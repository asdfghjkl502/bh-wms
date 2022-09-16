package io.ukoko.bhwms.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import io.ukoko.bhwms.dto.Page;
import io.ukoko.bhwms.entity.Department;
import io.ukoko.bhwms.mapper.DepartmentMapper;
import io.ukoko.bhwms.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentMapper departmentMapper;

    @Override
    public void addDepartment(Department department) {
        departmentMapper.addDepartment(department);
    }

    @Override
    public Page getDepartmentPage(int offset, int limit) {
        Page page = new Page();
        PageHelper.offsetPage(offset,limit);
        List<Department> list = departmentMapper.getDepartmentList();
        PageInfo<Department> info = new PageInfo<>(list);
        page.setPageNo(info.getPageNum());
        page.setPageSize(info.getPageSize());
        page.setPageCount(info.getPages());
        page.setCount(info.getTotal());
        page.setHasNext(info.isHasNextPage());
        page.setHasPre(info.isHasPreviousPage());
        page.setData(info.getList());
        return page;
    }
}
