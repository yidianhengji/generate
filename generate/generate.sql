/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50562
Source Host           : localhost:3306
Source Database       : generate

Target Server Type    : MYSQL
Target Server Version : 50562
File Encoding         : 65001

Date: 2020-07-24 10:31:04
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for tb_column
-- ----------------------------
DROP TABLE IF EXISTS `tb_column`;
CREATE TABLE `tb_column` (
  `column_id` varchar(50) NOT NULL,
  `table_id` varchar(50) DEFAULT NULL COMMENT '归属表编号',
  `column_name` varchar(50) DEFAULT NULL COMMENT '列名称',
  `column_comment` varchar(50) DEFAULT NULL COMMENT '列描述',
  `column_type` varchar(50) DEFAULT NULL COMMENT '列类型',
  `java_type` varchar(50) DEFAULT NULL COMMENT 'JAVA类型',
  `java_field` varchar(50) DEFAULT NULL COMMENT 'JAVA字段名',
  `is_pk` varchar(50) DEFAULT NULL COMMENT '主键标识',
  `is_required` int(10) DEFAULT '1' COMMENT '是否必填（1是）',
  `is_insert` int(10) DEFAULT '1' COMMENT '是否为插入字段（1是）',
  `is_edit` int(10) DEFAULT '1' COMMENT '是否编辑字段（1是）',
  `is_list` int(10) DEFAULT '1' COMMENT '是否列表字段（1是）',
  `is_query` int(10) DEFAULT '1' COMMENT '是否查询字段（1是）',
  `html_type` varchar(10) DEFAULT NULL COMMENT '显示类型（文本框、文本域、下拉框、复选框、单选框、日期控件）',
  `create_time` datetime DEFAULT NULL,
  `modify_time` datetime DEFAULT NULL,
  PRIMARY KEY (`column_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='表字段';

-- ----------------------------
-- Records of tb_column
-- ----------------------------
INSERT INTO `tb_column` VALUES ('03f871e03ac64183b2ba18b753368550', 'bdc6ab710bee433b86d4bcd22afb44ac', 'flag', '1正常 2删除', 'int', null, null, '', null, null, null, null, null, null, '2020-07-22 16:57:38', '2020-07-22 16:57:38');
INSERT INTO `tb_column` VALUES ('0b459bef5f124cbfb1ed36700799eaf7', 'bdc6ab710bee433b86d4bcd22afb44ac', 'project_path', '项目地址', 'varchar', null, null, '', null, null, null, null, null, null, '2020-07-22 16:57:38', '2020-07-22 16:57:38');
INSERT INTO `tb_column` VALUES ('0bec8cfb503a496d89280fb6edf91717', '760da9e6d5694879960a01811e8fcc1a', 'column_comment', '列描述', 'varchar', null, null, '', null, null, null, null, null, null, '2020-07-22 16:57:38', '2020-07-22 16:57:38');
INSERT INTO `tb_column` VALUES ('1b4fb6c6e6ea44508e40111f500f2fd5', '760da9e6d5694879960a01811e8fcc1a', 'column_type', '列类型', 'varchar', null, null, '', null, null, null, null, null, null, '2020-07-22 16:57:38', '2020-07-22 16:57:38');
INSERT INTO `tb_column` VALUES ('21d7ac28f25745a383cd8e707073e8ac', '760da9e6d5694879960a01811e8fcc1a', 'table_id', '归属表编号', 'varchar', null, null, '', null, null, null, null, null, null, '2020-07-22 16:57:38', '2020-07-22 16:57:38');
INSERT INTO `tb_column` VALUES ('29a55919452449a5b1b815c8f6b4fb54', 'bdc6ab710bee433b86d4bcd22afb44ac', 'java_path', 'java地址', 'varchar', null, null, '', null, null, null, null, null, null, '2020-07-22 16:57:38', '2020-07-22 16:57:38');
INSERT INTO `tb_column` VALUES ('3b4addd3c7b84824aea9a4971c5dab17', '760da9e6d5694879960a01811e8fcc1a', 'is_pk', '主键标识', 'varchar', null, null, '', null, null, null, null, null, null, '2020-07-22 16:57:38', '2020-07-22 16:57:38');
INSERT INTO `tb_column` VALUES ('40925d0759a34479bda41a18b72dab94', '5e94a5f8938e40049ae0e1406ae2a4f9', 'table_id', '数据库id', 'varchar', null, null, 'PRI', null, null, null, null, null, null, '2020-07-22 16:57:38', '2020-07-22 16:57:38');
INSERT INTO `tb_column` VALUES ('412dedbe4349458b805125baa6e5479e', '760da9e6d5694879960a01811e8fcc1a', 'html_type', '显示类型（文本框、文本域、下拉框、复选框、单选框、日期控件）', 'varchar', null, null, '', null, null, null, null, null, null, '2020-07-22 16:57:38', '2020-07-22 16:57:38');
INSERT INTO `tb_column` VALUES ('4c71b72b01bd4dd88dc6394f7845f9dd', 'bdc6ab710bee433b86d4bcd22afb44ac', 'description', '描述', 'varchar', null, null, '', null, null, null, null, null, null, '2020-07-22 16:57:38', '2020-07-22 16:57:38');
INSERT INTO `tb_column` VALUES ('4e673d2836e9457e82060da8d1cdbbc9', '760da9e6d5694879960a01811e8fcc1a', 'is_insert', '是否为插入字段（1是）', 'int', null, null, '', null, null, null, null, null, null, '2020-07-22 16:57:38', '2020-07-22 16:57:38');
INSERT INTO `tb_column` VALUES ('4efcbefe65f9439c92f9226ae13e925d', '760da9e6d5694879960a01811e8fcc1a', 'column_name', '列名称', 'varchar', null, null, '', null, null, null, null, null, null, '2020-07-22 16:57:38', '2020-07-22 16:57:38');
INSERT INTO `tb_column` VALUES ('681dd3c9f4394e8fa2bdcccb2f896639', '5e94a5f8938e40049ae0e1406ae2a4f9', 'project_id', '项目名称', 'varchar', null, null, '', null, null, null, null, null, null, '2020-07-22 16:57:38', '2020-07-22 16:57:38');
INSERT INTO `tb_column` VALUES ('6e5c0ad4d5e34096aea4b2898d5e55be', 'bdc6ab710bee433b86d4bcd22afb44ac', 'database_name', '数据库名称', 'varchar', null, null, '', null, null, null, null, null, null, '2020-07-22 16:57:38', '2020-07-22 16:57:38');
INSERT INTO `tb_column` VALUES ('7655446d5f034fb687ebb8cd5977e1fe', '5e94a5f8938e40049ae0e1406ae2a4f9', 'table_collation', '表排序规则', 'varchar', null, null, '', null, null, null, null, null, null, '2020-07-22 16:57:38', '2020-07-22 16:57:38');
INSERT INTO `tb_column` VALUES ('7710bc465c034b5287e3e35ebeb69e8d', 'bdc6ab710bee433b86d4bcd22afb44ac', 'create_time', '创建时间', 'datetime', null, null, '', null, null, null, null, null, null, '2020-07-22 16:57:38', '2020-07-22 16:57:38');
INSERT INTO `tb_column` VALUES ('81e8afc2c6c1419396b3280705fc7174', 'bdc6ab710bee433b86d4bcd22afb44ac', 'package_path', '项目包名', 'varchar', null, null, '', null, null, null, null, null, null, '2020-07-22 16:57:38', '2020-07-22 16:57:38');
INSERT INTO `tb_column` VALUES ('91da9fa8aa074cc49239cd6f81c074cb', '5e94a5f8938e40049ae0e1406ae2a4f9', 'create_time', '创建时间', 'datetime', null, null, '', null, null, null, null, null, null, '2020-07-22 16:57:38', '2020-07-22 16:57:38');
INSERT INTO `tb_column` VALUES ('9b3f6a37f06e4106818b09bf82642bc4', 'bdc6ab710bee433b86d4bcd22afb44ac', 'mapper_path', 'mapper地址', 'varchar', null, null, '', null, null, null, null, null, null, '2020-07-22 16:57:38', '2020-07-22 16:57:38');
INSERT INTO `tb_column` VALUES ('9d30bad89d2f460bbb5b26663d158fac', 'bdc6ab710bee433b86d4bcd22afb44ac', 'project_name', '项目名称', 'varchar', null, null, '', null, null, null, null, null, null, '2020-07-22 16:57:38', '2020-07-22 16:57:38');
INSERT INTO `tb_column` VALUES ('a3e5ae8514fd424ea168256ab829f0c1', '760da9e6d5694879960a01811e8fcc1a', 'is_query', '是否查询字段（1是）', 'int', null, null, '', null, null, null, null, null, null, '2020-07-22 16:57:38', '2020-07-22 16:57:38');
INSERT INTO `tb_column` VALUES ('aa252758952243f381a223d1f30eeada', 'bdc6ab710bee433b86d4bcd22afb44ac', 'modify_time', '更新时间', 'datetime', null, null, '', null, null, null, null, null, null, '2020-07-22 16:57:38', '2020-07-22 16:57:38');
INSERT INTO `tb_column` VALUES ('ac4c8e08524f4d1fb7c7ad60fad61e30', '760da9e6d5694879960a01811e8fcc1a', 'java_type', 'JAVA类型', 'varchar', null, null, '', null, null, null, null, null, null, '2020-07-22 16:57:38', '2020-07-22 16:57:38');
INSERT INTO `tb_column` VALUES ('b578f94a577d477fafe14fad8b52fbef', '5e94a5f8938e40049ae0e1406ae2a4f9', 'table_schema', '数据库名称', 'varchar', null, null, '', null, null, null, null, null, null, '2020-07-22 16:57:38', '2020-07-22 16:57:38');
INSERT INTO `tb_column` VALUES ('bb59ae63f6544af885b29910a91916a4', 'bdc6ab710bee433b86d4bcd22afb44ac', 'project_id', '项目id', 'varchar', null, null, 'PRI', null, null, null, null, null, null, '2020-07-22 16:57:38', '2020-07-22 16:57:38');
INSERT INTO `tb_column` VALUES ('bd1e58d370974eb5ad1f9da6f8c0c2ed', '760da9e6d5694879960a01811e8fcc1a', 'is_list', '是否列表字段（1是）', 'int', null, null, '', null, null, null, null, null, null, '2020-07-22 16:57:38', '2020-07-22 16:57:38');
INSERT INTO `tb_column` VALUES ('bf22231f644d46238d576c03a88e1704', 'bdc6ab710bee433b86d4bcd22afb44ac', 'package_path_t', '项目包', 'varchar', null, null, '', null, null, null, null, null, null, '2020-07-22 16:57:38', '2020-07-22 16:57:38');
INSERT INTO `tb_column` VALUES ('cb36995f6ea84a10a5a3d25a630be39b', '5e94a5f8938e40049ae0e1406ae2a4f9', 'table_comment', '表注释', 'varchar', null, null, '', null, null, null, null, null, null, '2020-07-22 16:57:38', '2020-07-22 16:57:38');
INSERT INTO `tb_column` VALUES ('cdb60ca764eb430eaf1648463489180e', '760da9e6d5694879960a01811e8fcc1a', 'create_time', '', 'datetime', null, null, '', null, null, null, null, null, null, '2020-07-22 16:57:38', '2020-07-22 16:57:38');
INSERT INTO `tb_column` VALUES ('cfdf11c1891640e39627d089cebc261f', '760da9e6d5694879960a01811e8fcc1a', 'modify_time', '', 'datetime', null, null, '', null, null, null, null, null, null, '2020-07-22 16:57:38', '2020-07-22 16:57:38');
INSERT INTO `tb_column` VALUES ('d46c58caa2c24f289eacf77a9a3c54d3', '760da9e6d5694879960a01811e8fcc1a', 'java_field', 'JAVA字段名', 'varchar', null, null, '', null, null, null, null, null, null, '2020-07-22 16:57:38', '2020-07-22 16:57:38');
INSERT INTO `tb_column` VALUES ('d5a048858d26433f9ce3623046021263', '5e94a5f8938e40049ae0e1406ae2a4f9', 'table_name', '表名称', 'varchar', null, null, '', null, null, null, null, null, null, '2020-07-22 16:57:38', '2020-07-22 16:57:38');
INSERT INTO `tb_column` VALUES ('ec0ead6873764d49939807f48612936d', '5e94a5f8938e40049ae0e1406ae2a4f9', 'modify_time', '更新时间', 'datetime', null, null, '', null, null, null, null, null, null, '2020-07-22 16:57:38', '2020-07-22 16:57:38');
INSERT INTO `tb_column` VALUES ('ef1a160af12041518fca3a30bcb09faf', '760da9e6d5694879960a01811e8fcc1a', 'is_required', '是否必填（1是）', 'int', null, null, '', null, null, null, null, null, null, '2020-07-22 16:57:38', '2020-07-22 16:57:38');
INSERT INTO `tb_column` VALUES ('f48d859afaa84db7bd35acd18171a7ad', '760da9e6d5694879960a01811e8fcc1a', 'is_edit', '是否编辑字段（1是）', 'int', null, null, '', null, null, null, null, null, null, '2020-07-22 16:57:38', '2020-07-22 16:57:38');
INSERT INTO `tb_column` VALUES ('f8dd2e3f53314996a59a48c7c9a35419', '760da9e6d5694879960a01811e8fcc1a', 'column_id', '', 'varchar', null, null, 'PRI', null, null, null, null, null, null, '2020-07-22 16:57:38', '2020-07-22 16:57:38');

-- ----------------------------
-- Table structure for tb_database
-- ----------------------------
DROP TABLE IF EXISTS `tb_database`;
CREATE TABLE `tb_database` (
  `table_id` varchar(50) NOT NULL COMMENT '数据库id',
  `project_id` varchar(50) DEFAULT NULL COMMENT '项目名称',
  `table_schema` varchar(50) DEFAULT NULL COMMENT '数据库名称',
  `table_name` varchar(50) DEFAULT NULL COMMENT '表名称',
  `table_collation` varchar(50) DEFAULT NULL COMMENT '表排序规则',
  `table_comment` varchar(50) DEFAULT NULL COMMENT '表注释',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `modify_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`table_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='项目中的数据库';

-- ----------------------------
-- Records of tb_database
-- ----------------------------
INSERT INTO `tb_database` VALUES ('16fd73b8f77b4cafb9dde7e1ea5bbcf3', '5e24825c0030468a9de45912bd0efd9a', 'bbs_sifou', 'tb_recommend_vote', 'utf8_general_ci', '文章、问答点赞表', '2020-07-20 15:15:32', '2020-07-20 15:15:32');
INSERT INTO `tb_database` VALUES ('2f2fe59e005b400c8774ccb479bc63ae', '5e24825c0030468a9de45912bd0efd9a', 'bbs_sifou', 'tb_comment', 'utf8_general_ci', '评论主表', '2020-07-20 15:15:32', '2020-07-20 15:15:32');
INSERT INTO `tb_database` VALUES ('5697427b26e64b07868a0e3d690409d0', '5e24825c0030468a9de45912bd0efd9a', 'bbs_sifou', 'tb_recommend', 'sjis_japanese_ci', '文章、问答表', '2020-07-20 15:15:32', '2020-07-20 15:15:32');
INSERT INTO `tb_database` VALUES ('5e94a5f8938e40049ae0e1406ae2a4f9', '458f0375760148a388a2a0bf9bb11e76', 'generate', 'tb_database', 'utf8_general_ci', '项目中的数据库', '2020-07-22 16:57:38', '2020-07-22 16:57:38');
INSERT INTO `tb_database` VALUES ('6e05dbcae56849cfac8ff61dd04d631e', '5e24825c0030468a9de45912bd0efd9a', 'bbs_sifou', 'tb_users_info', 'utf8_general_ci', '用户信息表(工作经历,教育经历,开源项目 & 文章著作)', '2020-07-20 15:15:32', '2020-07-20 15:15:32');
INSERT INTO `tb_database` VALUES ('760da9e6d5694879960a01811e8fcc1a', '458f0375760148a388a2a0bf9bb11e76', 'generate', 'tb_column', 'utf8_general_ci', '表字段', '2020-07-22 16:57:38', '2020-07-22 16:57:38');
INSERT INTO `tb_database` VALUES ('8ca54e5d7f854b3dbb62a04cc43adfbe', '5e24825c0030468a9de45912bd0efd9a', 'bbs_sifou', 'tb_users', 'utf8_general_ci', '用户表', '2020-07-20 15:15:32', '2020-07-20 15:15:32');
INSERT INTO `tb_database` VALUES ('92ab971406b244feb77114c98a0c27e5', '5e24825c0030468a9de45912bd0efd9a', 'bbs_sifou', 'tb_channels', 'utf8_general_ci', '频道表', '2020-07-20 15:15:32', '2020-07-20 15:15:32');
INSERT INTO `tb_database` VALUES ('bdc6ab710bee433b86d4bcd22afb44ac', '458f0375760148a388a2a0bf9bb11e76', 'generate', 'tb_projects', 'utf8_general_ci', '项目列表', '2020-07-22 16:57:38', '2020-07-22 16:57:38');
INSERT INTO `tb_database` VALUES ('f2285b888dde4024a96d7ddbfcd3c474', '5e24825c0030468a9de45912bd0efd9a', 'bbs_sifou', 'tb_labels', 'utf8_general_ci', '标签表', '2020-07-20 15:15:32', '2020-07-20 15:15:32');

-- ----------------------------
-- Table structure for tb_projects
-- ----------------------------
DROP TABLE IF EXISTS `tb_projects`;
CREATE TABLE `tb_projects` (
  `project_id` varchar(50) NOT NULL COMMENT '项目id',
  `project_name` varchar(20) DEFAULT NULL COMMENT '项目名称',
  `flag` int(11) DEFAULT NULL COMMENT '1正常 2删除',
  `description` varchar(50) DEFAULT NULL COMMENT '描述',
  `project_path` varchar(255) DEFAULT NULL COMMENT '项目地址',
  `java_path` varchar(255) DEFAULT NULL COMMENT 'java地址',
  `package_path` varchar(255) DEFAULT NULL COMMENT '项目包名',
  `package_path_t` varchar(255) DEFAULT NULL COMMENT '项目包',
  `mapper_path` varchar(255) DEFAULT NULL COMMENT 'mapper地址',
  `database_name` varchar(20) DEFAULT NULL COMMENT '数据库名称',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `modify_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`project_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='项目列表';

-- ----------------------------
-- Records of tb_projects
-- ----------------------------
INSERT INTO `tb_projects` VALUES ('458f0375760148a388a2a0bf9bb11e76', '项目二', null, '提供具体完整案例的一站式研发解决方案的范例项目', 'F:\\shop\\generate\\generate', 'src\\main\\java', 'com\\pg\\generate', 'com.pg.generate', 'src\\main\\resources\\mapper', 'generate', '2020-07-16 14:50:50', '2020-07-16 15:00:29');
INSERT INTO `tb_projects` VALUES ('5e24825c0030468a9de45912bd0efd9a', '项目四', null, '提供具体完整案例的一站式研发解决方案的范例项目', null, null, null, null, null, 'bbs_sifou', '2020-07-16 14:51:38', '2020-07-20 15:15:21');
INSERT INTO `tb_projects` VALUES ('b776290209094c878bb1f509bd3acab6', '项目一', null, '提供具体完整案例的一站式研发解决方案的范例项目', null, null, null, null, null, null, '2020-07-16 14:48:04', '2020-07-16 14:48:04');
INSERT INTO `tb_projects` VALUES ('bca66745136c4ab5a39ce7897273288b', '项目三', null, '提供具体完整案例的一站式研发解决方案的范例项目', null, null, null, null, null, null, '2020-07-16 14:51:26', '2020-07-16 14:51:26');
