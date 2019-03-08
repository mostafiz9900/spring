-- MySQL Administrator dump 1.4
--
-- ------------------------------------------------------
-- Server version	5.6.40-log


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


--
-- Create schema mcs
--

CREATE DATABASE IF NOT EXISTS mcs;
USE mcs;

--
-- Definition of table `bhaban`
--

DROP TABLE IF EXISTS `bhaban`;
CREATE TABLE `bhaban` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `address` varchar(255) DEFAULT NULL,
  `bhaban_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `bhaban`
--

/*!40000 ALTER TABLE `bhaban` DISABLE KEYS */;
INSERT INTO `bhaban` (`id`,`address`,`bhaban_name`) VALUES 
 (1,'Agarga','IDB BHABAN');
/*!40000 ALTER TABLE `bhaban` ENABLE KEYS */;


--
-- Definition of table `department`
--

DROP TABLE IF EXISTS `department`;
CREATE TABLE `department` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `department_name` varchar(255) DEFAULT NULL,
  `rank` varchar(255) DEFAULT NULL,
  `short_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `department`
--

/*!40000 ALTER TABLE `department` DISABLE KEYS */;
INSERT INTO `department` (`id`,`department_name`,`rank`,`short_name`) VALUES 
 (1,'Marketing','01','MKT'),
 (2,'Account','02','ACC');
/*!40000 ALTER TABLE `department` ENABLE KEYS */;


--
-- Definition of table `designation`
--

DROP TABLE IF EXISTS `designation`;
CREATE TABLE `designation` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `designation_name` varchar(255) DEFAULT NULL,
  `short_designation` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `designation`
--

/*!40000 ALTER TABLE `designation` DISABLE KEYS */;
INSERT INTO `designation` (`id`,`designation_name`,`short_designation`) VALUES 
 (1,'Project Manager','PH'),
 (2,'softawer Devolopment','SD');
/*!40000 ALTER TABLE `designation` ENABLE KEYS */;


--
-- Definition of table `floor`
--

DROP TABLE IF EXISTS `floor`;
CREATE TABLE `floor` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `floor_name` varchar(255) DEFAULT NULL,
  `bhaban_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKm5k7doqbrlpg122yprv4te2is` (`bhaban_id`)
) ENGINE=MyISAM AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `floor`
--

/*!40000 ALTER TABLE `floor` DISABLE KEYS */;
INSERT INTO `floor` (`id`,`floor_name`,`bhaban_id`) VALUES 
 (1,'3th floor',NULL);
/*!40000 ALTER TABLE `floor` ENABLE KEYS */;


--
-- Definition of table `minor`
--

