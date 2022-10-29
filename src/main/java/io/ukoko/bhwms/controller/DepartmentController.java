package io.ukoko.bhwms.controller;

import io.swagger.annotations.Api;
import io.ukoko.bhwms.dto.Result;
import io.ukoko.bhwms.entity.Department;
import io.ukoko.bhwms.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Api(tags = "部门模块")
@CrossOrigin
@RestController
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;


    /**
     * 更新部门
     * @param department : 部门
     * @return
     */
    @PostMapping(value = "/updateDepartment")
    public Object updateDepartment(@RequestBody Department department){
        departmentService.updateDepartment(department);
        return new Result();
    }

    /**
     * 添加部门
     * @param department: 部门
     * @return
     */
    @PostMapping(value = "/addDepartment")
    public Object addDepartment(@RequestBody Department department){
        departmentService.addDepartment(department);
        return new Result();
    }

    /**
     * 删除部门
     * @param deptId: 部门ID
     * @return
     */
    @PostMapping(value = "/deleteDepartment")
    public Object deleteDepartment(Integer deptId){
        departmentService.deleteDepartment(deptId);
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
