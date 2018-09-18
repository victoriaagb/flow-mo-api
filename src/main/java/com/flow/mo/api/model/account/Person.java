package com.flow.mo.api.model.account;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Field;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.flow.mo.api.model.choreography.Choreography;
import com.flow.mo.api.model.collection.Collection;

public class Person {
	
	@Id
	@Field("person_id")
	@JsonProperty("person_id")
	private String personId;
	
	@JsonProperty("first_name")
	private String firstName;
	
	@JsonProperty("last_name")
	private String lastName;
	
	@JsonProperty("phone_number")
	private String phoneNumber;
	
	@Indexed
	private String email;
	
	private List<Collection> collections;
	
	private List<Choreography> choreographies;
	
	public String getPersonId() {
		return personId;
	}

	public void setPersonId(String id) {
		this.personId = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<Collection> getCollections() {
		return collections;
	}

	public void setCollections(List<Collection> collections) {
		this.collections = collections;
	}

	public List<Choreography> getChoreographies() {
		return choreographies;
	}

	public void setChoreographies(List<Choreography> choreographies) {
		this.choreographies = choreographies;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
}