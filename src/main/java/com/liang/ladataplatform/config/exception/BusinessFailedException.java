package com.liang.ladataplatform.config.exception;

/**
 * @author liang
 * @version 1.0.0
 * @date 2024/11/18 15:07
 */
public class BusinessFailedException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public BusinessFailedException(String msg) {
        super(msg);
    }

    public static BusinessFailedException msg(String msg){
        return new BusinessFailedException(msg);
    }
}
