package com.liang.ladataplatform.application.om.datasource.enums;

import com.baomidou.mybatisplus.annotation.IEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 数据库类型
 * @author liang
 * @version 1.0.0
 * @date 2024/11/27 14:23
 */
@AllArgsConstructor
@Getter
public enum DatabaseType implements IEnum<String> {

    /**
     * mysql
     */
    MYSQL("MYSQL", "mysql"),

    /**
     * es
     */
    ELASTIC_SEARCH("ELASTIC_SEARCH", "ElasticSearch"),

    /**
     * redis
     */
    REDIS("REDIS", "redis");

    private final String value;

    private final String name;
}
