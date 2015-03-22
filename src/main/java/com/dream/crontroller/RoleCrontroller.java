package com.dream.crontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONArray;
import com.dream.entity.Role;
import com.dream.service.RoleService;
@Controller
@RequestMapping("/role")
public class RoleCrontroller {
	@Autowired
	private RoleService roleService;
	
	@RequestMapping("/listRole")
	@ResponseBody
	public String listRole(){
		List<Role> listRole=roleService.findAll();
		return JSONArray.toJSONString(listRole);
	}
}
