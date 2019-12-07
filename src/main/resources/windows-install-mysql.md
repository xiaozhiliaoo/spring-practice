## 下载mysql8
- 下载mysql https://dev.mysql.com/downloads/mysql/
###安装 windows下安装
安装过程参考 - https://www.cnblogs.com/zhangkanghui/p/9613844.html
- mysqld --initialize-insecure --user=mysql;
- mysqld -install;   //管理员权限
- net start MySQL;
- mysql -u root -p;
- select host,user,authentication_string from mysql.user;
- alter user 'root'@'localhost' identified by '123456';
- flush privileges;

### 建立数据库
``CREATE SCHEMA `traning` DEFAULT CHARACTER SET utf8 COLLATE utf8_bin ;
``
###建立表
``CREATE TABLE `traning`.`person` (
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

CREATE TABLE `traning`.`course` (
  `id` BIGINT(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `name` VARCHAR(45) NULL COMMENT '课程名字',
  `person_id` BIGINT(11) NULL,
  `open` INT NOT NULL DEFAULT 0 COMMENT '是否开课(0：开课 1：没开课)',
  `teacher` VARCHAR(45) NULL COMMENT '老师名字',
   `gmt_create` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
   `gmt_modified` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;``

### 初始化数据
``
INSERT INTO `traning`.`person` (`name`, `age`, `sex`, `status`, `level`) VALUES ('lili', '11', 'm', '1', '1');
INSERT INTO `traning`.`person` (`name`, `age`, `sex`, `status`, `level`) VALUES ('lili2', '11', 'm', '1', '1');
INSERT INTO `traning`.`person` (`name`, `age`, `sex`, `status`, `level`) VALUES ('lili3', '11', 'm', '1', '1');
INSERT INTO `traning`.`person` (`name`, `age`, `sex`, `status`, `level`) VALUES ('lili4', '11', 'm', '1', '1');
INSERT INTO `traning`.`course` (`name`, `person_id`, `open`, `teacher`) VALUES ('语文', '1', '1', '王老师');
INSERT INTO `traning`.`course` (`name`, `person_id`, `open`, `teacher`) VALUES ('数学', '1', '0', '张老师');
INSERT INTO `traning`.`course` (`name`, `person_id`, `open`, `teacher`) VALUES ('英语', '1', '1', '李老师');
INSERT INTO `traning`.`course` (`name`, `person_id`, `open`, `teacher`) VALUES ('语文', '2', '1', '王老师');
``