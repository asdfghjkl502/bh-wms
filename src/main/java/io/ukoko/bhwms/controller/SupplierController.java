package io.ukoko.bhwms.controller;

import io.swagger.annotations.Api;
import io.ukoko.bhwms.dto.Page;
import io.ukoko.bhwms.dto.Result;
import io.ukoko.bhwms.entity.Carrier;
import io.ukoko.bhwms.entity.Supplier;
import io.ukoko.bhwms.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "供应商模块")
@CrossOrigin
@RestController
public class SupplierController {

    @Autowired
    private SupplierService supplierService;

    /**
     * 供应商分页查询
     * @param offset
     * @param limit
     * @return
     */
    @GetMapping(value = "/getSupplierPage")
    public Object getSupplierPage(int offset,int limit,String supplierName){
        Page page = supplierService.getSupplierPage(offset,limit,supplierName);
        return new Result(page);
    }

    /**
     * 添加供应商
     * @param supplier
     * @return
     */
    @PostMapping(value = "/addSupplier")
    public Object addSupplier(Supplier supplier){
        supplierService.addSupplier(supplier);
        return new Result();
    }

}
