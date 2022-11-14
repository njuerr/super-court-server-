package com.hb0730.boot.admin.project.system.menu.controller;


import com.hb0730.boot.admin.annotation.ClassDescribe;
import com.hb0730.boot.admin.annotation.PreAuth;
import com.hb0730.boot.admin.domain.controller.SuperSimpleBaseController;
import com.hb0730.boot.admin.domain.result.R;
import com.hb0730.boot.admin.domain.result.Result;
import com.hb0730.boot.admin.project.system.menu.model.dto.MenuDTO;
import com.hb0730.boot.admin.project.system.menu.model.dto.TreeMenuDTO;
import com.hb0730.boot.admin.project.system.menu.model.entity.MenuEntity;
import com.hb0730.boot.admin.project.system.menu.model.query.MenuParams;
import com.hb0730.boot.admin.project.system.menu.model.vo.MenuPermissionVO;
import com.hb0730.boot.admin.project.system.menu.model.vo.VueMenuVO;
import com.hb0730.boot.admin.project.system.menu.service.IMenuService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 菜单  前端控制器
 *
 * @author Administrator
 * @since 3.0.0
 */
@RestController
@RequestMapping("/system/menu")
@PreAuth("menu")
@ClassDescribe("菜单管理")
public class MenuController extends SuperSimpleBaseController<Long, MenuDTO, MenuParams, MenuEntity> {
    private final IMenuService service;

    public MenuController(IMenuService service) {
        super(service);
        this.service = service;
    }

    /**
     * 菜单树形展示
     *
     * @return 菜单树形
     */
    @GetMapping("/query/tree")
    public Result<List<TreeMenuDTO>> queryTree() {
        List<TreeMenuDTO> treeMenu = service.queryTree();
        return R.success(treeMenu);
    }

    /**
     * 菜单权限树
     *
     * @return 菜单权限树
     */
    @GetMapping("/query/tree/permission")
    public Result<List<MenuPermissionVO>> queryMenuPermissionTree() {
        List<MenuPermissionVO> menuPermission = service.queryMenuPermissionTree();
        return R.success(menuPermission);
    }

    /**
     * 更新当前用户缓存
     *
     * @return 是否成功
     */
    @GetMapping("/update/current")
    public Result<String> updateCurrentMenu() {
        service.updateCurrentMenu();
        return R.success("更新成功");
    }

    /**
     * 获取当前用户所属菜单
     *
     * @return 菜单树
     */
    @GetMapping("/get/current/tree")
    public Result<List<TreeMenuDTO>> getCurrentMenu() {
        List<TreeMenuDTO> currentMenu = service.getCurrentMenu();
        List<TreeMenuDTO> treeMenu = service.buildTree(currentMenu);
        return R.success(treeMenu);
    }

    /**
     * 获取当前用户router
     *
     * @return vue router
     */
    @GetMapping("/get/current/router")
    public Result<List<VueMenuVO>> getCurrentRouter() {
        List<TreeMenuDTO> currentMenu = service.getCurrentMenu();
        List<TreeMenuDTO> treeMenu = service.buildTree(currentMenu);
        List<VueMenuVO> routerMenu = service.buildVueMenus(treeMenu);
        return R.success(routerMenu);
    }
}

