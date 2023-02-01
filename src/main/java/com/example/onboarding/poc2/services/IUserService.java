package com.example.onboarding.poc2.services;

import java.util.ArrayList;

import com.example.onboarding.poc2.model.UserModel;

public interface IUserService {

	public UserModel insert(String name);
	public ArrayList<UserModel> getAllUsers(String name);
}
