package com.example.onboarding.poc2.model;


import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;


@Entity
@Table(name="books")
public class BooksModel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name="title")
	private String title;
	
	@Column(name = "description")
	private String description;
	
	@Column(name = "author")
	private String author;
	
	@JsonManagedReference
	@OneToMany(mappedBy="books")
	private List<BorrowModel> borrow = new ArrayList<>();
	
	public BooksModel() {
		
	}

	public BooksModel(String title, String descriptione, String author) {
		this.title = title;
		this.description = description;
		this.author = author;
		this.borrow = new ArrayList<BorrowModel>();
	}
	public long getId() {
		return id;
	}
	public String getTitlte() {
		return this.title;
	}
	@JsonManagedReference(value="book-borrow")
	public List<BorrowModel> getBorrow() {
		return borrow;
	}

	public void setBorrow(List<BorrowModel> borrow) {
		this.borrow = borrow;
	}

	public String getDescription() {
		return this.description;
	}
	public String getAuthor() {
		return this.author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setId(long id) {
		this.id = id;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	@Override
	public String toString() {
		return "Books [Id="+this.id+", Title="+this.title+", description="+this.description+", author="+this.author+"]";
	}
}
