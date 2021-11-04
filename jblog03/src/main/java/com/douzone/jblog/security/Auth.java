package com.douzone.jblog.security;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface Auth {
	/*
		1. 로그인을 했는지 check => myblog
		2. 로그인을 했고, 블로그의 주인이 맞는지 check => blog 관리
	*/
	public int type() default 1;
	//public String user_id() default "";
	
}
