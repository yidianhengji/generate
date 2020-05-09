package com.pg.generate.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.pg.generate.entity.Tables;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@Component
@Repository
public interface TablesMapper extends BaseMapper<Tables> {

    /**
     * 查询数据库下面所有的表
     * @return
     */
    List<Tables> queryTableAll();
}
