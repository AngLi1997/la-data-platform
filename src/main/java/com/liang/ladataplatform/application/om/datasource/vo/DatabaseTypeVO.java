package com.liang.ladataplatform.application.om.datasource.vo;

import lombok.Data;

/**
 * @author liang
 * @version 1.0.0
 * @date 2024/11/18 15:32
 */
@Data
public class DatabaseTypeVO {

    private Long id;

    private String type;

    private String name;

    private String driverClassName;
}
