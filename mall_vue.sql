/*
 Navicat Premium Data Transfer

 Source Server         : TYKY
 Source Server Type    : MySQL
 Source Server Version : 80012
 Source Host           : localhost:3306
 Source Schema         : mall_vue

 Target Server Type    : MySQL
 Target Server Version : 80012
 File Encoding         : 65001

 Date: 16/03/2020 17:11:33
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for mall_goods
-- ----------------------------
DROP TABLE IF EXISTS `mall_goods`;
CREATE TABLE `mall_goods`  (
  `id` int(11) NOT NULL,
  `cat_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `cat_deleted` int(255) NOT NULL,
  `cat_level` int(255) NOT NULL,
  `cat_pid` int(11) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of mall_goods
-- ----------------------------
INSERT INTO `mall_goods` VALUES (100, '大家电', 0, 0, 0);
INSERT INTO `mall_goods` VALUES (101, '电视', 0, 1, 100);
INSERT INTO `mall_goods` VALUES (102, '空调', 0, 1, 100);
INSERT INTO `mall_goods` VALUES (103, '海信', 0, 2, 101);
INSERT INTO `mall_goods` VALUES (104, '威视', 0, 2, 101);
INSERT INTO `mall_goods` VALUES (105, '美菱', 0, 2, 102);
INSERT INTO `mall_goods` VALUES (106, '热门推荐', 0, 0, 0);
INSERT INTO `mall_goods` VALUES (107, '圣诞狂欢', 0, 1, 106);
INSERT INTO `mall_goods` VALUES (108, '面膜', 0, 2, 107);
INSERT INTO `mall_goods` VALUES (110, '海外购', 0, 0, 0);
INSERT INTO `mall_goods` VALUES (111, '康佳', 0, 2, 101);
INSERT INTO `mall_goods` VALUES (112, '圣诞套装', 0, 2, 107);
INSERT INTO `mall_goods` VALUES (113, '格力', 0, 2, 102);
INSERT INTO `mall_goods` VALUES (114, '长虹', 0, 2, 101);
INSERT INTO `mall_goods` VALUES (115, '麋鹿', 0, 2, 107);
INSERT INTO `mall_goods` VALUES (116, '圣诞玩具', 0, 2, 107);
INSERT INTO `mall_goods` VALUES (117, '海外购', 0, 2, 101);

-- ----------------------------
-- Table structure for mall_powers
-- ----------------------------
DROP TABLE IF EXISTS `mall_powers`;
CREATE TABLE `mall_powers`  (
  `id` int(11) NOT NULL,
  `auth_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `grade` int(255) NOT NULL,
  `pid` int(11) NULL DEFAULT NULL,
  `path` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of mall_powers
-- ----------------------------
INSERT INTO `mall_powers` VALUES (101, '商品管理', 0, 1001, 'goods');
INSERT INTO `mall_powers` VALUES (102, '用户管理', 0, 1001, 'users');
INSERT INTO `mall_powers` VALUES (103, '订单管理', 0, 1001, 'orders');
INSERT INTO `mall_powers` VALUES (104, '权限管理', 0, 1001, 'rights');
INSERT INTO `mall_powers` VALUES (105, '数据统计', 0, 1001, 'reports');
INSERT INTO `mall_powers` VALUES (201, '商品列表', 1, 101, 'goods');
INSERT INTO `mall_powers` VALUES (202, '添加商品', 2, 201, 'goods');
INSERT INTO `mall_powers` VALUES (203, '商品修改', 2, 201, 'goods');
INSERT INTO `mall_powers` VALUES (204, '商品删除', 2, 201, 'goods');
INSERT INTO `mall_powers` VALUES (205, '更新商品图片', 2, 201, 'goods');
INSERT INTO `mall_powers` VALUES (206, '更新商品属性', 2, 201, 'goods');
INSERT INTO `mall_powers` VALUES (207, '更新商品状态', 2, 201, 'goods');
INSERT INTO `mall_powers` VALUES (208, '更新商品详情', 2, 201, 'goods');
INSERT INTO `mall_powers` VALUES (302, '分类参数', 1, 101, 'params');
INSERT INTO `mall_powers` VALUES (303, '获取参数列表', 2, 302, 'categories');
INSERT INTO `mall_powers` VALUES (304, '创建商品参数', 2, 302, 'categories');
INSERT INTO `mall_powers` VALUES (305, '删除商品参数', 2, 302, 'categories');
INSERT INTO `mall_powers` VALUES (403, '商品分类', 1, 101, 'categories');
INSERT INTO `mall_powers` VALUES (405, '添加分类', 2, 403, 'categories');
INSERT INTO `mall_powers` VALUES (406, '删除分类', 2, 403, 'categories');
INSERT INTO `mall_powers` VALUES (407, '获取分类详情', 2, 403, 'categories');
INSERT INTO `mall_powers` VALUES (504, '订单列表', 1, 103, 'orders');
INSERT INTO `mall_powers` VALUES (505, '添加订单', 2, 504, 'orders');
INSERT INTO `mall_powers` VALUES (506, '订单更新', 2, 504, 'orders');
INSERT INTO `mall_powers` VALUES (507, '获取订单详情', 2, 504, 'orders');
INSERT INTO `mall_powers` VALUES (605, '角色列表', 1, 104, 'roles');
INSERT INTO `mall_powers` VALUES (606, '添加角色', 2, 605, 'roles');
INSERT INTO `mall_powers` VALUES (607, '删除角色', 2, 605, 'roles');
INSERT INTO `mall_powers` VALUES (608, '角色授权', 2, 605, 'roles');
INSERT INTO `mall_powers` VALUES (609, '取消角色授权', 2, 605, 'roles');
INSERT INTO `mall_powers` VALUES (610, '获取角色列表', 2, 605, 'roles');
INSERT INTO `mall_powers` VALUES (611, '获取角色详情', 2, 605, 'roles');
INSERT INTO `mall_powers` VALUES (612, '更新角色信息', 2, 605, 'roles');
INSERT INTO `mall_powers` VALUES (613, '更新角色权限', 2, 605, 'roles');
INSERT INTO `mall_powers` VALUES (706, '权限列表', 1, 104, 'rights');
INSERT INTO `mall_powers` VALUES (708, '查看权限', 2, 706, 'rights');
INSERT INTO `mall_powers` VALUES (802, '设置管理状态', 2, 807, 'users');
INSERT INTO `mall_powers` VALUES (803, '分配用户角色', 2, 807, 'users');
INSERT INTO `mall_powers` VALUES (804, '获取用户详情', 2, 807, 'users');
INSERT INTO `mall_powers` VALUES (805, '更新用户', 2, 807, 'users');
INSERT INTO `mall_powers` VALUES (806, '删除用户', 2, 807, 'users');
INSERT INTO `mall_powers` VALUES (807, '用户列表', 1, 102, 'users');
INSERT INTO `mall_powers` VALUES (808, '添加用户', 2, 807, 'users');
INSERT INTO `mall_powers` VALUES (908, '数据报表', 1, 105, 'reports');
INSERT INTO `mall_powers` VALUES (909, '查看数据', 2, 908, 'reports');

-- ----------------------------
-- Table structure for mall_roles
-- ----------------------------
DROP TABLE IF EXISTS `mall_roles`;
CREATE TABLE `mall_roles`  (
  `id` int(11) NULL DEFAULT NULL,
  `role_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `role_desc` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of mall_roles
-- ----------------------------
INSERT INTO `mall_roles` VALUES (2, 'hhh', 'hhhh');
INSERT INTO `mall_roles` VALUES (3, '测试', '测试');
INSERT INTO `mall_roles` VALUES (1, '市场总监', '主管市场');
INSERT INTO `mall_roles` VALUES (1000, '主管', '技术负责人');
INSERT INTO `mall_roles` VALUES (1001, '经理', '行政管理');
INSERT INTO `mall_roles` VALUES (1002, '销售员', '产品销售');

-- ----------------------------
-- Table structure for mall_users
-- ----------------------------
DROP TABLE IF EXISTS `mall_users`;
CREATE TABLE `mall_users`  (
  `id` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `email` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `telephone` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `role` int(255) NULL DEFAULT NULL,
  `status` int(255) NULL DEFAULT 0,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of mall_users
-- ----------------------------
INSERT INTO `mall_users` VALUES ('5dc1e96a057944c98c99f28d56334736', '13878447', '13878447846', '13878447846@qq.com', '13878447846', 1, 0);
INSERT INTO `mall_users` VALUES ('abc-123', 'Jobe', '123456212', '535523024@qq.com', '13678259451', 1000, 1);
INSERT INTO `mall_users` VALUES ('abc-124', 'Jim', '123456', '535523024@qq.com', '17672259451', 1002, 1);
INSERT INTO `mall_users` VALUES ('abc-125', 'Jenny', '123456', '535923024@qq.com', '15678259451', 1, 0);
INSERT INTO `mall_users` VALUES ('abc-126', 'Jen', '123456', '635423024@qq.com', '17678250451', 1, 0);
INSERT INTO `mall_users` VALUES ('abc-127', 'His', '123456', '735523024@qq.com', '17632459451', 1000, 1);
INSERT INTO `mall_users` VALUES ('d73e1167acc1451dba150ad7ae255eee', 'editDialo', 'editDialo', 'editDialo@qq.com', '13678956875', NULL, 0);
INSERT INTO `mall_users` VALUES ('e26eb1c4693e412ab7e415356cab291a', 'samous', '123456', '1456987545@qq.com', '13878454578', NULL, 0);
INSERT INTO `mall_users` VALUES ('f0164dad6dd94540899455aed267938d', 'gVisible', 'editDialogVi', 'editDialo1@qq.com', '13878955678', NULL, 0);

-- ----------------------------
-- Table structure for roles_powers
-- ----------------------------
DROP TABLE IF EXISTS `roles_powers`;
CREATE TABLE `roles_powers`  (
  `roles_id` int(11) NOT NULL,
  `powers_id` int(11) NOT NULL
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of roles_powers
-- ----------------------------
INSERT INTO `roles_powers` VALUES (1000, 202);
INSERT INTO `roles_powers` VALUES (1000, 203);
INSERT INTO `roles_powers` VALUES (1000, 204);
INSERT INTO `roles_powers` VALUES (1000, 101);
INSERT INTO `roles_powers` VALUES (1000, 201);
INSERT INTO `roles_powers` VALUES (1000, 205);
INSERT INTO `roles_powers` VALUES (1000, 206);
INSERT INTO `roles_powers` VALUES (1000, 207);
INSERT INTO `roles_powers` VALUES (1000, 208);
INSERT INTO `roles_powers` VALUES (1000, 302);
INSERT INTO `roles_powers` VALUES (1000, 303);
INSERT INTO `roles_powers` VALUES (1000, 304);
INSERT INTO `roles_powers` VALUES (1000, 305);
INSERT INTO `roles_powers` VALUES (1000, 403);
INSERT INTO `roles_powers` VALUES (1000, 405);
INSERT INTO `roles_powers` VALUES (1000, 406);
INSERT INTO `roles_powers` VALUES (1000, 407);
INSERT INTO `roles_powers` VALUES (1002, 201);
INSERT INTO `roles_powers` VALUES (1002, 202);
INSERT INTO `roles_powers` VALUES (1002, 203);
INSERT INTO `roles_powers` VALUES (1002, 204);
INSERT INTO `roles_powers` VALUES (1002, 205);
INSERT INTO `roles_powers` VALUES (1002, 206);
INSERT INTO `roles_powers` VALUES (1002, 207);
INSERT INTO `roles_powers` VALUES (1002, 208);
INSERT INTO `roles_powers` VALUES (1002, 302);
INSERT INTO `roles_powers` VALUES (1002, 303);
INSERT INTO `roles_powers` VALUES (1002, 304);
INSERT INTO `roles_powers` VALUES (1002, 305);
INSERT INTO `roles_powers` VALUES (1002, 405);
INSERT INTO `roles_powers` VALUES (1002, 406);
INSERT INTO `roles_powers` VALUES (1002, 806);
INSERT INTO `roles_powers` VALUES (1002, 101);
INSERT INTO `roles_powers` VALUES (1002, 403);
INSERT INTO `roles_powers` VALUES (1002, 102);
INSERT INTO `roles_powers` VALUES (1002, 807);
INSERT INTO `roles_powers` VALUES (1001, 203);
INSERT INTO `roles_powers` VALUES (1001, 303);
INSERT INTO `roles_powers` VALUES (1001, 101);
INSERT INTO `roles_powers` VALUES (1001, 201);
INSERT INTO `roles_powers` VALUES (1001, 302);
INSERT INTO `roles_powers` VALUES (2, 202);
INSERT INTO `roles_powers` VALUES (2, 203);
INSERT INTO `roles_powers` VALUES (2, 204);
INSERT INTO `roles_powers` VALUES (2, 208);
INSERT INTO `roles_powers` VALUES (2, 302);
INSERT INTO `roles_powers` VALUES (2, 303);
INSERT INTO `roles_powers` VALUES (2, 304);
INSERT INTO `roles_powers` VALUES (2, 305);
INSERT INTO `roles_powers` VALUES (2, 403);
INSERT INTO `roles_powers` VALUES (2, 405);
INSERT INTO `roles_powers` VALUES (2, 406);
INSERT INTO `roles_powers` VALUES (2, 407);
INSERT INTO `roles_powers` VALUES (2, 104);
INSERT INTO `roles_powers` VALUES (2, 605);
INSERT INTO `roles_powers` VALUES (2, 606);
INSERT INTO `roles_powers` VALUES (2, 607);
INSERT INTO `roles_powers` VALUES (2, 608);
INSERT INTO `roles_powers` VALUES (2, 609);
INSERT INTO `roles_powers` VALUES (2, 610);
INSERT INTO `roles_powers` VALUES (2, 611);
INSERT INTO `roles_powers` VALUES (2, 612);
INSERT INTO `roles_powers` VALUES (2, 613);
INSERT INTO `roles_powers` VALUES (2, 706);
INSERT INTO `roles_powers` VALUES (2, 708);
INSERT INTO `roles_powers` VALUES (2, 101);
INSERT INTO `roles_powers` VALUES (2, 201);

SET FOREIGN_KEY_CHECKS = 1;
