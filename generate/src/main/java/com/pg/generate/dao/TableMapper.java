package com.pg.generate.dao;

import com.github.pagehelper.Page;
import com.pg.generate.entity.Table;

import java.util.List;

public interface TableMapper {

    Page<Table> queryPage(Table table);

    List<Table> queryAll();

    Table queryOne(String tableId);

    int insert(Table table);

    int update(Table table);

    int delete(String tableId);

}
