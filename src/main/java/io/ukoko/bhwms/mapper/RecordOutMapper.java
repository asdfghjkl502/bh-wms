package io.ukoko.bhwms.mapper;

import io.ukoko.bhwms.entity.RecordIn;
import io.ukoko.bhwms.entity.RecordOut;
import org.apache.ibatis.annotations.Mapper;

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

}
