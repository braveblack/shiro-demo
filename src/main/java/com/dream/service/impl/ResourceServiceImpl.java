package com.dream.service.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.shiro.authz.permission.WildcardPermission;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.dream.dao.ResourceDao;
import com.dream.entity.Resource;
import com.dream.service.ResourceService;
@Component
public class ResourceServiceImpl implements ResourceService {
	@Autowired
	private ResourceDao resourceDao;
	/*
	 * 根据资源id获取权限字符串
	 * @see com.dream.service.ResourceService#findPermissions(java.util.Set)
	 */
	public Set<String> findPermissions(Set<Long> resourceIds) {
		 Set<String> permissions = new HashSet<String>();
		Iterator it=resourceIds.iterator();
		while(it.hasNext()){
			long resourceId=(Long) it.next();
			Resource resource=resourceDao.findOne(resourceId);
			if(resource != null && !StringUtils.isEmpty(resource.getPermission())) {
                permissions.add(resource.getPermission());
            }
		}
		return permissions;
	}
	
	private List<Resource> findAll() {
		return resourceDao.findAll();
	}
	 /*
	 * 根据permission获取menu转换成easyui的字符串
	 * @see com.dream.service.ResourceService#findMenus(java.util.Set)
	 */
	public JSONArray findMenus(Set<String> permissions) {
		List<Resource> allResources = findAll();
		List<Resource> validResources=new ArrayList<Resource>();
		for(Resource resource : allResources) {
	            if(resource.getType() != Resource.ResourceType.menu) {
	                continue;
	            }
	            if(!hasPermission(permissions, resource)) {
	                continue;
	            }
	            validResources.add(resource);
	     }
		return addMenus(0,validResources);
	}
	public JSONArray addMenus(long parentId,List<Resource> validResources){
		JSONArray jsonArray=this.getMenusByParentId(parentId,validResources);
		for(int i=0;i<jsonArray.size();i++){
			JSONObject jsonObject=jsonArray.getJSONObject(i);
			if("open".equals(jsonObject.getString("state"))){
				continue;
			}else{
				jsonObject.put("children",addMenus(jsonObject.getLong("id"),validResources) );
			}
		}
		return jsonArray;
	}
	public JSONArray getMenusByParentId(long parentId,List<Resource> validResources){
		JSONArray jsonArray=new JSONArray();
		Iterator it=validResources.iterator();
		while(it.hasNext()){
			JSONObject jsonObject=new JSONObject();
			Resource resource=(Resource) it.next();
			if(parentId==resource.getParentId()){
				jsonObject.put("id",resource.getId());
				jsonObject.put("text", resource.getName());
				jsonObject.put("state", resource.getState());
				jsonObject.put("iconCls", resource.getIconCls());
				JSONObject attributeObject=new JSONObject();
				jsonObject.put("parentId", resource.getParentId());
				attributeObject.put("authPath", resource.getUrl());
				jsonObject.put("attributes", attributeObject);
				jsonArray.add(jsonObject);
			}
		}
		return jsonArray;
	}
	  private boolean hasPermission(Set<String> permissions, Resource resource) {
	        if(StringUtils.isEmpty(resource.getPermission())) {
	            return true;
	        }
	        for(String permission : permissions) {
	            WildcardPermission p1 = new WildcardPermission(permission);
	            WildcardPermission p2 = new WildcardPermission(resource.getPermission());
	            if(p1.implies(p2) || p2.implies(p1)) {
	                return true;
	            }
	        }
	        return false;
	   }
	
}
