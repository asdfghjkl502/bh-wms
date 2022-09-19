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
     * @param offset
     * @param limit
     * @return
     */
    Page getCustomerPage(int offset, int limit,String customerName,String customerLeader,String customerTel,String customerEmail,String customerAddress,Integer isDelete,Date startTime,Date endTime);
}
