package com.pg.generate.controller;

import com.pg.generate.entity.Tables;
import com.pg.generate.entity.TablesSchema;
import com.pg.generate.handler.BusinessStatus;
import com.pg.generate.handler.Result;
import com.pg.generate.service.TablesSchemaService;
import com.pg.generate.service.TablesService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RequestMapping(value = "/api/gen")
@RestController
public class GenerateController {

    @Resource
    private TablesService tablesService;

    @Resource
    private TablesSchemaService tablesSchemaService;

    @GetMapping(value = "/genTable")
    public Result<List<Tables>> getTable() {
        List<Tables> tables = tablesService.queryTableAll();
        return new Result<List<Tables>>(BusinessStatus.SUCCESS, tables);
    }

    @GetMapping(value = "/genTableColumn")
    public Result<List<TablesSchema>> getTableColumn(@RequestParam String tableSchema, @RequestParam String tableName) {
        List<TablesSchema> tables = tablesSchemaService.queryTableColumnAll(tableSchema, tableName);
        return new Result<List<TablesSchema>>(BusinessStatus.SUCCESS, tables);
    }
}
