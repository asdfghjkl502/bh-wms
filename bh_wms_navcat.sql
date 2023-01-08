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

 Date: 08/01/2023 10:17:32
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
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='承运商表';

-- ----------------------------
-- Records of carrier
-- ----------------------------
BEGIN;
INSERT INTO `carrier` VALUES (1, '顺丰物流科技', 'jd管理001', '199999999999', 'bjcp@163.com', '北京市昌平区,北七家', '2021-12-12 20:12:11', '2022-11-12 22:17:45', 1);
INSERT INTO `carrier` VALUES (2, '申通科技', 'ST180', '18002222222', 'ST@163.COM', '上海市闸北区', '2022-11-13 06:17:32', '2022-11-12 22:17:50', 1);
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
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8 COMMENT='商品类目表';

-- ----------------------------
-- Records of category
-- ----------------------------
BEGIN;
INSERT INTO `category` VALUES (1, '服饰', 1, 0, '2022-01-01 19:11:11', '2022-11-09 21:28:30', 1);
INSERT INTO `category` VALUES (2, '男装', 2, 1, '2022-01-01 19:11:11', '2022-11-09 21:30:12', 1);
INSERT INTO `category` VALUES (3, '夹克', 3, 2, '2022-01-01 19:11:11', '2022-11-09 22:27:55', 1);
INSERT INTO `category` VALUES (4, '家用电器', 1, 0, '2022-11-10 05:37:17', '2022-11-09 21:37:18', 1);
INSERT INTO `category` VALUES (5, '大家电', 2, 4, '2022-11-10 05:39:02', '2022-11-09 21:39:03', 1);
INSERT INTO `category` VALUES (6, '小家电', 2, 4, '2022-11-10 05:39:46', '2022-11-09 21:39:47', 1);
INSERT INTO `category` VALUES (7, '女装', 2, 1, '2022-11-10 05:39:57', '2022-11-09 21:39:58', 1);
INSERT INTO `category` VALUES (8, '连衣裙', 3, 7, '2022-11-03 05:40:10', '2022-11-09 22:16:35', 1);
INSERT INTO `category` VALUES (9, '洗衣机', 3, 5, '2022-11-10 05:40:32', '2022-11-09 21:40:33', 1);
INSERT INTO `category` VALUES (10, '电热水壶', 3, 6, '2000-12-12 20:12:12', '2022-11-09 22:11:17', 1);
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
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='客户表';

-- ----------------------------
-- Records of customer
-- ----------------------------
BEGIN;
INSERT INTO `customer` VALUES (1, 's名字10', 's领导10', '12333333338', 's@163.com', '南京市建邺区10', 3, 3, 2, '2022-12-02 06:22:21', '2022-11-14 23:36:08', 1);
INSERT INTO `customer` VALUES (2, '客户名001', '联系人001', '33333333333', '233@163.com', '地址', 2, 6, 4, '2022-11-15 06:31:29', '2022-11-14 23:34:56', 1);
INSERT INTO `customer` VALUES (3, '客户名002', '联系人002', '22222222222', '222@163.com', '地址002', 3, 5, 5, '2022-11-15 06:33:04', '2022-11-14 23:35:10', 1);
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
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8 COMMENT='部门表';

-- ----------------------------
-- Records of department
-- ----------------------------
BEGIN;
INSERT INTO `department` VALUES (1, '北京千锋互联科技有限公司', 1, 0, '2022-11-03 05:08:35', '2022-11-19 20:14:28', 1);
INSERT INTO `department` VALUES (2, '千锋互联科技有限公司(北京分公司)', 2, 1, '2022-11-03 05:08:59', '2022-11-19 20:15:08', 1);
INSERT INTO `department` VALUES (3, '产品研发部', 3, 2, '2022-11-03 05:09:16', '2022-11-02 21:09:17', 1);
INSERT INTO `department` VALUES (4, '千锋互联科技有限公司(南京分公司)', 2, 1, '2022-11-03 05:09:43', '2022-11-19 20:15:13', 1);
INSERT INTO `department` VALUES (5, '市场部', 3, 4, '2022-11-03 05:10:52', '2022-11-02 21:10:53', 1);
INSERT INTO `department` VALUES (6, '技术科研部', 3, 2, '2022-11-03 05:11:15', '2022-11-02 21:11:16', 1);
INSERT INTO `department` VALUES (7, '公关部', 3, 4, '2022-11-03 05:11:27', '2022-11-02 21:11:28', 1);
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
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COMMENT='客户行业表';

