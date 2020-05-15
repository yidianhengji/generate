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
        // 新增的sql语句
        StringBuffer myInsertContent = new StringBuffer();
        // 修改的sql语句
        StringBuffer myUpdateContent = new StringBuffer();
        // 获取表中的主键
        String myColumnKey = "id";
        String insertName = "";
        String insertSqlName = "";
        String updateSql = "";
        for (TablesSchema tablesSchema : tableColumnAll) {
            // 获取字段主键
            if (tablesSchema.getColumnKey().equals("PRI")) {
                myColumnKey = tablesSchema.getColumnName();
            }
            // 实体字段名称
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
            if (!tablesSchema.getColumnKey().equals("PRI")) {
                updateSql += "" +
                        "           <if test=\"" + entityName + " != null and " + entityName + " != ''\">\n" +
                        "                " + columnName + " = #{" + entityName + "},\n" +
                        "           </if>\n";
            }
            insertName += entityName + ",";
            insertSqlName += "#{" + columnName + "}" + ",";
            myResultContent.append("        <result property=\"" + entityName + "\" column=\"" + columnName + "\" jdbcType=\"" + jdbcType + "\"/>\n");
        }

        myInsertContent.append("" +
                "        " +
                "INSERT INTO " + myTableName +
                "\n           (" + insertName.substring(0, insertName.length() - 1) + ")" +
                "\n        " +
                "values" +
                "\n            (" + insertSqlName.substring(0, insertSqlName.length() - 1) + ")"
        );
        myUpdateContent.append("" +
                "       update " + myTableName + "\n" +
                "       <set>\n" + updateSql + "" +
                "       </set>\n" +
                "       WHERE " + myColumnKey + " = #{uuid}"
        );
        String s_myResultContent = myResultContent.toString();
        String s_myInsertContent = myInsertContent.toString();
        String s_myUpdateContent = myUpdateContent.toString();
        String genMapperTemplate = GenMapperTemplate.genMapperTemplate(
                myMapperNamePackage,
                myEntityNamePackage,
                myMapperName,
                myTableName,
                myColumnKey,
                s_myResultContent,
                s_myInsertContent,
                s_myUpdateContent
        );
        return genMapperTemplate;
    }
}
