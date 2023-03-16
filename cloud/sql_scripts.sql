CREATE DATABASE `companies`;

CREATE DATABASE `stocks`;

CREATE TABLE `companies`.`company` (
  `id` bigint NOT NULL,
  `companyceo` varchar(255) DEFAULT NULL,
  `company_code` varchar(255) DEFAULT NULL,
  `company_name` varchar(255) DEFAULT NULL,
  `company_website` varchar(255) DEFAULT NULL,
  `turn_over` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
);

CREATE TABLE `stocks`.`stock` (
  `id` bigint NOT NULL,
  `company_code` varchar(255) DEFAULT NULL,
  `end_time` datetime(6) DEFAULT NULL,
  `price` double DEFAULT NULL,
  `start_time` datetime(6) DEFAULT NULL,
  PRIMARY KEY (`id`)
);

CREATE VIEW `companies`.`viewcompany` 
AS 
select  `companies`.`company`.`id` AS `id`,
        `companies`.`company`.`companyceo` AS `companyceo`,
	`companies`.`company`.`company_code` AS `company_code`,
	`companies`.`company`.`company_name` AS `company_name`,
	`companies`.`company`.`company_website` AS `company_website`,
	`companies`.`company`.`turn_over` AS `turn_over` 
	from `companies`.`company`;
    
    
CREATE VIEW `stocks`.`viewstock`
AS
select  `stocks`.`stock`.`id` AS `id`,
	`stocks`.`stock`.`company_code` AS `company_code`,
	`stocks`.`stock`.`end_time` AS `end_time`,
	`stocks`.`stock`.`price` AS `price`,
	`stocks`.`stock`.`start_time` AS `start_time`
	 from `stocks`.`stock`;    

INSERT INTO `companies`.`company` (`id`,`companyceo`,`company_code`,`company_name`,`company_website`,`turn_over`) VALUES (1,'RATAN','TCS','TCS','www.TCS.com','2000000000');
INSERT INTO `companies`.`company` (`id`,`companyceo`,`company_code`,`company_name`,`company_website`,`turn_over`) VALUES (3,'Brian','INFO20','Infosys','www.cognizant.com','2000000000');
INSERT INTO `companies`.`company` (`id`,`companyceo`,`company_code`,`company_name`,`company_website`,`turn_over`) VALUES (6,'Brian','COG','Cognizant','www.cognizant.com','2000000000');
INSERT INTO `companies`.`company` (`id`,`companyceo`,`company_code`,`company_name`,`company_website`,`turn_over`) VALUES (7,'Anil','ANI','Mahi Solution PVT Limited','www.mahi.com','100000000');
INSERT INTO `companies`.`company` (`id`,`companyceo`,`company_code`,`company_name`,`company_website`,`turn_over`) VALUES (8,'Jeff Basos','AMZ','Amazon','www.amazon.com','2000000000');
INSERT INTO `companies`.`company` (`id`,`companyceo`,`company_code`,`company_name`,`company_website`,`turn_over`) VALUES (9,'Mark','META','facebook','www.facebook.com','3000000000');
INSERT INTO `companies`.`company` (`id`,`companyceo`,`company_code`,`company_name`,`company_website`,`turn_over`) VALUES (10,'Jan Koum','WHAT','whatsp','www.whatsp.com','300000000000');
INSERT INTO `companies`.`company` (`id`,`companyceo`,`company_code`,`company_name`,`company_website`,`turn_over`) VALUES (11,'Julie Sweet','ACC','accenture','www.accenture.com','4000000000');
INSERT INTO `companies`.`company` (`id`,`companyceo`,`company_code`,`company_name`,`company_website`,`turn_over`) VALUES (13,'Jeff Basos','APP','apple','www.apple.com','7000000000');
INSERT INTO `companies`.`company` (`id`,`companyceo`,`company_code`,`company_name`,`company_website`,`turn_over`) VALUES (14,'Sundar','GOO','google','www.google.com','1000000000000');
INSERT INTO `companies`.`company` (`id`,`companyceo`,`company_code`,`company_name`,`company_website`,`turn_over`) VALUES (15,'Xyz Person','NAG','naggaro','www.naggaro,cin','200000000');
INSERT INTO `companies`.`company` (`id`,`companyceo`,`company_code`,`company_name`,`company_website`,`turn_over`) VALUES (16,'andrew syndes','SYN','synorique','www.synorique.com','3000000000');
INSERT INTO `companies`.`company` (`id`,`companyceo`,`company_code`,`company_name`,`company_website`,`turn_over`) VALUES (17,'somesh singh','SOM','somthing','www.something.com','500000000');
INSERT INTO `companies`.`company` (`id`,`companyceo`,`company_code`,`company_name`,`company_website`,`turn_over`) VALUES (19,'deepesh','INTECH','infotech','www.infotech.com','5000000000');




