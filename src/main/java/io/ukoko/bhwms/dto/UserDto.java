package io.ukoko.bhwms.dto;

import io.ukoko.bhwms.entity.Department;
import io.ukoko.bhwms.entity.Role;

import java.util.Date;
import java.util.List;

/**
 * 用户前后端交互数据
 */
public class UserDto {

    /*
       用户ID
      */
    private Integer userId;
    /*
      用户名
     */
    private String userName;
    /*
      联系电话
     */
    private String userTel;
    /*
      邮箱
     */
    private String userEmail;
    /*
      用户昵称
     */
    private String userNick;
    /*
      密码
     */
    private String password;

    /**
     * 新密码
     */
    private String newPassword;

    /**
     * 头像地址
     */
    private String avatar;

    /*
      盐值
     */
    private String salt;
    /*
      部门ID列表
     */
    private List<Integer> deptId;
    /*
      角色ID列表
     */
    private List<Integer> roleId;
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

    public UserDto() {
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserTel() {
        return userTel;
    }

    public void setUserTel(String userTel) {
        this.userTel = userTel;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserNick() {
        return userNick;
    }

    public void setUserNick(String userNick) {
        this.userNick = userNick;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public List<Integer> getDeptId() {
        return deptId;
    }

    public void setDeptId(List<Integer> deptId) {
        this.deptId = deptId;
    }

    public List<Integer> getRoleId() {
        return roleId;
    }

    public void setRoleId(List<Integer> roleId) {
        this.roleId = roleId;
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

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }
    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }
    @Override
    public String toString() {
        return "UserDto{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", userTel='" + userTel + '\'' +
                ", userEmail='" + userEmail + '\'' +
                ", userNick='" + userNick + '\'' +
                ", password='" + password + '\'' +
                ", newPassword='" + newPassword + '\'' +
                ", avatar='" + avatar + '\'' +
                ", salt='" + salt + '\'' +
                ", deptId=" + deptId +
                ", roleId=" + roleId +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", isDelete=" + isDelete +
                '}';
    }
}
