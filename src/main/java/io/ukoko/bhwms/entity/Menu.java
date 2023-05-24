package io.ukoko.bhwms.entity;


import java.util.Date;
import java.util.List;

/**
 * 映射数据库menu(菜单)表
 */
public class Menu {
    /*
        菜单ID
     */
    private Integer menuId;
    /*
        菜单名称
     */
    private String  menuName;
    /*
        菜单地址
     */
    private String menuUrl;
    /*
        菜单级别
     */
    private Integer level;
    /*
        父类ID
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
        是否删除
     */
    private Integer isDelete=1;

    /**
     * 叶子节点
     */
    private List<Menu> menus;

    public Menu() {
    }

    public Integer getMenuId() {
        return menuId;
    }

    public void setMenuId(Integer menuId) {
        this.menuId = menuId;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public String getMenuUrl() {
        return menuUrl;
    }

    public void setMenuUrl(String menuUrl) {
        this.menuUrl = menuUrl;
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

    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }

    public List<Menu> getMenus() {
        return menus;
    }

    public void setMenus(List<Menu> menus) {
        this.menus = menus;
    }

    @Override
    public String toString() {
        return "Menu{" +
                "menuId=" + menuId +
                ", menuName='" + menuName + '\'' +
                ", menuUrl='" + menuUrl + '\'' +
                ", level=" + level +
                ", parentId=" + parentId +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", isDelete=" + isDelete +
                ", menus=" + menus +
                '}';
    }
}
