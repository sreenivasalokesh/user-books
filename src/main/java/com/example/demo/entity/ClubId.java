package com.example.demo.entity;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.example.demo.util.Facilities;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Embeddable
public class ClubId implements Serializable{

	@Enumerated(EnumType.STRING)
	private Facilities facility;

	@ManyToOne
	@JoinColumn(name = "user_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "user_club_fk"))
	@JsonIgnore
	private User user;

	public Facilities getFacility() {
		return facility;
	}

	public void setFacility(Facilities facility) {
		this.facility = facility;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	
}
