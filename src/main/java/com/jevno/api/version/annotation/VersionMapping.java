package com.jevno.api.version.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.springframework.core.annotation.AliasFor;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @title 		VersionMapping用于RequestMappingInfo
 * @description	ApiVersion和ClientVersion的组合
 * @usage		
 * @copyright	Copyright 2018  marsmob Corporation. All rights reserved.
 * @company		marsmob
 * @author		jevno
 * @create		2018年4月3日下午9:13:40
 */
@Target({ElementType.METHOD,ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@RequestMapping
@ApiVersion
@ClientVersion
public @interface VersionMapping {
	
	/**
	 * Alias for {@link RequestMapping#name}.
	 */
	@AliasFor(annotation = RequestMapping.class)
	String name() default "";
	
	/**
	 * Alias for {@link RequestMapping#value}.
	 */
	@AliasFor(annotation = RequestMapping.class)
	String[] value() default {};
	
	/**
	 * Alias for {@link RequestMapping#path}.
	 */
	@AliasFor(annotation = RequestMapping.class)
	String[] path() default {};
	
	/**
	 * Alias for {@link RequestMapping#params}.
	 */
	@AliasFor(annotation = RequestMapping.class)
	String[] params() default {};
	
	/**
	 * Alias for {@link RequestMapping#headers}.
	 */
	@AliasFor(annotation = RequestMapping.class)
	String[] headers() default {};
	
	/**
	 * Alias for {@link RequestMapping#consumes}.
	 */
	@AliasFor(annotation = RequestMapping.class)
	String[] consumes() default {};
	
	/**
	 * Alias for {@link RequestMapping#produces}.
	 */
	@AliasFor(annotation = RequestMapping.class)
	String[] produces() default {};
	
	@AliasFor(annotation = ApiVersion.class,attribute = "value")
	String apiVersion() default "";
	
	@AliasFor(annotation = ClientVersion.class,attribute = "value")
	TerminalVersion[] terminalVersion() default {};
	
	@AliasFor(annotation = ClientVersion.class,attribute = "expression")
	String[]  terminalExpression() default {};
}
