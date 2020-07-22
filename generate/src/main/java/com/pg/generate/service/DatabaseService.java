package com.pg.generate.service;

import com.github.pagehelper.Page;
import com.pg.generate.entity.Database;

import java.util.List;

public interface DatabaseService {

    Page<Database> queryPage(Database database);

    List<Database> queryAll();

    Database queryOne(String tableId);

    int insert(Database database);

    int update(Database database);

    int delete(String tableId);

    int deleteProject(String projectId);

    List<Database> queryTableAll(String tableSchema);

}
