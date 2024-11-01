package com.vits.EventCalendar.services;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.PutObjectRequest;
@Service
public class UploadFileToS3Bucket {

	private String accessKey = System.getenv("ACCESS_KEY");
	private String secretKey = System.getenv("SECRET_KEY");
	private String bucketName = System.getenv("BUCKET_NAME");

    public void uploadFile(MultipartFile file) {
        BasicAWSCredentials awsCredentials = new BasicAWSCredentials(accessKey, secretKey);
        AmazonS3 s3Client = AmazonS3ClientBuilder.standard()
                .withRegion("us-east-1")
                .withCredentials(new AWSStaticCredentialsProvider(awsCredentials))
                .build();
        try {
            String keyName = file.getOriginalFilename(); 
            PutObjectRequest request = new PutObjectRequest(bucketName, keyName, file.getInputStream(), null);
            
            s3Client.putObject(request);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
