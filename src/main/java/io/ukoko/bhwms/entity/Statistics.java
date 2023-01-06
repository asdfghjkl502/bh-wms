package io.ukoko.bhwms.entity;

/**
 * 统计数据
 */
public class Statistics {

    private Long count;//数量
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

    @Override
    public String toString() {
        return "Statistics{" +
                "count=" + count +
                ", time='" + time + '\'' +
                '}';
    }
}
