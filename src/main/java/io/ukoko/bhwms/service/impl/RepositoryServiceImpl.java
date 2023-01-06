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

    @Override
    public List<Repository> getRepositoryList(String repoName) {
        List<Repository> repositoryList = repositoryMapper.getRepositoryList(null, null, null, repoName);
        return repositoryList;
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
