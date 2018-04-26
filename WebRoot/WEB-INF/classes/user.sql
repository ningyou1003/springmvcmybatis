/*
Navicat MySQL Data Transfer

Source Server         : mysql
Source Server Version : 60002
Source Host           : localhost:3306
Source Database       : test

Target Server Type    : MYSQL
Target Server Version : 60002
File Encoding         : 65001

Date: 2013-11-20 14:45:41
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `user`
-- ----------------------------

/*创建test数据库*/
drop database if exists test;
create database test;
use test;
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `username` varchar(100) DEFAULT NULL,
  `password` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', '222', '222');