package com.pg.generate.dao;

import com.pg.generate.entity.Tables;

import java.util.List;

public interface TablesMapper {

    /**
     * 查询数据库下面所有的表
     * @return
     */
    List<Tables> queryTableAll();
}