DROP TABLE IF EXISTS `minor`;
CREATE TABLE `minor` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `agenda_action` varchar(255) DEFAULT NULL,
  `meeting_title` varchar(255) DEFAULT NULL,
  `remark` varchar(255) DEFAULT NULL,
  `meeting_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKoac6c2lnml4ssqa7v9ixdu1mj` (`meeting_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `minor`
--

/*!40000 ALTER TABLE `minor` DISABLE KEYS */;
/*!40000 ALTER TABLE `minor` ENABLE KEYS */;


--
-- Definition of table `officer_id`
--

DROP TABLE IF EXISTS `officer_id`;
CREATE TABLE `officer_id` (
  `officer_id` bigint(20) DEFAULT NULL,
  `id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK8bmpi6po8wmjsjrd6xooc8w3c` (`officer_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `officer_id`
--

/*!40000 ALTER TABLE `officer_id` DISABLE KEYS */;
/*!40000 ALTER TABLE `officer_id` ENABLE KEYS */;


--
-- Definition of table `organigation`
--

DROP TABLE IF EXISTS `organigation`;
CREATE TABLE `organigation` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `email` varchar(255) DEFAULT NULL,
  `ministry_name_or_head_office` varchar(255) DEFAULT NULL,
  `org_chief_name` varchar(255) DEFAULT NULL,
  `org_name` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `registration_date` datetime DEFAULT NULL,
  `bhaban_id` bigint(20) DEFAULT NULL,
  `floor_id` bigint(20) DEFAULT NULL,
  `room_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKjbqnlius3v8kckq5qlbwp1hc2` (`bhaban_id`),
  KEY `FKrlmgfihhjxnjmw66n1r4mmswl` (`floor_id`),
  KEY `FKfavdvkyjvixmc1umdt8m419yq` (`room_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `organigation`
--

/*!40000 ALTER TABLE `organigation` DISABLE KEYS */;
/*!40000 ALTER TABLE `organigation` ENABLE KEYS */;


--
-- Definition of table `role`
--

DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `role_name` varchar(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `role`
--

/*!40000 ALTER TABLE `role` DISABLE KEYS */;
INSERT INTO `role` (`id`,`role_name`) VALUES 
 (1,'USER'),
 (2,'ADMIN'),
 (3,'SUPERADMIN'),
 (4,'CADMIN'),
 (5,'PM');
/*!40000 ALTER TABLE `role` ENABLE KEYS */;


--
-- Definition of table `room`
--

DROP TABLE IF EXISTS `room`;
CREATE TABLE `room` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `room_no` int(11) NOT NULL,
  `floor_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKstlo96g0nkwp4urd4e0ki5b3h` (`floor_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `room`
--

/*!40000 ALTER TABLE `room` DISABLE KEYS */;
/*!40000 ALTER TABLE `room` ENABLE KEYS */;


--
-- Definition of table `user`
--

DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `birth_date` date NOT NULL,
  `confirmation_token` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `enabled` bit(1) NOT NULL,
  `file_extension` varchar(255) DEFAULT NULL,
  `file_name` varchar(255) DEFAULT NULL,
  `file_path` varchar(255) DEFAULT NULL,
  `file_size` bigint(20) DEFAULT NULL,
  `first_name` varchar(50) NOT NULL,
  `gender` varchar(255) DEFAULT NULL,
  `last_modified_date` datetime DEFAULT NULL,
  `last_name` varchar(255) DEFAULT NULL,
  `mobile` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `regi_date` datetime DEFAULT NULL,
  `user_name` varchar(255) NOT NULL,
  `dep_id` bigint(20) DEFAULT NULL,
  `desig_id` bigint(20) DEFAULT NULL,
  `org_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_ob8kqyqqgmefl0aco34akdtpe` (`email`),
  UNIQUE KEY `UK_lqjrcobrh9jc8wpcar64q1bfh` (`user_name`),
  UNIQUE KEY `UK_cnjwxx5favk5ycqajjt17fwy1` (`mobile`),
  KEY `FK3x7b5829jumyimey9x7vmbh2f` (`dep_id`),
  KEY `FKodbkeboq45oayv165spts4u7m` (`desig_id`),
  KEY `FKdpkqlhi8epsskohm5087vxsj2` (`org_id`)
) ENGINE=MyISAM AUTO_INCREMENT=8 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user`
--

/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` (`id`,`birth_date`,`confirmation_token`,`email`,`enabled`,`file_extension`,`file_name`,`file_path`,`file_size`,`first_name`,`gender`,`last_modified_date`,`last_name`,`mobile`,`password`,`regi_date`,`user_name`,`dep_id`,`desig_id`,`org_id`) VALUES 
 (1,'2019-03-07','409eeb08-eb15-4faf-8bbb-1ba735973fd7','admin@gmail.com',0x01,NULL,NULL,NULL,0,'Mostafizur',NULL,'2019-03-07 19:16:37','Rahman',NULL,'$2a$10$Qlx1aA5ApMV.apVgWk/cdeTFHlu4nL9nBHuYiPvU/O2iUQh8erz7y',NULL,'mostafiz',NULL,NULL,NULL),
 (2,'2019-03-04','abddd67a-af15-4298-b968-a99ca1e3672e','mostafiz9900@gmail.com',0x01,NULL,NULL,NULL,0,'Md','m','2019-03-07 19:18:14','Mostafiz',NULL,'$2a$10$Ifi5L8nf2KRyMbne31Vd.u3PpXWL94zQ7oHcgRNdON3odhArjoORa','2019-03-07 19:18:14','mostafiz9900',NULL,NULL,NULL),
 (3,'2019-03-04','f0b5ee21-4d8b-4096-9492-0b049ab1e54a','sofiqul54@gmail.com',0x01,NULL,'',NULL,0,'Sofiqul','mail','2019-03-08 10:50:36','Islam','01730959487','$2a$10$ArPB.mW0lUXd3uKRPfhQv..h7JMp55iVOl/shE44SuZdNhf.10ZS2',NULL,'sofiqul54',NULL,NULL,NULL),
 (4,'2019-03-08','3a523452-9eac-4f74-a037-4dfb09819053','mahabub@gmail.com',0x01,NULL,'',NULL,0,'Mahabub','mail','2019-03-08 11:00:44','Rahman','012478569','$2a$10$/BuxwS6N8pVQsJSMRt7yGu1eQObBz6nMn41T38qYahT0UuQY6Rrxa',NULL,'mahabub',NULL,NULL,NULL),
 (5,'2019-03-08','74f1854b-3253-4d86-98a5-12220dec096b','arefin@gmail.com',0x01,NULL,'',NULL,0,'Arefin','mail','2019-03-08 11:06:30','Islam','01245785525','$2a$10$TKgeKrDnKSKfLQd4glJ7ouAVHOKDM7ZKyWyI5X77V.egVcxysABEO',NULL,'arefin',NULL,NULL,NULL),
 (6,'1995-01-02','145c6778-63da-4c24-bcf7-bcaa10709d2e','rashisa@gmail.com',0x01,NULL,'',NULL,0,'Rashida ','femail','2019-03-08 11:16:32','Khatun','01759016441','$2a$10$AkrNVDVyRhnbyhOle4T3u.MCouRgRK8X27TunGJI7gbtbv/Xw5k72','2019-03-08 11:16:32','rashisa',NULL,NULL,NULL),
 (7,'2019-03-04','3f5af8d3-f3cf-4c19-8289-4c789fc3ff4c','ajat@gmail.com',0x01,NULL,'',NULL,0,'Ajat','mail','2019-03-08 12:40:19','Khan','0158689542','$2a$10$XuTA716jlQ6MlZOyiiNm.OPCFWfpKaS/qS1h48kKW3dHtZRNRdowa','2019-03-08 12:40:19','ajat',NULL,NULL,NULL);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;


--
-- Definition of table `user_role`
--

DROP TABLE IF EXISTS `user_role`;
CREATE TABLE `user_role` (
  `user_id` bigint(20) NOT NULL,
  `role_id` bigint(20) NOT NULL,
  PRIMARY KEY (`user_id`,`role_id`),
  KEY `FKa68196081fvovjhkek5m97n3y` (`role_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user_role`
--

/*!40000 ALTER TABLE `user_role` DISABLE KEYS */;
INSERT INTO `user_role` (`user_id`,`role_id`) VALUES 
 (1,2),
 (1,3),
 (2,3),
 (3,1),
 (4,1),
 (4,5),
 (5,1),
 (5,2),
 (6,1),
 (7,1);
/*!40000 ALTER TABLE `user_role` ENABLE KEYS */;




/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
