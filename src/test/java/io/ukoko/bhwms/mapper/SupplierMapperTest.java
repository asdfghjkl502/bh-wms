package io.ukoko.bhwms.mapper;

import io.ukoko.bhwms.BhWmsApplicationTests;
import io.ukoko.bhwms.entity.Supplier;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;


class SupplierMapperTest extends BhWmsApplicationTests {

    @Autowired
    private SupplierMapper supplierMapper;

    @Test
    void addSupplier() {
        for (int i = 0; i < 100; i++) {
            Supplier supplier = new Supplier();
            supplier.setSupplierName("测试供应商名称"+i);
            supplier.setSupplierEmail("测试供应商邮箱"+i);
            supplier.setSupplierAddress("测试供应商地址"+i);
            supplier.setSupplierLeader("测试供应商负责人"+i);
            supplier.setSupplierTel("测试供应商联系电话"+i);
            supplier.setCreateTime(new Date());
            supplier.setIsDelete(i%2==0?1:0);
            supplierMapper.addSupplier(supplier);
        }
    }

    @Test
    void getSupplierList() {
        supplierMapper.getSupplierList("0").forEach(System.out::println);
    }
}