package io.ukoko.bhwms.entity;

/**
 * 映射数据库user_department(用户部门关联表)
 */
public class UserDepartment {
  /*
    用户ID
   */
  private Integer userId;
  /*
    部门ID
   */
  private Integer deptId;

  public UserDepartment() {
  }

  public UserDepartment(Integer userId, Integer deptId) {
    this.userId = userId;
    this.deptId = deptId;
  }

  public Integer getUserId() {
    return userId;
  }

  public void setUserId(Integer userId) {
    this.userId = userId;
  }

  public Integer getDeptId() {
    return deptId;
  }

  public void setDeptId(Integer deptId) {
    this.deptId = deptId;
  }

  @Override
  public String toString() {
    return "UserDepartment{" +
            "userId=" + userId +
            ", deptId=" + deptId +
            '}';
  }
}
