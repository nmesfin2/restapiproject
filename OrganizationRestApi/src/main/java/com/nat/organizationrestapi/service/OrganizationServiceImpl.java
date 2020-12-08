package com.nat.organizationrestapi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nat.organizationrestapi.model.Organization;
import com.nat.organizationrestapi.repository.OrganizationRepository;

@Service
public class OrganizationServiceImpl implements OrganizationService {

	@Autowired
	OrganizationRepository organizationRepository;
	
	@Override
	public Organization addOrganization(Organization organization) {
		// TODO Auto-generated method stub
		Organization organization2 = null;
		try {
			organization = organizationRepository.save(organization);
			return organization;
		}catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	@Override
	public Optional<Organization> getOrganizationById(long id) {
		// TODO Auto-generated method stub
		return organizationRepository.findById(id);
	}

	@Override
	public void deleteOrganization(long id) {
		// TODO Auto-generated method stub
		organizationRepository.deleteById(id);
	}

	@Override
	public Optional<List<Organization>> getOrganizations() {
		// TODO Auto-generated method stub
		return Optional.ofNullable(organizationRepository.findAll());
	}

}
