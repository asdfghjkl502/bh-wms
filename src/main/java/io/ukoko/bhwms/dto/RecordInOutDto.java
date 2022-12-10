package io.ukoko.bhwms.dto;

/**
 * 出入库记录参数
 */
public class RecordInOutDto {
    /*
        产品ID
    */
    private Integer productId;

    /*
        供应商ID
     */
    private Integer supplierId;

    /*
      仓库ID
     */
    private Integer repoId;
    /*
      库存数量
     */
    private Integer productStock;
    /*
        操作用户
     */
    private Integer userId;

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

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(Integer supplierId) {
        this.supplierId = supplierId;
    }

    @Override
    public String toString() {
        return "RecordInOutDto{" +
                "productId=" + productId +
                ", supplierId=" + supplierId +
                ", repoId=" + repoId +
                ", productStock=" + productStock +
                ", userId=" + userId +
                '}';
    }
}
