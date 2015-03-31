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
	@RequestMapping("/organization")
    public String organizationDispatcher() {
        return "/organization/organizationManager.jsp";
    }
	@RequestMapping("/resource")
    public String resourceDispatcher() {
        return "/resource/resourceManager.jsp";
    }
	@RequestMapping("/role")
    public String roleDispatcher() {
        return "/role/roleManager.jsp";
    }
}
