package com.liang.ladataplatform.application.om.datasource.service;

import com.liang.ladataplatform.application.om.datasource.dto.DatabaseConfigCreateDTO;
import com.liang.ladataplatform.application.om.datasource.dto.DatabaseConfigEditDTO;
import com.liang.ladataplatform.application.om.datasource.dto.DatabaseConfigPageQuery;
import com.liang.ladataplatform.application.om.datasource.vo.DatabaseConfigVO;

import java.util.List;

/**
 * @author liang
 * @version 1.0.0
 * @date 2024/11/11 11:06
 */
public interface IDatabaseConfigService {

    void createDatabaseConfig(DatabaseConfigCreateDTO dto);

    List<DatabaseConfigVO> queryDatabaseConfigList(DatabaseConfigPageQuery query);

    void deleteDatabaseConfig(Long databaseId);

    /**
     * 测试连接
     * @param databaseId
     */
    void testConnect(Long databaseId);

    DatabaseConfigVO queryDatabaseConfigDetail(Long databaseId);

    void editDatabaseConfig(DatabaseConfigEditDTO dto);
}
