package io.ukoko.bhwms.service;

import io.ukoko.bhwms.dto.Page;
import io.ukoko.bhwms.dto.RecordInOutDto;
import io.ukoko.bhwms.entity.RecordStock;

/**
 * 库存模块的业务逻辑层
 */
public interface RecordStockService {

    /**
     * 入库
     */
    void inRecordStock(RecordInOutDto recordStock);

    /**
     * 当天入库量
     */
    int getShipmentQuantityForToday();

    /**
     * 出库
     */
    void outRecordStock(RecordInOutDto recordStock);

    /**
     * 当天出库量
     */
    int getPurchaseQuantityForToday();

    /**
     * 通过仓库ID和产品ID查询存库
     */
    RecordStock getRecordStockByRepoIdAndProductId(Integer repoId,Integer productId);

    /**
     * 查询库存总量
     */
    int getRecordStockSum();

    /**
     * 预警产品(库存小于10的某个产品的总数)
     */
    Integer getProductCountWithLowStock();

    /**
     * 分页查询产品库存
     */
    Page getRecordStockPage(Integer pageNo,Integer pageSize,Integer repoId,Integer productId);

}
