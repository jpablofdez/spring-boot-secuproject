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
import com.security.jwt.models.ni_team;
import com.security.jwt.repository.TeamRepository;


@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api")
public class TeamController {


	@Autowired
	private TeamRepository teamRepository;
	
	// get all employees
	@GetMapping("/team")
	public List<ni_team> getAllTeams(){
		return teamRepository.findAll();
	}		
	
	// create employee rest api
	@PostMapping("/team")
	public ni_team createTeam(@RequestBody ni_team team) {
		return teamRepository.save(team);
	}
	
	// get employee by id rest api
	@GetMapping("/team/{team_id}")
	public ResponseEntity<ni_team> getTeamById(@PathVariable Long team_id) {
		ni_team team = teamRepository.findById(team_id)
				.orElseThrow(() -> new ResourceNotFoundException("team not exist with id :" + team_id));
		return ResponseEntity.ok(team);
	}
	
	// update employee rest api
	
	@PutMapping("/team/{team_id}")
	public ResponseEntity<ni_team> updateTeam(@PathVariable Long team_id, @RequestBody ni_team teamDetails){
		ni_team team = teamRepository.findById(team_id)
				.orElseThrow(() -> new ResourceNotFoundException("Team not exist with id :" + team_id));
		
		team.setTeam_name(teamDetails.getTeam_name());
		
		
		ni_team updatedEmployee = teamRepository.save(team);
		return ResponseEntity.ok(updatedEmployee);
	}
	
	// delete employee rest api
	@DeleteMapping("/team/{team_id}")
	public ResponseEntity<Map<String, Boolean>> deleteTeam(@PathVariable Long team_id){
		ni_team team = teamRepository.findById(team_id)
				.orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id :" + team_id));
		
		teamRepository.delete(team);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}
	
	
}