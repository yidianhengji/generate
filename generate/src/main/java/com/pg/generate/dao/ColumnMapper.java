package com.pg.generate.dao;

import com.github.pagehelper.Page;
import com.pg.generate.entity.Column;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ColumnMapper {

    Page<Column> queryPage(Column column);

    List<Column> queryAll();

    Column queryOne(String columnId);

    int insert(Column column);

    int update(Column column);

    int delete(String columnId);

    List<Column> queryTableColumnAll(@Param("tableSchema") String tableSchema, @Param("tableName") String tableName);

}
