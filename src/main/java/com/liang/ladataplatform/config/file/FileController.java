package com.liang.ladataplatform.config.file;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @author liang
 * @version 1.0.0
 * @date 2024/11/18 13:53
 */
@RestController
@RequestMapping("/file")
@Validated
public class FileController {

    @Resource
    private IFileManager fileManager;

    @PostMapping("/upload")
    public String upload(@NotBlank String path, @NotNull MultipartFile file) throws Exception {
        return fileManager.uploadFile(path, file.getOriginalFilename(), file.getInputStream());
    }
}
