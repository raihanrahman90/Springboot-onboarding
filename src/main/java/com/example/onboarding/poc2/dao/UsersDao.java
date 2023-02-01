package com.example.onboarding.poc2.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.onboarding.poc2.model.BooksModel;
import com.example.onboarding.poc2.model.UserModel;

public interface UsersDao extends JpaRepository<UserModel, Long>{


	List<UserModel> findByName(String name);
}
