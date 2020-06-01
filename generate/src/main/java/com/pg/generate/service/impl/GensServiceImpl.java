package com.pg.generate.service.impl;

import com.pg.generate.dao.TablesSchemaMapper;
import com.pg.generate.dto.GenTableInfo;
import com.pg.generate.entity.TablesSchema;
import com.pg.generate.service.GensService;
import com.pg.generate.util.Common;
import com.pg.generate.util.GenUtils;
import com.pg.generate.util.GetPath;
import com.pg.generate.util.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.StringWriter;
import java.util.List;
import java.util.Properties;

@Service
public class GensServiceImpl implements GensService {

    @Autowired
    private TablesSchemaMapper tablesSchemaMapper;

    /**
     * 模板数据拼接
     * @param tableSchema
     * @param tableName
     */
    @Override
    public int GenTemplate(String tableSchema, String tableName) {
        // 查询到表的数据
        List<TablesSchema> tableColumnAll = tablesSchemaMapper.queryTableColumnAll(tableSchema, tableName);
        // 初始化表信息
        List<TablesSchema> tablesSchemas = GenUtils.initColumnField(tableColumnAll);
        // 获取表的主键
        String columnPriKey = GenUtils.initColumnKey(tableColumnAll);
        // 获取表的名称，并转成驼峰的形式，并且第一个字母转成大写（实体类名称）
        String ClassName = Common.captureName(tableName);
        // 获取表的名称，并转成驼峰的形式
        String className = Common.underlineToCamel(tableName);

        // 初始化模板
        Properties properties = new Properties();
        // 设置velocity资源加载方式为class
        properties.setProperty("resource.loader", "class");
        // 设置velocity资源加载方式为file时的处理类
        properties.setProperty("class.resource.loader.class", "org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader");
        // 实例化一个VelocityEngine对象
        VelocityEngine velocityEngine = new VelocityEngine(properties);
        // 实例化一个VelocityContext
        VelocityContext context = new VelocityContext();
        // 向VelocityContext中放入键值
        context.put("tableName", tableName);
        context.put("packageName", GetPath.getPackageName());
        context.put("ClassName", ClassName);
        context.put("className", className);
        context.put("tableColumnAll", tablesSchemas);
        context.put("columnPriKey", columnPriKey);
        // 实例化一个StringWriter
        StringWriter writer = new StringWriter();
        // 从src目录下加载hello.vm模板
        List<String> templateVmList = Template.getTemplateVmList();
        for (String templatesPath : templateVmList) {
            velocityEngine.mergeTemplate(templatesPath, "UTF-8", context, writer);
            System.out.println(writer.toString());
        }
        return 0;
    }

}
