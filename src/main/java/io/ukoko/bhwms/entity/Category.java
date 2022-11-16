package io.ukoko.bhwms.entity;

import java.util.Date;
import java.util.List;

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
        层级
     */
    private Integer level;
    /*
        父ID
     */
    private Integer parentId;
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

    /*
        子分类列表
     */
    private List<Category> children;

    public Category() {
    }

    public Category(Integer categoryId, String categoryName, Integer level, Integer parentId, Date createTime, Date updateTime, int isDelete) {
        this.categoryId = categoryId;
        this.categoryName = categoryName;
        this.level = level;
        this.parentId = parentId;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.isDelete = isDelete;
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

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
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

    public int getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(int isDelete) {
        this.isDelete = isDelete;
    }

    public List<Category> getChildren() {
        return children;
    }

    public void setChildren(List<Category> children) {
        this.children = children;
    }

    @Override
    public String toString() {
        return "Category{" +
                "categoryId=" + categoryId +
                ", categoryName='" + categoryName + '\'' +
                ", level=" + level +
                ", parentId=" + parentId +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", isDelete=" + isDelete +
                ", children=" + children +
                '}';
    }
}
