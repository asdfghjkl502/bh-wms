package io.ukoko.bhwms.controller;

import io.swagger.annotations.Api;
import io.ukoko.bhwms.dto.Page;
import io.ukoko.bhwms.dto.Result;
import io.ukoko.bhwms.entity.Carrier;
import io.ukoko.bhwms.service.CarrierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "承运商模块")
@CrossOrigin
@RestController
public class CarrierController {
    @Autowired
    private CarrierService carrierService;

    /**
     * 承运商分页查询
     * @return
     */
    @GetMapping(value = "/getCarrierPage")
    public Object getCarrierPage(int pageNo,int pageSize,String carrierName,String carrierLeader,String carrierTel){
        Page page = carrierService.getCarrierPage(pageNo,pageSize,carrierName,carrierLeader,carrierTel);
        return new Result(page);
    }

    /**
     * 添加承运商
     * @param carrier
     * @return
     */
    @PostMapping(value = "/addCarrier")
    public Object addCarrier(@RequestBody Carrier carrier){
        carrierService.addCarrier(carrier);
        return new Result();
    }

    /**
     * 更新承运商
     * @param carrier
     * @return
     */
    @PostMapping(value = "/updateCarrier")
    public Object updateCarrier(@RequestBody Carrier carrier){
        carrierService.updateCarrier(carrier);
        System.out.println(carrier);
        return new Result();
    }

    /**
     * 删除承运商
     * @param carrierId
     * @return
     */
    @PostMapping(value = "/deleteCarrier")
    public Object deleteCarrier(Integer carrierId){
        carrierService.deleteCarrier(carrierId);
        return new Result();
    }

    /**
     * 批量删除
     * @param carrierIds
     * @return
     */
    @PostMapping(value = "/batchDeleteCarrier")
    public Object batchDeleteCarrier(@RequestBody List<Integer> carrierIds){
        carrierService.batchDeleteCarrier(carrierIds);
        return new Result();
    }
}
