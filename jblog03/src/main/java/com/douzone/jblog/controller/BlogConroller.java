package com.douzone.jblog.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.douzone.jblog.service.BlogService;
import com.douzone.jblog.service.CategoryService;
import com.douzone.jblog.vo.BlogVo;
import com.douzone.jblog.vo.CategoryVo;

@Controller
@RequestMapping("/blog")
public class BlogConroller {
	
	@Autowired
	BlogService blogService;
	
	@Autowired
	CategoryService categoryService;
	
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
	public String category(String id, Model model) {
		
		List<CategoryVo> vo = categoryService.findById("asd");
		for(CategoryVo d:vo) {
			System.out.println(d);
		}
		model.addAttribute("list", vo);
		
		return "/blog/blog-admin-category";
	}
	
	@GetMapping("write")
	public String write() {
		return "/blog/blog-admin-write";
	}
}
