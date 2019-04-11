CREATE TABLE `subscriptions` (
  `idsubscriptions` INT NOT NULL,
  `name` VARCHAR(45) NULL,
  `cost` INT GENERATED ALWAYS AS (0),
  `subscribers` INT GENERATED ALWAYS AS (0),
  PRIMARY KEY (`idsubscriptions`),
  UNIQUE INDEX `idsubscriptions_UNIQUE` (`idsubscriptions` ASC) VISIBLE,
  UNIQUE INDEX `name_UNIQUE` (`name` ASC) VISIBLE);
