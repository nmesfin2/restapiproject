package com.nat.organizationrestapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nat.organizationrestapi.model.Organization;

@Repository
public interface OrganizationRepository extends JpaRepository<Organization, Long> {

}
