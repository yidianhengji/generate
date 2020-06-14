package com.pg.generate.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.util.StringUtil;
import com.pg.generate.dao.TableMapper;
import com.pg.generate.entity.Table;
import com.pg.generate.handler.BusinessException;
import com.pg.generate.service.TableService;
import org.springframework.stereotype.Service;

import org.springframework.beans.factory.annotation.Autowired;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class TableServiceImpl implements TableService {

    @Autowired
    private TableMapper tableMapper;

    @Override
    public Page<Table> queryPage(Table table) {
        if (table.getPageSize() != null && table.getPageNum() != null) {
            PageHelper.startPage(table.getPageNum(), table.getPageSize());
        }
        Page<Table> pages = this.tableMapper.queryPage(table);
        return pages;
    }

    @Override
    public List<Table> queryAll() {
        List<Table> list = this.tableMapper.queryAll();
        return list;
    }

    @Override
    public Table queryOne(String tableId) {
        Table one = this.tableMapper.queryOne(tableId);
        return one;
    }

    @Override
    public int insert(Table table) {
        table.setTableId(UUID.randomUUID().toString().replace("-", ""));
        table.setCreateTime(new Date());
        table.setModifyTime(new Date());
        return this.tableMapper.insert(table);
    }

    @Override
    public int update(Table table) {
        if (StringUtil.isEmpty(table.getTableId())) {
            throw new BusinessException(500, "table_id必传");
        }
        table.setModifyTime(new Date());
        return this.tableMapper.update(table);
    }

    @Override
    public int delete(String tableId) {
        return this.tableMapper.delete(tableId);
    }
}
