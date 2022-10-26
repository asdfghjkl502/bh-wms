package io.ukoko.bhwms.controller;

import io.swagger.annotations.Api;
import io.ukoko.bhwms.dto.Result;
import io.ukoko.bhwms.entity.Department;
import io.ukoko.bhwms.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "部门模块")
@CrossOrigin
@RestController
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    /**
     * 添加部门
     * @param department
     * @return
     */
    @PostMapping(value = "/addDepartment")
    public Object addDepartment(Department department){
        departmentService.addDepartment(department);
        return new Result();
    }

    /**
     * 获取部门列表
     */
    @GetMapping(value = "/getDepartmentList")
    public Object getDepartmentList(){
        return new Result(departmentService.getDepartmentList());
    }
}
