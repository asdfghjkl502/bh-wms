package io.ukoko.bhwms.mapper;

import io.ukoko.bhwms.entity.Industry;
import io.ukoko.bhwms.entity.Level;
import io.ukoko.bhwms.entity.Source;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 操作数据库行业表(industry)的接口类
 */
@Mapper
public interface IndustryMapper {
    /**
     * 添加行业
     * @param industry
     */
    void addIndustry(Industry industry);

    /**
     * 获取行业列表
     * @return
     */
    List<Industry> getIndustryList();

    /**
     * 根据来源ID查询来源信息
     */
    Industry getIndustry(Integer industryId);

    /**
     * 更新
     * @param industry
     */
    void updateIndustry(Industry industry);

    /**
     * 批量删除
     */
    void batchDeleteIndustry(List<Integer> industryIds);

    /**
     * 通过ID删除
     */
    void deleteIndustry(Integer industryId);
}
