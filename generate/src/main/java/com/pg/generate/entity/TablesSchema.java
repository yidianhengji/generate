package com.pg.generate.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class TablesSchema {

    @ApiModelProperty(value = "字段名称")
    private String columnName;

    @ApiModelProperty(value = "实体字段名称")
    private String javaColumnName;

    @ApiModelProperty(value = "字段类型")
    private String dataType;

    @ApiModelProperty(value = "代码字段类型")
    private String codeDataType;

    @ApiModelProperty(value = "mybatis字段类型")
    private String jdbcType;

    @ApiModelProperty(value = "字段长度")
    private String characterMaximumLength;

    @ApiModelProperty(value = "字段编码")
    private String collationName;

    @ApiModelProperty(value = "字段描述")
    private String columnComment;

    @ApiModelProperty(value = "表列键")
    private String columnKey;

}
