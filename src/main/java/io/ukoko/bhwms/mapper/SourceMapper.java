package io.ukoko.bhwms.mapper;

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
     * 获取级别列表
     * @return
     */
    List<Source> getSourceList();
}
