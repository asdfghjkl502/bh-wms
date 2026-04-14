package io.ukoko.bhwms.entity;

import java.util.Date;
import java.util.List;

/**
 * 映射数据库permission(权限)表
 */
public class Permission {
    /*
        权限ID
     */
    private Integer permissionId;
    /*
        权限名称
     */
    private String permissionName;
    /*
        权限代码(如system:user:add)
     */
    private String permissionCode;
    /*
        权限类型:1=菜单,2=按钮,3=API
     */
    private Integer permissionType;
    /*
        权限URL(API权限时使用)
     */
    private String permissionUrl;
    /*
        层级
     */
    private Integer level;
    /*
        父ID,0表示顶级
     */
    private Integer parentId;
    /*
        创建时间
     */
    private Date createTime;
    /*
        更新时间
     */
    private Date updateTime;
    /*
        是否删除 0:删除 1:未删除
     */
    private Integer isDelete = 1;

    /*
        子权限列表
     */
    private List<Permission> children;

    public Permission() {
    }

    public Integer getPermissionId() {
        return permissionId;
    }

    public void setPermissionId(Integer permissionId) {
        this.permissionId = permissionId;
    }

    public String getPermissionName() {
        return permissionName;
    }

    public void setPermissionName(String permissionName) {
        this.permissionName = permissionName;
    }

    public String getPermissionCode() {
        return permissionCode;
    }

    public void setPermissionCode(String permissionCode) {
        this.permissionCode = permissionCode;
    }

    public Integer getPermissionType() {
        return permissionType;
    }

    public void setPermissionType(Integer permissionType) {
        this.permissionType = permissionType;
    }

    public String getPermissionUrl() {
        return permissionUrl;
    }

    public void setPermissionUrl(String permissionUrl) {
        this.permissionUrl = permissionUrl;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }

    public List<Permission> getChildren() {
        return children;
    }

    public void setChildren(List<Permission> children) {
        this.children = children;
    }

    @Override
    public String toString() {
        return "Permission{" +
                "permissionId=" + permissionId +
                ", permissionName='" + permissionName + '\'' +
                ", permissionCode='" + permissionCode + '\'' +
                ", permissionType=" + permissionType +
                ", permissionUrl='" + permissionUrl + '\'' +
                ", level=" + level +
                ", parentId=" + parentId +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", isDelete=" + isDelete +
                '}';
    }
}
