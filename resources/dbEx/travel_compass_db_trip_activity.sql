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
-- Table structure for table `trip_activity`
--

DROP TABLE IF EXISTS `trip_activity`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `trip_activity` (
  `trip_activity_id` int NOT NULL AUTO_INCREMENT,
  `trip_plan_id` int NOT NULL,
  `content_id` int NOT NULL,
  `activity_order` int NOT NULL,
  PRIMARY KEY (`trip_activity_id`),
  UNIQUE KEY `trip_activity_id_UNIQUE` (`trip_activity_id`),
  KEY `trip_plan_trip_plan_id_trip_activity_trip_plan_id_fk_idx` (`trip_plan_id`),
  KEY `attraction_info_content_id_trip_activity_content_id_fk_idx` (`content_id`),
  CONSTRAINT `attraction_info_content_id_trip_activity_content_id_fk` FOREIGN KEY (`content_id`) REFERENCES `attraction_info` (`content_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `trip_plan_trip_plan_id_trip_activity_trip_plan_id_fk` FOREIGN KEY (`trip_plan_id`) REFERENCES `trip_plan` (`trip_plan_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `trip_activity`
--

LOCK TABLES `trip_activity` WRITE;
/*!40000 ALTER TABLE `trip_activity` DISABLE KEYS */;
/*!40000 ALTER TABLE `trip_activity` ENABLE KEYS */;
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
