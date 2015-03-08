package com.dream.crontroller;

import java.util.Set;

import javax.servlet.http.HttpSession;

import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.dream.entity.User;
import com.dream.service.ResourceService;
import com.dream.service.UserService;


@Controller
@RequestMapping("/menu")
public class MenuController {
	@Autowired
	private ResourceService resourceService;
	@Autowired
    private UserService userService;
	//
	@RequestMapping(value="/listMenu",produces="text/html;charset=UTF-8")
	@ResponseBody
	public String listMenu(HttpSession session){
		 	String username = (String)SecurityUtils.getSubject().getPrincipal();
		  	Set<String> permissions = userService.findPermissions(username);
		  	JSONArray menus = resourceService.findMenus(permissions);
	        return menus.toString();
	}
	
}
