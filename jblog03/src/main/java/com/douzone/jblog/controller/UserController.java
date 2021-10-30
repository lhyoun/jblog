package com.douzone.jblog.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.douzone.jblog.service.UserService;
import com.douzone.jblog.vo.UserVo;

/* 해당 File에 대한 설명
   Jblog의 User관련 Contoller

   - 10/30 회원가입 폼/진행/성공 
           로그인 화면으로 이동 *login/logout은 security-Login(out)Interceptor서 진행하고 경로는 spring-servlet에서 설정. 현재는 /user/auth, /user/logout
*/

@Controller
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UserService userService;
	
	/* [Get]join => 회원가입Form
	   @ModelAttribute UserVo vo는 [Post]join에서 Binding 문제가 생겨 다시 돌아올 경우
	   User 정보를 가지고 들어오는데, 그걸 model에 담아서 회원가입Form으로 가게 된다
	*/
	@GetMapping("/join")
	public String join(@ModelAttribute UserVo vo) {
		return "user/join";
	}
	
	/* [Post]join => 회원가입 진행
	   단, BindingResult result에 문제가 있으면 User 정보를 가지고 다시 [Get]join으로 돌아간다
	*/ 
	@RequestMapping(value="/join", method=RequestMethod.POST)
	public String join(@ModelAttribute @Valid UserVo vo, BindingResult result, Model model) {
		System.out.println("join");
		
		if(result.hasErrors()) {
			List<ObjectError> list = result.getAllErrors();
			for(ObjectError error : list) {
				System.out.println(error);
			}
			
			model.addAllAttributes(result.getModel());
			// model.addAttribute("userVo", vo);
			return "user/join";
		}
		
		userService.join(vo);
		return "redirect:/user/joinsuccess";
	}
	
	// 회원가입 성공 페이지
	@RequestMapping("/joinsuccess")
	public String joinsuccess() {
		return "user/joinsuccess";
	}
	
	// 로그인 화면으로 이동
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public String login() {
		return "user/login";
	}
	
	/*
	@Auth
	@RequestMapping(value="/update", method=RequestMethod.GET)
	public String update(@AuthUser UserVo authUser, Model model) {
		UserVo userVo = userService.getUser(authUser.getNo());
		model.addAttribute("userVo", userVo);
		
		return "user/update";
	}	

	@Auth
	@RequestMapping(value="/update", method=RequestMethod.POST)
	public String update(@AuthUser UserVo authUser, UserVo userVo) {
		userVo.setNo(authUser.getNo());

		userService.updateUser(userVo);
		authUser.setName(userVo.getName());
		
		return "redirect:/user/update";
	}	*/
}
