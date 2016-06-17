package com.skl.cloud.admin.service.system;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.skl.cloud.admin.dao.system.SysRoleMapper;
import com.skl.cloud.admin.model.system.SysRole;
import com.skl.cloud.admin.service.common.BaseServiceImpl;

@Service
@Transactional
public class SysRoleServiceImpl extends BaseServiceImpl<SysRole> implements SysRoleService{

    @Autowired
    private SysResourceService resourceService;
	
    @Autowired(required=true)
    public void setSysUserMapper(SysRoleMapper sysRoleMapper){
    	setBaseMapper(sysRoleMapper);
    }
    
	@Override
	public Set<String> findRoles(Long... roleIds) {
		// TODO Auto-generated method stub
        Set<String> roles = new HashSet<String>();
        for(Long roleId : roleIds) {
            SysRole role = findOneById(roleId);
            if(role != null) {
                roles.add(role.getRoleName());
            }
        }
        return roles;
	}

	@Override
	public Set<String> findPermissions(Long[] roleIds) {
		// TODO Auto-generated method stub
        Set<Long> resourceIds = new HashSet<Long>();
        for(Long roleId : roleIds) {
            SysRole role = findOneById(roleId);
            if(role != null) {
                resourceIds.addAll(role.getResourceIds());
            }
        }
        return resourceService.findPermissions(resourceIds);
	}
}
