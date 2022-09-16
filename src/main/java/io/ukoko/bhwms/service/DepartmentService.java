package io.ukoko.bhwms.service;

import io.ukoko.bhwms.dto.Page;
import io.ukoko.bhwms.entity.Department;

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
     * 分页查询
     * @param offset: 偏移量
     * @param limit: 每页显示多少条数
     * @return
     */
    Page getDepartmentPage(int offset,int limit);
}
