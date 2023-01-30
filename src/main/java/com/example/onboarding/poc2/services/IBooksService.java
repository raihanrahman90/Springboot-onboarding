package com.example.onboarding.poc2.services;

import java.util.concurrent.Future;

import com.example.onboarding.poc2.model.BooksModel;


public interface IBooksService {

	public BooksModel insert(String title, String description, String author);

	public Future<BooksModel> insertLongTime(String title, String description, String author);
}
