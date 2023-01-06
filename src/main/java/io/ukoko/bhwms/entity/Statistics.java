package io.ukoko.bhwms.entity;

/**
 * 统计数据
 */
public class Statistics {

    private Integer productId;//产品ID
    private Long count;//数量
    private Double price;//金额
    private String time;//时间

    public Statistics() {
    }

    public Statistics(Long count, String time) {
        this.count = count;
        this.time = time;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    @Override
    public String toString() {
        return "Statistics{" +
                "productId=" + productId +
                ", count=" + count +
                ", price=" + price +
                ", time='" + time + '\'' +
                '}';
    }
}
