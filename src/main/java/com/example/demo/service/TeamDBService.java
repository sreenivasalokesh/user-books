package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.entity.Team;
import com.example.demo.repository.TeamRepository;


@Component
public class TeamDBService implements TeamService {
	
	@Autowired TeamRepository teamRepository;

	@Override
	public Team createTeam(Team team) {
		return teamRepository.save(team);
	}
	
	 @Override
	public List<Team> getTeams() {
		return teamRepository.findAll();
	}

}
