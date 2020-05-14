package com.pg.generate.service.impl;

import com.pg.generate.dao.TablesSchemaMapper;
import com.pg.generate.dto.GenTableInfo;
import com.pg.generate.entity.TablesSchema;
import com.pg.generate.gen.GenDaoTemplate;
import com.pg.generate.gen.GenEntity;
import com.pg.generate.gen.GenMapper;
import com.pg.generate.service.GenService;
import com.pg.generate.util.Common;
import com.pg.generate.util.WriteFile;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class GenServiceImpl implements GenService {

    @Resource
    private TablesSchemaMapper tablesSchemaMapper;

    // 项目所在的路径
    private static final String ProjectPath = "F:\\shop\\generate\\generate";
    // java地址
    private static final String JavaPath = "src\\main\\java";
    // 项目包名
    private static final String JavaPackagePath = "com\\pg\\generate";

    private static final String myPackage = "com.pg.generate";

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



        // 实例的模板数据
        //String genEntityTemplate = GenEntity.genEntity(myPackage + ".entity", tableName, tableColumnAll);
        //WriteFile.writeFile(getPath() + "\\entity", tableName, genEntityTemplate);
        // Dao的模板数据
        //String genDaoTemplate = GenDaoTemplate.genDaoTemplate(myPackage + ".dao", tableName, defaultTableName);
        //WriteFile.writeFile(getPath() + "\\dao", tableName + "Mapper", genDaoTemplate);

        String genMapper = GenMapper.genMapper(myPackage + ".dao." + tableName + "Mapper", myPackage + ".entity." + tableName, tableName, myTableName, tableColumnAll);
        System.out.println(genMapper);
        return 0;
    }

    public static String getPath() {
        return ProjectPath + "\\" + JavaPath + "\\" + JavaPackagePath;
    }

}
