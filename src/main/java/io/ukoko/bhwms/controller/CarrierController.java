package io.ukoko.bhwms.controller;

import io.swagger.annotations.Api;
import io.ukoko.bhwms.dto.Page;
import io.ukoko.bhwms.dto.Result;
import io.ukoko.bhwms.entity.Carrier;
import io.ukoko.bhwms.service.CarrierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "承运商模块")
@CrossOrigin
@RestController
public class CarrierController {
    @Autowired
    private CarrierService carrierService;

    /**
     * 承运商分页查询
     * @param offset
     * @param limit
     * @return
     */
    @GetMapping(value = "/getCarrierPage")
    public Object getCarrierPage(int offset,int limit,String carrierName){
        Page page = carrierService.getCarrierPage(offset, limit, carrierName);
        return new Result(page);
    }

    /**
     * 添加承运商
     * @param carrier
     * @return
     */
    @PostMapping(value = "/addCarrier")
    public Object addCarrier(Carrier carrier){
        carrierService.addCarrier(carrier);
        return new Result();
    }
}
