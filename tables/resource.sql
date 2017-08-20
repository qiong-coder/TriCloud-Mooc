SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for Order
-- ----------------------------
DROP TABLE IF EXISTS `Resource`;
CREATE TABLE `Resource` (
  `id`              INT(10) NOT NULL AUTO_INCREMENT,
  `name`            VARCHAR(100) NOT NULL COMMENT '资源名称',
  `cid`             INT(10) NOT NULL COMMENT '课程ID',
  `attachment`      VARCHAR(100) NOT NULL COMMENT '资源连接',
  `type`            INT(10) NOT NULL COMMENT '资源类型',
  `status`          INT(10) NOT NULL DEFAULT 0,
  `modify_time`     DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `create_time`     TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=0 DEFAULT CHARSET=utf8;