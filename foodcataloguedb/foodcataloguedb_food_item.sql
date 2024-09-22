-- MySQL dump 10.13  Distrib 8.0.34, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: foodcataloguedb
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
-- Table structure for table `food_item`
--

DROP TABLE IF EXISTS `food_item`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `food_item` (
  `id` int NOT NULL,
  `is_veg` bit(1) NOT NULL,
  `item_description` varchar(255) DEFAULT NULL,
  `item_name` varchar(255) DEFAULT NULL,
  `price` double DEFAULT NULL,
  `quantity` int NOT NULL DEFAULT '0',
  `restaurant_id` int DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `food_item`
--

LOCK TABLES `food_item` WRITE;
/*!40000 ALTER TABLE `food_item` DISABLE KEYS */;
INSERT INTO `food_item` VALUES (52,_binary '\0','Spicy chicken curry flavoured with variety of desi spices & herbs.','Chicken Curry',135,0,1),(103,_binary '\0','A Cheese Omelette is a fluffy, savory egg dish with melted cheese, perfect for breakfast...','Cheese Omelette',150,0,2),(104,_binary '\0','A classic milk tea: rich, creamy, and soothing blend of brewed tea and milk.','The Milk Tea',100,0,52),(105,_binary '\0','Rich, creamy cocoa smoothie with banana, almond milk, and a hint of vanilla. Deliciously satisfying!','Cocoa Smoothie',130,0,202),(106,_binary '\0','Flavorful biryani with tender chicken, fragrant rice, and a blend of spices. Hearty and spicy.','Chicken Kachhi Biryani',250,0,204),(107,_binary '\0','Quick stir-fried vegetables with a savory sauce. Crunchy and packed with nutrients.','Vegetable Stir-Fry',150,0,1),(108,_binary '\0','Classic pizza with tomato sauce, fresh mozzarella, and basil leaves.','Margherita Pizza',350,0,206),(109,_binary '\0','Light and crispy waffle served with whipped cream and fresh berries.','Belgian Waffle',180,0,203),(110,_binary '\0','A box of assorted grilled meats with savory marinades and sides.','Grilled Meatbox',400,0,205),(152,_binary '\0','A box of assorted grilled meats with savory marinades and sides.','Grilled Meatbox',400,0,108);
/*!40000 ALTER TABLE `food_item` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-09-22 19:03:33
