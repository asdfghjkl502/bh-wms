-- ----------------------------
-- 权限模块表结构
-- ----------------------------

-- 权限表
DROP TABLE IF EXISTS `permission`;
CREATE TABLE `permission` (
  `PERMISSION_ID` int NOT NULL AUTO_INCREMENT COMMENT '权限ID',
  `PERMISSION_NAME` varchar(100) NOT NULL COMMENT '权限名称',
  `PERMISSION_CODE` varchar(100) NOT NULL COMMENT '权限代码(如system:user:add)',
  `PERMISSION_TYPE` int NOT NULL COMMENT '权限类型:1=菜单,2=按钮,3=API',
  `PERMISSION_URL` varchar(255) DEFAULT NULL COMMENT '权限URL(API权限时使用)',
  `LEVEL` int DEFAULT '1' COMMENT '层级',
  `PARENT_ID` int DEFAULT '0' COMMENT '父ID,0表示顶级',
  `CREATE_TIME` datetime DEFAULT NULL COMMENT '创建时间',
  `UPDATE_TIME` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `IS_DELETE` int DEFAULT '1' COMMENT '是否删除:0=删除,1=未删除',
  PRIMARY KEY (`PERMISSION_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='权限表';

-- 角色权限关联表
DROP TABLE IF EXISTS `role_permission`;
CREATE TABLE `role_permission` (
  `ROLE_ID` int NOT NULL COMMENT '角色ID',
  `PERMISSION_ID` int NOT NULL COMMENT '权限ID',
  `CREATE_TIME` datetime DEFAULT NULL COMMENT '创建时间',
  `UPDATE_TIME` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `IS_DELETE` int DEFAULT '1' COMMENT '是否删除:0=删除,1=未删除',
  PRIMARY KEY (`ROLE_ID`,`PERMISSION_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='角色权限关联表';

-- ----------------------------
-- 初始权限数据
-- ----------------------------

-- 系统管理权限
INSERT INTO `permission` (`PERMISSION_ID`, `PERMISSION_NAME`, `PERMISSION_CODE`, `PERMISSION_TYPE`, `PERMISSION_URL`, `LEVEL`, `PARENT_ID`, `CREATE_TIME`, `IS_DELETE`) VALUES
(1, '系统管理', 'system', 1, NULL, 1, 0, NOW(), 1),
(2, '用户管理', 'system:user', 1, NULL, 2, 1, NOW(), 1),
(3, '用户列表', 'system:user:list', 2, '/getUserPage', 3, 2, NOW(), 1),
(4, '添加用户', 'system:user:add', 2, '/addUser', 3, 2, NOW(), 1),
(5, '更新用户', 'system:user:update', 2, '/updateUser', 3, 2, NOW(), 1),
(6, '删除用户', 'system:user:delete', 2, '/batchDeleteUser', 3, 2, NOW(), 1),
(7, '角色管理', 'system:role', 1, NULL, 2, 1, NOW(), 1),
(8, '角色列表', 'system:role:list', 2, '/getRolePage', 3, 7, NOW(), 1),
(9, '添加角色', 'system:role:add', 2, '/addRole', 3, 7, NOW(), 1),
(10, '更新角色', 'system:role:update', 2, '/updateRole', 3, 7, NOW(), 1),
(11, '删除角色', 'system:role:delete', 2, '/batchDeleteRole', 3, 7, NOW(), 1),
(12, '权限管理', 'system:permission', 1, NULL, 2, 1, NOW(), 1),
(13, '权限列表', 'system:permission:list', 2, '/getPermissionPage', 3, 12, NOW(), 1),
(14, '添加权限', 'system:permission:add', 2, '/addPermission', 3, 12, NOW(), 1),
(15, '更新权限', 'system:permission:update', 2, '/updatePermission', 3, 12, NOW(), 1),
(16, '删除权限', 'system:permission:delete', 2, '/deletePermission', 3, 12, NOW(), 1),

-- 基础数据权限
(20, '基础数据', 'base', 1, NULL, 1, 0, NOW(), 1),
(21, '产品管理', 'base:product', 1, NULL, 2, 20, NOW(), 1),
(22, '产品列表', 'base:product:list', 2, '/getProductPage', 3, 21, NOW(), 1),
(23, '添加产品', 'base:product:add', 2, '/addProduct', 3, 21, NOW(), 1),
(24, '更新产品', 'base:product:update', 2, '/updateProduct', 3, 21, NOW(), 1),
(25, '删除产品', 'base:product:delete', 2, '/batchDeleteProduct', 3, 21, NOW(), 1),
(26, '客户管理', 'base:customer', 1, NULL, 2, 20, NOW(), 1),
(27, '客户列表', 'base:customer:list', 2, '/getCustomerPage', 3, 26, NOW(), 1),
(28, '供应商管理', 'base:supplier', 1, NULL, 2, 20, NOW(), 1),
(29, '供应商列表', 'base:supplier:list', 2, '/getSupplierPage', 3, 28, NOW(), 1),

-- 仓库管理权限
(30, '仓库管理', 'repo', 1, NULL, 1, 0, NOW(), 1),
(31, '仓库列表', 'repo:warehouse:list', 2, '/getRepositoryPage', 3, 31, NOW(), 1),
(32, '添加入库', 'repo:warehouse:in', 2, '/inRecordStock', 3, 31, NOW(), 1),
(33, '添加出库', 'repo:warehouse:out', 2, '/outRecordStock', 3, 31, NOW(), 1),
(34, '库存查询', 'repo:stock:list', 2, '/getRecordStockPage', 3, 31, NOW(), 1);

-- 给管理员角色分配所有权限 (假设管理员角色ROLE_ID=1)
INSERT INTO `role_permission` (`ROLE_ID`, `PERMISSION_ID`, `CREATE_TIME`, `IS_DELETE`)
SELECT 1, `PERMISSION_ID`, NOW(), 1 FROM `permission` WHERE `IS_DELETE` = 1;
