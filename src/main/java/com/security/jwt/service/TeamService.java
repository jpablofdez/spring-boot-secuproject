package com.security.jwt.service;

import java.util.List;
import java.util.Optional;

import com.security.jwt.models.ni_team;

public interface TeamService {
	
	public List<ni_team> getAllTeams();
	public ni_team saveTeam(ni_team team);
	public void deleteTeam(Long id);

}
