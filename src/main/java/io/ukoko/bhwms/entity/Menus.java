package io.ukoko.bhwms.entity;


import java.util.List;

/**
 * 映射数据库menus(菜单)表
 */
public class Menus {
    /*
        菜单ID
     */
    private Integer menuId;
    /*
        菜单名称
     */
    private String  menuName;
    /*
        父类ID
     */
    private Integer pId;

    /*
        是否删除
     */
    private Integer isDelete;

    public Menus() {
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

    public Integer getpId() {
        return pId;
    }

    public void setpId(Integer pId) {
        this.pId = pId;
    }

    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }

    @Override
    public String toString() {
        return "Menus{" +
                "menuId=" + menuId +
                ", menuName='" + menuName + '\'' +
                ", pId=" + pId +
                ", isDelete=" + isDelete +
                '}';
    }
}
