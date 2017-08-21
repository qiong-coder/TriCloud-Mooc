SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for CourseOrder
-- ----------------------------
DROP TABLE IF EXISTS `CourseOrder`;
CREATE TABLE `CourseOrder` (
  `id`              INT(10) NOT NULL AUTO_INCREMENT,
  `login_name`      VARCHAR(100) NOT NULL COMMENT '学生号',
  `school`          INT(10) NOT NULL COMMENT '学校',
  `cid`             INT(10) NOT NULL COMMENT '课程ID',
  `machine`         VARCHAR(256) COMMENT '分配的虚拟机信息',
  `status`          INT(10) NOT NULL DEFAULT 0,
  `modify_time`     DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `create_time`     TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=0 DEFAULT CHARSET=utf8;