package io.ukoko.bhwms.service;

import io.ukoko.bhwms.dto.Page;
import io.ukoko.bhwms.entity.Industry;

/**
 * 行业管理模块的业务逻辑层
 */
public interface IndustryService {
    /**
     * 添加行业
     * @param industry
     */
    void addIndustry(Industry industry);

    /**
     * 获取行业分页
     * @param offset
     * @param limit
     * @return
     */
    Page getIndustryPage(int offset, int limit);
}
