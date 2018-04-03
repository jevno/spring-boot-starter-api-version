package com.jevno.api.version.core;

import org.springframework.boot.autoconfigure.web.WebMvcRegistrations;
import org.springframework.web.servlet.mvc.method.annotation.ExceptionHandlerExceptionResolver;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

public class CustomWebMvcRegistrations implements WebMvcRegistrations{

	@Override
	public ExceptionHandlerExceptionResolver getExceptionHandlerExceptionResolver()
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public RequestMappingHandlerAdapter getRequestMappingHandlerAdapter()
	{
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * 注入自定义路由映射
	 */
	@Override
	public RequestMappingHandlerMapping getRequestMappingHandlerMapping()
	{
		return new CustomRequestMappingHandlerMapping();
	}

}
