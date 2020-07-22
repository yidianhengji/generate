package com.pg.generate.dao;

import com.github.pagehelper.Page;
import com.pg.generate.entity.Database;

import java.util.List;

public interface DatabaseMapper {

    Page<Database> queryPage(Database database);

    List<Database> queryAll();

    Database queryOne(String tableId);

    int insert(Database database);

    int update(Database database);

    int delete(String tableId);

    List<Database> queryTableAll(String tableSchema);

    int deleteProject(String projectId);

}
