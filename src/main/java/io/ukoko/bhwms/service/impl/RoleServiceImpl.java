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

import java.util.List;

/**
 * 角色模块功能实现类
 */
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
        return roleMapper.getRoleBy(roleId);
    }

    @Override
    public Page getRolePage(int pageNo, int pageSize, int isDelete) {
        Page page = new Page();
        PageHelper.startPage(pageNo,pageSize);
        List<Role> roleList = roleMapper.getRoleList(isDelete);
        PageInfo<Role> pageInfo = new PageInfo<>(roleList);

        page.setPageNo(pageNo);
        page.setPageSize(pageSize);
        page.setHasPre(pageInfo.isHasPreviousPage());
        page.setHasNext(pageInfo.isHasNextPage());
        page.setCount(pageInfo.getTotal());
        page.setPageCount(pageInfo.getPages());
        page.setData(pageInfo.getList());

        return page;
    }

    @Override
    public Page getRolePageFor(int limit, int offset, int isDelete) {
        Page page = new Page();
        PageHelper.offsetPage(offset,limit);
        List<Role> roleList = roleMapper.getRoleList(isDelete);
        System.out.println(roleList.size());
        PageInfo<Role> pageInfo = new PageInfo<>(roleList);
        page.setHasPre(pageInfo.isHasPreviousPage());
        page.setHasNext(pageInfo.isHasNextPage());
        page.setCount(pageInfo.getTotal());
        page.setPageCount(pageInfo.getPages());
        page.setData(pageInfo.getList());
        System.out.println(page);
        return page;
    }

    @Override
    public List<Role> getRolesBy(Integer isDelete) {
        return roleMapper.getRoleList(isDelete);
    }


}
