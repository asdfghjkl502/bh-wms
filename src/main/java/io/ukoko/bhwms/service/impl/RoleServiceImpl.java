package io.ukoko.bhwms.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import io.ukoko.bhwms.dto.Page;
import io.ukoko.bhwms.entity.Role;
import io.ukoko.bhwms.mapper.RoleMapper;
import io.ukoko.bhwms.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Transactional
@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleMapper roleMapper;

    @Override
    public void addRole(Role role) {
        roleMapper.addRole(role);
    }

    @Override
    public void deleteRoleByRoleId(Integer roleId) {
        roleMapper.deleteRole(roleId);
    }

    @Override
    public void updateRole(Role role) {
        roleMapper.updateRole(role);
    }

    @Override
    public Role getRoleByRoleId(Integer roleId) {
        return roleMapper.getRoleByRoleId(roleId);
    }

    @Override
    public Page getRolePageFor(int limit, int offset, Integer isDelete, String roleName, Date startTime, Date endTime, Integer roleId) {
        PageHelper.offsetPage(offset,limit);
        List<Role> list = roleMapper.getRoleList(roleName, isDelete, roleId, startTime, endTime);
        PageInfo<Role> info = new PageInfo<>(list);
        Page page = new Page();
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
    public Page getRolePage(int pageSize, int pageNo, Integer isDelete, String roleName, Date startTime, Date endTime, Integer roleId) {
        PageHelper.startPage(pageNo,pageSize);
        List<Role> list = roleMapper.getRoleList(roleName, isDelete, roleId, startTime, endTime);
        PageInfo<Role> info = new PageInfo<>(list);
        Page page = new Page();
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
    public void batchDeleteRole(List<Integer> roleIds) {
        roleMapper.batchDeleteRole(roleIds);
    }
}
