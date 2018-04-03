package com.jevno.api.version.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import com.jevno.api.version.core.VersionOperator;

/**
 * @title 		TerminalVersion用于RequestMappingInfo
 * @description	获取客户端传递过来的版本号
 * @usage		
 * @copyright	Copyright 2018  marsmob Corporation. All rights reserved.
 * @company		marsmob
 * @author		jevno
 * @create		2018年4月3日下午6:13:40
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface TerminalVersion {
	
	int[] terminals() default {};
	
	VersionOperator op() default VersionOperator.NIL;
	
	String version() default "";
}
