package Test.daotest;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import Test.BaseTest;

import com.skl.cloud.admin.dao.system.SysResourceMapper;
import com.skl.cloud.admin.model.system.SysResource;
import com.skl.cloud.admin.model.system.SysResource.ResourceType;

public class SysResourceDaoTest extends BaseTest{
	@Autowired
	private SysResourceMapper sysResourceMapper;
	
	@Test
	public void testInsert(){
		SysResource sysResource = new SysResource();
		sysResource.setName("用户管理");
		sysResource.setUrl("/");
		sysResource.setType(ResourceType.menu);
		sysResource.setParentId(1l);
		System.out.println();
		sysResourceMapper.insert(sysResource);
	}
	@Test
	public void testUpdate(){
		SysResource sysResource = new SysResource();
		sysResource.setId(3696222237076905956l);
		sysResource.setName("用户管理11");
		sysResource.setUrl("/");
		sysResource.setType(ResourceType.menu);
		sysResource.setParentId(1l);
		System.out.println();
		sysResourceMapper.update(sysResource);
	}
	
	@Test
	public void testUpdateAllAttributes(){
		SysResource sysResource = new SysResource();
		sysResource.setId(3696222237076905956l);
		sysResource.setName("用户管理");
		sysResource.setUrl("/");
		sysResource.setType(ResourceType.button);
		sysResource.setParentId(1l);
		System.out.println();
		sysResourceMapper.updateAllAttributes(sysResource);
	}
	
	@Test
	public void testGetOne(){
		SysResource sysResource = new SysResource();
		sysResource.setId(3696124137555018567l);
//		sysResourceMapper.insert(sysResource);
		System.out.println(sysResourceMapper.getOne(sysResource));
	}
	
	@Test
	public void testGetAll(){
		SysResource sysResource = new SysResource();
		sysResource.setId(3696124137555018567l);
//		sysResourceMapper.insert(sysResource);
		System.out.println(sysResourceMapper.getAll());
	}
}
