package io.ukoko.bhwms.controller;

import io.swagger.annotations.Api;
import io.ukoko.bhwms.dto.Page;
import io.ukoko.bhwms.dto.ProductVo;
import io.ukoko.bhwms.dto.RecordInOutDto;
import io.ukoko.bhwms.dto.Result;
import io.ukoko.bhwms.entity.RecordStock;
import io.ukoko.bhwms.service.RecordStockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Api(tags = "库存模块")
@CrossOrigin
@RestController
public class RecordStockController {

    @Autowired
    private RecordStockService recordStockService;

    /**
     * 入库操作
     */
    @PostMapping(value = "/inRecordStock")
    public Object inRecordStock(@RequestBody RecordInOutDto recordInOutDto){
        recordStockService.inRecordStock(recordInOutDto);
        RecordStock rs = recordStockService.getRecordStockByRepoIdAndProductId(recordInOutDto.getRepoId(), recordInOutDto.getProductId());
        return new Result(rs);
    }

    /**
     * 当天入库
     */
    @GetMapping(value = "/getShipmentQuantityForToday")
    public Object getShipmentQuantityForToday(){
        int gSQFToday=recordStockService.getShipmentQuantityForToday();
        return new Result(gSQFToday);
    }

    /**
     * 出库操作
     */
    @PostMapping(value = "/outRecordStock")
    public Object outRecordStock(@RequestBody RecordInOutDto recordInOutDto){
        recordStockService.outRecordStock(recordInOutDto);
        RecordStock rs = recordStockService.getRecordStockByRepoIdAndProductId(recordInOutDto.getRepoId(), recordInOutDto.getProductId());
        return new Result(rs);
    }

    /**
     * 当天出库
     */
    @GetMapping(value = "getPurchaseQuantityForToday")
    public Object getPurchaseQuantityForToday(){
        int gPQFToday=recordStockService.getPurchaseQuantityForToday();
        return new Result(gPQFToday);
    }

    /**
     * 查询库存总量
     */
    @GetMapping(value = "/recordStockSum")
    public Object getRecordStockSum(){
        int gRSSum=recordStockService.getRecordStockSum();
        return new Result(gRSSum);
    }

    /**
     * 预警产品(库存小于10的某个产品的总数)
     */
    @GetMapping(value = "productCountWithLowStock")
    public Object getProductCountWithLowStock(){
        int gPCWLow=recordStockService.getProductCountWithLowStock();
        return new Result(gPCWLow);
    }

    /**
     * 分页获取库存列表
     */
    @GetMapping(value = "/getRecordStockPage")
    public Object getRecordStockPage(Integer pageNo,Integer pageSize,Integer repoId,Integer productId){
        Page page = recordStockService.getRecordStockPage(pageNo, pageSize, repoId, productId);
        return new Result(page);
    }
}
