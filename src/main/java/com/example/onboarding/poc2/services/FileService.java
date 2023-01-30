package com.example.onboarding.poc2.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.onboarding.poc2.config.Config;
import com.example.onboarding.poc2.util.SftpUtil;


@Service
public class FileService implements IFileService{
	@Autowired
	Config config;
	
	@Override
	public void upload(MultipartFile file) throws Exception{
		try {
			SftpUtil sftp = new SftpUtil(config.getSftpHost(), config.getSftpPort(), config.getSftpUsername(), config.getSftpPassword(), config.getSftpFolder());
			String fileName = file.getOriginalFilename();
			String fileType = file.getContentType();
			byte[] fileContent = file.getBytes();
			
			String sftpPath = config.getSftpFolder().concat("/").concat(fileName);
			sftp.sftpPutFromStream(file.getInputStream(), sftpPath);
		} catch(Exception e) {
			throw e;
		}
	}
}
