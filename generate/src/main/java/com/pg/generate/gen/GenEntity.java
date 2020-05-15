package com.pg.generate.gen;

import com.pg.generate.entity.TablesSchema;
import com.pg.generate.util.Common;

import java.util.List;

public class GenEntity {

    /**
     * @param myPackage      包名
     * @param tableName      实体类名称
     * @param tableColumnAll 数据库集合
     * @return
     */
    public static String genEntity(String myPackage, String tableName, List<TablesSchema> tableColumnAll) {
        // 创建一个内容StringBuffer
        StringBuffer content = new StringBuffer();
        // 拿到表的数据进行循环
        for (TablesSchema tablesSchema : tableColumnAll) {
            // 字段名称
            String columnName = Common.underlineToCamel(tablesSchema.getColumnName());
            // 字段类型
            String dataType = tablesSchema.getDataType();
            // 字段描述
            String columnComment = tablesSchema.getColumnComment();
            // 如果字段描述有的话就给它添加swagger的描述
            if (columnComment != null && !columnComment.isEmpty()) {
                content.append("    @ApiModelProperty(value = \"" + columnComment + "\")\n");
            }
            // 判断数据库的类型，并给实体类赋予对应的类型
            if (dataType.equals(GenEnum.TYPE_VARCHAR.getTypeName())) {
                content.append("    private String " + columnName + ";\n\n");
            } else if (dataType.equals(GenEnum.TYPE_INT.getTypeName())) {
                content.append("    private Integer " + columnName + ";\n\n");
            } else if (dataType.equals(GenEnum.TYPE_DATETIME.getTypeName())) {
                content.append("    private Date " + columnName + ";\n\n");
            } else {
                content.append("    private String " + columnName + ";\n\n");
            }
        }
        content.append("    private Integer pageSize;\n\n");
        content.append("    private Integer pageNum;\n\n");
        String s_content = content.toString();
        String genEntityTemplate = GenEntityTemplate.genEntityTemplate(myPackage, tableName, s_content);
        return genEntityTemplate;

    }
}
