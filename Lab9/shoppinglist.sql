/*
SQLyog Community v12.4.0 (64 bit)
MySQL - 5.7.17-log : Database - shoppinglist
*********************************************************************
*/


/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`shoppinglist` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `shoppinglist`;

/*Table structure for table `listitems` */

DROP TABLE IF EXISTS `listitems`;

CREATE TABLE `listitems` (
  `listitemid` bigint(20) NOT NULL AUTO_INCREMENT,
  `listitemdesc` varchar(30) NOT NULL,
  `listitemincart` tinyint(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`listitemid`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

/*Data for the table `listitems` */

insert  into `listitems`(`listitemid`,`listitemdesc`,`listitemincart`) values 

(6,'bananas',0),

(10,'asdasdad',0);

/* Procedure structure for procedure `addListItem` */

/*!50003 DROP PROCEDURE IF EXISTS  `addListItem` */;

DELIMITER $$

/*!50003 CREATE DEFINER=`root`@`localhost` PROCEDURE `addListItem`(newItem varchar(30))
BEGIN

		insert into listitems set listitemdesc=newItem;

	END */$$
DELIMITER ;

/* Procedure structure for procedure `deleteListItem` */

/*!50003 DROP PROCEDURE IF EXISTS  `deleteListItem` */;

DELIMITER $$

/*!50003 CREATE DEFINER=`root`@`localhost` PROCEDURE `deleteListItem`(listItemIdentifier bigint)
BEGIN

		delete from listitems where listitemid=listItemIdentifier;

	END */$$
DELIMITER ;

/* Procedure structure for procedure `toggleInCart` */

/*!50003 DROP PROCEDURE IF EXISTS  `toggleInCart` */;

DELIMITER $$

/*!50003 CREATE DEFINER=`root`@`localhost` PROCEDURE `toggleInCart`(listItemIdentifier bigint)
BEGIN

		update listitems set listitemincart=(not listitemincart) where listItemId=listItemIdentifier;

	END */$$
DELIMITER ;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
