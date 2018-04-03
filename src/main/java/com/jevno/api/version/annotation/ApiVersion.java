package com.jevno.api.version.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @title 		ApiVersion用于RequestMappingInfo拼接url
 * @description	规则：method优先级高于controller
 * @usage		
 * @copyright	Copyright 2018  marsmob Corporation. All rights reserved.
 * @company		marsmob
 * @author		jevno
 * @create		2018年4月3日下午6:13:40
 */
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface ApiVersion {
	String value() default "";
}
