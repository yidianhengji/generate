package com.pg.generate.service.impl;

import com.pg.generate.dao.TablesMapper;
import com.pg.generate.entity.Tables;
import com.pg.generate.service.TablesService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class TablesServiceImpl implements TablesService {

    @Resource
    private TablesMapper tablesMapper;

    @Override
    public List<Tables> queryTableAll() {
        return tablesMapper.queryTableAll();
    }
}
