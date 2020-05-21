package com.pg.generate.service.impl;

import com.pg.generate.dao.TablesSchemaMapper;
import com.pg.generate.dto.GenTableInfo;
import com.pg.generate.entity.TablesSchema;
import com.pg.generate.gen.VelocityInitializer;
import com.pg.generate.service.GensService;
import com.pg.generate.util.Common;
import net.bytebuddy.implementation.bind.MethodDelegationBinder;
import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;
import org.apache.velocity.app.VelocityEngine;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;

@Service
public class GensServiceImpl implements GensService {

    @Resource
    private TablesSchemaMapper tablesSchemaMapper;

    // 项目所在的路径
    private static final String ProjectPath = "F:\\shop\\generate\\generate";
    // java地址
    private static final String JavaPath = "src\\main\\java";
    // 项目包名
    private static final String JavaPackagePath = "com\\pg\\generate";
    // 项目包
    private static final String myPackage = "com.pg.generate";
    // mapper地址
    private static final String mapperPath = "src\\main\\resources\\mapper";


    /**
     * 生成实体信息
     *
     * @param genTableInfo
     */
    @Override
    public int GenEntity(GenTableInfo genTableInfo) {
        // 查询到表的数据
        List<TablesSchema> tableColumnAll = tablesSchemaMapper.queryTableColumnAll(genTableInfo.getTableSchema(), genTableInfo.getTableName());
        // 获取表的名称，并转成驼峰的形式，并且第一个字母转成大写（实体类名称）
        String tableName = Common.captureName(genTableInfo.getTableName());
        // 获取表的名称，并转成驼峰的形式
        String defaultTableName = Common.underlineToCamel(genTableInfo.getTableName());
        // 表名称
        String myTableName = genTableInfo.getTableName();
        // 表注释
        String tableComment = genTableInfo.getTableComment();

        VelocityEngine velocityEngine = new VelocityEngine();
        velocityEngine.getTemplate("templates\\java\\entity.java.vm");

//        // 实例的模板数据
//        String genEntityTemplate = GenEntity.genEntity(myPackage, tableName, tableColumnAll);
//        WriteFile.writeFile(getPath() + "\\entity", tableName, genEntityTemplate);
//        // Dao的模板数据
//        String genDaoTemplate = GenDaoTemplate.genDaoTemplate(myPackage, tableName, defaultTableName);
//        WriteFile.writeFile(getPath() + "\\dao", tableName + "Mapper", genDaoTemplate);
//        // Mapper的模板数据
//        String genMapper = GenMapper.genMapper(myPackage + ".dao." + tableName + "Mapper", myPackage + ".entity." + tableName, tableName, myTableName, tableColumnAll);
//        WriteFile.writeFileXml(getMapperPath(), tableName + "Mapper", genMapper);
//        // Service的模本数据
//        String genServiceTemplate = GenServiceTemplate.genServiceTemplate(myPackage + ".service", tableName, defaultTableName);
//        WriteFile.writeFile(getPath() + "\\service", tableName + "Service", genServiceTemplate);
//        // ServiceImpl的模板数据
//        String genServiceImpl = GenServiceImpl.genServiceImpl(myPackage, tableName, defaultTableName);
//        WriteFile.writeFile(getPath() + "\\service\\impl", tableName + "ServiceImpl", genServiceImpl);
//        // Controller的模板数据
//        String genController = GenController.genController(myPackage, tableName, defaultTableName, tableComment);
//        System.out.println(genController);
//        WriteFile.writeFile(getPath() + "\\controller", tableName + "Controller", genController);


        return 0;
    }

    public static String getPath() {
        return ProjectPath + "\\" + JavaPath + "\\" + JavaPackagePath;
    }

    public static String getMapperPath() {
        return ProjectPath + "\\" + mapperPath;
    }


    public static List<String> getTemplateList() {
        List<String> templates = new ArrayList<>();
        templates.add("vm/java/entity.java.vm");
        return templates;
    }

    public static void main(String[] args) {

        VelocityInitializer.initVelocity();

        List<String> templateList = getTemplateList();
        for (String template : templateList) {
            VelocityContext context = new VelocityContext();
            Template template1 = Velocity.getTemplate(template, "UTF-8");
            Object data = template1.getData();

            System.out.println(data.toString());
        }

    }

}
