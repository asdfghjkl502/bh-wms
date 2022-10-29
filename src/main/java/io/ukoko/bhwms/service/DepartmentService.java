package io.ukoko.bhwms.service;

import io.ukoko.bhwms.dto.Page;
import io.ukoko.bhwms.entity.Department;
import io.ukoko.bhwms.exceptions.BhWmsException;

import java.util.List;

/**
 * 部门管理模块的业务逻辑层
 */
public interface DepartmentService {

    /**
     * 添加部门
     * @param department
     */
    void addDepartment(Department department);

    /**
     * 更新部门
     */
    void updateDepartment(Department department);
    /*
        删除部门
     */
    void deleteDepartment(Integer deptId) throws BhWmsException;

    /**
     * 部门列表查询
     */
    List<Department> getDepartmentList();
}
