package com.pg.generate.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

@Data
public class Table {

    @ApiModelProperty(value = "数据库id")
    private String tableId;

    @ApiModelProperty(value = "项目名称")
    private String projectId;

    @ApiModelProperty(value = "数据库名称")
    private String tableSchema;

    @ApiModelProperty(value = "表名称")
    private String tableName;

    @ApiModelProperty(value = "表排序规则")
    private String tableCollation;

    @ApiModelProperty(value = "表注释")
    private String tableComment;

    @ApiModelProperty(value = "创建时间")
    private Date createTime;

    @ApiModelProperty(value = "更新时间")
    private Date modifyTime;

    private Integer PageSize;

    private Integer PageNum;

}