package com.liang.ladataplatform.application.om.datasource.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.liang.ladataplatform.application.om.datasource.convert.DatabaseDriverConverter;
import com.liang.ladataplatform.application.om.datasource.entity.DatabaseDriverEntity;
import com.liang.ladataplatform.application.om.datasource.mapper.IDatabaseDriverMapper;
import com.liang.ladataplatform.application.om.datasource.service.IDatabaseDriverService;
import com.liang.ladataplatform.application.om.datasource.vo.DatabaseDriverVO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author liang
 * @version 1.0.0
 * @date 2024/11/18 15:35
 */
@Service
public class DatabaseDriverServiceImpl implements IDatabaseDriverService {

    @Resource
    private IDatabaseDriverMapper databaseTypeMapper;

    @Override
    public List<DatabaseDriverVO> listDatabaseDriver() {
        List<DatabaseDriverEntity> databaseDriverEntities = databaseTypeMapper.selectList(new LambdaQueryWrapper<>());
        return DatabaseDriverConverter.INSTANCE.convertToVO(databaseDriverEntities);
    }
}
