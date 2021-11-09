package com.douzone.jblog.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.douzone.jblog.service.PostService;
import com.douzone.jblog.vo.PostVo;

/* 해당 File에 대한 설명
   Jblog의 Search관련 Contoller

*/

@Controller
@RequestMapping("/search")
public class SearchController {
	
	@Autowired
	PostService postService;
	
	/**
	 *  블로그 메인 - 검색결과 포함 
	 */
	@RequestMapping("")
	public String index(String keyword, Model model) {
		
		System.out.println(keyword);

		List<PostVo> list = postService.getSearchList("%"+keyword+"%");
		model.addAttribute("list", list);
		
		return "main/list";
	}	

	
	
	
}
