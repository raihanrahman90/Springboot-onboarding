package com.example.onboarding.poc2.services;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import org.springframework.transaction.annotation.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.onboarding.poc2.dao.BooksDao;
import com.example.onboarding.poc2.model.BooksModel;

@Service
public class BooksService implements IBooksService{

	@Autowired
	BooksDao booksDao;

	private ExecutorService executor = Executors.newFixedThreadPool(2);

	@Transactional
	@Override
	public BooksModel insert(String title, String description, String author) {
		try {
			BooksModel books = booksDao.save(new BooksModel(title, description, author));
			return books;
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	public Future<BooksModel> insertLongTime(String title, String description, String author) {
		return executor.submit(() -> {
			Thread.sleep(10000);
			return insert(title, description, author);
		});
	}
}
