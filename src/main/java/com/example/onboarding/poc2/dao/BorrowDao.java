package com.example.onboarding.poc2.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.onboarding.poc2.model.BorrowModel;

public interface BorrowDao extends JpaRepository<BorrowModel, Long>{

}
