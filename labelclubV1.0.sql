-- MySQL dump 10.13  Distrib 8.0.36, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: labelclub
-- ------------------------------------------------------
-- Server version	8.0.36

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `admin`
--

DROP TABLE IF EXISTS `admin`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `admin` (
  `id` int NOT NULL AUTO_INCREMENT,
  `username` varchar(50) CHARACTER SET gb2312 COLLATE gb2312_chinese_ci DEFAULT NULL,
  `password` varchar(50) CHARACTER SET gb2312 COLLATE gb2312_chinese_ci DEFAULT NULL,
  `status` varchar(10) CHARACTER SET gb2312 COLLATE gb2312_chinese_ci DEFAULT '0',
  `level` varchar(10) CHARACTER SET gb2312 COLLATE gb2312_chinese_ci DEFAULT '管理员',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=gb2312 ROW_FORMAT=DYNAMIC;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `admin`
--

LOCK TABLES `admin` WRITE;
/*!40000 ALTER TABLE `admin` DISABLE KEYS */;
INSERT INTO `admin` VALUES (1,'admin','21232f297a57a5a743894a0e4a801fc3','0','管理员','2024-02-25 07:15:44'),(2,'forestdre4m','202cb962ac59075b964b07152d234b70','0','管理员','2024-03-05 11:37:43'),(4,'778','352407221afb776e3143e8a1a0577885','0','管理员','2024-03-10 03:01:58');
/*!40000 ALTER TABLE `admin` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `artist`
--

DROP TABLE IF EXISTS `artist`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `artist` (
  `id` int NOT NULL AUTO_INCREMENT,
  `username` varchar(50) CHARACTER SET gb2312 COLLATE gb2312_chinese_ci DEFAULT NULL,
  `password` varchar(50) CHARACTER SET gb2312 COLLATE gb2312_chinese_ci DEFAULT NULL,
  `uid` varchar(50) CHARACTER SET gb2312 COLLATE gb2312_chinese_ci DEFAULT NULL,
  `email` varchar(50) CHARACTER SET gb2312 COLLATE gb2312_chinese_ci DEFAULT NULL,
  `sex` varchar(50) CHARACTER SET gb2312 COLLATE gb2312_chinese_ci DEFAULT NULL,
  `age` varchar(500) CHARACTER SET gb2312 COLLATE gb2312_chinese_ci DEFAULT NULL,
  `text` varchar(500) CHARACTER SET gb2312 COLLATE gb2312_chinese_ci DEFAULT NULL,
  `icon` varchar(50) CHARACTER SET gb2312 COLLATE gb2312_chinese_ci DEFAULT NULL,
  `level` varchar(10) CHARACTER SET gb2312 COLLATE gb2312_chinese_ci DEFAULT '音乐人',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=gb2312 ROW_FORMAT=DYNAMIC;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `artist`
--

LOCK TABLES `artist` WRITE;
/*!40000 ALTER TABLE `artist` DISABLE KEYS */;
INSERT INTO `artist` VALUES (2,'023','dc5c7986daef50c1e02ab09b442ee34f','','grhtrhk@163.com','0','32','','/files/download/16','音乐人','2024-02-25 07:15:52'),(3,'007','dc5c7986daef50c1e02ab09b442ee34f','','	fegge@163.com','0','32','','/files/download/17','音乐人','2024-02-25 07:15:52'),(4,'016','dc5c7986daef50c1e02ab09b442ee34f','','gewogw@qq.com','1','20','','/files/download/18','音乐人','2024-02-25 07:15:52'),(5,'006','dc5c7986daef50c1e02ab09b442ee34f','','2352352@qq.com','1','20','','/files/download/19','音乐人','2024-02-25 07:15:52'),(6,'033','dc5c7986daef50c1e02ab09b442ee34f','','grorti@qq.com','1','20','','/files/download/20','音乐人','2024-02-25 07:15:52'),(7,'015','dc5c7986daef50c1e02ab09b442ee34f','','56547474@qq.com','1','21','','/files/download/21','音乐人','2024-02-25 07:15:52'),(8,'025','dc5c7986daef50c1e02ab09b442ee34f','','43643933@qq.com','1','38','','/files/download/22','音乐人','2024-02-25 07:15:52'),(9,'009','dc5c7986daef50c1e02ab09b442ee34f','1','grorti@qq.com','1','21','','/files/download/23','音乐人','2024-02-25 07:15:52'),(10,'028','dc5c7986daef50c1e02ab09b442ee34f','','gewogw@qq.com','1','40','','/files/download/24','音乐人','2024-02-25 07:15:52'),(11,'001','dc5c7986daef50c1e02ab09b442ee34f','342334','grorti@qq.com','0','35','','/files/download/25','音乐人','2024-02-25 07:15:52'),(12,'qwe123','200820e3227815ed1756a6b531e7e0d2',NULL,NULL,'0',NULL,NULL,NULL,'音乐人','2024-03-04 08:21:20'),(13,NULL,'dc5c7986daef50c1e02ab09b442ee34f',NULL,NULL,'0',NULL,NULL,NULL,'音乐人','2024-03-09 07:16:05'),(14,NULL,'dc5c7986daef50c1e02ab09b442ee34f',NULL,NULL,'0',NULL,NULL,NULL,'音乐人','2024-03-09 07:17:50'),(15,'qwe321','456952f553b82e5ab0afdd8d3babe183',NULL,NULL,'0',NULL,NULL,NULL,'音乐人','2024-03-09 07:19:54'),(16,'cs9999','c57531b961190684902d45302f230614',NULL,NULL,'0',NULL,NULL,NULL,'音乐人','2024-03-11 11:24:23'),(17,'CS8888','f75717dbdfe5fdf8a638eb4731b49a1d',NULL,NULL,'0',NULL,NULL,NULL,'音乐人','2024-03-11 11:44:18'),(18,'cs0003333','33f2186932ea0bbe5648c6c78dce06cd',NULL,NULL,NULL,NULL,NULL,NULL,'音乐人','2024-03-11 13:31:25'),(19,'qwe111','c5a422ca1523ce8d1a84c99622b98a95',NULL,NULL,NULL,NULL,NULL,NULL,'音乐人','2024-03-11 15:33:03');
/*!40000 ALTER TABLE `artist` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `audio`
--

DROP TABLE IF EXISTS `audio`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `audio` (
  `id` int NOT NULL AUTO_INCREMENT,
  `aid` varchar(50) CHARACTER SET gb2312 COLLATE gb2312_chinese_ci DEFAULT NULL,
  `labelname` varchar(50) CHARACTER SET gb2312 COLLATE gb2312_chinese_ci DEFAULT NULL,
  `audioname` varchar(50) CHARACTER SET gb2312 COLLATE gb2312_chinese_ci DEFAULT NULL,
  `author` varchar(50) CHARACTER SET gb2312 COLLATE gb2312_chinese_ci DEFAULT NULL,
  `file` varchar(50) CHARACTER SET gb2312 COLLATE gb2312_chinese_ci DEFAULT NULL,
  `genre` varchar(50) CHARACTER SET gb2312 COLLATE gb2312_chinese_ci DEFAULT NULL,
  `remark` varchar(500) CHARACTER SET gb2312 COLLATE gb2312_chinese_ci DEFAULT NULL,
  `udt` varchar(50) CHARACTER SET gb2312 COLLATE gb2312_chinese_ci DEFAULT NULL,
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=gb2312 ROW_FORMAT=DYNAMIC;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `audio`
--

LOCK TABLES `audio` WRITE;
/*!40000 ALTER TABLE `audio` DISABLE KEYS */;
INSERT INTO `audio` VALUES (2,'202402257672','G厂牌','xxx','001','/files/download/26','xxx','xxxx','2024-2-25 1','2024-02-25 07:26:08'),(4,'202402257126','R厂牌','aaa','001','/files/download/27','aab','asdfadsf','2024-2-25 15:55:25','2024-02-25 07:55:37'),(5,'202403053585','E厂牌','123','qwe123','/files/download/28','house',NULL,'2024-3-5 9:2:28','2024-03-05 01:03:20'),(6,'202403053585','E厂牌','1234','qwe123','/files/download/29','dubstep',NULL,'2024-3-5 9:2:28','2024-03-05 01:06:05'),(7,'202403053585','E厂牌','12345','qwe123','/files/download/30','dubstep',NULL,'2024-3-5 9:2:28','2024-03-05 01:15:54'),(8,'202403094872','E厂牌','1233','qwe321',NULL,'deephouyse','qweqwre','2024-3-9 16:32:55','2024-03-09 08:33:16'),(9,'20240311145','测试222','我爱洗澡','023',NULL,'1','1','2024-3-11 21:23:24','2024-03-11 13:23:44'),(11,'202403128410','Under The Trees','demo3','qwe321',NULL,'tech house','联系方式','2024-3-12 14:52:55','2024-03-12 06:53:35');
/*!40000 ALTER TABLE `audio` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `audiocheck`
--

DROP TABLE IF EXISTS `audiocheck`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `audiocheck` (
  `id` int NOT NULL AUTO_INCREMENT,
  `author` varchar(50) CHARACTER SET gb2312 COLLATE gb2312_chinese_ci DEFAULT NULL,
  `labelname` varchar(50) CHARACTER SET gb2312 COLLATE gb2312_chinese_ci DEFAULT NULL,
  `audioname` varchar(50) CHARACTER SET gb2312 COLLATE gb2312_chinese_ci DEFAULT NULL,
  `issh` varchar(10) CHARACTER SET gb2312 COLLATE gb2312_chinese_ci DEFAULT '0',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=gb2312 ROW_FORMAT=DYNAMIC;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `audiocheck`
--

LOCK TABLES `audiocheck` WRITE;
/*!40000 ALTER TABLE `audiocheck` DISABLE KEYS */;
INSERT INTO `audiocheck` VALUES (3,'001','G厂牌','xxx','1','2024-02-25 07:45:10'),(4,'001','G厂牌','xxx','0','2024-02-25 07:57:11'),(5,'qwe123','E厂牌','123','1','2024-03-05 11:31:10'),(6,'001','G厂牌','xxx','0','2024-03-05 11:34:01'),(7,'001','G厂牌','xxx','0','2024-03-10 14:49:15'),(8,'023','测试222','我爱洗澡','1','2024-03-11 13:24:35'),(9,'cs0003333','测试1111','测试审核','1','2024-03-11 13:39:58'),(10,'qwe321','Under The Trees','demo3','0','2024-03-12 06:53:54');
/*!40000 ALTER TABLE `audiocheck` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `collect`
--

DROP TABLE IF EXISTS `collect`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `collect` (
  `id` int NOT NULL AUTO_INCREMENT,
  `user_id` int DEFAULT NULL,
  `shangpinxinxiID` int DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1 ROW_FORMAT=DYNAMIC;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `collect`
--

LOCK TABLES `collect` WRITE;
/*!40000 ALTER TABLE `collect` DISABLE KEYS */;
INSERT INTO `collect` VALUES (4,19,2),(6,12,2);
/*!40000 ALTER TABLE `collect` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `file`
--

DROP TABLE IF EXISTS `file`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `file` (
  `id` int NOT NULL AUTO_INCREMENT,
  `originName` varchar(255) CHARACTER SET gb2312 COLLATE gb2312_chinese_ci DEFAULT NULL,
  `fileName` varchar(255) CHARACTER SET gb2312 COLLATE gb2312_chinese_ci DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=45 DEFAULT CHARSET=gb2312 ROW_FORMAT=DYNAMIC;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `file`
--

LOCK TABLES `file` WRITE;
/*!40000 ALTER TABLE `file` DISABLE KEYS */;
INSERT INTO `file` VALUES (1,'bht1.jpg','bht1.jpg'),(2,'bht2.jpg','bht2.jpg'),(3,'bht3.jpg','bht3.jpg'),(4,'bht4.jpg','bht4.jpg'),(5,'bht5.jpg','bht5.jpg'),(6,'changpai1.jpg','changpai1.jpg'),(7,'changpai2.jpg','changpai2.jpg'),(8,'changpai3.jpg','changpai3.jpg'),(9,'changpai4.jpg','changpai4.jpg'),(10,'changpai5.jpg','changpai5.jpg'),(11,'changpai6.jpg','changpai6.jpg'),(12,'changpai7.jpg','changpai7.jpg'),(13,'changpai8.jpg','changpai8.jpg'),(14,'changpai9.jpg','changpai9.jpg'),(15,'changpai10.jpg','changpai10.jpg'),(16,'yinleren1.jpg','yinleren1.jpg'),(17,'yinleren2.jpg','yinleren2.jpg'),(18,'yinleren3.jpg','yinleren3.jpg'),(19,'yinleren4.jpg','yinleren4.jpg'),(20,'yinleren5.jpg','yinleren5.jpg'),(21,'yinleren6.jpg','yinleren6.jpg'),(22,'yinleren7.jpg','yinleren7.jpg'),(23,'yinleren8.jpg','yinleren8.jpg'),(24,'yinleren9.jpg','yinleren9.jpg'),(25,'yinleren10.jpg','yinleren10.jpg'),(26,'2.mp3','21708845960119.mp3'),(27,'2.mp3','21708847733159.mp3'),(28,'110bpm,22.mp3','110bpm,221709600564608.mp3'),(29,'110bpm,22.mp3','110bpm,221709600757317.mp3'),(30,'110bpm,22.mp3','110bpm,221709601349512.mp3'),(31,'110bpm,22.mp3','110bpm,221709973185732.mp3'),(32,'QQ截图20240310120406.jpg','QQ截图202403101204061710043463481.jpg'),(33,'QQ截图20240310120406.jpg','QQ截图202403101204061710043479861.jpg'),(34,'QQ截图20240310120406.jpg','QQ截图202403101204061710044260270.jpg'),(35,'QQ截图20240310120406.jpg','QQ截图202403101204061710044534036.jpg'),(36,'UnderTheTrees.jpg','UnderTheTrees1710225355347.jpg'),(37,'UnderTheTrees.jpg','UnderTheTrees1710225361992.jpg'),(38,'UnderTheTrees.jpg','UnderTheTrees1710225528909.jpg'),(39,'Electric State.jpg','Electric State1710225655622.jpg'),(40,'Electric State.jpg','Electric State1710225782952.jpg'),(41,'Ostowana.jpg','Ostowana1710225924459.jpg'),(42,'Lyshiantus Records.jpg','Lyshiantus Records1710226042611.jpg'),(43,'NOXU Deep.jpg','NOXU Deep1710226161181.jpg'),(44,'110bpm,22.mp3','110bpm,221710226389764.mp3');
/*!40000 ALTER TABLE `file` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `label`
--

DROP TABLE IF EXISTS `label`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `label` (
  `id` int NOT NULL AUTO_INCREMENT,
  `username` varchar(50) CHARACTER SET gb2312 COLLATE gb2312_chinese_ci DEFAULT NULL,
  `password` varchar(50) CHARACTER SET gb2312 COLLATE gb2312_chinese_ci DEFAULT NULL,
  `lid` varchar(50) CHARACTER SET gb2312 COLLATE gb2312_chinese_ci DEFAULT NULL,
  `labelname` varchar(50) CHARACTER SET gb2312 COLLATE gb2312_chinese_ci DEFAULT NULL,
  `email` varchar(50) CHARACTER SET gb2312 COLLATE gb2312_chinese_ci DEFAULT NULL,
  `place` varchar(50) CHARACTER SET gb2312 COLLATE gb2312_chinese_ci DEFAULT NULL,
  `doe` date DEFAULT NULL,
  `genre` varchar(255) DEFAULT NULL,
  `labelpic` varchar(50) CHARACTER SET gb2312 COLLATE gb2312_chinese_ci DEFAULT NULL,
  `level` varchar(10) CHARACTER SET gb2312 COLLATE gb2312_chinese_ci DEFAULT '厂牌',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=gb2312 ROW_FORMAT=DYNAMIC;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `label`
--

LOCK TABLES `label` WRITE;
/*!40000 ALTER TABLE `label` DISABLE KEYS */;
INSERT INTO `label` VALUES (2,'010','200820e3227815ed1756a6b531e7e0d2','010','subsidia','trodd@yahoo.com','开明路22号','2024-02-07','dubstep,bass house,glich hop','/files/download/6','厂牌','2024-02-25 07:15:44'),(5,'017','dc5c7986daef50c1e02ab09b442ee34f','017','PRMD MUSIC','43643933@qq.com','人民路57号','2024-02-06','future house,future bass,progressive house,trance','/files/download/9','厂牌','2024-02-25 07:15:44'),(6,'007','dc5c7986daef50c1e02ab09b442ee34f','007','NIGHT','2352352@qq.com','上江小区2幢','2024-02-29','house,techno,tech house,future bass','/files/download/10','厂牌','2024-02-25 07:15:44'),(16,'0001','dc5c7986daef50c1e02ab09b442ee34f','0001','Under The Trees','123123@11.com','Belgium','2024-03-18','Indie Dance, Nu Disco','/files/download/38','厂牌','2024-03-12 06:38:56'),(17,'0002','dc5c7986daef50c1e02ab09b442ee34f','0002','Electric State','123123@11.com','United States','2024-03-19','Tech House, Deep House, Electro House, Progressive House, House','/files/download/40','厂牌','2024-03-12 06:43:06'),(18,'0003','dc5c7986daef50c1e02ab09b442ee34f','0003','Ostowana','123123@11.com',' Morocco','2024-03-26','Afro House, Downtempo, Deep House','/files/download/41','厂牌','2024-03-12 06:45:28'),(19,'0004','dc5c7986daef50c1e02ab09b442ee34f','0004','Lyshiantus Records ','123123@11.com',' Morocco','2024-03-27','Trance','/files/download/42','厂牌','2024-03-12 06:47:26'),(20,'0005','dc5c7986daef50c1e02ab09b442ee34f','0005','NOXU Deep','info@noxudeep.com',' Netherlands','2024-03-10','Tech House, Deep House, House','/files/download/43','厂牌','2024-03-12 06:49:25');
/*!40000 ALTER TABLE `label` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `lfm`
--

DROP TABLE IF EXISTS `lfm`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `lfm` (
  `id` int NOT NULL AUTO_INCREMENT,
  `uid` int DEFAULT NULL,
  `rate` int DEFAULT NULL,
  `lid` int DEFAULT NULL,
  UNIQUE KEY `lfm_id_uindex` (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=193 DEFAULT CHARSET=utf8mb3 ROW_FORMAT=DYNAMIC;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `lfm`
--

LOCK TABLES `lfm` WRITE;
/*!40000 ALTER TABLE `lfm` DISABLE KEYS */;
INSERT INTO `lfm` VALUES (1,1,10,1),(2,1,10,2),(3,1,10,3),(4,1,10,4),(5,1,10,5),(6,2,10,1),(7,2,10,2),(8,3,10,1),(9,4,10,1),(10,5,10,1),(11,2,10,3),(12,3,10,2),(13,4,10,2),(14,5,10,2),(15,3,10,3),(16,4,10,3),(17,4,10,4),(18,5,10,3),(19,2,10,4),(20,3,10,4),(62,18,9,2),(63,18,9,3),(64,18,3,4),(65,18,9,5),(66,18,9,6),(67,18,5,7),(68,18,11,8),(69,18,10,9),(70,18,10,10),(71,18,10,13),(72,18,9,14),(73,2,9,15),(74,3,3,15),(75,4,9,15),(76,5,9,15),(77,6,9,15),(78,7,5,15),(79,8,9,15),(80,9,9,15),(81,10,9,15),(82,11,9,15),(83,12,9,15),(84,13,9,15),(85,14,9,15),(86,15,9,15),(87,16,9,15),(88,17,9,15),(89,18,9,15),(90,19,9,2),(91,19,9,3),(92,19,9,4),(93,19,9,5),(94,19,9,6),(95,19,9,7),(96,19,5,8),(97,19,9,9),(98,19,9,10),(99,19,2,13),(100,19,9,14),(101,19,9,15),(102,11,9,3),(103,2,9,16),(104,3,9,16),(105,4,3,16),(106,5,10,16),(107,6,10,16),(108,7,5,16),(109,8,10,16),(110,9,10,16),(111,10,10,16),(112,11,10,16),(113,12,10,16),(114,13,10,16),(115,14,4,16),(116,15,9,16),(117,16,9,16),(118,17,9,16),(119,18,3,16),(120,19,9,16),(121,2,9,17),(122,3,9,17),(123,4,9,17),(124,5,9,17),(125,6,9,17),(126,7,9,17),(127,8,9,17),(128,9,9,17),(129,10,9,17),(130,11,9,17),(131,12,9,17),(132,13,9,17),(133,14,9,17),(134,15,9,17),(135,16,9,17),(136,17,9,17),(137,18,4,17),(138,19,9,17),(139,2,9,18),(140,3,4,18),(141,4,9,18),(142,5,9,18),(143,6,9,18),(144,7,9,18),(145,8,9,18),(146,9,4,18),(147,10,9,18),(148,11,9,18),(149,12,3,18),(150,13,9,18),(151,14,9,18),(152,15,9,18),(153,16,9,18),(154,17,9,18),(155,18,9,18),(156,19,0,18),(157,2,9,19),(158,3,9,19),(159,4,9,19),(160,5,0,19),(161,6,9,19),(162,7,9,19),(163,8,9,19),(164,9,9,19),(165,10,9,19),(166,11,9,19),(167,12,9,19),(168,13,9,19),(169,14,9,19),(170,15,9,19),(171,16,9,19),(172,17,9,19),(173,18,9,19),(174,19,9,19),(175,2,9,20),(176,3,9,20),(177,4,9,20),(178,5,0,20),(179,6,9,20),(180,7,9,20),(181,8,0,20),(182,9,9,20),(183,10,9,20),(184,11,9,20),(185,12,9,20),(186,13,9,20),(187,14,0,20),(188,15,9,20),(189,16,9,20),(190,17,0,20),(191,18,9,20),(192,19,9,20);
/*!40000 ALTER TABLE `lfm` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `liuyanban`
--

DROP TABLE IF EXISTS `liuyanban`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `liuyanban` (
  `id` int NOT NULL AUTO_INCREMENT,
  `username` varchar(50) DEFAULT NULL,
  `cheng` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `icon` varchar(50) DEFAULT NULL,
  `title` varchar(50) DEFAULT NULL,
  `content` varchar(500) DEFAULT NULL,
  `reply` varchar(500) DEFAULT NULL,
  `status` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT '0',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `parent` int DEFAULT '0',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `liuyanban`
--

LOCK TABLES `liuyanban` WRITE;
/*!40000 ALTER TABLE `liuyanban` DISABLE KEYS */;
INSERT INTO `liuyanban` VALUES (6,NULL,'qwe111',NULL,'qwe',NULL,NULL,'0','2024-03-12 06:30:30',0),(7,NULL,'qwe111',NULL,NULL,NULL,NULL,'0','2024-03-12 06:30:43',6),(8,NULL,'qwe321',NULL,NULL,NULL,NULL,'0','2024-03-12 06:31:07',6),(9,NULL,'qwe321',NULL,NULL,NULL,NULL,'0','2024-03-12 06:31:10',6),(10,NULL,'qwe321',NULL,NULL,NULL,NULL,'0','2024-03-12 06:47:41',6);
/*!40000 ALTER TABLE `liuyanban` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pinglun`
--

DROP TABLE IF EXISTS `pinglun`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `pinglun` (
  `id` int NOT NULL AUTO_INCREMENT,
  `pinglunneirong` varchar(500) CHARACTER SET gb2312 COLLATE gb2312_chinese_ci DEFAULT NULL,
  `pingfen` varchar(50) CHARACTER SET gb2312 COLLATE gb2312_chinese_ci DEFAULT NULL,
  `biao` varchar(50) CHARACTER SET gb2312 COLLATE gb2312_chinese_ci DEFAULT NULL,
  `pinglunren` varchar(50) CHARACTER SET gb2312 COLLATE gb2312_chinese_ci DEFAULT NULL,
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `shujuid` varchar(255) CHARACTER SET gb2312 COLLATE gb2312_chinese_ci DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=gb2312 ROW_FORMAT=DYNAMIC;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pinglun`
--

LOCK TABLES `pinglun` WRITE;
/*!40000 ALTER TABLE `pinglun` DISABLE KEYS */;
/*!40000 ALTER TABLE `pinglun` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sp`
--

DROP TABLE IF EXISTS `sp`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sp` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(50) CHARACTER SET gb2312 COLLATE gb2312_chinese_ci DEFAULT NULL,
  `pic` varchar(50) CHARACTER SET gb2312 COLLATE gb2312_chinese_ci DEFAULT NULL,
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=gb2312 ROW_FORMAT=DYNAMIC;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sp`
--

LOCK TABLES `sp` WRITE;
/*!40000 ALTER TABLE `sp` DISABLE KEYS */;
INSERT INTO `sp` VALUES (1,'P名称','/files/download/1','2024-02-25 07:15:44'),(2,'C名称','/files/download/2','2024-02-25 07:15:44'),(3,'N名称','/files/download/3','2024-02-25 07:15:44'),(4,'Q名称','/files/download/4','2024-02-25 07:15:44'),(5,'H名称','/files/download/5','2024-02-25 07:15:44');
/*!40000 ALTER TABLE `sp` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `xinwentongzhi`
--

DROP TABLE IF EXISTS `xinwentongzhi`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `xinwentongzhi` (
  `id` int NOT NULL AUTO_INCREMENT,
  `biaoti` varchar(50) CHARACTER SET gb2312 COLLATE gb2312_chinese_ci DEFAULT NULL,
  `leibie` varchar(50) CHARACTER SET gb2312 COLLATE gb2312_chinese_ci DEFAULT NULL,
  `neirong` longtext CHARACTER SET gb2312 COLLATE gb2312_chinese_ci,
  `dianjilv` varchar(50) CHARACTER SET gb2312 COLLATE gb2312_chinese_ci DEFAULT NULL,
  `dianzan_d` int DEFAULT '0',
  `dianzan_c` int DEFAULT '0',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=gb2312 ROW_FORMAT=DYNAMIC;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `xinwentongzhi`
--

LOCK TABLES `xinwentongzhi` WRITE;
/*!40000 ALTER TABLE `xinwentongzhi` DISABLE KEYS */;
INSERT INTO `xinwentongzhi` VALUES (10,'我市359名新民警陆续上岗','公告信息','<DIV id=zoom>\r\n<TABLE align=center>\r\n<TBODY>\r\n<TR>\r\n<TD><IMG src=\"http://www.wenzhou.gov.cn/picture/0/101215053612533.jpg\" border=0></TD></TR></TBODY></TABLE><!--<$[信息内容]>begin--><!--ZJEG_RSS.content.begin-->\r\n<META name=ContentStart>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 我市359名新民警日前已陆续到各县（市、区）公安基层岗位上岗，这是我市公安队伍近年来人数最多的一次扩充。上岗前，这些新民警都接受了擒拿格斗、射击等专项训练；上岗后，他们将成为今冬打击“两抢一盗”新力量。图为新民警在培训班结业典礼上表演擒拿格斗。（林舒菡 摄） \r\n<META name=ContentEnd><!--ZJEG_RSS.content.end--><!--<$[信息内容]>end--></DIV>','42',0,0,'2024-02-25 07:15:44'),(11,'钱库辖区消防违法拘留公告5','公告信息','&nbsp; \r\n<TABLE class=MsoTableGrid style=\"BORDER-RIGHT: medium none; BORDER-TOP: medium none; BORDER-LEFT: medium none; WIDTH: 409.4pt; BORDER-BOTTOM: medium none; BORDER-COLLAPSE: collapse; mso-border-alt: solid windowtext .5pt; mso-yfti-tbllook: 480; mso-padding-alt: 0cm 5.4pt 0cm 5.4pt; mso-border-insideh: .5pt solid windowtext; mso-border-insidev: .5pt solid windowtext\" cellSpacing=0 cellPadding=0 width=546 border=1>\r\n<TBODY>\r\n<TR style=\"HEIGHT: 37.85pt; mso-yfti-irow: 0; mso-yfti-firstrow: yes\">\r\n<TD style=\"BORDER-RIGHT: windowtext 1pt solid; PADDING-RIGHT: 5.4pt; BORDER-TOP: windowtext 1pt solid; PADDING-LEFT: 5.4pt; PADDING-BOTTOM: 0cm; BORDER-LEFT: windowtext 1pt solid; WIDTH: 86.4pt; PADDING-TOP: 0cm; BORDER-BOTTOM: windowtext 1pt solid; HEIGHT: 37.85pt; mso-border-alt: solid windowtext .5pt\" width=115>\r\n<P class=MsoNormal style=\"TEXT-ALIGN: center\" align=center><SPAN style=\"FONT-SIZE: 14pt; FONT-FAMILY: 黑体; mso-hansi-font-family: 宋体\">单位<SPAN lang=EN-US><?xml:namespace prefix = o ns = \"urn:schemas-microsoft-com:office:office\" /><o:p></o:p></SPAN></SPAN></P></TD>\r\n<TD style=\"BORDER-RIGHT: windowtext 1pt solid; PADDING-RIGHT: 5.4pt; BORDER-TOP: windowtext 1pt solid; PADDING-LEFT: 5.4pt; PADDING-BOTTOM: 0cm; BORDER-LEFT: medium none; WIDTH: 45pt; PADDING-TOP: 0cm; BORDER-BOTTOM: windowtext 1pt solid; HEIGHT: 37.85pt; mso-border-alt: solid windowtext .5pt; mso-border-left-alt: solid windowtext .5pt\" width=60>\r\n<P class=MsoNormal style=\"TEXT-ALIGN: center\" align=center><SPAN style=\"FONT-SIZE: 14pt; FONT-FAMILY: 黑体; mso-hansi-font-family: 宋体\">时间<SPAN lang=EN-US><o:p></o:p></SPAN></SPAN></P></TD>\r\n<TD style=\"BORDER-RIGHT: windowtext 1pt solid; PADDING-RIGHT: 5.4pt; BORDER-TOP: windowtext 1pt solid; PADDING-LEFT: 5.4pt; PADDING-BOTTOM: 0cm; BORDER-LEFT: medium none; WIDTH: 83.75pt; PADDING-TOP: 0cm; BORDER-BOTTOM: windowtext 1pt solid; HEIGHT: 37.85pt; mso-border-alt: solid windowtext .5pt; mso-border-left-alt: solid windowtext .5pt\" width=112>\r\n<P class=MsoNormal style=\"TEXT-ALIGN: center\" align=center><SPAN style=\"FONT-SIZE: 14pt; FONT-FAMILY: 黑体; mso-hansi-font-family: 宋体\">存在隐患<SPAN lang=EN-US><o:p></o:p></SPAN></SPAN></P></TD>\r\n<TD style=\"BORDER-RIGHT: windowtext 1pt solid; PADDING-RIGHT: 5.4pt; BORDER-TOP: windowtext 1pt solid; PADDING-LEFT: 5.4pt; PADDING-BOTTOM: 0cm; BORDER-LEFT: medium none; WIDTH: 67.8pt; PADDING-TOP: 0cm; BORDER-BOTTOM: windowtext 1pt solid; HEIGHT: 37.85pt; mso-border-alt: solid windowtext .5pt; mso-border-left-alt: solid windowtext .5pt\" width=90>\r\n<P class=MsoNormal style=\"TEXT-ALIGN: center\" align=center><SPAN style=\"FONT-SIZE: 14pt; FONT-FAMILY: 黑体; mso-hansi-font-family: 宋体\">责任人<SPAN lang=EN-US><o:p></o:p></SPAN></SPAN></P></TD>\r\n<TD style=\"BORDER-RIGHT: windowtext 1pt solid; PADDING-RIGHT: 5.4pt; BORDER-TOP: windowtext 1pt solid; PADDING-LEFT: 5.4pt; PADDING-BOTTOM: 0cm; BORDER-LEFT: medium none; WIDTH: 64.4pt; PADDING-TOP: 0cm; BORDER-BOTTOM: windowtext 1pt solid; HEIGHT: 37.85pt; mso-border-alt: solid windowtext .5pt; mso-border-left-alt: solid windowtext .5pt\" width=86>\r\n<P class=MsoNormal style=\"TEXT-ALIGN: center\" align=center><SPAN style=\"FONT-SIZE: 14pt; FONT-FAMILY: 黑体; mso-hansi-font-family: 宋体\">处理<SPAN lang=EN-US><o:p></o:p></SPAN></SPAN></P>\r\n<P class=MsoNormal style=\"TEXT-ALIGN: center\" align=center><SPAN style=\"FONT-SIZE: 14pt; FONT-FAMILY: 黑体; mso-hansi-font-family: 宋体\">情况<SPAN lang=EN-US><o:p></o:p></SPAN></SPAN></P></TD>\r\n<TD style=\"BORDER-RIGHT: windowtext 1pt solid; PADDING-RIGHT: 5.4pt; BORDER-TOP: windowtext 1pt solid; PADDING-LEFT: 5.4pt; PADDING-BOTTOM: 0cm; BORDER-LEFT: medium none; WIDTH: 62.05pt; PADDING-TOP: 0cm; BORDER-BOTTOM: windowtext 1pt solid; HEIGHT: 37.85pt; mso-border-alt: solid windowtext .5pt; mso-border-left-alt: solid windowtext .5pt\" width=83>\r\n<P class=MsoNormal style=\"TEXT-INDENT: 7pt; TEXT-ALIGN: center; mso-char-indent-count: .5\" align=center><SPAN style=\"FONT-SIZE: 14pt; FONT-FAMILY: 黑体; mso-hansi-font-family: 宋体\">备注<SPAN lang=EN-US><o:p></o:p></SPAN></SPAN></P></TD></TR>\r\n<TR style=\"HEIGHT: 59.35pt; mso-yfti-irow: 1; mso-yfti-lastrow: yes\">\r\n<TD style=\"BORDER-RIGHT: windowtext 1pt solid; PADDING-RIGHT: 5.4pt; BORDER-TOP: medium none; PADDING-LEFT: 5.4pt; PADDING-BOTTOM: 0cm; BORDER-LEFT: windowtext 1pt solid; WIDTH: 86.4pt; PADDING-TOP: 0cm; BORDER-BOTTOM: windowtext 1pt solid; HEIGHT: 59.35pt; mso-border-alt: solid windowtext .5pt; mso-border-top-alt: solid windowtext .5pt\" vAlign=top width=115>\r\n<P class=MsoNormal><U><SPAN style=\"FONT-SIZE: 14pt; COLOR: black; FONT-FAMILY: 宋体; LETTER-SPACING: 0.9pt; mso-font-kerning: 0pt; mso-bidi-font-family: 宋体\">望里经纬再生棉纺厂</SPAN></U><SPAN lang=EN-US><o:p></o:p></SPAN></P></TD>\r\n<TD style=\"BORDER-RIGHT: windowtext 1pt solid; PADDING-RIGHT: 5.4pt; BORDER-TOP: medium none; PADDING-LEFT: 5.4pt; PADDING-BOTTOM: 0cm; BORDER-LEFT: medium none; WIDTH: 45pt; PADDING-TOP: 0cm; BORDER-BOTTOM: windowtext 1pt solid; HEIGHT: 59.35pt; mso-border-alt: solid windowtext .5pt; mso-border-left-alt: solid windowtext .5pt; mso-border-top-alt: solid windowtext .5pt\" vAlign=top width=60>\r\n<P class=MsoNormal><?xml:namespace prefix = st1 ns = \"urn:schemas-microsoft-com:office:smarttags\" /><st1:chsdate w:st=\"on\" IsROCDate=\"False\" IsLunarDate=\"False\" Day=\"13\" Month=\"9\" Year=\"2011\"><SPAN lang=EN-US>2011</SPAN><SPAN style=\"FONT-FAMILY: 宋体; mso-hansi-font-family: &#39;Times New Roman&#39;; mso-ascii-font-family: &#39;Times New Roman&#39;\">年</SPAN><SPAN lang=EN-US>9</SPAN><SPAN style=\"FONT-FAMILY: 宋体; mso-hansi-font-family: &#39;Times New Roman&#39;; mso-ascii-font-family: &#39;Times New Roman&#39;\">月</SPAN><SPAN lang=EN-US>13</SPAN><SPAN style=\"FONT-FAMILY: 宋体; mso-hansi-font-family: &#39;Times New Roman&#39;; mso-ascii-font-family: &#39;Times New Roman&#39;\">日</SPAN></st1:chsdate><SPAN lang=EN-US><o:p></o:p></SPAN></P></TD>\r\n<TD style=\"BORDER-RIGHT: windowtext 1pt solid; PADDING-RIGHT: 5.4pt; BORDER-TOP: medium none; PADDING-LEFT: 5.4pt; PADDING-BOTTOM: 0cm; BORDER-LEFT: medium none; WIDTH: 83.75pt; PADDING-TOP: 0cm; BORDER-BOTTOM: windowtext 1pt solid; HEIGHT: 59.35pt; mso-border-alt: solid windowtext .5pt; mso-border-left-alt: solid windowtext .5pt; mso-border-top-alt: solid windowtext .5pt\" vAlign=top width=112>\r\n<P class=MsoNormal><SPAN style=\"FONT-FAMILY: 宋体; mso-hansi-font-family: &#39;Times New Roman&#39;; mso-ascii-font-family: &#39;Times New Roman&#39;\">车间门口（棉花堆旁）吸烟</SPAN><SPAN lang=EN-US><o:p></o:p></SPAN></P></TD>\r\n<TD style=\"BORDER-RIGHT: windowtext 1pt solid; PADDING-RIGHT: 5.4pt; BORDER-TOP: medium none; PADDING-LEFT: 5.4pt; PADDING-BOTTOM: 0cm; BORDER-LEFT: medium none; WIDTH: 67.8pt; PADDING-TOP: 0cm; BORDER-BOTTOM: windowtext 1pt solid; HEIGHT: 59.35pt; mso-border-alt: solid windowtext .5pt; mso-border-left-alt: solid windowtext .5pt; mso-border-top-alt: solid windowtext .5pt\" vAlign=top width=90>\r\n<P class=MsoNormal><U><SPAN style=\"FONT-SIZE: 14pt; COLOR: black; FONT-FAMILY: 宋体; LETTER-SPACING: 0.9pt; mso-font-kerning: 0pt; mso-bidi-font-family: 宋体\">赵明军</SPAN></U><SPAN lang=EN-US><o:p></o:p></SPAN></P></TD>\r\n<TD style=\"BORDER-RIGHT: windowtext 1pt solid; PADDING-RIGHT: 5.4pt; BORDER-TOP: medium none; PADDING-LEFT: 5.4pt; PADDING-BOTTOM: 0cm; BORDER-LEFT: medium none; WIDTH: 64.4pt; PADDING-TOP: 0cm; BORDER-BOTTOM: windowtext 1pt solid; HEIGHT: 59.35pt; mso-border-alt: solid windowtext .5pt; mso-border-left-alt: solid windowtext .5pt; mso-border-top-alt: solid windowtext .5pt\" vAlign=top width=86>\r\n<P class=MsoNormal><SPAN style=\"FONT-FAMILY: 宋体; mso-hansi-font-family: &#39;Times New Roman&#39;; mso-ascii-font-family: &#39;Times New Roman&#39;\">行政拘留伍日</SPAN><SPAN lang=EN-US><o:p></o:p></SPAN></P></TD>\r\n<TD style=\"BORDER-RIGHT: windowtext 1pt solid; PADDING-RIGHT: 5.4pt; BORDER-TOP: medium none; PADDING-LEFT: 5.4pt; PADDING-BOTTOM: 0cm; BORDER-LEFT: medium none; WIDTH: 62.05pt; PADDING-TOP: 0cm; BORDER-BOTTOM: windowtext 1pt solid; HEIGHT: 59.35pt; mso-border-alt: solid windowtext .5pt; mso-border-left-alt: solid windowtext .5pt; mso-border-top-alt: solid windowtext .5pt\" vAlign=top width=83>\r\n<P class=MsoNormal><SPAN lang=EN-US><o:p>&nbsp;</o:p></SPAN></P></TD></TR></TBODY></TABLE>','77',0,0,'2024-02-25 07:15:44'),(12,'苍南县企业家协会招聘人员公告','公告信息','<P style=\"LINE-HEIGHT: 35pt; TEXT-INDENT: 32pt; MARGIN: 0cm 0cm 0pt; mso-line-height-rule: exactly; mso-char-indent-count: 2.0\" class=MsoNormal><SPAN style=\"FONT-FAMILY: 仿宋_GB2312; FONT-SIZE: 16pt\">苍南县企业家协会是经县民政局核准登记的非盈利性社会团体法人，因工作需要，决定招聘工作人员<FONT face=仿宋_GB2312><SPAN lang=EN><FONT size=5>2</FONT></SPAN>名。<SPAN lang=EN><?xml:namespace prefix = o ns = \"urn:schemas-microsoft-com:office:office\" /><o:p></o:p></SPAN></FONT></SPAN></P>\r\n<P style=\"LINE-HEIGHT: 35pt; TEXT-INDENT: 32pt; MARGIN: 0cm 0cm 0pt; mso-line-height-rule: exactly; mso-char-indent-count: 2.0\" class=MsoNormal><SPAN style=\"FONT-FAMILY: 仿宋_GB2312; FONT-SIZE: 16pt\">一、岗位名称和人数：秘书<FONT face=仿宋_GB2312><SPAN lang=EN><FONT size=5>2</FONT></SPAN>人。<SPAN lang=EN><o:p></o:p></SPAN></FONT></SPAN></P>\r\n<P style=\"LINE-HEIGHT: 35pt; TEXT-INDENT: 32pt; MARGIN: 0cm 0cm 0pt; mso-line-height-rule: exactly; mso-char-indent-count: 2.0\" class=MsoNormal><SPAN style=\"FONT-FAMILY: 仿宋_GB2312; FONT-SIZE: 16pt\">二、招聘条件：<SPAN lang=EN><o:p></o:p></SPAN></SPAN></P>\r\n<P style=\"LINE-HEIGHT: 35pt; TEXT-INDENT: 32pt; MARGIN: 0cm 0cm 0pt; mso-line-height-rule: exactly; mso-char-indent-count: 2.0\" class=MsoNormal><SPAN style=\"FONT-FAMILY: 仿宋_GB2312; FONT-SIZE: 16pt\">身体健康，年龄<FONT face=仿宋_GB2312><SPAN lang=EN><FONT size=5>35</FONT></SPAN>周数以下，男女不限，户籍不限，全日制大专毕业及以上学历，有较高的综合文字水平，有一定的人际沟通和组织协调能力，会熟练使用电脑办公软件。<SPAN lang=EN><o:p></o:p></SPAN></FONT></SPAN></P>\r\n<P style=\"LINE-HEIGHT: 35pt; TEXT-INDENT: 37.6pt; MARGIN: 0cm 0cm 0pt; mso-line-height-rule: exactly; mso-char-indent-count: 2.35\" class=MsoNormal><SPAN style=\"FONT-FAMILY: 仿宋_GB2312; FONT-SIZE: 16pt\">三、福利待遇：工资福利待遇参照苍南县事业单位人员标准执行。<SPAN lang=EN><o:p></o:p></SPAN></SPAN></P>\r\n<P style=\"LINE-HEIGHT: 35pt; TEXT-INDENT: 37.6pt; MARGIN: 0cm 0cm 0pt; mso-line-height-rule: exactly; mso-char-indent-count: 2.35\" class=MsoNormal><SPAN style=\"FONT-FAMILY: 仿宋_GB2312; FONT-SIZE: 16pt\">四、报名办法：应聘人员请于<FONT face=仿宋_GB2312><SPAN lang=EN><FONT size=5>3</FONT></SPAN>月 <SPAN lang=EN><FONT size=5>7</FONT></SPAN>日前持本人身份证、简历、学历证书等相关证书的原件和复印件各<SPAN lang=EN><FONT size=5>1</FONT></SPAN>份，两寸近期照片<SPAN lang=EN><FONT size=5>1</FONT></SPAN>张，到苍南县灵溪镇江湾路金城大厦<SPAN lang=EN><FONT size=5>601</FONT></SPAN>室报名。联系电话 <SPAN lang=EN><FONT size=5>64771806</FONT></SPAN>，联系人 </FONT><?xml:namespace prefix = st1 ns = \"urn:schemas-microsoft-com:office:smarttags\" /><st1:PersonName ProductID=\"潘\" w:st=\"on\">潘</st1:PersonName>小姐，<st1:PersonName ProductID=\"黄\" w:st=\"on\">黄</st1:PersonName>小姐 ，经资格审核后组织考核选拔（具体考核办法另行通知），择优录取。<SPAN lang=EN><o:p></o:p></SPAN></SPAN></P>\r\n<P style=\"LINE-HEIGHT: 35pt; MARGIN: 0cm 0cm 0pt; mso-line-height-rule: exactly\" class=MsoNormal><SPAN style=\"FONT-FAMILY: 仿宋_GB2312; FONT-SIZE: 16pt\" lang=EN><o:p>&nbsp;</o:p></SPAN></P>\r\n<P style=\"LINE-HEIGHT: 35pt; MARGIN: 0cm 0cm 0pt; mso-line-height-rule: exactly\" class=MsoNormal><SPAN style=\"FONT-FAMILY: 仿宋_GB2312; FONT-SIZE: 16pt\" lang=EN><o:p>&nbsp;</o:p></SPAN></P><SPAN style=\"FONT-FAMILY: 仿宋_GB2312; FONT-SIZE: 16pt\">\r\n<P style=\"LINE-HEIGHT: 35pt; TEXT-INDENT: 216pt; MARGIN: 0cm 0cm 0pt; mso-line-height-rule: exactly; mso-char-indent-count: 13.5\" class=MsoNormal><SPAN style=\"FONT-FAMILY: 仿宋_GB2312; FONT-SIZE: 16pt\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 苍南县企业家协会<SPAN lang=EN><o:p></o:p></SPAN></SPAN></P>\r\n<P style=\"LINE-HEIGHT: 35pt; TEXT-INDENT: 168pt; MARGIN: 0cm 0cm 0pt; mso-line-height-rule: exactly; mso-char-indent-count: 10.5\" class=MsoNormal><SPAN style=\"FONT-FAMILY: 仿宋_GB2312; FONT-SIZE: 16pt\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;二○一一年二月二十八日</SPAN></P></SPAN>','72',0,0,'2024-02-25 07:15:44'),(13,'钱库镇举行社区建设规划评审会','公告信息','<P>&nbsp;&nbsp;&nbsp; 为统筹城乡发展，推进城乡一体化建设,1月17日，钱库镇举行新安、玉龙、括东等社区建设规划的专家评审会。会议邀请来县城乡规划设计院专家现场解析，县住建局、发改委、国土局、水利局等单位及钱库各社区的相关负责人参加。</P>\r\n<P>&nbsp;&nbsp;&nbsp; 在县城乡规划设计设计人员对新编的新安、玉龙、合作、括东、项桥、河滨等6个社区规划方案作出详细的介绍后，县住建局、发改委、国土局、水利局等单位从各个方面对规划方案实施的科学性、可行性等进行论证与指导，同时钱库各社区负责人也从各自社区工作职责出发，提出自己的建议和看法。会议在热烈的气氛中进行，评审会上，与会人员对方案给予充分的肯定，同时提出一些修改意见，要求设计单位根据修改意见，进一步完善规划方案。</P>\r\n<P>&nbsp;&nbsp;&nbsp; 据了解，除通过应邀专家进行评审外，钱库镇还将在此基础上进行广泛调研，实地走访，充分征求党员、干部、群众意见，拿出初步方案，按照农村电网改造、道路交通、农田水利整治等统一规划，力求符合全域理念，全面谋划美好乡村建设。(缪克梯)</P>','15',0,0,'2024-02-25 07:15:44'),(14,'百年林夫 版画先驱','公告信息','<P>&nbsp;&nbsp;&nbsp; 今年是林夫诞辰100 周年。他不仅是我国新兴版画先驱之一，同时还是中国文化艺术界著名革命烈士。</P>\r\n<P>&nbsp;&nbsp;&nbsp; 林夫，原名林裕，字宽如，1911 年 2 月 22 日出生于平阳县江南林家塔村（今属苍南县钱库镇）一个贫苦农家。 1932 年中学毕业后，进入上海美术专科学校西画系。在校期间，他加入中国共产党，并从事地下活动，上世纪 30 年代参加鲁迅倡导的中国新兴木刻运动，为鲁迅珍视的青年木刻家之一。他走上了一条全新的道路，刻出了许多反映劳动人民苦难与抗争的作品。 1942 年 6 月，在闽北“赤石暴动”中牺牲，享年 31 岁。林夫不仅是我国新兴版画先驱之一，同时还是中国文化艺术界著名革命烈士。 </P>\r\n<P>&nbsp;&nbsp;&nbsp; 林夫的版画题材广泛，刀法粗犷，黑白对比强烈，善于用他的刀和笔反映现实生活和宣传革命道理。他先后创作的《马克思肖像》和《毛泽东肖像》木刻，是国内同类作品中最早的木刻肖像，颇具历史文献价值。 </P>\r\n<P>&nbsp;&nbsp;&nbsp; 占地面积达1600 平方米的林夫纪念馆，共有 7 个陈列室，陈列着林夫遗作 46 幅，其中 29 幅木刻作品， 10 幅砖刻版画， 7 幅漫画木刻。林夫纪念馆在温州苍南县钱库镇林家塔村建成开放以来，自 1999 年开馆以来，已接待了一批又一批的观众。林夫纪念馆也被命名为温州市爱国主义教育基地。 (缪克梯)<BR></P>','57',0,0,'2024-02-25 07:15:44'),(15,'钱库开展农村无照经营整治','公告信息','<DIV align=left>&nbsp;&nbsp;&nbsp;&nbsp;9月7-8日，钱库工商所组织执法人员对望里办事处望中路、望洲街、站前街等主要街道进行无照经营清理整治，查处无照经营6家，责令限期办理营业执照17户，取得农村无照经营整治的初步成效。<BR></DIV>\r\n<DIV align=left>&nbsp;&nbsp;&nbsp;&nbsp;针对望里办事处主要街道经营户相对集中的情况，钱库工商所在前期调查摸底的基础上，专门安排时间，抽调人员对望里办事处的主要街道进行无照经营清理整治，对无前置条件而未办理营业执照的，予以立案，适用无照经营快捷处置进行处理；对涉及前置许可的，责令限期办理营业执照。此次行动共计出动执法人员14人次，查处无照经营6家，责令限期办理营业执照17家。在清理整治的同时，做好宣传工作，处罚与教育相结合，取得农村无照经营整治的初步成效。(钱工商)</DIV>\r\n<P align=left>\r\n<SCRIPT>\r\nfunction closePage(){\r\n	window.close();\r\n}\r\n</SCRIPT>\r\n</P>','86',0,0,'2024-02-25 07:15:44'),(16,'温州创新监管护“最年轻银行”成长','公告信息','<P>　　村镇银行是中国最年轻的银行机构，在温州这块“金改试验田”里已经成长出了6家“最年轻银行”。记者从温州银监分局获悉，我市按照“加快农村新型金融机构试点，有力支持和服务新农村建设”的要求，通过实施分类监管措施，创新和实践监管方式和方法，摸索出了一套“温州监管法”，有效引导辖内村镇银行稳健发展。</P>\r\n<P>　　2008年，我市启动村镇银行试点工作，在永嘉县和苍南县两地筹建村镇银行。2009年4月21日，温州市第一家村镇银行――永嘉恒升村镇银行在永嘉县瓯北开张。据温州银监分局统计，目前全市已开业6家村镇银行，股本总额合计14.9亿，其中民营企业资本为14.43亿元，涉及民营企业87家。</P>\r\n<P>　　据了解，温州银监分局理顺监管机制，落实主监管员制度，完善村镇银行监管架构和岗位职责，以现场检查和非现场监管为架构，专岗专职，业务到人；创新建立“答辩式”季度分析例会机制，通过机构自我评价和监管部门评价的互动方式，促进双方的深度沟通；积极探索村镇银行自律机制建设，在银行业协会体制下成立村镇银行工作部，全面协调辖内村镇银行行业性事务。</P>\r\n<P>　　根据温州市辖内村镇银行主发起机构种类繁多的特点，温州银监分局积极采取分类监管措施，扬长避短，充分发挥各类机构的优势。一是鼓励国有大型银行发起设立的村镇银行创新管理模式，压缩管理链条，强调村镇银行自主经营的独立性；二是引导股份制及城市商业银行发起设立的村镇银行合理定位市场，密切监测其与主发起行的业务往来，避免村镇银行成为其“影子银行”；三是推动农村银行发起设立村镇银行加强内控机制建设，强化日常监管和业务辅导，促进内生创新能力的提升。</P>\r\n<P>　　温州银监分局还明确了监管底线和定位要求，防止村镇银行业务非农化和大额化。对银行承兑汇票业务超过规定比例的平阳浦发村镇银行采取了限制票据业务发展的监管措施；对存在垒大户的永嘉恒升村镇银行，以监管意见书的形式要求其限期压缩大额贷款余额；对户均贷款超过100万元的平阳浦发村镇银行和前十大户贷款集中度比例接近75％的文成北银村镇银行进行了风险提示。</P>\r\n<META name=ContentEnd><!--ZJEG_RSS.content.end--><!--<$[信息内容]>end-->','71',0,0,'2024-02-25 07:15:44'),(17,'县公共资源交易中心发挥平台作用','公告信息','&nbsp;&nbsp;&nbsp; 12月15日消息：县公共资源交易中心采取积极有效的措施，努力化解运行中遇到的各种难点热点问题，较好地发挥了平台作用。据了解，今年中心平台累计进场项目478项，交易总额达45.82亿元，与去年同期相比增长44.22%。\r\n<P>&nbsp;&nbsp;&nbsp; 县公共资源交易中心积极推行资格后审制度，把治理围标、串标现象作为突出问题来抓，改变过去资格预审的做法，对200万元以上的工程建设项目招标活动，在开标后对投标人进行资格审查，实行了网上下载招标文件，网上公开招标答疑等措施。同时该中心推行政府采购最低评标价修正法，针对不同投标产品的不同质量、不同服务进行报价修正，以修正后的报价最低者中标，克服政府采购最低价中标产品的价低质次等问题，使采购单位能用合理的价格买到满意的产品。该评审办法的合理性、公正性不仅得到投标供应商和采购单位的认可，还被其它县市采纳和推广。在全市公共资源交易平台中，该中心率先推行经营性用地招拍挂出让底价评审专家确定的办法，即在地块出让当天，从事前参加现场勘踏的13名专家中再随机抽取9名，于出让活动前1小时集中指定评标室确定底价（保留价），整个过程都在保密情况下完成，确保底价确定的科学性、保密性，体现了土地的市场价值，也有效地遏制了串标行为，实现了国有资产的保值增值。今年通过这种方法出让的地块，土地出让金累计增收7.85亿元。</P><!--advertisement code begin--><!--advertisement code end-->\r\n<P>&nbsp;&nbsp;&nbsp; 据悉，今年该中心平台累计进场项目478项，交易总额达45.82亿元，与去年同期相比增长44.22%。其中，工程建设项目132项，预算投资32.09亿元，实际交易额29.12亿元，节约额2.97亿元，节约率为9.26%；政府采购324宗，预算安排资金0.90亿元，实际中标价0.79亿元，节约0.11亿元，节约率为12.22%；土地交易22宗，起始价8.05亿元，实际中标价15.91亿元，增幅7.86亿元，增幅达97.63%。（记者&nbsp; 方耀星&nbsp; 通讯员&nbsp; 朱敬铨）</P>','63',0,0,'2024-02-25 07:15:44'),(18,'谁偷走了我们的公厕温州一公厕一夜不翼而飞','公告信息','<div align=\"center\">\r\n	<a href=\"http://news.zjol.com.cn/\" target=\"_blank\"></a> <a href=\"http://news.zjol.com.cn/08ms/index.shtml\" target=\"_blank\"></a> <a href=\"http://showbbs.zjol.com.cn/\" target=\"_blank\"></a>\r\n</div>\r\n<!----><span style=\"font-size:14px;line-height:25px;\"> \r\n<div id=\"ArticleCnt\">\r\n	<!--function content() parse begin-->\r\n	<table cellspacing=\"20\" cellpadding=\"0\" align=\"center\">\r\n		<tbody>\r\n			<tr>\r\n				<td>\r\n					<img src=\"http://img.zjol.com.cn/pic/0/03/92/44/3924414_757702.jpg\" border=\"0\" />\r\n				</td>\r\n			</tr>\r\n		</tbody>\r\n	</table>\r\n	<p>\r\n		<!--mark ( diantou ) parse begin--><b>浙江在线09月14日讯</b> <!-- mark ( diantou ) parse end-->“这里的公共厕所呢？”吴先生前几天到乐清市区南大街一带办事，想“方便”了，就来到了县前路。可他找来找去，就是找不到记忆中的那间公厕。<br />\r\n公厕究竟哪儿去了？昨天，记者从乐清乐成镇政府了解到，这个公共厕所一夜之间被村民拆了。乐成镇政府正在努力和村民协商，尽快恢复公厕原貌。\r\n	</p>\r\n	<p>\r\n		<strong> 被拆公厕</strong>\r\n	</p>\r\n	<p>\r\n		<strong> 光改建就花了15万</strong>\r\n	</p>\r\n	<p>\r\n		县前路是乐清主要的闹市区。这座公共厕所，是路人最大的“方便”处。\r\n	</p>\r\n	<p>\r\n		记者从乐成镇城乡建设服务站了解到，乐清市区县前路公厕始建于上世纪70年代，最早归属于南门村。厕所坐落于县前路18号边，占地面积47.3平方米，建筑面积60平方米。其间多次改建，尤其是在2003年为创卫生城市，市财政专项拨款改建和修缮公厕，该公厕被投入15余万元进行了全面改建，达到省一类公厕标准。\r\n	</p>\r\n	<p>\r\n		但今年5月2日晚，一些村民擅自拆除了该公厕。这样一来，南大街一带的商业和闹市区就没有了公厕，群众“方便”极不方便。\r\n	</p>\r\n	<p>\r\n		乐成镇镇长廖凯峰说，公厕在夜半被拆的，镇里也不知道是谁拆的。南门村的村民，谁也不承认参与了拆厕所。\r\n	</p>\r\n	<p>\r\n		<strong> 毁厕建房</strong>\r\n	</p>\r\n	<p>\r\n		<strong> 租金起码十多万</strong>\r\n	</p>\r\n	<p>\r\n		村民为什么要拆厕所？多数村民说公厕坏了这里风水，但这只是借口。\r\n	</p>\r\n	<p>\r\n		“这一带比较热闹，这么几间房子要租出去的话，租金起码在10万元以上。”了解行情的乐清居民透露。\r\n	</p>\r\n	<p>\r\n		对于拆厕所，南门村民显得理直气壮：“这个地归属权应该属于村里的，我们想建什么就建什么。”\r\n	</p>\r\n	<p>\r\n		而镇长廖凯峰告诉记者，由于这座公厕是南门村老厕所改建来的，所以对于归属权问题一直没有划清。\r\n	</p>\r\n	<p>\r\n		“公厕是属于公共设施，还是村里的集体土地？”廖凯峰说，“这个问题，我们也不清楚。”\r\n	</p>\r\n	<p>\r\n		<strong> 还公厕原貌</strong>\r\n	</p>\r\n	<p>\r\n		<strong> 还有两道坎</strong>\r\n	</p>\r\n	<p>\r\n		公厕被拆后，镇政府一直和南门村民协商。没想到几个月后，协商还没得出结果，村民已先行一步――公厕原址上已打好地基，一丛丛钢筋拔地而起，无声地告诉人们：这里马上要“另起炉灶”了。\r\n	</p>\r\n	<p>\r\n		9月10日，乐成镇政府、市市政园林局、乐成规划所、乐成派出所等单位联合行动，出动一百多人对这处违章建筑进行了强制拆除。\r\n	</p>\r\n	<p>\r\n		廖凯峰告诉记者，这一处违章建筑强拆后将尽快恢复原貌。\r\n	</p>\r\n	<p>\r\n		那么究竟什么时候能恢复原貌？修建新公厕的钱从哪里来？这些后续问题，让乐成镇政府很是头疼。\r\n	</p>\r\n	<p>\r\n		“一来是厕所的归属地问题，二来厕所到底是谁拆的还没有查清楚。”乐清镇政府相关人员透露，强拆能进行，主要因为村里没有经过任何审批就开始建房。\r\n	</p>\r\n	<p>\r\n		看来，路人要在这里解决“方便”问题，还要等很长时间。\r\n	</p>\r\n<!--function: content() parse end 0ms cost! --><!--advertisement code begin-->\r\n</div>\r\n</span>','86',0,0,'2024-02-25 07:15:44'),(19,'黄宝坤督导鹿城攻防3号统一行动','公告信息','<P>　　7月17日晚，鹿城警方在城区开展“平安13”攻防3号统一清查行动，简短的启动仪式后，1000余警力奔赴各点展开行动。市委常委、公安局长黄宝坤到现场指导检查。</P>\r\n<P>　　本次行动重点清查一批藏污纳垢的易涉黄赌毒的出租房、场所，处罚一批场所业主和出租房房东，打处一批涉嫌两抢等侵财型及黄赌毒等犯罪嫌疑人，处罚一批违法人员（<SPAN style=\"FONT-FAMILY: 楷体, 楷体_GB2312\"><FONT face=\"\">包括违法业主和房东</FONT></SPAN>）。行动期间，警方针对西片双屿、鞋都、黄龙辖区开展重点清查，全力净化城区西片的治安环境。</P>\r\n<P>　　夏季是公安机关维护治安任务相对艰巨的时段，各类案件高发。为此，我市警方从6月底开展攻防3号行动，针对夏季以来比较突出的治安形势，特别是“两抢”案件高发的特殊情况采取重点打击、专项整治。行动期间，市、县两级公安机关将加强对每日“两抢”警情的深入核对、分析，对每周警情进行动态预警通报，并进行打处效果评估。通过便衣打控，蹲守伏击、现场围追等手段力抓现行犯罪，全力遏制夏季“两抢”案件多发势头。</P>\r\n<P>　　行动期间，警方还开展了缉枪治爆专项整治，联合检、法等相关部门向社会发布收缴枪支、爆炸物品的通告，全面发动县镇街道、社区村居等各级社会力量提供线索，对可能私制、私存枪支弹药、爆炸物品的重点区域和可疑人员进行全面排查，对发现的非法枪支和爆炸物品一律收缴，对地域性、系列性、团伙性和流窜性涉枪涉爆犯罪团伙案件，实行联合打击，确保一网打尽。</P>','18',0,0,'2024-02-25 07:15:44'),(20,'中央美院写生基地落户南雁','公告信息','<P>　　置身平阳县南雁会文书院，50余名中央美术学院师生即兴挥毫水墨，游走于宣纸间的长短线条，勾勒出一幅幅南雁的秀山丽水。10月9日，“公望故里行”――中央美院师生平阳写生活动启动暨（陈平山水）写生基地挂牌仪式在南雁会文书院举行。据悉，这是中央美院在温州的首个写生基地。</P>\r\n<P>　　此次写生基地落户群山环抱的南雁会文书院。“这次写生团队将在这里进行10天写生，用画纸把南雁的景色装回去。”中央美术学院中国画学院副院长陈平教授说，《富春山居图》作者、中国元代画家黄公望的重要绘画经历就在南雁一带，这里有许多优秀的写生素材，民俗村落融于自然之景，非常适合教学，是掌握树法、石法、山法、水法等写生技巧中的理想场所。</P>\r\n<P>　　作为“中国（温州）书画大展――‘黄公望画作回故里’暨2011中国画全国名家邀请展”活动的一项重要内容，此次写生的部分作品将与黄公望作品、中国画全国名家作品等一同在温州博物馆展出。 （黄瑚 丁志峰 尤增国）</P>\r\n<META name=ContentEnd><!--ZJEG_RSS.content.end--><!--<$[信息内容]>end-->','47',0,0,'2024-02-25 07:15:44'),(21,'市县领导对雅后村进行扶贫开发整村推进项目验收','公告信息','<DIV>&nbsp;&nbsp;&nbsp; 2011年11月30日，由市农办、市财政局、县农办和县财政局组成的验收小组在林佳讯书记和镇农办的陪同下到雅后村进行扶贫开发整村推进项目验收。验收小组分别就项目财务情况、项目资料完备情况进行了细致检查，并对项目建设进行了实地检查。在鱼苗网箱养殖现场听取相关技术员的介绍，工作人员还当场打捞鱼苗，活蹦乱跳的小鱼成群结队，水波涌动。验收小组对雅后村扶贫项目工作给予了高度评价，并要求继续做好后续工作，真正实现脱贫致富目标。</DIV>\r\n<DIV>&nbsp;&nbsp; &nbsp;雅后村位于苍南县钱库镇北部，村域面积0.3平方公里，与仙居办事处所在地隔河相望。在项目实施过程中，加快了雅后村农业结构调整，农业结构逐步适应市场调节机制，改善了农民群众文化活动条件；群众素质得到提高，科学技术得到进一步普及和推广；促进剩余劳动力向产业化、市场化方向转移。</DIV>&nbsp;&nbsp;&nbsp; 在产生经济效益的同时还保证了生态效益。整村推进项目实施后，不仅进一步夯实了农业基础，实现了土地资源的合理配套，同时经济林果种植增加了植被，有效地防止水土流失，还实现了资源的有效保护，为实现农业可继续发展奠定坚实的基础。','88',0,0,'2024-02-25 07:15:44'),(22,'苍南龙港开出首家五星级酒店','公告信息','&nbsp;&nbsp;&nbsp; 我市五星级酒店将又添新军。7月6日，由在外温州人回乡投资、按照五星级标准建设的酒店――龙港诚大饭店正式开业。坐落于“中国农民城”的这家高星级酒店开业，也意味着我市酒店业在转型发展中由城市中心区向大都市中心镇拓展新空间。 \r\n<P>　　五星级酒店是体现地方旅游经济发展水平的重要标志之一。截至2010年底，全市共有星级饭店106家。其中，五星级酒店有华侨饭店和万和豪生大酒店。香格里拉大酒店、滨海大酒店和天豪君澜大酒店正在申请进程中。目前，除市区的喜来登、阿外楼、天润、君悦、世贸洲际等按五星级标准建设的酒店已相继试营业或加紧施工外，一批高星级酒店纷纷向瓯北、龙港等中心镇发展。</P>\r\n<P>　　与其他城市酒店国有化和外资化有所不同，作为民营经济最活跃的地区之一，温州高星级酒店主要为民营资本唱主角。诚大饭店就是我市民企浙江诚大实业集团有限公司投建的。由于看好新一轮温州旅游“黄金机遇期”的到来，在辽宁大连创业多年的诚大集团有限公司董事长金昌锋决定回乡投资旅游业，并选择在苍南县龙港镇投资3.5亿元兴建该酒店。据悉，这家集工业、贸易及服务业为一体的新兴企业集团为响应市委、市政府提出在外温州人回乡投资、反哺家乡的号召，先后回温投资建设了一家三星级酒店、一家拉链生产企业等，并将企业总部迁回温州。</P>\r\n<P>　　据介绍，诚大饭店坐落在龙港镇龙金大道东侧，占地面积53亩，豪华客房285间，建筑面积5.1万平方米。它的建成，将为龙港乃至整个鳌江流域进一步改善投资环境、树立城市形象、发展旅游服务业，起到积极的推动作用。在昨天的开业庆典上，诚大饭店向苍南县慈善总会捐资500万元，设立诚大爱心慈善基金。（邵闻）</P>\r\n<META name=ContentEnd><!--ZJEG_RSS.content.end--><!--<$[信息内容]>end-->','64',0,0,'2024-02-25 07:15:44'),(23,'黄寿龙在绿化造林工作汇报会上强调：打造精品工程 共建绿美家园','公告信息','&nbsp;&nbsp;&nbsp; 4月7日消息：今天，我县召开绿化造林工作重点乡镇部门汇报会。县委书记黄寿龙在会上强调，各地各部门一定要高度重视绿化造林工作，进一步明确“谁来种”、“种什么”、“种哪里”、“如何种”、“啥时种”、“如何管”，以及明年绿化早谋划等工作任务，重点打造一批绿化精品工程，切实加强养护管理，努力营造浓厚氛围，全面提升绿化效益，全县上下一心，共建绿色优美的生活家园。县领导戴嘉宝、邵潘锋参加会议。\r\n<P>&nbsp;&nbsp;&nbsp; 黄寿龙听取了我县绿化工作情况汇报和各重点乡镇部门的讨论发言后，对我县重点乡镇部门推进绿化造林工作给予充分肯定，对各地各部门坚持规划引领、多元投入和政策驱动，深入开展“绿色苍南、美丽家园”活动表示满意。同时，他对全县绿化造林的总量和进度不平衡、重点绿化工程进展缓慢、企业参与绿化氛围不浓、植后管护未及时跟进等困难和问题表示高度关注。</P><!--advertisement code begin--><!--advertisement code end-->\r\n<P>&nbsp;&nbsp;&nbsp; 黄寿龙要求，各地各部门一定要切实按照“森林屏障体系化、干线通道生态化、城镇绿化森林化、村庄绿化特色化、农田林网网格化、特色产业高效化、森林文化多元化、资源保护法制化”的“八个化”建设目标，力求构建以沿海基干林带为主线、农田防护林为网络、绿化通道工程为骨架、城镇村庄绿化为依托，点、线、面相结合的平原绿化格局，充分体现苍南滨海平原区域的特色。</P>\r\n<P>&nbsp;&nbsp;&nbsp; 黄寿龙指出，绿化工作是改善生态、改善生活、利国利民、意义重大而深远的大事，各乡镇各部门一定要分清责任，理顺关系，落实任务，形成科学合理的工作机制。要用审美的观点精心选择合适的树种，坚持“一镇一品，一路一花”，尽力体现绿化美化效果，营造多姿多彩、赏心悦目的人居环境。要突出重点地块和路段，特别是注重公共场所、道路两旁和沿江沿河的绿化植绿工作。要解决好种植密度、种植时间以及种植管护等问题，确保成活率。要坚持高起点和大手笔规划，邀请绿化专家把脉支招，为明年绿化工作早谋划早部署，为“绿色苍南”建设提供组织和智力支撑。</P>\r\n<P>&nbsp;&nbsp;&nbsp; 黄寿龙强调，各重点乡镇部门要切实加大力度，积极营造全社会爱绿、植绿、护绿、兴绿的良好氛围，加快推进交通干线森林通道等一批绿化精品示范工程建设，并坚持种管并重，在强化森林防火工作的同时，大力加强树种养护管理，努力提高种植成活率，努力为广大居民群众提供更多更好的生态型人居环境。（记者 方耀星 实习生 陈薇拉）</P>','83',0,0,'2024-02-25 07:15:44'),(24,'全市共产党员突破41万名','公告信息','　&nbsp; 记者昨天（6月29日）从市委组织部获悉，截至2010年底，全市共有共产党员413548名，比上年净增1.7万余名。这就意味着，约20位温州人中就有一位共产党员。 \r\n<P>　　根据统计，全市现有党的基层组织21362个，比上年净增528个。其中，基层党委730个，党总支部827个，党支部19805个。</P>\r\n<P>　　在41万余名党员中，女性党员有10.0634万名，约占党员总数的24.33%。从学历构成看，具有大专及以上学历的党员为13.2392万名，约占总数的32.01%，比上年提高1.83个百分点；初中及以下学历的有17.8432万名，约占总数的43.15%，比上年下降1.48个百分点。</P>\r\n<P>　　除了学历构成上的变化，党员的年龄构成也有所变化。其中，年龄为35岁及以下的党员有12.4739万名，约占党员总数的30.16%，比上年提高0.33个百分点；36岁至59岁的党员19.3792万名，约占总数的46.86%；60岁及以上的党员9.5017万名，约占总数的22.98%。</P>\r\n<P>　　从党员职业构成看，工人4.4686万名，农牧渔民18.1193万名，党政机关公务员3.4855万名，企事业单位管理人员和专业技术人员6.3184万名，学生0.7504万名，离退休人员4.8026万名，其他职业1.7837万名。其中，非公有制单位在岗职工中有党员3.8912万名，其中工人2.2658万名，管理人员和专业技术人员1.6254万名。另外，包括非公企业主等人士在内的新的社会阶层党员有8369名,占全市党员总数的2.02%，</P>\r\n<P>　　本报讯 （记者 潘秀慧） 记者昨天从市委组织部获悉，为进一步增强党员的归属感、光荣感、使命感，强化党员的宗旨意识、先锋意识和奉献意识，提升党的凝聚力、向心力、感召力，由省委组织部统一制作的“中国共产党成立90周年纪念章”现已在我市开始颁发，确保全市41万余名共产党员在“七一”节前每人领到一枚纪念章。</P>\r\n<P>　　该纪念章正面图案为红色党旗加“为人民服务”字样，其中，飘扬的党旗象征中国共产党的先进性和引领中华民族万众一心、奋勇前进的精神，金黄色的圆象征全国各族人民紧密团结在党的周围，放射型光芒象征建党90周年来取得的伟大成就，“为人民服务”则体现出对每位共产党员时刻践行全心全意为人民服务的要求。纪念章背面刻有“中国共产党成立90周年纪念”和“中共浙江省委组织部颁发”字样。据悉，为方便党员长期佩戴，纪念章采用镀仿金材料制作，所需经费由省、市、县（市、区）委管党费等承担，按党组织隶属关系免费发放给每位党员。</P>\r\n<P>　　根据要求，纪念章要统一佩戴于左胸前。除今年“七一”期间开展的纪念建党90周年各类活动中党员要佩戴外，今后在每年“七一”等党内重大纪念活动举行时，及基层党组织开展志愿服务、结对帮扶、党内关爱等活动时，党员都要佩戴。另外，窗口单位和服务行业的党员，工作时间都要佩戴；国有和非公有制企业党员，工作时间都要佩戴（特殊工种除外）。如有其它场合需要佩戴的，须由基层党委审定。</P>\r\n<META name=ContentEnd><!--ZJEG_RSS.content.end--><!--<$[信息内容]>end-->','28',0,0,'2024-02-25 07:15:44');
/*!40000 ALTER TABLE `xinwentongzhi` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-03-14 12:04:16
