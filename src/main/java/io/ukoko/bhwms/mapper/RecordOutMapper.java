package io.ukoko.bhwms.mapper;

import io.ukoko.bhwms.entity.RecordIn;
import io.ukoko.bhwms.entity.RecordOut;
import io.ukoko.bhwms.entity.Statistics;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 操作数据库出库记录表(record_out)的接口类
 */
@Mapper
public interface RecordOutMapper {

    /**
     * 插入记录
     * @param recordOut
     */
    void addRecordOut(RecordOut recordOut);

    /**
     * 统计12个月的出库量
     */
    List<Statistics> getStatisticsOutMonth();
}
