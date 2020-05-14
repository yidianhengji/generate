package com.pg.generate.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class GenTableInfo {

    @ApiModelProperty(value = "数据库名称")
    private String tableSchema;

    @ApiModelProperty(value = "表名称")
    private String tableName;

    @ApiModelProperty(value = "表注释")
    private String tableComment;
}
