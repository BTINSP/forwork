/*
 Navicat Premium Data Transfer

 Source Server         : mysql
 Source Server Type    : MySQL
 Source Server Version : 80034 (8.0.34)
 Source Host           : localhost:3306
 Source Schema         : forwork

 Target Server Type    : MySQL
 Target Server Version : 80034 (8.0.34)
 File Encoding         : 65001

 Date: 03/11/2023 12:23:36
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for class
-- ----------------------------
DROP TABLE IF EXISTS `class`;
CREATE TABLE `class` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) COLLATE utf8mb4_bin NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

-- ----------------------------
-- Records of class
-- ----------------------------
BEGIN;
INSERT INTO `class` (`id`, `name`) VALUES (1, '一班');
INSERT INTO `class` (`id`, `name`) VALUES (2, '二班');
COMMIT;

-- ----------------------------
-- Table structure for course
-- ----------------------------
DROP TABLE IF EXISTS `course`;
CREATE TABLE `course` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) COLLATE utf8mb4_bin NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

-- ----------------------------
-- Records of course
-- ----------------------------
BEGIN;
INSERT INTO `course` (`id`, `name`) VALUES (1, '化学');
INSERT INTO `course` (`id`, `name`) VALUES (2, '生物');
COMMIT;

-- ----------------------------
-- Table structure for report
-- ----------------------------
DROP TABLE IF EXISTS `report`;
CREATE TABLE `report` (
  `id` int NOT NULL AUTO_INCREMENT,
  `student_id` int NOT NULL,
  `course_id` int NOT NULL,
  `point` int NOT NULL,
  `create_time` timestamp NOT NULL,
  `update_time` timestamp NOT NULL ON UPDATE CURRENT_TIMESTAMP,
  `is_delete` tinyint NOT NULL DEFAULT '0' COMMENT '0未删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

-- ----------------------------
-- Records of report
-- ----------------------------
BEGIN;
INSERT INTO `report` (`id`, `student_id`, `course_id`, `point`, `create_time`, `update_time`, `is_delete`) VALUES (1, 4, 1, 123, '2023-11-02 21:11:02', '2023-11-02 14:14:00', 0);
INSERT INTO `report` (`id`, `student_id`, `course_id`, `point`, `create_time`, `update_time`, `is_delete`) VALUES (2, 2, 1, 91, '2023-11-02 21:11:18', '2023-11-02 15:47:39', 1);
INSERT INTO `report` (`id`, `student_id`, `course_id`, `point`, `create_time`, `update_time`, `is_delete`) VALUES (3, 3, 1, 123, '2023-11-02 14:29:09', '2023-11-02 15:45:52', 1);
INSERT INTO `report` (`id`, `student_id`, `course_id`, `point`, `create_time`, `update_time`, `is_delete`) VALUES (4, 1, 1, 100, '2023-11-02 15:48:44', '2023-11-02 15:48:44', 0);
INSERT INTO `report` (`id`, `student_id`, `course_id`, `point`, `create_time`, `update_time`, `is_delete`) VALUES (5, 1, 1, 200, '2023-11-02 15:48:47', '2023-11-02 15:48:47', 0);
INSERT INTO `report` (`id`, `student_id`, `course_id`, `point`, `create_time`, `update_time`, `is_delete`) VALUES (6, 1, 1, 500, '2023-11-02 15:48:49', '2023-11-02 15:48:58', 1);
COMMIT;

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `sex` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `class_id` int NOT NULL,
  `create_time` timestamp NOT NULL,
  `update_time` timestamp NOT NULL ON UPDATE CURRENT_TIMESTAMP,
  `is_delete` tinyint NOT NULL DEFAULT '0' COMMENT '0未删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

-- ----------------------------
-- Records of student
-- ----------------------------
BEGIN;
INSERT INTO `student` (`id`, `name`, `sex`, `class_id`, `create_time`, `update_time`, `is_delete`) VALUES (1, '小明', '男', 1, '2023-11-02 09:02:40', '2023-11-02 13:58:26', 0);
INSERT INTO `student` (`id`, `name`, `sex`, `class_id`, `create_time`, `update_time`, `is_delete`) VALUES (2, '小狗', '男', 2, '2023-11-02 09:02:43', '2023-11-02 13:00:24', 0);
INSERT INTO `student` (`id`, `name`, `sex`, `class_id`, `create_time`, `update_time`, `is_delete`) VALUES (3, '测试', '男', 2, '2023-11-02 12:42:14', '2023-11-02 13:00:09', 0);
INSERT INTO `student` (`id`, `name`, `sex`, `class_id`, `create_time`, `update_time`, `is_delete`) VALUES (4, '测试1', '女', 1, '2023-11-02 12:43:09', '2023-11-02 13:00:13', 0);
COMMIT;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int NOT NULL AUTO_INCREMENT,
  `username` varchar(255) COLLATE utf8mb4_bin NOT NULL,
  `password` varchar(255) COLLATE utf8mb4_bin NOT NULL,
  `role` int DEFAULT '0',
  `create_time` timestamp NOT NULL ON UPDATE CURRENT_TIMESTAMP,
  `update_time` timestamp NOT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

-- ----------------------------
-- Records of user
-- ----------------------------
BEGIN;
INSERT INTO `user` (`id`, `username`, `password`, `role`, `create_time`, `update_time`) VALUES (1, 'root', 'root', 0, '2023-11-02 14:22:44', '2023-11-02 14:22:46');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
