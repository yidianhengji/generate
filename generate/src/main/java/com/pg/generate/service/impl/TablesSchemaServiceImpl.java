package com.pg.generate.service.impl;

import com.pg.generate.dao.TablesSchemaMapper;
import com.pg.generate.entity.TablesSchema;
import com.pg.generate.service.TablesSchemaService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class TablesSchemaServiceImpl implements TablesSchemaService {

    @Resource
    private TablesSchemaMapper tablesSchemaMapper;

    /**
     * 查询表下面所有的字段
     * @param tableSchema
     * @param tableName
     */
    @Override
    public List<TablesSchema> queryTableColumnAll(String tableSchema, String tableName) {
        return tablesSchemaMapper.queryTableColumnAll(tableSchema, tableName);
    }

}
