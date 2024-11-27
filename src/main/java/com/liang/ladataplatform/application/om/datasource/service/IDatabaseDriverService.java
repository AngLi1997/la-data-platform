package com.liang.ladataplatform.application.om.datasource.service;

import com.liang.ladataplatform.application.om.datasource.vo.DatabaseDriverVO;

import java.util.List;

/**
 * @author liang
 * @version 1.0.0
 * @date 2024/11/18 15:35
 */
public interface IDatabaseDriverService {

    List<DatabaseDriverVO> listDatabaseDriver();
}
