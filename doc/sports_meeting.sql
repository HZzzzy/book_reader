/*
Navicat MySQL Data Transfer

Source Server         : study
Source Server Version : 50722
Source Host           : localhost:3306
Source Database       : sports_meeting

Target Server Type    : MYSQL
Target Server Version : 50722
File Encoding         : 65001

Date: 2018-10-31 19:08:29
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for apply
-- ----------------------------
DROP TABLE IF EXISTS `apply`;
CREATE TABLE `apply` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `name` varchar(32) NOT NULL COMMENT '参赛者姓名',
  `event1_id` int(10) DEFAULT NULL COMMENT '参与项目1',
  `event2_id` int(10) DEFAULT NULL COMMENT '参与项目2',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Table structure for article
-- ----------------------------
DROP TABLE IF EXISTS `article`;
CREATE TABLE `article` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `chapter_id` bigint(20) DEFAULT NULL COMMENT '对应章节id',
  `content` longtext COMMENT '文章内容',
  PRIMARY KEY (`id`),
  UNIQUE KEY `IDX_ARTICLE_CHAPTER_ID` (`chapter_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=661420 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Table structure for book
-- ----------------------------
DROP TABLE IF EXISTS `book`;
CREATE TABLE `book` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `book_name` varchar(255) DEFAULT NULL COMMENT '书名',
  `author` varchar(50) DEFAULT NULL COMMENT '作者',
  `pic` varchar(255) DEFAULT NULL COMMENT '封面图片地址',
  `is_end` char(1) DEFAULT '1' COMMENT '是否完结，1：完结；0：连载中',
  `last_update_time` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '最后更新时间',
  `new_title` varchar(255) DEFAULT NULL COMMENT '最新章节名称',
  `intro` text COMMENT '简介',
  `category_id` int(11) DEFAULT NULL COMMENT '所属分类',
  `come_from` varchar(255) DEFAULT NULL COMMENT '来源网站',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=967 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Table structure for category
-- ----------------------------
DROP TABLE IF EXISTS `category`;
CREATE TABLE `category` (
  `id` int(11) NOT NULL COMMENT '类型id',
  `category_name` varchar(255) DEFAULT NULL COMMENT '类型名称',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for chapter
-- ----------------------------
DROP TABLE IF EXISTS `chapter`;
CREATE TABLE `chapter` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `book_id` bigint(20) DEFAULT NULL COMMENT '所属书',
  `archive` varchar(255) DEFAULT NULL COMMENT '所属卷宗',
  `title` varchar(255) DEFAULT NULL COMMENT '章节名称',
  `come_from` varchar(500) DEFAULT NULL COMMENT '文章页链接',
  `words_count` int(11) DEFAULT NULL COMMENT '字数',
  PRIMARY KEY (`id`),
  KEY `IDX_CHAPTER_BOOK_ID` (`book_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=661433 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Table structure for events
-- ----------------------------
DROP TABLE IF EXISTS `events`;
CREATE TABLE `events` (
  `id` int(10) NOT NULL AUTO_INCREMENT COMMENT '1',
  `e_name` varchar(32) NOT NULL COMMENT '赛事',
  `site_id` int(11) NOT NULL COMMENT '场地id',
  `e_time` datetime DEFAULT NULL COMMENT '比赛时间',
  PRIMARY KEY (`id`),
  KEY `site_id` (`site_id`),
  CONSTRAINT `site_id` FOREIGN KEY (`site_id`) REFERENCES `site` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Table structure for site
-- ----------------------------
DROP TABLE IF EXISTS `site`;
CREATE TABLE `site` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `address` varchar(255) NOT NULL COMMENT '场地地点',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4;
