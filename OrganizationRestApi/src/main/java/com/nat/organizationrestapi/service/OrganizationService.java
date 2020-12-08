package com.nat.organizationrestapi.service;

import java.util.Optional;

import com.nat.organizationrestapi.model.Organization;

public interface OrganizationService {
	public Organization addOrganization(Organization organization);
	public Optional<Organization> getOrganizationById(long id);
	public void deleteOrganization(long id);
	public Optional<java.util.List<Organization>> getOrganizations();
}
