CREATE TABLE `springsecurity`.`roles` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `name_UNIQUE` (`name` ASC) VISIBLE);

  CREATE TABLE `springsecurity`.`users` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `username` VARCHAR(45) NOT NULL,
  `password` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `username_UNIQUE` (`username` ASC) VISIBLE);

  INSERT INTO `springsecurity`.`users` (`username`, `password`) VALUES ('user', '100');
    INSERT INTO `springsecurity`.`users` (`username`, `password`) VALUES ('admin', '100');

    CREATE TABLE `springsecurity`.`users_roles` (
  `user_id` BIGINT(20) NOT NULL,
  `role_id` BIGINT(20) NOT NULL,
  INDEX `fk_users_idx` (`user_id` ASC) VISIBLE,
  INDEX `fk_roles_idx` (`role_id` ASC) VISIBLE,
  CONSTRAINT `fk_users`
    FOREIGN KEY (`user_id`)
    REFERENCES `springsecurity`.`users` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_roles`
    FOREIGN KEY (`role_id`)
    REFERENCES `springsecurity`.`roles` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);

    INSERT INTO `springsecurity`.`roles` (`name`) VALUES ('USER');
INSERT INTO `springsecurity`.`roles` (`name`) VALUES ('ADMIN');
INSERT INTO `springsecurity`.`roles` (`name`) VALUES ('MANAGER');

INSERT INTO `springsecurity`.`users_roles` (`user_id`, `role_id`) VALUES ('1','1');