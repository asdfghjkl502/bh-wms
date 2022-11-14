package io.ukoko.bhwms.service;

import io.ukoko.bhwms.dto.Page;
import io.ukoko.bhwms.entity.Level;
import io.ukoko.bhwms.entity.Source;

import java.util.List;

/**
 * 来源管理模块的业务逻辑层
 */
public interface SourceService {
    /**
     * 添加来源
     * @param source
     */
    void addSource(Source source);

    /**
     * 获取级别分页
     * @param pageNo
     * @param pageSize
     * @return
     */
    Page getSourcePage(int pageNo, int pageSize);

    /**
     * 来源列表
     * @return
     */
    List<Source> getSourceList();

    /**
     * 更新
     * @param source
     */
    void updateSource(Source source);

    /**
     * 根据ID删除
     * @param sourceId
     */
    void deleteSourceBySourceId(Integer sourceId);

    /**
     * 批量删除
     * @param sourceIds
     */
    void batchDeleteSourceBySourceId(List<Integer> sourceIds);
}
