package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Team;
import com.example.demo.service.TeamService;


@RestController
public class TeamController {

	@Autowired TeamService teamService;
	
	@PostMapping(path = "/teams/create")
	public Team createTeam(@RequestBody Team team) {
		return teamService.createTeam(team);
	}
	
	@GetMapping("/teams")
	public List<Team> getTeams(){
		return teamService.getTeams();
	}
}
