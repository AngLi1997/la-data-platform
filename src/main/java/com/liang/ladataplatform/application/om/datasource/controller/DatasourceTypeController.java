package com.liang.ladataplatform.application.om.datasource.controller;

import com.liang.ladataplatform.application.om.datasource.service.IDatabaseTypeService;
import com.liang.ladataplatform.application.om.datasource.vo.DatabaseTypeVO;
import com.liang.ladataplatform.common.CommonResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author liang
 * @version 1.0.0
 * @date 2024/11/18 15:30
 */
@RestController
@RequestMapping("/datasource/type")
public class DatasourceTypeController {

    @Resource
    private IDatabaseTypeService databaseTypeService;

    @GetMapping("/list")
    public CommonResponse<List<DatabaseTypeVO>> listDatasourceType(){
        return CommonResponse.success(databaseTypeService.listDatabaseType());
    }
}
