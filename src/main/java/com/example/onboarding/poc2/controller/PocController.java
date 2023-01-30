package com.example.onboarding.poc2.controller;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.onboarding.poc2.dto.ResponseDTO;


@RestController
public class PocController {
	@RequestMapping(value = "/hello", method = RequestMethod.POST)
	public ResponseDTO helloWorld(@RequestBody String name) {
		ResponseDTO response = new ResponseDTO();
		response.setCode("200");
		response.setMessage(HttpStatus.OK.toString());
		response.setData(String.format("Hello %s welcome", null));
		return response;
	}
	
	@RequestMapping(value = "/hello-world", method = RequestMethod.GET)
	public ResponseDTO helloWorld() {
		ResponseDTO response = new ResponseDTO();
		response.setCode("200");
		response.setMessage("Hello");
		return response;
	}
}
