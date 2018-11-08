
-- DROP  DATABASE IF EXISTS promo;
drop database promo;
CREATE DATABASE IF NOT EXISTS promo;
DROP TABLE IF EXISTS `promo`.`statistics`;
DROP TABLE IF EXISTS `promo`.`socialNetworks`;
DROP TABLE IF EXISTS `promo`.`promocodes`;
DROP TABLE IF EXISTS `promo`.`feedback`;
DROP TABLE IF EXISTS `promo`.`users`;
DROP TABLE IF EXISTS `promo`.`shops`;
DROP TABLE IF EXISTS `promo`.`sequence`;
DROP TABLE IF EXISTS `promo`.`operations`;
DROP TABLE IF EXISTS `promo`.`groups`;
DROP TABLE IF EXISTS `promo`.`entities`;
DROP TABLE IF EXISTS `promo`.`comments`;
DROP TABLE IF EXISTS `promo`.`categories`;
DROP TABLE IF EXISTS `promo`.`socialNetworksList`;

-- ************************************** `groups`

CREATE TABLE `promo`.`groups`
(
  `id`   INTEGER NOT NULL AUTO_INCREMENT ,
  `name` VARCHAR(45) NOT NULL ,

  PRIMARY KEY (`id`)
);

INSERT INTO `promo`.`groups`(name) VALUES('Administrator');
INSERT INTO `promo`.`groups`(name) VALUES('Moderator');
INSERT INTO `promo`.`groups`(name) VALUES('User');

-- ************************************** `shops`

CREATE TABLE `promo`.`shops`
(
  `id`       INTEGER NOT NULL AUTO_INCREMENT ,
  `name`     VARCHAR(100) NOT NULL UNIQUE ,
  `URL`      VARCHAR(100) NOT NULL UNIQUE ,
  `count`    INTEGER NOT NULL DEFAULT 0,

  PRIMARY KEY (`id`)
);



-- ************************************** `users`
CREATE TABLE `promo`.`users`
(
  `id`       INTEGER NOT NULL ,
  `login`    VARCHAR(177) NOT NULL UNIQUE,
  `email`    VARCHAR(255) NOT NULL UNIQUE,
  `password` VARCHAR(100) NOT NULL ,
  `lastLogin` DATETIME NULL,
  `groupID`  INTEGER NOT NULL,

  PRIMARY KEY (`id`),
  FOREIGN KEY (`groupID`) REFERENCES `groups` (`id`)
);


-- ************************************** `socialNetworksList`

CREATE TABLE `promo`.`socialNetworksList`
(
 `id`   integer NOT NULL ,
 `name` varchar(20) NOT NULL ,
PRIMARY KEY (`id`)
);


-- ************************************** `socialNetworks`

CREATE TABLE `promo`.`socialNetworks`
(
 `id`               integer NOT NULL AUTO_INCREMENT,
 `socialNetworkID`  integer NOT NULL ,
 `identificator`    varchar(40) NOT NULL ,
 `userID`           integer NOT NULL ,
PRIMARY KEY (`id`),
FOREIGN KEY (`userID`) REFERENCES `users` (`id`),
FOREIGN KEY (`socialNetworkID`) REFERENCES `socialNetworksList` (`id`)
);


-- ************************************** `categories`

CREATE TABLE `promo`.`categories`
(
 `id`          integer NOT NULL ,
 `name`        varchar(40) NOT NULL ,
 `parentID`    integer NOT NULL ,
 `description` text NOT NULL ,
PRIMARY KEY (`id`),
FOREIGN KEY (`parentID`) REFERENCES `categories` (`id`)
);

-- ************************************** `promocodes`

