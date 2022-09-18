package io.ukoko.bhwms.service;

import io.ukoko.bhwms.dto.Page;
import io.ukoko.bhwms.entity.Source;

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
     * @param offset
     * @param limit
     * @return
     */
    Page getSourcePage(int offset, int limit);
}
