--
-- Table structure for table `food`
--

DROP TABLE IF EXISTS `food`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `food` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  `category` varchar(45) DEFAULT NULL,
  `country` varchar(45) DEFAULT NULL,
  `rating`  decimal(2,1) DEFAULT NULL,
  `description` blob,
  `picture` varchar(256) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=41 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `food`
--


/*!40000 ALTER TABLE `wine` DISABLE KEYS */;
INSERT INTO `food` VALUES 
(1,'Mochi','Dessert','Japan',3.6,'Mochi, the tiny cakes made out of glutinous rice, are an important part of Japanese cuisine and culture. The preparation of mochi starts with a time-consuming process of pounding boiled or steamed rice, usually the glutinous mochigome variety until it forms into a thick and homogenous paste.','mochi.jpg'),
(2,'Cupcake','Dessert','USA',3.2,'A cupcake is a tiny cake that is baked in a thin paper mold or an aluminum cup. One cupcake should typically serve one person.','cupcake.jpg'),
(3,'Tiramisù','Dessert','Italy',4.4,'Even though tiramisù is actually a fairly recent invention, this dessert of coffee-soaked ladyfingers layered with mascarpone cream enjoys an iconic status among Italian desserts. ','tiramisu.jpg'),
(4,'Brownies','Dessert','USA',4.2,'Deliciously chewy, dense and fudgy with a rich chocolate flavor, the beloved brownies are one of the most popular American desserts.','brownies.jpg'),
(5,'Donuts','Dessert','USA',3.8,'Although archaeologists had found some petrified remains of fried cakes with holes in the center, it is still unclear how could the early Native Americans prepare these delicious fried dough desserts that we know today as doughnuts.','donut.jpg'),
(6,'Mousse','Dessert','France',4.2,'This light, fluffy, creamy sweet or savory treat hails from 18th-century France. The word mousse itself means foam in French, and its foamy texture comes from the air bubbles held in suspension throughout it.','mousse.jpg'),
(7,'Macarons','Dessert','France',3.9,'These small, round, sweet meringue-based cookie sandwiches with filling in the middle are light and crunchy on the outside and chewy in the middle.','macarons.jpg'),
(8,'Sundae','Dessert','USA',3.7,'Along with Banana Split, sundae is one of the most served ice cream-based desserts in the United States of America.','sundae.jpg'),
(9,'Milkshake','Dessert','USA',3.9,'Today, milkshakes are understood as flavored milk and ice cream beverages, usually lavishly decorated and served cold.','milkshake.jpg'),
(10,'Fudge','Dessert','USA',3.1,'Fudge is the creamy American confectionery made with milk, sugar, butter, and various toppings and flavorings. ','fudge.jpg');
