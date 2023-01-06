package io.ukoko.bhwms.mapper;

import io.ukoko.bhwms.entity.RecordIn;
import io.ukoko.bhwms.entity.Statistics;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
  * 操作数据库入库记录表(record_in)的接口类
  */
@Mapper
public interface RecordInMapper {

    /**
     * 插入记录
     * @param recordIn
     */
    void addRecordIn(RecordIn recordIn);

    /**
     * 统计12个月的入库量
     */
    List<Statistics> getStatisticsInMonth();
}
