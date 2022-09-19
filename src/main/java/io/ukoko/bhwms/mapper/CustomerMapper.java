package io.ukoko.bhwms.mapper;

import io.ukoko.bhwms.entity.Customer;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

/**
 * 操作数据库客户表(customer)的接口类
 */
@Mapper
public interface CustomerMapper {

    /**
     * 添加客户
     * @param customer
     */
    void addCustomer(Customer customer);

    /**
     * 获取客户列表
     * @param customerName: 客户名称
     * @param customerLeader: 客户管理者
     * @param customerTel: 客户联系电话
     * @param customerEmail: 客户联系邮箱
     * @param customerAddress: 客户联系地址
     * @param isDelete: 是否有效
     * @param startTime: 开始时间
     * @param endTime: 结束时间
     * @return
     */
    List<Customer> getCustomerList(@Param("customerName") String customerName,@Param("customerLeader") String customerLeader,@Param("customerTel") String customerTel, @Param("customerEmail") String customerEmail,@Param("customerAddress") String customerAddress,@Param("isDelete") Integer isDelete,@Param("startTime") Date startTime,@Param("endTime") Date endTime);
}