CREATE TABLE `promo`.`promocodes`
(
  `PromoID`     INTEGER NOT NULL AUTO_INCREMENT ,
  `promo`       VARCHAR(100) ,
  `issueDate`   DATE NOT NULL ,
  `expireDate`  DATE NULL ,
  `description` MEDIUMTEXT NULL ,
  `userID`      INTEGER NOT NULL ,
  `shopId`      INTEGER NOT NULL ,
  `parentID`    INTEGER NOT NULL ,

  PRIMARY KEY (`PromoID`),
  FOREIGN KEY (`userID`) REFERENCES `users` (`id`),
  FOREIGN KEY (`shopId`) REFERENCES `shops` (`id`),
  FOREIGN KEY (`parentID`) REFERENCES `categories` (`id`)
);

-- ************************************** `entities`

CREATE TABLE `promo`.`entities`
(
 `id`   integer NOT NULL ,
 `name` varchar(20) NOT NULL ,
PRIMARY KEY (`id`)
);



-- ************************************** `operations`

CREATE TABLE `promo`.`operations`
(
 `id`            integer NOT NULL ,
 `operationType` varchar(20) NOT NULL ,
PRIMARY KEY (`id`)
);


-- ************************************** `sequence`

CREATE TABLE `promo`.`sequence`
(
 `id`   integer NOT NULL AUTO_INCREMENT ,
 `stat` tinyint NOT NULL ,
PRIMARY KEY (`id`)
);



-- ************************************** `comments`

CREATE TABLE `promo`.`comments`
(
 `id`   integer NOT NULL ,
 `text` text NOT NULL ,
PRIMARY KEY (`id`)
);




-- ************************************** `feedback`

CREATE TABLE `promo`.`feedback`
(
 `id`           integer NOT NULL ,
 `operationID`  integer NOT NULL ,
 `entityID`     integer NOT NULL ,
 `entityNameID` integer NOT NULL ,
 `ownerID`      integer NOT NULL ,
 `commentID`    integer ,
PRIMARY KEY (`id`),
FOREIGN KEY (`operationID`) REFERENCES `operations` (`id`),
FOREIGN KEY (`entityNameID`) REFERENCES `entities` (`id`),
FOREIGN KEY (`ownerID`) REFERENCES `users` (`id`),
FOREIGN KEY (`commentID`) REFERENCES `comments` (`id`)
);






-- ************************************** `statistics`

CREATE TABLE `promo`.`statistics`
(
 `id`                integer NOT NULL ,
 `date`              datetime NOT NULL ,
 `bestPromoID`       integer NOT NULL ,
 `worstPromoID`      integer NOT NULL ,
 `uniqUsersCount`    integer NOT NULL ,
 `uniqLikesCount`    integer NOT NULL ,
 `uniqDislikesCount` integer NOT NULL ,
PRIMARY KEY (`id`),
FOREIGN KEY (`bestPromoID`) REFERENCES `promocodes` (`PromoID`),
FOREIGN KEY (`worstPromoID`) REFERENCES `promocodes` (`PromoID`)
);






DROP TRIGGER IF EXISTS `promo`.`delete_user`;
CREATE TRIGGER `promo`.`delete_user` before delete ON `promo`.`users`
FOR EACH ROW BEGIN
UPDATE `promocodes` SET userID='1' WHERE `promocodes`.`userID`=OLD.`id`;
DELETE FROM `promo`.`feedback` WHERE `feedback`.ownerID=OLD.`id` or `feedback`.entityID=OLD.`id`;
END;


CREATE FUNCTION promo.next_id() RETURNS INTEGER DETERMINISTIC
   BEGIN
     DECLARE _id INTEGER;
     INSERT sequence (stat) VALUES (1);
		SELECT max(id) INTO _id FROM  sequence WHERE  stat = 1;
      DELETE FROM sequence WHERE stat = 0;
      UPDATE sequence SET stat = 0 WHERE stat = 1;
   RETURN _id;
   END;


INSERT INTO `promo`.`users` (id,login,email,password,groupID,lastLogin) VALUE (promo.next_id(),'Administrator','Admin@admin.ru',1234,1, '2008-10-23 10:37:22');
