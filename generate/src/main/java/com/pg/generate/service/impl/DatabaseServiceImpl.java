package com.pg.generate.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.util.StringUtil;
import com.pg.generate.dao.DatabaseMapper;
import com.pg.generate.entity.Database;
import com.pg.generate.handler.BusinessException;
import com.pg.generate.service.DatabaseService;
import org.springframework.stereotype.Service;

import org.springframework.beans.factory.annotation.Autowired;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class DatabaseServiceImpl implements DatabaseService {

    @Autowired
    private DatabaseMapper databaseMapper;

    @Override
    public Page<Database> queryPage(Database database) {
        if (database.getPageSize() != null && database.getPageNum() != null) {
            PageHelper.startPage(database.getPageNum(), database.getPageSize());
        }
        Page<Database> pages = this.databaseMapper.queryPage(database);
        return pages;
    }

    @Override
    public List<Database> queryAll(String projectId) {
        List<Database> list = this.databaseMapper.queryAll(projectId);
        return list;
    }

    @Override
    public Database queryOne(String tableId) {
        Database one = this.databaseMapper.queryOne(tableId);
        return one;
    }

    @Override
    public int insert(Database database) {
        database.setTableId(UUID.randomUUID().toString().replace("-", ""));
        database.setCreateTime(new Date());
        database.setModifyTime(new Date());
        return this.databaseMapper.insert(database);
    }

    @Override
    public int update(Database database) {
        if (StringUtil.isEmpty(database.getTableId())) {
            throw new BusinessException(500, "table_id必传");
        }
        database.setModifyTime(new Date());
        return this.databaseMapper.update(database);
    }

    @Override
    public int delete(String tableId) {
        return this.databaseMapper.delete(tableId);
    }

    @Override
    public int deleteProject(String projectId) {
        return this.databaseMapper.deleteProject(projectId);
    }

    @Override
    public List<Database> queryTableAll(String tableSchema) {
        List<Database> list = this.databaseMapper.queryTableAll(tableSchema);
        return list;
    }
}
