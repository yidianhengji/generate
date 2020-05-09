package com.pg.generate.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
public class Tables implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "数据库名称")
    private String tableSchema;

    @ApiModelProperty(value = "表名称")
    private String tableName;

    @ApiModelProperty(value = "表排序规则")
    private String tableCollation;

    @ApiModelProperty(value = "表注释")
    private String tableComment;

    @ApiModelProperty(value = "表创建的时间")
    private String createTime;
}
