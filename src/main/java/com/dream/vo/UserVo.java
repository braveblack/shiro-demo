package com.dream.vo;

import java.util.List;

import com.dream.entity.Role;

public class UserVo {
	private Long id; //编号
    private Long organizationId; //所属公司
    private String organizationName;
    private String username; //用户名
    private String salt; //加密密码的盐
    private List<Role> listRole; //拥有的角色列表
    private Boolean locked = Boolean.FALSE;
    
    
   
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getOrganizationId() {
		return organizationId;
	}
	public void setOrganizationId(Long organizationId) {
		this.organizationId = organizationId;
	}
	public String getOrganizationName() {
		return organizationName;
	}
	public void setOrganizationName(String organizationName) {
		this.organizationName = organizationName;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getSalt() {
		return salt;
	}
	public void setSalt(String salt) {
		this.salt = salt;
	}
	public List<Role> getListRole() {
		return listRole;
	}
	public void setListRole(List<Role> listRole) {
		this.listRole = listRole;
	}
	public Boolean getLocked() {
		return locked;
	}
	public void setLocked(Boolean locked) {
		this.locked = locked;
	}
    
    
    
    
    
}
