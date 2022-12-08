package io.ukoko.bhwms.mapper;

import io.ukoko.bhwms.entity.RecordStock;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 操作数据库库存记录表(record_stock)的接口类
 */
@Mapper
public interface RecordStockMapper {

    /**
     * 添加库存记录
     * @param recordStock
     */
    void addRecordStock(RecordStock recordStock);

    /**
     * 入库
     * @param recordStock
     */
    void inRecordStock(RecordStock recordStock);

    /**
     * 出库
     * @param recordStock
     */
    void outRecordStock(RecordStock recordStock);

    /**
     * 查询库存
     * @param productId: 产品ID
     * @param repoId: 仓库ID
     * @return
     */
    List<RecordStock> getRecordStockList(@Param("productId") Integer productId,@Param("repoId") Integer repoId);

}
