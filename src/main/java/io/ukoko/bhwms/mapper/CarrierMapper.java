package io.ukoko.bhwms.mapper;

import io.ukoko.bhwms.entity.Carrier;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 操作数据库承运商表(carrier)的接口类
 */
@Mapper
public interface CarrierMapper {

    /**
     * 添加承运商
     */
    void addCarrier(Carrier carrier);

    /**
     * 获取承运商列表
     */
    List<Carrier> getCarrierList(String carrierName);
}
