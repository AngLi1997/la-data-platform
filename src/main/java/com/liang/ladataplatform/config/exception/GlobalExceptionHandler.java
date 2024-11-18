package com.liang.ladataplatform.config.exception;

import com.liang.ladataplatform.common.CommonResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ConstraintViolationException;

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
