
-- DROP  DATABASE IF EXISTS promo;
drop database promo;
CREATE DATABASE IF NOT EXISTS promo DEFAULT CHARSET=utf8;
DROP TABLE IF EXISTS `promo`.`statistics`;
DROP TABLE IF EXISTS `promo`.`statistics_type`;
DROP TABLE IF EXISTS `promo`.`socialNetworks`;
DROP TABLE IF EXISTS `promo`.`promocodes`;
DROP TABLE IF EXISTS `promo`.`feedback`;
DROP TABLE IF EXISTS `promo`.`users`;
DROP TABLE IF EXISTS `promo`.`shops`;
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
) DEFAULT CHARSET=utf8;

-- ************************************** `shops`

CREATE TABLE `promo`.`shops`
(
  `id`       INTEGER NOT NULL AUTO_INCREMENT ,
  `name`     VARCHAR(100) NOT NULL UNIQUE ,
  `URL`      VARCHAR(100) NOT NULL UNIQUE ,

  PRIMARY KEY (`id`)
)
  AUTO_INCREMENT = 300000;



-- ************************************** `users`
CREATE TABLE `promo`.`users`
(
  `id`       INTEGER NOT NULL AUTO_INCREMENT,
  `login`    VARCHAR(177) NOT NULL UNIQUE,
  `email`    VARCHAR(255) NOT NULL UNIQUE,
  `password` VARCHAR(100) NOT NULL ,
  `groupID`  INTEGER NOT NULL,

  PRIMARY KEY (`id`),
  FOREIGN KEY (`groupID`) REFERENCES `groups` (`id`)
) AUTO_INCREMENT = 1000000;


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
  `id`          integer NOT NULL AUTO_INCREMENT ,
  `name`        varchar(40) NOT NULL ,
  `parentID`    integer,
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
)AUTO_INCREMENT = 2000000000;

-- ************************************** `entities`

CREATE TABLE `promo`.`entities`
(
  `id`   integer NOT NULL ,
  `name` varchar(20) NOT NULL ,
  PRIMARY KEY (`id`)
);



-- ************************************** `operation_types`

CREATE TABLE `promo`.`operation_types`
(
  `id`            integer NOT NULL ,
  `operationType` varchar(20) NOT NULL ,
  PRIMARY KEY (`id`)
);


-- ************************************** `comments`

CREATE TABLE `promo`.`comments`
(
  `id`   integer NOT NULL ,
  `text` text NOT NULL ,
  PRIMARY KEY (`id`)
);

-- ************************************** `operations`

CREATE TABLE `promo`.`operations`
(
  `id`           integer NOT NULL ,
  `operationID`  integer NOT NULL ,
  `entityID`     integer NOT NULL ,
  `entityNameID` integer NOT NULL ,
  `ownerID`      integer NOT NULL ,
  `commentID`    integer ,
  `value`		 integer,

  PRIMARY KEY (`id`),
  FOREIGN KEY (`operationID`) REFERENCES `operation_types` (`id`),
  FOREIGN KEY (`entityNameID`) REFERENCES `entities` (`id`),
  FOREIGN KEY (`ownerID`) REFERENCES `users` (`id`),
  FOREIGN KEY (`commentID`) REFERENCES `comments` (`id`)
);


-- ************************************** `statistics`

CREATE TABLE `promo`.`statistics_type`
(
  `id`	integer NOT NULL AUTO_INCREMENT,
  `name` varchar(30) NOT NULL,
    PRIMARY KEY (`id`)
);

CREATE TABLE `promo`.`statistics`
(
  `id`                integer NOT NULL AUTO_INCREMENT,
  `date`              datetime NOT NULL ,
  `type`			  integer NOT NULL,
  `value`			  integer,
  PRIMARY KEY (`id`),
  FOREIGN KEY (`type`) REFERENCES `statistics_type` (`id`)
);








DROP TRIGGER IF EXISTS `promo`.`delete_user`;
CREATE TRIGGER `promo`.`delete_user` before delete ON `promo`.`users`
  FOR EACH ROW BEGIN
  UPDATE `promocodes` SET userID='1' WHERE `promocodes`.`userID`=OLD.`id`;
  DELETE FROM `promo`.`feedback` WHERE `feedback`.ownerID=OLD.`id` or `feedback`.entityID=OLD.`id`;
END;


-- ************************************* init values

INSERT INTO `promo`.`groups`(name) VALUES('Administrator');
INSERT INTO `promo`.`groups`(name) VALUES('Moderator');
INSERT INTO `promo`.`groups`(name) VALUES('User');

INSERT INTO `promo`.`users` (login,email,password,groupID) VALUE ('Administrator','Admin@admin.ru','81dc9bdb52d04dc20036dbd8313ed055',1);

INSERT INTO `promo`.`shops` (name,URL) VALUE ('Юлмарт','https://www.ulmaurt.ru/');
INSERT INTO `promo`.`shops` (name,URL) VALUE ('Твое','https://www.tvoe.ru');
INSERT INTO `promo`.`shops` (name,URL) VALUE ('МВидео','https://www.mvideo.ru');
INSERT INTO `promo`.`shops` (name,URL) VALUE ('Эльдорадо','https://www.eldorado.ru/');
INSERT INTO `promo`.`shops` (name,URL) VALUE ('Ozon','https://www.ozon.ru/');
INSERT INTO `promo`.`shops` (name,URL) VALUE ('Ecco','https://www.ecco-shoes.ru/');
INSERT INTO `promo`.`shops` (name,URL) VALUE ('Достаевский','https://www.dostaevskii.ru/');
INSERT INTO `promo`.`shops` (name,URL) VALUE ('Ollis','https://www.ollis.ru/');
INSERT INTO `promo`.`shops` (name,URL) VALUE ('Додо пицца','https://dodopizza.ru');

INSERT INTO `promo`.`categories` (name,parentID,description) VALUE ('еда',NULL,'чтобы покушать');
INSERT INTO `promo`.`categories` (name,parentID,description) VALUE ('бургеры',1,'чтобы покушать');
INSERT INTO `promo`.`categories` (name,parentID,description) VALUE ('пиццы',1,'чтобы покушать');
INSERT INTO `promo`.`categories` (name,parentID,description) VALUE ('сеты',1,'чтобы покушать');
INSERT INTO `promo`.`categories` (name,parentID,description) VALUE ('одежда',NULL,'чтобы одеться');
INSERT INTO `promo`.`categories` (name,parentID,description) VALUE ('мужское',5,'для мужчин');
INSERT INTO `promo`.`categories` (name,parentID,description) VALUE ('женское',5,'для женщин');

INSERT INTO `promo`.`statistics_type` (name) VALUE ('bestPromo');
INSERT INTO `promo`.`statistics_type` (name) VALUE ('worstPromo');
INSERT INTO `promo`.`statistics_type` (name) VALUE ('uniqLikes');
INSERT INTO `promo`.`statistics_type` (name) VALUE ('uniqDislikes');


