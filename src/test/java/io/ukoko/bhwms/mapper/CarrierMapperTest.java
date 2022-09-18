package io.ukoko.bhwms.mapper;

import io.ukoko.bhwms.BhWmsApplicationTests;
import io.ukoko.bhwms.entity.Carrier;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class CarrierMapperTest extends BhWmsApplicationTests {

    @Autowired
    private CarrierMapper carrierMapper;

    @Test
    void addCarrier() {

        for (int i = 0; i < 100; i++) {
            Carrier carrier = new Carrier();
            carrier.setCarrierName("承运商名称"+i);
            carrier.setCarrierEmail("承运商邮箱"+i+"@163.com");
            carrier.setCarrierAddress("承运商地址"+i);
            carrier.setCarrierLeader("承运商负责人"+i);
            carrier.setCarrierTel("承运商联系电话"+i);
            carrier.setCreateTime(new Date());
            carrier.setIsDelete(i%2==0?1:0);

            carrierMapper.addCarrier(carrier);
        }

    }

    @Test
    void getCarrierList() {
    }
}