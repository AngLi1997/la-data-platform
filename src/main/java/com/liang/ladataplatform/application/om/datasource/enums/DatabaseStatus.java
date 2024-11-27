package com.liang.ladataplatform.application.om.datasource.enums;

import com.baomidou.mybatisplus.annotation.IEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author liang
 * @version 1.0.0
 * @date 2024/11/27 14:32
 */
@AllArgsConstructor
@Getter
public enum DatabaseStatus implements IEnum<String> {

    /**
     * 正常
     */
    NORMAL("NORMAL", "正常"),

    /**
     * 失败
     */
    FAILURE("FAILURE", "失败");

    private final String value;

    private final String name;
}
