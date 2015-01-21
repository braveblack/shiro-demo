package com.dream.dao;

import java.util.List;

import com.dream.entity.Resource;

public interface ResourceDao {
	public Resource createResource(Resource resource);
    public int updateResource(Resource resource);
    public void deleteResource(Long resourceId);

    Resource findOne(Long resourceId);
    List<Resource> findAll();
}
