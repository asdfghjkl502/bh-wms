package io.ukoko.bhwms.controller;

import io.swagger.annotations.Api;
import io.ukoko.bhwms.dto.Page;
import io.ukoko.bhwms.dto.Result;
import io.ukoko.bhwms.entity.Role;
import io.ukoko.bhwms.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 角色管理模块的控制器层
 */
@Api(tags = "角色管理模块控制器")
@RestController
@CrossOrigin
public class RoleController {

    @Autowired
    private RoleService roleService;


    /**
     * 获取角色分页数据
     * @param offset: 偏移量
     * @param limit: 每页显示多少条数
     * @param isDelete: 是否删除 1:未删除 0:删除
     * @return
     */
    @GetMapping(value = "/getRoleList")
    public Result getRoleList(Integer limit,Integer offset,Integer isDelete){
        System.out.println("limit:"+limit);
        System.out.println("offset:"+offset);
        System.out.println("isDelete:"+isDelete);
        Page page = roleService.getRolePageFor(limit,offset,isDelete);
        return new Result(page);
    }

    @GetMapping(value = "/getRoleBootstrap")
    public Object getRoleBootstrap(Integer limit,Integer offset){
        System.out.println("==="+offset);
        System.out.println("---"+limit);
        Page page = roleService.getRolePageFor(limit,offset,1);
        Map<String,Object> map = new HashMap<>();
        map.put("total",page.getCount());
        map.put("rows",page.getData());
        return map;
    }

    @GetMapping(value = "/getRolePage")
    public Object getRolePage(Integer pageNumber,Integer pageSize){
        System.out.println("+++"+pageNumber);
        System.out.println("---"+pageSize);
        Page page = roleService.getRolePage(pageNumber,pageSize,1);
        Map<String,Object> map = new HashMap<>();
        map.put("total",page.getCount());
        map.put("rows",page.getData());
        return map;
    }

    /**
     * 查询列表
     * @param isDelete
     * @return
     */
    @GetMapping(value = "/getRoleAll")
    public List<Role> getRoleAll(Integer isDelete){
        System.out.println("getRollAll...");
        return roleService.getRolesBy(isDelete);
    }

}