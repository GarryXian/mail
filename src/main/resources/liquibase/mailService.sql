CREATE TABLE  if not EXISTS  `mail_address_info` (
  `address_id` bigint(20) NOT NULL COMMENT '邮箱地址id',
  `group_id` bigint(20) DEFAULT NULL COMMENT '群组id',
  `address` varchar(500) DEFAULT NULL COMMENT '邮箱地址',
  `creation_date` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`address_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE  if not EXISTS  `mail_file_folder_path` (
  `folder_path_id` bigint(20) NOT NULL COMMENT '路径id',
  `folder_path` varchar(500) DEFAULT NULL COMMENT '文件夹绝对路径',
  `creation_date` datetime DEFAULT NULL COMMENT '创建日期',
  PRIMARY KEY (`folder_path_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


CREATE TABLE  if not EXISTS  `mail_file_info` (
  `file_id` bigint(20) NOT NULL COMMENT '附件id',
  `group_id` bigint(20) DEFAULT NULL COMMENT '邮箱群组id',
  `group_name` varchar(500) DEFAULT NULL COMMENT '邮箱群组名称',
  `batch_no` varchar(20) DEFAULT NULL COMMENT '发送批次号',
  `file_name` varchar(500) DEFAULT NULL COMMENT '附件名称',
  `file_path` varchar(500) DEFAULT NULL COMMENT '附件绝对路径',
  `creation_date` datetime DEFAULT NULL COMMENT '创建日期',
  `send_status` varchar(5) DEFAULT NULL COMMENT '发送状态',
  `send_date` datetime DEFAULT NULL COMMENT '发送时间',
  `send_msg` text COMMENT '发送回执',
  `address` varchar(500) DEFAULT NULL COMMENT '邮箱地址',
  PRIMARY KEY (`file_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


CREATE TABLE  if not EXISTS  `mail_group_info` (
  `mail_group_id` bigint(20) NOT NULL COMMENT '邮箱群组id',
  `mail_group_name` varchar(255) DEFAULT NULL COMMENT '邮箱群组名称',
  `mail_file_name` varchar(500) DEFAULT NULL COMMENT '邮箱群组对应附件名字',
  PRIMARY KEY (`mail_group_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;