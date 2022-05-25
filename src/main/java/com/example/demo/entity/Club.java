package com.example.demo.entity;

import java.sql.Date;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
public class Club {

	@JsonProperty("club")
	@EmbeddedId
	private ClubId clubId;

	//this is accept the json input in the format 13-12-2020, else it would expect in the format 2012-04-23T18:25:43.511Z
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
	private Date startDate;

	//this is accept the json input in the format 13-12-2020, else it would expect in the format 2012-04-23T18:25:43.511Z
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
	private Date endDate;


	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	
	public ClubId getClubId() {
		return clubId;
	}

	public void setClubId(ClubId clubId) {
		this.clubId = clubId;
	}

	public Long getUser_Id() {
		return this.clubId.getUser().getId();
	}
	
	public String getUser_Name() {
		return this.clubId.getUser().getName();
	}


	@JsonIgnore
	public User getUser() {
		return this.clubId.getUser();
	}

	public void setUser(User user) {
		this.clubId.setUser(user);
	}



}
