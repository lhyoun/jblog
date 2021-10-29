package com.douzone.jblog.controller;

import javax.servlet.ServletContext;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.douzone.jblog.exception.FileUploadException;
import com.douzone.jblog.security.Auth;
import com.douzone.jblog.service.FileUploadService;
import com.douzone.jblog.service.SiteService;
import com.douzone.jblog.vo.SiteVo;

@Auth(role="ADMIN")
@Controller
@RequestMapping("/admin")
public class AdminController {
	private static final Log LOGGER = LogFactory.getLog(AdminController.class);

	@Autowired
	private ServletContext servletContext;
	
	@Autowired
	private SiteService siteService;

	@Autowired
	private FileUploadService fileUploadService;

	@RequestMapping("")
	public String main(Model model) {
		SiteVo site = siteService.getSite();
		model.addAttribute("site", site);
		return "admin/main";
	}
	
	@RequestMapping("/main/update")
	public String main(SiteVo site, @RequestParam("file") MultipartFile file) {
		try {
			String profile = fileUploadService.restoreImage(file);
			site.setProfile(profile);
		} catch(FileUploadException ex) {
			LOGGER.info("Admin Main Update:" + ex);
		}
		
		siteService.update(site);
		servletContext.setAttribute("site", site);
		
		return "redirect:/admin";
	}	
	
	@RequestMapping("/guestbook")
	public String guestbook() {
		return "admin/guestbook";
	}

	@RequestMapping("/board")
	public String board() {
		return "admin/board";
	}

	@RequestMapping("/user")
	public String user() {
		return "admin/user";
	}
	
}
