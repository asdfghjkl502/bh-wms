package io.ukoko.bhwms.service.impl;

import io.ukoko.bhwms.entity.RecordStock;
import io.ukoko.bhwms.service.RecordStockService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class RecordStockServiceImpl implements RecordStockService {
    /**
     * 入库
     * @param recordStock
     */
    @Override
    public void inRecordStock(RecordStock recordStock) {

    }

    /**
     * 出库
     * @param recordStock
     */
    @Override
    public void outRecordStock(RecordStock recordStock) {

    }
}
