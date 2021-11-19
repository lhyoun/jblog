package com.douzone.jblog.security;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.douzone.jblog.vo.UserVo;

public class AuthInterceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(
			HttpServletRequest request, 
			HttpServletResponse response, 
			Object handler)
			throws Exception {
		
		//1. handler 종류 확인
		if(handler instanceof HandlerMethod == false) {
			return true;
		}
		
		//2. casting
		HandlerMethod handlerMethod = (HandlerMethod)handler;
		
		//3. Handler Method의 @Auth 받아오기
		Auth auth = handlerMethod.getMethodAnnotation(Auth.class);
		
		//4. Handler Method에 @Auth가 없으면 Type에 있는 지 확인(과제)
		if(auth == null) {
			auth = handlerMethod.getMethod().getDeclaringClass().getAnnotation(Auth.class);
		}
		
		//5. Type과 Method에 @Auth가 적용이 안되어 있는 경우
		if(auth == null) {
			return true;
		}
		
		/*  인증이 필요한 경우
		    1. 로그인을 했는지 check => myblog
		    2. 로그인을 했고, 블로그의 주인이 맞는지 check => blog 관리
            2가지 경우가 있는데 각각을 type 1, 2로 구분
            
            type 1 : 로그인 여부만 체크
            type 2 : 로그인 여부 체크 후 블로그 주인 여부 체크  */
		
		HttpSession session = request.getSession();
		if(session == null) {
			response.sendRedirect(request.getContextPath() + "/user/login");
			return false;
		}
		// type 1. 세션에서 로그인 여부 체크 
		UserVo authUser = (UserVo)session.getAttribute("authUser");
		if(authUser == null) {
			// 로그인이 안 된 경우 로그인 페이지로 이동
			response.sendRedirect(request.getContextPath() + "/user/login");
			return false;
		}
		
		// type 2. type을 받아와서 2인 경우만 해당 
		int type = auth.type();
		//String user_id = auth.user_id();
		String user_id = request.getRequestURI().split("/")[2];
		
		if(type == 2) {
			if(!authUser.getId().equals(user_id)) {
				response.sendRedirect(request.getContextPath());
				return false;
			}
		}
		
		return true;
	}
}
