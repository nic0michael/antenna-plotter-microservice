CREATE DATABASE antennad;

USE antenna;				

-- SHOW CREATE TABLE `audit`;
DROP TABLE IF EXISTS audit;
CREATE TABLE `audit` (
  `audit_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `date_created` datetime DEFAULT NULL,
  `employee_id` bigint(20) DEFAULT NULL,
  `operation_type` varchar(255) DEFAULT NULL,
  `request` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`audit_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
     


-- SHOW CREATE TABLE `employee`;  
DROP TABLE IF EXISTS employee;
CREATE TABLE `employee` (
  `employee_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `authority` varchar(255) DEFAULT NULL,
  `cellphone` varchar(255) DEFAULT NULL,
  `date_created` datetime DEFAULT NULL,
  `details` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `enabled` int(11) DEFAULT NULL,
  `fullname` varchar(255) DEFAULT NULL,
  `id_number` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `skills_category` varchar(255) DEFAULT NULL,
  `team_id` bigint(20) DEFAULT NULL,
  `telephone` varchar(255) DEFAULT NULL,
  `user_id` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`employee_id`),
  UNIQUE KEY `UK_6djefmjx26crewgafuih51sad` (`fullname`) USING HASH,
  UNIQUE KEY `UK_6tpj1vwpvfk1jljoylys4ixyp` (`id_number`) USING HASH,
  UNIQUE KEY `UK_mpps3d3r9pdvyjx3iqixi96fi` (`user_id`) USING HASH
) ENGINE=MyISAM AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

-- SHOW CREATE TABLE `antenna_gain_data`;
DROP TABLE IF EXISTS antenna_gain_data;
CREATE TABLE `antenna_gain_data` (
  `data_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `antenna_code` varchar(255) DEFAULT NULL,
  `base_antenna` varchar(255) DEFAULT NULL,
  `date_created` datetime DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `frequency` double DEFAULT NULL,
  `is_active` varchar(255) DEFAULT NULL,
  `is_base_antenna` varchar(255) DEFAULT NULL,
  `measurement_type` varchar(255) DEFAULT NULL,
  `measurement_value` double DEFAULT NULL,
  `id` bigint(20) NOT NULL,
  `antenna_data_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`data_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8; 



-- SHOW CREATE TABLE `antenna_gain_data_staging`;
DROP TABLE IF EXISTS antenna_gain_data_staging;
CREATE TABLE `antenna_gain_data_staging` (
  `data_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `antenna_code` varchar(255) DEFAULT NULL,
  `base_antenna` varchar(255) DEFAULT NULL,
  `date_created` datetime DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `frequency` double DEFAULT NULL,
  `is_active` varchar(255) DEFAULT NULL,
  `is_base_antenna` varchar(255) DEFAULT NULL,
  `measurement_type` varchar(255) DEFAULT NULL,
  `measurement_value` double DEFAULT NULL,
  `id` bigint(20) NOT NULL,
  `antenna_data_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`data_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8; 

-- SHOW CREATE TABLE `antenna_polar_data`;
DROP TABLE IF EXISTS antenna_polar_data;
CREATE TABLE `antenna_polar_data` (
  `data_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `angle` double DEFAULT NULL,
  `antenna_code` varchar(255) DEFAULT NULL,
  `base_antenna` varchar(255) DEFAULT NULL,
  `date_created` datetime DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `is_active` varchar(255) DEFAULT NULL,
  `is_base_antenna` varchar(255) DEFAULT NULL,
  `measurement_type` varchar(255) DEFAULT NULL,
  `measurement_value` double DEFAULT NULL,
  `id` bigint(20) NOT NULL,
  `antenna_data_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`data_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

 

-- SHOW CREATE TABLE `antenna_polar_data_staging`;
DROP TABLE IF EXISTS antenna_polar_data_staging;
CREATE TABLE `antenna_polar_data_staging` (
  `data_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `angle` double DEFAULT NULL,
  `antenna_code` varchar(255) DEFAULT NULL,
  `base_antenna` varchar(255) DEFAULT NULL,
  `date_created` datetime DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `is_active` varchar(255) DEFAULT NULL,
  `is_base_antenna` varchar(255) DEFAULT NULL,
  `measurement_type` varchar(255) DEFAULT NULL,
  `measurement_value` double DEFAULT NULL,
  `id` bigint(20) NOT NULL,
  `antenna_data_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`data_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- SHOW CREATE TABLE `antenna_vswr_data`;
DROP TABLE IF EXISTS antenna_vswr_data;
CREATE TABLE `antenna_vswr_data` (
  `data_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `antenna_code` varchar(255) DEFAULT NULL,
  `base_antenna` varchar(255) DEFAULT NULL,
  `date_created` datetime DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `frequency` double DEFAULT NULL,
  `is_active` varchar(255) DEFAULT NULL,
  `is_base_antenna` varchar(255) DEFAULT NULL,
  `measurement_type` varchar(255) DEFAULT NULL,
  `measurement_value` double DEFAULT NULL,
  `id` bigint(20) NOT NULL,
  `antenna_data_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`data_id`)
) ENGINE=MyISAM AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;


-- SHOW CREATE TABLE `antenna_vswr_data_staging`;
DROP TABLE IF EXISTS antenna_vswr_data_staging;
CREATE TABLE `antenna_vswr_data_staging` (
  `data_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `antenna_code` varchar(255) DEFAULT NULL,
  `base_antenna` varchar(255) DEFAULT NULL,
  `date_created` datetime DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `frequency` double DEFAULT NULL,
  `is_active` varchar(255) DEFAULT NULL,
  `is_base_antenna` varchar(255) DEFAULT NULL,
  `measurement_type` varchar(255) DEFAULT NULL,
  `measurement_value` double DEFAULT NULL,
  `id` bigint(20) NOT NULL,
  `antenna_data_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`data_id`)
) ENGINE=MyISAM AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

-- SHOW CREATE TABLE `antenna_data`;
DROP TABLE IF EXISTS antenna_data;
CREATE TABLE `antenna_data` (
  `data_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `antenna_code` varchar(255) DEFAULT NULL,
  `base_antenna` varchar(255) DEFAULT NULL,
  `date_created` datetime DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `is_active` varchar(255) DEFAULT NULL,
  `is_base_antenna` varchar(255) DEFAULT NULL,
  `stock_code` varchar(255) DEFAULT NULL,
  `id` bigint(20) NOT NULL,
  `display_value` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`data_id`),
  UNIQUE KEY `UK_92mp8ueiowvgbuakfmpdi859t` (`antenna_code`),
  UNIQUE KEY `UK_cq1n3cx9rkxgiax7mjw8t6efm` (`base_antenna`),
  UNIQUE KEY `UK_mbd386dk5ihds9nwbuax4uoaf` (`stock_code`),
  UNIQUE KEY `UK_ioc6efhkg02dwf4gsspyoyejw` (`display_value`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

alter table employee_user_story add constraint FKkexd21s49v2bf1xux0re92mq1 foreign key (user_story_id) references user_story (user_story_id);
alter table employee_user_story add constraint FKn6vtqimtcorrhdbepgjhkg7a8 foreign key (employee_id) references employee (employee_id);





