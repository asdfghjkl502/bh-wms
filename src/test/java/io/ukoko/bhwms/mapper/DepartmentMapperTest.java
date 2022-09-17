package io.ukoko.bhwms.mapper;

import io.ukoko.bhwms.BhWmsApplicationTests;
import io.ukoko.bhwms.entity.Department;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class DepartmentMapperTest extends BhWmsApplicationTests {

    @Autowired
    private DepartmentMapper departmentMapper;

    @Test
    void addDepartment() {

//        Department department = new Department();
//        department.setDeptName("大萝卜股份有限公司");
//        department.setLevel(1);
//        department.setParentId(0);
//        department.setIsDelete(1);
//        department.setCreateTime(new Date());

//        departmentMapper.addDepartment(department);


//        for (int i = 1; i <= 5; i++) {
//            Department department = new Department();
//            department.setDeptName("大萝卜子公司"+i);
//            department.setLevel(2);
//            department.setParentId(1);
//            department.setIsDelete(1);
//            department.setCreateTime(new Date());
//
//            departmentMapper.addDepartment(department);
//        }

        for (int i = 1; i <= 2; i++) {
            Department department = new Department();
            department.setDeptName("部门"+i);
            department.setLevel(3);
            department.setParentId(6);
            department.setIsDelete(1);
            department.setCreateTime(new Date());

            departmentMapper.addDepartment(department);

        }
    }

    @Test
    void getDepartmentList() {
        departmentMapper.getDepartmentList().forEach(System.out::println);
    }

    @Test
    void getDepartmentListByDepatId() {
    }
}