INSERT INTO `stocks`.`stock` (`id`,`company_code`,`end_time`,`price`,`start_time`) VALUES (1,'TCS','2022-08-01 23:06:46.171281',1500,'2022-08-01 21:52:41.858896');
INSERT INTO `stocks`.`stock` (`id`,`company_code`,`end_time`,`price`,`start_time`) VALUES (3,'INFO20','2022-08-01 22:28:43.210284',1200,'2022-08-01 22:01:33.533172');
INSERT INTO `stocks`.`stock` (`id`,`company_code`,`end_time`,`price`,`start_time`) VALUES (4,'INFO20','2022-08-01 22:29:21.624100',1300,'2022-08-01 22:28:43.210284');
INSERT INTO `stocks`.`stock` (`id`,`company_code`,`end_time`,`price`,`start_time`) VALUES (5,'INFO20','2022-08-01 22:32:39.273924',1500,'2022-08-01 22:29:21.624100');
INSERT INTO `stocks`.`stock` (`id`,`company_code`,`end_time`,`price`,`start_time`) VALUES (6,'INFO20','2022-08-01 22:39:20.715561',2000,'2022-08-01 22:32:39.273924');
INSERT INTO `stocks`.`stock` (`id`,`company_code`,`end_time`,`price`,`start_time`) VALUES (7,'INFO20','2022-08-01 23:06:05.724638',2000,'2022-08-01 22:39:20.715561');
INSERT INTO `stocks`.`stock` (`id`,`company_code`,`end_time`,`price`,`start_time`) VALUES (8,'INFO20','2022-08-10 19:52:48.049846',150,'2022-08-01 23:06:05.724638');
INSERT INTO `stocks`.`stock` (`id`,`company_code`,`end_time`,`price`,`start_time`) VALUES (9,'TCS','2022-08-23 08:23:28.841287',150,'2022-08-01 23:06:46.171281');
INSERT INTO `stocks`.`stock` (`id`,`company_code`,`end_time`,`price`,`start_time`) VALUES (14,'COG','2022-08-05 17:00:22.728033',5000,'2022-08-05 16:56:16.141393');
INSERT INTO `stocks`.`stock` (`id`,`company_code`,`end_time`,`price`,`start_time`) VALUES (15,'COG','2022-08-24 09:44:02.310281',1200,'2022-08-05 17:00:22.728033');
INSERT INTO `stocks`.`stock` (`id`,`company_code`,`end_time`,`price`,`start_time`) VALUES (16,'ANI','2022-08-07 10:48:10.986022',20,'2022-08-07 10:41:20.525986');
INSERT INTO `stocks`.`stock` (`id`,`company_code`,`end_time`,`price`,`start_time`) VALUES (18,'ANI',NULL,100,'2022-08-07 10:48:10.986022');
INSERT INTO `stocks`.`stock` (`id`,`company_code`,`end_time`,`price`,`start_time`) VALUES (19,'INFO20','2022-08-22 22:06:29.947142',100,'2022-08-10 19:52:48.049846');
INSERT INTO `stocks`.`stock` (`id`,`company_code`,`end_time`,`price`,`start_time`) VALUES (20,'AMZ','2022-08-23 08:26:11.225676',700,'2022-08-21 23:25:54.458499');
INSERT INTO `stocks`.`stock` (`id`,`company_code`,`end_time`,`price`,`start_time`) VALUES (21,'META','2022-08-23 09:34:37.526515',350,'2022-08-21 23:29:29.990065');
INSERT INTO `stocks`.`stock` (`id`,`company_code`,`end_time`,`price`,`start_time`) VALUES (22,'INFO20','2022-08-23 01:28:02.690258',300,'2022-08-22 22:06:29.947142');
INSERT INTO `stocks`.`stock` (`id`,`company_code`,`end_time`,`price`,`start_time`) VALUES (23,'INFO20','2022-08-23 08:04:49.173623',450,'2022-08-23 01:28:02.690258');
INSERT INTO `stocks`.`stock` (`id`,`company_code`,`end_time`,`price`,`start_time`) VALUES (24,'INFO20','2022-08-24 09:48:11.504021',300,'2022-08-23 08:04:49.173623');
INSERT INTO `stocks`.`stock` (`id`,`company_code`,`end_time`,`price`,`start_time`) VALUES (25,'WHAT','2022-08-23 09:35:37.862015',900,'2022-08-23 08:20:45.368530');
INSERT INTO `stocks`.`stock` (`id`,`company_code`,`end_time`,`price`,`start_time`) VALUES (26,'ACC','2022-08-23 08:23:12.338686',300,'2022-08-23 08:22:58.104634');
INSERT INTO `stocks`.`stock` (`id`,`company_code`,`end_time`,`price`,`start_time`) VALUES (27,'ACC','2022-08-24 10:13:17.565039',200,'2022-08-23 08:23:12.338686');
INSERT INTO `stocks`.`stock` (`id`,`company_code`,`end_time`,`price`,`start_time`) VALUES (28,'TCS','2022-08-24 09:47:31.146828',300,'2022-08-23 08:23:28.841287');
INSERT INTO `stocks`.`stock` (`id`,`company_code`,`end_time`,`price`,`start_time`) VALUES (29,'AMZ','2022-08-23 09:38:25.533896',300,'2022-08-23 08:26:11.225676');
INSERT INTO `stocks`.`stock` (`id`,`company_code`,`end_time`,`price`,`start_time`) VALUES (31,'APP','2022-08-25 13:26:23.967474',100,'2022-08-23 09:01:23.735490');
INSERT INTO `stocks`.`stock` (`id`,`company_code`,`end_time`,`price`,`start_time`) VALUES (32,'GOO','2022-08-26 13:03:54.486611',700,'2022-08-23 09:02:33.018373');
INSERT INTO `stocks`.`stock` (`id`,`company_code`,`end_time`,`price`,`start_time`) VALUES (33,'NAG',NULL,600,'2022-08-23 09:04:21.600679');
INSERT INTO `stocks`.`stock` (`id`,`company_code`,`end_time`,`price`,`start_time`) VALUES (34,'SYN',NULL,200,'2022-08-23 09:11:55.660092');
INSERT INTO `stocks`.`stock` (`id`,`company_code`,`end_time`,`price`,`start_time`) VALUES (35,'SOM',NULL,400,'2022-08-23 09:13:21.078294');
INSERT INTO `stocks`.`stock` (`id`,`company_code`,`end_time`,`price`,`start_time`) VALUES (37,'INTECH',NULL,500,'2022-08-23 09:27:37.124057');
INSERT INTO `stocks`.`stock` (`id`,`company_code`,`end_time`,`price`,`start_time`) VALUES (40,'META','2022-08-24 09:49:00.840959',500,'2022-08-23 09:34:37.526515');
INSERT INTO `stocks`.`stock` (`id`,`company_code`,`end_time`,`price`,`start_time`) VALUES (41,'WHAT','2022-08-24 09:42:55.700808',100,'2022-08-23 09:35:37.862015');
INSERT INTO `stocks`.`stock` (`id`,`company_code`,`end_time`,`price`,`start_time`) VALUES (42,'AMZ','2022-08-24 10:02:30.697406',600,'2022-08-23 09:38:25.533896');
INSERT INTO `stocks`.`stock` (`id`,`company_code`,`end_time`,`price`,`start_time`) VALUES (43,'WHAT','2022-08-24 09:43:16.229709',300,'2022-08-24 09:42:55.700808');
INSERT INTO `stocks`.`stock` (`id`,`company_code`,`end_time`,`price`,`start_time`) VALUES (44,'WHAT','2022-08-24 10:05:58.244603',500,'2022-08-24 09:43:16.229709');
INSERT INTO `stocks`.`stock` (`id`,`company_code`,`end_time`,`price`,`start_time`) VALUES (45,'COG','2022-08-24 10:03:22.286049',1300,'2022-08-24 09:44:02.310281');
INSERT INTO `stocks`.`stock` (`id`,`company_code`,`end_time`,`price`,`start_time`) VALUES (46,'TCS','2022-08-24 09:53:57.286011',300,'2022-08-24 09:47:31.146828');
INSERT INTO `stocks`.`stock` (`id`,`company_code`,`end_time`,`price`,`start_time`) VALUES (47,'INFO20',NULL,400,'2022-08-24 09:48:11.504021');
INSERT INTO `stocks`.`stock` (`id`,`company_code`,`end_time`,`price`,`start_time`) VALUES (48,'META','2022-08-24 10:00:00.212534',600,'2022-08-24 09:49:00.840959');
INSERT INTO `stocks`.`stock` (`id`,`company_code`,`end_time`,`price`,`start_time`) VALUES (49,'TCS','2022-08-24 10:01:33.334947',400,'2022-08-24 09:53:57.286011');
INSERT INTO `stocks`.`stock` (`id`,`company_code`,`end_time`,`price`,`start_time`) VALUES (50,'META','2022-08-25 00:11:52.337131',500,'2022-08-24 10:00:00.212534');
INSERT INTO `stocks`.`stock` (`id`,`company_code`,`end_time`,`price`,`start_time`) VALUES (51,'TCS','2022-08-24 10:06:28.972795',500,'2022-08-24 10:01:33.334947');
INSERT INTO `stocks`.`stock` (`id`,`company_code`,`end_time`,`price`,`start_time`) VALUES (52,'AMZ','2022-08-24 10:13:45.611185',700,'2022-08-24 10:02:30.697406');
INSERT INTO `stocks`.`stock` (`id`,`company_code`,`end_time`,`price`,`start_time`) VALUES (53,'COG','2022-08-24 19:04:07.969607',1200,'2022-08-24 10:03:22.286049');
INSERT INTO `stocks`.`stock` (`id`,`company_code`,`end_time`,`price`,`start_time`) VALUES (54,'WHAT','2022-08-24 10:12:58.758040',600,'2022-08-24 10:05:58.244603');
INSERT INTO `stocks`.`stock` (`id`,`company_code`,`end_time`,`price`,`start_time`) VALUES (55,'TCS',NULL,400,'2022-08-24 10:06:28.972795');
INSERT INTO `stocks`.`stock` (`id`,`company_code`,`end_time`,`price`,`start_time`) VALUES (56,'WHAT','2022-08-24 20:58:41.284063',300,'2022-08-24 10:12:58.758040');
INSERT INTO `stocks`.`stock` (`id`,`company_code`,`end_time`,`price`,`start_time`) VALUES (57,'ACC','2022-08-24 18:53:17.252272',300,'2022-08-24 10:13:17.565039');
INSERT INTO `stocks`.`stock` (`id`,`company_code`,`end_time`,`price`,`start_time`) VALUES (58,'AMZ','2022-08-24 20:51:31.073485',800,'2022-08-24 10:13:45.611185');
INSERT INTO `stocks`.`stock` (`id`,`company_code`,`end_time`,`price`,`start_time`) VALUES (59,'ACC','2022-08-25 00:17:27.746570',200,'2022-08-24 18:53:17.252272');
INSERT INTO `stocks`.`stock` (`id`,`company_code`,`end_time`,`price`,`start_time`) VALUES (60,'COG','2022-08-26 12:15:47.249496',110,'2022-08-24 19:04:07.969607');
INSERT INTO `stocks`.`stock` (`id`,`company_code`,`end_time`,`price`,`start_time`) VALUES (63,'AMZ',NULL,900,'2022-08-24 20:51:31.073485');
INSERT INTO `stocks`.`stock` (`id`,`company_code`,`end_time`,`price`,`start_time`) VALUES (64,'WHAT','2022-08-25 18:17:27.118643',500,'2022-08-24 20:58:41.284063');
INSERT INTO `stocks`.`stock` (`id`,`company_code`,`end_time`,`price`,`start_time`) VALUES (65,'METa','2022-08-25 00:12:13.447967',600,'2022-08-25 00:11:52.337131');
INSERT INTO `stocks`.`stock` (`id`,`company_code`,`end_time`,`price`,`start_time`) VALUES (66,'META','2022-08-25 00:12:45.713638',600,'2022-08-25 00:12:13.447967');
INSERT INTO `stocks`.`stock` (`id`,`company_code`,`end_time`,`price`,`start_time`) VALUES (67,'Meta','2022-08-25 00:13:21.119902',500,'2022-08-25 00:12:45.713638');
INSERT INTO `stocks`.`stock` (`id`,`company_code`,`end_time`,`price`,`start_time`) VALUES (68,'META',NULL,500,'2022-08-25 00:13:21.119902');
INSERT INTO `stocks`.`stock` (`id`,`company_code`,`end_time`,`price`,`start_time`) VALUES (69,'acc','2022-08-25 00:21:13.205257',300,'2022-08-25 00:17:27.746570');
INSERT INTO `stocks`.`stock` (`id`,`company_code`,`end_time`,`price`,`start_time`) VALUES (70,'ACC','2022-08-25 00:56:29.282140',500,'2022-08-25 00:21:13.205257');
INSERT INTO `stocks`.`stock` (`id`,`company_code`,`end_time`,`price`,`start_time`) VALUES (71,'ACC','2022-08-25 00:56:41.148720',900,'2022-08-25 00:56:29.282140');
INSERT INTO `stocks`.`stock` (`id`,`company_code`,`end_time`,`price`,`start_time`) VALUES (72,'ACC','2022-08-26 11:09:07.447518',1000,'2022-08-25 00:56:41.148720');
INSERT INTO `stocks`.`stock` (`id`,`company_code`,`end_time`,`price`,`start_time`) VALUES (73,'APP',NULL,200,'2022-08-25 13:26:23.967474');
INSERT INTO `stocks`.`stock` (`id`,`company_code`,`end_time`,`price`,`start_time`) VALUES (74,'WHAT',NULL,300,'2022-08-25 18:17:27.118643');
INSERT INTO `stocks`.`stock` (`id`,`company_code`,`end_time`,`price`,`start_time`) VALUES (75,'ACC','2022-08-26 11:12:56.615695',300,'2022-08-26 11:09:07.447518');
INSERT INTO `stocks`.`stock` (`id`,`company_code`,`end_time`,`price`,`start_time`) VALUES (76,'ACC',NULL,200,'2022-08-26 11:12:56.615695');
INSERT INTO `stocks`.`stock` (`id`,`company_code`,`end_time`,`price`,`start_time`) VALUES (77,'COG',NULL,200,'2022-08-26 12:15:47.249496');
INSERT INTO `stocks`.`stock` (`id`,`company_code`,`end_time`,`price`,`start_time`) VALUES (80,'GOO',NULL,800,'2022-08-26 13:03:54.486611');



