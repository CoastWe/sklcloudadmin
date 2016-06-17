package com.skl.cloud.admin.service.system;

import org.springframework.stereotype.Service;

@Service
public class TestServiceImpl implements TestService{

	@Override
	public void say() {
		// TODO Auto-generated method stub
		System.out.println("幼稚");
	}
	
}
