package com.pg.generate.service.impl;

import com.pg.generate.dao.TablesSchemaMapper;
import com.pg.generate.dto.GenTableInfo;
import com.pg.generate.entity.TablesSchema;
import com.pg.generate.service.GensService;
import com.pg.generate.util.Common;
import com.pg.generate.util.Template;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class GensServiceImpl implements GensService {

    @Resource
    private TablesSchemaMapper tablesSchemaMapper;

    @Autowired
    private TemplateEngine templateEngine;

    /**
     * 生成实体信息
     *
     * @param genTableInfo
     */
    @Override
    public int GenTemplate(GenTableInfo genTableInfo) {
        // 查询到表的数据
        List<TablesSchema> tableColumnAll = tablesSchemaMapper.queryTableColumnAll(genTableInfo.getTableSchema(), genTableInfo.getTableName());

        List<String> templateList = Template.getTemplateList();



        //初始化运行上下文
        Context context = new Context();
        context.setVariable("user", "wojinlail");

        String process = templateEngine.process("java/entity", context);
        System.out.println(process);

        return 0;
    }








}
