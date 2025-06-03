-- MySQL Workbench Synchronization
-- Generated: 2025-06-02 17:51
-- Model: New Model
-- Version: 1.0
-- Project: Name of the project
-- Author: 03786909148

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

ALTER SCHEMA `clinica`  DEFAULT CHARACTER SET utf8  DEFAULT COLLATE utf8_general_ci ;

ALTER TABLE `clinica`.`pessoa` 
DROP FOREIGN KEY `fk_pessoa_funcionario1`;

ALTER TABLE `clinica`.`animal` 
DROP FOREIGN KEY `fk_animal_pessoa1`;

ALTER TABLE `clinica`.`vacinacao` 
DROP FOREIGN KEY `fk_vacinacao_animal1`;

ALTER TABLE `clinica`.`frasco` 
DROP FOREIGN KEY `fk_frasco_lote1`;

ALTER TABLE `clinica`.`lote` 
DROP FOREIGN KEY `fk_lote_vacina1`;

ALTER TABLE `clinica`.`pessoa` 
CHARACTER SET = utf8 , COLLATE = utf8_general_ci ;

ALTER TABLE `clinica`.`veterinario` 
CHARACTER SET = utf8 , COLLATE = utf8_general_ci ;

ALTER TABLE `clinica`.`animal` 
CHARACTER SET = utf8 , COLLATE = utf8_general_ci ,
CHANGE COLUMN `idanimal` `idanimal` INT(11) NOT NULL AUTO_INCREMENT ;

ALTER TABLE `clinica`.`vacinacao` 
CHARACTER SET = utf8 , COLLATE = utf8_general_ci ;

ALTER TABLE `clinica`.`vacina` 
CHARACTER SET = utf8 , COLLATE = utf8_general_ci ;

ALTER TABLE `clinica`.`frasco` 
CHARACTER SET = utf8 , COLLATE = utf8_general_ci ;

ALTER TABLE `clinica`.`lote` 
CHARACTER SET = utf8 , COLLATE = utf8_general_ci ;

ALTER TABLE `clinica`.`pessoa` 
ADD CONSTRAINT `fk_pessoa_funcionario1`
  FOREIGN KEY (`funcionario_crmv`)
  REFERENCES `clinica`.`veterinario` (`crmv`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;

ALTER TABLE `clinica`.`animal` 
ADD CONSTRAINT `fk_animal_pessoa1`
  FOREIGN KEY (`pessoa_cpf`)
  REFERENCES `clinica`.`pessoa` (`cpf`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;

ALTER TABLE `clinica`.`vacinacao` 
DROP FOREIGN KEY `fk_vacinacao_veterinario1`,
DROP FOREIGN KEY `fk_vacinacao_vacina1`;

ALTER TABLE `clinica`.`vacinacao` ADD CONSTRAINT `fk_vacinacao_veterinario1`
  FOREIGN KEY (`veterinario_crmv`)
  REFERENCES `clinica`.`veterinario` (`crmv`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION,
ADD CONSTRAINT `fk_vacinacao_vacina1`
  FOREIGN KEY (`vacina_id_vacina`)
  REFERENCES `clinica`.`vacina` (`id_vacina`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION,
ADD CONSTRAINT `fk_vacinacao_animal1`
  FOREIGN KEY (`animal_idanimal`)
  REFERENCES `clinica`.`animal` (`idanimal`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;

ALTER TABLE `clinica`.`frasco` 
ADD CONSTRAINT `fk_frasco_lote1`
  FOREIGN KEY (`lote_id_lote`)
  REFERENCES `clinica`.`lote` (`id_lote`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;

ALTER TABLE `clinica`.`lote` 
ADD CONSTRAINT `fk_lote_vacina1`
  FOREIGN KEY (`vacina_id_vacina`)
  REFERENCES `clinica`.`vacina` (`id_vacina`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
