package com.liang.ladataplatform.application.om.datasource.entity;

import com.liang.ladataplatform.config.mybatis.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author liang
 * @version 1.0.0
 * @date 2024/11/11 10:57
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class DatasourceConfigEntity extends BaseEntity {

    private Long id;

    private String datasourceName;

    private String url;

    private String username;

    private String password;

    private String driverClassName;

    private String type;

    private String status;

    private String remark;
}
