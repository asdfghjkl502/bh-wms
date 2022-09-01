package io.ukoko.bhwms.entity;

/**
 * 映射数据库role(角色)表
 */
public class Role {
    /*
        角色ID
     */
    private Integer roleId;
    /*
        角色名称
     */
    private String roleName;
    /*
        是否删除 0:删除 1:未删除
     */
    private int isDelete=1;
    public Role() {
    }

    public Role(Integer roleId, String roleName) {
        this.roleId = roleId;
        this.roleName = roleName;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public int getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(int isDelete) {
        this.isDelete = isDelete;
    }

    @Override
    public String toString() {
        return "Role{" +
                "roleId=" + roleId +
                ", roleName='" + roleName + '\'' +
                ", isDelete=" + isDelete +
                '}';
    }
}
