package com.dream.service;

import java.util.List;

import com.dream.entity.Organization;

public interface OrganizationService {
	 	public Organization createOrganization(Organization organization);
	    public Organization updateOrganization(Organization organization);
	    public void deleteOrganization(Long organizationId);
	    public List<Organization> findAll();
}
