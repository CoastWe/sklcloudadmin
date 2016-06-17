package Test.daotest;

import java.util.Date;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.skl.cloud.admin.dao.system.SysUserMapper;
import com.skl.cloud.admin.model.system.SysUser;

import Test.BaseTest;

public class SysUserDaoTest extends BaseTest{
	@Autowired
	private SysUserMapper sysUserMapper;
	
	@Test
	public void testInsert(){
		SysUser user = new SysUser();
		user.setUsername("wangming");
		user.setPassword("123");
		user.setNickName("nihao");
		user.setCreateTime(new Date());
		user.setLastLoginTime(new Date());
		user.setLoginTime(new Date());
		user.setRoleIdsStr("1,3,4,5");
		sysUserMapper.insert(user);
	}
	@Test
	public void testUpdate(){
		SysUser user = new SysUser();
		user.setUsername("wangming");
		user.setPassword("123444");
		user.setNickName("1111111");
		user.setCreateTime(new Date());
		user.setLastLoginTime(new Date());
		user.setRoleIdsStr("1,3,4,5,4,8,9");
		System.out.println("sys--"+sysUserMapper);
		sysUserMapper.update(user);
	}
	
	@Test
	public void testUpdateAllAttributes(){
		SysUser user = new SysUser();
		user.setUsername("wangming");
		user.setPassword("123444");
		user.setNickName("1111111");
		user.setCreateTime(new Date());
		user.setLastLoginTime(new Date());
		user.setRoleIdsStr("1,3,4,5,4,8,9");
		System.out.println("sys--"+sysUserMapper);
		sysUserMapper.updateAllAttributes(user);
	}
	
	@Test
	public void testDelete(){
		SysUser user = new SysUser();
		user.setUsername("wangming");
		user.setPassword("123444");
		user.setNickName("1111111");
		user.setCreateTime(new Date());
		user.setLastLoginTime(new Date());
		user.setRoleIdsStr("1,3,4,5,4,8,9");
		System.out.println("sys--"+sysUserMapper);
		sysUserMapper.delete(3696222042609310781l);
	}
	
	@Test
	public void testGetOne(){
		SysUser user = new SysUser();
		user.setUsername("weibin");
		user = sysUserMapper.getOne(user);
		System.out.println(user);
	}
	
	@Test
	public void testGetAll(){
		SysUser user = new SysUser();
		user.setUsername("weibin");
		System.out.println(sysUserMapper.getAll());
	}
	
	
}
