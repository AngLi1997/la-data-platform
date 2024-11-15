package com.liang.ladataplatform.util;

import com.aspose.words.Document;
import com.aspose.words.License;
import com.aspose.words.LoadOptions;

import java.io.File;
import java.io.InputStream;
import java.nio.file.Files;

/**
 * @author liang
 * @version 1.0.0
 * @date 2024/11/15 10:27
 */
public class WordUtil {
    public static Document loadDocx(InputStream inputStream) {
        InputStream is = WordUtil.class.getClassLoader().getResourceAsStream("aspose/license.xml");
        License license = new License();
        try {
            license.setLicense(is);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        LoadOptions loadOptions = new LoadOptions();
        try {
            return new Document(inputStream, loadOptions);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
