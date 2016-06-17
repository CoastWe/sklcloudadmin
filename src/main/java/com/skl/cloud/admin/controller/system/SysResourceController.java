package com.skl.cloud.admin.controller.system;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.skl.cloud.admin.model.system.SysResource;
import com.skl.cloud.admin.service.system.SysResourceService;

@Controller
@RequestMapping("/resource")
public class SysResourceController {
	   @Autowired
	    private SysResourceService resourceService;

	    @ModelAttribute("types")
	    public SysResource.ResourceType[] resourceTypes() {
	        return SysResource.ResourceType.values();
	    }

	    @RequiresPermissions("system:resource:view")
	    @RequestMapping(value="/list",method = RequestMethod.GET)
	    public String list(Model model) {
	        model.addAttribute("resourceList", resourceService.findAll());
	        return "resource/list";
	    }

	    @RequiresPermissions("system:resource:create")
	    @RequestMapping(value = "/{parentId}/appendChild", method = RequestMethod.GET)
	    public String showAppendChildForm(@PathVariable("parentId") Long parentId, Model model) {
	        SysResource parent = resourceService.findOneById(parentId);
	        model.addAttribute("parent", parent);
	        SysResource child = new SysResource();
	        child.setParentId(parentId);
	        child.setParentIds(parent.makeSelfAsParentIds());
	        model.addAttribute("resource", child);
	        model.addAttribute("op", "新增子节点");
	        return "resource/edit";
	    }

	    @RequiresPermissions("system:resource:create")
	    @RequestMapping(value = "/{parentId}/appendChild", method = RequestMethod.POST)
	    public String create(SysResource resource, RedirectAttributes redirectAttributes) {
	        resourceService.create(resource);
	        redirectAttributes.addFlashAttribute("msg", "新增子节点成功");
	        return "redirect:/resource";
	    }

	    @RequiresPermissions("system:resource:update")
	    @RequestMapping(value = "/{id}/update", method = RequestMethod.GET)
	    public String showUpdateForm(@PathVariable("id") Long id, Model model) {
	        model.addAttribute("resource", resourceService.findOneById(id));
	        model.addAttribute("op", "修改");
	        return "resource/edit";
	    }

	    @RequiresPermissions("system:resource:update")
	    @RequestMapping(value = "/{id}/update", method = RequestMethod.POST)
	    public String update(SysResource resource, RedirectAttributes redirectAttributes) {
	        resourceService.update(resource);
	        redirectAttributes.addFlashAttribute("msg", "修改成功");
	        return "redirect:/resource";
	    }

	    @RequiresPermissions("system:resource:delete")
	    @RequestMapping(value = "/{id}/delete", method = RequestMethod.GET)
	    public String delete(@PathVariable("id") Long id, RedirectAttributes redirectAttributes) {
	        resourceService.delete(id);
	        redirectAttributes.addFlashAttribute("msg", "删除成功");
	        return "redirect:/resource";
	    }
}
