package com.security.jwt.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.security.jwt.exceptions.ResourceNotFoundException;
import com.security.jwt.models.ni_project_npi;
import com.security.jwt.repository.ProjectRepository;


@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api")
public class ProjectController {


	@Autowired
	private ProjectRepository projectRepository;
	
	// get all employees
	@GetMapping("/project")
	public List<ni_project_npi> getAllProjects(){
		return projectRepository.findAll();
	}		
	
	// create employee rest api
	@PostMapping("/project")
	public ni_project_npi createProject(@RequestBody ni_project_npi project) {
		return projectRepository.save(project);
	}
	
	// get employee by id rest api
	@GetMapping("/project/{project_id}")
	public ResponseEntity<ni_project_npi> getProjectById(@PathVariable Long project_id) {
		ni_project_npi project = projectRepository.findById(project_id)
				.orElseThrow(() -> new ResourceNotFoundException("project not exist with id :" + project_id));
		return ResponseEntity.ok(project);
	}
	
	// update employee rest api
	
	@PutMapping("/project/{project_id}")
	public ResponseEntity<ni_project_npi> updateProject(@PathVariable Long project_id, @RequestBody ni_project_npi projectDetails){
		ni_project_npi project = projectRepository.findById(project_id)
				.orElseThrow(() -> new ResourceNotFoundException("project not exist with id :" + project_id));
		
		
		project.setUser_id(projectDetails.getUser_id());
		project.setTeam(projectDetails.getTeam());
		project.setNpiid(projectDetails.getNpiid());
		project.setFinid(projectDetails.getFinid());
		project.setName(projectDetails.getName());
		project.setDescription(projectDetails.getDescription());
		project.setYr1rev(projectDetails.getYr1rev());
		project.setYr2rev(projectDetails.getYr2rev());
		project.setInvestment(projectDetails.getInvestment());
		
		ni_project_npi updatedEmployee = projectRepository.save(project);
		
		return ResponseEntity.ok(updatedEmployee);
	}
	
	// delete employee rest api
	@DeleteMapping("/project/{project_id}")
	public ResponseEntity<Map<String, Boolean>> deleteProject(@PathVariable Long project_id){
		ni_project_npi project = projectRepository.findById(project_id)
				.orElseThrow(() -> new ResourceNotFoundException("project not exist with id :" + project_id));
		
		projectRepository.delete(project);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}
	
	
}