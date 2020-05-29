package com.pg.generate.service.impl;

import com.pg.generate.dao.TablesSchemaMapper;
import com.pg.generate.dto.GenTableInfo;
import com.pg.generate.entity.TablesSchema;
import com.pg.generate.service.GensService;
import com.pg.generate.util.Common;
import com.pg.generate.util.GetPath;
import com.pg.generate.util.Template;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import javax.annotation.Resource;
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
        // 获取表的名称，并转成驼峰的形式，并且第一个字母转成大写（实体类名称）
        String ClassName = Common.captureName(genTableInfo.getTableName());
        // 获取表的名称，并转成驼峰的形式
        String className = Common.underlineToCamel(genTableInfo.getTableName());
        // 获取全部的模板
        List<String> templateList = Template.getTemplateList();
        // 遍历模板
        for (String string : templateList) {
            //初始化运行上下文
            Context context = new Context();
            // 给模板设置共通的值  包名 类名
            context.setVariable("packageName", GetPath.getPackageName());
            context.setVariable("ClassName", ClassName);
            context.setVariable("className", className);
            context.setVariable("tableColumnAll", tableColumnAll);
            // 给模板赋值
            String process = templateEngine.process(string, context);
            System.out.println(process);
        }
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(1);
    }


}
