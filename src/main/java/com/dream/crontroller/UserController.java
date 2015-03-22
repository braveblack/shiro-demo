package com.dream.crontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.dream.entity.Result;
import com.dream.entity.User;
import com.dream.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UserService userService;
	
	@RequestMapping("/userSave")
	@ResponseBody
	public String userSave(User user,@RequestParam("roleId") long[] roleIds){
		userService.userSave(user,roleIds);
		return JSONObject.toJSONString(new Result("添加成功"));
	}
	
	@RequestMapping("/userUpdate")
	@ResponseBody
	public String userUpdate(User user,@RequestParam("roleId")long[] roleIds){
		userService.userUpdate(user,roleIds);
		return JSONObject.toJSONString(new Result("修改成功"));
	}
}
