package com.liang.ladataplatform.application.om.datasource.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.liang.ladataplatform.application.om.datasource.enums.DatabaseStatus;
import com.liang.ladataplatform.application.om.datasource.enums.DatabaseType;
import com.liang.ladataplatform.config.mybatis.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @author liang
 * @version 1.0.0
 * @date 2024/11/11 10:57
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("la_database_config")
public class DatabaseConfigEntity extends BaseEntity {

    @TableId(type = IdType.ASSIGN_ID)
    private Long id;

    private String databaseName;

    private DatabaseType type;

    private Long databaseDriverId;

    private String schemaName;

    private String host;

    private Integer port;

    private String url;

    private String username;

    private String password;

    private DatabaseStatus status;

    private String remark;
}
