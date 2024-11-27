package com.liang.ladataplatform.application.om.datasource.convert;

import com.liang.ladataplatform.application.om.datasource.entity.DatabaseConfigEntity;
import com.liang.ladataplatform.application.om.datasource.entity.DatabaseDriverEntity;
import com.liang.ladataplatform.application.om.datasource.vo.DatabaseConfigVO;
import com.liang.ladataplatform.application.om.datasource.vo.DatabaseDriverVO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * @author liang
 * @version 1.0.0
 * @date 2024/11/18 15:37
 */
@Mapper
public interface DatabaseConfigConverter {

    DatabaseConfigConverter INSTANCE = Mappers.getMapper(DatabaseConfigConverter.class);

    @Mapping(target = "databaseType", expression = "java(entity.getType().getName())")
    @Mapping(target = "status", expression = "java(entity.getStatus().getName())")
    DatabaseConfigVO convertToVO(DatabaseConfigEntity entity);

    List<DatabaseConfigVO> convertToVO(List<DatabaseConfigEntity> entityList);
}
