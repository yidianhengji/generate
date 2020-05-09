package com.pg.generate.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.pg.generate.dao.TablesSchemaMapper;
import com.pg.generate.entity.TablesSchema;
import com.pg.generate.service.TablesSchemaService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class TablesSchemaServiceImpl extends ServiceImpl<TablesSchemaMapper, TablesSchema> implements TablesSchemaService {

    @Resource
    private TablesSchemaMapper tablesSchemaMapper;

    @Override
    public List<TablesSchema> queryTableColumnAll(String tableSchema, String tableName) {
        return tablesSchemaMapper.queryTableColumnAll(tableSchema, tableName);
    }
}
