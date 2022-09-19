package io.ukoko.bhwms.mapper;

import io.ukoko.bhwms.BhWmsApplicationTests;
import io.ukoko.bhwms.entity.Customer;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CustomerMapperTest extends BhWmsApplicationTests {

    @Autowired
    private CustomerMapper customerMapper;

    @Test
    void addCustomer() {

        for (int i = 0; i < 100; i++) {
            Customer customer = new Customer();
            customer.setCustomerName("客户名称"+i);
            customer.setCustomerTel("客户手机号"+i);
            customer.setCustomerLeader("客户负责人"+i);
            customer.setCustomerEmail("客户邮箱"+i);
            customer.setCustomerAddress("客户地址"+i);
            customer.setCreateTime(new Date());
            customer.setIsDelete(i%2==0?1:0);
            customer.setLevelId(i%2==0?i+1:2);
            customer.setSourceId(i%2==0?i+1:2);
            customer.setIndustryId(i%2==0?i+1:2);
            customerMapper.addCustomer(customer);
        }


    }

    @Test
    void getCustomerList() {
        List<Customer> list = customerMapper.getCustomerList("0", null, null, null, null, null, null, null);
        list.forEach(System.out::println);
    }
}