package com.douzone.jblog.controller.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.douzone.jblog.dto.JsonResult;
import com.douzone.jblog.service.UserService;

@RestController("userApiController")
@RequestMapping("/user/api")
public class UserController {
	@Autowired
	private UserService userService;
	
	@GetMapping("/checkId")
	public JsonResult checkemail(@RequestParam(value="blogId", required=true, defaultValue="") String blogId) {
		
		System.out.println(userService.getUser(blogId));
		
		return JsonResult.SelectTest(userService.getUser(blogId));
	}
}
