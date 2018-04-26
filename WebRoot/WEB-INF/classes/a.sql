/*
SQLyog Ultimate v11.11 (32 bit)
MySQL - 5.5.15 : Database - spring_mybatis
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`spring_mybatis` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `spring_mybatis`;

/*Table structure for table `keyword` */

DROP TABLE IF EXISTS `keyword`;

CREATE TABLE `keyword` (
  `id` int(255) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `keys` varchar(255) DEFAULT NULL COMMENT '关键词',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8;

/*Data for the table `keyword` */

insert  into `keyword`(`id`,`keys`) values (1,'aaa'),(2,'a'),(3,'agg'),(4,'抢位置'),(9,'w'),(10,'1231'),(14,NULL),(15,'w'),(17,'e');

/*Table structure for table `trade_data` */

DROP TABLE IF EXISTS `trade_data`;

CREATE TABLE `trade_data` (
  `id` int(255) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `username` varchar(255) DEFAULT NULL COMMENT '账号',
  `phone` varchar(255) DEFAULT NULL COMMENT '手机',
  `time` time DEFAULT NULL COMMENT '时间',
  `content` text COMMENT '内容',
  `address` varchar(255) DEFAULT NULL COMMENT '地区',
  `supplier` varchar(255) DEFAULT NULL COMMENT '供应商',
  `reply` varchar(255) DEFAULT NULL COMMENT '回复',
  `tag` text COMMENT '标签',
  `grade` int(2) DEFAULT NULL COMMENT '等级',
  `entry_time` time DEFAULT NULL COMMENT '入库时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*Data for the table `trade_data` */

insert  into `trade_data`(`id`,`username`,`phone`,`time`,`content`,`address`,`supplier`,`reply`,`tag`,`grade`,`entry_time`) values (1,'1','1','00:00:01','1','1','1','1','1',1,'00:00:01');

/*Table structure for table `trades` */

DROP TABLE IF EXISTS `trades`;

CREATE TABLE `trades` (
  `id` int(255) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `trade` varchar(255) DEFAULT NULL COMMENT '行业',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `trades` */

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `username` varchar(100) DEFAULT NULL,
  `password` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

/*Data for the table `user` */

insert  into `user`(`id`,`username`,`password`) values (1,'222','222'),(2,'33','33');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
