package io.ukoko.bhwms.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import io.ukoko.bhwms.dto.Page;
import io.ukoko.bhwms.entity.Carrier;
import io.ukoko.bhwms.entity.Supplier;
import io.ukoko.bhwms.mapper.SupplierMapper;
import io.ukoko.bhwms.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class SupplierServiceImpl implements SupplierService {

    @Autowired
    private SupplierMapper supplierMapper;

    @Override
    public void addSupplier(Supplier supplier) {
        supplierMapper.addSupplier(supplier);
    }

    @Override
    public Page getSupplierPage(int pageNo, int pageSize, String supplierName, String supplierLeader, String supplierTel) {
        Page page = new Page();
        PageHelper.startPage(pageNo,pageSize);
        List<Supplier> supplierList = supplierMapper.getSupplierList(supplierName,supplierLeader,supplierTel);
        PageInfo<Supplier> info = new PageInfo<>(supplierList);
        page.setPageNo(info.getPageNum());
        page.setPageSize(info.getPageSize());
        page.setPageCount(info.getPages());
        page.setCount(info.getTotal());
        page.setHasPre(info.isHasPreviousPage());
        page.setHasNext(info.isHasNextPage());
        page.setData(info.getList());
        return page;
    }

    @Override
    public void updateSupplier(Supplier supplier) {
        supplierMapper.updateSupplier(supplier);
    }

    @Override
    public void batchDeleteSupplier(List<Integer> supplierIds) {
        supplierMapper.batchDeleteSupplier(supplierIds);
    }

    @Override
    public void deleteSupplier(Integer supplierId) {
        supplierMapper.deleteSupplier(supplierId);
    }


}
