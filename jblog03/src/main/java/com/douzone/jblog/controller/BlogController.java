package com.douzone.jblog.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
   - 11/2  블로그 header, footer 1회만 application이나 session에 담아두도록 변경하기
   - 11/3  글쓰기 : 완료
           카테고리 : 카테고리 추가는 되는데 추가 후 화면 랜더링 안됨 / 카테고리 삭제 안됨
           기본설정 :      
           블로그정보 매번 받아오는데 한 번만 받아오게 수정해야 함
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
	
	/**
	 *  블로그 메인 
	 */
	// 블로그 메인화면으로 이동
	@GetMapping("{blogId}/{postId}")
	public String main(@PathVariable("blogId") String blogId, @PathVariable("postId") Long postId, Model model ) {
		
		// blogId로 id, title, logo 받아옴
		BlogVo blogVo = blogService.findById(blogId);
		model.addAttribute("blogVo", blogVo);
		// 나중에 바꿔야 함		
		
		// blogId로 포스트 찾아서 담아주기
		List<PostVo> postVoList = postService.findAllById(blogId);
		model.addAttribute("list", postVoList);
		
		// postId로 상단에 보여줄 게시물 담아주기
		PostVo postVo = postService.findByNo(postId);
		model.addAttribute("postVo", postVo);
		
		// blogId로 우측에 보여줄 카테고리 담아주기
		List<CategoryVo> categoryVo = categoryService.findById(blogId);
		model.addAttribute("category", categoryVo);
		
		return "/blog/blog-main";
	}
	
	/**
	 *  기본설정 
	 */
	// 블로그 관리화면으로 이동
	@GetMapping("{blogId}/admin/basic")
	public String admin(@PathVariable("blogId") String blogId, Model model) {
		
		BlogVo blogVo = blogService.findById(blogId);
		model.addAttribute("blogVo", blogVo);
		// 나중에 바꿔야 함
		
		return "/blog/blog-admin-basic";
	}
	
	/**
	 *  카테고리(insert, delete는 API Controller) 
	 */
	// 블로그 카테고리 관리화면으로 이동
	@GetMapping("{blogId}/admin/category")
	public String category(@PathVariable("blogId") String blogId, Model model) {
		
		BlogVo blogVo = blogService.findById(blogId);
		model.addAttribute("blogVo", blogVo);
		// 나중에 바꿔야 함
		
		List<CategoryVo> categoryVo = categoryService.findById(blogId);
		model.addAttribute("list", categoryVo);
		
		return "/blog/blog-admin-category";
	}
	
	/**
	 *  글작성
	 */
	// 블로그 글쓰기 화면으로 이동
	@GetMapping("{blogId}/admin/write")
	public String write(@PathVariable("blogId") String blogId, Model model) {
		
		BlogVo blogVo = blogService.findById(blogId);
		model.addAttribute("blogVo", blogVo);
		// 나중에 바꿔야 함
		
		List<CategoryVo> categoryVo = categoryService.findById(blogId);
		model.addAttribute("list", categoryVo);
		
		return "/blog/blog-admin-write";
	}
	
	// 블로그 글쓰기
	@PostMapping("{blogId}/admin/write")
	public String write(@PathVariable("blogId") String blogId, PostVo postVo) {
		
		postVo.setUser_id(blogId);
		postService.write(postVo);
		
		return "/blog/blog-admin-write";
	}
}
