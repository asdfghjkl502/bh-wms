package io.ukoko.bhwms.entity;

import java.util.Date;

/**
 * 映射数据库record_stock(库存记录)表
 */
public class RecordStock {

  /*
    产品ID
   */
  private Integer productId;

  /*
    产品详情
   */
  private Product product;

  /*
    仓库ID
   */
  private Integer repoId;

  /*
    仓库详情
   */
  private Repository repository;

  /*
    库存数量
   */
  private Integer productStock;
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

  public RecordStock() {
  }

  public RecordStock(Integer productId, Integer repoId, Integer productStock) {
    this.productId = productId;
    this.repoId = repoId;
    this.productStock = productStock;
  }

  public Integer getProductId() {
    return productId;
  }

  public void setProductId(Integer productId) {
    this.productId = productId;
  }

  public Integer getRepoId() {
    return repoId;
  }

  public void setRepoId(Integer repoId) {
    this.repoId = repoId;
  }

  public Integer getProductStock() {
    return productStock;
  }

  public void setProductStock(Integer productStock) {
    this.productStock = productStock;
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

  public Product getProduct() {
    return product;
  }

  public void setProduct(Product product) {
    this.product = product;
  }

  public Repository getRepository() {
    return repository;
  }

  public void setRepository(Repository repository) {
    this.repository = repository;
  }

  @Override
  public String toString() {
    return "RecordStock{" +
            "productId=" + productId +
            ", product=" + product +
            ", repoId=" + repoId +
            ", repository=" + repository +
            ", productStock=" + productStock +
            ", createTime=" + createTime +
            ", updateTime=" + updateTime +
            ", isDelete=" + isDelete +
            '}';
  }
}
