package io.ukoko.bhwms.controller;

import io.swagger.annotations.Api;
import io.ukoko.bhwms.dto.Page;
import io.ukoko.bhwms.dto.Result;
import io.ukoko.bhwms.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 角色管理模块的控制器层
 */
@Api(tags = "角色管理模块控制器")
@RestController
public class RoleController {

    @Autowired
    private RoleService roleService;


    /*
        获取角色分页数据
     */
    @GetMapping(value = "/getRoleList")
    public Result getRoleList(Integer pageNo,Integer pageSize,Integer isDelete){
        Page page = roleService.getRolePage(pageNo, pageSize, isDelete);
        return new Result(page);
    }

}