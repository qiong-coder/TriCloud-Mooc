SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for Course
-- ----------------------------
DROP TABLE IF EXISTS `Course`;
CREATE TABLE `Course` (
  `id`              INT(10) NOT NULL AUTO_INCREMENT,
  `name`            VARCHAR(100) NOT NULL COMMENT '课程名称',
  `login_name`      VARCHAR(100) NOT NULL COMMENT '教师工号',
  `attachment`      VARCHAR(100) NOT NULL COMMENT '课程描述文件连接',
  `status`          INT(10) NOT NULL DEFAULT 0,
  `modify_time`     DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `create_time`     TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=0 DEFAULT CHARSET=utf8;