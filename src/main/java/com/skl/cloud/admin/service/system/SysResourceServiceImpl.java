package com.skl.cloud.admin.service.system;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.shiro.authz.permission.WildcardPermission;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.skl.cloud.admin.dao.system.SysResourceMapper;
import com.skl.cloud.admin.dto.ComplexButton;
import com.skl.cloud.admin.model.system.SysResource;
import com.skl.cloud.admin.service.common.BaseServiceImpl;

@Service
@Transactional
public class SysResourceServiceImpl extends BaseServiceImpl<SysResource> implements SysResourceService{

    @Autowired(required=true)
    public void setSysUserMapper(SysResourceMapper sysResourceMapper){
    	setBaseMapper(sysResourceMapper);
    }
	
	@Override
	public Set<String> findPermissions(Set<Long> resourceIds) {
		// TODO Auto-generated method stub
        Set<String> permissions = new HashSet<String>();
        for(Long resourceId : resourceIds) {
            SysResource resource = findOneById(resourceId);
            if(resource != null && !StringUtils.isEmpty(resource.getPermission())) {
                permissions.add(resource.getPermission());
            }
        }
        return permissions;
	}

	@Override
	public List<ComplexButton> findMenus(Set<String> permissions) {
		// TODO Auto-generated method stub
        List<SysResource> allResources = findAll();
        Map<Long,ComplexButton> map = new LinkedHashMap<Long, ComplexButton>();
        for(SysResource resource : allResources) {
            if(resource.isRootNode()) {
                continue;
            }
            if(resource.getType() != SysResource.ResourceType.menu) {
                continue;
            }
            if(!hasPermission(permissions, resource)) {
                continue;
            }
            if(resource.getLevel() == 1){
            	ComplexButton complexButton = new ComplexButton();
            	complexButton.setResource(resource);
            	map.put(resource.getId(), complexButton);
            }else if (resource.getLevel() == 2){
            	map.get(resource.getParentId()).setSub_resources(resource);
            }
        }
        return new ArrayList<ComplexButton>(map.values());
	}
	
    private boolean hasPermission(Set<String> permissions, SysResource resource) {
        if(StringUtils.isEmpty(resource.getPermission())) {
            return true;
        }
        for(String permission : permissions) {
            WildcardPermission p1 = new WildcardPermission(permission);
            WildcardPermission p2 = new WildcardPermission(resource.getPermission());
            if(p1.implies(p2) || p2.implies(p1)) {
                return true;
            }
        }
        return false;
    }

}
