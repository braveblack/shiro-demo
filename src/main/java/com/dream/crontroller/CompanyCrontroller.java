package com.dream.crontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONArray;
import com.dream.entity.Organization;
import com.dream.service.OrganizationService;

@Controller
@RequestMapping("/company")
public class CompanyCrontroller {
	@Autowired
	private OrganizationService organiztionService;
	
	@RequestMapping("/listCompany")
	@ResponseBody
	public String listCompany(){
		List<Organization> listOrganization=organiztionService.findAll();
		return JSONArray.toJSONString(listOrganization);
	}
}
