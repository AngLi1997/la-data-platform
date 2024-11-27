package com.liang.ladataplatform.application.om.datasource.dto;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

/**
 * @author liang
 * @version 1.0.0
 * @date 2024/11/27 15:27
 */
@Data
public class DatabaseConfigPageQuery {

    @Length(max = 100)
    private String databaseName;
}
