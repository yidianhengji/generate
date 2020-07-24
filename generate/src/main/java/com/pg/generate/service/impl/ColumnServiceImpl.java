package com.pg.generate.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.util.StringUtil;
import com.pg.generate.dao.ColumnMapper;
import com.pg.generate.entity.Column;
import com.pg.generate.handler.BusinessException;
import com.pg.generate.service.ColumnService;
import org.springframework.stereotype.Service;

import org.springframework.beans.factory.annotation.Autowired;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class ColumnServiceImpl implements ColumnService {

    @Autowired
    private ColumnMapper columnMapper;

    @Override
    public Page<Column> queryPage(Column column) {
        if (column.getPageSize() != null && column.getPageNum() != null) {
            PageHelper.startPage(column.getPageNum(), column.getPageSize());
        }
        Page<Column> pages = this.columnMapper.queryPage(column);
        return pages;
    }

    @Override
    public List<Column> queryAll() {
        List<Column> list = this.columnMapper.queryAll();
        return list;
    }

    @Override
    public Column queryOne(String columnId) {
        Column one = this.columnMapper.queryOne(columnId);
        return one;
    }

    @Override
    public int insert(Column column) {
        column.setColumnId(UUID.randomUUID().toString().replace("-", ""));
        column.setCreateTime(new Date());
        column.setModifyTime(new Date());
        return this.columnMapper.insert(column);
    }

    @Override
    public int update(Column column) {
        if (StringUtil.isEmpty(column.getColumnId())) {
            throw new BusinessException(500, "column_id必传");
        }
        column.setModifyTime(new Date());
        return this.columnMapper.update(column);
    }

    @Override
    public int delete(String columnId) {
        return this.columnMapper.delete(columnId);
    }

    @Override
    public List<Column> queryTableColumnAll(String tableSchema, String tableName) {
        return this.columnMapper.queryTableColumnAll(tableSchema, tableName);
    }
}
