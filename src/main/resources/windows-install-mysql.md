**mysql-8.0.18-winx64.zip**
install - https://www.cnblogs.com/zhangkanghui/p/9613844.html
mysqld --initialize-insecure --user=mysql;
mysqld -install;   //管理员权限
net start MySQL;
mysql -u root -p;
select host,user,authentication_string from mysql.user;
alter user 'root'@'localhost' identified by '123456';
flush privileges;

CREATE SCHEMA `traning` DEFAULT CHARACTER SET utf8 COLLATE utf8_bin ;


CREATE TABLE `traning`.`person` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `name` varchar(20) NOT NULL COMMENT '姓名',
  `age` varchar(20) DEFAULT NULL COMMENT '年龄',
  `sex` varchar(2) NOT NULL DEFAULT 'm' COMMENT '性别(m:男 w:女)',
  `status` int(2) NOT NULL DEFAULT '1' COMMENT '活动状态1：在活动 0：不在活动\nl',
  `level` int(2) NOT NULL DEFAULT '1' COMMENT '等级:0 初级 1 中级 2 高级',
  `gmt_create` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `gmt_modified` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8

INSERT INTO `traning`.`person` (`name`, `age`, `sex`, `status`, `level`) VALUES ('lili', '11', 'm', '1', '1');
INSERT INTO `traning`.`person` (`name`, `age`, `sex`, `status`, `level`) VALUES ('lili2', '11', 'm', '1', '1');
INSERT INTO `traning`.`person` (`name`, `age`, `sex`, `status`, `level`) VALUES ('lili3', '11', 'm', '1', '1');
INSERT INTO `traning`.`person` (`name`, `age`, `sex`, `status`, `level`) VALUES ('lili4', '11', 'm', '1', '1');

  