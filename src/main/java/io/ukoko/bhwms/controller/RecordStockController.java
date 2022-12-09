package io.ukoko.bhwms.controller;

import io.swagger.annotations.Api;
import io.ukoko.bhwms.dto.Result;
import io.ukoko.bhwms.entity.RecordStock;
import io.ukoko.bhwms.service.RecordStockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "产品出入库模块")
@CrossOrigin
@RestController
public class RecordStockController {

    @Autowired
    private RecordStockService recordStockService;

    /**
     * 入库操作
     */
    @PostMapping(value = "/inRecordStock")
    public Object inRecordStock(@RequestBody RecordStock recordStock){
        recordStockService.inRecordStock(recordStock);
        RecordStock rs = recordStockService.getRecordStockByRepoIdAndProductId(recordStock.getRepoId(), recordStock.getProductId());
        return new Result(rs);
    }
    /**
     * 出库操作
     */
    @PostMapping(value = "/outRecordStock")
    public Object outRecordStock(@RequestBody RecordStock recordStock){
        recordStockService.outRecordStock(recordStock);
        return new Result();
    }

}
