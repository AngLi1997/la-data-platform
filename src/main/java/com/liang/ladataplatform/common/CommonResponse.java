package com.liang.ladataplatform.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author liang
 * @version 1.0.0
 * @date 2024/11/15 10:29
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CommonResponse<T> {

    private Integer code;

    private String msg;

    private T data;

    public CommonResponse(Integer code, String msg){
        this.code = code;
        this.msg = msg;
    }

    public static <T> CommonResponse<T> success(T data) {
        return new CommonResponse<>(200, "成功", data);
    }

    public static <T> CommonResponse<T> failed(String msg) {
        return new CommonResponse<>(-1, msg);
    }

    public static <T> CommonResponse<T> error(String msg) {
        return new CommonResponse<>(500, msg);
    }
}
