package io.ukoko.bhwms.service;

import io.ukoko.bhwms.entity.RecordStock;

/**
 * 库存模块的业务逻辑层
 */
public interface RecordStockService {

    /**
     * 入库
     */
    void inRecordStock(RecordStock recordStock);

    /**
     * 出库
     */
    void outRecordStock(RecordStock recordStock);

    /**
     * 通过仓库ID和产品ID查询存库
     */
    RecordStock getRecordStockByRepoIdAndProductId(Integer repoId,Integer productId);
}
