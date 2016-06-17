package com.skl.cloud.admin.dto;

import java.util.ArrayList;
import java.util.List;

import com.skl.cloud.admin.model.system.SysResource;

public class ComplexButton extends Button{

	private List<SysResource> sub_resources;
	
	public List<SysResource> getSub_resources() {
		return sub_resources;
	}
	public void setSub_resources(SysResource resources) {
		if(sub_resources == null){
			sub_resources = new ArrayList<SysResource>();
		}
		sub_resources.add(resources);
	}
		
}
