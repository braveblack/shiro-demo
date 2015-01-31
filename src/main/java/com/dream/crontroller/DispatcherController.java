package com.dream.crontroller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class DispatcherController {
	
	
	@RequestMapping("/")
    public String index() {
        return "/index.jsp";
    }
	@RequestMapping("/user")
    public String userDispatcher() {
        return "/account/accountManager.jsp";
    }
}