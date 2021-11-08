package com.douzone.jblog.controller.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.douzone.jblog.dto.JsonResult;
import com.douzone.jblog.security.Auth;
import com.douzone.jblog.service.CategoryService;
import com.douzone.jblog.vo.CategoryVo;

/* 해당 File에 대한 설명
   Jblog의 Category관련 APIContoller

   - 11/3 카테고리 추가 : user_id 받아와서 넣어줘야 함 -> 완료 / insert 후 화면 table 번호 안됨 
          카테고리 삭제 : 완료 -> 해당 카테고리의 post 처리 필요 / delete 후 화면 처리 안됨
          공통 : return type을 JsonResult로 수정해야 함 -> 완료
   - 11/4 권한 : uri에 blog_id를 넣어줘야 함

*/

@RestController("categoryApiController")
@RequestMapping("/category/api")
public class CategoryController {
	@Autowired
	private CategoryService categoryService;
	
	// 카테고리 추가
	//@Auth(type=2)
	@PostMapping("/add")
	public JsonResult addCategory(@RequestBody CategoryVo vo) {
		return JsonResult.notSelectTest(categoryService.addCategory(vo));
	}

	// 카테고리 삭제
	//@Auth(type=2)
	@DeleteMapping("/delete/{no}")
	public JsonResult deleteCategory(@PathVariable("no") int no) {
		System.out.println("aaaaa");
		return JsonResult.notSelectTest(categoryService.deleteCategory(no));
	}
	
}
