package io.ukoko.bhwms.service.impl;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import io.ukoko.bhwms.dto.Page;
import io.ukoko.bhwms.entity.Carrier;
import io.ukoko.bhwms.entity.Industry;
import io.ukoko.bhwms.mapper.CarrierMapper;
import io.ukoko.bhwms.service.CarrierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CarrierServiceImpl implements CarrierService {
    @Autowired
    private CarrierMapper carrierMapper;

    @Override
    public void addCarrier(Carrier carrier) {
        carrierMapper.addCarrier(carrier);
    }

    @Override
    public Page getCarrierPage(int offset, int limit,String carrierName) {
        Page page = new Page();
        PageHelper.offsetPage(offset,limit);
        List<Carrier> carrierList = carrierMapper.getCarrierList(carrierName);
        PageInfo<Carrier> info = new PageInfo<>(carrierList);
        page.setPageNo(info.getPageNum());
        page.setPageSize(info.getPageSize());
        page.setPageCount(info.getPages());
        page.setCount(info.getTotal());
        page.setHasPre(info.isHasPreviousPage());
        page.setHasNext(info.isHasNextPage());
        page.setData(info.getList());
        return page;
    }
}
