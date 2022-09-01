package io.ukoko.bhwms.entity;

/**
 * 映射数据库repository(仓库)表
 */
public class Repository {
  /*
    仓库ID
   */
  private Integer repoId;
  /*
    仓库地址
   */
  private String repoAddress;
  /*
    仓库面积,单位:平方米
   */
  private String repoArea;
  /*
    仓库描述(备注)
   */
  private String repoDesc;
  /*
    仓库状态 0:故障 1:正常 2:已满
   */
  private Integer repoStatus;
  /*
      是否删除 0:删除 1:未删除
   */
  private int isDelete=1;
  public Repository() {
  }

  public Integer getRepoId() {
    return repoId;
  }

  public void setRepoId(Integer repoId) {
    this.repoId = repoId;
  }

  public String getRepoAddress() {
    return repoAddress;
  }

  public void setRepoAddress(String repoAddress) {
    this.repoAddress = repoAddress;
  }

  public String getRepoArea() {
    return repoArea;
  }

  public void setRepoArea(String repoArea) {
    this.repoArea = repoArea;
  }

  public String getRepoDesc() {
    return repoDesc;
  }

  public void setRepoDesc(String repoDesc) {
    this.repoDesc = repoDesc;
  }

  public Integer getRepoStatus() {
    return repoStatus;
  }

  public void setRepoStatus(Integer repoStatus) {
    this.repoStatus = repoStatus;
  }

  public int getIsDelete() {
    return isDelete;
  }

  public void setIsDelete(int isDelete) {
    this.isDelete = isDelete;
  }

  @Override
  public String toString() {
    return "Repository{" +
            "repoId=" + repoId +
            ", repoAddress='" + repoAddress + '\'' +
            ", repoArea='" + repoArea + '\'' +
            ", repoDesc='" + repoDesc + '\'' +
            ", repoStatus=" + repoStatus +
            ", isDelete=" + isDelete +
            '}';
  }
}
