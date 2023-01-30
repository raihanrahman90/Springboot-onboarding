package com.example.onboarding.poc2.model;

import jakarta.persistence.*;

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
	
	public BooksModel() {
		
	}
	
	public BooksModel(String title, String descriptione, String author) {
		this.title = title;
		this.description = description;
		this.author = author;
	}
	public long getId() {
		return id;
	}
	public String getTitlte() {
		return this.title;
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
