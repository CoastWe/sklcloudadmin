package servicetest;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.skl.cloud.admin.service.system.TestService;

import Test.BaseTest;

public class test extends BaseTest{
	
	@Autowired
	private TestService test;
	
	@Test
	public void testInsert(){
	test.say();
	}
}
