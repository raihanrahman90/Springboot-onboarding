package com.example.onboarding.poc2.controller;

import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.onboarding.poc2.dao.BooksDao;
import com.example.onboarding.poc2.dto.OptionsDTO;
import com.example.onboarding.poc2.services.BooksService;
import com.example.onboarding.poc2.services.IBooksService;


@SpringBootTest
public class BooksControllerMockitoTest {

	@Mock
	BooksDao booksDao;

	@InjectMocks
	IBooksService booksService = new BooksService();

	@DisplayName("Test Mock find ddl")
	@Test
	void testFindDDL() {
		List<OptionsDTO> expected = new ArrayList<>();
		expected.add(new OptionsDTO("test2".concat(" - ").concat("test author2"), 1));

		when(booksDao.findDDLTitle()).thenReturn(expected);

		Assertions.assertEquals(expected.size(), booksDao.findDDLTitle().size());
		Assertions.assertArrayEquals(expected.toArray(), booksDao.findDDLTitle().toArray());
	}

}