-- ----------------------------
-- Records of industry
-- ----------------------------
BEGIN;
INSERT INTO `industry` VALUES (1, '教育', '2012-12-12 20:12:12', '2022-11-08 23:12:31', 1);
INSERT INTO `industry` VALUES (2, '化工', '2022-11-09 07:03:46', '2022-11-08 23:12:27', 0);
INSERT INTO `industry` VALUES (3, '金融', '2022-11-09 07:03:58', '2022-11-08 23:12:34', 1);
INSERT INTO `industry` VALUES (4, '食品', '2022-11-09 07:08:07', '2022-11-08 23:12:27', 0);
INSERT INTO `industry` VALUES (5, '互联网', '2022-11-09 07:08:16', '2022-11-08 23:12:27', 0);
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
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='客户级别表';

-- ----------------------------
-- Records of level
-- ----------------------------
BEGIN;
INSERT INTO `level` VALUES (1, '青铜', '2022-11-06 04:56:10', '2022-11-05 21:50:59', 1);
INSERT INTO `level` VALUES (2, '白银', '2010-12-12 20:12:12', '2022-11-05 21:51:38', 1);
INSERT INTO `level` VALUES (3, '黄金', '2022-11-06 05:55:34', '2022-11-05 21:55:40', 1);
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
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8 COMMENT='菜单表';

-- ----------------------------
-- Records of menus
-- ----------------------------
BEGIN;
INSERT INTO `menus` VALUES (1, '仪表盘', '', 1, 0, '2022-11-02 05:09:10', '2022-11-01 21:14:21', 1);
INSERT INTO `menus` VALUES (2, '系统设置', '', 1, 0, '2022-11-02 05:09:19', '2022-11-01 21:09:20', 1);
INSERT INTO `menus` VALUES (3, '用户管理', '', 2, 2, '2022-11-02 05:09:29', '2022-11-01 21:09:30', 1);
INSERT INTO `menus` VALUES (4, '角色管理', '', 2, 2, '2022-11-02 05:09:44', '2022-11-01 21:09:45', 1);
INSERT INTO `menus` VALUES (5, '部门管理', '', 2, 2, '2022-11-02 05:09:54', '2022-11-01 21:09:55', 1);
INSERT INTO `menus` VALUES (6, '菜单管理', '', 2, 2, '2022-11-02 05:10:04', '2022-11-01 21:10:05', 1);
INSERT INTO `menus` VALUES (7, '基础数据', '', 1, 0, '2022-11-02 05:10:20', '2022-11-01 21:10:21', 1);
INSERT INTO `menus` VALUES (8, '产品管理', '', 2, 7, '2022-11-02 05:10:31', '2022-11-01 21:10:32', 1);
INSERT INTO `menus` VALUES (9, '客户管理', '', 2, 7, '2022-11-02 05:10:41', '2022-11-01 21:10:42', 1);
INSERT INTO `menus` VALUES (10, '供应商管理', '', 2, 7, '2022-11-02 05:10:53', '2022-11-01 21:10:54', 1);
INSERT INTO `menus` VALUES (11, '承运商管理', '', 2, 7, '2022-11-02 05:11:07', '2022-11-01 21:11:08', 1);
INSERT INTO `menus` VALUES (12, '仓库管理', '', 1, 0, '2022-11-02 05:11:33', '2022-11-01 21:11:34', 1);
INSERT INTO `menus` VALUES (13, '仓库管理', '', 2, 12, '2022-11-02 05:11:46', '2022-11-01 21:11:48', 1);
INSERT INTO `menus` VALUES (14, '货物入库', '', 2, 12, '2022-11-02 05:11:58', '2022-11-01 21:11:59', 1);
INSERT INTO `menus` VALUES (15, '货物出库', '', 2, 12, '2022-11-02 05:12:10', '2022-11-01 21:12:10', 1);
INSERT INTO `menus` VALUES (16, '库存查询', '', 2, 12, '2022-11-02 05:12:26', '2022-11-01 21:12:28', 1);
INSERT INTO `menus` VALUES (17, '字典管理', '', 1, 0, '2022-11-02 05:12:40', '2022-11-01 21:12:41', 1);
INSERT INTO `menus` VALUES (18, '产品类目', '', 2, 17, '2022-11-02 05:12:54', '2022-11-01 21:12:55', 1);
INSERT INTO `menus` VALUES (19, '客户级别', '', 2, 17, '2022-11-02 05:13:06', '2022-11-01 21:13:07', 1);
INSERT INTO `menus` VALUES (20, '客户来源', '', 2, 17, '2022-11-02 05:13:16', '2022-11-01 21:13:16', 1);
INSERT INTO `menus` VALUES (21, '日志管理', '', 1, 0, '2022-11-02 05:13:28', '2022-11-01 21:13:29', 1);
INSERT INTO `menus` VALUES (22, '系统日志', '', 2, 21, '2022-11-01 08:00:00', '2022-11-01 21:13:40', 1);
INSERT INTO `menus` VALUES (23, '登录日志', '', 2, 21, '2022-11-02 05:13:49', '2022-11-01 21:13:49', 1);
INSERT INTO `menus` VALUES (24, '商业智能', '', 2, 1, '2022-11-06 04:55:47', '2022-11-05 20:55:48', 1);
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
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='产品信息表';

