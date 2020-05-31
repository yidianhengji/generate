package com.pg.generate.service.impl;

import com.pg.generate.dao.TablesSchemaMapper;
import com.pg.generate.dto.GenTableInfo;
import com.pg.generate.entity.TablesSchema;
import com.pg.generate.service.GensService;
import com.pg.generate.util.Common;
import com.pg.generate.util.GetPath;
import com.pg.generate.util.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;
import org.apache.velocity.app.VelocityEngine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import javax.annotation.Resource;
import java.io.StringWriter;
import java.util.List;
import java.util.Properties;

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


        //初始化参数
        Properties properties=new Properties();
        //设置velocity资源加载方式为class
        properties.setProperty("resource.loader", "class");
        //设置velocity资源加载方式为file时的处理类
        properties.setProperty("class.resource.loader.class", "org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader");
        //实例化一个VelocityEngine对象
        VelocityEngine velocityEngine=new VelocityEngine(properties);
        //实例化一个VelocityContext
        VelocityContext context=new VelocityContext();
        //向VelocityContext中放入键值
        context.put("user", "张三");
        context.put("password", "123456789");
        context.put("age", "20");
        context.put("address", "陕西西安");
        context.put("blog", "http://blogjava.net/sxyx2008");
        //实例化一个StringWriter
        StringWriter writer=new StringWriter();
        //从src目录下加载hello.vm模板
        List<String> templateVmList = Template.getTemplateVmList();
        for (String templatesPath : templateVmList){
            velocityEngine.mergeTemplate(templatesPath, "UTF-8", context, writer);
            System.out.println(writer.toString());
        }


//        // 查询到表的数据
//        List<TablesSchema> tableColumnAll = tablesSchemaMapper.queryTableColumnAll(genTableInfo.getTableSchema(), genTableInfo.getTableName());
//        // 获取表的名称，并转成驼峰的形式，并且第一个字母转成大写（实体类名称）
//        String ClassName = Common.captureName(genTableInfo.getTableName());
//        // 获取表的名称，并转成驼峰的形式
//        String className = Common.underlineToCamel(genTableInfo.getTableName());
//        // 获取全部的模板
//        List<String> templateList = Template.getTemplateList();
//        // 遍历模板
//        for (String string : templateList) {
//            //初始化运行上下文
//            Context context = new Context();
//            // 给模板设置共通的值  包名 类名
//            context.setVariable("packageName", GetPath.getPackageName());
//            context.setVariable("ClassName", ClassName);
//            context.setVariable("className", className);
//            context.setVariable("tableColumnAll", tableColumnAll);
//            // 给模板赋值
//            String process = templateEngine.process(string, context);
//            System.out.println(process);
//        }


        return 0;
    }

    public static void main(String[] args) {
        System.out.println(1);
    }


}
