package com.dream.vo;

import java.util.List;

import com.dream.entity.Resource;

public class RoleVo {
    private Long id; //编号
    private String role; //角色标识 程序中判断使用,如"admin"
    private String description; //角色描述,UI界面显示使用
    private Boolean available = Boolean.FALSE; //是否可用,如果不可用将不会添加给用户
    private List<Resource> listResources;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Boolean getAvailable() {
		return available;
	}
	public void setAvailable(Boolean available) {
		this.available = available;
	}
	public List<Resource> getListResources() {
		return listResources;
	}
	public void setListResources(List<Resource> listResources) {
		this.listResources = listResources;
	}
    
}
    
    
