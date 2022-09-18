/*
 Navicat Premium Data Transfer

 Source Server         : MYSQL
 Source Server Type    : MySQL
 Source Server Version : 50716
 Source Host           : localhost:3306
 Source Schema         : bh_wms

 Target Server Type    : MySQL
 Target Server Version : 50716
 File Encoding         : 65001

 Date: 18/09/2022 10:26:55
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for carrier
-- ----------------------------
DROP TABLE IF EXISTS `carrier`;
CREATE TABLE `carrier` (
  `CARRIER_ID` int(11) NOT NULL AUTO_INCREMENT COMMENT '承运商ID,主键自增',
  `CARRIER_NAME` varchar(100) NOT NULL COMMENT '承运商名称',
  `CARRIER_LEADER` varchar(100) NOT NULL COMMENT '承运商负责人',
  `CARRIER_TEL` varchar(100) NOT NULL COMMENT '联系电话',
  `CARRIER_EMAIL` varchar(100) DEFAULT NULL COMMENT '联系邮箱',
  `CARRIER_ADDRESS` varchar(255) DEFAULT NULL COMMENT '联系地址',
  `CREATE_TIME` datetime DEFAULT NULL COMMENT '创建时间',
  `UPDATE_TIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '设置当前时间，并且自动更更新时间',
  `IS_DELETE` int(11) DEFAULT '1' COMMENT '是否删除 0:删除 1:未删除',
  PRIMARY KEY (`CARRIER_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='承运商表';

-- ----------------------------
-- Records of carrier
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for category
-- ----------------------------
DROP TABLE IF EXISTS `category`;
CREATE TABLE `category` (
  `CATEGORY_ID` int(11) NOT NULL AUTO_INCREMENT COMMENT '类目ID,主键自增',
  `CATEGORY_NAME` varchar(100) NOT NULL COMMENT '类目名称',
  `LEVEL` int(11) DEFAULT '1' COMMENT '层级',
  `PARENT_ID` int(11) DEFAULT '0' COMMENT '父ID,关联主键(自关联),顶层父ID为0',
  `CREATE_TIME` datetime DEFAULT NULL COMMENT '创建时间',
  `UPDATE_TIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '设置当前时间，并且自动更更新时间',
  `IS_DELETE` int(11) DEFAULT '1' COMMENT '是否删除 0:删除 1:未删除',
  PRIMARY KEY (`CATEGORY_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8 COMMENT='商品类目表';

-- ----------------------------
-- Records of category
-- ----------------------------
BEGIN;
INSERT INTO `category` VALUES (1, '一级类目标题1', 1, 0, '2022-09-17 23:09:12', '2022-09-17 23:09:12', 1);
INSERT INTO `category` VALUES (2, '一级类目标题2', 1, 0, '2022-09-17 23:09:12', '2022-09-17 23:09:12', 1);
INSERT INTO `category` VALUES (3, '一级类目标题3', 1, 0, '2022-09-17 23:09:12', '2022-09-17 23:09:12', 1);
INSERT INTO `category` VALUES (4, '一级类目标题4', 1, 0, '2022-09-17 23:09:12', '2022-09-17 23:09:12', 1);
INSERT INTO `category` VALUES (5, '一级类目标题5', 1, 0, '2022-09-17 23:09:12', '2022-09-17 23:09:12', 1);
INSERT INTO `category` VALUES (6, '二级类目标题1', 2, 1, '2022-09-17 23:11:05', '2022-09-17 23:11:05', 1);
INSERT INTO `category` VALUES (7, '二级类目标题2', 2, 1, '2022-09-17 23:11:05', '2022-09-17 23:11:05', 1);
INSERT INTO `category` VALUES (8, '二级类目标题1', 2, 2, '2022-09-17 23:11:05', '2022-09-17 23:11:05', 1);
INSERT INTO `category` VALUES (9, '二级类目标题2', 2, 2, '2022-09-17 23:11:05', '2022-09-17 23:11:05', 1);
INSERT INTO `category` VALUES (10, '二级类目标题1', 2, 3, '2022-09-17 23:11:05', '2022-09-17 23:11:05', 1);
INSERT INTO `category` VALUES (11, '二级类目标题2', 2, 3, '2022-09-17 23:11:05', '2022-09-17 23:11:05', 1);
INSERT INTO `category` VALUES (12, '二级类目标题1', 2, 4, '2022-09-17 23:11:05', '2022-09-17 23:11:05', 1);
INSERT INTO `category` VALUES (13, '二级类目标题2', 2, 4, '2022-09-17 23:11:05', '2022-09-17 23:11:05', 1);
INSERT INTO `category` VALUES (14, '二级类目标题1', 2, 5, '2022-09-17 23:11:05', '2022-09-17 23:11:05', 1);
INSERT INTO `category` VALUES (15, '二级类目标题2', 2, 5, '2022-09-17 23:11:05', '2022-09-17 23:11:05', 1);
COMMIT;

-- ----------------------------
-- Table structure for customer
-- ----------------------------
DROP TABLE IF EXISTS `customer`;
CREATE TABLE `customer` (
  `CUSTOMER_ID` int(11) NOT NULL AUTO_INCREMENT COMMENT '客户ID,主键自增',
  `CUSTOMER_NAME` varchar(100) NOT NULL COMMENT '客户名称,如果为公司,那么是公司名,如果为个人,那么填写个人名称',
  `CUSTOMER_LEADER` varchar(100) NOT NULL COMMENT '客户负责人,如果公司为个人,那么和CUSTOMER_NAME内容相同',
  `CUSTOMER_TEL` varchar(100) NOT NULL COMMENT '联系电话',
  `CUSTOMER_EMAIL` varchar(100) DEFAULT NULL COMMENT '联系邮箱',
  `CUSTOMER_ADDRESS` varchar(255) DEFAULT NULL COMMENT '联系地址',
  `LEVEL_ID` int(11) NOT NULL COMMENT '客户级别,关联级别表主键',
  `SOURCE_ID` int(11) NOT NULL COMMENT '客户来源,关联来源表主键',
  `INDUSTRY_ID` int(11) NOT NULL COMMENT '客户行业,关联行业表主键',
  `CREATE_TIME` datetime DEFAULT NULL COMMENT '创建时间',
  `UPDATE_TIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '设置当前时间，并且自动更更新时间',
  `IS_DELETE` int(11) DEFAULT '1' COMMENT '是否删除 0:删除 1:未删除',
  PRIMARY KEY (`CUSTOMER_ID`),
  KEY `LEVEL_ID` (`LEVEL_ID`),
  KEY `SOURCE_ID` (`SOURCE_ID`),
  KEY `INDUSTRY_ID` (`INDUSTRY_ID`),
  CONSTRAINT `customer_ibfk_1` FOREIGN KEY (`LEVEL_ID`) REFERENCES `level` (`LEVEL_ID`),
  CONSTRAINT `customer_ibfk_2` FOREIGN KEY (`SOURCE_ID`) REFERENCES `source` (`SOURCE_ID`),
  CONSTRAINT `customer_ibfk_3` FOREIGN KEY (`INDUSTRY_ID`) REFERENCES `industry` (`INDUSTRY_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='客户表';

-- ----------------------------
-- Records of customer
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for department
-- ----------------------------
DROP TABLE IF EXISTS `department`;
CREATE TABLE `department` (
  `DEPT_ID` int(11) NOT NULL AUTO_INCREMENT COMMENT '部门ID',
  `DEPT_NAME` varchar(100) DEFAULT NULL COMMENT '部门名称',
  `LEVEL` int(11) DEFAULT '1' COMMENT '层级',
  `PARENT_ID` int(11) DEFAULT '0' COMMENT '父ID,自关联DEPT_ID',
  `CREATE_TIME` datetime DEFAULT NULL COMMENT '创建时间',
  `UPDATE_TIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '设置当前时间，并且自动更更新时间',
  `IS_DELETE` int(11) DEFAULT '1' COMMENT '是否删除 0:删除 1:未删除',
  PRIMARY KEY (`DEPT_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=33 DEFAULT CHARSET=utf8 COMMENT='部门表';

-- ----------------------------
-- Records of department
-- ----------------------------
BEGIN;
INSERT INTO `department` VALUES (1, '大萝卜股份有限公司', 1, 0, '2022-09-17 22:50:34', '2022-09-17 22:50:34', 1);
INSERT INTO `department` VALUES (2, '小萝卜股份有限公司', 1, 0, '2022-09-17 22:50:58', '2022-09-17 22:50:58', 1);
INSERT INTO `department` VALUES (3, '大萝卜子公司1', 2, 1, '2022-09-17 22:51:31', '2022-09-17 22:51:31', 1);
INSERT INTO `department` VALUES (4, '大萝卜子公司2', 2, 1, '2022-09-17 22:51:31', '2022-09-17 22:51:31', 1);
INSERT INTO `department` VALUES (5, '大萝卜子公司3', 2, 1, '2022-09-17 22:51:31', '2022-09-17 22:51:31', 1);
INSERT INTO `department` VALUES (6, '大萝卜子公司4', 2, 1, '2022-09-17 22:51:31', '2022-09-17 22:51:31', 1);
INSERT INTO `department` VALUES (7, '大萝卜子公司5', 2, 1, '2022-09-17 22:51:31', '2022-09-17 22:51:31', 1);
INSERT INTO `department` VALUES (8, '小萝卜子公司1', 2, 2, '2022-09-17 22:52:05', '2022-09-17 22:52:05', 1);
INSERT INTO `department` VALUES (9, '小萝卜子公司2', 2, 2, '2022-09-17 22:52:05', '2022-09-17 22:52:05', 1);
INSERT INTO `department` VALUES (10, '小萝卜子公司3', 2, 2, '2022-09-17 22:52:05', '2022-09-17 22:52:05', 1);
INSERT INTO `department` VALUES (11, '小萝卜子公司4', 2, 2, '2022-09-17 22:52:05', '2022-09-17 22:52:05', 1);
INSERT INTO `department` VALUES (12, '小萝卜子公司5', 2, 2, '2022-09-17 22:52:05', '2022-09-17 22:52:05', 1);
INSERT INTO `department` VALUES (13, '部门1', 3, 3, '2022-09-17 22:53:47', '2022-09-17 22:53:47', 1);
INSERT INTO `department` VALUES (14, '部门2', 3, 3, '2022-09-17 22:53:47', '2022-09-17 22:53:47', 1);
INSERT INTO `department` VALUES (15, '部门1', 3, 4, '2022-09-17 22:53:47', '2022-09-17 22:53:47', 1);
INSERT INTO `department` VALUES (16, '部门2', 3, 4, '2022-09-17 22:53:47', '2022-09-17 22:53:47', 1);
INSERT INTO `department` VALUES (17, '部门1', 3, 5, '2022-09-17 22:53:47', '2022-09-17 22:53:47', 1);
INSERT INTO `department` VALUES (18, '部门2', 3, 5, '2022-09-17 22:53:47', '2022-09-17 22:53:47', 1);
INSERT INTO `department` VALUES (19, '部门1', 3, 6, '2022-09-17 22:53:47', '2022-09-17 22:53:47', 1);
INSERT INTO `department` VALUES (20, '部门2', 3, 6, '2022-09-17 22:53:47', '2022-09-17 22:53:47', 1);
INSERT INTO `department` VALUES (21, '部门1', 3, 7, '2022-09-17 22:53:47', '2022-09-17 22:53:47', 1);
INSERT INTO `department` VALUES (22, '部门2', 3, 7, '2022-09-17 22:53:47', '2022-09-17 22:53:47', 1);
INSERT INTO `department` VALUES (23, '部门1', 3, 8, '2022-09-17 22:53:47', '2022-09-17 22:53:47', 1);
INSERT INTO `department` VALUES (24, '部门2', 3, 8, '2022-09-17 22:53:47', '2022-09-17 22:53:47', 1);
INSERT INTO `department` VALUES (25, '部门1', 3, 9, '2022-09-17 22:53:47', '2022-09-17 22:53:47', 1);
INSERT INTO `department` VALUES (26, '部门2', 3, 9, '2022-09-17 22:53:47', '2022-09-17 22:53:47', 1);
INSERT INTO `department` VALUES (27, '部门1', 3, 10, '2022-09-17 22:53:47', '2022-09-17 22:53:47', 1);
INSERT INTO `department` VALUES (28, '部门2', 3, 10, '2022-09-17 22:53:47', '2022-09-17 22:53:47', 1);
INSERT INTO `department` VALUES (29, '部门1', 3, 11, '2022-09-17 22:53:47', '2022-09-17 22:53:47', 1);
INSERT INTO `department` VALUES (30, '部门2', 3, 11, '2022-09-17 22:53:47', '2022-09-17 22:53:47', 1);
INSERT INTO `department` VALUES (31, '部门1', 3, 12, '2022-09-17 22:53:47', '2022-09-17 22:53:47', 1);
INSERT INTO `department` VALUES (32, '部门2', 3, 12, '2022-09-17 22:53:47', '2022-09-17 22:53:47', 1);
COMMIT;

-- ----------------------------
-- Table structure for industry
-- ----------------------------
DROP TABLE IF EXISTS `industry`;
CREATE TABLE `industry` (
  `INDUSTRY_ID` int(11) NOT NULL AUTO_INCREMENT COMMENT '行业ID,主键自增',
  `INDUSTRY_NAME` varchar(100) NOT NULL COMMENT '行业名称',
  `CREATE_TIME` datetime DEFAULT NULL COMMENT '创建时间',
  `UPDATE_TIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '设置当前时间，并且自动更更新时间',
  `IS_DELETE` int(11) DEFAULT '1' COMMENT '是否删除 0:删除 1:未删除',
  PRIMARY KEY (`INDUSTRY_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='客户行业表';

-- ----------------------------
-- Records of industry
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for level
-- ----------------------------
DROP TABLE IF EXISTS `level`;
CREATE TABLE `level` (
  `LEVEL_ID` int(11) NOT NULL AUTO_INCREMENT COMMENT '客户级别ID,主键自增',
  `LEVEL_NAME` varchar(100) NOT NULL COMMENT '客户级别名称',
  `CREATE_TIME` datetime DEFAULT NULL COMMENT '创建时间',
  `UPDATE_TIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '设置当前时间，并且自动更更新时间',
  `IS_DELETE` int(11) DEFAULT '1' COMMENT '是否删除 0:删除 1:未删除',
  PRIMARY KEY (`LEVEL_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='客户级别表';

-- ----------------------------
-- Records of level
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for menus
-- ----------------------------
DROP TABLE IF EXISTS `menus`;
CREATE TABLE `menus` (
  `MENU_ID` int(11) NOT NULL AUTO_INCREMENT COMMENT '菜单ID,主键自增',
  `MENU_NAME` varchar(100) NOT NULL COMMENT '菜单名称',
  `MENU_URL` varchar(255) DEFAULT NULL COMMENT '菜单地址',
  `LEVEL` int(11) DEFAULT '1' COMMENT '层级',
  `PARENT_ID` int(11) DEFAULT NULL COMMENT '父ID,关联menus表主键,默认值为0,表示菜单第一级',
  `CREATE_TIME` datetime DEFAULT NULL COMMENT '创建时间',
  `UPDATE_TIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '设置当前时间，并且自动更更新时间',
  `IS_DELETE` int(11) DEFAULT '1' COMMENT '菜单状态 0:删除 1:未删除',
  PRIMARY KEY (`MENU_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8 COMMENT='菜单表';

-- ----------------------------
-- Records of menus
-- ----------------------------
BEGIN;
INSERT INTO `menus` VALUES (1, '顶级菜单标题1', NULL, 1, 0, '2022-09-17 22:55:38', '2022-09-17 22:55:38', 1);
INSERT INTO `menus` VALUES (2, '顶级菜单标题2', NULL, 1, 0, '2022-09-17 22:55:38', '2022-09-17 22:55:38', 1);
INSERT INTO `menus` VALUES (3, '顶级菜单标题3', NULL, 1, 0, '2022-09-17 22:55:38', '2022-09-17 22:55:38', 1);
INSERT INTO `menus` VALUES (4, '顶级菜单标题4', NULL, 1, 0, '2022-09-17 22:55:38', '2022-09-17 22:55:38', 1);
INSERT INTO `menus` VALUES (5, '顶级菜单标题5', NULL, 1, 0, '2022-09-17 22:55:38', '2022-09-17 22:55:38', 1);
INSERT INTO `menus` VALUES (6, '子集菜单标题1', NULL, 2, 1, '2022-09-17 22:56:49', '2022-09-17 22:56:49', 1);
INSERT INTO `menus` VALUES (7, '子集菜单标题2', NULL, 2, 1, '2022-09-17 22:56:49', '2022-09-17 22:56:49', 1);
INSERT INTO `menus` VALUES (8, '子集菜单标题1', NULL, 2, 2, '2022-09-17 22:56:49', '2022-09-17 22:56:49', 1);
INSERT INTO `menus` VALUES (9, '子集菜单标题2', NULL, 2, 2, '2022-09-17 22:56:49', '2022-09-17 22:56:49', 1);
INSERT INTO `menus` VALUES (10, '子集菜单标题1', NULL, 2, 3, '2022-09-17 22:56:49', '2022-09-17 22:56:49', 1);
INSERT INTO `menus` VALUES (11, '子集菜单标题2', NULL, 2, 3, '2022-09-17 22:56:49', '2022-09-17 22:56:49', 1);
INSERT INTO `menus` VALUES (12, '子集菜单标题1', NULL, 2, 4, '2022-09-17 22:56:49', '2022-09-17 22:56:49', 1);
INSERT INTO `menus` VALUES (13, '子集菜单标题2', NULL, 2, 4, '2022-09-17 22:56:49', '2022-09-17 22:56:49', 1);
INSERT INTO `menus` VALUES (14, '子集菜单标题1', NULL, 2, 5, '2022-09-17 22:56:49', '2022-09-17 22:56:49', 1);
INSERT INTO `menus` VALUES (15, '子集菜单标题2', NULL, 2, 5, '2022-09-17 22:56:49', '2022-09-17 22:56:49', 1);
COMMIT;

-- ----------------------------
-- Table structure for product
-- ----------------------------
DROP TABLE IF EXISTS `product`;
CREATE TABLE `product` (
  `PRODUCT_ID` int(11) NOT NULL AUTO_INCREMENT COMMENT '产品ID,主键自增',
  `PRODUCT_NAME` varchar(100) NOT NULL COMMENT '产品名称',
  `CATEGORY_ID` int(11) NOT NULL COMMENT '产品类目ID,关联类目表主键',
  `PRODUCT_SIZE` varchar(100) DEFAULT NULL COMMENT '产品尺寸(长乘宽),单位 毫米(mm)',
  `PRODUCT_PRICE` double(16,3) DEFAULT NULL COMMENT '产品价格',
  `CREATE_TIME` datetime DEFAULT NULL COMMENT '创建时间',
  `UPDATE_TIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '设置当前时间，并且自动更更新时间',
  `IS_DELETE` int(11) DEFAULT '1' COMMENT '是否删除 0:删除 1:未删除',
  PRIMARY KEY (`PRODUCT_ID`),
  KEY `CATEGORY_ID` (`CATEGORY_ID`),
  CONSTRAINT `product_ibfk_1` FOREIGN KEY (`CATEGORY_ID`) REFERENCES `category` (`CATEGORY_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='产品信息表';

-- ----------------------------
-- Records of product
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for record_in
-- ----------------------------
DROP TABLE IF EXISTS `record_in`;
CREATE TABLE `record_in` (
  `RECORD_IN_ID` int(11) NOT NULL AUTO_INCREMENT COMMENT '入库ID,主键自增',
  `SUPPLIER_ID` int(11) NOT NULL COMMENT '供应商ID,关联供应商表主键',
  `PRODUCT_ID` int(11) NOT NULL COMMENT '产品ID,关联产品表主键',
  `RECORD_IN_NUMBER` int(11) DEFAULT '0' COMMENT '入库数量',
  `RECORD_IN_TIME` datetime DEFAULT NULL COMMENT '入库时间',
  `USER_ID` int(11) NOT NULL COMMENT '入库负责人ID,关联用户表主键',
  `REPO_ID` int(11) NOT NULL COMMENT '仓库ID,关联仓库表主键',
  `REMARKS` varchar(255) DEFAULT NULL COMMENT '备注',
  `CREATE_TIME` datetime DEFAULT NULL COMMENT '创建时间',
  `UPDATE_TIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '设置当前时间，并且自动更更新时间',
  `IS_DELETE` int(11) DEFAULT '1' COMMENT '是否删除 0:删除 1:未删除',
  PRIMARY KEY (`RECORD_IN_ID`),
  KEY `SUPPLIER_ID` (`SUPPLIER_ID`),
  KEY `PRODUCT_ID` (`PRODUCT_ID`),
  KEY `USER_ID` (`USER_ID`),
  CONSTRAINT `record_in_ibfk_1` FOREIGN KEY (`SUPPLIER_ID`) REFERENCES `supplier` (`SUPPLIER_ID`),
  CONSTRAINT `record_in_ibfk_2` FOREIGN KEY (`PRODUCT_ID`) REFERENCES `product` (`PRODUCT_ID`),
  CONSTRAINT `record_in_ibfk_3` FOREIGN KEY (`USER_ID`) REFERENCES `user` (`USER_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='入库记录表';

-- ----------------------------
-- Records of record_in
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for record_out
-- ----------------------------
DROP TABLE IF EXISTS `record_out`;
CREATE TABLE `record_out` (
  `RECORD_OUT_ID` int(11) NOT NULL AUTO_INCREMENT COMMENT '出库ID,主键自增',
  `CUSTOMER_ID` int(11) NOT NULL COMMENT '客户ID,关联客户表主键',
  `PRODUCT_ID` int(11) NOT NULL COMMENT '产品ID,关联产品表主键',
  `RECORD_OUT_NUMBER` int(11) DEFAULT '0' COMMENT '出库数量',
  `RECORD_OUT_TIME` datetime DEFAULT NULL COMMENT '出库时间',
  `USER_ID` int(11) NOT NULL COMMENT '出库负责人ID,关联用户表主键',
  `REPO_ID` int(11) NOT NULL COMMENT '仓库ID,关联仓库表主键',
  `REMARKS` varchar(255) DEFAULT NULL COMMENT '备注',
  `CREATE_TIME` datetime DEFAULT NULL COMMENT '创建时间',
  `UPDATE_TIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '设置当前时间，并且自动更更新时间',
  `IS_DELETE` int(11) DEFAULT '1' COMMENT '是否删除 0:删除 1:未删除',
  PRIMARY KEY (`RECORD_OUT_ID`),
  KEY `CUSTOMER_ID` (`CUSTOMER_ID`),
  KEY `PRODUCT_ID` (`PRODUCT_ID`),
  KEY `USER_ID` (`USER_ID`),
  CONSTRAINT `record_out_ibfk_1` FOREIGN KEY (`CUSTOMER_ID`) REFERENCES `customer` (`CUSTOMER_ID`),
  CONSTRAINT `record_out_ibfk_2` FOREIGN KEY (`PRODUCT_ID`) REFERENCES `product` (`PRODUCT_ID`),
  CONSTRAINT `record_out_ibfk_3` FOREIGN KEY (`USER_ID`) REFERENCES `user` (`USER_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='出库记录表';

-- ----------------------------
-- Records of record_out
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for record_stock
-- ----------------------------
DROP TABLE IF EXISTS `record_stock`;
CREATE TABLE `record_stock` (
  `PRODUCT_ID` int(11) NOT NULL COMMENT '产品ID,关联产品表主键',
  `REPO_ID` int(11) NOT NULL COMMENT '仓库ID,关联仓库表主键',
  `PRODUCT_STOCK` int(11) DEFAULT '0' COMMENT '库存数量',
  `CREATE_TIME` datetime DEFAULT NULL COMMENT '创建时间',
  `UPDATE_TIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '设置当前时间，并且自动更更新时间',
  `IS_DELETE` int(11) DEFAULT '1' COMMENT '是否删除 0:删除 1:未删除',
  PRIMARY KEY (`PRODUCT_ID`,`REPO_ID`),
  KEY `REPO_ID` (`REPO_ID`),
  CONSTRAINT `record_stock_ibfk_1` FOREIGN KEY (`PRODUCT_ID`) REFERENCES `product` (`PRODUCT_ID`),
  CONSTRAINT `record_stock_ibfk_2` FOREIGN KEY (`REPO_ID`) REFERENCES `repository` (`REPO_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='库存记录表';

-- ----------------------------
-- Records of record_stock
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for repository
-- ----------------------------
DROP TABLE IF EXISTS `repository`;
CREATE TABLE `repository` (
  `REPO_ID` int(11) NOT NULL AUTO_INCREMENT COMMENT '仓库ID,主键自增',
  `REPO_ADDRESS` varchar(100) NOT NULL COMMENT '仓库地址',
  `REPO_AREA` varchar(50) DEFAULT NULL COMMENT '仓库面积,单位:平方米',
  `REPO_DESC` varchar(255) DEFAULT NULL COMMENT '仓库描述(备注)',
  `REPO_STATUS` tinyint(4) DEFAULT '1' COMMENT '仓库状态 0:故障 1:正常 2:已满 3:废弃',
  `CREATE_TIME` datetime DEFAULT NULL COMMENT '创建时间',
  `UPDATE_TIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '设置当前时间，并且自动更更新时间',
  `IS_DELETE` int(11) DEFAULT '1' COMMENT '是否删除 0:删除 1:未删除',
  PRIMARY KEY (`REPO_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='仓库信息表';

-- ----------------------------
-- Records of repository
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `ROLE_ID` int(11) NOT NULL AUTO_INCREMENT COMMENT '角色ID,主键自增',
  `ROLE_NAME` varchar(100) DEFAULT NULL COMMENT '角色名称',
  `CREATE_TIME` datetime DEFAULT NULL COMMENT '创建时间',
  `UPDATE_TIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '设置当前时间，并且自动更更新时间',
  `IS_DELETE` int(11) DEFAULT '1' COMMENT '是否删除 0:删除 1:未删除',
  PRIMARY KEY (`ROLE_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=101 DEFAULT CHARSET=utf8 COMMENT='角色表';

-- ----------------------------
-- Records of role
-- ----------------------------
BEGIN;
INSERT INTO `role` VALUES (1, '测试角色名称0', '2022-09-17 22:48:18', '2022-09-17 22:48:18', 1);
INSERT INTO `role` VALUES (2, '测试角色名称1', '2022-09-17 22:48:19', '2022-09-17 22:48:18', 0);
INSERT INTO `role` VALUES (3, '测试角色名称2', '2022-09-17 22:48:19', '2022-09-17 22:48:18', 1);
INSERT INTO `role` VALUES (4, '测试角色名称3', '2022-09-17 22:48:19', '2022-09-17 22:48:18', 0);
INSERT INTO `role` VALUES (5, '测试角色名称4', '2022-09-17 22:48:19', '2022-09-17 22:48:18', 1);
INSERT INTO `role` VALUES (6, '测试角色名称5', '2022-09-17 22:48:19', '2022-09-17 22:48:18', 0);
INSERT INTO `role` VALUES (7, '测试角色名称6', '2022-09-17 22:48:19', '2022-09-17 22:48:18', 1);
INSERT INTO `role` VALUES (8, '测试角色名称7', '2022-09-17 22:48:19', '2022-09-17 22:48:18', 0);
INSERT INTO `role` VALUES (9, '测试角色名称8', '2022-09-17 22:48:19', '2022-09-17 22:48:18', 1);
INSERT INTO `role` VALUES (10, '测试角色名称9', '2022-09-17 22:48:19', '2022-09-17 22:48:18', 0);
INSERT INTO `role` VALUES (11, '测试角色名称10', '2022-09-17 22:48:19', '2022-09-17 22:48:18', 1);
INSERT INTO `role` VALUES (12, '测试角色名称11', '2022-09-17 22:48:19', '2022-09-17 22:48:18', 0);
INSERT INTO `role` VALUES (13, '测试角色名称12', '2022-09-17 22:48:19', '2022-09-17 22:48:18', 1);
INSERT INTO `role` VALUES (14, '测试角色名称13', '2022-09-17 22:48:19', '2022-09-17 22:48:18', 0);
INSERT INTO `role` VALUES (15, '测试角色名称14', '2022-09-17 22:48:19', '2022-09-17 22:48:18', 1);
INSERT INTO `role` VALUES (16, '测试角色名称15', '2022-09-17 22:48:19', '2022-09-17 22:48:18', 0);
INSERT INTO `role` VALUES (17, '测试角色名称16', '2022-09-17 22:48:19', '2022-09-17 22:48:18', 1);
INSERT INTO `role` VALUES (18, '测试角色名称17', '2022-09-17 22:48:19', '2022-09-17 22:48:18', 0);
INSERT INTO `role` VALUES (19, '测试角色名称18', '2022-09-17 22:48:19', '2022-09-17 22:48:19', 1);
INSERT INTO `role` VALUES (20, '测试角色名称19', '2022-09-17 22:48:19', '2022-09-17 22:48:19', 0);
INSERT INTO `role` VALUES (21, '测试角色名称20', '2022-09-17 22:48:19', '2022-09-17 22:48:19', 1);
INSERT INTO `role` VALUES (22, '测试角色名称21', '2022-09-17 22:48:19', '2022-09-17 22:48:19', 0);
INSERT INTO `role` VALUES (23, '测试角色名称22', '2022-09-17 22:48:19', '2022-09-17 22:48:19', 1);
INSERT INTO `role` VALUES (24, '测试角色名称23', '2022-09-17 22:48:19', '2022-09-17 22:48:19', 0);
INSERT INTO `role` VALUES (25, '测试角色名称24', '2022-09-17 22:48:19', '2022-09-17 22:48:19', 1);
INSERT INTO `role` VALUES (26, '测试角色名称25', '2022-09-17 22:48:19', '2022-09-17 22:48:19', 0);
INSERT INTO `role` VALUES (27, '测试角色名称26', '2022-09-17 22:48:19', '2022-09-17 22:48:19', 1);
INSERT INTO `role` VALUES (28, '测试角色名称27', '2022-09-17 22:48:19', '2022-09-17 22:48:19', 0);
INSERT INTO `role` VALUES (29, '测试角色名称28', '2022-09-17 22:48:19', '2022-09-17 22:48:19', 1);
INSERT INTO `role` VALUES (30, '测试角色名称29', '2022-09-17 22:48:19', '2022-09-17 22:48:19', 0);
INSERT INTO `role` VALUES (31, '测试角色名称30', '2022-09-17 22:48:19', '2022-09-17 22:48:19', 1);
INSERT INTO `role` VALUES (32, '测试角色名称31', '2022-09-17 22:48:19', '2022-09-17 22:48:19', 0);
INSERT INTO `role` VALUES (33, '测试角色名称32', '2022-09-17 22:48:19', '2022-09-17 22:48:19', 1);
INSERT INTO `role` VALUES (34, '测试角色名称33', '2022-09-17 22:48:19', '2022-09-17 22:48:19', 0);
INSERT INTO `role` VALUES (35, '测试角色名称34', '2022-09-17 22:48:19', '2022-09-17 22:48:19', 1);
INSERT INTO `role` VALUES (36, '测试角色名称35', '2022-09-17 22:48:19', '2022-09-17 22:48:19', 0);
INSERT INTO `role` VALUES (37, '测试角色名称36', '2022-09-17 22:48:19', '2022-09-17 22:48:19', 1);
INSERT INTO `role` VALUES (38, '测试角色名称37', '2022-09-17 22:48:19', '2022-09-17 22:48:19', 0);
INSERT INTO `role` VALUES (39, '测试角色名称38', '2022-09-17 22:48:19', '2022-09-17 22:48:19', 1);
INSERT INTO `role` VALUES (40, '测试角色名称39', '2022-09-17 22:48:19', '2022-09-17 22:48:19', 0);
INSERT INTO `role` VALUES (41, '测试角色名称40', '2022-09-17 22:48:19', '2022-09-17 22:48:19', 1);
INSERT INTO `role` VALUES (42, '测试角色名称41', '2022-09-17 22:48:19', '2022-09-17 22:48:19', 0);
INSERT INTO `role` VALUES (43, '测试角色名称42', '2022-09-17 22:48:19', '2022-09-17 22:48:19', 1);
INSERT INTO `role` VALUES (44, '测试角色名称43', '2022-09-17 22:48:19', '2022-09-17 22:48:19', 0);
INSERT INTO `role` VALUES (45, '测试角色名称44', '2022-09-17 22:48:19', '2022-09-17 22:48:19', 1);
INSERT INTO `role` VALUES (46, '测试角色名称45', '2022-09-17 22:48:19', '2022-09-17 22:48:19', 0);
INSERT INTO `role` VALUES (47, '测试角色名称46', '2022-09-17 22:48:19', '2022-09-17 22:48:19', 1);
INSERT INTO `role` VALUES (48, '测试角色名称47', '2022-09-17 22:48:19', '2022-09-17 22:48:19', 0);
INSERT INTO `role` VALUES (49, '测试角色名称48', '2022-09-17 22:48:19', '2022-09-17 22:48:19', 1);
INSERT INTO `role` VALUES (50, '测试角色名称49', '2022-09-17 22:48:19', '2022-09-17 22:48:19', 0);
INSERT INTO `role` VALUES (51, '测试角色名称50', '2022-09-17 22:48:19', '2022-09-17 22:48:19', 1);
INSERT INTO `role` VALUES (52, '测试角色名称51', '2022-09-17 22:48:19', '2022-09-17 22:48:19', 0);
INSERT INTO `role` VALUES (53, '测试角色名称52', '2022-09-17 22:48:19', '2022-09-17 22:48:19', 1);
INSERT INTO `role` VALUES (54, '测试角色名称53', '2022-09-17 22:48:19', '2022-09-17 22:48:19', 0);
INSERT INTO `role` VALUES (55, '测试角色名称54', '2022-09-17 22:48:19', '2022-09-17 22:48:19', 1);
INSERT INTO `role` VALUES (56, '测试角色名称55', '2022-09-17 22:48:19', '2022-09-17 22:48:19', 0);
INSERT INTO `role` VALUES (57, '测试角色名称56', '2022-09-17 22:48:19', '2022-09-17 22:48:19', 1);
INSERT INTO `role` VALUES (58, '测试角色名称57', '2022-09-17 22:48:20', '2022-09-17 22:48:19', 0);
INSERT INTO `role` VALUES (59, '测试角色名称58', '2022-09-17 22:48:20', '2022-09-17 22:48:19', 1);
INSERT INTO `role` VALUES (60, '测试角色名称59', '2022-09-17 22:48:20', '2022-09-17 22:48:19', 0);
INSERT INTO `role` VALUES (61, '测试角色名称60', '2022-09-17 22:48:20', '2022-09-17 22:48:19', 1);
INSERT INTO `role` VALUES (62, '测试角色名称61', '2022-09-17 22:48:20', '2022-09-17 22:48:19', 0);
INSERT INTO `role` VALUES (63, '测试角色名称62', '2022-09-17 22:48:20', '2022-09-17 22:48:19', 1);
INSERT INTO `role` VALUES (64, '测试角色名称63', '2022-09-17 22:48:20', '2022-09-17 22:48:19', 0);
INSERT INTO `role` VALUES (65, '测试角色名称64', '2022-09-17 22:48:20', '2022-09-17 22:48:19', 1);
INSERT INTO `role` VALUES (66, '测试角色名称65', '2022-09-17 22:48:20', '2022-09-17 22:48:19', 0);
INSERT INTO `role` VALUES (67, '测试角色名称66', '2022-09-17 22:48:20', '2022-09-17 22:48:19', 1);
INSERT INTO `role` VALUES (68, '测试角色名称67', '2022-09-17 22:48:20', '2022-09-17 22:48:19', 0);
INSERT INTO `role` VALUES (69, '测试角色名称68', '2022-09-17 22:48:20', '2022-09-17 22:48:19', 1);
INSERT INTO `role` VALUES (70, '测试角色名称69', '2022-09-17 22:48:20', '2022-09-17 22:48:19', 0);
INSERT INTO `role` VALUES (71, '测试角色名称70', '2022-09-17 22:48:20', '2022-09-17 22:48:19', 1);
INSERT INTO `role` VALUES (72, '测试角色名称71', '2022-09-17 22:48:20', '2022-09-17 22:48:19', 0);
INSERT INTO `role` VALUES (73, '测试角色名称72', '2022-09-17 22:48:20', '2022-09-17 22:48:19', 1);
INSERT INTO `role` VALUES (74, '测试角色名称73', '2022-09-17 22:48:20', '2022-09-17 22:48:19', 0);
INSERT INTO `role` VALUES (75, '测试角色名称74', '2022-09-17 22:48:20', '2022-09-17 22:48:19', 1);
INSERT INTO `role` VALUES (76, '测试角色名称75', '2022-09-17 22:48:20', '2022-09-17 22:48:19', 0);
INSERT INTO `role` VALUES (77, '测试角色名称76', '2022-09-17 22:48:20', '2022-09-17 22:48:19', 1);
INSERT INTO `role` VALUES (78, '测试角色名称77', '2022-09-17 22:48:20', '2022-09-17 22:48:19', 0);
INSERT INTO `role` VALUES (79, '测试角色名称78', '2022-09-17 22:48:20', '2022-09-17 22:48:19', 1);
INSERT INTO `role` VALUES (80, '测试角色名称79', '2022-09-17 22:48:20', '2022-09-17 22:48:19', 0);
INSERT INTO `role` VALUES (81, '测试角色名称80', '2022-09-17 22:48:20', '2022-09-17 22:48:19', 1);
INSERT INTO `role` VALUES (82, '测试角色名称81', '2022-09-17 22:48:20', '2022-09-17 22:48:19', 0);
INSERT INTO `role` VALUES (83, '测试角色名称82', '2022-09-17 22:48:20', '2022-09-17 22:48:19', 1);
INSERT INTO `role` VALUES (84, '测试角色名称83', '2022-09-17 22:48:20', '2022-09-17 22:48:19', 0);
INSERT INTO `role` VALUES (85, '测试角色名称84', '2022-09-17 22:48:20', '2022-09-17 22:48:19', 1);
INSERT INTO `role` VALUES (86, '测试角色名称85', '2022-09-17 22:48:20', '2022-09-17 22:48:19', 0);
INSERT INTO `role` VALUES (87, '测试角色名称86', '2022-09-17 22:48:20', '2022-09-17 22:48:19', 1);
INSERT INTO `role` VALUES (88, '测试角色名称87', '2022-09-17 22:48:20', '2022-09-17 22:48:19', 0);
INSERT INTO `role` VALUES (89, '测试角色名称88', '2022-09-17 22:48:20', '2022-09-17 22:48:19', 1);
INSERT INTO `role` VALUES (90, '测试角色名称89', '2022-09-17 22:48:20', '2022-09-17 22:48:19', 0);
INSERT INTO `role` VALUES (91, '测试角色名称90', '2022-09-17 22:48:20', '2022-09-17 22:48:19', 1);
INSERT INTO `role` VALUES (92, '测试角色名称91', '2022-09-17 22:48:20', '2022-09-17 22:48:19', 0);
INSERT INTO `role` VALUES (93, '测试角色名称92', '2022-09-17 22:48:20', '2022-09-17 22:48:19', 1);
INSERT INTO `role` VALUES (94, '测试角色名称93', '2022-09-17 22:48:20', '2022-09-17 22:48:19', 0);
INSERT INTO `role` VALUES (95, '测试角色名称94', '2022-09-17 22:48:20', '2022-09-17 22:48:19', 1);
INSERT INTO `role` VALUES (96, '测试角色名称95', '2022-09-17 22:48:20', '2022-09-17 22:48:19', 0);
INSERT INTO `role` VALUES (97, '测试角色名称96', '2022-09-17 22:48:20', '2022-09-17 22:48:20', 1);
INSERT INTO `role` VALUES (98, '测试角色名称97', '2022-09-17 22:48:20', '2022-09-17 22:48:20', 0);
INSERT INTO `role` VALUES (99, '测试角色名称98', '2022-09-17 22:48:20', '2022-09-17 22:48:20', 1);
INSERT INTO `role` VALUES (100, '测试角色名称99', '2022-09-17 22:48:20', '2022-09-17 22:48:20', 0);
COMMIT;

-- ----------------------------
-- Table structure for role_menus
-- ----------------------------
DROP TABLE IF EXISTS `role_menus`;
CREATE TABLE `role_menus` (
  `ROLE_ID` int(11) NOT NULL COMMENT '角色ID,关联角色表主键',
  `MENU_ID` int(11) NOT NULL COMMENT '菜单ID,关联菜单表主键',
  `CREATE_TIME` datetime DEFAULT NULL COMMENT '创建时间',
  `UPDATE_TIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '设置当前时间，并且自动更更新时间',
  `IS_DELETE` int(11) DEFAULT '1' COMMENT '是否删除 0:删除 1:未删除',
  PRIMARY KEY (`ROLE_ID`,`MENU_ID`),
  KEY `MENU_ID` (`MENU_ID`),
  CONSTRAINT `role_menus_ibfk_1` FOREIGN KEY (`ROLE_ID`) REFERENCES `role` (`ROLE_ID`),
  CONSTRAINT `role_menus_ibfk_2` FOREIGN KEY (`MENU_ID`) REFERENCES `menus` (`MENU_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色菜单关联表';

-- ----------------------------
-- Records of role_menus
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for source
-- ----------------------------
DROP TABLE IF EXISTS `source`;
CREATE TABLE `source` (
  `SOURCE_ID` int(11) NOT NULL AUTO_INCREMENT COMMENT '客户来源ID,主键自增',
  `SOURCE_NAME` varchar(100) NOT NULL COMMENT '客户来源名称',
  `CREATE_TIME` datetime DEFAULT NULL COMMENT '创建时间',
  `UPDATE_TIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '设置当前时间，并且自动更更新时间',
  `IS_DELETE` int(11) DEFAULT '1' COMMENT '是否删除 0:删除 1:未删除',
  PRIMARY KEY (`SOURCE_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='客户来源表';

-- ----------------------------
-- Records of source
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for supplier
-- ----------------------------
DROP TABLE IF EXISTS `supplier`;
CREATE TABLE `supplier` (
  `SUPPLIER_ID` int(11) NOT NULL AUTO_INCREMENT COMMENT '供应商ID,主键自增',
  `SUPPLIER_NAME` varchar(100) NOT NULL COMMENT '供应商信息,如果为个人(非公司),那么当前字段和SUPPLIER_LEADER信息相同,如果为公司,那么是公司名称',
  `SUPPLIER_LEADER` varchar(100) NOT NULL COMMENT '负责人,如果为个人(非公司),那么当前字段和SUPPLIER_NAME信息相同',
  `SUPPLIER_TEL` varchar(100) NOT NULL COMMENT '联系电话',
  `SUPPLIER_EMAIL` varchar(100) NOT NULL COMMENT '邮箱',
  `SUPPLIER_ADDRESS` varchar(100) NOT NULL COMMENT '地址',
  `CREATE_TIME` datetime DEFAULT NULL COMMENT '创建时间',
  `UPDATE_TIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '设置当前时间，并且自动更更新时间',
  `IS_DELETE` int(11) DEFAULT '1' COMMENT '是否删除 0:删除 1:未删除',
  PRIMARY KEY (`SUPPLIER_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='供应商信息表';

-- ----------------------------
-- Records of supplier
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `USER_ID` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户ID,主键自增',
  `USER_NAME` varchar(20) NOT NULL COMMENT '用户名',
  `USER_TEL` varchar(20) NOT NULL COMMENT '联系电话',
  `USER_EMAIL` varchar(100) NOT NULL COMMENT '邮箱',
  `USER_NICK` varchar(10) DEFAULT 'WMS' COMMENT '用户昵称',
  `PASSWORD` varchar(255) NOT NULL COMMENT '密码',
  `SALT` varchar(100) DEFAULT NULL COMMENT '盐值',
  `CREATE_TIME` datetime DEFAULT NULL COMMENT '创建时间',
  `UPDATE_TIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '设置当前时间，并且自动更更新时间',
  `IS_DELETE` int(11) DEFAULT '1' COMMENT '是否删除 0:删除 1:未删除',
  PRIMARY KEY (`USER_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=101 DEFAULT CHARSET=utf8 COMMENT='用户表';

-- ----------------------------
-- Records of user
-- ----------------------------
BEGIN;
INSERT INTO `user` VALUES (1, '测试名称0', '1888888880', '1@10.com', '测试昵称0', '0测试密码0', '测试盐0', '2022-09-17 22:48:42', '2022-09-17 22:48:42', 0);
INSERT INTO `user` VALUES (2, '测试名称1', '1888888881', '1@11.com', '测试昵称1', '1测试密码1', '测试盐1', '2022-09-17 22:48:43', '2022-09-17 22:48:42', 1);
INSERT INTO `user` VALUES (3, '测试名称2', '1888888882', '1@12.com', '测试昵称2', '2测试密码2', '测试盐2', '2022-09-17 22:48:43', '2022-09-17 22:48:42', 0);
INSERT INTO `user` VALUES (4, '测试名称3', '1888888883', '1@13.com', '测试昵称3', '3测试密码3', '测试盐3', '2022-09-17 22:48:43', '2022-09-17 22:48:42', 1);
INSERT INTO `user` VALUES (5, '测试名称4', '1888888884', '1@14.com', '测试昵称4', '4测试密码4', '测试盐4', '2022-09-17 22:48:43', '2022-09-17 22:48:42', 0);
INSERT INTO `user` VALUES (6, '测试名称5', '1888888885', '1@15.com', '测试昵称5', '5测试密码5', '测试盐5', '2022-09-17 22:48:43', '2022-09-17 22:48:42', 1);
INSERT INTO `user` VALUES (7, '测试名称6', '1888888886', '1@16.com', '测试昵称6', '6测试密码6', '测试盐6', '2022-09-17 22:48:43', '2022-09-17 22:48:42', 0);
INSERT INTO `user` VALUES (8, '测试名称7', '1888888887', '1@17.com', '测试昵称7', '7测试密码7', '测试盐7', '2022-09-17 22:48:43', '2022-09-17 22:48:42', 1);
INSERT INTO `user` VALUES (9, '测试名称8', '1888888888', '1@18.com', '测试昵称8', '8测试密码8', '测试盐8', '2022-09-17 22:48:43', '2022-09-17 22:48:42', 0);
INSERT INTO `user` VALUES (10, '测试名称9', '1888888889', '1@19.com', '测试昵称9', '9测试密码9', '测试盐9', '2022-09-17 22:48:43', '2022-09-17 22:48:42', 1);
INSERT INTO `user` VALUES (11, '测试名称10', '18888888810', '1@110.com', '测试昵称10', '10测试密码10', '测试盐10', '2022-09-17 22:48:43', '2022-09-17 22:48:42', 0);
INSERT INTO `user` VALUES (12, '测试名称11', '18888888811', '1@111.com', '测试昵称11', '11测试密码11', '测试盐11', '2022-09-17 22:48:43', '2022-09-17 22:48:42', 1);
INSERT INTO `user` VALUES (13, '测试名称12', '18888888812', '1@112.com', '测试昵称12', '12测试密码12', '测试盐12', '2022-09-17 22:48:43', '2022-09-17 22:48:42', 0);
INSERT INTO `user` VALUES (14, '测试名称13', '18888888813', '1@113.com', '测试昵称13', '13测试密码13', '测试盐13', '2022-09-17 22:48:43', '2022-09-17 22:48:42', 1);
INSERT INTO `user` VALUES (15, '测试名称14', '18888888814', '1@114.com', '测试昵称14', '14测试密码14', '测试盐14', '2022-09-17 22:48:43', '2022-09-17 22:48:42', 0);
INSERT INTO `user` VALUES (16, '测试名称15', '18888888815', '1@115.com', '测试昵称15', '15测试密码15', '测试盐15', '2022-09-17 22:48:43', '2022-09-17 22:48:42', 1);
INSERT INTO `user` VALUES (17, '测试名称16', '18888888816', '1@116.com', '测试昵称16', '16测试密码16', '测试盐16', '2022-09-17 22:48:43', '2022-09-17 22:48:42', 0);
INSERT INTO `user` VALUES (18, '测试名称17', '18888888817', '1@117.com', '测试昵称17', '17测试密码17', '测试盐17', '2022-09-17 22:48:43', '2022-09-17 22:48:43', 1);
INSERT INTO `user` VALUES (19, '测试名称18', '18888888818', '1@118.com', '测试昵称18', '18测试密码18', '测试盐18', '2022-09-17 22:48:43', '2022-09-17 22:48:43', 0);
INSERT INTO `user` VALUES (20, '测试名称19', '18888888819', '1@119.com', '测试昵称19', '19测试密码19', '测试盐19', '2022-09-17 22:48:43', '2022-09-17 22:48:43', 1);
INSERT INTO `user` VALUES (21, '测试名称20', '18888888820', '1@120.com', '测试昵称20', '20测试密码20', '测试盐20', '2022-09-17 22:48:43', '2022-09-17 22:48:43', 0);
INSERT INTO `user` VALUES (22, '测试名称21', '18888888821', '1@121.com', '测试昵称21', '21测试密码21', '测试盐21', '2022-09-17 22:48:43', '2022-09-17 22:48:43', 1);
INSERT INTO `user` VALUES (23, '测试名称22', '18888888822', '1@122.com', '测试昵称22', '22测试密码22', '测试盐22', '2022-09-17 22:48:43', '2022-09-17 22:48:43', 0);
INSERT INTO `user` VALUES (24, '测试名称23', '18888888823', '1@123.com', '测试昵称23', '23测试密码23', '测试盐23', '2022-09-17 22:48:43', '2022-09-17 22:48:43', 1);
INSERT INTO `user` VALUES (25, '测试名称24', '18888888824', '1@124.com', '测试昵称24', '24测试密码24', '测试盐24', '2022-09-17 22:48:43', '2022-09-17 22:48:43', 0);
INSERT INTO `user` VALUES (26, '测试名称25', '18888888825', '1@125.com', '测试昵称25', '25测试密码25', '测试盐25', '2022-09-17 22:48:43', '2022-09-17 22:48:43', 1);
INSERT INTO `user` VALUES (27, '测试名称26', '18888888826', '1@126.com', '测试昵称26', '26测试密码26', '测试盐26', '2022-09-17 22:48:43', '2022-09-17 22:48:43', 0);
INSERT INTO `user` VALUES (28, '测试名称27', '18888888827', '1@127.com', '测试昵称27', '27测试密码27', '测试盐27', '2022-09-17 22:48:43', '2022-09-17 22:48:43', 1);
INSERT INTO `user` VALUES (29, '测试名称28', '18888888828', '1@128.com', '测试昵称28', '28测试密码28', '测试盐28', '2022-09-17 22:48:43', '2022-09-17 22:48:43', 0);
INSERT INTO `user` VALUES (30, '测试名称29', '18888888829', '1@129.com', '测试昵称29', '29测试密码29', '测试盐29', '2022-09-17 22:48:43', '2022-09-17 22:48:43', 1);
INSERT INTO `user` VALUES (31, '测试名称30', '18888888830', '1@130.com', '测试昵称30', '30测试密码30', '测试盐30', '2022-09-17 22:48:43', '2022-09-17 22:48:43', 0);
INSERT INTO `user` VALUES (32, '测试名称31', '18888888831', '1@131.com', '测试昵称31', '31测试密码31', '测试盐31', '2022-09-17 22:48:43', '2022-09-17 22:48:43', 1);
INSERT INTO `user` VALUES (33, '测试名称32', '18888888832', '1@132.com', '测试昵称32', '32测试密码32', '测试盐32', '2022-09-17 22:48:43', '2022-09-17 22:48:43', 0);
INSERT INTO `user` VALUES (34, '测试名称33', '18888888833', '1@133.com', '测试昵称33', '33测试密码33', '测试盐33', '2022-09-17 22:48:43', '2022-09-17 22:48:43', 1);
INSERT INTO `user` VALUES (35, '测试名称34', '18888888834', '1@134.com', '测试昵称34', '34测试密码34', '测试盐34', '2022-09-17 22:48:43', '2022-09-17 22:48:43', 0);
INSERT INTO `user` VALUES (36, '测试名称35', '18888888835', '1@135.com', '测试昵称35', '35测试密码35', '测试盐35', '2022-09-17 22:48:43', '2022-09-17 22:48:43', 1);
INSERT INTO `user` VALUES (37, '测试名称36', '18888888836', '1@136.com', '测试昵称36', '36测试密码36', '测试盐36', '2022-09-17 22:48:43', '2022-09-17 22:48:43', 0);
INSERT INTO `user` VALUES (38, '测试名称37', '18888888837', '1@137.com', '测试昵称37', '37测试密码37', '测试盐37', '2022-09-17 22:48:43', '2022-09-17 22:48:43', 1);
INSERT INTO `user` VALUES (39, '测试名称38', '18888888838', '1@138.com', '测试昵称38', '38测试密码38', '测试盐38', '2022-09-17 22:48:43', '2022-09-17 22:48:43', 0);
INSERT INTO `user` VALUES (40, '测试名称39', '18888888839', '1@139.com', '测试昵称39', '39测试密码39', '测试盐39', '2022-09-17 22:48:43', '2022-09-17 22:48:43', 1);
INSERT INTO `user` VALUES (41, '测试名称40', '18888888840', '1@140.com', '测试昵称40', '40测试密码40', '测试盐40', '2022-09-17 22:48:43', '2022-09-17 22:48:43', 0);
INSERT INTO `user` VALUES (42, '测试名称41', '18888888841', '1@141.com', '测试昵称41', '41测试密码41', '测试盐41', '2022-09-17 22:48:43', '2022-09-17 22:48:43', 1);
INSERT INTO `user` VALUES (43, '测试名称42', '18888888842', '1@142.com', '测试昵称42', '42测试密码42', '测试盐42', '2022-09-17 22:48:43', '2022-09-17 22:48:43', 0);
INSERT INTO `user` VALUES (44, '测试名称43', '18888888843', '1@143.com', '测试昵称43', '43测试密码43', '测试盐43', '2022-09-17 22:48:43', '2022-09-17 22:48:43', 1);
INSERT INTO `user` VALUES (45, '测试名称44', '18888888844', '1@144.com', '测试昵称44', '44测试密码44', '测试盐44', '2022-09-17 22:48:43', '2022-09-17 22:48:43', 0);
INSERT INTO `user` VALUES (46, '测试名称45', '18888888845', '1@145.com', '测试昵称45', '45测试密码45', '测试盐45', '2022-09-17 22:48:43', '2022-09-17 22:48:43', 1);
INSERT INTO `user` VALUES (47, '测试名称46', '18888888846', '1@146.com', '测试昵称46', '46测试密码46', '测试盐46', '2022-09-17 22:48:43', '2022-09-17 22:48:43', 0);
INSERT INTO `user` VALUES (48, '测试名称47', '18888888847', '1@147.com', '测试昵称47', '47测试密码47', '测试盐47', '2022-09-17 22:48:43', '2022-09-17 22:48:43', 1);
INSERT INTO `user` VALUES (49, '测试名称48', '18888888848', '1@148.com', '测试昵称48', '48测试密码48', '测试盐48', '2022-09-17 22:48:43', '2022-09-17 22:48:43', 0);
INSERT INTO `user` VALUES (50, '测试名称49', '18888888849', '1@149.com', '测试昵称49', '49测试密码49', '测试盐49', '2022-09-17 22:48:43', '2022-09-17 22:48:43', 1);
INSERT INTO `user` VALUES (51, '测试名称50', '18888888850', '1@150.com', '测试昵称50', '50测试密码50', '测试盐50', '2022-09-17 22:48:43', '2022-09-17 22:48:43', 0);
INSERT INTO `user` VALUES (52, '测试名称51', '18888888851', '1@151.com', '测试昵称51', '51测试密码51', '测试盐51', '2022-09-17 22:48:43', '2022-09-17 22:48:43', 1);
INSERT INTO `user` VALUES (53, '测试名称52', '18888888852', '1@152.com', '测试昵称52', '52测试密码52', '测试盐52', '2022-09-17 22:48:43', '2022-09-17 22:48:43', 0);
INSERT INTO `user` VALUES (54, '测试名称53', '18888888853', '1@153.com', '测试昵称53', '53测试密码53', '测试盐53', '2022-09-17 22:48:43', '2022-09-17 22:48:43', 1);
INSERT INTO `user` VALUES (55, '测试名称54', '18888888854', '1@154.com', '测试昵称54', '54测试密码54', '测试盐54', '2022-09-17 22:48:43', '2022-09-17 22:48:43', 0);
INSERT INTO `user` VALUES (56, '测试名称55', '18888888855', '1@155.com', '测试昵称55', '55测试密码55', '测试盐55', '2022-09-17 22:48:44', '2022-09-17 22:48:43', 1);
INSERT INTO `user` VALUES (57, '测试名称56', '18888888856', '1@156.com', '测试昵称56', '56测试密码56', '测试盐56', '2022-09-17 22:48:44', '2022-09-17 22:48:43', 0);
INSERT INTO `user` VALUES (58, '测试名称57', '18888888857', '1@157.com', '测试昵称57', '57测试密码57', '测试盐57', '2022-09-17 22:48:44', '2022-09-17 22:48:43', 1);
INSERT INTO `user` VALUES (59, '测试名称58', '18888888858', '1@158.com', '测试昵称58', '58测试密码58', '测试盐58', '2022-09-17 22:48:44', '2022-09-17 22:48:43', 0);
INSERT INTO `user` VALUES (60, '测试名称59', '18888888859', '1@159.com', '测试昵称59', '59测试密码59', '测试盐59', '2022-09-17 22:48:44', '2022-09-17 22:48:43', 1);
INSERT INTO `user` VALUES (61, '测试名称60', '18888888860', '1@160.com', '测试昵称60', '60测试密码60', '测试盐60', '2022-09-17 22:48:44', '2022-09-17 22:48:43', 0);
INSERT INTO `user` VALUES (62, '测试名称61', '18888888861', '1@161.com', '测试昵称61', '61测试密码61', '测试盐61', '2022-09-17 22:48:44', '2022-09-17 22:48:43', 1);
INSERT INTO `user` VALUES (63, '测试名称62', '18888888862', '1@162.com', '测试昵称62', '62测试密码62', '测试盐62', '2022-09-17 22:48:44', '2022-09-17 22:48:43', 0);
INSERT INTO `user` VALUES (64, '测试名称63', '18888888863', '1@163.com', '测试昵称63', '63测试密码63', '测试盐63', '2022-09-17 22:48:44', '2022-09-17 22:48:43', 1);
INSERT INTO `user` VALUES (65, '测试名称64', '18888888864', '1@164.com', '测试昵称64', '64测试密码64', '测试盐64', '2022-09-17 22:48:44', '2022-09-17 22:48:43', 0);
INSERT INTO `user` VALUES (66, '测试名称65', '18888888865', '1@165.com', '测试昵称65', '65测试密码65', '测试盐65', '2022-09-17 22:48:44', '2022-09-17 22:48:43', 1);
INSERT INTO `user` VALUES (67, '测试名称66', '18888888866', '1@166.com', '测试昵称66', '66测试密码66', '测试盐66', '2022-09-17 22:48:44', '2022-09-17 22:48:43', 0);
INSERT INTO `user` VALUES (68, '测试名称67', '18888888867', '1@167.com', '测试昵称67', '67测试密码67', '测试盐67', '2022-09-17 22:48:44', '2022-09-17 22:48:43', 1);
INSERT INTO `user` VALUES (69, '测试名称68', '18888888868', '1@168.com', '测试昵称68', '68测试密码68', '测试盐68', '2022-09-17 22:48:44', '2022-09-17 22:48:43', 0);
INSERT INTO `user` VALUES (70, '测试名称69', '18888888869', '1@169.com', '测试昵称69', '69测试密码69', '测试盐69', '2022-09-17 22:48:44', '2022-09-17 22:48:43', 1);
INSERT INTO `user` VALUES (71, '测试名称70', '18888888870', '1@170.com', '测试昵称70', '70测试密码70', '测试盐70', '2022-09-17 22:48:44', '2022-09-17 22:48:43', 0);
INSERT INTO `user` VALUES (72, '测试名称71', '18888888871', '1@171.com', '测试昵称71', '71测试密码71', '测试盐71', '2022-09-17 22:48:44', '2022-09-17 22:48:43', 1);
INSERT INTO `user` VALUES (73, '测试名称72', '18888888872', '1@172.com', '测试昵称72', '72测试密码72', '测试盐72', '2022-09-17 22:48:44', '2022-09-17 22:48:43', 0);
INSERT INTO `user` VALUES (74, '测试名称73', '18888888873', '1@173.com', '测试昵称73', '73测试密码73', '测试盐73', '2022-09-17 22:48:44', '2022-09-17 22:48:43', 1);
INSERT INTO `user` VALUES (75, '测试名称74', '18888888874', '1@174.com', '测试昵称74', '74测试密码74', '测试盐74', '2022-09-17 22:48:44', '2022-09-17 22:48:43', 0);
INSERT INTO `user` VALUES (76, '测试名称75', '18888888875', '1@175.com', '测试昵称75', '75测试密码75', '测试盐75', '2022-09-17 22:48:44', '2022-09-17 22:48:43', 1);
INSERT INTO `user` VALUES (77, '测试名称76', '18888888876', '1@176.com', '测试昵称76', '76测试密码76', '测试盐76', '2022-09-17 22:48:44', '2022-09-17 22:48:43', 0);
INSERT INTO `user` VALUES (78, '测试名称77', '18888888877', '1@177.com', '测试昵称77', '77测试密码77', '测试盐77', '2022-09-17 22:48:44', '2022-09-17 22:48:43', 1);
INSERT INTO `user` VALUES (79, '测试名称78', '18888888878', '1@178.com', '测试昵称78', '78测试密码78', '测试盐78', '2022-09-17 22:48:44', '2022-09-17 22:48:43', 0);
INSERT INTO `user` VALUES (80, '测试名称79', '18888888879', '1@179.com', '测试昵称79', '79测试密码79', '测试盐79', '2022-09-17 22:48:44', '2022-09-17 22:48:43', 1);
INSERT INTO `user` VALUES (81, '测试名称80', '18888888880', '1@180.com', '测试昵称80', '80测试密码80', '测试盐80', '2022-09-17 22:48:44', '2022-09-17 22:48:43', 0);
INSERT INTO `user` VALUES (82, '测试名称81', '18888888881', '1@181.com', '测试昵称81', '81测试密码81', '测试盐81', '2022-09-17 22:48:44', '2022-09-17 22:48:43', 1);
INSERT INTO `user` VALUES (83, '测试名称82', '18888888882', '1@182.com', '测试昵称82', '82测试密码82', '测试盐82', '2022-09-17 22:48:44', '2022-09-17 22:48:43', 0);
INSERT INTO `user` VALUES (84, '测试名称83', '18888888883', '1@183.com', '测试昵称83', '83测试密码83', '测试盐83', '2022-09-17 22:48:44', '2022-09-17 22:48:43', 1);
INSERT INTO `user` VALUES (85, '测试名称84', '18888888884', '1@184.com', '测试昵称84', '84测试密码84', '测试盐84', '2022-09-17 22:48:44', '2022-09-17 22:48:43', 0);
INSERT INTO `user` VALUES (86, '测试名称85', '18888888885', '1@185.com', '测试昵称85', '85测试密码85', '测试盐85', '2022-09-17 22:48:44', '2022-09-17 22:48:43', 1);
INSERT INTO `user` VALUES (87, '测试名称86', '18888888886', '1@186.com', '测试昵称86', '86测试密码86', '测试盐86', '2022-09-17 22:48:44', '2022-09-17 22:48:43', 0);
INSERT INTO `user` VALUES (88, '测试名称87', '18888888887', '1@187.com', '测试昵称87', '87测试密码87', '测试盐87', '2022-09-17 22:48:44', '2022-09-17 22:48:43', 1);
INSERT INTO `user` VALUES (89, '测试名称88', '18888888888', '1@188.com', '测试昵称88', '88测试密码88', '测试盐88', '2022-09-17 22:48:44', '2022-09-17 22:48:43', 0);
INSERT INTO `user` VALUES (90, '测试名称89', '18888888889', '1@189.com', '测试昵称89', '89测试密码89', '测试盐89', '2022-09-17 22:48:44', '2022-09-17 22:48:43', 1);
INSERT INTO `user` VALUES (91, '测试名称90', '18888888890', '1@190.com', '测试昵称90', '90测试密码90', '测试盐90', '2022-09-17 22:48:44', '2022-09-17 22:48:43', 0);
INSERT INTO `user` VALUES (92, '测试名称91', '18888888891', '1@191.com', '测试昵称91', '91测试密码91', '测试盐91', '2022-09-17 22:48:44', '2022-09-17 22:48:43', 1);
INSERT INTO `user` VALUES (93, '测试名称92', '18888888892', '1@192.com', '测试昵称92', '92测试密码92', '测试盐92', '2022-09-17 22:48:44', '2022-09-17 22:48:44', 0);
INSERT INTO `user` VALUES (94, '测试名称93', '18888888893', '1@193.com', '测试昵称93', '93测试密码93', '测试盐93', '2022-09-17 22:48:44', '2022-09-17 22:48:44', 1);
INSERT INTO `user` VALUES (95, '测试名称94', '18888888894', '1@194.com', '测试昵称94', '94测试密码94', '测试盐94', '2022-09-17 22:48:44', '2022-09-17 22:48:44', 0);
INSERT INTO `user` VALUES (96, '测试名称95', '18888888895', '1@195.com', '测试昵称95', '95测试密码95', '测试盐95', '2022-09-17 22:48:44', '2022-09-17 22:48:44', 1);
INSERT INTO `user` VALUES (97, '测试名称96', '18888888896', '1@196.com', '测试昵称96', '96测试密码96', '测试盐96', '2022-09-17 22:48:44', '2022-09-17 22:48:44', 0);
INSERT INTO `user` VALUES (98, '测试名称97', '18888888897', '1@197.com', '测试昵称97', '97测试密码97', '测试盐97', '2022-09-17 22:48:44', '2022-09-17 22:48:44', 1);
INSERT INTO `user` VALUES (99, '测试名称98', '18888888898', '1@198.com', '测试昵称98', '98测试密码98', '测试盐98', '2022-09-17 22:48:44', '2022-09-17 22:48:44', 0);
INSERT INTO `user` VALUES (100, '测试名称99', '18888888899', '1@199.com', '测试昵称99', '99测试密码99', '测试盐99', '2022-09-17 22:48:44', '2022-09-17 22:48:44', 1);
COMMIT;

-- ----------------------------
-- Table structure for user_department
-- ----------------------------
DROP TABLE IF EXISTS `user_department`;
CREATE TABLE `user_department` (
  `USER_ID` int(11) NOT NULL COMMENT '用户ID,关联用户表主键',
  `DEPT_ID` int(11) NOT NULL COMMENT '部门ID,关联部门表主键,需要关联最末级节点',
  `CREATE_TIME` datetime DEFAULT NULL COMMENT '创建时间',
  `UPDATE_TIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '设置当前时间，并且自动更更新时间',
  `IS_DELETE` int(11) DEFAULT '1' COMMENT '是否删除 0:删除 1:未删除',
  PRIMARY KEY (`USER_ID`,`DEPT_ID`),
  KEY `DEPT_ID` (`DEPT_ID`),
  CONSTRAINT `user_department_ibfk_1` FOREIGN KEY (`USER_ID`) REFERENCES `user` (`USER_ID`),
  CONSTRAINT `user_department_ibfk_2` FOREIGN KEY (`DEPT_ID`) REFERENCES `department` (`DEPT_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户部门关联表';

-- ----------------------------
-- Records of user_department
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for user_role
-- ----------------------------
DROP TABLE IF EXISTS `user_role`;
CREATE TABLE `user_role` (
  `USER_ID` int(11) NOT NULL COMMENT '用户ID,关联用户表主键',
  `ROLE_ID` int(11) NOT NULL COMMENT '角色ID,关联角色表主键',
  `CREATE_TIME` datetime DEFAULT NULL COMMENT '创建时间',
  `UPDATE_TIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '设置当前时间，并且自动更更新时间',
  `IS_DELETE` int(11) DEFAULT '1' COMMENT '是否删除 0:删除 1:未删除',
  PRIMARY KEY (`USER_ID`,`ROLE_ID`),
  KEY `ROLE_ID` (`ROLE_ID`),
  CONSTRAINT `user_role_ibfk_1` FOREIGN KEY (`USER_ID`) REFERENCES `user` (`USER_ID`),
  CONSTRAINT `user_role_ibfk_2` FOREIGN KEY (`ROLE_ID`) REFERENCES `role` (`ROLE_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户角色关联表';

-- ----------------------------
-- Records of user_role
-- ----------------------------
BEGIN;
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
