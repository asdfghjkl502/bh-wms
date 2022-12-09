package io.ukoko.bhwms.mapper;

import io.ukoko.bhwms.entity.RecordIn;
import org.apache.ibatis.annotations.Mapper;

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
}
