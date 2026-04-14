package io.ukoko.bhwms.dto;

import io.ukoko.bhwms.entity.Role;

import java.util.List;

/**
 * 角色添加/更新请求DTO
 */
public class RoleRequest {
    private Role role;
    private List<Integer> permissionIds;

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public List<Integer> getPermissionIds() {
        return permissionIds;
    }

    public void setPermissionIds(List<Integer> permissionIds) {
        this.permissionIds = permissionIds;
    }
}
