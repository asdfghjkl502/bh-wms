package io.ukoko.bhwms.mapper;

import io.ukoko.bhwms.entity.Department;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 *  操作数据库部门表(department)的接口类
 */
@Mapper
public interface DepartmentMapper {

    /*
        添加部门
     */
    void addDepartment(Department department);

    /*
         获取部门列表
     */
    List<Department> getDepartmentList();

    /*
        通过部门ID查询当前部门下的子部门列表
     */
    List<Department> getDepartmentListByDeptId(Integer deptId);
}
