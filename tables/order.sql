SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for Order
-- ----------------------------
DROP TABLE IF EXISTS `Order`;
CREATE TABLE `Order` (
  `id`              INT(10) NOT NULL AUTO_INCREMENT,
  `login_name`      VARCHAR(100) NOT NULL COMMENT '学生号',
  `school`          INT(10) NOT NULL COMMENT '学校',
  `cid`             INT(10) NOT NULL COMMENT '课程ID',
  `machine`         TEXT COMMENT '分配的虚拟机信息',
  `status`          INT(10) NOT NULL DEFAULT 0,
  `modify_time`     DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `create_time`     TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=0 DEFAULT CHARSET=utf8;