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

    public static <T> CommonResponse<T> success(T data) {
        return new CommonResponse<>(200, "请求成功", data);
    }
}
