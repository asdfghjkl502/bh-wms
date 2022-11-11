package io.ukoko.bhwms.mapper;

import io.ukoko.bhwms.entity.Carrier;
import io.ukoko.bhwms.entity.Supplier;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

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
    List<Carrier> getCarrierList(@Param("carrierName") String carrierName,@Param("carrierLeader") String carrierLeader,@Param("carrierTel") String carrierTel);

    /**
     * 更新
     */
    void updateCarrier(Carrier carrier);

    /**
     * 批量删除
     */
    void batchDeleteCarrier(List<Integer> carrierIds);

    /**
     * 删除
     */
    void deleteCarrier(Integer carrierId);
}
