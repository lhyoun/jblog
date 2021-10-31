package com.douzone.jblog.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.douzone.jblog.service.BlogService;
import com.douzone.jblog.service.CategoryService;
import com.douzone.jblog.service.PostService;
import com.douzone.jblog.vo.BlogVo;
import com.douzone.jblog.vo.CategoryVo;
import com.douzone.jblog.vo.PostVo;

/* 해당 File에 대한 설명
   Jblog의 Blog관련 Contoller

   - 10/30 블로그 메인화면으로 이동. * 현재는 동일한 메인인데 유저 받아와서 특정 유저의 블로그로 가야 함
           블로그 관리 화면, 카테고리, 글쓰기. * 이것도 유저 받아와야 함. @Auth 설정 필요
   - 10/31 블로그 메인화면 완료, 관리 화면, 카테고리, 글쓰기 유저 받아오기 및 path 설정 완료
           
                
*/

@Controller
@RequestMapping("")
public class BlogController {
	
	@Autowired
	BlogService blogService;
	
	@Autowired
	CategoryService categoryService;
	
	@Autowired
	PostService postService;
	
	@RequestMapping("")
	public String index() {
		return "main/index";
	}	
	
	// 블로그 메인화면으로 이동
	@GetMapping("{blogId}")
	public String main(@PathVariable("blogId") String blogId, Model model ) {
		
		// blogId로 id, title, logo 받아옴
		BlogVo blogVo = blogService.findById(blogId);
		model.addAttribute("blogVo", blogVo);
		
		return "/blog/blog-main";
	}
	
	// 블로그 관리화면으로 이동
	@GetMapping("{blogId}/admin/basic")
	public String admin(@PathVariable("blogId") String blogId, Model model) {
		
		BlogVo blogVo = blogService.findById(blogId);
		model.addAttribute("blogVo", blogVo);
		
		return "/blog/blog-admin-basic";
	}
	
	// 블로그 카테고리 관리화면으로 이동
	@GetMapping("{blogId}/admin/category")
	public String category(@PathVariable("blogId") String blogId, Model model) {
		
		List<CategoryVo> categoryVo = categoryService.findById(blogId);
		model.addAttribute("list", categoryVo);
		
		BlogVo blogVo = blogService.findById(blogId);
		model.addAttribute("blogVo", blogVo);
		
		return "/blog/blog-admin-category";
	}
	
	// 블로그 글쓰기 화면으로 이동
	@GetMapping("{blogId}/admin/write")
	public String write(@PathVariable("blogId") String blogId, Model model) {
		
		List<CategoryVo> categoryVo = categoryService.findById(blogId);
		model.addAttribute("list", categoryVo);
		
		BlogVo blogVo = blogService.findById(blogId);
		model.addAttribute("blogVo", blogVo);
		
		return "/blog/blog-admin-write";
	}
	
	// 블로그 글쓰기
	@PostMapping("{blogId}/admin/write")
	public String write(@PathVariable("blogId") String blogId, PostVo postVo) {
		
		postVo.setUser_id(blogId);
		//postService.
		
		return "/blog/blog-admin-write";
	}
}
