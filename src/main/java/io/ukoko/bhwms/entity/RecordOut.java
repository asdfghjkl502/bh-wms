package io.ukoko.bhwms.entity;

import java.util.Date;
/**
 * 映射数据库record_out(出库记录表)表
 */
public class RecordOut {
  /*
    出库ID
   */
  private Integer recordOutId;
  /*
    客户ID
   */
  private Integer customerId;
  /*
    客户信息 多对一
   */
  private Customer customer;
  /*
    产品ID
   */
  private Integer productId;
  /*
    产品信息 多对一
   */
  private Product product;
  /*
    出库数量
   */
  private Integer recordOutNumber;
  /*
    出库时间
   */
  private Date recordOutTime;
  /*
    出库负责人ID
   */
  private Integer userId;
  /*
    出库负责人信息 多对一
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
      是否删除 0:删除 1:未删除
   */
  private int isDelete=1;
  public RecordOut() {
  }

  public Integer getRecordOutId() {
    return recordOutId;
  }

  public void setRecordOutId(Integer recordOutId) {
    this.recordOutId = recordOutId;
  }

  public Integer getCustomerId() {
    return customerId;
  }

  public void setCustomerId(Integer customerId) {
    this.customerId = customerId;
  }

  public Customer getCustomer() {
    return customer;
  }

  public void setCustomer(Customer customer) {
    this.customer = customer;
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

  public Integer getRecordOutNumber() {
    return recordOutNumber;
  }

  public void setRecordOutNumber(Integer recordOutNumber) {
    this.recordOutNumber = recordOutNumber;
  }

  public Date getRecordOutTime() {
    return recordOutTime;
  }

  public void setRecordOutTime(Date recordOutTime) {
    this.recordOutTime = recordOutTime;
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

  @Override
  public String toString() {
    return "RecordOut{" +
            "recordOutId=" + recordOutId +
            ", customerId=" + customerId +
            ", customer=" + customer +
            ", productId=" + productId +
            ", product=" + product +
            ", recordOutNumber=" + recordOutNumber +
            ", recordOutTime=" + recordOutTime +
            ", userId=" + userId +
            ", user=" + user +
            ", repoId=" + repoId +
            ", repository=" + repository +
            ", remarks='" + remarks + '\'' +
            ", isDelete=" + isDelete +
            '}';
  }
}
