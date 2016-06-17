package com.skl.cloud.admin.controller.system;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.skl.cloud.admin.model.system.SysUser;
import com.skl.cloud.admin.service.system.SysRoleService;
import com.skl.cloud.admin.service.system.SysUserService;

@Controller
@RequestMapping("/user")
public class SysUserController {
    @Autowired
    private SysUserService sysUserService;  
    @Autowired
    private SysRoleService sysRoleService;
    
    @RequiresPermissions("system:user:create")
    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public String showCreateForm(Model model) {
        setCommonData(model);
        model.addAttribute("user", new SysUser());
        model.addAttribute("op", "新增");
        return "user/edit";
    }

    @RequiresPermissions("system:user:create")
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String create(SysUser user, RedirectAttributes redirectAttributes) {
        sysUserService.create(user);
        redirectAttributes.addFlashAttribute("msg", "新增成功");
        return "redirect:/user";
    }

    @RequiresPermissions("system:user:update")
    @RequestMapping(value = "/{id}/update", method = RequestMethod.GET)
    public String showUpdateForm(@PathVariable("id") Long id, Model model) {
        setCommonData(model);
        model.addAttribute("user", sysUserService.findOneById(id));
        model.addAttribute("op", "修改");
        return "user/edit";
    }

    @RequiresPermissions("system:user:update")
    @RequestMapping(value = "/{id}/update", method = RequestMethod.POST)
    public String update(SysUser user, RedirectAttributes redirectAttributes) {
        sysUserService.update(user);
        redirectAttributes.addFlashAttribute("msg", "修改成功");
        return "redirect:/user";
    }

    @RequiresPermissions("system:user:delete")
    @RequestMapping(value = "/{id}/delete", method = RequestMethod.GET)
    public String showDeleteForm(@PathVariable("id") Long id, Model model) {
        setCommonData(model);
        model.addAttribute("user", sysUserService.findOneById(id));
        model.addAttribute("op", "删除");
        return "user/edit";
    }

    @RequiresPermissions("system:user:delete")
    @RequestMapping(value = "/{id}/delete", method = RequestMethod.POST)
    public String delete(@PathVariable("id") Long id, RedirectAttributes redirectAttributes) {
        sysUserService.delete(id);
        redirectAttributes.addFlashAttribute("msg", "删除成功");
        return "redirect:/user";
    }


    @RequiresPermissions("system:user:update")
    @RequestMapping(value = "/{id}/changePassword", method = RequestMethod.GET)
    public String showChangePasswordForm(@PathVariable("id") Long id, Model model) {
        model.addAttribute("user", sysUserService.findOneById(id));
        model.addAttribute("op", "修改密码");
        return "user/changePassword";
    }

    @RequiresPermissions("user:update")
    @RequestMapping(value = "/{id}/changePassword", method = RequestMethod.POST)
    public String changePassword(@PathVariable("id") Long id, String newPassword, RedirectAttributes redirectAttributes) {
        sysUserService.changePassword(id, newPassword);
        redirectAttributes.addFlashAttribute("msg", "修改密码成功");
        return "redirect:/user";
    }

    private void setCommonData(Model model) {
        model.addAttribute("roleList", sysRoleService.findAll());
    }
}
