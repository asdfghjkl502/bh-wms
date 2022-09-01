package io.ukoko.bhwms.entity;

/**
 * 映射数据库user(用户)表
 */
public class User {

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
  /*
    盐值
   */
  private String salt;
  /*
      是否删除 0:删除 1:未删除
   */
  private int isDelete=1;
  public User() {
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

  public int getIsDelete() {
    return isDelete;
  }

  public void setIsDelete(int isDelete) {
    this.isDelete = isDelete;
  }

  @Override
  public String toString() {
    return "User{" +
            "userId=" + userId +
            ", userName='" + userName + '\'' +
            ", userTel='" + userTel + '\'' +
            ", userEmail='" + userEmail + '\'' +
            ", userNick='" + userNick + '\'' +
            ", password='" + password + '\'' +
            ", salt='" + salt + '\'' +
            ", isDelete=" + isDelete +
            '}';
  }
}
