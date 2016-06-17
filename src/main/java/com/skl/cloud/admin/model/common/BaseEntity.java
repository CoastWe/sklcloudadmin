package com.skl.cloud.admin.model.common;

import org.apache.commons.lang3.builder.ToStringBuilder;


public class BaseEntity {
	
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, CustomToStringStyle.DEFAULT_STYLE);
	}
}
