package com.example.onboarding.poc2.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.onboarding.poc2.dao.UsersDao;
import com.example.onboarding.poc2.model.BooksModel;
import com.example.onboarding.poc2.model.UserModel;

@Service
public class UserService implements IUserService{
	@Autowired
	UsersDao userDao;
	@Override
	public UserModel insert(String name) {
		// TODO Auto-generated method stub@Transactional
		
		try {
			UserModel user = new UserModel(name);
			user = userDao.save(user);
			return user;
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	public ArrayList<UserModel> getAllUsers(String name) {
		// TODO Auto-generated method stub
		try {
			ArrayList<UserModel> users = new ArrayList<UserModel>();
			if(name == null) {
				userDao.findAll().forEach(users::add);
			}
			else {
				userDao.findByName(name).forEach(users::add);
			}
			return users;
		}catch(Exception e) {
			return new ArrayList<UserModel>();
		}
	}

}
