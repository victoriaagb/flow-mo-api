package com.flow.mo.api.adaptor;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.DeleteObjectRequest;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.amazonaws.services.s3.model.PutObjectResult;

@Service
public class AmazonClient {
	
	private static Logger logger = LoggerFactory.getLogger(AmazonClient.class);
	
	private AmazonS3 s3client;

    @Value("${aws.url}")
    private String endpointUrl;
    
    @Value("${aws.bucket.flow}")
    private String bucketName;
    
    @Value("${aws.accessKey.id}")
    private String accessKey;
    
    @Value("${aws.accessKey.secret}")
    private String secretKey;

    @PostConstruct
    private void initializeAmazon() {
       AWSCredentials credentials = new BasicAWSCredentials(this.accessKey, this.secretKey);
       this.s3client = AmazonS3ClientBuilder.standard()
    		   .withRegion("us-east-2")
    		   .withCredentials(new AWSStaticCredentialsProvider(credentials))
    		   .build();

    }
    
    private File convertMultiPartToFile(MultipartFile file) throws IOException {
        File convFile = new File(file.getOriginalFilename());
        FileOutputStream fos = new FileOutputStream(convFile);
        fos.write(file.getBytes());
        fos.close();
        return convFile;
    }
    
    private String generateFileName(MultipartFile multiPart) {
        String fileName = new Date().getTime() + "-" + multiPart.getOriginalFilename().replace(" ", "_");
        logger.info("file name: " + fileName);
        return fileName;
    }
    
    private void uploadFileTos3bucket(String fileName, File file) {
        PutObjectResult result = s3client.putObject(new PutObjectRequest(bucketName, fileName, file)
                .withCannedAcl(CannedAccessControlList.PublicRead));
        logger.info("Upload File Result: " + result);
    }

	public String uploadFile(MultipartFile multipartFile) {
		String fileUrl = "";
	    try {
	        File file = convertMultiPartToFile(multipartFile);
	        String fileName = generateFileName(multipartFile);
	        fileUrl = endpointUrl + "/" + bucketName + "/" + fileName;
	        uploadFileTos3bucket(fileName, file);
	        file.delete();
	    } catch (Exception e) {
	       e.printStackTrace();
	    }
	    return fileUrl;
	}

	public String deleteFileFromS3Bucket(String fileUrl) {
		String fileName = fileUrl.substring(fileUrl.lastIndexOf("/") + 1);
	    s3client.deleteObject(new DeleteObjectRequest(bucketName, fileName));
	    logger.info("Deleted File: " + fileName);
	    return "Successfully deleted";
	}

}
