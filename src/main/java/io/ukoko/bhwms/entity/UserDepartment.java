package io.ukoko.bhwms.entity;


import java.util.Date;

/**
 * 映射数据库user_department(用户部门关联)表
 */
public class UserDepartment {

  /*
    部门ID
   */
  private Integer deptId;
  /*
    部门信息
   */
  private Department department;
  /*
    用户ID
   */
  private Integer userId;
  /*
    用户信息
   */
  private User user;
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
  private int isDelete=1;

  public UserDepartment() {
  }

  public Integer getDeptId() {
    return deptId;
  }

  public void setDeptId(Integer deptId) {
    this.deptId = deptId;
  }

  public Integer getUserId() {
    return userId;
  }

  public void setUserId(Integer userId) {
    this.userId = userId;
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

  public int getIsDelete() {
    return isDelete;
  }

  public void setIsDelete(int isDelete) {
    this.isDelete = isDelete;
  }

  public Department getDepartment() {
    return department;
  }

  public void setDepartment(Department department) {
    this.department = department;
  }

  public User getUser() {
    return user;
  }

  public void setUser(User user) {
    this.user = user;
  }

  @Override
  public String toString() {
    return "UserDepartment{" +
            "deptId=" + deptId +
            ", department=" + department +
            ", userId=" + userId +
            ", user=" + user +
            ", createTime=" + createTime +
            ", updateTime=" + updateTime +
            ", isDelete=" + isDelete +
            '}';
  }
}
