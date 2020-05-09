package com.pg.generate.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.pg.generate.entity.TablesSchema;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TablesSchemaService extends IService<TablesSchema> {

    /**
     * 查询表下面所有的字段
     * @param tableSchema
     * @param tableName
     */
    List<TablesSchema> queryTableColumnAll(@Param("tableSchema") String tableSchema, @Param("tableName") String tableName);
}
