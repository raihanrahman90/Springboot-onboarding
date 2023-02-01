package com.example.onboarding.poc2.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name="borrow")
public class BorrowModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@JsonBackReference
	@ManyToOne
	@JoinColumn(name="booksId", referencedColumnName = "Id", insertable = false, updatable = false)
	private BooksModel books;
	private Integer booksId;
	
	@JsonBackReference
	@ManyToOne
	@JoinColumn(name="userId", referencedColumnName = "Id", insertable = false, updatable = false)
	private UserModel user;
	private Integer userId;

	public long getId() {
		return id;
	}
	@JsonBackReference(value="book-borrow")
	public Integer getBooksId() {
		return booksId;
	}

	public void setBooksId(Integer booksId) {
		this.booksId = booksId;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public void setId(long id) {
		this.id = id;
	}


	public BooksModel getBooks() {
		return books;
	}

	public void setBooks(BooksModel books) {
		this.books = books;
	}

	public UserModel getUser() {
		return user;
	}

	public void setUser(UserModel user) {
		this.user = user;
	}

	public void setBook(BooksModel book) {
		this.books = book;
	}
	public BorrowModel() {
		
	}
	public BorrowModel(UserModel user, BooksModel book) {
		this.books = book;
		this.user = user;
		
	}
}
