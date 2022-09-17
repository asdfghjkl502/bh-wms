package io.ukoko.bhwms.entity;


import java.util.Date;

/**
 * 映射数据库source(来源)表
 */
public class Source {
  /*
    来源ID
   */
  private Integer sourceId;
  /*
    来源名称
   */
  private String sourceName;
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

  public Source() {
  }

  public Source(Integer sourceId, String sourceName, Date createTime, Date updateTime, Integer isDelete) {
    this.sourceId = sourceId;
    this.sourceName = sourceName;
    this.createTime = createTime;
    this.updateTime = updateTime;
    this.isDelete = isDelete;
  }

  public Integer getSourceId() {
    return sourceId;
  }

  public void setSourceId(Integer sourceId) {
    this.sourceId = sourceId;
  }

  public String getSourceName() {
    return sourceName;
  }

  public void setSourceName(String sourceName) {
    this.sourceName = sourceName;
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
    return "Source{" +
            "sourceId=" + sourceId +
            ", sourceName='" + sourceName + '\'' +
            ", createTime=" + createTime +
            ", updateTime=" + updateTime +
            ", isDelete=" + isDelete +
            '}';
  }
}
