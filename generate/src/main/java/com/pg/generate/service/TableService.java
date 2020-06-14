package com.pg.generate.service;

import com.github.pagehelper.Page;
import com.pg.generate.entity.Table;

import java.util.List;

public interface TableService {

    Page<Table> queryPage(Table table);

    List<Table> queryAll();

    Table queryOne(String tableId);

    int insert(Table table);

    int update(Table table);

    int delete(String tableId);

}
