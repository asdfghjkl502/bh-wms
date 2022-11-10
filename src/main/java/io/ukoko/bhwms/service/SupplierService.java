package io.ukoko.bhwms.service;

import io.ukoko.bhwms.dto.Page;
import io.ukoko.bhwms.entity.Supplier;


/**
 * 供应商管理模块的业务逻辑层
 */
public interface SupplierService {
    /**
     * 添加供应商
     */
    void addSupplier(Supplier supplier);

    /**
     * 获取供应商列表
     */
    Page getSupplierPage(int pageNo,int pageSize,String supplierName,String supplierLeader, String supplierTel);
}
