package com.profeel.monsterfac.monsterfactoryserver.file.command.domain.service;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.*;
import com.amazonaws.util.IOUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.PostConstruct;
import java.io.IOException;

/**
 * <pre>
 * Class : S3UploaderService
 * Comment: 클래스에 대한 간단 설명
 * History
 * ================================================================
 * DATE             AUTHOR           NOTE
 * ----------------------------------------------------------------
 * 2022-11-07       최윤서           최초 생성
 * </pre>
 *
 * @author 최윤서
 * @version 1
 */

@Service
@RequiredArgsConstructor
@PropertySource("classpath:aws.yml")
public class S3Service {

    @Value("${cloud.aws.s3.buket}")
    private String bucket;

    @Value("${cloud.aws.region.static}")
    private String region;
    @Value("${cloud.aws.credentials.access-key}")
    private String accessKey;

    @Value("${cloud.aws.credentials.secret-key}")
    private String secretKey;

    private AmazonS3 amazonS3Client;

    @PostConstruct
    private void init(){

        AWSCredentials credentials = new BasicAWSCredentials(this.accessKey, this.secretKey);
        amazonS3Client = AmazonS3ClientBuilder.standard()
                .withCredentials(new AWSStaticCredentialsProvider(credentials))
                .withRegion(this.region)
                .build();
    }

    public ObjectMetadata getObjectMetadata(MultipartFile multipartFile){
        long size = multipartFile.getSize(); // 파일 크기

        ObjectMetadata objectMetaData = new ObjectMetadata();
        objectMetaData.setContentType(multipartFile.getContentType());
        objectMetaData.setContentLength(size);
        return  objectMetaData;
    }

    public String imageUpload(MultipartFile uploadFile, String savePath) throws IOException {

        // S3 버킷 폴더에 업로드
        amazonS3Client.putObject(new PutObjectRequest(this.bucket, savePath, uploadFile.getInputStream(), getObjectMetadata(uploadFile)));
//                .withCannedAcl(CannedAccessControlList.PublicRead));

        // 업로드 url 반환
        return amazonS3Client.getUrl(this.bucket, savePath).toString();
    }


    public void modelUpload(MultipartFile uploadFile, String savePath) throws IOException {
        amazonS3Client.putObject(new PutObjectRequest(this.bucket, savePath, uploadFile.getInputStream(), getObjectMetadata(uploadFile)));
        System.out.println("s3 url : " + amazonS3Client.getUrl(this.bucket, savePath).toString());
    }

    public byte[] getFileObject(String savedPath) throws IOException {
        S3Object s3Object = amazonS3Client.getObject(new GetObjectRequest(this.bucket, savedPath));
        S3ObjectInputStream objectInputStream = s3Object.getObjectContent();
        return IOUtils.toByteArray(objectInputStream);
    }

    public void deleteFileObject(String savedPath){
        amazonS3Client.deleteObject(new DeleteObjectRequest(this.bucket, savedPath));
    }

}
