/*
 Navicat Premium Data Transfer

 Source Server         : MYSQL
 Source Server Type    : MySQL
 Source Server Version : 50723
 Source Host           : localhost:3306
 Source Schema         : bh_wms

 Target Server Type    : MySQL
 Target Server Version : 50723
 File Encoding         : 65001

 Date: 25/11/2022 19:23:21
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for carrier
-- ----------------------------
DROP TABLE IF EXISTS `carrier`;
CREATE TABLE `carrier`  (
  `CARRIER_ID` int(11) NOT NULL AUTO_INCREMENT COMMENT '承运商ID,主键自增',
  `CARRIER_NAME` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '承运商名称',
  `CARRIER_LEADER` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '承运商负责人',
  `CARRIER_TEL` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '联系电话',
  `CARRIER_EMAIL` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '联系邮箱',
  `CARRIER_ADDRESS` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '联系地址',
  `CREATE_TIME` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `UPDATE_TIME` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '设置当前时间，并且自动更更新时间',
  `IS_DELETE` int(11) NULL DEFAULT 1 COMMENT '是否删除 0:删除 1:未删除',
  PRIMARY KEY (`CARRIER_ID`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '承运商表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of carrier
-- ----------------------------
INSERT INTO `carrier` VALUES (1, '承运商', '领导', '电话', '邮箱', '地址', '2012-12-12 20:12:12', '2022-11-25 18:58:55', 1);
INSERT INTO `carrier` VALUES (2, '顺丰物流333', 'sf联系人333', '1111111111', '1231111@163.com', '地址111', '2022-11-12 21:00:22', '2022-11-12 13:00:30', 1);

-- ----------------------------
-- Table structure for category
-- ----------------------------
DROP TABLE IF EXISTS `category`;
CREATE TABLE `category`  (
  `CATEGORY_ID` int(11) NOT NULL AUTO_INCREMENT COMMENT '类目ID,主键自增',
  `CATEGORY_NAME` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '类目名称',
  `LEVEL` int(11) NULL DEFAULT 1 COMMENT '层级',
  `PARENT_ID` int(11) NULL DEFAULT 0 COMMENT '父ID,关联主键(自关联),顶层父ID为0',
  `CREATE_TIME` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `UPDATE_TIME` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '设置当前时间，并且自动更更新时间',
  `IS_DELETE` int(11) NULL DEFAULT 1 COMMENT '是否删除 0:删除 1:未删除',
  PRIMARY KEY (`CATEGORY_ID`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '商品类目表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of category
-- ----------------------------
INSERT INTO `category` VALUES (1, '衣服', 1, 0, '2022-11-10 16:37:09', '2022-11-10 08:37:09', 1);
INSERT INTO `category` VALUES (2, '流行男装', 2, 1, '2022-11-10 16:37:20', '2022-11-10 08:37:21', 1);
INSERT INTO `category` VALUES (3, '流行女装', 2, 1, '2022-11-10 16:37:29', '2022-11-10 08:37:30', 1);
INSERT INTO `category` VALUES (4, '夹克', 3, 2, '2022-11-10 08:00:00', '2022-11-10 08:37:38', 1);
INSERT INTO `category` VALUES (5, '连衣裙', 3, 3, '2022-11-10 16:37:47', '2022-11-10 08:37:48', 1);

-- ----------------------------
-- Table structure for customer
-- ----------------------------
DROP TABLE IF EXISTS `customer`;
CREATE TABLE `customer`  (
  `CUSTOMER_ID` int(11) NOT NULL AUTO_INCREMENT COMMENT '客户ID,主键自增',
  `CUSTOMER_NAME` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '客户名称,如果为公司,那么是公司名,如果为个人,那么填写个人名称',
  `CUSTOMER_LEADER` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '客户负责人,如果公司为个人,那么和CUSTOMER_NAME内容相同',
  `CUSTOMER_TEL` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '联系电话',
  `CUSTOMER_EMAIL` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '联系邮箱',
  `CUSTOMER_ADDRESS` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '联系地址',
  `LEVEL_ID` int(11) NOT NULL COMMENT '客户级别,关联级别表主键',
  `SOURCE_ID` int(11) NOT NULL COMMENT '客户来源,关联来源表主键',
  `INDUSTRY_ID` int(11) NOT NULL COMMENT '客户行业,关联行业表主键',
  `CREATE_TIME` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `UPDATE_TIME` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '设置当前时间，并且自动更更新时间',
  `IS_DELETE` int(11) NULL DEFAULT 1 COMMENT '是否删除 0:删除 1:未删除',
  PRIMARY KEY (`CUSTOMER_ID`) USING BTREE,
  INDEX `LEVEL_ID`(`LEVEL_ID`) USING BTREE,
  INDEX `SOURCE_ID`(`SOURCE_ID`) USING BTREE,
  INDEX `INDUSTRY_ID`(`INDUSTRY_ID`) USING BTREE,
  CONSTRAINT `customer_ibfk_1` FOREIGN KEY (`LEVEL_ID`) REFERENCES `level` (`LEVEL_ID`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `customer_ibfk_2` FOREIGN KEY (`SOURCE_ID`) REFERENCES `source` (`SOURCE_ID`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `customer_ibfk_3` FOREIGN KEY (`INDUSTRY_ID`) REFERENCES `industry` (`INDUSTRY_ID`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '客户表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of customer
-- ----------------------------
INSERT INTO `customer` VALUES (1, '三一重工', '客户领导1', '123123123123', '123@163.com', '南京建邺', 1, 1, 1, '2011-12-12 20:12:12', '2022-11-14 15:06:57', 1);
INSERT INTO `customer` VALUES (2, '三二重工', '客户领导2', '123123123123', '123@163.com', '南京建邺', 1, 1, 1, '2011-12-12 20:12:12', '2022-11-14 15:06:59', 1);

-- ----------------------------
-- Table structure for department
-- ----------------------------
DROP TABLE IF EXISTS `department`;
CREATE TABLE `department`  (
  `DEPT_ID` int(11) NOT NULL AUTO_INCREMENT COMMENT '部门ID',
  `DEPT_NAME` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '部门名称',
  `LEVEL` int(11) NULL DEFAULT 1 COMMENT '层级',
  `PARENT_ID` int(11) NULL DEFAULT 0 COMMENT '父ID,自关联DEPT_ID',
  `CREATE_TIME` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `UPDATE_TIME` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '设置当前时间，并且自动更更新时间',
  `IS_DELETE` int(11) NULL DEFAULT 1 COMMENT '是否删除 0:删除 1:未删除',
  PRIMARY KEY (`DEPT_ID`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '部门表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of department
-- ----------------------------
INSERT INTO `department` VALUES (1, '安丰科技股份有限公司', 1, 0, '2022-11-03 05:08:35', '2022-11-02 21:10:01', 1);
INSERT INTO `department` VALUES (2, '安丰科技股份有限公司(北京分公司)', 2, 1, '2022-11-03 05:08:59', '2022-11-02 21:09:52', 1);
INSERT INTO `department` VALUES (3, '产品研发部', 3, 2, '2022-11-03 05:09:16', '2022-11-02 21:09:17', 1);
INSERT INTO `department` VALUES (4, '安丰科技股份有限公司(南京分公司)', 2, 1, '2022-11-03 05:09:43', '2022-11-02 21:10:40', 1);
INSERT INTO `department` VALUES (5, '市场部', 3, 4, '2022-11-03 05:10:52', '2022-11-02 21:10:53', 1);
INSERT INTO `department` VALUES (6, '技术科研部', 3, 2, '2022-11-03 05:11:15', '2022-11-02 21:11:16', 1);
INSERT INTO `department` VALUES (7, '公关部', 3, 4, '2022-11-03 05:11:27', '2022-11-02 21:11:28', 1);

-- ----------------------------
-- Table structure for industry
-- ----------------------------
DROP TABLE IF EXISTS `industry`;
CREATE TABLE `industry`  (
  `INDUSTRY_ID` int(11) NOT NULL AUTO_INCREMENT COMMENT '行业ID,主键自增',
  `INDUSTRY_NAME` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '行业名称',
  `CREATE_TIME` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `UPDATE_TIME` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '设置当前时间，并且自动更更新时间',
  `IS_DELETE` int(11) NULL DEFAULT 1 COMMENT '是否删除 0:删除 1:未删除',
  PRIMARY KEY (`INDUSTRY_ID`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '客户行业表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of industry
-- ----------------------------
INSERT INTO `industry` VALUES (1, '教育', '2022-11-14 14:15:23', '2022-11-14 14:15:26', 1);

-- ----------------------------
-- Table structure for level
-- ----------------------------
DROP TABLE IF EXISTS `level`;
CREATE TABLE `level`  (
  `LEVEL_ID` int(11) NOT NULL AUTO_INCREMENT COMMENT '客户级别ID,主键自增',
  `LEVEL_NAME` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '客户级别名称',
  `CREATE_TIME` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `UPDATE_TIME` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '设置当前时间，并且自动更更新时间',
  `IS_DELETE` int(11) NULL DEFAULT 1 COMMENT '是否删除 0:删除 1:未删除',
  PRIMARY KEY (`LEVEL_ID`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 9 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '客户级别表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of level
-- ----------------------------
INSERT INTO `level` VALUES (1, '白银', '2022-11-05 12:27:01', '2022-11-07 08:35:02', 1);
INSERT INTO `level` VALUES (2, '黄金', '2022-11-05 12:27:13', '2022-11-07 08:35:11', 1);
INSERT INTO `level` VALUES (3, '铂金', '2022-11-05 12:27:23', '2022-11-05 12:55:26', 1);
INSERT INTO `level` VALUES (4, '钻石', '2022-11-05 12:27:32', '2022-11-05 12:27:34', 1);
INSERT INTO `level` VALUES (5, '星耀', '2021-12-13 06:22:22', '2022-11-05 12:38:40', 1);
INSERT INTO `level` VALUES (6, '王者', '2022-11-05 20:39:24', '2022-11-05 12:39:25', 1);
INSERT INTO `level` VALUES (7, '最强王者', '2022-11-05 20:39:37', '2022-11-05 12:39:38', 1);
INSERT INTO `level` VALUES (8, '超级王者', '2022-11-05 20:59:06', '2022-11-05 12:59:06', 1);

-- ----------------------------
-- Table structure for menus
-- ----------------------------
DROP TABLE IF EXISTS `menus`;
CREATE TABLE `menus`  (
  `MENU_ID` int(11) NOT NULL AUTO_INCREMENT COMMENT '菜单ID,主键自增',
  `MENU_NAME` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '菜单名称',
  `MENU_URL` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '菜单地址',
  `LEVEL` int(11) NULL DEFAULT 1 COMMENT '层级',
  `PARENT_ID` int(11) NULL DEFAULT NULL COMMENT '父ID,关联menus表主键,默认值为0,表示菜单第一级',
  `CREATE_TIME` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `UPDATE_TIME` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '设置当前时间，并且自动更更新时间',
  `IS_DELETE` int(11) NULL DEFAULT 1 COMMENT '菜单状态 0:删除 1:未删除',
  PRIMARY KEY (`MENU_ID`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 25 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '菜单表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of menus
-- ----------------------------
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
INSERT INTO `menus` VALUES (24, '商业智能', '', 2, 1, '2022-11-05 16:45:40', '2022-11-05 08:45:40', 1);

-- ----------------------------
-- Table structure for product
-- ----------------------------
DROP TABLE IF EXISTS `product`;
CREATE TABLE `product`  (
  `PRODUCT_ID` int(11) NOT NULL AUTO_INCREMENT COMMENT '产品ID,主键自增',
  `PRODUCT_NAME` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '产品名称',
  `CATEGORY_ID` int(11) NOT NULL COMMENT '产品类目ID,关联类目表主键',
  `PRODUCT_SIZE` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '产品尺寸(长乘宽),单位 毫米(mm)',
  `PRODUCT_PRICE` double(16, 3) NULL DEFAULT NULL COMMENT '产品价格',
  `CREATE_TIME` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `UPDATE_TIME` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '设置当前时间，并且自动更更新时间',
  `IS_DELETE` int(11) NULL DEFAULT 1 COMMENT '是否删除 0:删除 1:未删除',
  PRIMARY KEY (`PRODUCT_ID`) USING BTREE,
  INDEX `CATEGORY_ID`(`CATEGORY_ID`) USING BTREE,
  CONSTRAINT `product_ibfk_1` FOREIGN KEY (`CATEGORY_ID`) REFERENCES `category` (`CATEGORY_ID`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '产品信息表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of product
-- ----------------------------
INSERT INTO `product` VALUES (1, '商品名称001', 4, '200*300', 10000.120, '2009-12-12 20:12:12', '2022-11-17 18:02:17', 1);

-- ----------------------------
-- Table structure for record_in
-- ----------------------------
DROP TABLE IF EXISTS `record_in`;
CREATE TABLE `record_in`  (
  `RECORD_IN_ID` int(11) NOT NULL AUTO_INCREMENT COMMENT '入库ID,主键自增',
  `SUPPLIER_ID` int(11) NOT NULL COMMENT '供应商ID,关联供应商表主键',
  `PRODUCT_ID` int(11) NOT NULL COMMENT '产品ID,关联产品表主键',
  `RECORD_IN_NUMBER` int(11) NULL DEFAULT 0 COMMENT '入库数量',
  `RECORD_IN_TIME` datetime(0) NULL DEFAULT NULL COMMENT '入库时间',
  `USER_ID` int(11) NOT NULL COMMENT '入库负责人ID,关联用户表主键',
  `REPO_ID` int(11) NOT NULL COMMENT '仓库ID,关联仓库表主键',
  `REMARKS` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注',
  `CREATE_TIME` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `UPDATE_TIME` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '设置当前时间，并且自动更更新时间',
  `IS_DELETE` int(11) NULL DEFAULT 1 COMMENT '是否删除 0:删除 1:未删除',
  PRIMARY KEY (`RECORD_IN_ID`) USING BTREE,
  INDEX `SUPPLIER_ID`(`SUPPLIER_ID`) USING BTREE,
  INDEX `PRODUCT_ID`(`PRODUCT_ID`) USING BTREE,
  INDEX `USER_ID`(`USER_ID`) USING BTREE,
  CONSTRAINT `record_in_ibfk_1` FOREIGN KEY (`SUPPLIER_ID`) REFERENCES `supplier` (`SUPPLIER_ID`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `record_in_ibfk_2` FOREIGN KEY (`PRODUCT_ID`) REFERENCES `product` (`PRODUCT_ID`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `record_in_ibfk_3` FOREIGN KEY (`USER_ID`) REFERENCES `user` (`USER_ID`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '入库记录表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for record_out
-- ----------------------------
DROP TABLE IF EXISTS `record_out`;
CREATE TABLE `record_out`  (
  `RECORD_OUT_ID` int(11) NOT NULL AUTO_INCREMENT COMMENT '出库ID,主键自增',
  `CUSTOMER_ID` int(11) NOT NULL COMMENT '客户ID,关联客户表主键',
  `PRODUCT_ID` int(11) NOT NULL COMMENT '产品ID,关联产品表主键',
  `RECORD_OUT_NUMBER` int(11) NULL DEFAULT 0 COMMENT '出库数量',
  `RECORD_OUT_TIME` datetime(0) NULL DEFAULT NULL COMMENT '出库时间',
  `USER_ID` int(11) NOT NULL COMMENT '出库负责人ID,关联用户表主键',
  `REPO_ID` int(11) NOT NULL COMMENT '仓库ID,关联仓库表主键',
  `REMARKS` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注',
  `CREATE_TIME` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `UPDATE_TIME` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '设置当前时间，并且自动更更新时间',
  `IS_DELETE` int(11) NULL DEFAULT 1 COMMENT '是否删除 0:删除 1:未删除',
  PRIMARY KEY (`RECORD_OUT_ID`) USING BTREE,
  INDEX `CUSTOMER_ID`(`CUSTOMER_ID`) USING BTREE,
  INDEX `PRODUCT_ID`(`PRODUCT_ID`) USING BTREE,
  INDEX `USER_ID`(`USER_ID`) USING BTREE,
  CONSTRAINT `record_out_ibfk_1` FOREIGN KEY (`CUSTOMER_ID`) REFERENCES `customer` (`CUSTOMER_ID`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `record_out_ibfk_2` FOREIGN KEY (`PRODUCT_ID`) REFERENCES `product` (`PRODUCT_ID`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `record_out_ibfk_3` FOREIGN KEY (`USER_ID`) REFERENCES `user` (`USER_ID`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '出库记录表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for record_stock
-- ----------------------------
DROP TABLE IF EXISTS `record_stock`;
CREATE TABLE `record_stock`  (
  `PRODUCT_ID` int(11) NOT NULL COMMENT '产品ID,关联产品表主键',
  `REPO_ID` int(11) NOT NULL COMMENT '仓库ID,关联仓库表主键',
  `PRODUCT_STOCK` int(11) NULL DEFAULT 0 COMMENT '库存数量',
  `CREATE_TIME` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `UPDATE_TIME` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '设置当前时间，并且自动更更新时间',
  `IS_DELETE` int(11) NULL DEFAULT 1 COMMENT '是否删除 0:删除 1:未删除',
  PRIMARY KEY (`PRODUCT_ID`, `REPO_ID`) USING BTREE,
  INDEX `REPO_ID`(`REPO_ID`) USING BTREE,
  CONSTRAINT `record_stock_ibfk_1` FOREIGN KEY (`PRODUCT_ID`) REFERENCES `product` (`PRODUCT_ID`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `record_stock_ibfk_2` FOREIGN KEY (`REPO_ID`) REFERENCES `repository` (`REPO_ID`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '库存记录表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for repository
-- ----------------------------
DROP TABLE IF EXISTS `repository`;
CREATE TABLE `repository`  (
  `REPO_ID` int(11) NOT NULL AUTO_INCREMENT COMMENT '仓库ID,主键自增',
  `REPO_ADDRESS` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '仓库地址',
  `REPO_AREA` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '仓库面积,单位:平方米',
  `REPO_DESC` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '仓库描述(备注)',
  `REPO_STATUS` tinyint(4) NULL DEFAULT 1 COMMENT '仓库状态 0:故障 1:正常 2:已满 3:废弃',
  `CREATE_TIME` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `UPDATE_TIME` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '设置当前时间，并且自动更更新时间',
  `IS_DELETE` int(11) NULL DEFAULT 1 COMMENT '是否删除 0:删除 1:未删除',
  PRIMARY KEY (`REPO_ID`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '仓库信息表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of repository
-- ----------------------------
INSERT INTO `repository` VALUES (1, '南京市建邺区', '100*100', '发动机仓库', 1, '2022-11-24 08:48:27', '2022-11-24 08:48:28', 1);
INSERT INTO `repository` VALUES (2, '南京市江宁区', '200*200', '汽车仓库', 2, '2022-11-24 08:48:55', '2022-11-24 08:48:55', 1);

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role`  (
  `ROLE_ID` int(11) NOT NULL AUTO_INCREMENT COMMENT '角色ID,主键自增',
  `ROLE_NAME` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '角色名称',
  `CREATE_TIME` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `UPDATE_TIME` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '设置当前时间，并且自动更更新时间',
  `IS_DELETE` int(11) NULL DEFAULT 1 COMMENT '是否删除 0:删除 1:未删除',
  PRIMARY KEY (`ROLE_ID`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '角色表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES (1, '平台管理员', '2022-11-03 05:07:38', '2022-11-02 21:07:39', 1);
INSERT INTO `role` VALUES (2, '仓库管理员', '2022-11-03 05:07:49', '2022-11-02 21:07:49', 1);

-- ----------------------------
-- Table structure for role_menus
-- ----------------------------
DROP TABLE IF EXISTS `role_menus`;
CREATE TABLE `role_menus`  (
  `ROLE_ID` int(11) NOT NULL COMMENT '角色ID,关联角色表主键',
  `MENU_ID` int(11) NOT NULL COMMENT '菜单ID,关联菜单表主键',
  `CREATE_TIME` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `UPDATE_TIME` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '设置当前时间，并且自动更更新时间',
  `IS_DELETE` int(11) NULL DEFAULT 1 COMMENT '是否删除 0:删除 1:未删除',
  PRIMARY KEY (`ROLE_ID`, `MENU_ID`) USING BTREE,
  INDEX `MENU_ID`(`MENU_ID`) USING BTREE,
  CONSTRAINT `role_menus_ibfk_1` FOREIGN KEY (`ROLE_ID`) REFERENCES `role` (`ROLE_ID`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `role_menus_ibfk_2` FOREIGN KEY (`MENU_ID`) REFERENCES `menus` (`MENU_ID`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '角色菜单关联表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for source
-- ----------------------------
DROP TABLE IF EXISTS `source`;
CREATE TABLE `source`  (
  `SOURCE_ID` int(11) NOT NULL AUTO_INCREMENT COMMENT '客户来源ID,主键自增',
  `SOURCE_NAME` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '客户来源名称',
  `CREATE_TIME` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `UPDATE_TIME` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '设置当前时间，并且自动更更新时间',
  `IS_DELETE` int(11) NULL DEFAULT 1 COMMENT '是否删除 0:删除 1:未删除',
  PRIMARY KEY (`SOURCE_ID`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '客户来源表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of source
-- ----------------------------
INSERT INTO `source` VALUES (1, '百度', '2022-11-14 14:15:13', '2022-11-14 14:15:17', 1);
INSERT INTO `source` VALUES (2, '转介绍', '2022-11-14 22:17:58', '2022-11-14 14:17:59', 1);

-- ----------------------------
-- Table structure for supplier
-- ----------------------------
DROP TABLE IF EXISTS `supplier`;
CREATE TABLE `supplier`  (
  `SUPPLIER_ID` int(11) NOT NULL AUTO_INCREMENT COMMENT '供应商ID,主键自增',
  `SUPPLIER_NAME` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '供应商信息,如果为个人(非公司),那么当前字段和SUPPLIER_LEADER信息相同,如果为公司,那么是公司名称',
  `SUPPLIER_LEADER` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '负责人,如果为个人(非公司),那么当前字段和SUPPLIER_NAME信息相同',
  `SUPPLIER_TEL` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '联系电话',
  `SUPPLIER_EMAIL` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '邮箱',
  `SUPPLIER_ADDRESS` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '地址',
  `CREATE_TIME` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `UPDATE_TIME` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '设置当前时间，并且自动更更新时间',
  `IS_DELETE` int(11) NULL DEFAULT 1 COMMENT '是否删除 0:删除 1:未删除',
  PRIMARY KEY (`SUPPLIER_ID`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '供应商信息表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of supplier
-- ----------------------------
INSERT INTO `supplier` VALUES (1, '南京天机星', '大萝卜', '12333333333', '123@123.com', '南京市溧水区', '2022-11-11 16:49:12', '2022-11-11 08:49:12', 1);
INSERT INTO `supplier` VALUES (2, '顺丰物流', 'sf名字', '1222222222', 'sf@163.com', '北京市昌平区', '2022-11-12 18:41:04', '2022-11-12 10:41:06', 1);
INSERT INTO `supplier` VALUES (3, 'SHUNFENGSUDI', 'SF', '1111111111', '1@1.com', '背景昌平区', '2022-11-12 18:44:24', '2022-11-12 10:44:25', 1);

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `USER_ID` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户ID,主键自增',
  `USER_NAME` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户名',
  `USER_TEL` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '联系电话',
  `USER_EMAIL` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '邮箱',
  `USER_NICK` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT 'WMS' COMMENT '用户昵称',
  `PASSWORD` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '密码',
  `SALT` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '盐值',
  `CREATE_TIME` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `UPDATE_TIME` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '设置当前时间，并且自动更更新时间',
  `IS_DELETE` int(11) NULL DEFAULT 1 COMMENT '是否删除 0:删除 1:未删除',
  `AVATAR` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '/img/avatar.jpeg' COMMENT '头像',
  PRIMARY KEY (`USER_ID`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '用户表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, '张三', '18288888888', 'j@j.com', '夜泊', 'a38b872c85e9096dd2d97b5dbe482861', '1', '2022-11-04 16:42:10', '2022-11-25 18:46:30', 1, '/pics/9151315b-add5-440f-84a1-9e3ba3c6862e.jpeg');
INSERT INTO `user` VALUES (2, '李四', '18333333332', 'd@2.com', '李四大罗弄', '222222', '1667522858146', '2022-11-04 16:47:37', '2022-11-21 13:01:57', 1, '/img/avatar.jpeg');

-- ----------------------------
-- Table structure for user_department
-- ----------------------------
DROP TABLE IF EXISTS `user_department`;
CREATE TABLE `user_department`  (
  `DEPT_ID` int(11) NOT NULL COMMENT '部门ID',
  `USER_ID` int(11) NOT NULL COMMENT '用户ID',
  `CREATE_TIME` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `UPDATE_TIME` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '设置当前时间，并且自动更更新时间',
  `IS_DELETE` int(11) NULL DEFAULT 1 COMMENT '是否删除 0:删除 1:未删除',
  PRIMARY KEY (`USER_ID`, `DEPT_ID`) USING BTREE,
  INDEX `DEPT_ID`(`DEPT_ID`) USING BTREE,
  CONSTRAINT `user_department_ibfk_1` FOREIGN KEY (`USER_ID`) REFERENCES `user` (`USER_ID`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `user_department_ibfk_2` FOREIGN KEY (`DEPT_ID`) REFERENCES `department` (`DEPT_ID`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '用户部门关联表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user_department
-- ----------------------------
INSERT INTO `user_department` VALUES (3, 1, '2022-11-04 16:42:10', '2022-11-04 08:42:15', 1);
INSERT INTO `user_department` VALUES (5, 1, '2022-11-04 16:42:10', '2022-11-04 08:42:15', 1);
INSERT INTO `user_department` VALUES (6, 1, '2022-11-04 16:42:10', '2022-11-04 08:42:15', 1);
INSERT INTO `user_department` VALUES (7, 1, '2022-11-04 16:42:10', '2022-11-04 08:42:15', 1);
INSERT INTO `user_department` VALUES (5, 2, '2022-11-04 16:47:37', '2022-11-04 08:47:38', 1);
INSERT INTO `user_department` VALUES (7, 2, '2022-11-04 16:47:37', '2022-11-04 08:47:38', 1);

-- ----------------------------
-- Table structure for user_repository
-- ----------------------------
DROP TABLE IF EXISTS `user_repository`;
CREATE TABLE `user_repository`  (
  `REPO_ID` int(11) NOT NULL COMMENT '仓库ID',
  `USER_ID` int(11) NOT NULL COMMENT '用户ID',
  `CREATE_TIME` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `UPDATE_TIME` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '设置当前时间，并且自动更更新时间',
  `IS_DELETE` int(11) NULL DEFAULT 1 COMMENT '是否删除 0:删除 1:未删除',
  PRIMARY KEY (`REPO_ID`, `USER_ID`) USING BTREE,
  INDEX `USER_ID`(`USER_ID`) USING BTREE,
  CONSTRAINT `user_repository_ibfk_1` FOREIGN KEY (`REPO_ID`) REFERENCES `repository` (`REPO_ID`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `user_repository_ibfk_2` FOREIGN KEY (`USER_ID`) REFERENCES `user` (`USER_ID`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '用户仓库关联表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for user_role
-- ----------------------------
DROP TABLE IF EXISTS `user_role`;
CREATE TABLE `user_role`  (
  `USER_ID` int(11) NOT NULL COMMENT '用户ID,关联用户表主键',
  `ROLE_ID` int(11) NOT NULL COMMENT '角色ID,关联角色表主键',
  `CREATE_TIME` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `UPDATE_TIME` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '设置当前时间，并且自动更更新时间',
  `IS_DELETE` int(11) NULL DEFAULT 1 COMMENT '是否删除 0:删除 1:未删除',
  PRIMARY KEY (`USER_ID`, `ROLE_ID`) USING BTREE,
  INDEX `ROLE_ID`(`ROLE_ID`) USING BTREE,
  CONSTRAINT `user_role_ibfk_1` FOREIGN KEY (`USER_ID`) REFERENCES `user` (`USER_ID`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `user_role_ibfk_2` FOREIGN KEY (`ROLE_ID`) REFERENCES `role` (`ROLE_ID`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '用户角色关联表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user_role
-- ----------------------------
INSERT INTO `user_role` VALUES (1, 1, '2022-11-04 16:42:10', '2022-11-04 08:42:15', 1);
INSERT INTO `user_role` VALUES (1, 2, '2022-11-04 16:42:10', '2022-11-04 08:42:15', 1);
INSERT INTO `user_role` VALUES (2, 1, '2022-11-04 16:47:37', '2022-11-04 08:47:38', 1);
INSERT INTO `user_role` VALUES (2, 2, '2022-11-04 16:47:37', '2022-11-04 08:47:38', 1);

SET FOREIGN_KEY_CHECKS = 1;
