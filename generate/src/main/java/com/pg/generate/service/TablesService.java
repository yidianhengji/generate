package com.pg.generate.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.pg.generate.entity.Tables;

import java.util.List;

public interface TablesService extends IService<Tables> {

    /**
     * 查询数据库下面所有的表
     * @return
     */
    List<Tables> queryTableAll();
}
