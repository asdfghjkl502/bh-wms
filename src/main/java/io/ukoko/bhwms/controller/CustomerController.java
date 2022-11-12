package io.ukoko.bhwms.controller;

import io.swagger.annotations.Api;
import io.ukoko.bhwms.dto.Page;
import io.ukoko.bhwms.dto.Result;
import io.ukoko.bhwms.entity.Customer;
import io.ukoko.bhwms.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@Api(tags = "客户模块")
@CrossOrigin
@RestController
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    /**
     * 添加客户
     * @param customer
     * @return
     */
    @PostMapping(value = "/addCustomer")
    public Object addCustomer(@RequestBody Customer customer){
        customerService.addCustomer(customer);
        return new Result();
    }

    /**
     * 获取分页信息
     * @param pageNo
     * @param pageSize
     * @param customerName
     * @param customerLeader
     * @param customerTel
     * @param customerEmail
     * @param customerAddress
     * @param startTime
     * @param endTime
     * @return
     */
    @GetMapping(value = "/getCustomerPage")
    public Object getCustomerPage(int pageNo, int pageSize,String customerName,String customerLeader,String customerTel,String customerEmail,String customerAddress,Date startTime,Date endTime){
        Page page = customerService.getCustomerPage(pageNo, pageSize, customerName, customerLeader, customerTel, customerEmail, customerAddress, startTime, endTime);
        return new Result(page);
    }

    /**
     * 更新客户
     * @param customer
     * @return
     */
    @PostMapping(value = "/updateCustomer")
    public Object updateCustomer(@RequestBody Customer customer){
        customerService.updateCustomer(customer);
        return new Result();
    }

    /**
     * 删除
     * @param customerId
     * @return
     */
    @PostMapping(value = "/deleteCustomer")
    public Object deleteCustomer(Integer customerId){
        customerService.deleteCustomer(customerId);
        return new Result();
    }

    /**
     * 批量删除
     * @param customerIds
     * @return
     */
    @PostMapping(value = "/batchDeleteCustomer")
    public Object batchDeleteCustomer(@RequestBody List<Integer> customerIds){
        customerService.batchDeleteCustomer(customerIds);
        return new Result();
    }
}
