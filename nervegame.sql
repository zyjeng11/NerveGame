-- MySQL dump 10.13  Distrib 5.7.14, for Win64 (x86_64)
--
-- Host: localhost    Database: nerve_game
-- ------------------------------------------------------
-- Server version	5.7.14-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `question`
--

DROP TABLE IF EXISTS `question`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `question` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `question` varchar(50) DEFAULT '',
  `answer1` varchar(1) DEFAULT '',
  `answer2` varchar(1) DEFAULT '',
  `answer3` varchar(1) DEFAULT '',
  `answer4` varchar(1) DEFAULT '',
  `answer5` varchar(1) DEFAULT '',
  `answer6` varchar(1) DEFAULT '',
  `answer7` varchar(1) DEFAULT '',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `question`
--

LOCK TABLES `question` WRITE;
/*!40000 ALTER TABLE `question` DISABLE KEYS */;
INSERT INTO `question` VALUES (1,'手碰到熱鍋子，立刻縮回來','A','E','F','H','I','',''),(2,'聞到香雞排的氣味流口水','B','E','K','H','J','',''),(3,'腳被蚊子叮到，覺得很癢，用手把蚊子打死','A','E','F','G','F','H','I'),(4,'看到尺往下掉，立刻用手把尺接住','C','E','G','F','H','I',''),(5,'聽到有人叫我的名字，轉過頭去看看是誰','D','E','G','H','I','',''),(6,'手被刀割到，大喊好痛','A','E','F','G','H','I',''),(7,'敲膝蓋，小腿彈起來','A','E','F','H','I','',''),(8,'看到一個人衝過來，立刻用手壓住腳踏車的煞車手把緊急煞車','C','E','G','F','H','I',''),(9,'吸到胡椒粉，一直打噴嚏','B','E','K','H','I','',''),(10,'看著跳舞機的指令，腳跟著舞步動作','C','E','G','F','H','I',''),(11,'被同學踩到腳，覺得好痛，用手推開他','A','E','F','G','F','H','I'),(12,'看到老師，對老師說早安','C','E','G','H','I','','');
/*!40000 ALTER TABLE `question` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-12-21 11:26:31
