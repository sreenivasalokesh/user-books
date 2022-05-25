package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Club;

public interface ClubService {
	public List<Club> createClubMembership(Long userId, List<Club> clubs);

}
