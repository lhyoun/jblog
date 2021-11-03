package com.douzone.jblog.controller.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.douzone.jblog.service.CategoryService;
import com.douzone.jblog.vo.CategoryVo;

/* 해당 File에 대한 설명
   Jblog의 Category관련 APIContoller

   - 11/3 카테고리 추가 : user_id 받아와서 넣어줘야 함
          카테고리 삭제 : 완료
          공통 : return type을 JsonResult로 수정해야 함

*/

@RestController("categoryApiController")
@RequestMapping("/category/api")
public class CategoryController {
	@Autowired
	private CategoryService categoryService;
	
	// 카테고리 추가
	@PostMapping("/add")
	public ResponseEntity<?> addCategory(@RequestBody CategoryVo vo) {
		
		vo.setBlog_id("asd");
		
		categoryService.addCategory(vo);
		
		return new ResponseEntity<String>("성공", HttpStatus.OK);
		
		//return JsonResult.success(categoryService.addCategory(vo) != true);
	}

	// 카테고리 삭제
	@DeleteMapping("/delete")
	public ResponseEntity<?> deleteCategory(int no) {
		
		categoryService.deleteCategory(no);
		
		return new ResponseEntity<String>("성공", HttpStatus.OK);
		
		//return JsonResult.success(categoryService.addCategory(vo) != true);
	}
	
}
