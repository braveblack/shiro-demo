package com.dream.service.impl;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

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

}
