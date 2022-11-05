package io.ukoko.bhwms.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import io.ukoko.bhwms.dto.Page;
import io.ukoko.bhwms.entity.Level;
import io.ukoko.bhwms.entity.Source;
import io.ukoko.bhwms.mapper.SourceMapper;
import io.ukoko.bhwms.service.SourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class SourceServiceImpl implements SourceService {
    @Autowired
    private SourceMapper sourceMapper;

    @Override
    public void addSource(Source source) {
        sourceMapper.addSource(source);
    }

    @Override
    public Page getSourcePage(int pageNo, int pageSize) {
        Page page = new Page();
        PageHelper.startPage(pageNo,pageSize);
        List<Source> sourceList = sourceMapper.getSourceList();
        PageInfo<Source> info = new PageInfo<>(sourceList);
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
