package io.ukoko.bhwms.entity;

/**
 * 映射数据库product(产品)表
 */
public class Product {
  /*
    产品ID
   */
  private Integer productId;
  /*
    产品名称
   */
  private String productName;
  /*
    类目ID
   */
  private Integer categoryId;
  /*
    产品分类(多对一)
   */
  private Category category;
  /*
    产品尺寸
   */
  private String productSize;
  /*
    产品价格
   */
  private Double productPrice;
  /*
      是否删除 0:删除 1:未删除
   */
  private int isDelete=1;
  public Product() {
  }

  public Integer getProductId() {
    return productId;
  }

  public void setProductId(Integer productId) {
    this.productId = productId;
  }

  public String getProductName() {
    return productName;
  }

  public void setProductName(String productName) {
    this.productName = productName;
  }

  public Integer getCategoryId() {
    return categoryId;
  }

  public void setCategoryId(Integer categoryId) {
    this.categoryId = categoryId;
  }

  public Category getCategory() {
    return category;
  }

  public void setCategory(Category category) {
    this.category = category;
  }

  public String getProductSize() {
    return productSize;
  }

  public void setProductSize(String productSize) {
    this.productSize = productSize;
  }

  public Double getProductPrice() {
    return productPrice;
  }

  public void setProductPrice(Double productPrice) {
    this.productPrice = productPrice;
  }

  public int getIsDelete() {
    return isDelete;
  }

  public void setIsDelete(int isDelete) {
    this.isDelete = isDelete;
  }

  @Override
  public String toString() {
    return "Product{" +
            "productId=" + productId +
            ", productName='" + productName + '\'' +
            ", categoryId=" + categoryId +
            ", category=" + category +
            ", productSize='" + productSize + '\'' +
            ", productPrice=" + productPrice +
            ", isDelete=" + isDelete +
            '}';
  }
}
