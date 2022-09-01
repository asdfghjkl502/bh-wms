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

  @Override
  public String toString() {
    return "UserRole{" +
            "userId=" + userId +
            ", roleId=" + roleId +
            '}';
  }
}
