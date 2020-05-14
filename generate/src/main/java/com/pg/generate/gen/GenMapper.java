package com.pg.generate.gen;

import com.pg.generate.entity.TablesSchema;
import com.pg.generate.util.Common;

import java.util.List;

public class GenMapper {

    public static String genMapper(
            String myMapperNamePackage,
            String myEntityNamePackage,
            String myMapperName,
            String myTableName,
            List<TablesSchema> tableColumnAll) {
        // 创建一个内容StringBuffer
        StringBuffer myResultContent = new StringBuffer();
        // 获取表中的主键
        String myColumnKey = "id";
        for (TablesSchema tablesSchema : tableColumnAll) {
            // 获取字段主键
            if (tablesSchema.getColumnKey().equals("PRI")) {
                myColumnKey = tablesSchema.getColumnName();
            }

            // 字段名称
            String entityName = Common.underlineToCamel(tablesSchema.getColumnName());
            // 表字段名称
            String columnName = tablesSchema.getColumnName();
            // 字段类型
            String dataType = tablesSchema.getDataType();
            String jdbcType = "VARCHAR";
            if (dataType.equals(GenEnum.TYPE_VARCHAR.getTypeName())) {
                jdbcType = "VARCHAR";
            } else if (dataType.equals(GenEnum.TYPE_INT.getTypeName())) {
                jdbcType = "INTEGER";
            } else if (dataType.equals(GenEnum.TYPE_DATETIME.getTypeName())) {
                jdbcType = "TIMESTAMP";
            }
            myResultContent.append("        <result property=\"" + entityName + "\" column=\"" + columnName + "\" jdbcType=\"" + jdbcType + "\"/>\n");
        }
        String s_myResultContent = myResultContent.toString();
        String genMapperTemplate = GenMapperTemplate.genMapperTemplate(
                myMapperNamePackage,
                myEntityNamePackage,
                myMapperName,
                myTableName,
                myColumnKey,
                s_myResultContent
        );
        return genMapperTemplate;
    }
}
