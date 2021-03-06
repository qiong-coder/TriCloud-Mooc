SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for Account
-- ----------------------------
DROP TABLE IF EXISTS `Account`;
CREATE TABLE `Account` (
  `id`              INT(10) NOT NULL AUTO_INCREMENT,
  `login_name`      VARCHAR(100) NOT NULL COMMENT '用户登陆名称',
  `username`        VARCHAR(100) NOT NULL COMMENT '用户名称',
  `password`        VARCHAR(100) NOT NULL COMMENT '登陆密码',
  `roles`           VARCHAR(100) NOT NULL DEFAULT "ROLE_STUDENT" COMMENT '用户的角色',
  `school`          INT(10) NOT NULL COMMENT '学校编号',
  `status`          INT(10) NOT NULL DEFAULT 0,
  `create_time`     TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=0 DEFAULT CHARSET=utf8;

CREATE INDEX id_number_index ON Account(login_name);

INSERT Account(login_name,username,password,roles,school) VALUES("administrator","administrator", "administrator", "ROLE_ADMIN", 0);