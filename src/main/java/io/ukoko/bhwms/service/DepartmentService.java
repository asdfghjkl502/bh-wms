package io.ukoko.bhwms.service;

import io.ukoko.bhwms.dto.Page;
import io.ukoko.bhwms.entity.Department;

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
     * 部门列表查询
     */
    List<Department> getDepartmentList();
}
