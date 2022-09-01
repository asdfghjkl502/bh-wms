package io.ukoko.bhwms.entity;

/**
 * 映射数据库department(部门)表
 */
public class Department {

    /*
      部门ID
     */
    private Integer deptId;
    /*
      部门名称
     */
    private String deptName;
    /*
        层级
     */
    private Integer level;
    /*
        父ID
     */
    private Integer parentId;
    /*
        是否删除 0:删除 1:未删除
     */
    private int isDelete=1;
    public Department() {
    }

    public Department(Integer deptId, String deptName, Integer level, Integer parentId) {
        this.deptId = deptId;
        this.deptName = deptName;
        this.level = level;
        this.parentId = parentId;
    }

    public Integer getDeptId() {
        return deptId;
    }

    public void setDeptId(Integer deptId) {
        this.deptId = deptId;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
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

    public int getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(int isDelete) {
        this.isDelete = isDelete;
    }

    @Override
    public String toString() {
        return "Department{" +
                "deptId=" + deptId +
                ", deptName='" + deptName + '\'' +
                ", level=" + level +
                ", parentId=" + parentId +
                ", isDelete=" + isDelete +
                '}';
    }
}
