package com.douzone.jblog.controller.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.douzone.jblog.dto.JsonResult;
import com.douzone.jblog.service.UserService;

/* 해당 File에 대한 설명
   Jblog의 User관련 APIContoller

   - 11/3 blogId 중복체크 완료
 
*/

@RestController("userApiController")
@RequestMapping("/user/api")
public class UserController {
	@Autowired
	private UserService userService;
	
	@GetMapping("/checkId")
	public JsonResult checkId(@RequestParam(value="blogId", required=true, defaultValue="") String blogId) {
		
		return JsonResult.SelectTest(userService.getUser(blogId));
	}
}
