package com.dream.crontroller.account;

import java.util.List;
import java.util.Map;




import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.dream.entity.Page;
import com.dream.entity.User;
import com.dream.service.UserService;
import com.dream.vo.UserVo;
import com.google.common.collect.Maps;

@Controller
@RequestMapping("/account")
public class AccountController {
	@Autowired
	private UserService userService;
	
	@RequestMapping(value="listAccount",produces="text/html;charset=UTF-8")
	@ResponseBody
	public String listAccount(@RequestParam("page") Integer pageNo,
			@RequestParam("rows") Integer pageSize){
		Page page = new Page();
		page.setPageNo(pageNo);
		page.setPageSize(pageSize);
		Map<String, Object> map = Maps.newHashMap();
		List<UserVo> users=userService.findAllAccount();
		map.put("total", page.getTotalRecord());
		map.put("rows", users);
		return JSONObject.toJSON(map).toString();
	}
	
	@RequestMapping("/login")
	public String login(HttpServletRequest request,Model model){
		 	String exceptionClassName = (String)request.getAttribute("shiroLoginFailure");
	        String error = null;
	        if(UnknownAccountException.class.getName().equals(exceptionClassName)) {
	            error = "用户名/密码错误";
	        } else if(IncorrectCredentialsException.class.getName().equals(exceptionClassName)) {
	            error = "用户名/密码错误";
	        } else if(exceptionClassName != null) {
	            error = "其他错误：" + exceptionClassName;
	        }
	        model.addAttribute("error", error);
	        return "/login.jsp";
	}
	
}
