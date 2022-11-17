package io.ukoko.bhwms.service;

import io.ukoko.bhwms.dto.Page;
import io.ukoko.bhwms.entity.Repository;

import java.util.Date;
import java.util.List;

public interface RepositoryService {
    /**
     * 添加仓库
     * @param repository
     */
    void addRepository(Repository repository);

    /**
     * 删除仓库
     * @param repoId
     */
    void deleteRepository(Integer repoId);

    /**
     * 批量删除
     * @param repoIds
     */
    void batchDeleteRepository(List<Integer> repoIds);

    /**
     * 更新仓库
     * @param repository
     */
    void updateRepository(Repository repository);

    /**
     * 获取仓库列表
     * @param repoAddress
     * @param startTime
     * @param endTime
     * @return
     */
    Page getRepositoryPage(Integer pageNo,Integer pageSize,String repoAddress, Date startTime, Date endTime);

}
