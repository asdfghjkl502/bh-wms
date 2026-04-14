package io.ukoko.bhwms.controller;

import io.swagger.annotations.Api;
import io.ukoko.bhwms.dto.Page;
import io.ukoko.bhwms.dto.Result;
import io.ukoko.bhwms.entity.Permission;
import io.ukoko.bhwms.entity.User;
import io.ukoko.bhwms.mapper.UserMapper;
import io.ukoko.bhwms.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

/**
 * 权限管理控制器
 */
@Api(tags = "权限模块")
@CrossOrigin
@RestController
public class PermissionController {

    @Autowired
    private PermissionService permissionService;

    @Autowired
    private UserMapper userMapper;

    /**
     * 获取权限分页列表
     */
    @GetMapping(value = "/getPermissionPage")
    public Object getPermissionPage(Integer pageNo, Integer pageSize, String permissionName, String permissionCode, Integer permissionType) {
        Page page = permissionService.getPermissionPage(pageNo, pageSize, permissionName, permissionCode, permissionType);
        return new Result(page);
    }

    /**
     * 获取所有权限
     */
    @GetMapping(value = "/getPermissionAll")
    public Object getPermissionAll() {
        List<Permission> list = permissionService.getPermissionAll();
        return new Result(list);
    }

    /**
     * 添加权限
     */
    @PostMapping(value = "/addPermission")
    public Object addPermission(@RequestBody Permission permission) {
        permissionService.addPermission(permission);
        return new Result();
    }

    /**
     * 更新权限
     */
    @PostMapping(value = "/updatePermission")
    public Object updatePermission(@RequestBody Permission permission) {
        permissionService.updatePermission(permission);
        return new Result();
    }

    /**
     * 删除权限
     */
    @PostMapping(value = "/deletePermission")
    public Object deletePermission(Integer permissionId) {
        permissionService.deletePermission(permissionId);
        return new Result();
    }

    /**
     * 批量删除权限
     */
    @PostMapping(value = "/batchDeletePermission")
    public Object batchDeletePermission(@RequestBody List<Integer> permissionIds) {
        permissionService.batchDeletePermission(permissionIds);
        return new Result();
    }

    /**
     * 获取角色拥有的权限
     */
    @GetMapping(value = "/getPermissionByRoleId")
    public Object getPermissionByRoleId(Integer roleId) {
        List<Permission> list = permissionService.getPermissionByRoleId(roleId);
        return new Result(list);
    }

    /**
     * 分配权限给角色
     */
    @PostMapping(value = "/assignPermissions")
    public Object assignPermissions(@RequestBody Map<String, Object> params) {
        Integer roleId = (Integer) params.get("roleId");
        @SuppressWarnings("unchecked")
        List<Integer> permissionIds = (List<Integer>) params.get("permissionIds");
        permissionService.assignPermissions(roleId, permissionIds);
        return new Result();
    }

    /**
     * 获取当前用户的菜单权限
     */
    @GetMapping(value = "/getUserMenuPermissions")
    public Object getUserMenuPermissions(HttpServletRequest request) {
        Integer userId = getUserIdFromCookie(request);
        if (userId == null) {
            return new Result(-1, "用户未登录");
        }
        List<Permission> list = permissionService.getMenuPermissionsByUserId(userId);
        return new Result(list);
    }

    /**
     * 获取当前用户的按钮权限
     */
    @GetMapping(value = "/getUserButtonPermissions")
    public Object getUserButtonPermissions(HttpServletRequest request) {
        Integer userId = getUserIdFromCookie(request);
        if (userId == null) {
            return new Result(-1, "用户未登录");
        }
        List<String> list = permissionService.getButtonPermissionsByUserId(userId);
        return new Result(list);
    }

    /**
     * 获取当前用户的所有权限
     */
    @GetMapping(value = "/getUserAllPermissions")
    public Object getUserAllPermissions(HttpServletRequest request) {
        Integer userId = getUserIdFromCookie(request);
        if (userId == null) {
            return new Result(-1, "用户未登录");
        }
        List<Permission> list = permissionService.getUserAllPermissions(userId);
        return new Result(list);
    }

    /**
     * 从Cookie获取用户ID
     */
    private Integer getUserIdFromCookie(HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if ("userId".equals(cookie.getName())) {
                    try {
                        return Integer.parseInt(cookie.getValue());
                    } catch (NumberFormatException e) {
                        return null;
                    }
                }
            }
        }
        return null;
    }
}
