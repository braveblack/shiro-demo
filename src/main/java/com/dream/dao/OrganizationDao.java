package com.dream.dao;

import java.util.List;

import com.dream.entity.Organization;

public interface OrganizationDao {
	public Organization createOrganization(Organization organization);
    public int updateOrganization(Organization organization);
    public void deleteOrganization(Long organizationId);

    Organization findOne(Long organizationId);
    List<Organization> findAll();

    List<Organization> findAllWithExclude(Organization excludeOraganization);

    void move(Organization source, Organization target);
}
