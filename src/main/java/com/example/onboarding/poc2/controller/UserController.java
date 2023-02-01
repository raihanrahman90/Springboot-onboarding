package com.example.onboarding.poc2.controller;




import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.onboarding.poc2.dao.UsersDao;
import com.example.onboarding.poc2.dto.ResponseDTO;
import com.example.onboarding.poc2.services.IUserService;
import com.example.onboarding.poc2.model.*;

@RestController
@RequestMapping("/user")
public class UserController {
	private static final Logger log = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	UsersDao usersDao;
	
	@Autowired
	IUserService userService;
	
	@GetMapping("/get-users")
	public ResponseEntity<ArrayList<UserModel>> getAllUsers(@RequestParam(required=false) String name){
		try {
			ArrayList<UserModel> users = userService.getAllUsers(name);
			return new ResponseEntity<>(users, HttpStatus.OK);
		} catch(Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@PostMapping("/insert")
	public ResponseDTO insert(@RequestBody UserModel user) {
		ResponseDTO response = new ResponseDTO();
		try {
			UserModel userResponse = userService.insert(user.getName());
			response.setCode("200");
			response.setMessage("insert success");
			response.setData(userResponse);
		}catch(Exception e) {
			response.setCode("500");
			response.setMessage("Insert Failed");
		}
		return response;
	}
}
