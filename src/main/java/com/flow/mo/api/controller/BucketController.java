package com.flow.mo.api.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.flow.mo.api.service.AmazonClient;

@RestController
@RequestMapping("/storage")
public class BucketController {
	
	private static Logger logger = LoggerFactory.getLogger(BucketController.class);
	
	private AmazonClient amazonClient;
	
	@Autowired
    BucketController(AmazonClient amazonClient) {
        this.amazonClient = amazonClient;
    }
	
	@PostMapping("/uploadFile")
    public String uploadFile(@RequestPart(value = "file") MultipartFile file) {
        return this.amazonClient.uploadFile(file);
    }
	
	@DeleteMapping("/deleteFile")
    public String deleteFile(@RequestPart(value = "url") String fileUrl) {
        return this.amazonClient.deleteFileFromS3Bucket(fileUrl);
    }
}