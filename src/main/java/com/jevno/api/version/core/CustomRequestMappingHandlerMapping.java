package com.jevno.api.version.core;

import java.lang.reflect.Method;

import org.apache.commons.lang3.StringUtils;
import org.springframework.core.annotation.AnnotatedElementUtils;
import org.springframework.web.servlet.mvc.condition.RequestCondition;
import org.springframework.web.servlet.mvc.method.RequestMappingInfo;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import com.jevno.api.version.annotation.ApiVersion;
import com.jevno.api.version.annotation.ClientVersion;

/**
 * @title 		CustomRequestMappingHandlerMapping
 * @description	自定义查找url对应的处理方法
 * @usage		
 * @copyright	Copyright 2018  marsmob Corporation. All rights reserved.
 * @company		marsmob
 * @author		jevno
 * @create		2018年4月3日下午10:25:40
 */
public class CustomRequestMappingHandlerMapping extends RequestMappingHandlerMapping{

	@Override
	protected RequestMappingInfo getMappingForMethod(Method method, Class<?> handlerType)
	{
		RequestMappingInfo requestMappingInfo = super.getMappingForMethod(method, handlerType);
		if(null != requestMappingInfo)
		{
			RequestMappingInfo apiVersionRequestMappingInfo = getApiVersionMappingInfo(method, handlerType);
			return null == apiVersionRequestMappingInfo ? requestMappingInfo : apiVersionRequestMappingInfo.combine(requestMappingInfo);
		}
		return requestMappingInfo;
	}
	
	/**
	 * 查找有ApiVersion注解的RequestMappingInfo
	 * method 优先级别高于controller
	 * @param method
	 * @param handlerType
	 * @return
	 */
	protected RequestMappingInfo getApiVersionMappingInfo(Method method, Class<?> handlerType)
	{
		//优先查找method上是否有ApiVersion注解
		ApiVersion apiVersion = AnnotatedElementUtils.findMergedAnnotation(method, ApiVersion.class);
		if(null == apiVersion || StringUtils.isBlank(apiVersion.value()))
		{
			apiVersion = AnnotatedElementUtils.findMergedAnnotation(handlerType, ApiVersion.class);
		}
		return null == apiVersion || StringUtils.isBlank(apiVersion.value()) 
					? null : RequestMappingInfo.paths(apiVersion.value()).build();
	}
	
	/**
	 * 重新定义类上注解clientversion的匹配条件
	 */
	@Override
	protected RequestCondition<?> getCustomTypeCondition(Class<?> handlerType)
	{
		ClientVersion clientVersion = AnnotatedElementUtils.findMergedAnnotation(handlerType, ClientVersion.class);
		return createRequestCondtion(clientVersion);
	}
	
	/**
	 * 重新定义方法上注解clientversion的匹配条件
	 */
	@Override
	protected RequestCondition<?> getCustomMethodCondition(Method method)
	{
		ClientVersion clientVersion = AnnotatedElementUtils.findMergedAnnotation(method, ClientVersion.class);
		return createRequestCondtion(clientVersion);
	}
	
	protected RequestCondition<?> createRequestCondtion(ClientVersion clientVersion)
	{
		if(null == clientVersion)
		{
			return null;
		}
		
		if(null != clientVersion.value() && clientVersion.value().length > 0)
		{
			return null;
		}
		
		if(null != clientVersion.expression() && clientVersion.expression().length > 0)
		{
			return null;
		}
		
		return null;
	}

}
