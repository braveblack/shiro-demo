package com.dream.crontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONArray;
import com.dream.entity.Resource;
import com.dream.service.ResourceService;

@Controller
@RequestMapping("/resource")
public class ResourceController {
	@Autowired
	private ResourceService resourceService;
	
	
	@RequestMapping("/listResource")
	@ResponseBody
	public String listResource(){
		List<Resource> listResource=resourceService.findAll();
		return JSONArray.toJSONString(listResource);
	}
}
