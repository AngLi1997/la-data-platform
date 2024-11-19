package com.liang.ladataplatform.application.om.datasource.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.liang.ladataplatform.application.om.datasource.convert.DatabaseTypeConverter;
import com.liang.ladataplatform.application.om.datasource.entity.DatabaseTypeEntity;
import com.liang.ladataplatform.application.om.datasource.mapper.IDatabaseTypeMapper;
import com.liang.ladataplatform.application.om.datasource.service.IDatabaseTypeService;
import com.liang.ladataplatform.application.om.datasource.vo.DatabaseTypeVO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author liang
 * @version 1.0.0
 * @date 2024/11/18 15:35
 */
@Service
public class DatabaseTypeServiceImpl implements IDatabaseTypeService {

    @Resource
    private IDatabaseTypeMapper databaseTypeMapper;

    @Override
    public List<DatabaseTypeVO> listDatabaseType() {
        List<DatabaseTypeEntity> databaseTypeEntities = databaseTypeMapper.selectList(new LambdaQueryWrapper<>());
        return DatabaseTypeConverter.INSTANCE.convertToVO(databaseTypeEntities);
    }
}
