package io.ukoko.bhwms.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import io.ukoko.bhwms.dto.Page;
import io.ukoko.bhwms.entity.Permission;
import io.ukoko.bhwms.mapper.PermissionMapper;
import io.ukoko.bhwms.mapper.RolePermissionMapper;
import io.ukoko.bhwms.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Transactional
@Service
public class PermissionServiceImpl implements PermissionService {

    @Autowired
    private PermissionMapper permissionMapper;

    @Autowired
    private RolePermissionMapper rolePermissionMapper;

    @Override
    public void addPermission(Permission permission) {
        permissionMapper.addPermission(permission);
    }

    @Override
    public void deletePermission(Integer permissionId) {
        permissionMapper.deletePermission(permissionId);
    }

    @Override
    public void batchDeletePermission(List<Integer> permissionIds) {
        permissionMapper.batchDeletePermission(permissionIds);
    }

    @Override
    public void updatePermission(Permission permission) {
        permissionMapper.updatePermission(permission);
    }

    @Override
    public Page getPermissionPage(Integer pageNo, Integer pageSize, String permissionName, String permissionCode, Integer permissionType) {
        PageHelper.startPage(pageNo, pageSize);
        List<Permission> list = permissionMapper.getPermissionList(permissionName, permissionCode, permissionType);
        PageInfo<Permission> info = new PageInfo<>(list);
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
    public List<Permission> getPermissionAll() {
        return permissionMapper.getPermissionAll();
    }

    @Override
    public Permission getPermissionByPermissionId(Integer permissionId) {
        return permissionMapper.getPermissionByPermissionId(permissionId);
    }

    @Override
    public List<Permission> getPermissionByRoleId(Integer roleId) {
        return permissionMapper.getPermissionByRoleId(roleId);
    }

    @Override
    public void assignPermissions(Integer roleId, List<Integer> permissionIds) {
        // 先删除角色原有权限
        rolePermissionMapper.deleteByRoleId(roleId);
        // 分配新权限
        if (permissionIds != null && !permissionIds.isEmpty()) {
            rolePermissionMapper.assignPermissions(roleId, permissionIds);
        }
    }

    @Override
    public List<Permission> getMenuPermissionsByUserId(Integer userId) {
        return permissionMapper.getMenuPermissionsByUserId(userId);
    }

    @Override
    public List<String> getButtonPermissionsByUserId(Integer userId) {
        return permissionMapper.getButtonPermissionsByUserId(userId);
    }

    @Override
    public List<String> getApiPermissionsByUserId(Integer userId) {
        return permissionMapper.getApiPermissionsByUserId(userId);
    }

    @Override
    public List<Permission> getUserAllPermissions(Integer userId) {
        return permissionMapper.getMenuPermissionsByUserId(userId);
    }

    /**
     * 将权限列表转换为树形结构
     */
    public List<Permission> buildPermissionTree(List<Permission> permissions) {
        Map<Integer, Permission> map = new HashMap<>();
        List<Permission> roots = new ArrayList<>();

        // 先把所有权限放入map
        for (Permission p : permissions) {
            map.put(p.getPermissionId(), p);
        }

        // 构建树形结构
        for (Permission p : permissions) {
            if (p.getParentId() == null || p.getParentId() == 0) {
                roots.add(p);
            } else {
                Permission parent = map.get(p.getParentId());
                if (parent != null) {
                    if (parent.getChildren() == null) {
                        parent.setChildren(new ArrayList<>());
                    }
                    parent.getChildren().add(p);
                }
            }
        }

        return roots;
    }
}
