package io.ukoko.bhwms.entity;
/*
  映射数据库supplier(供应商)表
 */
public class Supplier {
  /*
    供应商ID
   */
  private Integer supplierId;
  /*
    供应商信息名字
   */
  private String supplierName;
  /*
    供应商负责人
   */
  private String supplierLeader;
  /*
    供应商联系电话
   */
  private String supplierTel;
  /*
    供应商联系邮箱
   */
  private String supplierEmail;
  /*
    供应商联系地址
   */
  private String supplierAddress;

  public Supplier() {
  }

  public Integer getSupplierId() {
    return supplierId;
  }

  public void setSupplierId(Integer supplierId) {
    this.supplierId = supplierId;
  }

  public String getSupplierName() {
    return supplierName;
  }

  public void setSupplierName(String supplierName) {
    this.supplierName = supplierName;
  }

  public String getSupplierLeader() {
    return supplierLeader;
  }

  public void setSupplierLeader(String supplierLeader) {
    this.supplierLeader = supplierLeader;
  }

  public String getSupplierTel() {
    return supplierTel;
  }

  public void setSupplierTel(String supplierTel) {
    this.supplierTel = supplierTel;
  }

  public String getSupplierEmail() {
    return supplierEmail;
  }

  public void setSupplierEmail(String supplierEmail) {
    this.supplierEmail = supplierEmail;
  }

  public String getSupplierAddress() {
    return supplierAddress;
  }

  public void setSupplierAddress(String supplierAddress) {
    this.supplierAddress = supplierAddress;
  }

  @Override
  public String toString() {
    return "Supplier{" +
            "supplierId=" + supplierId +
            ", supplierName='" + supplierName + '\'' +
            ", supplierLeader='" + supplierLeader + '\'' +
            ", supplierTel='" + supplierTel + '\'' +
            ", supplierEmail='" + supplierEmail + '\'' +
            ", supplierAddress='" + supplierAddress + '\'' +
            '}';
  }
}
