package io.ukoko.bhwms.dto;

/**
 * 封装分页信息
 */
public class Page {
    /*
        当前页
     */
    private int pageNo;
    /*
        每页显示多少条数
     */
    private int pageSize;
    /*
        是否有上一页
     */
    private boolean hasPre;
    /*
        是否有下一页
     */
    private boolean hasNext;
    /*
        总记录数
     */
    private long count;
    /*
        总页数
     */
    private long pageCount;
    /*
        当前页数据
     */
    private Object data;

    public Page() {
    }

    public int getPageNo() {
        return pageNo;
    }

    public void setPageNo(int pageNo) {
        this.pageNo = pageNo;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public boolean isHasPre() {
        return hasPre;
    }

    public void setHasPre(boolean hasPre) {
        this.hasPre = hasPre;
    }

    public boolean isHasNext() {
        return hasNext;
    }

    public void setHasNext(boolean hasNext) {
        this.hasNext = hasNext;
    }

    public long getCount() {
        return count;
    }

    public void setCount(long count) {
        this.count = count;
    }

    public long getPageCount() {
        return pageCount;
    }

    public void setPageCount(long pageCount) {
        this.pageCount = pageCount;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Page{" +
                "pageNo=" + pageNo +
                ", pageSize=" + pageSize +
                ", hasPre=" + hasPre +
                ", hasNext=" + hasNext +
                ", count=" + count +
                ", pageCount=" + pageCount +
                ", data=" + data +
                '}';
    }
}
