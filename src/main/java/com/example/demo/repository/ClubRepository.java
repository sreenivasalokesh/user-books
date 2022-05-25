package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Club;
import com.example.demo.entity.ClubId;

public interface ClubRepository extends JpaRepository<Club, ClubId>{

}
