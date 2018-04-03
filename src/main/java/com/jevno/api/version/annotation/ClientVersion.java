package com.jevno.api.version.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @title 		ClientVersion用于RequestMappingInfo
 * @description	获取客户端传递过来的版本号
 * @usage		
 * @copyright	Copyright 2018  marsmob Corporation. All rights reserved.
 * @company		marsmob
 * @author		jevno
 * @create		2018年4月3日下午6:13:40
 */
@Target({ElementType.METHOD,ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface ClientVersion {
	
	TerminalVersion[] value() default {};

	String[] expression() default {};//从string表达式解析，和上述效果一致
}
