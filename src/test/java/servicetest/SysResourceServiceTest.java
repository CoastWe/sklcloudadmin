package servicetest;

import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.skl.cloud.admin.model.system.SysResource;
import com.skl.cloud.admin.model.system.SysUser;
import com.skl.cloud.admin.service.system.SysResourceService;
import com.skl.cloud.admin.service.system.SysRoleService;
import com.skl.cloud.admin.service.system.SysUserService;

import Test.BaseTest;

public class SysResourceServiceTest extends BaseTest{
	
	@Autowired
	private SysResourceService sysUserService;
		
	@Test
	public void testInsert(){
		SysResource user = new SysResource();
		sysUserService.create(user);
//		sysUserService.saveOrUpdate(user);
	}
	@Test
	public void testUpdate(){
		SysResource user = new SysResource();
		sysUserService.update(user);
	}
	
	@Test
	public void testUpdateAllAttributes(){
		SysResource user = new SysResource();
		sysUserService.updateAllAttributes(user);
	}
	
	@Test
	public void testGetOne(){
		SysResource user = new SysResource();
		user = sysUserService.findOne(user);
		System.out.println(user);
	}
	
	@Test
	public void testGetOneById(){
		SysResource user = new SysResource();
		user = sysUserService.findOneById(3696240024769711823l);
		System.out.println(user);
	}
	
	@Test
	public void testGetALL(){
		List<SysResource> list = sysUserService.findAll();
		System.out.println(list);
	}
}
