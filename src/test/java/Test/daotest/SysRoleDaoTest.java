package Test.daotest;

import java.util.Date;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.skl.cloud.admin.dao.system.SysRoleMapper;
import com.skl.cloud.admin.model.system.SysRole;
import com.skl.cloud.admin.model.system.SysUser;

import Test.BaseTest;

public class SysRoleDaoTest extends BaseTest{
	
	@Autowired
	private SysRoleMapper sysRoleMapper;
	
	
	@Test
	public void testInsert(){
		SysRole role = new SysRole();
		role.setRoleName("admin");
		role.setDescription("11");
		sysRoleMapper.insert(role);
	}
	@Test
	public void testUpdate(){
		SysRole role = new SysRole();
		role.setRoleName("admin");
		role.setDescription("11");
		role.setCreateTime(new Date());
		sysRoleMapper.update(role);
	}
	
	@Test
	public void testUpdateAllAttributes(){
		SysRole role = new SysRole();
		role.setRoleName("admin");
		role.setDescription("11");
		role.setCreateTime(new Date());
		role.setResourceIdsStr("1,2,3");
		sysRoleMapper.updateAllAttributes(role);
	}
	
	@Test
	public void testGetOne(){
		SysRole role = new SysRole();
		role.setRoleName("admin");
		;
		System.out.println(sysRoleMapper.getOne(role));
	}
	
	@Test
	public void testGetAll(){
		SysRole role = new SysRole();
		role.setRoleName("admin");
		;
		System.out.println(sysRoleMapper.getAll());
	}

}
