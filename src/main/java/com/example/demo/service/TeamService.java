package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Team;

public interface TeamService {

	public Team createTeam(Team team);
	
	public List<Team> getTeams();
}
