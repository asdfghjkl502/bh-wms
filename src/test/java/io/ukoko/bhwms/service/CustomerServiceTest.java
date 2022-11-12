package io.ukoko.bhwms.service;

import io.ukoko.bhwms.BhWmsApplicationTests;
import io.ukoko.bhwms.dto.Page;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;

class CustomerServiceTest extends BhWmsApplicationTests {

    @Autowired
    private CustomerService customerService;

    @Test
    void addCustomer() {
    }

    @Test
    void getCustomerPage() {
        Page page = customerService.getCustomerPage(1, 2, null, null, null, null, null, null, null);
        Object data = page.getData();
        System.out.println(data);
    }
}