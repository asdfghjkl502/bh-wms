package io.ukoko.bhwms.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.ukoko.bhwms.dto.Page;
import io.ukoko.bhwms.dto.Result;
import io.ukoko.bhwms.entity.Role;
import io.ukoko.bhwms.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@Api(tags = "角色模块")
@CrossOrigin
@RestController
public class RoleController {


    @Autowired
    private RoleService roleService;

    /**
     * 添加角色
     * @param role:角色信息
     * @return
     */
    @PostMapping(value = "/addRole")
    public Object addRole(@RequestBody Role role){
        roleService.addRole(role);
        return new Result();
    }

    /**
     * 批量删除
     * @param roleIds
     * @return
     */
    @PostMapping(value = "/batchDeleteRole")
    public Object batchDeleteRole(@RequestBody List<Integer> roleIds){
        roleService.batchDeleteRole(roleIds);
        return new Result();
    }

    /**
     * 删除角色
     * @param roleId:角色ID
     * @return
     */
    @GetMapping(value = "/deleteRoleByRoleId")
    public Object deleteRoleByRoleId(Integer roleId){
        System.out.println("删除角色: "+roleId);
        return new Result();
    }

    /**
     * 更新角色
     * @param role
     * @return
     */
    @PostMapping(value = "/updateRole")
    public Object updateRole(@RequestBody Role role){
        System.out.println("更新角色: "+role);
        roleService.updateRole(role);
        return new Result();
    }


    /**
     * 获取角色页
     * @param pageSize
     * @param pageNo
     * @param isDelete
     * @param roleName
     * @param startTime
     * @param endTime
     * @param roleId
     * @return
     */
    @GetMapping(value = "/getRolePage")
    public Result getRolePage(Integer pageSize, Integer pageNo, Integer isDelete, String roleName, @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") Date startTime,@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") Date endTime, Integer roleId){
        Page page = roleService.getRolePage(pageSize, pageNo, isDelete, roleName, startTime, endTime, roleId);
        return new Result(page);
    }

    /**
     * 获取角色信息
     * @param roleId:角色ID
     * @return
     */
    @ApiImplicitParams(value = {@ApiImplicitParam(name = "roleId",value = "角色ID",dataType = "java.lang.Integer")})
    @GetMapping(value = "/getRole")
    public Object getRole(Integer roleId){
        Role role = roleService.getRoleByRoleId(roleId);
        return new Result(role);
    }

    /**
     * 查询全部
     * @return
     */
    @GetMapping(value = "/getRoleList")
    public Object getRoleList(){
        return new Result(roleService.getRoleList());
    }
}
