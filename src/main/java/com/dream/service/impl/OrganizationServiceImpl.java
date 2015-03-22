package com.dream.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.dream.dao.OrganizationDao;
import com.dream.entity.Organization;
import com.dream.service.OrganizationService;
@Component
public class OrganizationServiceImpl implements OrganizationService {
	@Autowired
	private OrganizationDao organizationDao;
	
	public Organization createOrganization(Organization organization) {
		// TODO Auto-generated method stub
		return null;
	}

	public Organization updateOrganization(Organization organization) {
		// TODO Auto-generated method stub
		return null;
	}

	public void deleteOrganization(Long organizationId) {
		// TODO Auto-generated method stub

	}

	public List<Organization> findAll() {
		return organizationDao.findAll();
	}

}
