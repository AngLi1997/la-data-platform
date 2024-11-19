package com.liang.ladataplatform.application.om.datasource.convert;

import com.liang.ladataplatform.application.om.datasource.entity.DatabaseTypeEntity;
import com.liang.ladataplatform.application.om.datasource.vo.DatabaseTypeVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * @author liang
 * @version 1.0.0
 * @date 2024/11/18 15:37
 */
@Mapper
public interface DatabaseTypeConverter {

    DatabaseTypeConverter INSTANCE = Mappers.getMapper(DatabaseTypeConverter.class);

    List<DatabaseTypeVO> convertToVO(List<DatabaseTypeEntity> entityList);
}
