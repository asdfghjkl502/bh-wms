/*
SQLyog Community v13.1.8 (64 bit)
MySQL - 8.0.30 : Database - bh_wms
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`bh_wms` /*!40100 DEFAULT CHARACTER SET utf8mb3 */ /*!80016 DEFAULT ENCRYPTION='N' */;

USE `bh_wms`;

/*Table structure for table `carrier` */

DROP TABLE IF EXISTS `carrier`;

CREATE TABLE `carrier` (
  `CARRIER_ID` int NOT NULL AUTO_INCREMENT COMMENT '承运商ID,主键自增',
  `CARRIER_NAME` varchar(100) NOT NULL COMMENT '承运商名称',
  `CARRIER_LEADER` varchar(100) NOT NULL COMMENT '承运商负责人',
  `CARRIER_TEL` varchar(100) NOT NULL COMMENT '联系电话',
  `CARRIER_EMAIL` varchar(100) DEFAULT NULL COMMENT '联系邮箱',
  `CARRIER_ADDRESS` varchar(255) DEFAULT NULL COMMENT '联系地址',
  `CREATE_TIME` datetime DEFAULT NULL COMMENT '创建时间',
  `UPDATE_TIME` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '设置当前时间，并且自动更更新时间',
  `IS_DELETE` int DEFAULT '1' COMMENT '是否删除 0:删除 1:未删除',
  PRIMARY KEY (`CARRIER_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb3 COMMENT='承运商表';

/*Data for the table `carrier` */

insert  into `carrier`(`CARRIER_ID`,`CARRIER_NAME`,`CARRIER_LEADER`,`CARRIER_TEL`,`CARRIER_EMAIL`,`CARRIER_ADDRESS`,`CREATE_TIME`,`UPDATE_TIME`,`IS_DELETE`) values 
(1,'顺丰快递','SF001','15555555555','sf@163.com','北京昌平','2023-01-05 17:18:06','2023-01-05 17:18:07',1),
(2,'韵达快递','YD001','15566666666','yd@163.com','北京朝阳','2023-01-05 17:19:13','2023-01-05 17:19:14',1);

/*Table structure for table `category` */

DROP TABLE IF EXISTS `category`;

CREATE TABLE `category` (
  `CATEGORY_ID` int NOT NULL AUTO_INCREMENT COMMENT '类目ID,主键自增',
  `CATEGORY_NAME` varchar(100) NOT NULL COMMENT '类目名称',
  `LEVEL` int DEFAULT '1' COMMENT '层级',
  `PARENT_ID` int DEFAULT '0' COMMENT '父ID,关联主键(自关联),顶层父ID为0',
  `CREATE_TIME` datetime DEFAULT NULL COMMENT '创建时间',
  `UPDATE_TIME` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '设置当前时间，并且自动更更新时间',
  `IS_DELETE` int DEFAULT '1' COMMENT '是否删除 0:删除 1:未删除',
  PRIMARY KEY (`CATEGORY_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb3 COMMENT='商品类目表';

/*Data for the table `category` */

insert  into `category`(`CATEGORY_ID`,`CATEGORY_NAME`,`LEVEL`,`PARENT_ID`,`CREATE_TIME`,`UPDATE_TIME`,`IS_DELETE`) values 
(1,'服装',1,0,'2023-01-05 00:00:00','2023-01-05 17:12:09',1),
(2,'家电',1,0,'2023-01-05 00:00:00','2023-01-05 17:12:17',1),
(3,'3C电子',1,0,'2023-01-05 00:00:00','2023-01-05 17:12:35',1),
(4,'上衣',2,1,'2023-01-05 00:00:00','2023-01-05 17:12:43',1),
(5,'下身',2,1,'2023-01-05 00:00:00','2023-01-05 17:12:55',1),
(6,'夹克',3,4,'2023-01-05 17:13:02','2023-01-05 17:13:03',1),
(7,'短裤',3,5,'2023-01-05 00:00:00','2023-01-05 17:13:13',1),
(8,'大家电',2,2,'2023-01-05 17:13:21','2023-01-05 17:13:22',1),
(9,'小家电',2,2,'2023-01-05 17:13:30','2023-01-05 17:13:30',1),
(10,'电冰箱',3,8,'2023-01-05 17:13:47','2023-01-05 17:14:02',1),
(11,'恒温壶',3,9,'2023-01-05 17:14:16','2023-01-05 17:14:16',1),
(12,'灯具',2,3,'2023-01-05 17:14:32','2023-01-05 17:14:32',1),
(13,'白炽灯',3,12,'2023-01-05 17:14:41','2023-01-05 17:14:42',1),
(14,'节能灯',3,12,'2023-01-05 17:14:49','2023-01-05 17:14:50',1);

/*Table structure for table `customer` */

DROP TABLE IF EXISTS `customer`;

CREATE TABLE `customer` (
  `CUSTOMER_ID` int NOT NULL AUTO_INCREMENT COMMENT '客户ID,主键自增',
  `CUSTOMER_NAME` varchar(100) NOT NULL COMMENT '客户名称,如果为公司,那么是公司名,如果为个人,那么填写个人名称',
  `CUSTOMER_LEADER` varchar(100) NOT NULL COMMENT '客户负责人,如果公司为个人,那么和CUSTOMER_NAME内容相同',
  `CUSTOMER_TEL` varchar(100) NOT NULL COMMENT '联系电话',
  `CUSTOMER_EMAIL` varchar(100) DEFAULT NULL COMMENT '联系邮箱',
  `CUSTOMER_ADDRESS` varchar(255) DEFAULT NULL COMMENT '联系地址',
  `LEVEL_ID` int NOT NULL COMMENT '客户级别,关联级别表主键',
  `SOURCE_ID` int NOT NULL COMMENT '客户来源,关联来源表主键',
  `INDUSTRY_ID` int NOT NULL COMMENT '客户行业,关联行业表主键',
  `CREATE_TIME` datetime DEFAULT NULL COMMENT '创建时间',
  `UPDATE_TIME` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '设置当前时间，并且自动更更新时间',
  `IS_DELETE` int DEFAULT '1' COMMENT '是否删除 0:删除 1:未删除',
  PRIMARY KEY (`CUSTOMER_ID`),
  KEY `LEVEL_ID` (`LEVEL_ID`),
  KEY `SOURCE_ID` (`SOURCE_ID`),
  KEY `INDUSTRY_ID` (`INDUSTRY_ID`),
  CONSTRAINT `customer_ibfk_1` FOREIGN KEY (`LEVEL_ID`) REFERENCES `level` (`LEVEL_ID`),
  CONSTRAINT `customer_ibfk_2` FOREIGN KEY (`SOURCE_ID`) REFERENCES `source` (`SOURCE_ID`),
  CONSTRAINT `customer_ibfk_3` FOREIGN KEY (`INDUSTRY_ID`) REFERENCES `industry` (`INDUSTRY_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb3 COMMENT='客户表';

/*Data for the table `customer` */

insert  into `customer`(`CUSTOMER_ID`,`CUSTOMER_NAME`,`CUSTOMER_LEADER`,`CUSTOMER_TEL`,`CUSTOMER_EMAIL`,`CUSTOMER_ADDRESS`,`LEVEL_ID`,`SOURCE_ID`,`INDUSTRY_ID`,`CREATE_TIME`,`UPDATE_TIME`,`IS_DELETE`) values 
(1,'客户001','KH001','19999999999','kh@163.com','南京建邺区',1,1,1,'2023-01-05 17:32:28','2023-01-05 17:32:29',1);

/*Table structure for table `department` */

DROP TABLE IF EXISTS `department`;

CREATE TABLE `department` (
  `DEPT_ID` int NOT NULL AUTO_INCREMENT COMMENT '部门ID',
  `DEPT_NAME` varchar(100) DEFAULT NULL COMMENT '部门名称',
  `LEVEL` int DEFAULT '1' COMMENT '层级',
  `PARENT_ID` int DEFAULT '0' COMMENT '父ID,自关联DEPT_ID',
  `CREATE_TIME` datetime DEFAULT NULL COMMENT '创建时间',
  `UPDATE_TIME` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '设置当前时间，并且自动更更新时间',
  `IS_DELETE` int DEFAULT '1' COMMENT '是否删除 0:删除 1:未删除',
  PRIMARY KEY (`DEPT_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb3 COMMENT='部门表';

/*Data for the table `department` */

insert  into `department`(`DEPT_ID`,`DEPT_NAME`,`LEVEL`,`PARENT_ID`,`CREATE_TIME`,`UPDATE_TIME`,`IS_DELETE`) values 
(1,'大浪科技有限公司',1,0,'2023-01-05 17:07:10','2023-01-05 17:07:11',1),
(2,'大浪科技北京分公司',2,1,'2023-01-05 17:07:26','2023-01-05 17:07:27',1),
(3,'浪淘沙科技有限公司',1,0,'2023-01-04 00:00:00','2023-01-05 17:07:46',1),
(4,'浪淘沙北京分公司',2,3,'2023-01-04 00:00:00','2023-01-05 17:08:07',1),
(5,'大浪科技南京分公司',2,1,'2023-01-05 00:00:00','2023-01-05 17:08:23',1),
(6,'浪淘沙南京分公司',2,3,'2023-01-05 00:00:00','2023-01-05 17:08:41',1),
(7,'人事部',3,2,'2023-01-05 00:00:00','2023-01-05 17:08:49',1),
(8,'行政部',3,5,'2023-01-05 00:00:00','2023-01-05 17:08:58',1),
(9,'财务部',3,4,'2023-01-05 00:00:00','2023-01-05 17:09:07',1),
(10,'公关部',3,6,'2023-01-05 17:09:15','2023-01-05 17:09:16',1);

/*Table structure for table `industry` */

DROP TABLE IF EXISTS `industry`;

CREATE TABLE `industry` (
  `INDUSTRY_ID` int NOT NULL AUTO_INCREMENT COMMENT '行业ID,主键自增',
  `INDUSTRY_NAME` varchar(100) NOT NULL COMMENT '行业名称',
  `CREATE_TIME` datetime DEFAULT NULL COMMENT '创建时间',
  `UPDATE_TIME` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '设置当前时间，并且自动更更新时间',
  `IS_DELETE` int DEFAULT '1' COMMENT '是否删除 0:删除 1:未删除',
  PRIMARY KEY (`INDUSTRY_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb3 COMMENT='客户行业表';

/*Data for the table `industry` */

insert  into `industry`(`INDUSTRY_ID`,`INDUSTRY_NAME`,`CREATE_TIME`,`UPDATE_TIME`,`IS_DELETE`) values 
(1,'金融','2023-01-05 17:16:35','2023-01-05 17:16:35',1),
(2,'化工','2023-01-05 17:16:40','2023-01-05 17:16:41',1),
(3,'教育','2023-01-05 17:16:50','2023-01-05 17:16:51',1);

/*Table structure for table `level` */

DROP TABLE IF EXISTS `level`;

CREATE TABLE `level` (
  `LEVEL_ID` int NOT NULL AUTO_INCREMENT COMMENT '客户级别ID,主键自增',
  `LEVEL_NAME` varchar(100) NOT NULL COMMENT '客户级别名称',
  `CREATE_TIME` datetime DEFAULT NULL COMMENT '创建时间',
  `UPDATE_TIME` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '设置当前时间，并且自动更更新时间',
  `IS_DELETE` int DEFAULT '1' COMMENT '是否删除 0:删除 1:未删除',
  PRIMARY KEY (`LEVEL_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb3 COMMENT='客户级别表';

/*Data for the table `level` */

insert  into `level`(`LEVEL_ID`,`LEVEL_NAME`,`CREATE_TIME`,`UPDATE_TIME`,`IS_DELETE`) values 
(1,'青铜','2023-01-05 17:15:34','2023-01-05 17:15:34',1),
(2,'白银','2023-01-05 17:15:41','2023-01-05 17:15:41',1),
(3,'黄金','2023-01-05 17:15:47','2023-01-05 17:15:48',1),
(4,'钻石','2023-01-05 17:15:55','2023-01-05 17:15:55',1);

/*Table structure for table `menus` */

DROP TABLE IF EXISTS `menus`;

CREATE TABLE `menus` (
  `MENU_ID` int NOT NULL AUTO_INCREMENT COMMENT '菜单ID,主键自增',
  `MENU_NAME` varchar(100) NOT NULL COMMENT '菜单名称',
  `MENU_URL` varchar(255) DEFAULT NULL COMMENT '菜单地址',
  `LEVEL` int DEFAULT '1' COMMENT '层级',
  `PARENT_ID` int DEFAULT NULL COMMENT '父ID,关联menus表主键,默认值为0,表示菜单第一级',
  `CREATE_TIME` datetime DEFAULT NULL COMMENT '创建时间',
  `UPDATE_TIME` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '设置当前时间，并且自动更更新时间',
  `IS_DELETE` int DEFAULT '1' COMMENT '菜单状态 0:删除 1:未删除',
  PRIMARY KEY (`MENU_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COMMENT='菜单表';

/*Data for the table `menus` */

/*Table structure for table `product` */

DROP TABLE IF EXISTS `product`;

CREATE TABLE `product` (
  `PRODUCT_ID` int NOT NULL AUTO_INCREMENT COMMENT '产品ID,主键自增',
  `PRODUCT_NAME` varchar(100) NOT NULL COMMENT '产品名称',
  `CATEGORY_ID` int NOT NULL COMMENT '产品类目ID,关联类目表主键',
  `PRODUCT_SIZE` varchar(100) DEFAULT NULL COMMENT '产品尺寸(长乘宽),单位 毫米(mm)',
  `PRODUCT_PRICE` double(16,3) DEFAULT NULL COMMENT '产品价格',
  `CREATE_TIME` datetime DEFAULT NULL COMMENT '创建时间',
  `UPDATE_TIME` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '设置当前时间，并且自动更更新时间',
  `IS_DELETE` int DEFAULT '1' COMMENT '是否删除 0:删除 1:未删除',
  PRIMARY KEY (`PRODUCT_ID`),
  KEY `CATEGORY_ID` (`CATEGORY_ID`),
  CONSTRAINT `product_ibfk_1` FOREIGN KEY (`CATEGORY_ID`) REFERENCES `category` (`CATEGORY_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb3 COMMENT='产品信息表';

/*Data for the table `product` */

insert  into `product`(`PRODUCT_ID`,`PRODUCT_NAME`,`CATEGORY_ID`,`PRODUCT_SIZE`,`PRODUCT_PRICE`,`CREATE_TIME`,`UPDATE_TIME`,`IS_DELETE`) values 
(1,'恒温壶0',11,'200*300',10000.000,'2023-01-05 17:33:01','2023-01-05 17:35:25',1);

/*Table structure for table `record_in` */

DROP TABLE IF EXISTS `record_in`;

CREATE TABLE `record_in` (
  `RECORD_IN_ID` int NOT NULL AUTO_INCREMENT COMMENT '入库ID,主键自增',
  `SUPPLIER_ID` int NOT NULL COMMENT '供应商ID,关联供应商表主键',
  `PRODUCT_ID` int NOT NULL COMMENT '产品ID,关联产品表主键',
  `RECORD_IN_NUMBER` int DEFAULT '0' COMMENT '入库数量',
  `RECORD_IN_TIME` datetime DEFAULT NULL COMMENT '入库时间',
  `USER_ID` int NOT NULL COMMENT '入库负责人ID,关联用户表主键',
  `REPO_ID` int NOT NULL COMMENT '仓库ID,关联仓库表主键',
  `REMARKS` varchar(255) DEFAULT NULL COMMENT '备注',
  `CREATE_TIME` datetime DEFAULT NULL COMMENT '创建时间',
  `UPDATE_TIME` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '设置当前时间，并且自动更更新时间',
  `IS_DELETE` int DEFAULT '1' COMMENT '是否删除 0:删除 1:未删除',
  PRIMARY KEY (`RECORD_IN_ID`),
  KEY `SUPPLIER_ID` (`SUPPLIER_ID`),
  KEY `PRODUCT_ID` (`PRODUCT_ID`),
  KEY `USER_ID` (`USER_ID`),
  CONSTRAINT `record_in_ibfk_1` FOREIGN KEY (`SUPPLIER_ID`) REFERENCES `supplier` (`SUPPLIER_ID`),
  CONSTRAINT `record_in_ibfk_2` FOREIGN KEY (`PRODUCT_ID`) REFERENCES `product` (`PRODUCT_ID`),
  CONSTRAINT `record_in_ibfk_3` FOREIGN KEY (`USER_ID`) REFERENCES `user` (`USER_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb3 COMMENT='入库记录表';

/*Data for the table `record_in` */

insert  into `record_in`(`RECORD_IN_ID`,`SUPPLIER_ID`,`PRODUCT_ID`,`RECORD_IN_NUMBER`,`RECORD_IN_TIME`,`USER_ID`,`REPO_ID`,`REMARKS`,`CREATE_TIME`,`UPDATE_TIME`,`IS_DELETE`) values 
(1,1,1,100,'2023-01-05 17:36:01',1,1,NULL,'2023-01-05 17:36:01','2023-01-05 17:36:01',1);

/*Table structure for table `record_out` */

DROP TABLE IF EXISTS `record_out`;

CREATE TABLE `record_out` (
  `RECORD_OUT_ID` int NOT NULL AUTO_INCREMENT COMMENT '出库ID,主键自增',
  `CUSTOMER_ID` int NOT NULL COMMENT '客户ID,关联客户表主键',
  `PRODUCT_ID` int NOT NULL COMMENT '产品ID,关联产品表主键',
  `RECORD_OUT_NUMBER` int DEFAULT '0' COMMENT '出库数量',
  `RECORD_OUT_TIME` datetime DEFAULT NULL COMMENT '出库时间',
  `USER_ID` int NOT NULL COMMENT '出库负责人ID,关联用户表主键',
  `REPO_ID` int NOT NULL COMMENT '仓库ID,关联仓库表主键',
  `REMARKS` varchar(255) DEFAULT NULL COMMENT '备注',
  `CREATE_TIME` datetime DEFAULT NULL COMMENT '创建时间',
  `UPDATE_TIME` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '设置当前时间，并且自动更更新时间',
  `IS_DELETE` int DEFAULT '1' COMMENT '是否删除 0:删除 1:未删除',
  PRIMARY KEY (`RECORD_OUT_ID`),
  KEY `CUSTOMER_ID` (`CUSTOMER_ID`),
  KEY `PRODUCT_ID` (`PRODUCT_ID`),
  KEY `USER_ID` (`USER_ID`),
  CONSTRAINT `record_out_ibfk_1` FOREIGN KEY (`CUSTOMER_ID`) REFERENCES `customer` (`CUSTOMER_ID`),
  CONSTRAINT `record_out_ibfk_2` FOREIGN KEY (`PRODUCT_ID`) REFERENCES `product` (`PRODUCT_ID`),
  CONSTRAINT `record_out_ibfk_3` FOREIGN KEY (`USER_ID`) REFERENCES `user` (`USER_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb3 COMMENT='出库记录表';

/*Data for the table `record_out` */

insert  into `record_out`(`RECORD_OUT_ID`,`CUSTOMER_ID`,`PRODUCT_ID`,`RECORD_OUT_NUMBER`,`RECORD_OUT_TIME`,`USER_ID`,`REPO_ID`,`REMARKS`,`CREATE_TIME`,`UPDATE_TIME`,`IS_DELETE`) values 
(1,1,1,90,'2023-01-05 17:36:25',1,1,NULL,'2023-01-05 17:36:25','2023-01-05 17:36:24',1);

/*Table structure for table `record_stock` */

DROP TABLE IF EXISTS `record_stock`;

CREATE TABLE `record_stock` (
  `PRODUCT_ID` int NOT NULL COMMENT '产品ID,关联产品表主键',
  `REPO_ID` int NOT NULL COMMENT '仓库ID,关联仓库表主键',
  `PRODUCT_STOCK` int DEFAULT '0' COMMENT '库存数量',
  `CREATE_TIME` datetime DEFAULT NULL COMMENT '创建时间',
  `UPDATE_TIME` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '设置当前时间，并且自动更更新时间',
  `IS_DELETE` int DEFAULT '1' COMMENT '是否删除 0:删除 1:未删除',
  PRIMARY KEY (`PRODUCT_ID`,`REPO_ID`),
  KEY `REPO_ID` (`REPO_ID`),
  CONSTRAINT `record_stock_ibfk_1` FOREIGN KEY (`PRODUCT_ID`) REFERENCES `product` (`PRODUCT_ID`),
  CONSTRAINT `record_stock_ibfk_2` FOREIGN KEY (`REPO_ID`) REFERENCES `repository` (`REPO_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COMMENT='库存记录表';

/*Data for the table `record_stock` */

insert  into `record_stock`(`PRODUCT_ID`,`REPO_ID`,`PRODUCT_STOCK`,`CREATE_TIME`,`UPDATE_TIME`,`IS_DELETE`) values 
(1,1,10,'2023-01-05 17:36:01','2023-01-05 17:36:24',1);

/*Table structure for table `repository` */

DROP TABLE IF EXISTS `repository`;

CREATE TABLE `repository` (
  `REPO_ID` int NOT NULL AUTO_INCREMENT COMMENT '仓库ID,主键自增',
  `REPO_NAME` varchar(100) DEFAULT NULL COMMENT '仓库名称',
  `REPO_ADDRESS` varchar(100) NOT NULL COMMENT '仓库地址',
  `REPO_AREA` varchar(50) DEFAULT NULL COMMENT '仓库面积,单位:平方米',
  `REPO_DESC` varchar(255) DEFAULT NULL COMMENT '仓库描述(备注)',
  `REPO_STATUS` tinyint DEFAULT '1' COMMENT '仓库状态 0:故障 1:正常 2:已满 3:废弃',
  `CREATE_TIME` datetime DEFAULT NULL COMMENT '创建时间',
  `UPDATE_TIME` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '设置当前时间，并且自动更更新时间',
  `IS_DELETE` int DEFAULT '1' COMMENT '是否删除 0:删除 1:未删除',
  PRIMARY KEY (`REPO_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb3 COMMENT='仓库信息表';

/*Data for the table `repository` */

insert  into `repository`(`REPO_ID`,`REPO_NAME`,`REPO_ADDRESS`,`REPO_AREA`,`REPO_DESC`,`REPO_STATUS`,`CREATE_TIME`,`UPDATE_TIME`,`IS_DELETE`) values 
(1,'大白仓库0','南京市建邺区','2000000','恒温仓库',1,'2023-01-05 17:33:46','2023-01-05 17:35:43',1),
(2,'大黑仓库0','南京市江宁区','300000','冷冻仓库',1,'2023-01-05 17:34:14','2023-01-05 17:35:47',1);

/*Table structure for table `role` */

DROP TABLE IF EXISTS `role`;

CREATE TABLE `role` (
  `ROLE_ID` int NOT NULL AUTO_INCREMENT COMMENT '角色ID,主键自增',
  `ROLE_NAME` varchar(100) NOT NULL COMMENT '角色名称',
  `CREATE_TIME` datetime DEFAULT NULL COMMENT '创建时间',
  `UPDATE_TIME` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '设置当前时间，并且自动更更新时间',
  `IS_DELETE` int DEFAULT '1' COMMENT '是否删除 0:删除 1:未删除',
  PRIMARY KEY (`ROLE_ID`),
  UNIQUE KEY `ROLE_NAME` (`ROLE_NAME`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb3 COMMENT='角色表';

/*Data for the table `role` */

insert  into `role`(`ROLE_ID`,`ROLE_NAME`,`CREATE_TIME`,`UPDATE_TIME`,`IS_DELETE`) values 
(1,'平台管理员','2023-01-05 17:06:31','2023-01-05 17:06:32',1),
(2,'仓库管理员','2023-01-05 17:06:41','2023-01-05 17:06:42',1);

/*Table structure for table `role_menus` */

DROP TABLE IF EXISTS `role_menus`;

CREATE TABLE `role_menus` (
  `ROLE_ID` int NOT NULL COMMENT '角色ID,关联角色表主键',
  `MENU_ID` int NOT NULL COMMENT '菜单ID,关联菜单表主键',
  `CREATE_TIME` datetime DEFAULT NULL COMMENT '创建时间',
  `UPDATE_TIME` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '设置当前时间，并且自动更更新时间',
  `IS_DELETE` int DEFAULT '1' COMMENT '是否删除 0:删除 1:未删除',
  PRIMARY KEY (`ROLE_ID`,`MENU_ID`),
  KEY `MENU_ID` (`MENU_ID`),
  CONSTRAINT `role_menus_ibfk_1` FOREIGN KEY (`ROLE_ID`) REFERENCES `role` (`ROLE_ID`),
  CONSTRAINT `role_menus_ibfk_2` FOREIGN KEY (`MENU_ID`) REFERENCES `menus` (`MENU_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COMMENT='角色菜单关联表';

/*Data for the table `role_menus` */

/*Table structure for table `source` */

DROP TABLE IF EXISTS `source`;

CREATE TABLE `source` (
  `SOURCE_ID` int NOT NULL AUTO_INCREMENT COMMENT '客户来源ID,主键自增',
  `SOURCE_NAME` varchar(100) NOT NULL COMMENT '客户来源名称',
  `CREATE_TIME` datetime DEFAULT NULL COMMENT '创建时间',
  `UPDATE_TIME` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '设置当前时间，并且自动更更新时间',
  `IS_DELETE` int DEFAULT '1' COMMENT '是否删除 0:删除 1:未删除',
  PRIMARY KEY (`SOURCE_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb3 COMMENT='客户来源表';

/*Data for the table `source` */

insert  into `source`(`SOURCE_ID`,`SOURCE_NAME`,`CREATE_TIME`,`UPDATE_TIME`,`IS_DELETE`) values 
(1,'百度','2023-01-05 17:16:03','2023-01-05 17:16:03',1),
(2,'口碑','2023-01-05 17:16:14','2023-01-05 17:16:14',1),
(3,'转介绍','2023-01-05 17:16:22','2023-01-05 17:16:23',1);

/*Table structure for table `supplier` */

DROP TABLE IF EXISTS `supplier`;

CREATE TABLE `supplier` (
  `SUPPLIER_ID` int NOT NULL AUTO_INCREMENT COMMENT '供应商ID,主键自增',
  `SUPPLIER_NAME` varchar(100) NOT NULL COMMENT '供应商信息,如果为个人(非公司),那么当前字段和SUPPLIER_LEADER信息相同,如果为公司,那么是公司名称',
  `SUPPLIER_LEADER` varchar(100) NOT NULL COMMENT '负责人,如果为个人(非公司),那么当前字段和SUPPLIER_NAME信息相同',
  `SUPPLIER_TEL` varchar(100) NOT NULL COMMENT '联系电话',
  `SUPPLIER_EMAIL` varchar(100) NOT NULL COMMENT '邮箱',
  `SUPPLIER_ADDRESS` varchar(100) NOT NULL COMMENT '地址',
  `CREATE_TIME` datetime DEFAULT NULL COMMENT '创建时间',
  `UPDATE_TIME` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '设置当前时间，并且自动更更新时间',
  `IS_DELETE` int DEFAULT '1' COMMENT '是否删除 0:删除 1:未删除',
  PRIMARY KEY (`SUPPLIER_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb3 COMMENT='供应商信息表';

/*Data for the table `supplier` */

insert  into `supplier`(`SUPPLIER_ID`,`SUPPLIER_NAME`,`SUPPLIER_LEADER`,`SUPPLIER_TEL`,`SUPPLIER_EMAIL`,`SUPPLIER_ADDRESS`,`CREATE_TIME`,`UPDATE_TIME`,`IS_DELETE`) values 
(1,'小熊科技有效公司0','XX001','17777777777','xx@163.com','广东佛山','2023-01-05 17:21:30','2023-01-05 17:35:07',1),
(2,'大白鲨科技有效公司0','DBS','18999999999','dbs@163.com','广东深圳','2023-01-05 17:23:00','2023-01-05 17:35:10',1);

/*Table structure for table `sys_log` */

DROP TABLE IF EXISTS `sys_log`;

CREATE TABLE `sys_log` (
  `log_id` bigint NOT NULL AUTO_INCREMENT COMMENT '日志ID',
  `type` int DEFAULT '1' COMMENT '日志类型 1:登陆日志; 0:其他日志',
  `ip_addr` varchar(255) NOT NULL COMMENT '请求地址',
  `method_name` varchar(100) NOT NULL COMMENT '请求方法名称',
  `method` varchar(100) NOT NULL COMMENT '请求方式',
  `nick_name` varchar(100) NOT NULL COMMENT '昵称',
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`log_id`)
) ENGINE=InnoDB AUTO_INCREMENT=413 DEFAULT CHARSET=utf8mb3 COMMENT='日志记录表';

/*Data for the table `sys_log` */

insert  into `sys_log`(`log_id`,`type`,`ip_addr`,`method_name`,`method`,`nick_name`,`create_time`) values 
(1,0,'0:0:0:0:0:0:0:1','toLogin','GET','匿名','2023-01-05 16:58:11'),
(2,0,'0:0:0:0:0:0:0:1','getVerifyCode','GET','匿名','2023-01-05 16:58:11'),
(3,1,'0:0:0:0:0:0:0:1','login','POST','匿名','2023-01-05 16:58:20'),
(4,0,'0:0:0:0:0:0:0:1','toLogin','GET','匿名','2023-01-05 17:04:06'),
(5,0,'0:0:0:0:0:0:0:1','getVerifyCode','GET','匿名','2023-01-05 17:04:06'),
(6,1,'0:0:0:0:0:0:0:1','login','POST','匿名','2023-01-05 17:04:10'),
(7,0,'0:0:0:0:0:0:0:1','home','GET','WMS','2023-01-05 17:04:10'),
(8,0,'0:0:0:0:0:0:0:1','getUserDetail','GET','WMS','2023-01-05 17:04:10'),
(9,0,'0:0:0:0:0:0:0:1','getUserDetail','GET','WMS','2023-01-05 17:04:15'),
(10,0,'0:0:0:0:0:0:0:1','home','GET','WMS','2023-01-05 17:04:24'),
(11,0,'0:0:0:0:0:0:0:1','getUserDetail','GET','WMS','2023-01-05 17:04:24'),
(12,0,'0:0:0:0:0:0:0:1','home','GET','WMS','2023-01-05 17:05:58'),
(13,0,'0:0:0:0:0:0:0:1','getUserDetail','GET','WMS','2023-01-05 17:05:58'),
(14,0,'0:0:0:0:0:0:0:1','getUserDetail','GET','WMS','2023-01-05 17:06:00'),
(15,0,'0:0:0:0:0:0:0:1','uploadFile','POST','WMS','2023-01-05 17:06:06'),
(16,0,'0:0:0:0:0:0:0:1','updateUser','POST','WMS','2023-01-05 17:06:07'),
(17,0,'0:0:0:0:0:0:0:1','home','GET','WMS','2023-01-05 17:06:07'),
(18,0,'0:0:0:0:0:0:0:1','getUserDetail','GET','WMS','2023-01-05 17:06:07'),
(19,0,'0:0:0:0:0:0:0:1','getUserPage','GET','WMS','2023-01-05 17:06:16'),
(20,0,'0:0:0:0:0:0:0:1','getRolePage','GET','WMS','2023-01-05 17:06:20'),
(21,0,'0:0:0:0:0:0:0:1','addRole','POST','WMS','2023-01-05 17:06:33'),
(22,0,'0:0:0:0:0:0:0:1','getRolePage','GET','WMS','2023-01-05 17:06:33'),
(23,0,'0:0:0:0:0:0:0:1','addRole','POST','WMS','2023-01-05 17:06:42'),
(24,0,'0:0:0:0:0:0:0:1','getRolePage','GET','WMS','2023-01-05 17:06:42'),
(25,0,'0:0:0:0:0:0:0:1','getDepartmentList','GET','WMS','2023-01-05 17:06:46'),
(26,0,'0:0:0:0:0:0:0:1','addDepartment','POST','WMS','2023-01-05 17:07:11'),
(27,0,'0:0:0:0:0:0:0:1','getDepartmentList','GET','WMS','2023-01-05 17:07:11'),
(28,0,'0:0:0:0:0:0:0:1','addDepartment','POST','WMS','2023-01-05 17:07:27'),
(29,0,'0:0:0:0:0:0:0:1','getDepartmentList','GET','WMS','2023-01-05 17:07:28'),
(30,0,'0:0:0:0:0:0:0:1','addDepartment','POST','WMS','2023-01-05 17:07:47'),
(31,0,'0:0:0:0:0:0:0:1','getDepartmentList','GET','WMS','2023-01-05 17:07:47'),
(32,0,'0:0:0:0:0:0:0:1','addDepartment','POST','WMS','2023-01-05 17:08:08'),
(33,0,'0:0:0:0:0:0:0:1','getDepartmentList','GET','WMS','2023-01-05 17:08:08'),
(34,0,'0:0:0:0:0:0:0:1','addDepartment','POST','WMS','2023-01-05 17:08:24'),
(35,0,'0:0:0:0:0:0:0:1','getDepartmentList','GET','WMS','2023-01-05 17:08:24'),
(36,0,'0:0:0:0:0:0:0:1','addDepartment','POST','WMS','2023-01-05 17:08:41'),
(37,0,'0:0:0:0:0:0:0:1','getDepartmentList','GET','WMS','2023-01-05 17:08:41'),
(38,0,'0:0:0:0:0:0:0:1','addDepartment','POST','WMS','2023-01-05 17:08:50'),
(39,0,'0:0:0:0:0:0:0:1','getDepartmentList','GET','WMS','2023-01-05 17:08:50'),
(40,0,'0:0:0:0:0:0:0:1','addDepartment','POST','WMS','2023-01-05 17:08:59'),
(41,0,'0:0:0:0:0:0:0:1','getDepartmentList','GET','WMS','2023-01-05 17:08:59'),
(42,0,'0:0:0:0:0:0:0:1','addDepartment','POST','WMS','2023-01-05 17:09:07'),
(43,0,'0:0:0:0:0:0:0:1','getDepartmentList','GET','WMS','2023-01-05 17:09:08'),
(44,0,'0:0:0:0:0:0:0:1','addDepartment','POST','WMS','2023-01-05 17:09:16'),
(45,0,'0:0:0:0:0:0:0:1','getDepartmentList','GET','WMS','2023-01-05 17:09:16'),
(46,0,'0:0:0:0:0:0:0:1','getMenuList','GET','WMS','2023-01-05 17:09:30'),
(47,0,'0:0:0:0:0:0:0:1','getDepartmentList$','GET','WMS','2023-01-05 17:09:49'),
(48,0,'0:0:0:0:0:0:0:1','getRoleList','GET','WMS','2023-01-05 17:09:49'),
(49,0,'0:0:0:0:0:0:0:1','getUserPage','GET','WMS','2023-01-05 17:09:55'),
(50,0,'0:0:0:0:0:0:0:1','getDepartmentList$','GET','WMS','2023-01-05 17:09:56'),
(51,0,'0:0:0:0:0:0:0:1','getRoleList','GET','WMS','2023-01-05 17:09:56'),
(52,0,'0:0:0:0:0:0:0:1','addUser','POST','WMS','2023-01-05 17:10:42'),
(53,0,'0:0:0:0:0:0:0:1','getUserPage','GET','WMS','2023-01-05 17:10:43'),
(54,0,'0:0:0:0:0:0:0:1','getUserDetail','GET','WMS','2023-01-05 17:10:46'),
(55,0,'0:0:0:0:0:0:0:1','getUserPage','GET','WMS','2023-01-05 17:11:22'),
(56,0,'0:0:0:0:0:0:0:1','logout','GET','WMS','2023-01-05 17:11:25'),
(57,0,'0:0:0:0:0:0:0:1','toLogin','GET','匿名','2023-01-05 17:11:25'),
(58,0,'0:0:0:0:0:0:0:1','getVerifyCode','GET','匿名','2023-01-05 17:11:25'),
(59,1,'0:0:0:0:0:0:0:1','login','POST','匿名','2023-01-05 17:11:29'),
(60,0,'0:0:0:0:0:0:0:1','home','GET','WMS','2023-01-05 17:11:29'),
(61,0,'0:0:0:0:0:0:0:1','getUserDetail','GET','WMS','2023-01-05 17:11:29'),
(62,0,'0:0:0:0:0:0:0:1','getUserDetail','GET','WMS','2023-01-05 17:11:31'),
(63,0,'0:0:0:0:0:0:0:1','uploadFile','POST','WMS','2023-01-05 17:11:35'),
(64,0,'0:0:0:0:0:0:0:1','updateUser','POST','WMS','2023-01-05 17:11:37'),
(65,0,'0:0:0:0:0:0:0:1','home','GET','WMS','2023-01-05 17:11:37'),
(66,0,'0:0:0:0:0:0:0:1','getUserDetail','GET','WMS','2023-01-05 17:11:37'),
(67,0,'0:0:0:0:0:0:0:1','getMenuList','GET','WMS','2023-01-05 17:11:41'),
(68,0,'0:0:0:0:0:0:0:1','getProductPage','GET','WMS','2023-01-05 17:11:44'),
(69,0,'0:0:0:0:0:0:0:1','getCustomerPage','GET','WMS','2023-01-05 17:11:46'),
(70,0,'0:0:0:0:0:0:0:1','getSupplierPage','GET','WMS','2023-01-05 17:11:46'),
(71,0,'0:0:0:0:0:0:0:1','getCarrierPage','GET','WMS','2023-01-05 17:11:47'),
(72,0,'0:0:0:0:0:0:0:1','getCategoryList','GET','WMS','2023-01-05 17:12:01'),
(73,0,'0:0:0:0:0:0:0:1','addCategory','POST','WMS','2023-01-05 17:12:09'),
(74,0,'0:0:0:0:0:0:0:1','getCategoryList','GET','WMS','2023-01-05 17:12:10'),
(75,0,'0:0:0:0:0:0:0:1','addCategory','POST','WMS','2023-01-05 17:12:17'),
(76,0,'0:0:0:0:0:0:0:1','getCategoryList','GET','WMS','2023-01-05 17:12:17'),
(77,0,'0:0:0:0:0:0:0:1','addCategory','POST','WMS','2023-01-05 17:12:35'),
(78,0,'0:0:0:0:0:0:0:1','getCategoryList','GET','WMS','2023-01-05 17:12:36'),
(79,0,'0:0:0:0:0:0:0:1','addCategory','POST','WMS','2023-01-05 17:12:43'),
(80,0,'0:0:0:0:0:0:0:1','getCategoryList','GET','WMS','2023-01-05 17:12:44'),
(81,0,'0:0:0:0:0:0:0:1','addCategory','POST','WMS','2023-01-05 17:12:56'),
(82,0,'0:0:0:0:0:0:0:1','getCategoryList','GET','WMS','2023-01-05 17:12:56'),
(83,0,'0:0:0:0:0:0:0:1','addCategory','POST','WMS','2023-01-05 17:13:03'),
(84,0,'0:0:0:0:0:0:0:1','getCategoryList','GET','WMS','2023-01-05 17:13:03'),
(85,0,'0:0:0:0:0:0:0:1','addCategory','POST','WMS','2023-01-05 17:13:14'),
(86,0,'0:0:0:0:0:0:0:1','getCategoryList','GET','WMS','2023-01-05 17:13:14'),
(87,0,'0:0:0:0:0:0:0:1','addCategory','POST','WMS','2023-01-05 17:13:22'),
(88,0,'0:0:0:0:0:0:0:1','getCategoryList','GET','WMS','2023-01-05 17:13:22'),
(89,0,'0:0:0:0:0:0:0:1','addCategory','POST','WMS','2023-01-05 17:13:31'),
(90,0,'0:0:0:0:0:0:0:1','getCategoryList','GET','WMS','2023-01-05 17:13:31'),
(91,0,'0:0:0:0:0:0:0:1','addCategory','POST','WMS','2023-01-05 17:13:48'),
(92,0,'0:0:0:0:0:0:0:1','getCategoryList','GET','WMS','2023-01-05 17:13:48'),
(93,0,'0:0:0:0:0:0:0:1','updateCategory','POST','WMS','2023-01-05 17:14:02'),
(94,0,'0:0:0:0:0:0:0:1','getCategoryList','GET','WMS','2023-01-05 17:14:03'),
(95,0,'0:0:0:0:0:0:0:1','addCategory','POST','WMS','2023-01-05 17:14:17'),
(96,0,'0:0:0:0:0:0:0:1','getCategoryList','GET','WMS','2023-01-05 17:14:17'),
(97,0,'0:0:0:0:0:0:0:1','addCategory','POST','WMS','2023-01-05 17:14:33'),
(98,0,'0:0:0:0:0:0:0:1','getCategoryList','GET','WMS','2023-01-05 17:14:33'),
(99,0,'0:0:0:0:0:0:0:1','addCategory','POST','WMS','2023-01-05 17:14:42'),
(100,0,'0:0:0:0:0:0:0:1','getCategoryList','GET','WMS','2023-01-05 17:14:42'),
(101,0,'0:0:0:0:0:0:0:1','addCategory','POST','WMS','2023-01-05 17:14:50'),
(102,0,'0:0:0:0:0:0:0:1','getCategoryList','GET','WMS','2023-01-05 17:14:51'),
(103,0,'0:0:0:0:0:0:0:1','getCategoryList','GET','WMS','2023-01-05 17:15:16'),
(104,0,'0:0:0:0:0:0:0:1','getCategoryList','GET','WMS','2023-01-05 17:15:23'),
(105,0,'0:0:0:0:0:0:0:1','getLevelPage','GET','WMS','2023-01-05 17:15:24'),
(106,0,'0:0:0:0:0:0:0:1','addLevel','POST','WMS','2023-01-05 17:15:35'),
(107,0,'0:0:0:0:0:0:0:1','getLevelPage','GET','WMS','2023-01-05 17:15:35'),
(108,0,'0:0:0:0:0:0:0:1','addLevel','POST','WMS','2023-01-05 17:15:42'),
(109,0,'0:0:0:0:0:0:0:1','getLevelPage','GET','WMS','2023-01-05 17:15:42'),
(110,0,'0:0:0:0:0:0:0:1','addLevel','POST','WMS','2023-01-05 17:15:48'),
(111,0,'0:0:0:0:0:0:0:1','getLevelPage','GET','WMS','2023-01-05 17:15:48'),
(112,0,'0:0:0:0:0:0:0:1','addLevel','POST','WMS','2023-01-05 17:15:56'),
(113,0,'0:0:0:0:0:0:0:1','getLevelPage','GET','WMS','2023-01-05 17:15:56'),
(114,0,'0:0:0:0:0:0:0:1','getSourcePage','GET','WMS','2023-01-05 17:15:58'),
(115,0,'0:0:0:0:0:0:0:1','addSource','POST','WMS','2023-01-05 17:16:04'),
(116,0,'0:0:0:0:0:0:0:1','getSourcePage','GET','WMS','2023-01-05 17:16:04'),
(117,0,'0:0:0:0:0:0:0:1','addSource','POST','WMS','2023-01-05 17:16:15'),
(118,0,'0:0:0:0:0:0:0:1','getSourcePage','GET','WMS','2023-01-05 17:16:15'),
(119,0,'0:0:0:0:0:0:0:1','addSource','POST','WMS','2023-01-05 17:16:23'),
(120,0,'0:0:0:0:0:0:0:1','getSourcePage','GET','WMS','2023-01-05 17:16:24'),
(121,0,'0:0:0:0:0:0:0:1','getIndustryPage','GET','WMS','2023-01-05 17:16:29'),
(122,0,'0:0:0:0:0:0:0:1','addIndustry','POST','WMS','2023-01-05 17:16:36'),
(123,0,'0:0:0:0:0:0:0:1','getIndustryPage','GET','WMS','2023-01-05 17:16:36'),
(124,0,'0:0:0:0:0:0:0:1','addIndustry','POST','WMS','2023-01-05 17:16:41'),
(125,0,'0:0:0:0:0:0:0:1','getIndustryPage','GET','WMS','2023-01-05 17:16:41'),
(126,0,'0:0:0:0:0:0:0:1','addIndustry','POST','WMS','2023-01-05 17:16:51'),
(127,0,'0:0:0:0:0:0:0:1','getIndustryPage','GET','WMS','2023-01-05 17:16:51'),
(128,0,'0:0:0:0:0:0:0:1','getRepositoryPage','GET','WMS','2023-01-05 17:17:08'),
(129,0,'0:0:0:0:0:0:0:1','getProductPage','GET','WMS','2023-01-05 17:17:11'),
(130,0,'0:0:0:0:0:0:0:1','getSupplierPage','GET','WMS','2023-01-05 17:17:15'),
(131,0,'0:0:0:0:0:0:0:1','getCarrierPage','GET','WMS','2023-01-05 17:17:16'),
(132,0,'0:0:0:0:0:0:0:1','addCarrier','POST','WMS','2023-01-05 17:18:07'),
(133,0,'0:0:0:0:0:0:0:1','getCarrierPage','GET','WMS','2023-01-05 17:18:07'),
(134,0,'0:0:0:0:0:0:0:1','getCarrierPage','GET','WMS','2023-01-05 17:18:40'),
(135,0,'0:0:0:0:0:0:0:1','addCarrier','POST','WMS','2023-01-05 17:19:15'),
(136,0,'0:0:0:0:0:0:0:1','getCarrierPage','GET','WMS','2023-01-05 17:19:15'),
(137,0,'0:0:0:0:0:0:0:1','getSupplierPage','GET','WMS','2023-01-05 17:19:24'),
(138,0,'0:0:0:0:0:0:0:1','getCustomerPage','GET','WMS','2023-01-05 17:19:26'),
(139,0,'0:0:0:0:0:0:0:1','getCarrierPage','GET','WMS','2023-01-05 17:20:11'),
(140,0,'0:0:0:0:0:0:0:1','getSupplierPage','GET','WMS','2023-01-05 17:20:12'),
(141,0,'0:0:0:0:0:0:0:1','getCustomerPage','GET','WMS','2023-01-05 17:20:14'),
(142,0,'0:0:0:0:0:0:0:1','getProductPage','GET','WMS','2023-01-05 17:20:15'),
(143,0,'0:0:0:0:0:0:0:1','getProductPage','GET','WMS','2023-01-05 17:20:25'),
(144,0,'0:0:0:0:0:0:0:1','getCustomerPage','GET','WMS','2023-01-05 17:20:27'),
(145,0,'0:0:0:0:0:0:0:1','getSupplierPage','GET','WMS','2023-01-05 17:20:28'),
(146,0,'0:0:0:0:0:0:0:1','getCarrierPage','GET','WMS','2023-01-05 17:20:29'),
(147,0,'0:0:0:0:0:0:0:1','getSupplierPage','GET','WMS','2023-01-05 17:20:33'),
(148,0,'0:0:0:0:0:0:0:1','addSupplier','POST','WMS','2023-01-05 17:21:33'),
(149,0,'0:0:0:0:0:0:0:1','getSupplierPage','GET','WMS','2023-01-05 17:21:33'),
(150,0,'0:0:0:0:0:0:0:1','addSupplier','POST','WMS','2023-01-05 17:23:01'),
(151,0,'0:0:0:0:0:0:0:1','getSupplierPage','GET','WMS','2023-01-05 17:23:01'),
(152,0,'0:0:0:0:0:0:0:1','getSupplierPage','GET','WMS','2023-01-05 17:24:31'),
(153,0,'0:0:0:0:0:0:0:1','getCarrierPage','GET','WMS','2023-01-05 17:24:37'),
(154,0,'0:0:0:0:0:0:0:1','getSupplierPage','GET','WMS','2023-01-05 17:24:38'),
(155,0,'0:0:0:0:0:0:0:1','getCustomerPage','GET','WMS','2023-01-05 17:24:39'),
(156,0,'0:0:0:0:0:0:0:1','getCustomerPage','GET','WMS','2023-01-05 17:31:35'),
(157,0,'0:0:0:0:0:0:0:1','getSourceList','GET','WMS','2023-01-05 17:31:53'),
(158,0,'0:0:0:0:0:0:0:1','getLevelList','GET','WMS','2023-01-05 17:31:53'),
(159,0,'0:0:0:0:0:0:0:1','getIndustryList','GET','WMS','2023-01-05 17:31:53'),
(160,0,'0:0:0:0:0:0:0:1','addCustomer','POST','WMS','2023-01-05 17:32:29'),
(161,0,'0:0:0:0:0:0:0:1','getCustomerPage','GET','WMS','2023-01-05 17:32:29'),
(162,0,'0:0:0:0:0:0:0:1','getProductPage','GET','WMS','2023-01-05 17:32:35'),
(163,0,'0:0:0:0:0:0:0:1','getCategoryList$','GET','WMS','2023-01-05 17:32:37'),
(164,0,'0:0:0:0:0:0:0:1','addProduct','POST','WMS','2023-01-05 17:33:03'),
(165,0,'0:0:0:0:0:0:0:1','getProductPage','GET','WMS','2023-01-05 17:33:03'),
(166,0,'0:0:0:0:0:0:0:1','getSupplierPage','GET','WMS','2023-01-05 17:33:08'),
(167,0,'0:0:0:0:0:0:0:1','getCarrierPage','GET','WMS','2023-01-05 17:33:09'),
(168,0,'0:0:0:0:0:0:0:1','getRepositoryPage','GET','WMS','2023-01-05 17:33:15'),
(169,0,'0:0:0:0:0:0:0:1','getRepositoryStatusList','GET','WMS','2023-01-05 17:33:16'),
(170,0,'0:0:0:0:0:0:0:1','addRepository','POST','WMS','2023-01-05 17:33:47'),
(171,0,'0:0:0:0:0:0:0:1','getRepositoryPage','GET','WMS','2023-01-05 17:33:47'),
(172,0,'0:0:0:0:0:0:0:1','getRepositoryStatusList','GET','WMS','2023-01-05 17:33:50'),
(173,0,'0:0:0:0:0:0:0:1','addRepository','POST','WMS','2023-01-05 17:34:15'),
(174,0,'0:0:0:0:0:0:0:1','getRepositoryPage','GET','WMS','2023-01-05 17:34:15'),
(175,0,'0:0:0:0:0:0:0:1','getSupplierList','GET','WMS','2023-01-05 17:34:19'),
(176,0,'0:0:0:0:0:0:0:1','getSupplierList','GET','WMS','2023-01-05 17:35:14'),
(177,0,'0:0:0:0:0:0:0:1','getProductList','GET','WMS','2023-01-05 17:35:28'),
(178,0,'0:0:0:0:0:0:0:1','getProduct','GET','WMS','2023-01-05 17:35:29'),
(179,0,'0:0:0:0:0:0:0:1','getRepositoryList','GET','WMS','2023-01-05 17:35:51'),
(180,0,'0:0:0:0:0:0:0:1','getProduct','GET','WMS','2023-01-05 17:35:52'),
(181,0,'0:0:0:0:0:0:0:1','getProduct','GET','WMS','2023-01-05 17:35:55'),
(182,0,'0:0:0:0:0:0:0:1','inRecordStock','POST','WMS','2023-01-05 17:36:01'),
(183,0,'0:0:0:0:0:0:0:1','getCustomerList','GET','WMS','2023-01-05 17:36:13'),
(184,0,'0:0:0:0:0:0:0:1','getProductList','GET','WMS','2023-01-05 17:36:16'),
(185,0,'0:0:0:0:0:0:0:1','getProduct','GET','WMS','2023-01-05 17:36:16'),
(186,0,'0:0:0:0:0:0:0:1','getRepositoryList','GET','WMS','2023-01-05 17:36:20'),
(187,0,'0:0:0:0:0:0:0:1','getProduct','GET','WMS','2023-01-05 17:36:21'),
(188,0,'0:0:0:0:0:0:0:1','outRecordStock','POST','WMS','2023-01-05 17:36:25'),
(189,0,'0:0:0:0:0:0:0:1','getRecordStockPage','GET','WMS','2023-01-05 17:36:31'),
(190,0,'0:0:0:0:0:0:0:1','getProductList','GET','WMS','2023-01-05 17:36:31'),
(191,0,'0:0:0:0:0:0:0:1','getRepositoryList','GET','WMS','2023-01-05 17:36:31'),
(192,0,'0:0:0:0:0:0:0:1','getRecordStockPage','GET','WMS','2023-01-05 17:36:38'),
(193,0,'0:0:0:0:0:0:0:1','getProductList','GET','WMS','2023-01-05 17:36:38'),
(194,0,'0:0:0:0:0:0:0:1','getRepositoryList','GET','WMS','2023-01-05 17:36:38'),
(195,0,'0:0:0:0:0:0:0:1','getRecordStockPage','GET','WMS','2023-01-05 17:36:40'),
(196,0,'0:0:0:0:0:0:0:1','getRecordStockPage','GET','WMS','2023-01-05 17:36:44'),
(197,0,'0:0:0:0:0:0:0:1','getRecordStockPage','GET','WMS','2023-01-05 17:36:45'),
(198,0,'0:0:0:0:0:0:0:1','getRecordStockPage','GET','WMS','2023-01-05 17:36:48'),
(199,0,'0:0:0:0:0:0:0:1','getLogs','GET','WMS','2023-01-05 17:36:57'),
(200,0,'0:0:0:0:0:0:0:1','getLogs','GET','WMS','2023-01-05 17:36:59'),
(201,0,'0:0:0:0:0:0:0:1','getLogs','GET','WMS','2023-01-05 17:37:02'),
(202,0,'0:0:0:0:0:0:0:1','getLogs','GET','WMS','2023-01-05 17:37:03'),
(203,0,'0:0:0:0:0:0:0:1','getLogs','GET','WMS','2023-01-05 17:37:05'),
(204,0,'0:0:0:0:0:0:0:1','getLogs','GET','WMS','2023-01-05 17:37:06'),
(205,0,'0:0:0:0:0:0:0:1','home','GET','WMS','2023-01-05 18:02:04'),
(206,0,'0:0:0:0:0:0:0:1','getUserDetail','GET','WMS','2023-01-05 18:02:05'),
(207,0,'127.0.0.1','toLogin','GET','匿名','2023-01-05 20:40:46'),
(208,0,'127.0.0.1','getVerifyCode','GET','匿名','2023-01-05 20:40:46'),
(209,1,'127.0.0.1','login','POST','匿名','2023-01-05 20:40:51'),
(210,0,'127.0.0.1','home','GET','三弟','2023-01-05 20:40:51'),
(211,0,'127.0.0.1','getUserDetail','GET','三弟','2023-01-05 20:40:51'),
(212,0,'127.0.0.1','getUserDetail','GET','三弟','2023-01-05 20:40:54'),
(213,0,'127.0.0.1','uploadFile','POST','三弟','2023-01-05 20:41:02'),
(214,0,'127.0.0.1','updateUser','POST','三弟','2023-01-05 20:41:04'),
(215,0,'127.0.0.1','home','GET','三弟','2023-01-05 20:41:04'),
(216,0,'127.0.0.1','getUserDetail','GET','三弟','2023-01-05 20:41:04'),
(217,0,'127.0.0.1','toLogin','GET','匿名','2023-01-05 20:44:04'),
(218,0,'127.0.0.1','getVerifyCode','GET','匿名','2023-01-05 20:44:04'),
(219,0,'127.0.0.1','home','GET','三弟','2023-01-05 20:47:21'),
(220,0,'127.0.0.1','getUserDetail','GET','三弟','2023-01-05 20:47:21'),
(221,0,'127.0.0.1','toLogin','GET','匿名','2023-01-06 09:23:14'),
(222,0,'127.0.0.1','getVerifyCode','GET','匿名','2023-01-06 09:23:14'),
(223,1,'127.0.0.1','login','POST','匿名','2023-01-06 09:23:20'),
(224,0,'127.0.0.1','home','GET','三弟','2023-01-06 09:23:21'),
(225,0,'127.0.0.1','getUserDetail','GET','三弟','2023-01-06 09:23:21'),
(226,0,'127.0.0.1','getUserDetail','GET','三弟','2023-01-06 09:23:25'),
(227,0,'127.0.0.1','uploadFile','POST','三弟','2023-01-06 09:23:28'),
(228,0,'127.0.0.1','updateUser','POST','三弟','2023-01-06 09:23:30'),
(229,0,'127.0.0.1','home','GET','三弟','2023-01-06 09:23:30'),
(230,0,'127.0.0.1','getUserDetail','GET','三弟','2023-01-06 09:23:30'),
(231,0,'127.0.0.1','getUserDetail','GET','三弟','2023-01-06 09:24:22'),
(232,0,'127.0.0.1','home','GET','三弟','2023-01-06 09:24:26'),
(233,0,'127.0.0.1','getUserDetail','GET','三弟','2023-01-06 09:24:26'),
(234,0,'127.0.0.1','getDepartmentList','GET','三弟','2023-01-06 09:24:36'),
(235,0,'127.0.0.1','getMenuList','GET','三弟','2023-01-06 09:25:27'),
(236,0,'127.0.0.1','getProductPage','GET','三弟','2023-01-06 09:25:28'),
(237,0,'127.0.0.1','getCustomerPage','GET','三弟','2023-01-06 09:25:29'),
(238,0,'127.0.0.1','getSupplierPage','GET','三弟','2023-01-06 09:25:30'),
(239,0,'127.0.0.1','getCarrierPage','GET','三弟','2023-01-06 09:25:31'),
(240,0,'127.0.0.1','getRepositoryPage','GET','三弟','2023-01-06 09:25:35'),
(241,0,'127.0.0.1','getSupplierList','GET','三弟','2023-01-06 09:25:41'),
(242,0,'127.0.0.1','getProductList','GET','三弟','2023-01-06 09:25:43'),
(243,0,'127.0.0.1','getProduct','GET','三弟','2023-01-06 09:25:44'),
(244,0,'127.0.0.1','getRepositoryList','GET','三弟','2023-01-06 09:25:48'),
(245,0,'127.0.0.1','getProduct','GET','三弟','2023-01-06 09:25:49'),
(246,0,'127.0.0.1','getProduct','GET','三弟','2023-01-06 09:25:52'),
(247,0,'127.0.0.1','getRecordStockPage','GET','三弟','2023-01-06 09:26:13'),
(248,0,'127.0.0.1','getRepositoryList','GET','三弟','2023-01-06 09:26:13'),
(249,0,'127.0.0.1','getProductList','GET','三弟','2023-01-06 09:26:13'),
(250,0,'127.0.0.1','getProductList','GET','三弟','2023-01-06 09:26:56'),
(251,0,'127.0.0.1','getCustomerList','GET','三弟','2023-01-06 09:29:12'),
(252,0,'127.0.0.1','getLogs','GET','三弟','2023-01-06 09:30:14'),
(253,0,'127.0.0.1','getLogs','GET','三弟','2023-01-06 09:30:20'),
(254,0,'127.0.0.1','getLogs','GET','三弟','2023-01-06 09:30:25'),
(255,0,'127.0.0.1','getLogs','GET','三弟','2023-01-06 09:30:30'),
(256,0,'127.0.0.1','getLogs','GET','三弟','2023-01-06 09:30:31'),
(257,0,'127.0.0.1','getLogs','GET','三弟','2023-01-06 09:30:33'),
(258,0,'127.0.0.1','getLogs','GET','三弟','2023-01-06 09:30:35'),
(259,0,'127.0.0.1','getLogs','GET','三弟','2023-01-06 09:30:36'),
(260,0,'127.0.0.1','getLogs','GET','三弟','2023-01-06 09:30:36'),
(261,0,'127.0.0.1','getLogs','GET','三弟','2023-01-06 09:30:37'),
(262,0,'127.0.0.1','getLogs','GET','三弟','2023-01-06 09:30:37'),
(263,0,'127.0.0.1','getLogs','GET','三弟','2023-01-06 09:30:38'),
(264,0,'127.0.0.1','getLogs','GET','三弟','2023-01-06 09:30:38'),
(265,0,'127.0.0.1','getLogs','GET','三弟','2023-01-06 09:30:40'),
(266,0,'127.0.0.1','getLogs','GET','三弟','2023-01-06 09:30:43'),
(267,0,'127.0.0.1','getLogs','GET','三弟','2023-01-06 09:30:45'),
(268,0,'127.0.0.1','getLogs','GET','三弟','2023-01-06 09:30:47'),
(269,0,'127.0.0.1','getCategoryList','GET','三弟','2023-01-06 09:32:12'),
(270,0,'127.0.0.1','getSourcePage','GET','三弟','2023-01-06 09:32:40'),
(271,0,'127.0.0.1','home','GET','三弟','2023-01-06 09:32:53'),
(272,0,'127.0.0.1','getUserDetail','GET','三弟','2023-01-06 09:32:53'),
(273,0,'127.0.0.1','getMenuList','GET','三弟','2023-01-06 09:36:19'),
(274,0,'127.0.0.1','getMenuList','GET','三弟','2023-01-06 09:36:23'),
(275,0,'127.0.0.1','getDepartmentList','GET','三弟','2023-01-06 09:36:26'),
(276,0,'127.0.0.1','getDepartmentList','GET','三弟','2023-01-06 09:36:34'),
(277,0,'127.0.0.1','getCarrierPage','GET','三弟','2023-01-06 09:38:39'),
(278,0,'127.0.0.1','getCarrierPage','GET','三弟','2023-01-06 09:39:06'),
(279,0,'127.0.0.1','getRecordStockPage','GET','三弟','2023-01-06 09:40:51'),
(280,0,'127.0.0.1','getProductList','GET','三弟','2023-01-06 09:40:51'),
(281,0,'127.0.0.1','getRepositoryList','GET','三弟','2023-01-06 09:40:51'),
(282,0,'127.0.0.1','getMenuList','GET','三弟','2023-01-06 09:40:56'),
(283,0,'127.0.0.1','getDepartmentList','GET','三弟','2023-01-06 09:40:57'),
(284,0,'127.0.0.1','getCustomerPage','GET','三弟','2023-01-06 09:40:58'),
(285,0,'127.0.0.1','getUserDetail','GET','三弟','2023-01-06 09:42:04'),
(286,0,'127.0.0.1','home','GET','三弟','2023-01-06 09:42:21'),
(287,0,'127.0.0.1','getUserDetail','GET','三弟','2023-01-06 09:42:21'),
(288,0,'127.0.0.1','getRepositoryPage','GET','匿名','2023-01-06 10:42:47'),
(289,0,'127.0.0.1','toLogin','GET','匿名','2023-01-06 11:00:23'),
(290,0,'127.0.0.1','getVerifyCode','GET','匿名','2023-01-06 11:00:23'),
(291,1,'127.0.0.1','login','POST','匿名','2023-01-06 11:00:27'),
(292,0,'127.0.0.1','home','GET','三弟','2023-01-06 11:00:27'),
(293,0,'127.0.0.1','getUserDetail','GET','三弟','2023-01-06 11:00:27'),
(294,0,'127.0.0.1','getUserPage','GET','三弟','2023-01-06 11:04:51'),
(295,0,'127.0.0.1','getRolePage','GET','三弟','2023-01-06 11:04:52'),
(296,0,'127.0.0.1','getDepartmentList','GET','三弟','2023-01-06 11:04:52'),
(297,0,'127.0.0.1','getMenuList','GET','三弟','2023-01-06 11:04:53'),
(298,0,'127.0.0.1','getProductPage','GET','三弟','2023-01-06 11:04:54'),
(299,0,'127.0.0.1','getCustomerPage','GET','三弟','2023-01-06 11:04:54'),
(300,0,'127.0.0.1','getSupplierPage','GET','三弟','2023-01-06 11:04:55'),
(301,0,'127.0.0.1','getCarrierPage','GET','三弟','2023-01-06 11:04:56'),
(302,0,'127.0.0.1','getRepositoryPage','GET','三弟','2023-01-06 11:04:57'),
(303,0,'127.0.0.1','getRecordStockPage','GET','三弟','2023-01-06 11:05:00'),
(304,0,'127.0.0.1','getProductList','GET','三弟','2023-01-06 11:05:00'),
(305,0,'127.0.0.1','getRepositoryList','GET','三弟','2023-01-06 11:05:00'),
(306,0,'127.0.0.1','toLogin','GET','匿名','2023-01-06 11:07:33'),
(307,0,'127.0.0.1','toLogin','GET','匿名','2023-01-06 11:12:24'),
(308,0,'127.0.0.1','getVerifyCode','GET','匿名','2023-01-06 11:12:24'),
(309,1,'127.0.0.1','login','POST','匿名','2023-01-06 11:12:28'),
(310,0,'127.0.0.1','home','GET','三弟','2023-01-06 11:12:28'),
(311,0,'127.0.0.1','getUserDetail','GET','三弟','2023-01-06 11:12:28'),
(312,0,'127.0.0.1','toLogin','GET','匿名','2023-01-06 11:12:53'),
(313,0,'127.0.0.1','getVerifyCode','GET','匿名','2023-01-06 11:12:53'),
(314,1,'127.0.0.1','login','POST','匿名','2023-01-06 11:12:56'),
(315,0,'127.0.0.1','home','GET','三弟','2023-01-06 11:12:56'),
(316,0,'127.0.0.1','getUserDetail','GET','三弟','2023-01-06 11:12:56'),
(317,0,'127.0.0.1','getUserDetail','GET','三弟','2023-01-06 11:12:58'),
(318,0,'127.0.0.1','uploadFile','POST','三弟','2023-01-06 11:13:03'),
(319,0,'127.0.0.1','updateUser','POST','三弟','2023-01-06 11:13:05'),
(320,0,'127.0.0.1','home','GET','三弟','2023-01-06 11:13:05'),
(321,0,'127.0.0.1','getUserDetail','GET','三弟','2023-01-06 11:13:05'),
(322,0,'127.0.0.1','toLogin','GET','匿名','2023-01-06 13:25:12'),
(323,0,'127.0.0.1','getVerifyCode','GET','匿名','2023-01-06 13:25:13'),
(324,0,'127.0.0.1','getVerifyCode','GET','匿名','2023-01-06 13:25:16'),
(325,1,'127.0.0.1','login','POST','匿名','2023-01-06 13:25:18'),
(326,0,'127.0.0.1','home','GET','三弟','2023-01-06 13:25:19'),
(327,0,'127.0.0.1','getUserDetail','GET','三弟','2023-01-06 13:25:19'),
(328,0,'127.0.0.1','toLogin','GET','匿名','2023-01-06 13:25:25'),
(329,0,'127.0.0.1','home','GET','三弟','2023-01-06 13:25:59'),
(330,0,'127.0.0.1','getUserDetail','GET','三弟','2023-01-06 13:25:59'),
(331,0,'127.0.0.1','toLogin','GET','匿名','2023-01-06 13:26:44'),
(332,0,'127.0.0.1','getVerifyCode','GET','匿名','2023-01-06 13:26:45'),
(333,1,'127.0.0.1','login','POST','匿名','2023-01-06 13:26:48'),
(334,0,'127.0.0.1','home','GET','三弟','2023-01-06 13:26:48'),
(335,0,'127.0.0.1','getUserDetail','GET','三弟','2023-01-06 13:26:48'),
(336,0,'0:0:0:0:0:0:0:1','toLogin','GET','匿名','2023-01-06 13:28:06'),
(337,0,'0:0:0:0:0:0:0:1','getVerifyCode','GET','匿名','2023-01-06 13:28:06'),
(338,1,'0:0:0:0:0:0:0:1','login','POST','匿名','2023-01-06 13:28:11'),
(339,1,'0:0:0:0:0:0:0:1','login','POST','匿名','2023-01-06 13:28:14'),
(340,0,'0:0:0:0:0:0:0:1','home','GET','三弟','2023-01-06 13:28:14'),
(341,0,'0:0:0:0:0:0:0:1','getUserDetail','GET','三弟','2023-01-06 13:28:14'),
(342,0,'0:0:0:0:0:0:0:1','home','GET','三弟','2023-01-06 13:29:01'),
(343,0,'0:0:0:0:0:0:0:1','getUserDetail','GET','三弟','2023-01-06 13:29:01'),
(344,0,'0:0:0:0:0:0:0:1','home','GET','三弟','2023-01-06 13:29:08'),
(345,0,'0:0:0:0:0:0:0:1','getUserDetail','GET','三弟','2023-01-06 13:29:08'),
(346,0,'0:0:0:0:0:0:0:1','home','GET','三弟','2023-01-06 13:30:04'),
(347,0,'0:0:0:0:0:0:0:1','getUserDetail','GET','三弟','2023-01-06 13:30:05'),
(348,0,'0:0:0:0:0:0:0:1','toLogin','GET','匿名','2023-01-06 13:31:13'),
(349,0,'0:0:0:0:0:0:0:1','getVerifyCode','GET','匿名','2023-01-06 13:31:13'),
(350,1,'0:0:0:0:0:0:0:1','login','POST','匿名','2023-01-06 13:31:17'),
(351,0,'0:0:0:0:0:0:0:1','home','GET','三弟','2023-01-06 13:31:17'),
(352,0,'0:0:0:0:0:0:0:1','getUserDetail','GET','三弟','2023-01-06 13:31:18'),
(353,0,'0:0:0:0:0:0:0:1','home','GET','三弟','2023-01-06 13:31:29'),
(354,0,'0:0:0:0:0:0:0:1','getUserDetail','GET','三弟','2023-01-06 13:31:29'),
(355,0,'0:0:0:0:0:0:0:1','home','GET','三弟','2023-01-06 13:31:46'),
(356,0,'0:0:0:0:0:0:0:1','getUserDetail','GET','三弟','2023-01-06 13:31:46'),
(357,0,'0:0:0:0:0:0:0:1','toLogin','GET','匿名','2023-01-06 13:32:08'),
(358,0,'0:0:0:0:0:0:0:1','getVerifyCode','GET','匿名','2023-01-06 13:32:08'),
(359,1,'0:0:0:0:0:0:0:1','login','POST','匿名','2023-01-06 13:32:12'),
(360,0,'0:0:0:0:0:0:0:1','home','GET','三弟','2023-01-06 13:32:12'),
(361,0,'0:0:0:0:0:0:0:1','getUserDetail','GET','三弟','2023-01-06 13:32:13'),
(362,0,'0:0:0:0:0:0:0:1','toLogin','GET','匿名','2023-01-06 13:34:25'),
(363,0,'0:0:0:0:0:0:0:1','getVerifyCode','GET','匿名','2023-01-06 13:34:26'),
(364,1,'0:0:0:0:0:0:0:1','login','POST','匿名','2023-01-06 13:34:29'),
(365,0,'0:0:0:0:0:0:0:1','home','GET','三弟','2023-01-06 13:34:29'),
(366,0,'0:0:0:0:0:0:0:1','getUserDetail','GET','三弟','2023-01-06 13:34:29'),
(367,0,'0:0:0:0:0:0:0:1','home','GET','三弟','2023-01-06 13:36:56'),
(368,0,'0:0:0:0:0:0:0:1','getUserDetail','GET','三弟','2023-01-06 13:36:56'),
(369,0,'0:0:0:0:0:0:0:1','toLogin','GET','匿名','2023-01-06 13:37:19'),
(370,0,'0:0:0:0:0:0:0:1','getVerifyCode','GET','匿名','2023-01-06 13:37:19'),
(371,1,'0:0:0:0:0:0:0:1','login','POST','匿名','2023-01-06 13:37:22'),
(372,0,'0:0:0:0:0:0:0:1','home','GET','三弟','2023-01-06 13:37:22'),
(373,0,'0:0:0:0:0:0:0:1','getUserDetail','GET','三弟','2023-01-06 13:37:22'),
(374,0,'0:0:0:0:0:0:0:1','toLogin','GET','匿名','2023-01-06 13:39:39'),
(375,0,'0:0:0:0:0:0:0:1','getVerifyCode','GET','匿名','2023-01-06 13:39:39'),
(376,1,'0:0:0:0:0:0:0:1','login','POST','匿名','2023-01-06 13:39:42'),
(377,0,'0:0:0:0:0:0:0:1','home','GET','三弟','2023-01-06 13:39:43'),
(378,0,'0:0:0:0:0:0:0:1','getUserDetail','GET','三弟','2023-01-06 13:39:43'),
(379,0,'0:0:0:0:0:0:0:1','toLogin','GET','匿名','2023-01-06 13:42:47'),
(380,0,'0:0:0:0:0:0:0:1','getVerifyCode','GET','匿名','2023-01-06 13:42:48'),
(381,1,'0:0:0:0:0:0:0:1','login','POST','匿名','2023-01-06 13:42:51'),
(382,0,'0:0:0:0:0:0:0:1','home','GET','三弟','2023-01-06 13:42:51'),
(383,0,'0:0:0:0:0:0:0:1','getUserDetail','GET','三弟','2023-01-06 13:42:51'),
(384,0,'0:0:0:0:0:0:0:1','getLogs','GET','三弟','2023-01-06 13:43:01'),
(385,0,'0:0:0:0:0:0:0:1','getLogs','GET','三弟','2023-01-06 13:43:02'),
(386,0,'0:0:0:0:0:0:0:1','home','GET','三弟','2023-01-06 13:44:01'),
(387,0,'0:0:0:0:0:0:0:1','getUserDetail','GET','三弟','2023-01-06 13:44:01'),
(388,0,'0:0:0:0:0:0:0:1','getProductPage','GET','三弟','2023-01-06 13:44:40'),
(389,0,'0:0:0:0:0:0:0:1','home','GET','三弟','2023-01-06 13:46:58'),
(390,0,'0:0:0:0:0:0:0:1','getUserDetail','GET','三弟','2023-01-06 13:46:58'),
(391,0,'0:0:0:0:0:0:0:1','getUserDetail','GET','三弟','2023-01-06 13:47:05'),
(392,0,'0:0:0:0:0:0:0:1','uploadFile','POST','三弟','2023-01-06 13:47:10'),
(393,0,'0:0:0:0:0:0:0:1','updateUser','POST','三弟','2023-01-06 13:47:11'),
(394,0,'0:0:0:0:0:0:0:1','home','GET','三弟','2023-01-06 13:47:11'),
(395,0,'0:0:0:0:0:0:0:1','getUserDetail','GET','三弟','2023-01-06 13:47:11'),
(396,0,'0:0:0:0:0:0:0:1','toLogin','GET','匿名','2023-01-06 13:47:50'),
(397,0,'0:0:0:0:0:0:0:1','getVerifyCode','GET','匿名','2023-01-06 13:47:51'),
(398,1,'0:0:0:0:0:0:0:1','login','POST','匿名','2023-01-06 13:47:54'),
(399,0,'0:0:0:0:0:0:0:1','home','GET','三弟','2023-01-06 13:47:54'),
(400,0,'0:0:0:0:0:0:0:1','getUserDetail','GET','三弟','2023-01-06 13:47:54'),
(401,0,'0:0:0:0:0:0:0:1','toLogin','GET','匿名','2023-01-06 13:49:13'),
(402,0,'0:0:0:0:0:0:0:1','getVerifyCode','GET','匿名','2023-01-06 13:49:14'),
(403,1,'0:0:0:0:0:0:0:1','login','POST','匿名','2023-01-06 13:49:18'),
(404,0,'0:0:0:0:0:0:0:1','home','GET','三弟','2023-01-06 13:49:18'),
(405,0,'0:0:0:0:0:0:0:1','getUserDetail','GET','三弟','2023-01-06 13:49:18'),
(406,0,'0:0:0:0:0:0:0:1','getUserDetail','GET','三弟','2023-01-06 13:49:20'),
(407,0,'0:0:0:0:0:0:0:1','uploadFile','POST','三弟','2023-01-06 13:49:24'),
(408,0,'0:0:0:0:0:0:0:1','updateUser','POST','三弟','2023-01-06 13:49:25'),
(409,0,'0:0:0:0:0:0:0:1','home','GET','三弟','2023-01-06 13:49:25'),
(410,0,'0:0:0:0:0:0:0:1','getUserDetail','GET','三弟','2023-01-06 13:49:25'),
(411,0,'0:0:0:0:0:0:0:1','home','GET','三弟','2023-01-06 13:49:26'),
(412,0,'0:0:0:0:0:0:0:1','getUserDetail','GET','三弟','2023-01-06 13:49:26');

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `USER_ID` int NOT NULL AUTO_INCREMENT COMMENT '用户ID,主键自增',
  `USER_NAME` varchar(20) NOT NULL COMMENT '用户名',
  `USER_TEL` varchar(20) NOT NULL COMMENT '联系电话',
  `USER_EMAIL` varchar(100) NOT NULL COMMENT '邮箱',
  `USER_NICK` varchar(10) DEFAULT 'WMS' COMMENT '用户昵称',
  `PASSWORD` varchar(255) NOT NULL COMMENT '密码',
  `SALT` varchar(100) DEFAULT NULL COMMENT '盐值',
  `AVATAR` varchar(255) DEFAULT '/img/avatar.jpeg' COMMENT '用户头像地址',
  `CREATE_TIME` datetime DEFAULT NULL COMMENT '创建时间',
  `UPDATE_TIME` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '设置当前时间，并且自动更更新时间',
  `IS_DELETE` int DEFAULT '1' COMMENT '是否删除 0:删除 1:未删除',
  PRIMARY KEY (`USER_ID`),
  UNIQUE KEY `USER_TEL` (`USER_TEL`),
  UNIQUE KEY `USER_EMAIL` (`USER_EMAIL`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb3 COMMENT='用户表';

/*Data for the table `user` */

insert  into `user`(`USER_ID`,`USER_NAME`,`USER_TEL`,`USER_EMAIL`,`USER_NICK`,`PASSWORD`,`SALT`,`AVATAR`,`CREATE_TIME`,`UPDATE_TIME`,`IS_DELETE`) values 
(1,'张三','18288888888','zs@163.com','三弟','a38b872c85e9096dd2d97b5dbe482861','1','/pics/a4cac348-eb3d-4e18-b6cf-db0d1eeb85cb.jpg','2023-01-05 17:01:59','2023-01-06 13:49:25',1),
(2,'李四','18277777777','ls@163.com','四哥','6e7a02af81126d820abb074b8f47e127','0.28609688608538886','/img/avatar.jpeg','2023-01-05 17:10:41','2023-01-05 17:10:42',1);

/*Table structure for table `user_department` */

DROP TABLE IF EXISTS `user_department`;

CREATE TABLE `user_department` (
  `DEPT_ID` int NOT NULL COMMENT '部门ID',
  `USER_ID` int NOT NULL COMMENT '用户ID',
  `CREATE_TIME` datetime DEFAULT NULL COMMENT '创建时间',
  `UPDATE_TIME` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '设置当前时间，并且自动更更新时间',
  `IS_DELETE` int DEFAULT '1' COMMENT '是否删除 0:删除 1:未删除',
  PRIMARY KEY (`USER_ID`,`DEPT_ID`),
  KEY `DEPT_ID` (`DEPT_ID`),
  CONSTRAINT `user_department_ibfk_1` FOREIGN KEY (`USER_ID`) REFERENCES `user` (`USER_ID`),
  CONSTRAINT `user_department_ibfk_2` FOREIGN KEY (`DEPT_ID`) REFERENCES `department` (`DEPT_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COMMENT='用户部门关联表';

/*Data for the table `user_department` */

insert  into `user_department`(`DEPT_ID`,`USER_ID`,`CREATE_TIME`,`UPDATE_TIME`,`IS_DELETE`) values 
(7,2,'2023-01-05 17:10:41','2023-01-05 17:10:42',1),
(8,2,'2023-01-05 17:10:41','2023-01-05 17:10:42',1);

/*Table structure for table `user_repository` */

DROP TABLE IF EXISTS `user_repository`;

CREATE TABLE `user_repository` (
  `REPO_ID` int NOT NULL COMMENT '仓库ID',
  `USER_ID` int NOT NULL COMMENT '用户ID',
  `CREATE_TIME` datetime DEFAULT NULL COMMENT '创建时间',
  `UPDATE_TIME` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '设置当前时间，并且自动更更新时间',
  `IS_DELETE` int DEFAULT '1' COMMENT '是否删除 0:删除 1:未删除',
  PRIMARY KEY (`REPO_ID`,`USER_ID`),
  KEY `USER_ID` (`USER_ID`),
  CONSTRAINT `user_repository_ibfk_1` FOREIGN KEY (`REPO_ID`) REFERENCES `repository` (`REPO_ID`),
  CONSTRAINT `user_repository_ibfk_2` FOREIGN KEY (`USER_ID`) REFERENCES `user` (`USER_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COMMENT='用户仓库关联表';

/*Data for the table `user_repository` */

/*Table structure for table `user_role` */

DROP TABLE IF EXISTS `user_role`;

CREATE TABLE `user_role` (
  `USER_ID` int NOT NULL COMMENT '用户ID,关联用户表主键',
  `ROLE_ID` int NOT NULL COMMENT '角色ID,关联角色表主键',
  `CREATE_TIME` datetime DEFAULT NULL COMMENT '创建时间',
  `UPDATE_TIME` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '设置当前时间，并且自动更更新时间',
  `IS_DELETE` int DEFAULT '1' COMMENT '是否删除 0:删除 1:未删除',
  PRIMARY KEY (`USER_ID`,`ROLE_ID`),
  KEY `ROLE_ID` (`ROLE_ID`),
  CONSTRAINT `user_role_ibfk_1` FOREIGN KEY (`USER_ID`) REFERENCES `user` (`USER_ID`),
  CONSTRAINT `user_role_ibfk_2` FOREIGN KEY (`ROLE_ID`) REFERENCES `role` (`ROLE_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COMMENT='用户角色关联表';

/*Data for the table `user_role` */

insert  into `user_role`(`USER_ID`,`ROLE_ID`,`CREATE_TIME`,`UPDATE_TIME`,`IS_DELETE`) values 
(2,2,'2023-01-05 17:10:41','2023-01-05 17:10:42',1);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
