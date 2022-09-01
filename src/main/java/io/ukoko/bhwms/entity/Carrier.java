package io.ukoko.bhwms.entity;

/**
 * 映射数据库carrier(承运商)表
 */
public class Carrier {
    /*
      承运商ID
     */
    private Integer carrierId;
    /*
      承运商名称
     */
    private String carrierName;
    /*
      承运商负责人
     */
    private String carrierLeader;
    /*
      承运商联系电话
     */
    private String carrierTel;
    /*
      承运商联系邮箱
     */
    private String carrierEmail;
    /*
      联系地址
     */
    private String carrierAddress;
    /*
        是否删除 0:删除 1:未删除
     */
    private int isDelete=1;

    public Carrier() {
    }

    public Integer getCarrierId() {
        return carrierId;
    }

    public void setCarrierId(Integer carrierId) {
        this.carrierId = carrierId;
    }

    public String getCarrierName() {
        return carrierName;
    }

    public void setCarrierName(String carrierName) {
        this.carrierName = carrierName;
    }

    public String getCarrierLeader() {
        return carrierLeader;
    }

    public void setCarrierLeader(String carrierLeader) {
        this.carrierLeader = carrierLeader;
    }

    public String getCarrierTel() {
        return carrierTel;
    }

    public void setCarrierTel(String carrierTel) {
        this.carrierTel = carrierTel;
    }

    public String getCarrierEmail() {
        return carrierEmail;
    }

    public void setCarrierEmail(String carrierEmail) {
        this.carrierEmail = carrierEmail;
    }

    public String getCarrierAddress() {
        return carrierAddress;
    }

    public void setCarrierAddress(String carrierAddress) {
        this.carrierAddress = carrierAddress;
    }

    public int getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(int isDelete) {
        this.isDelete = isDelete;
    }

    @Override
    public String toString() {
        return "Carrier{" +
                "carrierId=" + carrierId +
                ", carrierName='" + carrierName + '\'' +
                ", carrierLeader='" + carrierLeader + '\'' +
                ", carrierTel='" + carrierTel + '\'' +
                ", carrierEmail='" + carrierEmail + '\'' +
                ", carrierAddress='" + carrierAddress + '\'' +
                ", isDelete=" + isDelete +
                '}';
    }
}
