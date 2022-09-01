package io.ukoko.bhwms.entity;

/**
 * 映射数据库user_role(用户角色关联表)
 */
public class UserRole {
  /*
    用户ID
   */
  private Integer userId;
  /*
    角色ID
   */
  private Integer roleId;
  /*
      是否删除 0:删除 1:未删除
   */
  private int isDelete=1;
  public UserRole() {
  }

  public UserRole(Integer userId, Integer roleId) {
    this.userId = userId;
    this.roleId = roleId;
  }

  public Integer getUserId() {
    return userId;
  }

  public void setUserId(Integer userId) {
    this.userId = userId;
  }

  public Integer getRoleId() {
    return roleId;
  }

  public void setRoleId(Integer roleId) {
    this.roleId = roleId;
  }

  public int getIsDelete() {
    return isDelete;
  }

  public void setIsDelete(int isDelete) {
    this.isDelete = isDelete;
  }

  @Override
  public String toString() {
    return "UserRole{" +
            "userId=" + userId +
            ", roleId=" + roleId +
            ", isDelete=" + isDelete +
            '}';
  }
}
