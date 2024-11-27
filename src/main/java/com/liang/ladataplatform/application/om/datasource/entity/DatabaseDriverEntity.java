package com.liang.ladataplatform.application.om.datasource.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.liang.ladataplatform.application.om.datasource.enums.DatabaseType;
import com.liang.ladataplatform.config.mybatis.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author liang
 * @version 1.0.0
 * @date 2024/11/18 15:33
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("la_database_driver")
public class DatabaseDriverEntity extends BaseEntity {

    @TableId(type = IdType.ASSIGN_ID)
    private Long id;

    private DatabaseType type;

    private String name;

    private String driverClassName;
}
