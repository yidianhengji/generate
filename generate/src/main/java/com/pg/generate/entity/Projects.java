package com.pg.generate.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

@Data
public class Projects {

    @ApiModelProperty(value = "项目id")
    private String projectId;

    @ApiModelProperty(value = "项目名称")
    private String projectName;

    @ApiModelProperty(value = "1正常 2删除")
    private Integer flag;

    @ApiModelProperty(value = "描述")
    private String description;

    @ApiModelProperty(value = "项目地址")
    private String projectPath;

    @ApiModelProperty(value = "java地址")
    private String javaPath;

    @ApiModelProperty(value = "项目包名")
    private String packagePath;

    @ApiModelProperty(value = "项目包")
    private String packagePathT;

    @ApiModelProperty(value = "mapper地址")
    private String mapperPath;

    @ApiModelProperty(value = "数据库名称")
    private String databaseName;

    @ApiModelProperty(value = "创建时间")
    private Date createTime;

    @ApiModelProperty(value = "更新时间")
    private Date modifyTime;

    private Integer PageSize;

    private Integer PageNum;

}