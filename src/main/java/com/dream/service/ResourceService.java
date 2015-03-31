package com.dream.service;

import java.util.List;
import java.util.Set;

import com.alibaba.fastjson.JSONArray;
import com.dream.entity.Resource;

public interface ResourceService {

	Set<String> findPermissions(Set<Long> resourceIds);

	JSONArray findMenus(Set<String> permissions);

	List<Resource> findAll();


}
