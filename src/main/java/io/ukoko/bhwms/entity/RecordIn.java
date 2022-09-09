package io.ukoko.bhwms.entity;

import java.util.Date;

/**
 * 映射数据库record_in(入库记录表)表
 */
public class RecordIn {
  /*
    入库ID
   */
  private Integer recordInId;
  /*
    供应商ID
   */
  private Integer supplierId;
  /*
    供应商信息 多对一
   */
  private Supplier supplier;
  /*
    产品ID
   */
  private Integer productId;
  /*
    产品信息 多对一
   */
  private Product product;
  /*
    入库数量
   */
  private Integer recordInNumber;
  /*
    入库时间
   */
  private Date recordInTime;
  /*
    入库负责人ID
   */
  private Integer userId;
  /*
    入库负责人信息 多对一
   */
  private User user;
  /*
    仓库ID
   */
  private Integer repoId;
  /*
    入库仓库信息(多对一)
   */
  private Repository repository;
  /*
    备注
   */
  private String remarks;
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
  public RecordIn() {
  }

  public Integer getRecordInId() {
    return recordInId;
  }

  public void setRecordInId(Integer recordInId) {
    this.recordInId = recordInId;
  }

  public Integer getSupplierId() {
    return supplierId;
  }

  public void setSupplierId(Integer supplierId) {
    this.supplierId = supplierId;
  }

  public Supplier getSupplier() {
    return supplier;
  }

  public void setSupplier(Supplier supplier) {
    this.supplier = supplier;
  }

  public Integer getProductId() {
    return productId;
  }

  public void setProductId(Integer productId) {
    this.productId = productId;
  }

  public Product getProduct() {
    return product;
  }

  public void setProduct(Product product) {
    this.product = product;
  }

  public Integer getRecordInNumber() {
    return recordInNumber;
  }

  public void setRecordInNumber(Integer recordInNumber) {
    this.recordInNumber = recordInNumber;
  }

  public Date getRecordInTime() {
    return recordInTime;
  }

  public void setRecordInTime(Date recordInTime) {
    this.recordInTime = recordInTime;
  }

  public Integer getUserId() {
    return userId;
  }

  public void setUserId(Integer userId) {
    this.userId = userId;
  }

  public User getUser() {
    return user;
  }

  public void setUser(User user) {
    this.user = user;
  }

  public Integer getRepoId() {
    return repoId;
  }

  public void setRepoId(Integer repoId) {
    this.repoId = repoId;
  }

  public Repository getRepository() {
    return repository;
  }

  public void setRepository(Repository repository) {
    this.repository = repository;
  }

  public String getRemarks() {
    return remarks;
  }

  public void setRemarks(String remarks) {
    this.remarks = remarks;
  }

  public int getIsDelete() {
    return isDelete;
  }

  public void setIsDelete(int isDelete) {
    this.isDelete = isDelete;
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

  @Override
  public String toString() {
    return "RecordIn{" +
            "recordInId=" + recordInId +
            ", supplierId=" + supplierId +
            ", supplier=" + supplier +
            ", productId=" + productId +
            ", product=" + product +
            ", recordInNumber=" + recordInNumber +
            ", recordInTime=" + recordInTime +
            ", userId=" + userId +
            ", user=" + user +
            ", repoId=" + repoId +
            ", repository=" + repository +
            ", remarks='" + remarks + '\'' +
            ", createTime=" + createTime +
            ", updateTime=" + updateTime +
            ", isDelete=" + isDelete +
            '}';
  }
}
