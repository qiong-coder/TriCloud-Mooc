SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for Order
-- ----------------------------
DROP TABLE IF EXISTS `Account`;
CREATE TABLE `Account` (
  `id`              INT(10) NOT NULL AUTO_INCREMENT,
  `username`        VARCHAR(20) NOT NULL COMMENT '用户名称',
  `password`        VARCHAR(20) NOT NULL COMMENT '登陆密码',
  `roles`           VARCHAR(100) NOT NULL DEFAULT "ROLE_USER" COMMENT '用户的角色',
  `status`          INT(10) NOT NULL DEFAULT 0,
  `create_time`     TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=0 DEFAULT CHARSET=utf8;

INSERT Account(username,password,roles) VALUES("admin", "admin", "ROLE_ADMIN");