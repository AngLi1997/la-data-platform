package com.liang.ladataplatform.application.om.datasource.controller;

import com.liang.ladataplatform.application.om.datasource.dto.DatabaseConfigCreateDTO;
import com.liang.ladataplatform.application.om.datasource.dto.DatabaseConfigEditDTO;
import com.liang.ladataplatform.application.om.datasource.dto.DatabaseConfigPageQuery;
import com.liang.ladataplatform.application.om.datasource.service.IDatabaseConfigService;
import com.liang.ladataplatform.application.om.datasource.vo.DatabaseConfigVO;
import com.liang.ladataplatform.common.CommonResponse;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author liang
 * @version 1.0.0
 * @date 2024/11/18 15:30
 */
@RestController
@RequestMapping("/database/config")
public class DatabaseConfigController {

    @Resource
    private IDatabaseConfigService databaseConfigService;

    @PostMapping("/create")
    public CommonResponse<Void> createDatabaseConfig(@Validated @RequestBody DatabaseConfigCreateDTO dto) {
        databaseConfigService.createDatabaseConfig(dto);
        return CommonResponse.success();
    }

    @PostMapping("/edit")
    public CommonResponse<Void> editDatabaseConfig(@Validated @RequestBody DatabaseConfigEditDTO dto) {
        databaseConfigService.editDatabaseConfig(dto);
        return CommonResponse.success();
    }

    @PostMapping("/list")
    public CommonResponse<List<DatabaseConfigVO>> queryDatabaseConfigList(@Validated @RequestBody DatabaseConfigPageQuery query) {
        return CommonResponse.success(databaseConfigService.queryDatabaseConfigList(query));
    }

    @DeleteMapping("/delete")
    public CommonResponse<Void> deleteDatabaseConfig(@Validated @RequestParam Long databaseId) {
        databaseConfigService.deleteDatabaseConfig(databaseId);
        return CommonResponse.success();
    }

    @GetMapping("/detail")
    public CommonResponse<DatabaseConfigVO> queryDatabaseConfigDetail(@Validated @RequestParam Long databaseId) {
        return CommonResponse.success(databaseConfigService.queryDatabaseConfigDetail(databaseId));
    }

    @GetMapping("/testConnect")
    public CommonResponse<Boolean> testConnect(@Validated @RequestParam Long databaseId) {
        return CommonResponse.success(databaseConfigService.testConnect(databaseId));
    }
}
