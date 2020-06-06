/*
 Navicat Premium Data Transfer

 Source Server         : StopHumble
 Source Server Type    : MySQL
 Source Server Version : 50728
 Source Host           : localhost:3306
 Source Schema         : cdio

 Target Server Type    : MySQL
 Target Server Version : 50728
 File Encoding         : 65001

 Date: 06/06/2020 10:25:33
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for authority
-- ----------------------------
DROP TABLE IF EXISTS `authority`;
CREATE TABLE `authority`  (
  `authority_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '权限id',
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '权限名称',
  PRIMARY KEY (`authority_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of authority
-- ----------------------------
INSERT INTO `authority` VALUES (0, 'ROLE_ROOT');
INSERT INTO `authority` VALUES (1, 'ROLE_ADMIN');
INSERT INTO `authority` VALUES (2, 'ROLE_USER');

-- ----------------------------
-- Table structure for cars
-- ----------------------------
DROP TABLE IF EXISTS `cars`;
CREATE TABLE `cars`  (
  `car_id` int(10) NOT NULL AUTO_INCREMENT COMMENT '车辆id',
  `car_category` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '车辆型号',
  `car_card` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '车牌号',
  `vehicle_id` int(10) NULL DEFAULT NULL COMMENT '车主id',
  `driver` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '司机姓名',
  `phone` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '司机联系电话',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `create_by` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '创建者',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `update_by` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '更新者',
  `status` int(2) NULL DEFAULT NULL,
  `remark` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`car_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of cars
-- ----------------------------
INSERT INTO `cars` VALUES (1, '重汽', '京A88888', NULL, '李三', '5844110', '2020-04-29 15:13:17', 'admin', NULL, NULL, 1, NULL);
INSERT INTO `cars` VALUES (2, '重汽', '冀B 77777', NULL, '王五', '17831000687', '2020-06-05 10:54:41', 'admin', NULL, NULL, 1, NULL);
INSERT INTO `cars` VALUES (3, '重汽', '冀B77990', NULL, '叶天', '17831000688', '2020-06-05 10:56:36', 'admin', NULL, NULL, 1, NULL);

-- ----------------------------
-- Table structure for category
-- ----------------------------
DROP TABLE IF EXISTS `category`;
CREATE TABLE `category`  (
  `category_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '商品种类ID',
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '商品种类名称',
  `status` int(2) NULL DEFAULT NULL COMMENT '状态',
  `remarks` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`category_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 21 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of category
-- ----------------------------
INSERT INTO `category` VALUES (12, '杜虹池', 0, '真不是个东西安大安市打算大声道阿萨德');
INSERT INTO `category` VALUES (13, 'ilcy1998', 0, '就是个玩具而已呀');
INSERT INTO `category` VALUES (14, '铁板', 1, '铁板');
INSERT INTO `category` VALUES (15, '铆钉', 1, '各种型号大小');
INSERT INTO `category` VALUES (16, '焊机', 1, '各品牌/大小/类型');
INSERT INTO `category` VALUES (17, '插口板手', 1, '各种型号大小的扳手');
INSERT INTO `category` VALUES (18, '圆口扳手', 1, '圆口的型号扳手');
INSERT INTO `category` VALUES (19, '龙门吊', 1, '20吨承重');
INSERT INTO `category` VALUES (20, '切割机', 1, '小型一体式切割机');

-- ----------------------------
-- Table structure for employee
-- ----------------------------
DROP TABLE IF EXISTS `employee`;
CREATE TABLE `employee`  (
  `employee_id` int(10) NOT NULL AUTO_INCREMENT COMMENT '员工id',
  `employee_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '员工姓名',
  `sex` int(2) NULL DEFAULT NULL COMMENT '性别：0：男 1：女',
  `phone` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '联系电话',
  `idcard` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '身份证号',
  `status` int(2) NULL DEFAULT NULL COMMENT '状态 0：离职 1：在职',
  `address` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '地址',
  `create_time` datetime(0) NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(0),
  `create_by` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `update_time` datetime(0) NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(0),
  `update_by` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `remark` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`employee_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of employee
-- ----------------------------
INSERT INTO `employee` VALUES (1, 'MING QIN', 1, '17831000687', '13022719980510027', 0, '3766 Ripple Street, Saginaw Michigan', '2020-04-25 20:08:51', NULL, '2020-04-25 20:08:56', NULL, '阿斯顿撒');
INSERT INTO `employee` VALUES (2, '杜虹池', 1, '18830520372', '1302271998051002', 1, '河北唐山', '2020-05-24 03:20:21', NULL, '2020-05-24 03:20:22', 'admin', '你说得对');
INSERT INTO `employee` VALUES (3, '张三', 1, '5844110', '13022719980510024', 1, '3766 Ripple', '2020-04-25 21:52:06', NULL, '2020-04-25 21:52:06', 'admin', '啊啊啊啊啊');
INSERT INTO `employee` VALUES (4, '李四', 1, '5844227', '1302271998051002', 1, '3766 Ripple', NULL, NULL, NULL, NULL, '撒大声地');
INSERT INTO `employee` VALUES (5, '张天爱', 1, '17831000687', '1302271998051002', 1, '北京', '2020-04-25 21:54:05', 'admin', '2020-04-25 21:54:06', 'admin', 'plmm我爱你');
INSERT INTO `employee` VALUES (6, '王五', 1, '17831000687', '130227199805', 1, '撒打算打算', '2020-05-24 03:13:37', 'admin', '2020-05-24 03:13:37', 'admin', '');

-- ----------------------------
-- Table structure for grade
-- ----------------------------
DROP TABLE IF EXISTS `grade`;
CREATE TABLE `grade`  (
  `grade_id` int(2) NOT NULL AUTO_INCREMENT COMMENT '评级id',
  `employee_id` int(2) NULL DEFAULT NULL COMMENT '员工id',
  `valuation` int(2) NULL DEFAULT NULL COMMENT '评价分数（0：不行1：勉强2：不错3：很好）',
  `content` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '具体评价',
  `create_time` datetime(0) NULL DEFAULT NULL,
  `create_by` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `update_time` datetime(0) NULL DEFAULT NULL,
  `update_by` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `remark` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`grade_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 14 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of grade
-- ----------------------------
INSERT INTO `grade` VALUES (1, NULL, 10, '阿达', '2020-04-26 14:54:08', 'admin', NULL, NULL, '飒飒');
INSERT INTO `grade` VALUES (2, NULL, 5, '1111', '2020-04-26 14:59:28', 'admin', NULL, NULL, '2222');
INSERT INTO `grade` VALUES (3, NULL, 10, '1111', '2020-04-26 15:18:50', 'admin', NULL, NULL, '撒大声地');
INSERT INTO `grade` VALUES (4, NULL, 5, '你好好嗷嗷', '2020-04-26 15:27:10', 'admin', NULL, NULL, '设置备注');
INSERT INTO `grade` VALUES (5, NULL, 6, '安顺达杀手', '2020-04-26 15:47:24', 'admin', NULL, NULL, '阿大多数');
INSERT INTO `grade` VALUES (6, NULL, 7, '777777', '2020-04-26 15:50:47', 'admin', NULL, NULL, 'nihao');
INSERT INTO `grade` VALUES (7, NULL, 8, '1111', '2020-04-26 15:52:49', 'admin', NULL, NULL, '撒大声地');
INSERT INTO `grade` VALUES (8, NULL, 10, '无敌', '2020-04-26 15:54:39', 'admin', NULL, NULL, '撒大声地');
INSERT INTO `grade` VALUES (9, 4, 6, '是一个好好工作的人', '2020-04-26 16:04:31', 'admin', '2020-05-24 03:26:18', 'admin', '没什么呢好说的');
INSERT INTO `grade` VALUES (13, 5, 5, '你好好', '2020-05-20 15:39:13', 'admin', '2020-05-20 15:39:13', 'admin', 'nihao');

-- ----------------------------
-- Table structure for product
-- ----------------------------
DROP TABLE IF EXISTS `product`;
CREATE TABLE `product`  (
  `product_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '商品id',
  `category_id` int(11) NOT NULL DEFAULT 0 COMMENT '商品种类id',
  `product_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '商品名称',
  `price` double(10, 2) NULL DEFAULT NULL COMMENT '商品单价（11.00）',
  `count` int(20) NULL DEFAULT 0 COMMENT ' 商品库存量',
  `image` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '商品图片的url',
  `date` datetime(0) NULL DEFAULT NULL COMMENT '商品的上架时间',
  `factory` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '该商品的生产厂家',
  `sales` int(20) NULL DEFAULT 0 COMMENT '该商品的销量',
  `status` int(10) NOT NULL DEFAULT 0 COMMENT '该商品的上下架状态（0表示下架/1表示上架）',
  `is_effective` int(10) NOT NULL DEFAULT 0 COMMENT ' 该商品是否有效（0表示无效/1表示有效）',
  `remarks` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备住',
  PRIMARY KEY (`product_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 82 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of product
-- ----------------------------
INSERT INTO `product` VALUES (65, 12, '娃娃', 1111.00, 20, '250d8c8d7e8c4ff5956bccca2cb61b9d.jpeg', '2020-04-20 17:20:59', '东京hot', 0, 1, 0, 'yige haorn');
INSERT INTO `product` VALUES (66, 12, '金锣玉米肠', 2312.00, 23, '1b8466d505d44766a6dc5e4af65948bd.jpg', '2020-04-25 13:11:28', '东京hot', 0, 1, 0, '就是是是');
INSERT INTO `product` VALUES (67, 13, '辣条', 2312.00, 20, '44b65c92d7634be4b82d276bbbc7b913.jpg', '2020-04-26 15:28:24', '东京hot', 0, 1, 0, '就是是是');
INSERT INTO `product` VALUES (68, 13, '被子', 1111.00, 20, '4828a74bc5404dbd8ed9f9a2afd858b9.jpg', '2020-04-26 15:55:55', '东京hot', 0, 1, 0, '啊啊啊');
INSERT INTO `product` VALUES (69, 12, '被子', 2312.00, 20, '1326fe5ad0824ab0973e280064df7443.jpg', '2020-04-26 15:58:50', '东京hot', 0, 1, 0, '阿萨飒飒');
INSERT INTO `product` VALUES (70, 12, '阿萨飒飒', 1111.00, 20, '763aedf1365b4063ab79d29d9751d66e.jpg', '2020-04-26 15:59:30', '东京hot', 0, 1, 0, '事实上飒飒');
INSERT INTO `product` VALUES (71, 14, '200*100型铁板', 50.00, 100, '53a0056f046c4cc4922bd2bd0d030e77.jpg', '2020-04-26 17:11:30', '津西铁厂', 0, 1, 1, '阿萨飒飒');
INSERT INTO `product` VALUES (72, 14, '180*70', 45.00, 70, NULL, '2020-04-26 17:12:59', '津西铁厂', 0, 1, 1, '');
INSERT INTO `product` VALUES (73, 15, '10mm铆钉', 1.20, 100, 'c1622cea3db34bea98ad696ab6fbf7df.jpg', '2020-05-02 10:35:14', '遵化材料厂', 0, 1, 1, '10mm铆钉');
INSERT INTO `product` VALUES (74, 16, '二保焊焊机', 24000.00, 2, NULL, '2020-05-02 10:36:04', '松下', 0, 1, 1, '二保焊焊机');
INSERT INTO `product` VALUES (75, 19, '龙门吊', 150000.00, 1, NULL, '2020-05-02 10:41:52', '自行组装', 0, 1, 1, '20吨承重');
INSERT INTO `product` VALUES (76, 17, '17mm叉口扳手', 50.00, 20, '7884785cc1164ec19802c901aba22977.png', '2020-05-12 10:47:20', '沙河', 0, 1, 1, '');
INSERT INTO `product` VALUES (77, 18, '16mm圆口扳手', 12.00, 30, '0757580bf1694432a9c13ecf335f15ee.jpg', '2020-05-20 08:44:14', '津西铁厂', 0, 1, 1, '');
INSERT INTO `product` VALUES (78, 20, '固定式中小型切割机', 2312.00, 5, NULL, '2020-05-20 12:17:45', '松下', 0, 1, 1, '');
INSERT INTO `product` VALUES (79, 15, '7mm铆钉', 12.00, 100, NULL, '2020-05-20 12:18:26', '津西铁厂', 0, 1, 1, '');
INSERT INTO `product` VALUES (80, 15, '5mm铆钉', 7.00, 70, NULL, '2020-05-20 12:19:07', '津西铁厂', 0, 1, 1, '');
INSERT INTO `product` VALUES (81, 15, '12mm铆钉', 2.50, 100, '1947daf11fdf4410a4d3ae89da40c3b2.jpg', '2020-05-20 12:19:51', '松下', 0, 1, 1, '');

-- ----------------------------
-- Table structure for salary
-- ----------------------------
DROP TABLE IF EXISTS `salary`;
CREATE TABLE `salary`  (
  `salary_id` int(10) NOT NULL AUTO_INCREMENT COMMENT '工资id',
  `status` int(2) NULL DEFAULT NULL COMMENT '账目类型（0：支出 1：收入）',
  `title` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '账目标题',
  `content` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '账目内容',
  `total` double(20, 0) NULL DEFAULT NULL COMMENT '账目金额',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `create_by` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '创建者',
  `update_by` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '更新者',
  `remark` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`salary_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 10 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of salary
-- ----------------------------
INSERT INTO `salary` VALUES (1, NULL, NULL, NULL, NULL, '2020-04-30 17:02:44', NULL, 'admin', NULL, NULL);
INSERT INTO `salary` VALUES (2, NULL, NULL, NULL, NULL, '2020-04-30 17:02:47', NULL, 'admin', NULL, NULL);
INSERT INTO `salary` VALUES (3, NULL, NULL, NULL, NULL, '2020-04-30 17:03:14', NULL, 'admin', NULL, NULL);
INSERT INTO `salary` VALUES (4, 0, '员工工资', '5名员工工资支出+年底奖金', 54000, '2020-04-30 17:05:52', '2020-05-19 13:13:33', 'admin', 'admin', '结清');
INSERT INTO `salary` VALUES (5, 0, '4月工资支出', '4月工资支出', 54000, '2020-05-02 10:42:45', '2020-05-19 13:13:44', 'admin', 'admin', '4月工资支出 结清');
INSERT INTO `salary` VALUES (6, 1, '做车斗', '4月份制作车斗6个', 120000, '2020-05-02 10:44:05', '2020-05-19 13:14:19', 'admin', 'admin', '4月份制作车斗6个 进账12000元');
INSERT INTO `salary` VALUES (7, 1, '油箱', '制作挂车油箱两个', 1200, '2020-05-02 10:45:05', '2020-05-19 13:14:43', 'admin', 'admin', '零散收入1200元');
INSERT INTO `salary` VALUES (8, 0, '4月份材料', '漆料5桶、防锈漆10桶、氧气30罐', 5000, '2020-05-02 10:46:47', '2020-05-19 13:14:58', 'admin', 'admin', '氧气消耗略多');
INSERT INTO `salary` VALUES (9, 0, '电费', '上月电费总额', 800, '2020-06-05 11:14:15', '2020-06-05 11:14:15', 'admin', 'admin', '');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `user_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户id',
  `username` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户名',
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户密码',
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '姓名（默认为用户名）',
  `birth` datetime(0) NULL DEFAULT NULL COMMENT '生日',
  `email` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '邮箱',
  `register_time` datetime(0) NOT NULL COMMENT '注册时间',
  `phone` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '手机号',
  `sex` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '3' COMMENT '性别',
  `portrait_url` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '拥有默认头像，后期添加',
  `address` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '地址',
  `postcode` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '邮编',
  `is_effective` int(11) NOT NULL DEFAULT 1 COMMENT '能否购物\n1为能\n0为否',
  PRIMARY KEY (`user_id`) USING BTREE,
  UNIQUE INDEX `username_UNIQUE`(`username`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('41e242a1ee824d0da9d07b3a43645c63', 'root1', '2a1aad7bc437ce604df21138d303765d', 'root1', '1998-05-10 00:00:00', 'dhcbukaixin@qq.com', '2020-04-24 10:22:37', NULL, '3', 'df6f35db59bc4e6fb5414d1a8d0acd7d.jpg', NULL, NULL, 1);
INSERT INTO `user` VALUES ('67c4c973e0a04c7181a58e31ee9fa52a', 'admin', '2a1aad7bc437ce604df21138d303765d', '杜虹池', '1111-02-02 00:00:00', 'dhcbukaixin@qq.com', '2020-04-20 17:13:30', '17831000687', '1', 'cf485250f1994492a243a54a58838dc1.jpg', '3766 Ripple Street, Saginaw Michigan', '48607', 1);

-- ----------------------------
-- Table structure for user_authority
-- ----------------------------
DROP TABLE IF EXISTS `user_authority`;
CREATE TABLE `user_authority`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户权限表id',
  `user_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户ID',
  `authority_id` int(11) NOT NULL COMMENT '权限ID',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `authority_id`(`authority_id`) USING BTREE,
  INDEX `user_id`(`user_id`) USING BTREE,
  CONSTRAINT `user_authority_ibfk_1` FOREIGN KEY (`authority_id`) REFERENCES `authority` (`authority_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `user_authority_ibfk_2` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 28 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user_authority
-- ----------------------------
INSERT INTO `user_authority` VALUES (1, '67c4c973e0a04c7181a58e31ee9fa52a', 0);
INSERT INTO `user_authority` VALUES (2, '67c4c973e0a04c7181a58e31ee9fa52a', 1);
INSERT INTO `user_authority` VALUES (3, '41e242a1ee824d0da9d07b3a43645c63', 2);
INSERT INTO `user_authority` VALUES (27, '41e242a1ee824d0da9d07b3a43645c63', 1);

-- ----------------------------
-- Table structure for vehicle_owner
-- ----------------------------
DROP TABLE IF EXISTS `vehicle_owner`;
CREATE TABLE `vehicle_owner`  (
  `vehicle_id` int(10) NOT NULL AUTO_INCREMENT COMMENT '车主id',
  `vehicle_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '车主姓名',
  `car_id` int(10) NULL DEFAULT NULL COMMENT '所有车的id',
  `phone` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '联系电话',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `create_by` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '创建者',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时键',
  `update_by` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '更新者',
  `status` int(2) NULL DEFAULT NULL COMMENT '状态',
  `remark` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`vehicle_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of vehicle_owner
-- ----------------------------
INSERT INTO `vehicle_owner` VALUES (1, '张三', 1, '5844110', '2020-04-29 15:32:13', 'admin', NULL, NULL, 1, 'nihao');
INSERT INTO `vehicle_owner` VALUES (2, '李四', 1, '18830520372', '2020-06-05 10:30:54', 'admin', NULL, NULL, 1, 'nihao');
INSERT INTO `vehicle_owner` VALUES (3, '李四', 2, '18830520372', '2020-06-05 10:59:18', 'admin', NULL, NULL, 1, 'nihao');

-- ----------------------------
-- Table structure for works
-- ----------------------------
DROP TABLE IF EXISTS `works`;
CREATE TABLE `works`  (
  `work_id` int(10) NOT NULL AUTO_INCREMENT COMMENT '业务id',
  `work_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '业务名称',
  `car_card` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '车牌号',
  `content` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '业务内容',
  `price` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '预期收费',
  `working_time` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '预期工时',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `create_by` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '创建者',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `update_by` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '更新者',
  `status` int(2) NULL DEFAULT NULL,
  `remark` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`work_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of works
-- ----------------------------
INSERT INTO `works` VALUES (1, '焊大梁', '京A88888', '挂车焊接大梁', '1111', '5小时', '2020-05-01 14:58:32', 'admin', NULL, NULL, 1, 'nihao');
INSERT INTO `works` VALUES (2, '做车斗', '冀B 77777', '车斗三个', '6000', '一个星期', '2020-05-02 10:48:30', 'admin', NULL, NULL, 1, '');

-- ----------------------------
-- View structure for c_p
-- ----------------------------
DROP VIEW IF EXISTS `c_p`;
CREATE ALGORITHM = UNDEFINED SQL SECURITY DEFINER VIEW `c_p` AS select `category`.`category_id` AS `category_id`,`category`.`name` AS `name`,`product`.`product_id` AS `product_id`,`product`.`product_name` AS `product_name`,`product`.`price` AS `price`,`product`.`count` AS `count`,`product`.`image` AS `image`,`product`.`factory` AS `factory`,`product`.`date` AS `date`,`product`.`sales` AS `sales`,`product`.`status` AS `status`,`product`.`is_effective` AS `is_effective`,`product`.`remarks` AS `remarks` from (`category` join `product`);

-- ----------------------------
-- View structure for e_g
-- ----------------------------
DROP VIEW IF EXISTS `e_g`;
CREATE ALGORITHM = UNDEFINED SQL SECURITY DEFINER VIEW `e_g` AS select `employee`.`employee_id` AS `employee_id`,`employee`.`employee_name` AS `employee_name`,`grade`.`grade_id` AS `grade_id`,`grade`.`valuation` AS `valuation`,`grade`.`content` AS `content`,`grade`.`create_time` AS `create_time`,`grade`.`create_by` AS `create_by`,`grade`.`update_time` AS `update_time`,`grade`.`update_by` AS `update_by`,`grade`.`remark` AS `remark` from (`employee` join `grade`);

-- ----------------------------
-- View structure for grade_view
-- ----------------------------
DROP VIEW IF EXISTS `grade_view`;
CREATE ALGORITHM = UNDEFINED SQL SECURITY DEFINER VIEW `grade_view` AS select `b`.`employee_name` AS `employee_name`,`a`.`grade_id` AS `grade_id`,`a`.`employee_id` AS `employee_id`,`a`.`valuation` AS `valuation`,`a`.`content` AS `content`,`a`.`create_time` AS `create_time`,`a`.`create_by` AS `create_by`,`a`.`update_time` AS `update_time`,`a`.`update_by` AS `update_by`,`a`.`remark` AS `remark` from (`grade` `a` join `employee` `b`) where (`a`.`employee_id` = `b`.`employee_id`);

-- ----------------------------
-- View structure for product_view
-- ----------------------------
DROP VIEW IF EXISTS `product_view`;
CREATE ALGORITHM = UNDEFINED SQL SECURITY DEFINER VIEW `product_view` AS select `b`.`name` AS `category_name`,`a`.`product_id` AS `product_id`,`a`.`category_id` AS `category_id`,`a`.`product_name` AS `product_name`,`a`.`price` AS `price`,`a`.`count` AS `count`,`a`.`image` AS `image`,`a`.`date` AS `date`,`a`.`factory` AS `factory`,`a`.`sales` AS `sales`,`a`.`status` AS `status`,`a`.`is_effective` AS `is_effective`,`a`.`remarks` AS `remarks` from (`product` `a` join `category` `b`) where (`a`.`category_id` = `b`.`category_id`);

-- ----------------------------
-- View structure for vehicle_view
-- ----------------------------
DROP VIEW IF EXISTS `vehicle_view`;
CREATE ALGORITHM = UNDEFINED SQL SECURITY DEFINER VIEW `vehicle_view` AS select `b`.`car_card` AS `car_card`,`a`.`vehicle_id` AS `vehicle_id`,`a`.`car_id` AS `car_id`,`a`.`vehicle_name` AS `vehicle_name`,`a`.`phone` AS `phone`,`a`.`create_time` AS `create_time`,`a`.`create_by` AS `create_by`,`a`.`update_time` AS `update_time`,`a`.`update_by` AS `update_by`,`a`.`status` AS `status`,`a`.`remark` AS `remark` from (`vehicle_owner` `a` join `cars` `b`) where (`a`.`car_id` = `b`.`car_id`);

-- ----------------------------
-- Procedure structure for proc_sql
-- ----------------------------
DROP PROCEDURE IF EXISTS `proc_sql`;
delimiter ;;
CREATE PROCEDURE `proc_sql`(in nid1 INT,
  in nid2 INT,
  in callsql VARCHAR(255))
BEGIN
  set @nid1 = nid1;
  set @nid2 = nid2;
  set @callsql = callsql;
    PREPARE myprod FROM @callsql;
--   PREPARE prod FROM 'select * from product where product_id>? and product_id<?';  传入的值为字符串，？为占位符
--   用@p1，和@p2填充占位符
    EXECUTE myprod USING @nid1,@nid2;
  DEALLOCATE prepare myprod;
 
END
;;
delimiter ;

SET FOREIGN_KEY_CHECKS = 1;
