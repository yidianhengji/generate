/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50562
Source Host           : localhost:3306
Source Database       : generate

Target Server Type    : MYSQL
Target Server Version : 50562
File Encoding         : 65001

Date: 2020-07-22 09:09:08
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for tb_column
-- ----------------------------
DROP TABLE IF EXISTS `tb_column`;
CREATE TABLE `tb_column` (
  `column_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `table_id` varchar(64) DEFAULT NULL COMMENT '归属表编号',
  `column_name` varchar(200) DEFAULT NULL COMMENT '列名称',
  `column_comment` varchar(500) DEFAULT NULL COMMENT '列描述',
  `column_type` varchar(100) DEFAULT NULL COMMENT '列类型',
  `java_type` varchar(500) DEFAULT NULL COMMENT 'JAVA类型',
  `java_field` varchar(200) DEFAULT NULL COMMENT 'JAVA字段名',
  `is_pk` char(1) DEFAULT NULL COMMENT '是否主键（1是）',
  `is_increment` char(1) DEFAULT NULL COMMENT '是否自增（1是）',
  `is_required` char(1) DEFAULT NULL COMMENT '是否必填（1是）',
  `is_insert` char(1) DEFAULT NULL COMMENT '是否为插入字段（1是）',
  `is_edit` char(1) DEFAULT NULL COMMENT '是否编辑字段（1是）',
  `is_list` char(1) DEFAULT NULL COMMENT '是否列表字段（1是）',
  `is_query` char(1) DEFAULT NULL COMMENT '是否查询字段（1是）',
  `query_type` varchar(200) DEFAULT 'EQ' COMMENT '查询方式（等于、不等于、大于、小于、范围）',
  `html_type` varchar(200) DEFAULT NULL COMMENT '显示类型（文本框、文本域、下拉框、复选框、单选框、日期控件）',
  `dict_type` varchar(200) DEFAULT '' COMMENT '字典类型',
  `sort` int(11) DEFAULT NULL COMMENT '排序',
  `create_by` varchar(64) DEFAULT '' COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) DEFAULT '' COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`column_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=598 DEFAULT CHARSET=utf8mb4 ROW_FORMAT=DYNAMIC COMMENT='代码生成业务表字段';

-- ----------------------------
-- Records of tb_column
-- ----------------------------

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
INSERT INTO `tb_database` VALUES ('2ff62b9aa0c748c6a7566346a681f2a2', '458f0375760148a388a2a0bf9bb11e76', 'generate', 'tb_database', 'utf8_general_ci', '项目中的数据库', '2020-07-20 15:14:10', '2020-07-20 15:14:10');
INSERT INTO `tb_database` VALUES ('5697427b26e64b07868a0e3d690409d0', '5e24825c0030468a9de45912bd0efd9a', 'bbs_sifou', 'tb_recommend', 'sjis_japanese_ci', '文章、问答表', '2020-07-20 15:15:32', '2020-07-20 15:15:32');
INSERT INTO `tb_database` VALUES ('5afc461528834c29b4d28fb618db3767', '458f0375760148a388a2a0bf9bb11e76', 'generate', 'tb_projects', 'utf8_general_ci', '项目列表', '2020-07-20 15:14:10', '2020-07-20 15:14:10');
INSERT INTO `tb_database` VALUES ('6e05dbcae56849cfac8ff61dd04d631e', '5e24825c0030468a9de45912bd0efd9a', 'bbs_sifou', 'tb_users_info', 'utf8_general_ci', '用户信息表(工作经历,教育经历,开源项目 & 文章著作)', '2020-07-20 15:15:32', '2020-07-20 15:15:32');
INSERT INTO `tb_database` VALUES ('8ca54e5d7f854b3dbb62a04cc43adfbe', '5e24825c0030468a9de45912bd0efd9a', 'bbs_sifou', 'tb_users', 'utf8_general_ci', '用户表', '2020-07-20 15:15:32', '2020-07-20 15:15:32');
INSERT INTO `tb_database` VALUES ('92ab971406b244feb77114c98a0c27e5', '5e24825c0030468a9de45912bd0efd9a', 'bbs_sifou', 'tb_channels', 'utf8_general_ci', '频道表', '2020-07-20 15:15:32', '2020-07-20 15:15:32');
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
