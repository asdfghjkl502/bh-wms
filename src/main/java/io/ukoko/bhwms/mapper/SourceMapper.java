package io.ukoko.bhwms.mapper;

import io.ukoko.bhwms.entity.Level;
import io.ukoko.bhwms.entity.Source;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 操作数据库来源表(source)的接口类
 */
@Mapper
public interface SourceMapper {
    /**
     * 添加级别
     * @param source
     */
    void addSource(Source source);

    /**
     * 更新
     * @param source
     */
    void updateSource(Source source);

    /**
     * 获取级别列表
     * @return
     */
    List<Source> getSourceList();

    /**
     * 通过来源ID查询来源信息
     */
    Source getSource(Integer sourceId);


    /**
     * 批量删除
     */
    void batchDeleteSource(List<Integer> sourceIds);

    /**
     * 通过ID删除
     */
    void deleteSource(Integer sourceId);

}
