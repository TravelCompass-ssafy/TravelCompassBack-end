-- MySQL dump 10.13  Distrib 8.0.34, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: travel_compass_db
-- ------------------------------------------------------
-- Server version	8.0.35

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `trip_detail_comment`
--

DROP TABLE IF EXISTS `trip_detail_comment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `trip_detail_comment` (
  `trip_detail_comment_id` int NOT NULL,
  `trip_detail_id` int NOT NULL,
  `parent_id` int NOT NULL,
  `user_id` int NOT NULL,
  `content` varchar(1000) NOT NULL,
  `created_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`trip_detail_comment_id`),
  KEY `trip_trip_detail_comment_trip_detail_id_idx` (`trip_detail_id`),
  KEY `user_trip_detail_comment_user_id_fk_idx` (`user_id`),
  KEY `trip_detail_comment_parent_id_idx` (`parent_id`),
  CONSTRAINT `trip_detail_comment_parent_id` FOREIGN KEY (`parent_id`) REFERENCES `trip_detail_comment` (`trip_detail_comment_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `trip_trip_detail_comment_trip_detail_id` FOREIGN KEY (`trip_detail_id`) REFERENCES `trip_detail` (`trip_detail_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `user_trip_detail_comment_user_id_fk` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `trip_detail_comment`
--

LOCK TABLES `trip_detail_comment` WRITE;
/*!40000 ALTER TABLE `trip_detail_comment` DISABLE KEYS */;
/*!40000 ALTER TABLE `trip_detail_comment` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-05-17  8:24:52
