package io.ukoko.bhwms.service;

import io.ukoko.bhwms.dto.Page;
import io.ukoko.bhwms.entity.Supplier;

import java.util.List;


/**
 * 供应商管理模块的业务逻辑层
 */
public interface SupplierService {
    /**
     * 添加供应商
     */
    void addSupplier(Supplier supplier);

    /**
     * 获取供应商分页
     */
    Page getSupplierPage(int pageNo,int pageSize,String supplierName,String supplierLeader, String supplierTel);

    /**
     * 获取供应商列表
     * @return
     */
    List<Supplier> getSupplierList();

    /**
     * 更新
     * @param supplier
     */
    void updateSupplier(Supplier supplier);

    /**
     * 批量删除
     * @param supplierIds
     */
    void batchDeleteSupplier(List<Integer> supplierIds);

    /**
     * 删除
     * @param supplierId
     */
    void deleteSupplier(Integer supplierId);
}
