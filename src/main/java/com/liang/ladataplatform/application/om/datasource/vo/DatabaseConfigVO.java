package com.liang.ladataplatform.application.om.datasource.vo;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author liang
 * @version 1.0.0
 * @date 2024/11/27 15:26
 */
@Data
public class DatabaseConfigVO {

    private Long id;

    private String databaseName;

    private String databaseType;

    private Long databaseDriverId;

    private String schemaName;

    private String host;

    private Integer port;

    private String url;

    private String username;

    private String status;

    private String remark;

    private LocalDateTime updateTime;

    private String updateUser;
}
