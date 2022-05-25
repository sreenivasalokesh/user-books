package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Club;
import com.example.demo.service.ClubService;

@RestController
public class ClubController {
	
	@Autowired
	ClubService clubService;
	
	@PostMapping(path = "/users/{id}/clubs")
	public List<Club> addClubMembership(@PathVariable Long id, @RequestBody List<Club> clubs) {
		System.out.println("hit clubs");
		
		return clubService.createClubMembership(id, clubs);
		
		
	}

}
