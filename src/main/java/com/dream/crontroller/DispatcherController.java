package com.dream.crontroller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/dream")
public class DispatcherController {

	@RequestMapping("/login")
	public String loginJsp() {
		System.out.println("aaaaaaaaaaaaa");
		return "/login.jsp";
	}
}

