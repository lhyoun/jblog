package com.douzone.jblog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.douzone.jblog.service.BlogService;
import com.douzone.jblog.vo.BlogVo;

@Controller
@RequestMapping("/blog")
public class BlogConroller {
	
	@Autowired
	BlogService blogService;
	
	@GetMapping("")
	public String main() {
		return "/blog/blog-main";
	}
	
	@GetMapping("admin")
	public String admin(String id, Model model) {
		
		BlogVo vo = blogService.findById("asd");
		System.out.println(vo);
		model.addAttribute("blogVo", vo);
		
		return "/blog/blog-admin-basic";
	}
	
	@GetMapping("category")
	public String category() {
		return "/blog/blog-admin-category";
	}
	
	@GetMapping("write")
	public String write() {
		return "/blog/blog-admin-write";
	}
}
