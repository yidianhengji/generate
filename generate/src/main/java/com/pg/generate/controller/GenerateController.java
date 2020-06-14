package com.pg.generate.controller;

import com.pg.generate.entity.Tables;
import com.pg.generate.entity.TablesSchema;
import com.pg.generate.handler.BusinessStatus;
import com.pg.generate.handler.Result;
import com.pg.generate.service.GensService;
import com.pg.generate.service.TablesSchemaService;
import com.pg.generate.service.TablesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RequestMapping(value = "/api/gen")
@RestController
public class GenerateController {

    @Autowired
    private TablesService tablesService;

    @Autowired
    private TablesSchemaService tablesSchemaService;

    @Autowired
    private GensService gensService;

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

    @GetMapping(value = "/genTemplate")
    public Result<HashMap<Object, String>> genTemplate(@RequestParam String tableSchema, @RequestParam String tableName, @RequestParam Integer type) {
        HashMap<Object, String> hashMap = gensService.GenTemplate(tableSchema, tableName, type);
        return new Result<>(BusinessStatus.SUCCESS, hashMap);
    }


}
