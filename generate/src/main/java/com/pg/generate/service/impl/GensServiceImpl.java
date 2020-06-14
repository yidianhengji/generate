package com.pg.generate.service.impl;

import com.pg.generate.dao.TablesSchemaMapper;
import com.pg.generate.entity.TablesSchema;
import com.pg.generate.service.GensService;
import com.pg.generate.util.*;
import io.swagger.models.auth.In;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.StringWriter;
import java.util.HashMap;
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
    public HashMap<Object, String> GenTemplate(String tableSchema, String tableName, Integer type) {
        String handleTableName = "";
        if(tableName.contains("tb_")){
            handleTableName = tableName.substring(3);
        } else {
            handleTableName = tableName;
        }
        // 查询到表的数据
        List<TablesSchema> tableColumnAll = tablesSchemaMapper.queryTableColumnAll(tableSchema, tableName);
        // 初始化表信息
        List<TablesSchema> tablesSchemas = GenUtils.initColumnField(tableColumnAll);
        // 获取表的主键
        String columnPriKey = GenUtils.initColumnKey(tableColumnAll);
        // 获取表的名称，并转成驼峰的形式，并且第一个字母转成大写（实体类名称）
        String ClassName = Common.captureName(handleTableName);
        // 获取表的名称，并转成驼峰的形式
        String className = Common.underlineToCamel(handleTableName);

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
        context.put("tableName", handleTableName);
        context.put("packageName", GetPath.getPackageName());
        context.put("ClassName", ClassName);
        context.put("className", className);
        context.put("tableColumnAll", tablesSchemas);
        context.put("columnPriKey", columnPriKey);
        context.put("setColumnPriKey", Common.captureName(columnPriKey));
        context.put("setColumnPriKeyMapper", Common.underlineToCamel(columnPriKey));
        // 从src目录下加载hello.vm模板
        List<String> templateVmList = Template.getTemplateVmList();
        HashMap<Object, String> hashMap = new HashMap<>();
        for (String templatesPath : templateVmList) {
            // 实例化一个StringWriter
            StringWriter writer = new StringWriter();
            velocityEngine.mergeTemplate(templatesPath, "UTF-8", context, writer);
            hashMap.put(templatesPath, writer.toString());
            // 如果type等于2那就下载到项目里面去
            if(type==2){
                downFile(ClassName, templatesPath, writer.toString());
            }
        }
        return hashMap;
    }

    public static void downFile(String ClassName, String templatesPath, String context) {
        String srcPath = GetPath.getPath();
        String mapperPath = GetPath.getMapperPath();
        if(templatesPath.contains("entity.vm")){
            String path = srcPath+"\\entity";
            WriteFile.writeFile(path, ClassName, context);
        }
        if(templatesPath.contains("dao.vm")){
            String path = srcPath+"\\dao";
            WriteFile.writeFile(path, ClassName+"Mapper", context);
        }
        if(templatesPath.contains("service.vm")){
            String path = srcPath+"\\service";
            WriteFile.writeFile(path, ClassName+"Service", context);
        }
        if(templatesPath.contains("serviceImpl.vm")){
            String path = srcPath+"\\service\\impl";
            WriteFile.writeFile(path, ClassName+"ServiceImpl", context);
        }
        if(templatesPath.contains("controller.vm")){
            String path = srcPath+"\\controller";
            WriteFile.writeFile(path, ClassName+"Controller", context);
        }
        if(templatesPath.contains("mapper.vm")){
            String path = mapperPath;
            WriteFile.writeFileXml(path, ClassName+"Mapper", context);
        }
    }

}
