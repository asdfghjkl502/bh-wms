package io.ukoko.bhwms.service;

import io.ukoko.bhwms.dto.Page;
import io.ukoko.bhwms.entity.Carrier;

import java.util.List;


/**
 * 承运商管理模块的业务逻辑层
 */
public interface CarrierService {
    /**
     * 添加承运商
     */
    void addCarrier(Carrier carrier);

    /**
     * 获取承运商分页
     */
    Page getCarrierPage(int pageNo,int pageSize,String carrierName,String carrierLeader,String carrierTel);

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
