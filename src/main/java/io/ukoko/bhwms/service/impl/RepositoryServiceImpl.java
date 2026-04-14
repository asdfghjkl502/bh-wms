package io.ukoko.bhwms.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import io.ukoko.bhwms.dto.Page;
import io.ukoko.bhwms.entity.RecordStock;
import io.ukoko.bhwms.entity.Repository;
import io.ukoko.bhwms.entity.Role;
import io.ukoko.bhwms.entity.Statistics;
import io.ukoko.bhwms.mapper.RecordStockMapper;
import io.ukoko.bhwms.mapper.RepositoryMapper;
import io.ukoko.bhwms.service.RepositoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static java.lang.Integer.parseInt;

@Transactional
@Service
public class RepositoryServiceImpl implements RepositoryService {

    @Autowired
    private RepositoryMapper repositoryMapper;
    @Autowired
    private RecordStockMapper recordStockMapper;

    @Override
    public void addRepository(Repository repository) {
        repositoryMapper.addRepository(repository);
    }

    @Override
    public void deleteRepository(Integer repoId) {
        repositoryMapper.deleteRepository(repoId);
    }

    @Override
    public void batchDeleteRepository(List<Integer> repoIds) {
        repositoryMapper.batchDeleteRepository(repoIds);
    }

    @Override
    public void updateRepository(Repository repository) {
        repositoryMapper.updateRepository(repository);
    }

    @Override
    public Page getRepositoryPage(Integer pageNo, Integer pageSize, String repoAddress, Date startTime, Date endTime,String repoName) {
        PageHelper.startPage(pageNo,pageSize);
        List<Repository> list = repositoryMapper.getRepositoryList(repoAddress, startTime, endTime,repoName);
        // 计算每个仓库的剩余面积
        for (Repository repository : list) {
            int remaining = calculateRemainingArea(repository);
            repository.setRemainingArea(remaining);
        }
        PageInfo<Repository> info = new PageInfo<>(list);
        Page page = new Page();
        page.setPageNo(info.getPageNum());
        page.setPageSize(info.getPageSize());
        page.setPageCount(info.getPages());
        page.setCount(info.getTotal());
        page.setHasPre(info.isHasPreviousPage());
        page.setHasNext(info.isHasNextPage());
        page.setData(info.getList());
        return page;
    }

    /**
     * 计算仓库剩余面积
     * 剩余面积 = 仓库面积 - 已占用面积
     * 已占用面积 = SUM(每种产品的库存数量 * 产品单位面积)
     */
    private int calculateRemainingArea(Repository repository) {
        // 解析仓库面积
        int repoArea;
        String repoAreaStr = repository.getRepoArea();
        if (repoAreaStr != null && repoAreaStr.contains("*")) {
            String[] parts = repoAreaStr.split("\\*");
            if (parts.length >= 2) {
                repoArea = parseInt(parts[0].trim()) * parseInt(parts[1].trim());
            } else {
                repoArea = parseInt(repoAreaStr.trim());
            }
        } else {
            repoArea = parseInt(repoAreaStr.trim());
        }

        // 获取该仓库下所有产品库存
        List<RecordStock> recordStocks = recordStockMapper.getRecordStockList(null, repository.getRepoId());

        // 计算已占用面积
        int usedArea = 0;
        for (RecordStock recordStock : recordStocks) {
            if (recordStock.getProduct() != null && recordStock.getProduct().getProductSize() != null) {
                String productSizeStr = recordStock.getProduct().getProductSize();
                int productSize;
                if (productSizeStr.contains("*")) {
                    String[] parts = productSizeStr.split("\\*");
                    if (parts.length >= 2) {
                        productSize = parseInt(parts[0].trim()) * parseInt(parts[1].trim());
                    } else {
                        productSize = parseInt(productSizeStr.trim());
                    }
                } else {
                    productSize = parseInt(productSizeStr.trim());
                }
                usedArea += productSize * recordStock.getProductStock();
            }
        }

        return repoArea - usedArea;
    }

    @Override
    public List<Repository> getRepositoryList(String repoName) {
        List<Repository> repositoryList = repositoryMapper.getRepositoryList(null, null, null, repoName);
        // 计算每个仓库的剩余面积
        for (Repository repository : repositoryList) {
            int remaining = calculateRemainingArea(repository);
            repository.setRemainingArea(remaining);
        }
        return repositoryList;
    }

    @Override
    public List<Repository> getRepositoryAll() {
        List<Repository> repositories = repositoryMapper.getRepositoryAll();
        // 计算每个仓库的剩余面积
        for (Repository repository : repositories) {
            int remaining = calculateRemainingArea(repository);
            repository.setRemainingArea(remaining);
        }
        return repositories;
    }

    @Override
    public List<Statistics> getRepositoryPayloadStatistics() {
        List<Statistics> statistics = new ArrayList<>();
        //获取所有仓库
        List<Repository> repositories = repositoryMapper.getRepositoryList(null, null, null, null);
        //查询每一个仓库中的产品库存总数
        for (Repository repository : repositories) {
            Statistics s = new Statistics();
            s.setCommon(repository.getRepoName());
            List<RecordStock> recordStocks = recordStockMapper.getRecordStockList(null, repository.getRepoId());
            //总库存
            Long stock=0L;
            for (RecordStock recordStock : recordStocks) {
                //当前仓库的总库存
                stock+=recordStock.getProductStock();
            }
            s.setCount(stock);
            statistics.add(s);
        }

        return statistics;
    }
}
