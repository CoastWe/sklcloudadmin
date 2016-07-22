package servicetest;

import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.skl.cloud.admin.model.system.SysUser;
import com.skl.cloud.admin.service.system.SysUserService;

import Test.BaseTest;

public class SysUserServiceTest extends BaseTest{
	
	@Autowired
	private SysUserService sysUserService;
		
	@Test
	public void testInsert(){
		SysUser user = new SysUser();
		user.setUsername("admin123");
		user.setPassword("123456");
		user.setNickName("niha");
		user.setCreateTime(new Date());
		user.setLastLoginTime(new Date());
		user.setLoginTime(new Date());
		user.setRoleIdsStr("1");
		System.out.println("sys--"+sysUserService);
		sysUserService.create(user);
//		sysUserService.saveOrUpdate(user);
	}
	@Test
	public void testUpdate(){
		SysUser user = new SysUser();
		user.setUsername("admin");
		user.setPassword("123456");
		user.setNickName("11111");
		user.setCreateTime(new Date());
		user.setLastLoginTime(new Date());
		user.setRoleIdsStr("1");
		System.out.println("sys--"+sysUserService);
		sysUserService.update(user);
	}
	
	@Test
	public void testUpdateAllAttributes(){
		SysUser user = new SysUser();
		user.setUsername("weibin124");
		user.setPassword("123444");
		user.setNickName("1111111");
		user.setCreateTime(new Date());
		user.setLastLoginTime(new Date());
		user.setRoleIdsStr("1,3,4,5,4,8,9");
		System.out.println("sys--"+sysUserService);
		sysUserService.updateAllAttributes(user);
	}
	
	@Test
	public void testGetOne(){
		SysUser user = new SysUser();
		user.setUsername("weibin");
		user = sysUserService.findOne(user);
		System.out.println(user);
	}
	
	@Test
	public void testGetOneById(){
		SysUser user = new SysUser();
		user = sysUserService.findOneById(3696240024769711823l);
		System.out.println(user);
	}
	
	@Test
	public void testGetALL(){
		List<SysUser> list = sysUserService.findAll();
		System.out.println(list);
	}
}
