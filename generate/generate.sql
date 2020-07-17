/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50562
Source Host           : localhost:3306
Source Database       : generate

Target Server Type    : MYSQL
Target Server Version : 50562
File Encoding         : 65001

Date: 2020-07-17 14:20:11
*/

SET FOREIGN_KEY_CHECKS=0;

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
INSERT INTO `tb_projects` VALUES ('5e24825c0030468a9de45912bd0efd9a', '项目四', null, '提供具体完整案例的一站式研发解决方案的范例项目', null, null, null, null, null, 'generate', '2020-07-16 14:51:38', '2020-07-16 15:00:44');
INSERT INTO `tb_projects` VALUES ('b776290209094c878bb1f509bd3acab6', '项目一', null, '提供具体完整案例的一站式研发解决方案的范例项目', null, null, null, null, null, null, '2020-07-16 14:48:04', '2020-07-16 14:48:04');
INSERT INTO `tb_projects` VALUES ('bca66745136c4ab5a39ce7897273288b', '项目三', null, '提供具体完整案例的一站式研发解决方案的范例项目', null, null, null, null, null, null, '2020-07-16 14:51:26', '2020-07-16 14:51:26');
