package com.liang.ladataplatform.application.om.datasource.convert;

import com.liang.ladataplatform.application.om.datasource.entity.DatabaseDriverEntity;
import com.liang.ladataplatform.application.om.datasource.vo.DatabaseDriverVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * @author liang
 * @version 1.0.0
 * @date 2024/11/18 15:37
 */
@Mapper
public interface DatabaseDriverConverter {

    DatabaseDriverConverter INSTANCE = Mappers.getMapper(DatabaseDriverConverter.class);

    List<DatabaseDriverVO> convertToVO(List<DatabaseDriverEntity> entityList);
}
