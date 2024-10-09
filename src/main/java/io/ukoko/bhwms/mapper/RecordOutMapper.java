package io.ukoko.bhwms.mapper;

import io.ukoko.bhwms.entity.RecordOut;
import io.ukoko.bhwms.entity.Statistics;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
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
    /**
     * 根据时间段统计每一种出库商品的数量
     */
    List<Statistics> getStatisticsOutByTime(@Param("startTime") Date startTime, @Param("endTime") Date endTime);

    /**
     * 当天出库量
     */
    Integer getPurchaseQuantityForToday();
}
