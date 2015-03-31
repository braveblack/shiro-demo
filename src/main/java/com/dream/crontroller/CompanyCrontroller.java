package com.dream.crontroller;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONArray;
import com.beust.jcommander.internal.Maps;
import com.dream.entity.Organization;
import com.dream.entity.Page;
import com.dream.service.OrganizationService;

@Controller
@RequestMapping("/company")
public class CompanyCrontroller {
	@Autowired
	private OrganizationService organiztionService;
	
	@RequestMapping("/listCompany")
	@ResponseBody
	public String listCompany(@RequestParam(value="page",defaultValue="1" )Integer pageNo,@RequestParam(value="rows",defaultValue="1")Integer pageSize){
		List<Organization> listOrganization=organiztionService.findAll();
		return JSONArray.toJSONString(listOrganization);
	}
}
