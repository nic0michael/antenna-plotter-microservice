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

-- SHOW CREATE TABLE `ant_antenna`;
DROP TABLE IF EXISTS ant_antenna;
CREATE TABLE `ant_antenna` (
  `ant_id` int(11) NOT NULL,
  `ant_code` varchar(255) DEFAULT NULL,
  `ant_date_created` datetime DEFAULT NULL,
  `ant_description` varchar(255) DEFAULT NULL,
  `ant_name` varchar(255) DEFAULT NULL,
  `ant_antenna_ant_code` int(11) DEFAULT NULL,
  `ant_type_ant_type_code` int(11) DEFAULT NULL,
  PRIMARY KEY (`ant_id`),
  KEY `FK8epwd78gienlf0yg52w7ym6p6` (`ant_antenna_ant_code`),
  KEY `FK6xcje9apa2317692cwlyxbet1` (`ant_type_ant_type_code`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4; 



-- SHOW CREATE TABLE `ant_data`;
DROP TABLE IF EXISTS ant_data;
CREATE TABLE `ant_data` (
  `dta_id` int(11) NOT NULL,
  `dta_date_created` datetime DEFAULT NULL,
  `dta_determinant` double DEFAULT NULL,
  `dta_value` double DEFAULT NULL,
  `dta_antenna_ant_code` int(11) DEFAULT NULL,
  `dta_measurement_msm_code` int(11) DEFAULT NULL,
  PRIMARY KEY (`dta_id`),
  KEY `FKqkd8975k6mgktm3q3mqpnbovn` (`dta_antenna_ant_code`),
  KEY `FKfrhipq6i7xfau73s57vrtkk5s` (`dta_measurement_msm_code`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4; 


-- SHOW CREATE TABLE `ant_measurement`;
DROP TABLE IF EXISTS ant_measurement;
CREATE TABLE `ant_measurement` (
  `msm_id` int(11) NOT NULL,
  `msm_code` varchar(255) DEFAULT NULL,
  `msm_date_created` datetime DEFAULT NULL,
  `msm_description` varchar(255) DEFAULT NULL,
  `msm_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`msm_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

 

-- SHOW CREATE TABLE `ant_type`;
DROP TABLE IF EXISTS ant_type;
CREATE TABLE `ant_type` (
  `ant_type_id` int(11) NOT NULL,
  `ant_type_code` varchar(255) DEFAULT NULL,
  `ant_type_date_created` datetime DEFAULT NULL,
  `ant_type_description` varchar(255) DEFAULT NULL,
  `ant_type_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ant_type_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;


alter table employee_user_story add constraint FKkexd21s49v2bf1xux0re92mq1 foreign key (user_story_id) references user_story (user_story_id);
alter table employee_user_story add constraint FKn6vtqimtcorrhdbepgjhkg7a8 foreign key (employee_id) references employee (employee_id);





