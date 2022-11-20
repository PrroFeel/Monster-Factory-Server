package com.profeel.monsterfac.monsterfactoryserver.file.command.domain.service;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.PutObjectRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.File;
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
//@PropertySource("classpath:aws.yml")
public class S3UploaderService {

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


    // 임시 저장 경로에 저장된 파일을 지우는 메소드
    private void removeFile(File targetFile){
        if(targetFile.delete()){
            System.out.println("File 삭제 성공");
            return;
        }
        System.out.println("파일 삭제 실패");
    }




    // multipart 파일을 s3 특정 폴더에 업로드 하기 위한 메소드
    public void modelUpload(File uploadFile, String savePath) throws IOException {
        amazonS3Client.putObject(new PutObjectRequest(this.bucket, savePath, uploadFile));
        removeFile(uploadFile);
        System.out.println("s3 url : " + amazonS3Client.getUrl(this.bucket, savePath).toString());
    }

    public String imageUpload(File uploadFile, String savePath){
        // S3 버킷 폴더에 업로드
        amazonS3Client.putObject(new PutObjectRequest(this.bucket, savePath, uploadFile));
//                .withCannedAcl(CannedAccessControlList.PublicRead));

        // 임시 저장된 File 객체 제거
        removeFile(uploadFile);
        // 업로드 url 반환
        return amazonS3Client.getUrl(this.bucket, savePath).toString();
    }

}
