package com.liang.ladataplatform.config.file;

import java.io.InputStream;
import java.io.OutputStream;

/**
 * 文件处理接口
 * @author liang
 * @version 1.0.0
 * @date 2024/11/18 13:39
 */
public interface IFileManager {

    String uploadFile(String path, String fileName, InputStream input) throws Exception;

    void downloadFile(String path, String fileName, OutputStream output) throws Exception;
}
