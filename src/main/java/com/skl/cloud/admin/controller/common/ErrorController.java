package com.skl.cloud.admin.controller.common;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.authz.UnauthenticatedException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.util.UrlPathHelper;

/**
 * 定义controller通用的异常捕获
 * @author weibin
 *
 */
@ControllerAdvice
public class ErrorController{
	
	private static Logger log = LoggerFactory.getLogger(ErrorController.class);
	private static final UrlPathHelper urlPathHelper = new UrlPathHelper();
	
    @ExceptionHandler(UnauthenticatedException.class)
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    @ResponseBody
    public String processUnauthenticatedException(NativeWebRequest request, UnauthenticatedException e) {  
        String url = urlPathHelper.getLookupPathForRequest((HttpServletRequest) request.getNativeRequest());
    	log.error("请求url{}失败",url,e); 
        return "viewName"; //返回一个逻辑视图名  
    }
    
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    public String processException(NativeWebRequest request, Exception e) {   
        String url = urlPathHelper.getLookupPathForRequest((HttpServletRequest) request.getNativeRequest());
    	log.error("请求url{}失败",url,e); 
        return "error"; //返回一个逻辑视图名  
    }  
}
