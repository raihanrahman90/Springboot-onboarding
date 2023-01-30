package com.example.onboarding.poc2.services;

import org.springframework.web.multipart.MultipartFile;

public interface IFileService {
	public void upload(MultipartFile file) throws Exception;
}
