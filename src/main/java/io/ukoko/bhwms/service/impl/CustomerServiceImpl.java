package io.ukoko.bhwms.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import io.ukoko.bhwms.dto.Page;
import io.ukoko.bhwms.entity.Customer;
import io.ukoko.bhwms.entity.Level;
import io.ukoko.bhwms.mapper.CustomerMapper;
import io.ukoko.bhwms.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Transactional
@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerMapper customerMapper;

    @Override
    public void addCustomer(Customer customer) {
        customerMapper.addCustomer(customer);
    }

    @Override
    public Page getCustomerPage(int pageNo, int pageSize, String customerName, String customerLeader, String customerTel, String customerEmail, String customerAddress, Date startTime, Date endTime) {
        Page page = new Page();
        PageHelper.startPage(pageNo,pageSize);
        List<Customer> customerList = customerMapper.getCustomerList(customerName, customerLeader, customerTel, customerEmail, customerAddress, startTime, endTime);
        PageInfo<Customer> info = new PageInfo<>(customerList);
        page.setPageNo(info.getPageNum());
        page.setPageSize(info.getPageSize());
        page.setPageCount(info.getPages());
        page.setCount(info.getTotal());
        page.setHasPre(info.isHasPreviousPage());
        page.setHasNext(info.isHasNextPage());
        page.setData(info.getList());
        return page;
    }

    @Override
    public List<Customer> getCustomerList(String customerName, String customerLeader, String customerTel, String customerEmail, String customerAddress) {
        return customerMapper.getCustomerList(customerName,customerLeader,customerTel,customerEmail,customerAddress,null,null);
    }

    @Override
    public List<Customer> getCustomerAll() {
        return customerMapper.getCustomerAll();
    }

    @Override
    public void updateCustomer(Customer customer) {
        customerMapper.updateCustomer(customer);
    }

    @Override
    public void deleteCustomer(Integer customerId) {
        customerMapper.deleteCustomer(customerId);
    }

    @Override
    public void batchDeleteCustomer(List<Integer> customerIds) {
        customerMapper.batchDeleteCustomer(customerIds);
    }

}
