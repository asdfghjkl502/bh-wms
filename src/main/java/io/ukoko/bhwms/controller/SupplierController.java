package io.ukoko.bhwms.controller;

import io.swagger.annotations.Api;
import io.ukoko.bhwms.dto.Page;
import io.ukoko.bhwms.dto.Result;
import io.ukoko.bhwms.entity.Carrier;
import io.ukoko.bhwms.entity.Supplier;
import io.ukoko.bhwms.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "供应商模块")
@CrossOrigin
@RestController
public class SupplierController {

    @Autowired
    private SupplierService supplierService;

    /**
     * 供应商分页查询t
     * @param pageNo
     * @param pageSize
     * @param supplierName
     * @param supplierLeader
     * @param supplierTel
     * @return
     */
    @GetMapping(value = "/getSupplierPage")
    public Object getSupplierPage(int pageNo,int pageSize,String supplierName,String supplierLeader,String supplierTel){
        Page page = supplierService.getSupplierPage(pageNo,pageSize,supplierName,supplierLeader,supplierTel);
        return new Result(page);
    }

    /**
     * 添加供应商
     * @param supplier
     * @return
     */
    @PostMapping(value = "/addSupplier")
    public Object addSupplier(@RequestBody Supplier supplier){
        supplierService.addSupplier(supplier);
        return new Result();
    }

    /**
     * 更新供应商
     * @param supplier
     * @return
     */
    @PostMapping(value = "/updateSupplier")
    public Object updateSupplier(@RequestBody Supplier supplier){
        supplierService.updateSupplier(supplier);
        return new Result();
    }

    /**
     * 删除
     * @param supplierId
     * @return
     */
    @PostMapping(value = "/deleteSupplier")
    public Object deleteSupplier(Integer supplierId){
        supplierService.deleteSupplier(supplierId);
        return new Result();
    }

    /**
     * 批量删除
     * @param supplierIds
     * @return
     */
    @PostMapping(value = "/batchDeleteSupplier")
    public Object batchDeleteSupplier(@RequestBody List<Integer> supplierIds){
        supplierService.batchDeleteSupplier(supplierIds);
        return new Result();
    }
}
