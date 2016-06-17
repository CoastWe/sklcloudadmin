package com.skl.cloud.admin.service.system;

import java.util.Collections;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.skl.cloud.admin.dao.system.SysUserMapper;
import com.skl.cloud.admin.model.system.SysUser;
import com.skl.cloud.admin.service.common.BaseServiceImpl;
import com.skl.cloud.admin.service.common.PasswordHelper;

@Service
@Transactional
public class SysUserServiceImpl extends BaseServiceImpl<SysUser> implements SysUserService{
	
    @Autowired
    private PasswordHelper passwordHelper;
    @Autowired
    private SysRoleService roleService;
    
    @Autowired(required=true)
    public void setSysUserMapper(SysUserMapper sysUserMapper){
    	setBaseMapper(sysUserMapper);
    }

    
	@Override
	public void create(SysUser entity) {
		// TODO Auto-generated method stub
		passwordHelper.encryptPassword(entity);
		super.create(entity);
	}

	@Override
	public void changePassword(Long id, String newPassword) {
		// TODO Auto-generated method stub
        SysUser user =super.findOneById(id);
        user.setPassword(newPassword);
        passwordHelper.encryptPassword(user);
		super.update(user);
	}

	@Override
	public SysUser findByUsername(String username) {
		// TODO Auto-generated method stub
		SysUser user = new SysUser();
		user.setUsername(username);
		return super.findOne(user);
	}

	@Override
	public Set<String> findRoles(String username) {
		// TODO Auto-generated method stub
        SysUser user =findByUsername(username);
        if(user == null) {
            return Collections.emptySet();
        }
        return roleService.findRoles(user.getRoleIds().toArray(new Long[0]));
	}

	@Override
	public Set<String> findPermissions(String username) {
		// TODO Auto-generated method stub
        SysUser user =findByUsername(username);
        if(user == null) {
            return Collections.emptySet();
        }
        return roleService.findPermissions(user.getRoleIds().toArray(new Long[0]));
	}
}
