package io.ukoko.bhwms.service;

import io.ukoko.bhwms.dto.Page;
import io.ukoko.bhwms.entity.Customer;

import java.util.Date;
import java.util.List;

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

    /**
     * 根据条件查询客户列表
     * @param customerName
     * @param customerLeader
     * @param customerTel
     * @param customerEmail
     * @param customerAddress
     * @return
     */
    List<Customer> getCustomerList(String customerName,String customerLeader,String customerTel,String customerEmail,String customerAddress);

    /**
     * 查询所有列表
     */
    List<Customer> getCustomerAll();


    /**
     * 更新
     * @param customer
     */
    void updateCustomer(Customer customer);

    /**
     * 通过客户ID删除客户信息
     * @param customerId
     */
    void deleteCustomer(Integer customerId);

    /**
     * 批量删除
     * @param customerIds
     */
    void batchDeleteCustomer(List<Integer> customerIds);
}
