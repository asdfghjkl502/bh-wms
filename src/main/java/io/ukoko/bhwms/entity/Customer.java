package io.ukoko.bhwms.entity;

import java.util.Date;

/**
 * 映射数据库customer(客户)表
 */
public class Customer {
    /*
      客户ID
     */
    private Integer customerId;
    /*
      客户名称
     */
    private String customerName;
    /*
      客户负责人
     */
    private String customerLeader;
    /*
      客户联系电话
     */
    private String customerTel;
    /*
      客户联系邮箱
     */
    private String customerEmail;
    /*
      客户联系地址
     */
    private String customerAddress;
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
    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerLeader() {
        return customerLeader;
    }

    public void setCustomerLeader(String customerLeader) {
        this.customerLeader = customerLeader;
    }

    public String getCustomerTel() {
        return customerTel;
    }

    public void setCustomerTel(String customerTel) {
        this.customerTel = customerTel;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
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
        return "Customer{" +
                "customerId=" + customerId +
                ", customerName='" + customerName + '\'' +
                ", customerLeader='" + customerLeader + '\'' +
                ", customerTel='" + customerTel + '\'' +
                ", customerEmail='" + customerEmail + '\'' +
                ", customerAddress='" + customerAddress + '\'' +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", isDelete=" + isDelete +
                '}';
    }
}
