package io.ukoko.bhwms.controller;

import io.swagger.annotations.Api;
import io.ukoko.bhwms.dto.Page;
import io.ukoko.bhwms.dto.Result;
import io.ukoko.bhwms.entity.Customer;
import io.ukoko.bhwms.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

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
    public Object addCustomer(Customer customer){
        customerService.addCustomer(customer);
        return new Result();
    }

    /**
     * 获取分页信息
     * @param offset
     * @param limit
     * @param customerName
     * @param customerLeader
     * @param customerTel
     * @param customerEmail
     * @param customerAddress
     * @param isDelete
     * @param startTime
     * @param endTime
     * @return
     */
    @GetMapping(value = "/getCustomerPage")
    public Object getCustomerPage(int offset, int limit,String customerName,String customerLeader,String customerTel,String customerEmail,String customerAddress,Integer isDelete,Date startTime,Date endTime){
        Page page = customerService.getCustomerPage(offset, limit, customerName, customerLeader, customerTel, customerEmail, customerAddress, isDelete, startTime, endTime);
        return new Result(page);
    }
}
