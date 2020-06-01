package com.pg.generate.util;

import com.pg.generate.entity.TablesSchema;

import java.util.List;

public class GenUtils {

    /**
     * 初始化表信息
     * @param tablesSchema
     * @return
     */
    public static List<TablesSchema> initColumnField(List<TablesSchema> tablesSchema) {
        for (TablesSchema item : tablesSchema) {
            item.setJavaColumnName(Common.underlineToCamel(item.getColumnName()));
            if(item.getDataType().equals(GenEnum.TYPE_VARCHAR.getTypeName())){
                item.setCodeDataType(GenEnum.TYPE_JAVA_VARCHAR.getTypeName());
            } else if(item.getDataType().equals(GenEnum.TYPE_INT.getTypeName())) {
                item.setCodeDataType(GenEnum.TYPE_JAVA_INT.getTypeName());
            } else if(item.getDataType().equals(GenEnum.TYPE_DATETIME.getTypeName())) {
                item.setCodeDataType(GenEnum.TYPE_JAVA_DATETIME.getTypeName());
            } else {
                item.setCodeDataType(GenEnum.TYPE_JAVA_VARCHAR.getTypeName());
            }
        }
        return tablesSchema;
    }

    /**
     * 获取表的主键
     * @param tablesSchema
     * @return
     */
    public static String initColumnKey(List<TablesSchema> tablesSchema) {
        String columnPriKey = "";
        for (TablesSchema item : tablesSchema) {
            if(item.getColumnKey().equals("PRI")){
                columnPriKey=item.getColumnName();
                break;
            }
        }
        return columnPriKey;
    }

}
