package com.liang.ladataplatform.config.exception;

import com.liang.ladataplatform.common.CommonResponse;
import lombok.extern.slf4j.Slf4j;
import org.apache.logging.log4j.util.Strings;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ConstraintViolationException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author liang
 * @version 1.0.0
 * @date 2024/11/18 15:03
 */
@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(value = ConstraintViolationException.class)
    public CommonResponse<String> handleValidationException(ConstraintViolationException e) {
        log.error("参数校验失败", e);
        return CommonResponse.failed(e.getMessage());
    }

    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public CommonResponse<String> handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        log.error("参数校验失败", e);
        List<String> errorList = new ArrayList<>();
        e.getBindingResult().getAllErrors().forEach(err -> {
            String fieldName = ((FieldError) err).getField();
            String errorMessage = err.getDefaultMessage();
            errorList.add(fieldName + errorMessage);
        });
        return CommonResponse.failed(Strings.join(errorList, ','));
    }

    @ExceptionHandler(value = BusinessFailedException.class)
    public CommonResponse<String> handleBusinessFailedException(BusinessFailedException e) {
        log.error("业务失败", e);
        return CommonResponse.failed(e.getMessage());
    }

    @ExceptionHandler(value = Exception.class)
    public CommonResponse<String> handleException(Exception e) {
        log.error("系统异常", e);
        return CommonResponse.error(e.getMessage());
    }
}
