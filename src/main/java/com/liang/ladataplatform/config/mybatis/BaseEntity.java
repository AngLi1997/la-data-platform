package com.liang.ladataplatform.config.mybatis;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author liang
 * @version 1.0.0
 * @date 2024/11/11 10:59
 */
@Data
public class BaseEntity {

    private LocalDateTime createTime;

    private LocalDateTime updateTime;

    private String createUser;

    private String updateUser;

    private Boolean isDelete;
}
