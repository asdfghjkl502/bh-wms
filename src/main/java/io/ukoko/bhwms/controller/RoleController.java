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
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

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
    public Object addRole(Role role){
        System.out.println("添加角色: "+role);
        roleService.addRole(role);
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
    public Object updateRole(Role role){
        System.out.println("更新角色: "+role);
        roleService.updateRole(role);
        return new Result();
    }

    /**
     * 获取角色列表信息
     * @param limit : 每页显示多少条数
     * @param offset: 偏移量
     * @param isDelete : 是否删除
     * @param roleName : 角色名称
     * @param startTime: 开始时间
     * @param endTime: 结束时间
     * @param roleId : 角色ID
     * @return
     */
    @ApiImplicitParams({
            @ApiImplicitParam(name = "limit",value = "页容量",dataType = "java.lang.Integer"),
            @ApiImplicitParam(name = "offset",value = "偏移量",dataType = "java.lang.Integer"),
            @ApiImplicitParam(name = "isDelete",value = "是否删除 0:删除,1:未删除",dataType = "java.lang.Integer"),
            @ApiImplicitParam(name = "roleName",value = "角色名称",dataType = "java.lang.String"),
            @ApiImplicitParam(name = "startTime",value = "开始时间",dataType = "java.util.Date"),
            @ApiImplicitParam(name = "endTime",value = "结束时间",dataType = "java.util.Date"),
            @ApiImplicitParam(name = "roleId",value = "角色ID",dataType = "java.lang.Integer")
    })
    @GetMapping(value = "/getRoles")
    public Result getRoles(int limit, int offset, Integer isDelete, String roleName, @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") Date startTime,@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") Date endTime, Integer roleId){
        Page page = roleService.getRolePageFor(limit, offset, isDelete, roleName, startTime, endTime, roleId);
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
}
