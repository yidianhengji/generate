package com.pg.generate.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

@Data
public class Column {

    private String columnId;

    @ApiModelProperty(value = "归属表编号")
    private String tableId;

    @ApiModelProperty(value = "列名称")
    private String columnName;

    @ApiModelProperty(value = "列描述")
    private String columnComment;

    @ApiModelProperty(value = "列类型")
    private String columnType;

    @ApiModelProperty(value = "JAVA类型")
    private String javaType;

    @ApiModelProperty(value = "JAVA字段名")
    private String javaField;

    @ApiModelProperty(value = "主键标识")
    private String isPk;

    @ApiModelProperty(value = "是否必填（1是）")
    private Integer isRequired;

    @ApiModelProperty(value = "是否为插入字段（1是）")
    private Integer isInsert;

    @ApiModelProperty(value = "是否编辑字段（1是）")
    private Integer isEdit;

    @ApiModelProperty(value = "是否列表字段（1是）")
    private Integer isList;

    @ApiModelProperty(value = "是否查询字段（1是）")
    private Integer isQuery;

    @ApiModelProperty(value = "显示类型（文本框、文本域、下拉框、复选框、单选框、日期控件）")
    private String htmlType;

    private Date createTime;

    private Date modifyTime;

    private Integer PageSize;

    private Integer PageNum;

}