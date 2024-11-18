package com.liang.ladataplatform.config.file.minio;

import com.liang.ladataplatform.config.file.IFileManager;
import io.minio.*;
import lombok.extern.slf4j.Slf4j;

import java.io.InputStream;
import java.io.OutputStream;

/**
 * @author liang
 * @version 1.0.0
 * @date 2024/11/18 13:42
 */
@Slf4j
public class MinioIFileManager implements IFileManager {

    private static final int PART_SIZE = 1024 * 1024 * 10;

    private final MinioClient minioClient;

    private final String bucketName;

    public MinioIFileManager(MinioClient minioClient, String bucketName) {
        this.minioClient = minioClient;
        this.bucketName = bucketName;
    }


    @Override
    public String uploadFile(String path, String fileName, InputStream input) throws Exception {
        log.info("文件上传:{}, {}/{}", bucketName, path, fileName);
        checkBucket();
        if (!path.endsWith("/")){
            path += "/";
        }
        ObjectWriteResponse response = minioClient.putObject(PutObjectArgs.builder()
                .bucket(bucketName)
                .object(path + fileName)
                .stream(input, -1, PART_SIZE)
                .build());
        return response.object();
    }

    @Override
    public void downloadFile(String path, String fileName, OutputStream output) {

    }

    private void checkBucket() throws Exception {
        if (!minioClient.bucketExists(BucketExistsArgs.builder()
                .bucket(bucketName)
                .build())){
            minioClient.makeBucket(MakeBucketArgs.builder()
                    .bucket(bucketName)
                    .build());
            minioClient.setBucketPolicy(SetBucketPolicyArgs.builder()
                    .bucket(bucketName)
                    .config("{\"Version\":\"2012-10-17\",\"Statement\":[{\"Effect\":\"Allow\","
                            + "\"Principal\":{\"AWS\":[\"*\"]},\"Action\":[\"s3:ListBucketMultipartUploads\","
                            + "\"s3:GetBucketLocation\",\"s3:ListBucket\"],\"Resource\":[\"arn:aws:s3:::"
                            + bucketName + "\"]},"
                            + "{\"Effect\":\"Allow\",\"Principal\":{\"AWS\":[\"*\"]},"
                            + "\"Action\":[\"s3:AbortMultipartUpload\",\"s3:DeleteObject\",\"s3:GetObject\","
                            + "\"s3:ListMultipartUploadParts\",\"s3:PutObject\"],"
                            + "\"Resource\":[\"arn:aws:s3:::" + bucketName + "/*\"]}]}")
                    .build());
        }
    }
}
