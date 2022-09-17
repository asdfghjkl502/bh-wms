package io.ukoko.bhwms.entity;

import java.util.Date;

/**
 * 映射数据库industry(行业)表
 */
public class Industry {

  /*
    行业ID
   */
  private Integer industryId;
  /*
    行业名称
   */
  private String industryName;
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

  public Industry() {
  }

  public Industry(Integer industryId, String industryName, Date createTime, Date updateTime, Integer isDelete) {
    this.industryId = industryId;
    this.industryName = industryName;
    this.createTime = createTime;
    this.updateTime = updateTime;
    this.isDelete = isDelete;
  }

  public Integer getIndustryId() {
    return industryId;
  }

  public void setIndustryId(Integer industryId) {
    this.industryId = industryId;
  }

  public String getIndustryName() {
    return industryName;
  }

  public void setIndustryName(String industryName) {
    this.industryName = industryName;
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
    return "Industry{" +
            "industryId=" + industryId +
            ", industryName='" + industryName + '\'' +
            ", createTime=" + createTime +
            ", updateTime=" + updateTime +
            ", isDelete=" + isDelete +
            '}';
  }
}
