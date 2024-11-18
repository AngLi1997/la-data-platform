package com.liang.ladataplatform.config.file.minio;

import io.minio.MinioClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author liang
 * @version 1.0.0
 * @date 2024/11/18 11:57
 */
@Configuration
public class MinioConfiguration {

    @Value(value = "${minio.endpoint}")
    private String endpoint;

    @Value(value = "${minio.access-key}")
    private String accessKey;

    @Value(value = "${minio.secret-key}")
    private String secretKey;

    @Value("${minio.bucket-name}")
    private String bucketName;

    @Bean
    public MinioClient getMinioClient() {
        return new MinioClient.Builder()
                .credentials(accessKey, secretKey)
                .endpoint(endpoint)
                .build();
    }

    @Bean
    public MinioIFileManager getMinioIFileManager(MinioClient minioClient) {
        return new MinioIFileManager(minioClient, bucketName);
    }
}
