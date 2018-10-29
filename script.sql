
-- DROP  DATABASE IF EXISTS promo;

CREATE DATABASE promo;

DROP TABLE IF EXISTS `promo`.`promoDislikes`;
DROP TABLE IF EXISTS `promo`.`promoLikes`;
DROP TABLE IF EXISTS `promo`.`shopDislikes`;
DROP TABLE IF EXISTS `promo`.`shopLikes`;
DROP TABLE IF EXISTS `promo`.`promoComments`;
DROP TABLE IF EXISTS `promo`.`shopComments`;
DROP TABLE IF EXISTS `promo`.`promocodes`;
DROP TABLE IF EXISTS `promo`.`users`;
DROP TABLE IF EXISTS `promo`.`groups`;
DROP TABLE IF EXISTS `promo`.`shops`;


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
  `id`       INTEGER NOT NULL AUTO_INCREMENT ,
  `login`    VARCHAR(177) NOT NULL UNIQUE,
  `email`    VARCHAR(255) NOT NULL UNIQUE,
  `password` VARCHAR(100) NOT NULL ,
  `vkID`      INTEGER UNIQUE,
  `rating`   INTEGER NOT NULL DEFAULT 0,
  `session`   VARCHAR(40) NULL,
  `lastLogin` DATETIME NULL,
  `groupID`  INTEGER NOT NULL,

  PRIMARY KEY (`id`),
  FOREIGN KEY (`groupID`) REFERENCES `groups` (`id`)
);



-- ************************************** `shopComments`

CREATE TABLE `promo`.`shopComments`
(
  `id`      INTEGER NOT NULL AUTO_INCREMENT ,
  `comment` MEDIUMTEXT NOT NULL ,
  `time`    DATETIME NOT NULL ,
  `userID`  INTEGER NOT NULL ,
  `shopID`  INTEGER NOT NULL ,

  PRIMARY KEY (`id`),
  FOREIGN KEY (`userID`) REFERENCES `users` (`id`),
  FOREIGN KEY (`shopID`) REFERENCES `shops` (`id`)
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

  PRIMARY KEY (`PromoID`),
  FOREIGN KEY (`userID`) REFERENCES `users` (`id`),
  FOREIGN KEY (`shopId`) REFERENCES `shops` (`id`)
);



-- ************************************** `promoComments`

CREATE TABLE `promo`.`promoComments`
(
  `id`      INTEGER NOT NULL AUTO_INCREMENT ,
  `comment` MEDIUMTEXT NOT NULL ,
  `time`    DATETIME NOT NULL ,
  `userID`  INTEGER NOT NULL ,
  `promoID` INTEGER NOT NULL ,

  PRIMARY KEY (`id`),
  FOREIGN KEY (`userID`) REFERENCES `users` (`id`),
  FOREIGN KEY (`promoID`) REFERENCES `promocodes` (`PromoID`)
);

-- ************************************** `shopDislikes`

CREATE TABLE `promo`.`shopDislikes`
(
 `id`     INTEGER NOT NULL AUTO_INCREMENT ,
 `userID` INTEGER NOT NULL ,
 `shopID` INTEGER NOT NULL ,

PRIMARY KEY (`id`),
FOREIGN KEY (`userID`) REFERENCES `users` (`id`),
FOREIGN KEY (`shopID`) REFERENCES `shops` (`id`)
);



-- ************************************** `shopLikes`

CREATE TABLE `promo`.`shopLikes`
(
 `id`     INTEGER NOT NULL AUTO_INCREMENT ,
 `userID` INTEGER NOT NULL ,
 `shopID` INTEGER NOT NULL ,

PRIMARY KEY (`id`),
FOREIGN KEY (`userID`) REFERENCES `users` (`id`),
FOREIGN KEY (`shopID`) REFERENCES `shops` (`id`)
);


-- ************************************** `promoDislikes`

CREATE TABLE `promo`.`promoDislikes`
(
 `id`      INTEGER NOT NULL AUTO_INCREMENT ,
 `PromoID` INTEGER NOT NULL ,
 `userID`  INTEGER NOT NULL ,

PRIMARY KEY (`id`),
FOREIGN KEY (`PromoID`) REFERENCES `promocodes` (`PromoID`),
FOREIGN KEY (`userID`) REFERENCES `users` (`id`)
);



-- ************************************** `promoLikes`

CREATE TABLE `promo`.`promoLikes`
(
 `id`      INTEGER NOT NULL AUTO_INCREMENT ,
 `PromoID` INTEGER NOT NULL ,
 `userID`  INTEGER NOT NULL ,

PRIMARY KEY (`id`),
FOREIGN KEY (`PromoID`) REFERENCES `promocodes` (`PromoID`),
FOREIGN KEY (`userID`) REFERENCES `users` (`id`)
);