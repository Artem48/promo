
DROP  DATABASE IF EXISTS promo;
CREATE DATABASE promo;
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



-- ************************************** `shops`

CREATE TABLE `promo`.`shops`
(
  `id`       INTEGER NOT NULL AUTO_INCREMENT ,
  `name`     VARCHAR(100) NOT NULL ,
  `URL`      VARCHAR(100) NOT NULL ,
  `count`    INTEGER NOT NULL ,
  `likes`    INTEGER NOT NULL ,
  `dislikes` INTEGER NOT NULL ,

  PRIMARY KEY (`id`)
);



-- ************************************** `users`

CREATE TABLE `promo`.`users`
(
  `id`       INTEGER NOT NULL AUTO_INCREMENT ,
  `login`    VARCHAR(177) NOT NULL ,
  `email`    VARCHAR(255) NOT NULL ,
  `password` VARCHAR(100) NOT NULL ,
  `rating`   INTEGER NOT NULL ,
  `groupID`  INTEGER NOT NULL ,

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
  `expireDate`  DATE NOT NULL ,
  `likes`       INTEGER NOT NULL ,
  `dislikes`    INTEGER NOT NULL ,
  `description` MEDIUMTEXT NOT NULL ,
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
