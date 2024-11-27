package com.liang.ladataplatform.application.om.datasource.mapper;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.liang.ladataplatform.application.om.datasource.dto.DatabaseConfigPageQuery;
import com.liang.ladataplatform.application.om.datasource.entity.DatabaseConfigEntity;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author liang
 * @version 1.0.0
 * @date 2024/11/11 11:06
 */
@Mapper
public interface IDatabaseConfigMapper extends BaseMapper<DatabaseConfigEntity> {

    default List<DatabaseConfigEntity> queryDatabaseConfigList(DatabaseConfigPageQuery query){
        return selectList(new LambdaQueryWrapper<DatabaseConfigEntity>()
                .like(StringUtils.isNotBlank(query.getDatabaseName()), DatabaseConfigEntity::getDatabaseName, query.getDatabaseName())
                .orderByDesc(DatabaseConfigEntity::getCreateTime)
        );
    }
}
