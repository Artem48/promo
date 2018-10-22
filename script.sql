--  Database `promo` -- 


CREATE DATABASE promo;


-- Table `promo`.`Users` -- 




DROP TABLE IF EXISTS `promo`.`Users`;
		
CREATE TABLE `promo`.`Users` (
  `id` INTEGER NULL AUTO_INCREMENT DEFAULT NULL,
  `login` VARCHAR(177) NULL DEFAULT NULL,
  `email` VARCHAR(255) NULL DEFAULT NULL,
  `password` VARCHAR(100) NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY (`email`)
) ENGINE=InnoDB CHARACTER SET=UTF8;


-- Table `promo`.`promocodes` -- 


DROP TABLE IF EXISTS `promo`.`promocodes`;
		
CREATE TABLE `promo`.`promocodes` (
  `promoId` INTEGER NULL AUTO_INCREMENT DEFAULT NULL,
  `promo` VARCHAR(100) NULL DEFAULT NULL,
  `site` VARCHAR(100) NULL DEFAULT NULL,
  `userId` INTEGER NULL DEFAULT NULL,
  `issueDate` DATE NULL DEFAULT NULL,
  `likes` INTEGER NULL DEFAULT 0,
  `dislikes` INTEGER NULL DEFAULT 0,
  PRIMARY KEY (`promoId`),
  UNIQUE KEY (`promo`),
  FOREIGN KEY (`userId`) REFERENCES Users(`id`)
) ENGINE=InnoDB CHARACTER SET=UTF8;


-- Table `promo`.`comments` -- 


DROP TABLE IF EXISTS `promo`.`comments`;
		
CREATE TABLE `promo`.`comments` (
  `id` INTEGER NULL AUTO_INCREMENT DEFAULT NULL,
  `userId` INTEGER NULL DEFAULT NULL,
  `promoId` INTEGER NULL DEFAULT NULL,
  `comment` MEDIUMTEXT NULL DEFAULT NULL,
  `time` DATETIME NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  FOREIGN KEY (`userId`) REFERENCES Users(`id`),
  FOREIGN KEY (`promoId`) REFERENCES promocodes(`promoId`)
) ENGINE=InnoDB CHARACTER SET=UTF8;



-- Test Data -- 


-- INSERT INTO `Users` (`id`,`login`,`email`,`password`) VALUES
-- ('','','','');
-- INSERT INTO `promocodes` (`promoId`,`promo`,`userId`,`issueDate`,`likes`,`dislikes`) VALUES
-- ('','','','','','');
-- INSERT INTO `comments` (`id`,`userId`,`promoId`,`comment`,`time`) VALUES
-- ('','','','','');