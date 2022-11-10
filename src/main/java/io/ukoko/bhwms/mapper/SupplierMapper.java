package io.ukoko.bhwms.mapper;

import io.ukoko.bhwms.entity.Supplier;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 操作数据库供应商表(supplier)的接口类
 */
@Mapper
public interface SupplierMapper {

    /**
     * 添加供应商
     */
    void addSupplier(Supplier supplier);

    /**
     * 获取供应商列表
     */
    List<Supplier> getSupplierList(@Param("supplierName") String supplierName,@Param("supplierLeader") String supplierLeader,@Param("supplierTel") String supplierTel);

    /*
        更新
     */
    void updateSupplier(Supplier supplier);

    /*
        批量删除
     */
    void batchDeleteSupplier(List<Integer> supplierIds);

    /*
        删除
     */
    void deleteSupplier(Integer supplierId);
}
