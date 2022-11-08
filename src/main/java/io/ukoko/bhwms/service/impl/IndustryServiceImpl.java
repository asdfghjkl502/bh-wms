package io.ukoko.bhwms.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import io.ukoko.bhwms.dto.Page;
import io.ukoko.bhwms.entity.Industry;
import io.ukoko.bhwms.entity.Level;
import io.ukoko.bhwms.mapper.IndustryMapper;
import io.ukoko.bhwms.service.IndustryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class IndustryServiceImpl implements IndustryService {
    @Autowired
    private IndustryMapper industryMapper;

    @Override
    public void addIndustry(Industry industry) {
        industryMapper.addIndustry(industry);
    }

    @Override
    public Page getIndustryPage(int pageNo, int pageSize) {
        Page page = new Page();
        PageHelper.startPage(pageNo,pageSize);
        List<Industry> industryList = industryMapper.getIndustryList();
        PageInfo<Industry> info = new PageInfo<>(industryList);
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
    public void updateIndustry(Industry industry) {
        industryMapper.updateIndustry(industry);
    }

    @Override
    public void deleteIndustryByIndustryId(Integer industryId) {
        industryMapper.deleteIndustry(industryId);
    }

    @Override
    public void batchDeleteIndustryByIndustryId(List<Integer> industryIds) {
        industryMapper.batchDeleteIndustry(industryIds);
    }
}
