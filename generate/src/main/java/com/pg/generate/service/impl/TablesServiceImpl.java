package com.pg.generate.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.pg.generate.dao.TablesMapper;
import com.pg.generate.entity.Tables;
import com.pg.generate.service.TablesService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class TablesServiceImpl extends ServiceImpl<TablesMapper, Tables> implements TablesService {

    @Resource
    private TablesMapper tablesMapper;

    @Override
    public List<Tables> queryTableAll() {
        return tablesMapper.queryTableAll();
    }
}
