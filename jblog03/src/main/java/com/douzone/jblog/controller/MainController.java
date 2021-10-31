package com.douzone.jblog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/* 해당 File에 대한 설명
   Jblog의 메인화면 Contoller
   
   - 10/30 메인화면으로 이동
   - 10/31 @RequestMapping 수정 
*/

@Controller
@RequestMapping({"/main"})
public class MainController {

	@RequestMapping("")
	public String index() {
		return "main/index";
	}	
}
