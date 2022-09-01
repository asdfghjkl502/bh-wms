package io.ukoko.bhwms.entity;

/**
 * 映射数据库record_stock(库存记录)表
 */
public class RecordStock {

  /*
    产品ID
   */
  private Integer productId;
  /*
    仓库ID
   */
  private Integer repoId;
  /*
    库存数量
   */
  private Integer productStock;

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

  @Override
  public String toString() {
    return "RecordStock{" +
            "productId=" + productId +
            ", repoId=" + repoId +
            ", productStock=" + productStock +
            '}';
  }
}