-- ----------------------------
-- Records of product
-- ----------------------------
BEGIN;
INSERT INTO `product` VALUES (1, '衣服1', 3, '200*200', 1200.000, '2022-11-17 04:25:37', '2022-12-09 22:14:20', 1);
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
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COMMENT='入库记录表';

-- ----------------------------
-- Records of record_in
-- ----------------------------
BEGIN;
INSERT INTO `record_in` VALUES (1, 2, 1, 1, '2022-12-11 22:14:22', 1, 1, NULL, '2022-12-11 22:14:22', '2022-12-11 22:14:22', 1);
INSERT INTO `record_in` VALUES (2, 2, 1, 10, '2022-12-11 22:28:59', 1, 2, NULL, '2022-12-11 22:28:59', '2022-12-11 22:28:59', 1);
INSERT INTO `record_in` VALUES (3, 2, 1, 100, '2023-01-08 10:14:47', 1, 1, NULL, '2023-01-08 10:14:47', '2023-01-08 10:14:46', 1);
INSERT INTO `record_in` VALUES (4, 2, 1, 1, '2023-01-08 10:15:18', 1, 1, NULL, '2023-01-08 10:15:18', '2023-01-08 10:15:18', 1);
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
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COMMENT='出库记录表';

-- ----------------------------
-- Records of record_out
-- ----------------------------
BEGIN;
INSERT INTO `record_out` VALUES (1, 1, 1, 1, '2022-12-10 23:56:03', 1, 1, NULL, '2022-12-10 23:56:03', '2022-12-10 23:56:02', 1);
INSERT INTO `record_out` VALUES (2, 1, 1, 1, '2022-12-10 23:56:29', 1, 1, NULL, '2022-12-10 23:56:29', '2022-12-10 23:56:28', 1);
INSERT INTO `record_out` VALUES (3, 1, 1, 1, '2022-12-11 22:15:27', 1, 1, NULL, '2022-12-11 22:15:27', '2022-12-11 22:15:27', 1);
INSERT INTO `record_out` VALUES (4, 1, 1, 2, '2022-12-11 22:15:37', 1, 1, NULL, '2022-12-11 22:15:37', '2022-12-11 22:15:36', 1);
INSERT INTO `record_out` VALUES (5, 2, 1, 100, '2023-01-08 10:15:40', 1, 1, NULL, '2023-01-08 10:15:40', '2023-01-08 10:15:39', 1);
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
INSERT INTO `record_stock` VALUES (1, 1, 5, '2022-12-09 22:14:37', '2023-01-08 10:15:39', 1);
INSERT INTO `record_stock` VALUES (1, 2, 10, '2022-12-11 22:28:59', '2022-12-11 22:28:59', 1);
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
  `REPO_NAME` varchar(100) DEFAULT NULL COMMENT '仓库名称',
  PRIMARY KEY (`REPO_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='仓库信息表';

-- ----------------------------
-- Records of repository
-- ----------------------------
BEGIN;
INSERT INTO `repository` VALUES (1, '南京市建邺区1', '100011平米', '大仓库12', 2, '2022-12-27 20:12:12', '2022-12-08 22:45:26', 1, '南京市建邺区仓库1');
INSERT INTO `repository` VALUES (2, '南京市江宁区1', '100', '小仓库', 1, '2022-11-18 07:07:05', '2022-12-08 22:45:37', 1, '南京市江宁区仓库1');
INSERT INTO `repository` VALUES (3, '北京市昌平区北七家', '200000', '混合仓库', 1, '2023-01-08 10:16:54', '2023-01-08 10:16:56', 1, '北京昌平仓库');
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
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='角色表';

-- ----------------------------
-- Records of role
-- ----------------------------
BEGIN;
INSERT INTO `role` VALUES (1, '平台管理员', '2022-11-03 05:07:38', '2022-11-19 21:27:41', 1);
INSERT INTO `role` VALUES (2, '仓库管理员', '2022-11-03 05:07:49', '2022-11-19 21:26:43', 1);
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
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COMMENT='客户来源表';

-- ----------------------------
-- Records of source
-- ----------------------------
BEGIN;
INSERT INTO `source` VALUES (1, '百度', '2021-12-12 20:12:12', '2022-11-08 22:32:27', 1);
INSERT INTO `source` VALUES (2, '转介绍', '2022-11-09 06:22:40', '2022-11-08 22:25:41', 1);
INSERT INTO `source` VALUES (3, '官网', '2022-11-09 06:22:52', '2022-11-08 22:27:53', 1);
INSERT INTO `source` VALUES (4, '客户线索', '2022-11-09 06:28:21', '2022-11-08 22:28:22', 1);
INSERT INTO `source` VALUES (5, '电话销售', '2022-11-09 06:28:31', '2022-11-08 22:28:32', 1);
INSERT INTO `source` VALUES (6, '自谈', '2022-11-09 06:28:41', '2022-11-08 22:28:42', 1);
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
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='供应商信息表';

-- ----------------------------
-- Records of supplier
-- ----------------------------
BEGIN;
INSERT INTO `supplier` VALUES (1, '河北防爆', '大萝卜', '129999999', 'hbfb@163.com', '北京市昌平区', '2022-12-12 20:12:12', '2022-11-10 22:33:00', 1);
INSERT INTO `supplier` VALUES (2, '供应商名字011', '供应商联系人022', '12345678901', 'gys@163.com', '南京市建邺区南苑街道', '2022-11-10 05:52:47', '2022-11-10 22:33:07', 1);
COMMIT;

-- ----------------------------
-- Table structure for sys_log
-- ----------------------------
DROP TABLE IF EXISTS `sys_log`;
CREATE TABLE `sys_log` (
  `log_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '日志ID',
  `type` int(11) DEFAULT '1' COMMENT '日志类型 1:登陆日志; 0:其他日志',
  `ip_addr` varchar(255) NOT NULL COMMENT '请求地址',
  `method_name` varchar(100) NOT NULL COMMENT '请求方法名称',
  `method` varchar(100) NOT NULL COMMENT '请求方式',
  `nick_name` varchar(100) NOT NULL COMMENT '昵称',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`log_id`)
) ENGINE=InnoDB AUTO_INCREMENT=90 DEFAULT CHARSET=utf8 COMMENT='日志记录表';

