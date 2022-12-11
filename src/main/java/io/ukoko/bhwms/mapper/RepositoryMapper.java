package io.ukoko.bhwms.mapper;

import io.ukoko.bhwms.entity.Repository;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

/**
 * 操作数据库仓库表(repository)的接口类
 */
@Mapper
public interface RepositoryMapper {

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
    List<Repository> getRepositoryList(@Param("repoAddress") String repoAddress,@Param("startTime") Date startTime,@Param("endTime") Date endTime,@Param("repoName") String repoName);

    /**
     * 通过仓库ID查询仓库
     * @param repoId
     * @return
     */
    Repository getRepositoryByRepoId(Integer repoId);

}
