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

/* 해당 File에 대한 설명
   Jblog의 Blog관련 Contoller

   - 10/30 블로그 메인화면으로 이동. * 현재는 동일한 메인인데 유저 받아와서 특정 유저의 블로그로 가야 함
           블로그 관리 화면, 카테고리, 글쓰기. * 이것도 유저 받아와야 함. @Auth 설정 필요
        
*/

@Controller
@RequestMapping("/blog")
public class BlogConroller {
	
	@Autowired
	BlogService blogService;
	
	@Autowired
	CategoryService categoryService;
	
	// 블로그 메인화면으로 이동
	@GetMapping("")
	public String main() {
		return "/blog/blog-main";
	}
	
	// 블로그 관리화면으로 이동
	@GetMapping("admin")
	public String admin(String id, Model model) {
		
		BlogVo vo = blogService.findById("asd");
		System.out.println(vo);
		model.addAttribute("blogVo", vo);
		
		return "/blog/blog-admin-basic";
	}
	
	// 블로그 카테고리 관리화면으로 이동
	@GetMapping("category")
	public String category(String id, Model model) {
		
		List<CategoryVo> vo = categoryService.findById("asd");
		for(CategoryVo d:vo) {
			System.out.println(d);
		}
		model.addAttribute("list", vo);
		
		return "/blog/blog-admin-category";
	}
	
	// 블로그 글쓰기 화면으로 이동
	@GetMapping("write")
	public String write() {
		return "/blog/blog-admin-write";
	}
}
