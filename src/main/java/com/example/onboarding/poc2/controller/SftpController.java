package com.example.onboarding.poc2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.onboarding.poc2.dto.ResponseDTO;
import com.example.onboarding.poc2.services.IFileService;


@RestController
@RequestMapping("/sftp")
public class SftpController {

	@Autowired
	IFileService fileService;
	
	@RequestMapping(path = "/upload", method = RequestMethod.POST, consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public ResponseDTO upload(@RequestPart(value = "file") MultipartFile file) {
		ResponseDTO response = new ResponseDTO();
		try {
			fileService.upload(file);
			response.setCode("200");
			response.setMessage("Upload success");
		} catch(Exception e) {
			response.setCode("500");
			response.setMessage("upload failed");
		}
		return response;
	}
}
