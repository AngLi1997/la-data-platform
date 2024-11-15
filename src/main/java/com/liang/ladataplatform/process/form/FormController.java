package com.liang.ladataplatform.process.form;

import com.aspose.words.*;
import com.liang.ladataplatform.common.CommonResponse;
import com.liang.ladataplatform.util.WordUtil;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayOutputStream;

/**
 * @author liang
 * @version 1.0.0
 * @date 2024/11/15 10:28
 */
@RestController
@RequestMapping("/process/form")
public class FormController {

    @PostMapping("/convertToHtml")
    public CommonResponse<String> convertToHtml(MultipartFile file) throws Exception{
        if (file == null){
            return CommonResponse.success("no file");
        }
        Document document = WordUtil.loadDocx(file.getInputStream());
        HtmlSaveOptions htmlSaveOptions = new HtmlSaveOptions();
        // 严格模式
        htmlSaveOptions.setExportXhtmlTransitional(true);
        htmlSaveOptions.setHtmlVersion(HtmlVersion.HTML_5);
        htmlSaveOptions.setExportImagesAsBase64(true);
        htmlSaveOptions.setCssStyleSheetType(CssStyleSheetType.INLINE);
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        document.save(output, htmlSaveOptions);
        return CommonResponse.success(output.toString());
    }
}
