package com.douzone.jblog.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.douzone.jblog.service.SiteService;
import com.douzone.jblog.vo.SiteVo;

public class SiteInterceptor extends HandlerInterceptorAdapter {
	//@Autowired
	private SiteService siteService;
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		System.out.println("iii");
		/*SiteVo site = (SiteVo)request.getServletContext().getAttribute("site");
		if(site == null) {
			site = siteService.getSite();
			request.getServletContext().setAttribute("site", site);
		}*/

		return true;
	}
}
