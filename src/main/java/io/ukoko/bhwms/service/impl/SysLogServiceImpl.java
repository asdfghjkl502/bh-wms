package io.ukoko.bhwms.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import io.ukoko.bhwms.dto.Page;
import io.ukoko.bhwms.entity.SysLog;
import io.ukoko.bhwms.mapper.SysLogMapper;
import io.ukoko.bhwms.service.SysLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Transactional
@Service
public class SysLogServiceImpl implements SysLogService {

    @Autowired
    private SysLogMapper sysLogMapper;

    @Override
    public void addSysLog(SysLog sysLog) {
        sysLogMapper.addSysLog(sysLog);
    }

    @Override
    public Page getSysLogPage(Integer pageNo, Integer pageSize, Integer type, String methodName, String method, String nickName, Date start, Date end) {
        Page page = new Page();
        PageHelper.startPage(pageNo,pageSize);
        List<SysLog> sysLogList = sysLogMapper.getSysLogList(type, methodName, method, nickName, start, end);
        PageInfo<SysLog> info = new PageInfo<>(sysLogList);
        page.setPageNo(info.getPageNum());
        page.setPageSize(info.getPageSize());
        page.setCount(info.getTotal());
        page.setHasNext(info.isHasNextPage());
        page.setHasPre(info.isHasPreviousPage());
        page.setPageCount(info.getPages());
        page.setData(info.getList());
        return page;
    }
}
