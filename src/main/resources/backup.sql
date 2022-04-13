-- --------------------------------------------------------
-- 호스트:                          35.188.6.143
-- 서버 버전:                        10.4.10-MariaDB - MariaDB Server
-- 서버 OS:                        Linux
-- HeidiSQL 버전:                  10.2.0.5599
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

-- 테이블 dev_demo.auth_group 구조 내보내기
DROP TABLE IF EXISTS `auth_group`;
CREATE TABLE IF NOT EXISTS `auth_group` (
  `auth_id` char(32) NOT NULL,
  `center_id` varchar(255) DEFAULT NULL,
  `group_name` varchar(255) DEFAULT NULL,
  `mod_dd` datetime DEFAULT NULL,
  `mod_id` varchar(255) DEFAULT NULL,
  `reg_dd` datetime DEFAULT NULL,
  `reg_id` varchar(255) DEFAULT NULL,
  `user_id` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`auth_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 테이블 데이터 dev_demo.auth_group:~0 rows (대략적) 내보내기
/*!40000 ALTER TABLE `auth_group` DISABLE KEYS */;
/*!40000 ALTER TABLE `auth_group` ENABLE KEYS */;

-- 테이블 dev_demo.board 구조 내보내기
DROP TABLE IF EXISTS `board`;
CREATE TABLE IF NOT EXISTS `board` (
  `board_id` char(32) NOT NULL,
  `board_order` int(11) DEFAULT NULL,
  `board_type` int(11) DEFAULT NULL,
  `center_id` varchar(255) DEFAULT NULL,
  `content` longtext DEFAULT NULL,
  `hit` int(11) DEFAULT NULL,
  `mod_dd` datetime DEFAULT NULL,
  `mod_id` varchar(255) DEFAULT NULL,
  `reg_dd` datetime DEFAULT NULL,
  `reg_id` varchar(255) DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  `use_yn` varchar(255) DEFAULT NULL,
  `group_id` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`board_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 테이블 데이터 dev_demo.board:~1 rows (대략적) 내보내기
/*!40000 ALTER TABLE `board` DISABLE KEYS */;
/*!40000 ALTER TABLE `board` ENABLE KEYS */;

-- 테이블 dev_demo.center 구조 내보내기
DROP TABLE IF EXISTS `center`;
CREATE TABLE IF NOT EXISTS `center` (
  `center_id` char(32) NOT NULL,
  `address` varchar(255) DEFAULT NULL,
  `director_id` varchar(255) DEFAULT NULL,
  `imgae_id` varchar(255) DEFAULT NULL,
  `mod_dd` datetime DEFAULT NULL,
  `mod_id` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `reg_dd` datetime DEFAULT NULL,
  `reg_id` varchar(255) DEFAULT NULL,
  `remarks` longtext DEFAULT NULL,
  `tel` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`center_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 테이블 데이터 dev_demo.center:~1 rows (대략적) 내보내기
/*!40000 ALTER TABLE `center` DISABLE KEYS */;
INSERT INTO `center` (`center_id`, `address`, `director_id`, `imgae_id`, `mod_dd`, `mod_id`, `name`, `reg_dd`, `reg_id`, `remarks`, `tel`) VALUES
	('dev_center', NULL, NULL, NULL, NULL, 'admin', NULL, '2019-11-07 13:51:45', 'admin', NULL, NULL);
/*!40000 ALTER TABLE `center` ENABLE KEYS */;

-- 테이블 dev_demo.center_config 구조 내보내기
DROP TABLE IF EXISTS `center_config`;
CREATE TABLE IF NOT EXISTS `center_config` (
  `center_config_id` char(32) NOT NULL,
  `attendance_public_time` int(11) DEFAULT NULL,
  `attendance_public_unit` int(11) DEFAULT NULL,
  `center_id` varchar(255) DEFAULT NULL,
  `maturity_time` int(11) DEFAULT NULL,
  `maturity_unit` int(11) DEFAULT NULL,
  `mod_dd` datetime DEFAULT NULL,
  `mod_id` varchar(50) DEFAULT NULL,
  `reg_dd` datetime DEFAULT NULL,
  `reg_id` varchar(50) DEFAULT NULL,
  `reserv_cancle_time` int(11) DEFAULT NULL,
  `reserv_cancle_unit` int(11) DEFAULT NULL,
  `reserv_modify_time` int(11) DEFAULT NULL,
  `reserv_modify_unit` int(11) DEFAULT NULL,
  `reserv_public_time` int(11) DEFAULT NULL,
  `reserv_public_unit` int(11) DEFAULT NULL,
  `tardy_after_time` int(11) DEFAULT NULL,
  `tardy_after_unit` int(11) DEFAULT NULL,
  PRIMARY KEY (`center_config_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 테이블 데이터 dev_demo.center_config:~0 rows (대략적) 내보내기
/*!40000 ALTER TABLE `center_config` DISABLE KEYS */;
/*!40000 ALTER TABLE `center_config` ENABLE KEYS */;

-- 테이블 dev_demo.center_director 구조 내보내기
DROP TABLE IF EXISTS `center_director`;
CREATE TABLE IF NOT EXISTS `center_director` (
  `director_id` varchar(255) NOT NULL,
  `birthday` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `mod_dd` datetime DEFAULT NULL,
  `mod_id` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `reg_dd` datetime DEFAULT NULL,
  `sex` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`director_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 테이블 데이터 dev_demo.center_director:~0 rows (대략적) 내보내기
/*!40000 ALTER TABLE `center_director` DISABLE KEYS */;
/*!40000 ALTER TABLE `center_director` ENABLE KEYS */;

-- 테이블 dev_demo.center_instructor 구조 내보내기
DROP TABLE IF EXISTS `center_instructor`;
CREATE TABLE IF NOT EXISTS `center_instructor` (
  `center_instructor_id` char(32) NOT NULL,
  `instructor_id` varchar(255) DEFAULT NULL,
  `instructor_status` int(11) DEFAULT NULL,
  `join_date` datetime DEFAULT NULL,
  `leave_date` datetime DEFAULT NULL,
  `mod_dd` datetime DEFAULT NULL,
  `mod_id` varchar(255) DEFAULT NULL,
  `reg_dd` datetime DEFAULT NULL,
  `reg_id` varchar(255) DEFAULT NULL,
  `center_id` varchar(255) DEFAULT NULL,
  `center_organization_id` varchar(255) DEFAULT NULL,
  `instructor_desc` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`center_instructor_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 테이블 데이터 dev_demo.center_instructor:~0 rows (대략적) 내보내기
/*!40000 ALTER TABLE `center_instructor` DISABLE KEYS */;
/*!40000 ALTER TABLE `center_instructor` ENABLE KEYS */;

-- 테이블 dev_demo.center_organization 구조 내보내기
DROP TABLE IF EXISTS `center_organization`;
CREATE TABLE IF NOT EXISTS `center_organization` (
  `center_organization_id` char(32) NOT NULL,
  `center_id` varchar(255) DEFAULT NULL,
  `mod_dd` datetime DEFAULT NULL,
  `mod_id` varchar(255) DEFAULT NULL,
  `oraganization_desc` varchar(255) DEFAULT NULL,
  `oraganization_title` varchar(255) DEFAULT NULL,
  `organization_diff` varchar(255) DEFAULT NULL,
  `reg_dd` datetime DEFAULT NULL,
  `reg_id` varchar(255) DEFAULT NULL,
  `oraganization_level` int(11) DEFAULT NULL,
  PRIMARY KEY (`center_organization_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 테이블 데이터 dev_demo.center_organization:~0 rows (대략적) 내보내기
/*!40000 ALTER TABLE `center_organization` DISABLE KEYS */;
INSERT INTO `center_organization` (`center_organization_id`, `center_id`, `mod_dd`, `mod_id`, `oraganization_desc`, `oraganization_title`, `organization_diff`, `reg_dd`, `reg_id`, `oraganization_level`) VALUES
	('organization_test_id', 'dev_center', NULL, NULL, '비고1', '부원장', NULL, NULL, NULL, 1),
	('organization_test_id1', 'dev_center', NULL, NULL, '비고1', '팀장', NULL, NULL, NULL, 2),
	('organization_test_id2', 'dev_center', NULL, NULL, '비고1', '주니어1', NULL, NULL, NULL, 6),
	('organization_test_id3', 'dev_center', NULL, NULL, '비고1', '시니어1', NULL, NULL, NULL, 3),
	('organization_test_id4', 'dev_center', NULL, NULL, '비고1', '인턴', NULL, NULL, NULL, 7),
	('organization_test_id5', 'dev_center', NULL, NULL, '비고1', '시니어2', NULL, NULL, NULL, 4),
	('organization_test_id6', 'dev_center', NULL, NULL, '비고1', '주니어2', NULL, NULL, NULL, 5);
/*!40000 ALTER TABLE `center_organization` ENABLE KEYS */;

-- 테이블 dev_demo.center_payment 구조 내보내기
DROP TABLE IF EXISTS `center_payment`;
CREATE TABLE IF NOT EXISTS `center_payment` (
  `center_payment_id` char(32) NOT NULL,
  `card` int(11) DEFAULT NULL,
  `cash` int(11) DEFAULT NULL,
  `center_id` varchar(255) DEFAULT NULL,
  `management_grade` int(11) DEFAULT NULL,
  `mod_dd` datetime DEFAULT NULL,
  `mod_id` varchar(255) DEFAULT NULL,
  `payment_type` int(11) DEFAULT NULL,
  `reg_dd` datetime DEFAULT NULL,
  `reg_id` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`center_payment_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 테이블 데이터 dev_demo.center_payment:~0 rows (대략적) 내보내기
/*!40000 ALTER TABLE `center_payment` DISABLE KEYS */;
/*!40000 ALTER TABLE `center_payment` ENABLE KEYS */;

-- 테이블 dev_demo.center_status 구조 내보내기
DROP TABLE IF EXISTS `center_status`;
CREATE TABLE IF NOT EXISTS `center_status` (
  `center_id` varchar(255) NOT NULL,
  `management_end_dd` varchar(255) DEFAULT NULL,
  `management_id` varchar(255) DEFAULT NULL,
  `management_start_dd` varchar(255) DEFAULT NULL,
  `mod_dd` datetime DEFAULT NULL,
  `mod_id` varchar(255) DEFAULT NULL,
  `reg_dd` datetime DEFAULT NULL,
  `reg_id` varchar(255) DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`center_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 테이블 데이터 dev_demo.center_status:~0 rows (대략적) 내보내기
/*!40000 ALTER TABLE `center_status` DISABLE KEYS */;
/*!40000 ALTER TABLE `center_status` ENABLE KEYS */;

-- 테이블 dev_demo.common_code 구조 내보내기
DROP TABLE IF EXISTS `common_code`;
CREATE TABLE IF NOT EXISTS `common_code` (
  `code_id` varchar(255) NOT NULL,
  `code_diff` varchar(255) DEFAULT NULL,
  `code_level` int(11) DEFAULT NULL,
  `code_name` varchar(255) DEFAULT NULL,
  `code_order` int(11) DEFAULT NULL,
  `def_val` varchar(255) DEFAULT NULL,
  `mod_dd` datetime DEFAULT NULL,
  `mod_id` varchar(255) DEFAULT NULL,
  `mod_yn` varchar(255) DEFAULT NULL,
  `reg_dd` datetime DEFAULT NULL,
  `reg_id` varchar(255) DEFAULT NULL,
  `remarks` longtext DEFAULT NULL,
  `use_yn` varchar(255) DEFAULT NULL,
  `center_id` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`code_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 테이블 데이터 dev_demo.common_code:~0 rows (대략적) 내보내기
/*!40000 ALTER TABLE `common_code` DISABLE KEYS */;
/*!40000 ALTER TABLE `common_code` ENABLE KEYS */;

-- 테이블 dev_demo.file 구조 내보내기
DROP TABLE IF EXISTS `file`;
CREATE TABLE IF NOT EXISTS `file` (
  `file_id` char(32) NOT NULL,
  `display_name` varchar(255) DEFAULT NULL,
  `file_ext` varchar(255) DEFAULT NULL,
  `file_path` varchar(255) DEFAULT NULL,
  `file_size` varchar(255) DEFAULT NULL,
  `file_type` varchar(255) DEFAULT NULL,
  `mod_dd` datetime DEFAULT NULL,
  `mod_id` varchar(255) DEFAULT NULL,
  `original_name` varchar(255) DEFAULT NULL,
  `reg_dd` datetime DEFAULT NULL,
  `reg_id` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`file_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 테이블 데이터 dev_demo.file:~0 rows (대략적) 내보내기
/*!40000 ALTER TABLE `file` DISABLE KEYS */;
/*!40000 ALTER TABLE `file` ENABLE KEYS */;

-- 테이블 dev_demo.health_class 구조 내보내기
DROP TABLE IF EXISTS `health_class`;
CREATE TABLE IF NOT EXISTS `health_class` (
  `health_class_id` char(32) NOT NULL,
  `center_id` varchar(255) DEFAULT NULL,
  `class_cnt` int(11) DEFAULT NULL,
  `class_cnt_payment` int(11) DEFAULT NULL,
  `class_day_max_cnt` int(11) DEFAULT NULL,
  `class_session_month` int(11) DEFAULT NULL,
  `class_session_payment` int(11) DEFAULT NULL,
  `class_session_type` int(11) DEFAULT NULL,
  `class_total_max_cnt` int(11) DEFAULT NULL,
  `class_user_max_cnt` int(11) DEFAULT NULL,
  `class_week_max_cnt` int(11) DEFAULT NULL,
  `health_class_type_id` varchar(255) DEFAULT NULL,
  `instructor_id` varchar(255) DEFAULT NULL,
  `is_use` bit(1) DEFAULT NULL,
  `mod_dd` datetime DEFAULT NULL,
  `mod_id` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `reg_dd` datetime DEFAULT NULL,
  `reg_id` varchar(255) DEFAULT NULL,
  `remarks` longtext DEFAULT NULL,
  PRIMARY KEY (`health_class_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 테이블 데이터 dev_demo.health_class:~2 rows (대략적) 내보내기
/*!40000 ALTER TABLE `health_class` DISABLE KEYS */;
INSERT INTO `health_class` (`health_class_id`, `center_id`, `class_cnt`, `class_cnt_payment`, `class_day_max_cnt`, `class_session_month`, `class_session_payment`, `class_session_type`, `class_total_max_cnt`, `class_user_max_cnt`, `class_week_max_cnt`, `health_class_type_id`, `instructor_id`, `is_use`, `mod_dd`, `mod_id`, `name`, `reg_dd`, `reg_id`, `remarks`) VALUES
	('402880856e442649016e447404b80002', 'dev_center', NULL, 30000, 1, 5, NULL, 1, 50, 2, 20, '402880856e442649016e44372af00000', 'instructor1', b'1', NULL, NULL, '2:1 그룹레슨', '2019-11-07 06:01:24', 'reg_test_id', NULL),
	('402880856e442649016e44747cc40003', 'dev_center', NULL, 10000, 1, 3, NULL, 1, 50, 5, 7, '402880856e442649016e44372af00000', 'instructor1', b'1', NULL, NULL, '5:1 그룹레슨', '2019-11-07 06:01:54', 'reg_test_id', NULL),
	('402880856e442649016e4475cec50004', 'dev_center', NULL, 70000, 1, 3, NULL, 1, 50, 1, 7, '402880856e442649016e44375aa50001', 'instructor1', b'1', NULL, NULL, '테스트강사 1:1 수업', '2019-11-07 06:03:21', 'reg_test_id', NULL);
/*!40000 ALTER TABLE `health_class` ENABLE KEYS */;

-- 테이블 dev_demo.health_class_reserv 구조 내보내기
DROP TABLE IF EXISTS `health_class_reserv`;
CREATE TABLE IF NOT EXISTS `health_class_reserv` (
  `health_class_reserv_id` char(32) NOT NULL,
  `health_class_schedule_id` varchar(255) DEFAULT NULL,
  `mod_dd` datetime DEFAULT NULL,
  `mod_id` varchar(255) DEFAULT NULL,
  `reg_dd` datetime DEFAULT NULL,
  `reg_id` varchar(255) DEFAULT NULL,
  `reserv_status` int(11) DEFAULT NULL,
  `user_id` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`health_class_reserv_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 테이블 데이터 dev_demo.health_class_reserv:~0 rows (대략적) 내보내기
/*!40000 ALTER TABLE `health_class_reserv` DISABLE KEYS */;
/*!40000 ALTER TABLE `health_class_reserv` ENABLE KEYS */;

-- 테이블 dev_demo.health_class_schedule 구조 내보내기
DROP TABLE IF EXISTS `health_class_schedule`;
CREATE TABLE IF NOT EXISTS `health_class_schedule` (
  `health_class_schedule_id` char(32) NOT NULL,
  `class_date` varchar(255) DEFAULT NULL,
  `class_week` varchar(255) DEFAULT NULL,
  `health_class_id` varchar(255) DEFAULT NULL,
  `mod_dd` datetime DEFAULT NULL,
  `mod_id` varchar(255) DEFAULT NULL,
  `reg_dd` datetime DEFAULT NULL,
  `reg_id` varchar(255) DEFAULT NULL,
  `schedule_status` int(11) DEFAULT NULL,
  PRIMARY KEY (`health_class_schedule_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 테이블 데이터 dev_demo.health_class_schedule:~0 rows (대략적) 내보내기
/*!40000 ALTER TABLE `health_class_schedule` DISABLE KEYS */;
/*!40000 ALTER TABLE `health_class_schedule` ENABLE KEYS */;

-- 테이블 dev_demo.health_class_type 구조 내보내기
DROP TABLE IF EXISTS `health_class_type`;
CREATE TABLE IF NOT EXISTS `health_class_type` (
  `health_class_type_id` char(32) NOT NULL,
  `center_id` varchar(255) DEFAULT NULL,
  `is_use` bit(1) DEFAULT NULL,
  `mod_dd` datetime DEFAULT NULL,
  `mod_id` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `reg_dd` datetime DEFAULT NULL,
  `reg_id` varchar(255) DEFAULT NULL,
  `remarks` longtext DEFAULT NULL,
  PRIMARY KEY (`health_class_type_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 테이블 데이터 dev_demo.health_class_type:~3 rows (대략적) 내보내기
/*!40000 ALTER TABLE `health_class_type` DISABLE KEYS */;
INSERT INTO `health_class_type` (`health_class_type_id`, `center_id`, `is_use`, `mod_dd`, `mod_id`, `name`, `reg_dd`, `reg_id`, `remarks`) VALUES
	('402880856e442649016e44372af00000', 'dev_center', b'1', NULL, NULL, '그룹레슨', '2019-11-07 04:55:08', 'reg_test_id', '그룹레슨 그룹레슨'),
	('402880856e442649016e44375aa50001', 'dev_center', b'1', NULL, NULL, '개인레슨', '2019-11-07 04:55:08', 'reg_test_id', '개인수업에 카테고리');
/*!40000 ALTER TABLE `health_class_type` ENABLE KEYS */;

-- 테이블 dev_demo.locker 구조 내보내기
DROP TABLE IF EXISTS `locker`;
CREATE TABLE IF NOT EXISTS `locker` (
  `locker_id` char(32) NOT NULL,
  `center_id` varchar(255) DEFAULT NULL,
  `locker_num` int(11) DEFAULT NULL,
  `mod_dd` datetime DEFAULT NULL,
  `mod_id` varchar(255) DEFAULT NULL,
  `reg_dd` datetime DEFAULT NULL,
  `reg_id` varchar(255) DEFAULT NULL,
  `remarks` longtext DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  `use_end_dd` varchar(255) DEFAULT NULL,
  `use_start_dd` varchar(255) DEFAULT NULL,
  `user_id` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`locker_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 테이블 데이터 dev_demo.locker:~0 rows (대략적) 내보내기
/*!40000 ALTER TABLE `locker` DISABLE KEYS */;
/*!40000 ALTER TABLE `locker` ENABLE KEYS */;

-- 테이블 dev_demo.management 구조 내보내기
DROP TABLE IF EXISTS `management`;
CREATE TABLE IF NOT EXISTS `management` (
  `management_id` char(32) NOT NULL,
  `grad` varchar(255) DEFAULT NULL,
  `instructor_cnt` int(11) DEFAULT NULL,
  `mod_dd` datetime DEFAULT NULL,
  `mod_id` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `payment` int(11) DEFAULT NULL,
  `reg_dd` datetime DEFAULT NULL,
  `reg_id` varchar(255) DEFAULT NULL,
  `user_cnt` int(11) DEFAULT NULL,
  PRIMARY KEY (`management_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 테이블 데이터 dev_demo.management:~0 rows (대략적) 내보내기
/*!40000 ALTER TABLE `management` DISABLE KEYS */;
/*!40000 ALTER TABLE `management` ENABLE KEYS */;

-- 테이블 dev_demo.oauth 구조 내보내기
DROP TABLE IF EXISTS `oauth`;
CREATE TABLE IF NOT EXISTS `oauth` (
  `oauth_id` varchar(255) NOT NULL,
  `access_token` varchar(255) DEFAULT NULL,
  `expires_in` varchar(255) DEFAULT NULL,
  `mod_dd` datetime DEFAULT NULL,
  `mod_id` varchar(255) DEFAULT NULL,
  `refresh_token` varchar(255) DEFAULT NULL,
  `reg_dd` datetime DEFAULT NULL,
  `reg_id` varchar(255) DEFAULT NULL,
  `scope` varchar(255) DEFAULT NULL,
  `token_type` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`oauth_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 테이블 데이터 dev_demo.oauth:~4 rows (대략적) 내보내기
/*!40000 ALTER TABLE `oauth` DISABLE KEYS */;
INSERT INTO `oauth` (`oauth_id`, `access_token`, `expires_in`, `mod_dd`, `mod_id`, `refresh_token`, `reg_dd`, `reg_id`, `scope`, `token_type`) VALUES
	('dev_admin_token', '59ab2fd5-b5b6-41e9-b1a5-a740c1ebe770', '999999998', '2019-11-13 01:11:06', NULL, '5302abb6-bf5b-49ea-a4fb-14c85ad12db9', NULL, NULL, 'read write trust', 'bearer'),
	('dev_user_token', 'de4daf4f-3c84-4633-9a6f-af45dd1b810f', '999999999', '2019-11-13 01:11:08', NULL, '7cf1b8a9-adbd-4b52-8b71-ea736f326b01', NULL, NULL, 'read write trust', 'bearer'),
	('mk_dev_admin_token', 'fe6c4632-05b1-41e1-81da-e607eced906b', '999999998', '2019-11-12 05:44:50', NULL, '00c402ff-9e20-4944-bdef-0296245697c4', NULL, NULL, 'read write trust', 'bearer'),
	('mk_dev_user_token', '32a9b94f-74bd-412a-838a-59fce12114ab', '999999998', '2019-11-12 05:44:51', NULL, '1a7080a1-2db7-4a65-8457-5f9e4ed6e794', NULL, NULL, 'read write trust', 'bearer');
/*!40000 ALTER TABLE `oauth` ENABLE KEYS */;

-- 테이블 dev_demo.SPRING_SESSION 구조 내보내기
DROP TABLE IF EXISTS `SPRING_SESSION`;
CREATE TABLE IF NOT EXISTS `SPRING_SESSION` (
  `PRIMARY_ID` char(36) NOT NULL,
  `SESSION_ID` char(36) NOT NULL,
  `CREATION_TIME` bigint(20) NOT NULL,
  `LAST_ACCESS_TIME` bigint(20) NOT NULL,
  `MAX_INACTIVE_INTERVAL` int(11) NOT NULL,
  `EXPIRY_TIME` bigint(20) NOT NULL,
  `PRINCIPAL_NAME` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`PRIMARY_ID`),
  UNIQUE KEY `SPRING_SESSION_IX1` (`SESSION_ID`),
  KEY `SPRING_SESSION_IX2` (`EXPIRY_TIME`),
  KEY `SPRING_SESSION_IX3` (`PRINCIPAL_NAME`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- 테이블 데이터 dev_demo.SPRING_SESSION:~0 rows (대략적) 내보내기
/*!40000 ALTER TABLE `SPRING_SESSION` DISABLE KEYS */;
/*!40000 ALTER TABLE `SPRING_SESSION` ENABLE KEYS */;

-- 테이블 dev_demo.SPRING_SESSION_ATTRIBUTES 구조 내보내기
DROP TABLE IF EXISTS `SPRING_SESSION_ATTRIBUTES`;
CREATE TABLE IF NOT EXISTS `SPRING_SESSION_ATTRIBUTES` (
  `SESSION_PRIMARY_ID` char(36) NOT NULL,
  `ATTRIBUTE_NAME` varchar(200) NOT NULL,
  `ATTRIBUTE_BYTES` blob NOT NULL,
  PRIMARY KEY (`SESSION_PRIMARY_ID`,`ATTRIBUTE_NAME`),
  CONSTRAINT `SPRING_SESSION_ATTRIBUTES_FK` FOREIGN KEY (`SESSION_PRIMARY_ID`) REFERENCES `SPRING_SESSION` (`PRIMARY_ID`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- 테이블 데이터 dev_demo.SPRING_SESSION_ATTRIBUTES:~0 rows (대략적) 내보내기
/*!40000 ALTER TABLE `SPRING_SESSION_ATTRIBUTES` DISABLE KEYS */;
/*!40000 ALTER TABLE `SPRING_SESSION_ATTRIBUTES` ENABLE KEYS */;

-- 테이블 dev_demo.user 구조 내보내기
DROP TABLE IF EXISTS `user`;
CREATE TABLE IF NOT EXISTS `user` (
  `user_id` varchar(255) NOT NULL,
  `address` varchar(255) DEFAULT NULL,
  `birthday` varchar(255) DEFAULT NULL,
  `center_id` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `mod_dd` datetime DEFAULT NULL,
  `mod_id` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `reg_dd` datetime DEFAULT NULL,
  `reg_id` varchar(255) DEFAULT NULL,
  `sex` int(11) DEFAULT NULL,
  `user_type` int(11) DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 테이블 데이터 dev_demo.user:~8 rows (대략적) 내보내기
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` (`user_id`, `address`, `birthday`, `center_id`, `email`, `mod_dd`, `mod_id`, `name`, `password`, `phone`, `reg_dd`, `reg_id`, `sex`, `user_type`) VALUES
	('191107_test2', '테스트 주소', '20191107', 'dev_center', 'test2@test.com', NULL, NULL, '회원2', 'teky6+JBsDmKnapfgB1a8+Eh/zLagd4teoVCR7UdBRCNN1Z0r8eehBqUFgu2gyCa9XTlqA==', '01022222222', '2019-11-07 06:06:31', '', 1, 1),
	('191107_test3', '테스트주소', '20191107', 'dev_center', 'test3@test.com', NULL, NULL, '회원3', 'DypTPOKH9OP5qMvVJ09DW6RHVjmKsHsucd7ggG+BFJ2BCeLEi+S1LMviQBW3ARdqM3fuog==', '01000000000', '2019-11-07 06:10:07', '', 1, 1),
	('admin', NULL, NULL, NULL, 'admin@rms.com', NULL, 'admin', '관리자', 'YJCK40iWWbLKkuY4z2LY+0IGKETmJc93oSpr9Vzhg/pJItR9KwbRz02eW5MtElEyVji+Og==', NULL, '2019-11-07 13:48:50', NULL, NULL, NULL),
	('instructor1', '테스트주소1', NULL, 'dev_center', 'instructor1@test.com', NULL, NULL, '테스트강사', 'YJCK40iWWbLKkuY4z2LY+0IGKETmJc93oSpr9Vzhg/pJItR9KwbRz02eW5MtElEyVji+Og==', '01000000000', NULL, NULL, 1, 2),
	('instructor2', '테스트주소2', NULL, 'dev_center', 'instructor2@test.com', NULL, NULL, '테스트강사2\r\n', 'YJCK40iWWbLKkuY4z2LY+0IGKETmJc93oSpr9Vzhg/pJItR9KwbRz02eW5MtElEyVji+Og==', '01000000000', NULL, NULL, 1, 2),
	('instructor3', '테스트주소3', NULL, 'dev_center', 'instructor3@test.com', NULL, NULL, '테스트강사3\r\n\r\n', 'YJCK40iWWbLKkuY4z2LY+0IGKETmJc93oSpr9Vzhg/pJItR9KwbRz02eW5MtElEyVji+Og==', '01000000000', NULL, NULL, 1, 2),
	('instructor4', '테스트주소4', NULL, 'dev_center', 'instructor4@test.com', NULL, NULL, '테스트강사4', 'YJCK40iWWbLKkuY4z2LY+0IGKETmJc93oSpr9Vzhg/pJItR9KwbRz02eW5MtElEyVji+Og==', '01000000000', NULL, NULL, 1, 2),
	('instructor5', '테스트주소5', NULL, 'dev_center', 'instructor5@test.com', NULL, NULL, '테스트강사5', 'YJCK40iWWbLKkuY4z2LY+0IGKETmJc93oSpr9Vzhg/pJItR9KwbRz02eW5MtElEyVji+Og==', '01000000000', NULL, NULL, 1, 2);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;

-- 테이블 dev_demo.user_health_class_status 구조 내보내기
DROP TABLE IF EXISTS `user_health_class_status`;
CREATE TABLE IF NOT EXISTS `user_health_class_status` (
  `user_health_class_status_id` char(32) NOT NULL,
  `class_end_dd` datetime DEFAULT NULL,
  `class_start_dd` datetime DEFAULT NULL,
  `health_class_id` varchar(255) DEFAULT NULL,
  `instructor_id` varchar(255) DEFAULT NULL,
  `mod_dd` datetime DEFAULT NULL,
  `mod_id` varchar(255) DEFAULT NULL,
  `payment_class_cnt` int(11) DEFAULT NULL,
  `payment_class_status` int(11) DEFAULT NULL,
  `reg_dd` datetime DEFAULT NULL,
  `reg_id` varchar(255) DEFAULT NULL,
  `user_id` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`user_health_class_status_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 테이블 데이터 dev_demo.user_health_class_status:~2 rows (대략적) 내보내기
/*!40000 ALTER TABLE `user_health_class_status` DISABLE KEYS */;
INSERT INTO `user_health_class_status` (`user_health_class_status_id`, `class_end_dd`, `class_start_dd`, `health_class_id`, `instructor_id`, `mod_dd`, `mod_id`, `payment_class_cnt`, `payment_class_status`, `reg_dd`, `reg_id`, `user_id`) VALUES
	('402880856e442649016e4478b9030005', '2019-11-29 15:00:00', '2019-11-06 15:00:00', '402880856e442649016e4475cec50004', 'instructor1', NULL, NULL, 10, 3, '2019-11-07 06:06:32', '', '191107_test2'),
	('402880856e442649016e447c04780007', '2019-11-28 15:00:00', '2019-11-14 15:00:00', '402880856e442649016e44747cc40003', 'instructor1', NULL, NULL, 1, 3, '2019-11-07 06:10:08', '', '191107_test3');
/*!40000 ALTER TABLE `user_health_class_status` ENABLE KEYS */;

-- 테이블 dev_demo.user_payment 구조 내보내기
DROP TABLE IF EXISTS `user_payment`;
CREATE TABLE IF NOT EXISTS `user_payment` (
  `user_payment_id` char(32) NOT NULL,
  `card` int(11) DEFAULT NULL,
  `cash` int(11) DEFAULT NULL,
  `class_payment` int(11) DEFAULT NULL,
  `mod_dd` datetime DEFAULT NULL,
  `mod_id` varchar(255) DEFAULT NULL,
  `payment` int(11) DEFAULT NULL,
  `payment_instructor_id` varchar(255) DEFAULT NULL,
  `payment_status` int(11) DEFAULT NULL,
  `payment_type` int(11) DEFAULT NULL,
  `payment_type_id` varchar(255) DEFAULT NULL,
  `reg_dd` datetime DEFAULT NULL,
  `reg_id` varchar(255) DEFAULT NULL,
  `user_id` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`user_payment_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 테이블 데이터 dev_demo.user_payment:~2 rows (대략적) 내보내기
/*!40000 ALTER TABLE `user_payment` DISABLE KEYS */;
INSERT INTO `user_payment` (`user_payment_id`, `card`, `cash`, `class_payment`, `mod_dd`, `mod_id`, `payment`, `payment_instructor_id`, `payment_status`, `payment_type`, `payment_type_id`, `reg_dd`, `reg_id`, `user_id`) VALUES
	('402880856e442649016e4478bb810006', 500000, 200000, 700000, NULL, NULL, 700000, 'test1', 3, 1, '402880856e442649016e4475cec50004', '2019-11-07 06:06:33', '', '191107_test2'),
	('402880856e442649016e447c06ef0008', 5000, 5000, 10000, NULL, NULL, 10000, 'test1', 3, 1, '402880856e442649016e44747cc40003', '2019-11-07 06:10:09', '', '191107_test3');
/*!40000 ALTER TABLE `user_payment` ENABLE KEYS */;

-- 테이블 dev_demo.user_status 구조 내보내기
DROP TABLE IF EXISTS `user_status`;
CREATE TABLE IF NOT EXISTS `user_status` (
  `user_id` varchar(255) NOT NULL,
  `mod_dd` datetime DEFAULT NULL,
  `mod_id` varchar(255) DEFAULT NULL,
  `reg_dd` datetime DEFAULT NULL,
  `reg_id` varchar(255) DEFAULT NULL,
  `remarks` longtext DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 테이블 데이터 dev_demo.user_status:~2 rows (대략적) 내보내기
/*!40000 ALTER TABLE `user_status` DISABLE KEYS */;
INSERT INTO `user_status` (`user_id`, `mod_dd`, `mod_id`, `reg_dd`, `reg_id`, `remarks`, `status`) VALUES
	('191107_test2', NULL, NULL, '2019-11-07 06:06:33', '', '', 2),
	('191107_test3', NULL, NULL, '2019-11-07 06:10:09', '', '', 2);
/*!40000 ALTER TABLE `user_status` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
