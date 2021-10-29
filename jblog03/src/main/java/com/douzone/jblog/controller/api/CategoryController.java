package com.douzone.jblog.controller.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.douzone.jblog.dto.JsonResult;
import com.douzone.jblog.service.CategoryService;
import com.douzone.jblog.vo.CategoryVo;

@RestController("categoryApiController")
@RequestMapping("/category/api")
public class CategoryController {
	@Autowired
	private CategoryService categoryService;
	
	@PostMapping("/add")
	public ResponseEntity<?> checkemail(@RequestBody CategoryVo vo) {
		
		vo.setBlog_id("asd");
		
		categoryService.addCategory(vo);
		
		return new ResponseEntity<String>("성공", HttpStatus.OK);
		
		//return JsonResult.success(categoryService.addCategory(vo) != true);
	}
	
}
