package com.skl.cloud.admin.controller.common;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * controller的父类
 * @author weibin
 *
 */
@Controller
public class BaseController {
	
	@ExceptionHandler(ArithmeticException.class)
	@ResponseBody
	public String exceptionHandle(Exception ex, HttpServletRequest request, HttpServletResponse response) {
		return "parent";		
	}
}
