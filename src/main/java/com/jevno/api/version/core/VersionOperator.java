package com.jevno.api.version.core;

/**
 * @title 		VersionOperator
 * @description	版本比对枚举
 * @usage		
 * @copyright	Copyright 2018  marsmob Corporation. All rights reserved.
 * @company		marsmob
 * @author		jevno
 * @create		2018年4月3日下午10:13:20
 */
public enum VersionOperator {
	NIL(""),
	LT("<"),
	GT(">"),
	LTE("<="),
	GTE(">="),
	NE("!="),
	EQ("==");
	
	private String code;
	
	VersionOperator(String code)
	{
		this.code = code;
	}

	public String getCode()
	{
		return code;
	}

	public static VersionOperator parse(String code)
	{
		for (VersionOperator operator : VersionOperator.values())
		{
			if(operator.getCode().equalsIgnoreCase(code))
			{
				return operator;
			}
		}
		return null;
	}
}
