package com.skl.cloud.admin.dto;

/**
 * 返回json的通用类
 * @author weibin
 *
 * @param <T>
 */
public class Result <T>{
	private String code;
	private String Message;
	private T date;
	
	
	
	public Result() {
		super();
	}

	public Result(String code, T date) {
		super();
		this.code = code;
		this.date = date;
	}
		
	public Result(String code, String message) {
		super();
		this.code = code;
		Message = message;
	}

	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getMessage() {
		return Message;
	}
	public void setMessage(String message) {
		Message = message;
	}
	public T getDate() {
		return date;
	}
	public void setDate(T date) {
		this.date = date;
	}	
}
