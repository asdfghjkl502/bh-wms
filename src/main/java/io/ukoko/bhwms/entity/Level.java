package io.ukoko.bhwms.entity;

import java.util.Date;

/**
 * 映射数据库level(级别)表
 */
public class Level {

  /*
    级别ID
   */
  private Integer levelId;
  /*
    级别名称
   */
  private String levelName;
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
  private Integer isDelete=1;

  public Level() {
  }

  public Level(Integer levelId, String levelName, Date createTime, Date updateTime, Integer isDelete) {
    this.levelId = levelId;
    this.levelName = levelName;
    this.createTime = createTime;
    this.updateTime = updateTime;
    this.isDelete = isDelete;
  }

  public Integer getLevelId() {
    return levelId;
  }

  public void setLevelId(Integer levelId) {
    this.levelId = levelId;
  }

  public String getLevelName() {
    return levelName;
  }

  public void setLevelName(String levelName) {
    this.levelName = levelName;
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

  @Override
  public String toString() {
    return "Level{" +
            "levelId=" + levelId +
            ", levelName='" + levelName + '\'' +
            ", createTime=" + createTime +
            ", updateTime=" + updateTime +
            ", isDelete=" + isDelete +
            '}';
  }
}
