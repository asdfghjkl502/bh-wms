package io.ukoko.bhwms.service;

import io.ukoko.bhwms.dto.Page;
import io.ukoko.bhwms.entity.Customer;

import java.util.Date;

/**
 *  客户管理模块的业务逻辑层
 */
public interface CustomerService {
    /**
     * 添加
     * @param customer
     */
    void addCustomer(Customer customer);

    /**
     * 获取分页
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
    Page getCustomerPage(int pageNo, int pageSize,String customerName,String customerLeader,String customerTel,String customerEmail,String customerAddress,Date startTime,Date endTime);
}
