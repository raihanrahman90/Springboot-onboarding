package com.example.onboarding.poc2.model;

import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name="user")
public class UserModel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name="name")
	private String name;
	
	@JsonManagedReference
	@OneToMany(mappedBy="user")
	private List<BorrowModel> borrows;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return String.format("Users [Id=%s, Name=%2s]", this.id, this.name);
	}
	public UserModel(String name) {
		this.name = name;
	}
	public UserModel() {
		
	}
}
