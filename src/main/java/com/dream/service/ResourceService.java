package com.dream.service;

import java.util.Set;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

public interface ResourceService {

	Set<String> findPermissions(Set<Long> resourceIds);

	JSONArray findMenus(Set<String> permissions);


}
