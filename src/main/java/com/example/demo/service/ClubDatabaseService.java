package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.entity.Club;
import com.example.demo.entity.User;
import com.example.demo.repository.ClubRepository;
import com.example.demo.repository.UserRepository;

@Component
public class ClubDatabaseService implements ClubService {
	
	@Autowired
	UserRepository userRepos;
	
	@Autowired 
	ClubRepository clubRepos;

	@Override
	public List<Club> createClubMembership(Long userId, List<Club> clubs) {
		User user = userRepos.findById(userId).get();
		List<Club> result = new ArrayList<Club>();
		
		for(Club club: clubs) {
			club.setUser(user);
			result.add(clubRepos.save(club));
		}
		
		return result;
		
	}

}
