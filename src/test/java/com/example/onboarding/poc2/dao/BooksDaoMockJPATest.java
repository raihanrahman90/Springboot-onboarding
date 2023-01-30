package com.example.onboarding.poc2.dao;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import com.example.onboarding.poc2.dto.OptionsDTO;
import com.example.onboarding.poc2.model.BooksModel;

@DataJpaTest
public class BooksDaoMockJPATest {
	@Autowired
	private TestEntityManager entityManager;
	
	@Autowired
	private BooksDao booksDao;
	
	@BeforeEach
	public void init() {
		BooksModel book = new BooksModel("test2", "test description2", "test author");
		entityManager.persist(book);
		
		entityManager.flush();
	}
	
	@Test
	public void test_findByTitle() {
		List<BooksModel> found = booksDao.findByTitle("test2");
		
		BooksModel result = null;
		if(found.size()>0) {
			result = found.get(0);
		}
		assertThat(result.getTitle())
		.isEqualTo("test2");
	}
	
	@Test
	public void test_findDDLTitle() {
		List<OptionsDTO> found = booksDao.findDDLTitle();
		List<OptionsDTO> expected = new ArrayList<>();
		expected.add(new OptionsDTO("test2".concat(" - ").concat("test author2"), 1));
		
		assertThat(found.size()).isEqualTo(expected.size());
	}
}
