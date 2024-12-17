package com.liang.ladataplatform.application.om.datasource.dto;

import com.liang.ladataplatform.application.om.datasource.enums.DatabaseStatus;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @author liang
 * @version 1.0.0
 * @date 2024/12/17 15:44
 */
@Data
public class DatabaseConfigEditDTO {

    @NotNull
    private Long id;

    @NotBlank
    @Length(max = 100)
    private String databaseName;

    @NotNull
    private Long databaseDriverId;

    @NotBlank
    @Length(max = 100)
    private String schemaName;

    @NotBlank
    @Length(max = 100)
    private String host;

    @NotNull
    private Integer port;

    @Length(max = 100)
    private String username;

    @Length(max = 100)
    private String password;

    @NotNull
    private DatabaseStatus status;

    @Length(max = 200)
    private String remark;
}
