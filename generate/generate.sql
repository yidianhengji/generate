-- --------------------------------------------------------
-- 主机:                           127.0.0.1
-- 服务器版本:                        10.5.2-MariaDB - mariadb.org binary distribution
-- 服务器OS:                        Win64
-- HeidiSQL 版本:                  10.2.0.5599
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- Dumping database structure for generate
DROP DATABASE IF EXISTS `generate`;
CREATE DATABASE IF NOT EXISTS `generate` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `generate`;

-- Dumping structure for table generate.tb_projects
DROP TABLE IF EXISTS `tb_projects`;
CREATE TABLE IF NOT EXISTS `tb_projects` (
  `project_id` varchar(50) NOT NULL COMMENT '项目id',
  `project_name` varchar(20) DEFAULT NULL COMMENT '项目名称',
  `flag` int(11) DEFAULT NULL COMMENT '1正常 2删除',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `modify_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`project_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='项目列表';

-- Data exporting was unselected.

-- Dumping structure for table generate.tb_table
DROP TABLE IF EXISTS `tb_table`;
CREATE TABLE IF NOT EXISTS `tb_table` (
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

-- Data exporting was unselected.

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
