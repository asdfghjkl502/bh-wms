package io.ukoko.bhwms.mapper;

import io.ukoko.bhwms.entity.Carrier;
import io.ukoko.bhwms.entity.Supplier;
import org.apache.ibatis.annotations.Mapper;

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
    List<Supplier> getSupplierList(String supplierName);

}
