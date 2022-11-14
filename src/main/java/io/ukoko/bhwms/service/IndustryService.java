package io.ukoko.bhwms.service;

import io.ukoko.bhwms.dto.Page;
import io.ukoko.bhwms.entity.Industry;

import java.util.List;

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
     * @param pageNo
     * @param pageSize
     * @return
     */
    Page getIndustryPage(int pageNo, int pageSize);

    /**
     * 行业列表
     * @return
     */
    List<Industry> getIndustryList();

    /**
     * 更新
     * @param industry
     */
    void updateIndustry(Industry industry);

    /**
     * 根据ID删除
     * @param industryId
     */
    void deleteIndustryByIndustryId(Integer industryId);

    /**
     * 批量删除
     * @param industryIds
     */
    void batchDeleteIndustryByIndustryId(List<Integer> industryIds);
}
