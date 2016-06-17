package com.skl.cloud.admin.controller;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.skl.cloud.admin.dto.ComplexButton;
import com.skl.cloud.admin.foundation.spring.mvc.annotation.CurrentUser;
import com.skl.cloud.admin.model.system.SysResource;
import com.skl.cloud.admin.model.system.SysUser;
import com.skl.cloud.admin.service.system.SysResourceService;
import com.skl.cloud.admin.service.system.SysUserService;

@Controller
public class IndexController {
	
    @Autowired
    private SysResourceService resourceService;
    @Autowired
    private SysUserService userService;

    @RequestMapping("/")
    public String index(@CurrentUser SysUser loginUser, Model model) {
        Set<String> permissions = userService.findPermissions(loginUser.getUsername());
        List<ComplexButton> menus = resourceService.findMenus(permissions);
        model.addAttribute("menus", menus);
        return "index";
    }

    @RequestMapping("/welcome")
    public String welcome() {
        return "welcome";
    }
}