-- ----------------------------
-- Records of sys_log
-- ----------------------------
BEGIN;
INSERT INTO `sys_log` VALUES (1, 0, '0:0:0:0:0:0:0:1', 'toLogin', 'GET', '匿名', '2023-01-06 23:09:33');
INSERT INTO `sys_log` VALUES (2, 0, '0:0:0:0:0:0:0:1', 'getVerifyCode', 'GET', '匿名', '2023-01-06 23:09:34');
INSERT INTO `sys_log` VALUES (3, 1, '0:0:0:0:0:0:0:1', 'login', 'POST', '匿名', '2023-01-06 23:09:39');
INSERT INTO `sys_log` VALUES (4, 0, '0:0:0:0:0:0:0:1', 'home', 'GET', '大萝卜张三', '2023-01-06 23:09:39');
INSERT INTO `sys_log` VALUES (5, 0, '0:0:0:0:0:0:0:1', 'getUserDetail', 'GET', '大萝卜张三', '2023-01-06 23:09:39');
INSERT INTO `sys_log` VALUES (6, 0, '0:0:0:0:0:0:0:1', 'getRepositoryPayloadStatistics', 'GET', '大萝卜张三', '2023-01-06 23:09:40');
INSERT INTO `sys_log` VALUES (7, 0, '0:0:0:0:0:0:0:1', 'getStatisticsInMonth', 'GET', '大萝卜张三', '2023-01-06 23:09:56');
INSERT INTO `sys_log` VALUES (8, 0, '0:0:0:0:0:0:0:1', 'getStatisticsOutMonth', 'GET', '大萝卜张三', '2023-01-06 23:09:56');
INSERT INTO `sys_log` VALUES (9, 0, '0:0:0:0:0:0:0:1', 'getStatisticsMonthMoney', 'GET', '大萝卜张三', '2023-01-06 23:09:56');
INSERT INTO `sys_log` VALUES (10, 0, '0:0:0:0:0:0:0:1', 'getLogs', 'GET', '大萝卜张三', '2023-01-06 23:13:48');
INSERT INTO `sys_log` VALUES (11, 0, '0:0:0:0:0:0:0:1', 'getLogs', 'GET', '大萝卜张三', '2023-01-06 23:13:50');
INSERT INTO `sys_log` VALUES (12, 0, '0:0:0:0:0:0:0:1', 'getCategoryList', 'GET', '大萝卜张三', '2023-01-06 23:14:09');
INSERT INTO `sys_log` VALUES (13, 0, '0:0:0:0:0:0:0:1', 'getLevelPage', 'GET', '大萝卜张三', '2023-01-06 23:14:19');
INSERT INTO `sys_log` VALUES (14, 0, '0:0:0:0:0:0:0:1', 'getSourcePage', 'GET', '大萝卜张三', '2023-01-06 23:14:23');
INSERT INTO `sys_log` VALUES (15, 0, '0:0:0:0:0:0:0:1', 'getIndustryPage', 'GET', '大萝卜张三', '2023-01-06 23:14:24');
INSERT INTO `sys_log` VALUES (16, 0, '0:0:0:0:0:0:0:1', 'getRepositoryPage', 'GET', '大萝卜张三', '2023-01-06 23:15:12');
INSERT INTO `sys_log` VALUES (17, 0, '0:0:0:0:0:0:0:1', 'getProductPage', 'GET', '大萝卜张三', '2023-01-06 23:15:17');
INSERT INTO `sys_log` VALUES (18, 0, '0:0:0:0:0:0:0:1', 'getCustomerPage', 'GET', '大萝卜张三', '2023-01-06 23:15:18');
INSERT INTO `sys_log` VALUES (19, 0, '0:0:0:0:0:0:0:1', 'getUserPage', 'GET', '大萝卜张三', '2023-01-06 23:15:19');
INSERT INTO `sys_log` VALUES (20, 0, '0:0:0:0:0:0:0:1', 'getRolePage', 'GET', '大萝卜张三', '2023-01-06 23:15:20');
INSERT INTO `sys_log` VALUES (21, 0, '0:0:0:0:0:0:0:1', 'getStatisticsInMonth', 'GET', '大萝卜张三', '2023-01-06 23:15:21');
INSERT INTO `sys_log` VALUES (22, 0, '0:0:0:0:0:0:0:1', 'getStatisticsMonthMoney', 'GET', '大萝卜张三', '2023-01-06 23:15:21');
INSERT INTO `sys_log` VALUES (23, 0, '0:0:0:0:0:0:0:1', 'getStatisticsOutMonth', 'GET', '大萝卜张三', '2023-01-06 23:15:21');
INSERT INTO `sys_log` VALUES (24, 0, '0:0:0:0:0:0:0:1', 'getStatisticsOutMonth', 'GET', '大萝卜张三', '2023-01-06 23:15:34');
INSERT INTO `sys_log` VALUES (25, 0, '0:0:0:0:0:0:0:1', 'getStatisticsInMonth', 'GET', '大萝卜张三', '2023-01-06 23:15:34');
INSERT INTO `sys_log` VALUES (26, 0, '0:0:0:0:0:0:0:1', 'getStatisticsMonthMoney', 'GET', '大萝卜张三', '2023-01-06 23:15:34');
INSERT INTO `sys_log` VALUES (27, 0, '0:0:0:0:0:0:0:1', 'home', 'GET', '大萝卜张三', '2023-01-06 23:15:53');
INSERT INTO `sys_log` VALUES (28, 0, '0:0:0:0:0:0:0:1', 'getUserDetail', 'GET', '大萝卜张三', '2023-01-06 23:15:53');
INSERT INTO `sys_log` VALUES (29, 0, '0:0:0:0:0:0:0:1', 'getRepositoryPayloadStatistics', 'GET', '大萝卜张三', '2023-01-06 23:15:53');
INSERT INTO `sys_log` VALUES (30, 0, '0:0:0:0:0:0:0:1', 'getUserDetail', 'GET', '大萝卜张三', '2023-01-06 23:18:37');
INSERT INTO `sys_log` VALUES (31, 0, '0:0:0:0:0:0:0:1', 'uploadFile', 'POST', '大萝卜张三', '2023-01-06 23:18:44');
INSERT INTO `sys_log` VALUES (32, 0, '0:0:0:0:0:0:0:1', 'updateUser', 'POST', '大萝卜张三', '2023-01-06 23:18:46');
INSERT INTO `sys_log` VALUES (33, 0, '0:0:0:0:0:0:0:1', 'home', 'GET', '大萝卜张三', '2023-01-06 23:18:46');
INSERT INTO `sys_log` VALUES (34, 0, '0:0:0:0:0:0:0:1', 'getUserDetail', 'GET', '大萝卜张三', '2023-01-06 23:18:46');
INSERT INTO `sys_log` VALUES (35, 0, '0:0:0:0:0:0:0:1', 'getRepositoryPayloadStatistics', 'GET', '大萝卜张三', '2023-01-06 23:18:46');
INSERT INTO `sys_log` VALUES (36, 0, '0:0:0:0:0:0:0:1', 'toLogin', 'GET', '匿名', '2023-01-08 10:13:44');
INSERT INTO `sys_log` VALUES (37, 0, '0:0:0:0:0:0:0:1', 'getVerifyCode', 'GET', '匿名', '2023-01-08 10:13:45');
INSERT INTO `sys_log` VALUES (38, 1, '0:0:0:0:0:0:0:1', 'login', 'POST', '匿名', '2023-01-08 10:13:49');
INSERT INTO `sys_log` VALUES (39, 0, '0:0:0:0:0:0:0:1', 'home', 'GET', '大萝卜张三', '2023-01-08 10:13:49');
INSERT INTO `sys_log` VALUES (40, 0, '0:0:0:0:0:0:0:1', 'getUserDetail', 'GET', '大萝卜张三', '2023-01-08 10:13:49');
INSERT INTO `sys_log` VALUES (41, 0, '0:0:0:0:0:0:0:1', 'getRepositoryPayloadStatistics', 'GET', '大萝卜张三', '2023-01-08 10:13:50');
INSERT INTO `sys_log` VALUES (42, 0, '0:0:0:0:0:0:0:1', 'getStatisticsInMonth', 'GET', '大萝卜张三', '2023-01-08 10:13:53');
INSERT INTO `sys_log` VALUES (43, 0, '0:0:0:0:0:0:0:1', 'getStatisticsOutMonth', 'GET', '大萝卜张三', '2023-01-08 10:13:53');
INSERT INTO `sys_log` VALUES (44, 0, '0:0:0:0:0:0:0:1', 'getStatisticsMonthMoney', 'GET', '大萝卜张三', '2023-01-08 10:13:53');
INSERT INTO `sys_log` VALUES (45, 0, '0:0:0:0:0:0:0:1', 'getUserPage', 'GET', '大萝卜张三', '2023-01-08 10:14:11');
INSERT INTO `sys_log` VALUES (46, 0, '0:0:0:0:0:0:0:1', 'getStatisticsInMonth', 'GET', '大萝卜张三', '2023-01-08 10:14:16');
INSERT INTO `sys_log` VALUES (47, 0, '0:0:0:0:0:0:0:1', 'getStatisticsMonthMoney', 'GET', '大萝卜张三', '2023-01-08 10:14:16');
INSERT INTO `sys_log` VALUES (48, 0, '0:0:0:0:0:0:0:1', 'getStatisticsOutMonth', 'GET', '大萝卜张三', '2023-01-08 10:14:16');
INSERT INTO `sys_log` VALUES (49, 0, '0:0:0:0:0:0:0:1', 'getSupplierList', 'GET', '大萝卜张三', '2023-01-08 10:14:28');
INSERT INTO `sys_log` VALUES (50, 0, '0:0:0:0:0:0:0:1', 'getProductList', 'GET', '大萝卜张三', '2023-01-08 10:14:31');
INSERT INTO `sys_log` VALUES (51, 0, '0:0:0:0:0:0:0:1', 'getProductList', 'GET', '大萝卜张三', '2023-01-08 10:14:36');
INSERT INTO `sys_log` VALUES (52, 0, '0:0:0:0:0:0:0:1', 'getProduct', 'GET', '大萝卜张三', '2023-01-08 10:14:37');
INSERT INTO `sys_log` VALUES (53, 0, '0:0:0:0:0:0:0:1', 'getRepositoryList', 'GET', '大萝卜张三', '2023-01-08 10:14:41');
INSERT INTO `sys_log` VALUES (54, 0, '0:0:0:0:0:0:0:1', 'getProduct', 'GET', '大萝卜张三', '2023-01-08 10:14:42');
INSERT INTO `sys_log` VALUES (55, 0, '0:0:0:0:0:0:0:1', 'inRecordStock', 'POST', '大萝卜张三', '2023-01-08 10:14:47');
INSERT INTO `sys_log` VALUES (56, 0, '0:0:0:0:0:0:0:1', 'getStatisticsInMonth', 'GET', '大萝卜张三', '2023-01-08 10:14:50');
INSERT INTO `sys_log` VALUES (57, 0, '0:0:0:0:0:0:0:1', 'getStatisticsOutMonth', 'GET', '大萝卜张三', '2023-01-08 10:14:50');
INSERT INTO `sys_log` VALUES (58, 0, '0:0:0:0:0:0:0:1', 'getStatisticsMonthMoney', 'GET', '大萝卜张三', '2023-01-08 10:14:50');
INSERT INTO `sys_log` VALUES (59, 0, '0:0:0:0:0:0:0:1', 'getSupplierList', 'GET', '大萝卜张三', '2023-01-08 10:15:09');
INSERT INTO `sys_log` VALUES (60, 0, '0:0:0:0:0:0:0:1', 'getProductList', 'GET', '大萝卜张三', '2023-01-08 10:15:12');
INSERT INTO `sys_log` VALUES (61, 0, '0:0:0:0:0:0:0:1', 'getProduct', 'GET', '大萝卜张三', '2023-01-08 10:15:13');
INSERT INTO `sys_log` VALUES (62, 0, '0:0:0:0:0:0:0:1', 'getRepositoryList', 'GET', '大萝卜张三', '2023-01-08 10:15:14');
INSERT INTO `sys_log` VALUES (63, 0, '0:0:0:0:0:0:0:1', 'getProduct', 'GET', '大萝卜张三', '2023-01-08 10:15:16');
INSERT INTO `sys_log` VALUES (64, 0, '0:0:0:0:0:0:0:1', 'inRecordStock', 'POST', '大萝卜张三', '2023-01-08 10:15:18');
INSERT INTO `sys_log` VALUES (65, 0, '0:0:0:0:0:0:0:1', 'getStatisticsInMonth', 'GET', '大萝卜张三', '2023-01-08 10:15:22');
INSERT INTO `sys_log` VALUES (66, 0, '0:0:0:0:0:0:0:1', 'getStatisticsOutMonth', 'GET', '大萝卜张三', '2023-01-08 10:15:22');
INSERT INTO `sys_log` VALUES (67, 0, '0:0:0:0:0:0:0:1', 'getStatisticsMonthMoney', 'GET', '大萝卜张三', '2023-01-08 10:15:22');
INSERT INTO `sys_log` VALUES (68, 0, '0:0:0:0:0:0:0:1', 'getCustomerList', 'GET', '大萝卜张三', '2023-01-08 10:15:31');
INSERT INTO `sys_log` VALUES (69, 0, '0:0:0:0:0:0:0:1', 'getProductList', 'GET', '大萝卜张三', '2023-01-08 10:15:34');
INSERT INTO `sys_log` VALUES (70, 0, '0:0:0:0:0:0:0:1', 'getProduct', 'GET', '大萝卜张三', '2023-01-08 10:15:34');
INSERT INTO `sys_log` VALUES (71, 0, '0:0:0:0:0:0:0:1', 'getRepositoryList', 'GET', '大萝卜张三', '2023-01-08 10:15:36');
INSERT INTO `sys_log` VALUES (72, 0, '0:0:0:0:0:0:0:1', 'getProduct', 'GET', '大萝卜张三', '2023-01-08 10:15:36');
INSERT INTO `sys_log` VALUES (73, 0, '0:0:0:0:0:0:0:1', 'outRecordStock', 'POST', '大萝卜张三', '2023-01-08 10:15:40');
INSERT INTO `sys_log` VALUES (74, 0, '0:0:0:0:0:0:0:1', 'getStatisticsInMonth', 'GET', '大萝卜张三', '2023-01-08 10:15:43');
INSERT INTO `sys_log` VALUES (75, 0, '0:0:0:0:0:0:0:1', 'getStatisticsOutMonth', 'GET', '大萝卜张三', '2023-01-08 10:15:43');
INSERT INTO `sys_log` VALUES (76, 0, '0:0:0:0:0:0:0:1', 'getStatisticsMonthMoney', 'GET', '大萝卜张三', '2023-01-08 10:15:43');
INSERT INTO `sys_log` VALUES (77, 0, '0:0:0:0:0:0:0:1', 'getUserDetail', 'GET', '大萝卜张三', '2023-01-08 10:15:53');
INSERT INTO `sys_log` VALUES (78, 0, '0:0:0:0:0:0:0:1', 'uploadFile', 'POST', '大萝卜张三', '2023-01-08 10:15:58');
INSERT INTO `sys_log` VALUES (79, 0, '0:0:0:0:0:0:0:1', 'updateUser', 'POST', '大萝卜张三', '2023-01-08 10:16:00');
INSERT INTO `sys_log` VALUES (80, 0, '0:0:0:0:0:0:0:1', 'home', 'GET', '大萝卜张三', '2023-01-08 10:16:00');
INSERT INTO `sys_log` VALUES (81, 0, '0:0:0:0:0:0:0:1', 'getUserDetail', 'GET', '大萝卜张三', '2023-01-08 10:16:01');
INSERT INTO `sys_log` VALUES (82, 0, '0:0:0:0:0:0:0:1', 'getRepositoryPayloadStatistics', 'GET', '大萝卜张三', '2023-01-08 10:16:01');
INSERT INTO `sys_log` VALUES (83, 0, '0:0:0:0:0:0:0:1', 'getRepositoryPage', 'GET', '大萝卜张三', '2023-01-08 10:16:24');
INSERT INTO `sys_log` VALUES (84, 0, '0:0:0:0:0:0:0:1', 'getRepositoryStatusList', 'GET', '大萝卜张三', '2023-01-08 10:16:25');
INSERT INTO `sys_log` VALUES (85, 0, '0:0:0:0:0:0:0:1', 'addRepository', 'POST', '大萝卜张三', '2023-01-08 10:16:56');
INSERT INTO `sys_log` VALUES (86, 0, '0:0:0:0:0:0:0:1', 'getRepositoryPage', 'GET', '大萝卜张三', '2023-01-08 10:16:56');
INSERT INTO `sys_log` VALUES (87, 0, '0:0:0:0:0:0:0:1', 'home', 'GET', '大萝卜张三', '2023-01-08 10:16:59');
INSERT INTO `sys_log` VALUES (88, 0, '0:0:0:0:0:0:0:1', 'getUserDetail', 'GET', '大萝卜张三', '2023-01-08 10:16:59');
INSERT INTO `sys_log` VALUES (89, 0, '0:0:0:0:0:0:0:1', 'getRepositoryPayloadStatistics', 'GET', '大萝卜张三', '2023-01-08 10:17:00');
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
  `AVATAR` varchar(255) DEFAULT '/img/avatar.jpeg' COMMENT '头像',
  PRIMARY KEY (`USER_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='用户表';

-- ----------------------------
-- Records of user
-- ----------------------------
BEGIN;
INSERT INTO `user` VALUES (1, '张三', '18288888888', 'z3@163.com', '大萝卜张三', 'a38b872c85e9096dd2d97b5dbe482861', '1', '2022-11-04 05:40:53', '2023-01-08 10:16:00', 1, '/pics/1ffa527f-ae9e-4d6c-b036-7abaf525de03.jpeg');
INSERT INTO `user` VALUES (2, '李四', '18333333321', 'q@q.com', '大萝卜123', '074a99bbd19a11ca921a7b12afffc8bc', '1667568835473', '2022-11-05 05:33:54', '2022-11-20 18:54:17', 1, '/img/avatar.jpeg');
INSERT INTO `user` VALUES (3, '李雷', '13313676789', 'll@163.com', '雷子', '51b4f11a197f52d062d4825a47486cd4', '0.3175579183075884', '2022-11-21 02:11:17', '2022-11-20 18:54:44', 1, '/img/avatar.jpeg');
COMMIT;

-- ----------------------------
-- Table structure for user_department
-- ----------------------------
DROP TABLE IF EXISTS `user_department`;
CREATE TABLE `user_department` (
  `DEPT_ID` int(11) NOT NULL COMMENT '部门ID',
  `USER_ID` int(11) NOT NULL COMMENT '用户ID',
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
INSERT INTO `user_department` VALUES (3, 1, '2022-11-04 05:40:53', '2022-11-03 21:40:55', 1);
INSERT INTO `user_department` VALUES (5, 1, '2022-11-04 05:40:53', '2022-11-03 21:40:55', 1);
INSERT INTO `user_department` VALUES (6, 1, '2022-11-04 05:40:53', '2022-11-03 21:40:55', 1);
INSERT INTO `user_department` VALUES (7, 1, '2022-11-04 05:40:53', '2022-11-03 21:40:55', 1);
INSERT INTO `user_department` VALUES (5, 2, '2022-11-05 05:33:54', '2022-11-04 21:33:55', 1);
INSERT INTO `user_department` VALUES (7, 2, '2022-11-05 05:33:54', '2022-11-04 21:33:55', 1);
INSERT INTO `user_department` VALUES (6, 3, '2022-11-21 02:11:17', '2022-11-20 18:11:18', 1);
COMMIT;

-- ----------------------------
-- Table structure for user_repository
-- ----------------------------
DROP TABLE IF EXISTS `user_repository`;
CREATE TABLE `user_repository` (
  `REPO_ID` int(11) NOT NULL COMMENT '仓库ID',
  `USER_ID` int(11) NOT NULL COMMENT '用户ID',
  `CREATE_TIME` datetime DEFAULT NULL COMMENT '创建时间',
  `UPDATE_TIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '设置当前时间，并且自动更更新时间',
  `IS_DELETE` int(11) DEFAULT '1' COMMENT '是否删除 0:删除 1:未删除',
  PRIMARY KEY (`REPO_ID`,`USER_ID`),
  KEY `USER_ID` (`USER_ID`),
  CONSTRAINT `user_repository_ibfk_1` FOREIGN KEY (`REPO_ID`) REFERENCES `repository` (`REPO_ID`),
  CONSTRAINT `user_repository_ibfk_2` FOREIGN KEY (`USER_ID`) REFERENCES `user` (`USER_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户仓库关联表';

-- ----------------------------
-- Records of user_repository
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
INSERT INTO `user_role` VALUES (1, 1, '2022-11-04 05:40:53', '2022-11-03 21:40:55', 1);
INSERT INTO `user_role` VALUES (1, 2, '2022-11-04 05:40:53', '2022-11-03 21:40:55', 1);
INSERT INTO `user_role` VALUES (2, 1, '2022-11-05 05:33:54', '2022-11-04 21:33:55', 1);
INSERT INTO `user_role` VALUES (3, 1, '2022-11-21 02:11:17', '2022-11-20 18:11:18', 1);
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
