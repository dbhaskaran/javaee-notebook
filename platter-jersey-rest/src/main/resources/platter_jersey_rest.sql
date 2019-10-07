DROP DATABASE IF EXISTS `platter`;

CREATE DATABASE `platter`;

USE `platter`;


CREATE TABLE `dish` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  `category` varchar(45) DEFAULT NULL,
  `country` varchar(45) DEFAULT NULL,
  `region` varchar(45) DEFAULT NULL,
  `description` blob,
  `picture` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;


INSERT INTO dish VALUES (1,'Dosa','Breakfast','India','Bangalore','Dosa is a type of pancake originating from the Indian subcontinent, made from a fermented batter. It is somewhat similar to a crepe in appearance.','dosa.jpg');

INSERT INTO dish VALUES (2,'Pelmeni','Breakfast','Russia','Moscow','Pelmeni are dumplings of Russian cuisine which consist of a filling wrapped in thin, unleavened dough.','pelmeni.jpg');

INSERT INTO dish VALUES (3,'Mezze','Breakfast','Turkey','Middle East','Meze or mezze is a selection of small dishes served as appetizers in the Near East, the Balkans, and parts of Central and South Asia.','mezze.jpg');

INSERT INTO dish VALUES (4,'Biryani','Entree','Pakistan','Karachi','Biryani, also known as biriyani, biriani, birani or briyani, is a mixed rice dish with its origins among the Muslims of the Indian subcontinent.','biryani.jpg');

INSERT INTO dish VALUES (5,'Burrito','Entree','Mexico','Mexico City','A burrito is a dish in Mexican and Tex-Mex cuisine that consists of a flour tortilla with various other ingredients.','burrito.jpg');

INSERT INTO dish VALUES (6,'Nasi Lemak','Entree','Malaysia','Kuala lumpur','Nasi lemak is a Malay fragrant rice dish cooked in coconut milk and pandan leaf.','nasi.jpg');

INSERT INTO dish VALUES (7,'Pho','Breakfast','Vietnam','Saigon','Phở or pho is a Vietnamese soup consisting of broth, rice noodles called bánh phở, a few herbs, and meat, primarily made with either beef or chicken.','pho.jpg');

INSERT INTO dish VALUES (8,'Pad Thai','Entree','Thailand','Bankok','Pad thai, or phad thai, is a stir-fried rice noodle dish commonly served as a street food and at most restaurants in Thailand.','padthai.jpg');

INSERT INTO dish VALUES (9,'Kunafe','Dessert','Turkey','Istanbul','Kanafeh is a traditional Arab dessert made with thin noodle-like pastry, or alternatively fine semolina dough, soaked in sweet, sugar-based syrup','kunafe.jpg');

INSERT INTO dish VALUES (10,'Crepes','Breakfast','France','Paris','A crêpe or crepe is a type of very thin pancake. Crêpes are usually of two types: sweet crêpes and savoury galettes.','crepes.jpg');