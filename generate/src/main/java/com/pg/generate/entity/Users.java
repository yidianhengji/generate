package com.pg.generate.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
@TableName("tb_users")
public class Users implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "用户id")
    private String uuid;

    @ApiModelProperty(value = "真实姓名")
    private String username;

    @ApiModelProperty(value = "昵称")
    private String nickname;

    @ApiModelProperty(value = "密码")
    private String password;

    @ApiModelProperty(value = "手机号码")
    private String phone;

    @ApiModelProperty(value = "个人网站")
    private String website;

    @ApiModelProperty(value = "邮箱")
    private String email;

    @ApiModelProperty(value = "头像")
    private String imageUrl;

    @ApiModelProperty(value = "所在城市")
    private String locationCity;

    @ApiModelProperty(value = "通讯地址")
    private String address;

    @ApiModelProperty(value = "履历说明")
    private String resumeDescription;

    @ApiModelProperty(value = "擅长技术（逗号隔开）")
    private String goodAtTechnology;

    @ApiModelProperty(value = "个人简介")
    private String description;

    @ApiModelProperty(value = "创建时间")
    private Date createTime;

    @ApiModelProperty(value = "修改时间")
    private Date modifyTime;
}
