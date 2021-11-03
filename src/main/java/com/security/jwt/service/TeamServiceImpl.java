package com.security.jwt.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.security.jwt.models.ni_team;
import com.security.jwt.repository.TeamRepository;

@Service
public class TeamServiceImpl implements TeamService{
	
	@Autowired
	private TeamRepository teamRepository;
	@Override
	public List<ni_team> getAllTeams(){
		//return teamRepository.findAll();
		return teamRepository.findAll();
	}		
	@Override
	public ni_team saveTeam(ni_team team) {
		return teamRepository.save(team);
	}
	@Override
	public void deleteTeam(Long id) {
		teamRepository.deleteById(id);
	}

	
	
}
