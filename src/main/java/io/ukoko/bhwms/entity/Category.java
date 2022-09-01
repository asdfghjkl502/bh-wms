package io.ukoko.bhwms.entity;

/**
 * 映射数据库category(类目)表
 */
public class Category {
    /*
      类目ID
     */
    private Integer categoryId;
    /*
      类目名称
     */
    private String categoryName;
    /*
        是否删除 0:删除 1:未删除
     */
    private int isDelete=1;
    public Category() {
    }

    public Category(Integer categoryId, String categoryName) {
        this.categoryId = categoryId;
        this.categoryName = categoryName;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public int getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(int isDelete) {
        this.isDelete = isDelete;
    }

    @Override
    public String toString() {
        return "Category{" +
                "categoryId=" + categoryId +
                ", categoryName='" + categoryName + '\'' +
                ", isDelete=" + isDelete +
                '}';
    }
}
