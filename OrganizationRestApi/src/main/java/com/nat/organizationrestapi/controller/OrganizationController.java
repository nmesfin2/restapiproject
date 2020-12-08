package com.nat.organizationrestapi.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import com.nat.organizationrestapi.exception.ResourceNotFoundException;
import com.nat.organizationrestapi.model.Organization;
import com.nat.organizationrestapi.service.OrganizationService;

@RestController
@RequestMapping("/api/v1/organization")
public class OrganizationController {

	@Autowired
	OrganizationService organizationService;
	
	@GetMapping
	public List<Organization> getOrganizations() {
		return organizationService.getOrganizations().get();
	}
	
	@GetMapping("/{organizationId}")
	public ResponseEntity<Organization> getOrganizationById(@PathVariable("organizationId") long organizationId) throws ResourceNotFoundException {
		Organization organization = organizationService.getOrganizationById(organizationId).orElseThrow(()-> new ResourceNotFoundException("Product not found"));
		
		return ResponseEntity.ok().body(organization);
	}
	
	@PostMapping
	public ResponseEntity<?> addOrganization(@RequestBody Organization organization,UriComponentsBuilder uriComponentsBuilder,HttpServletRequest request) {
	
		Organization organization2 = organizationService.addOrganization(organization);
		UriComponents uriComponents = uriComponentsBuilder
				.path(request.getRequestURI()+"/{id}")
				.buildAndExpand(organization2.getId());
	  return 	 ResponseEntity.created(uriComponents.toUri()).body(organization2);
	}
	
	@DeleteMapping("/{organizationId}")
	public Map<String, Boolean> deleteOrganizationById(@PathVariable long organizationId) throws ResourceNotFoundException { 
		Organization organization = organizationService.getOrganizationById(organizationId).orElseThrow(()-> new ResourceNotFoundException("Organization not found"));
		
		organizationService.deleteOrganization(organizationId);
		HashMap<String, Boolean> hashMap = new HashMap<>();
		hashMap.put("deleted", Boolean.TRUE);
		
		return hashMap;
	}
}