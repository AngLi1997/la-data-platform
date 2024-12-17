package com.liang.ladataplatform.application.om.datasource.service.impl;

import com.liang.ladataplatform.application.om.datasource.dto.DatabaseConfigCreateDTO;
import com.liang.ladataplatform.application.om.datasource.convert.DatabaseConfigConverter;
import com.liang.ladataplatform.application.om.datasource.dto.DatabaseConfigEditDTO;
import com.liang.ladataplatform.application.om.datasource.dto.DatabaseConfigPageQuery;
import com.liang.ladataplatform.application.om.datasource.entity.DatabaseConfigEntity;
import com.liang.ladataplatform.application.om.datasource.entity.DatabaseDriverEntity;
import com.liang.ladataplatform.application.om.datasource.mapper.IDatabaseConfigMapper;
import com.liang.ladataplatform.application.om.datasource.mapper.IDatabaseDriverMapper;
import com.liang.ladataplatform.application.om.datasource.service.IDatabaseConfigService;
import com.liang.ladataplatform.application.om.datasource.vo.DatabaseConfigVO;
import com.liang.ladataplatform.config.exception.BusinessFailedException;
import com.mysql.cj.jdbc.exceptions.CommunicationsException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.SQLSyntaxErrorException;
import java.util.List;

/**
 * @author liang
 * @version 1.0.0
 * @date 2024/11/11 11:06
 */
@Service
public class DatabaseConfigServiceImpl implements IDatabaseConfigService {

    @Resource
    private IDatabaseConfigMapper databaseConfigMapper;

    @Resource
    private IDatabaseDriverMapper databaseDriverMapper;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void createDatabaseConfig(DatabaseConfigCreateDTO dto) {
        DatabaseDriverEntity driver = databaseDriverMapper.selectById(dto.getDatabaseDriverId());
        if (driver == null){
            throw new BusinessFailedException("数据库驱动不存在");
        }
        DatabaseConfigEntity config = new DatabaseConfigEntity();
        config.setDatabaseName(dto.getDatabaseName());
        config.setDatabaseDriverId(driver.getId());
        config.setType(driver.getType());
        config.setHost(dto.getHost());
        config.setPort(dto.getPort());
        config.setSchemaName(dto.getSchemaName());
        config.setUsername(dto.getUsername());
        config.setPassword(dto.getPassword());
        config.setStatus(dto.getStatus());
        config.setRemark(dto.getRemark());
        databaseConfigMapper.insert(config);
    }

    @Override
    public List<DatabaseConfigVO> queryDatabaseConfigList(DatabaseConfigPageQuery query) {
        List<DatabaseConfigEntity> list = databaseConfigMapper.queryDatabaseConfigList(query);
        return DatabaseConfigConverter.INSTANCE.convertToVO(list);
    }

    @Override
    public void deleteDatabaseConfig(Long databaseId) {
        DatabaseConfigEntity config = databaseConfigMapper.selectById(databaseId);
        if (config == null){
            throw new BusinessFailedException("数据库配置不存在");
        }
        databaseConfigMapper.deleteById(databaseId);
    }

    @Override
    public void testConnect(Long databaseId) {
        String template = "jdbc:mysql://%s:%s/%s";
        DatabaseConfigEntity config = databaseConfigMapper.selectById(databaseId);
        if (config == null){
            throw new BusinessFailedException("数据库配置不存在");
        }
        String host = config.getHost();
        Integer port = config.getPort();
        String schemaName = config.getSchemaName();
        String username = config.getUsername();
        String password = config.getPassword();
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(String.format(template, host, port, schemaName), username, password);
        } catch (SQLException e) {
            if (e instanceof CommunicationsException){
                throw new BusinessFailedException("数据库连接失败:通信失败");
            } if (e instanceof SQLSyntaxErrorException){
                throw new BusinessFailedException("数据库连接失败:数据库["+schemaName+"]不存在");
            }else {
                e.printStackTrace();
            }
        }finally {
            if (connection != null){
                try {
                    connection.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    @Override
    public DatabaseConfigVO queryDatabaseConfigDetail(Long databaseId) {
        DatabaseConfigEntity config = databaseConfigMapper.selectById(databaseId);
        if (config == null){
            throw new BusinessFailedException("数据库配置不存在");
        }
        return DatabaseConfigConverter.INSTANCE.convertToVO(config);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void editDatabaseConfig(DatabaseConfigEditDTO dto) {
        DatabaseConfigEntity config = databaseConfigMapper.selectById(dto.getId());
        if (config == null){
            throw new BusinessFailedException("数据库配置不存在");
        }
        DatabaseDriverEntity driver = databaseDriverMapper.selectById(dto.getDatabaseDriverId());
        if (driver == null){
            throw new BusinessFailedException("数据库驱动不存在");
        }
        config.setDatabaseName(dto.getDatabaseName());
        config.setDatabaseDriverId(driver.getId());
        config.setType(driver.getType());
        config.setHost(dto.getHost());
        config.setPort(dto.getPort());
        config.setSchemaName(dto.getSchemaName());
        config.setUsername(dto.getUsername());
        config.setPassword(dto.getPassword());
        config.setStatus(dto.getStatus());
        config.setRemark(dto.getRemark());

        databaseConfigMapper.updateById(config);
    }
}
