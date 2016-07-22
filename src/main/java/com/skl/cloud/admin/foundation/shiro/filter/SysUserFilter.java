package com.skl.cloud.admin.foundation.shiro.filter;

import java.util.List;
import java.util.Set;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.web.filter.PathMatchingFilter;
import org.springframework.beans.factory.annotation.Autowired;

import com.skl.cloud.admin.dto.ComplexButton;
import com.skl.cloud.admin.service.system.SysResourceService;
import com.skl.cloud.admin.service.system.SysUserService;

public class SysUserFilter extends PathMatchingFilter {

    @Autowired
    private SysUserService userService;
    @Autowired
    private SysResourceService resourceService;

    @Override
    protected boolean onPreHandle(ServletRequest request, ServletResponse response, Object mappedValue) throws Exception {

        String username = (String)SecurityUtils.getSubject().getPrincipal();
        @SuppressWarnings("unchecked")
		List<ComplexButton> menus = (List<ComplexButton>) SecurityUtils.getSubject().getSession().getAttribute("menus");
        request.setAttribute("user",userService.findByUsername(username));
        if(menus==null||menus.size()<=0){
            Set<String> permissions = userService.findPermissions(username);
            menus = resourceService.findMenus(permissions);
            SecurityUtils.getSubject().getSession().setAttribute("menus", menus);
        }
        request.setAttribute("menus", menus);
        return true;
    }
}
