-- MySQL Script generated by MySQL Workbench
-- Sun Jun  8 21:15:21 2025
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema clinica
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `clinica` ;

-- -----------------------------------------------------
-- Schema clinica
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `clinica` DEFAULT CHARACTER SET utf8 ;
USE `clinica` ;

-- -----------------------------------------------------
-- Table `clinica`.`veterinario`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `clinica`.`veterinario` ;

CREATE TABLE IF NOT EXISTS `clinica`.`veterinario` (
  `crmv` VARCHAR(15) NOT NULL,
  PRIMARY KEY (`crmv`))
ENGINE = InnoDB;

INSERT INTO `clinica`.`veterinario` (`crmv`) VALUES ('12345MS');


-- -----------------------------------------------------
-- Table `clinica`.`pessoa`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `clinica`.`pessoa` ;

CREATE TABLE IF NOT EXISTS `clinica`.`pessoa` (
  `nome` VARCHAR(45) NOT NULL,
  `cpf` VARCHAR(15) NOT NULL,
  `telefone` VARCHAR(15) NOT NULL,
  `email` VARCHAR(45) NOT NULL,
  `data_nascimento` DATE NOT NULL,
  `sexo` CHAR NOT NULL,
  `funcionario_crmv` VARCHAR(15) NULL,
  PRIMARY KEY (`cpf`),
  INDEX `fk_pessoa_funcionario1_idx` (`funcionario_crmv` ASC) VISIBLE,
  CONSTRAINT `fk_pessoa_funcionario1`
    FOREIGN KEY (`funcionario_crmv`)
    REFERENCES `clinica`.`veterinario` (`crmv`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

INSERT INTO `clinica`.`pessoa` (`nome`, `cpf`, `telefone`, `email`, `data_nascimento`, `sexo`, `funcionario_crmv`) VALUES ('Dr. Carlos Elias', '123.456.789-00', '(11) 98765-4321', 'joao.silva@email.com', '1985-05-20', 'm', '12345MS');


-- -----------------------------------------------------
-- Table `clinica`.`animal`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `clinica`.`animal` ;

CREATE TABLE IF NOT EXISTS `clinica`.`animal` (
  `idanimal` INT NOT NULL AUTO_INCREMENT,
  `raca` VARCHAR(45) NOT NULL DEFAULT 'Generico',
  `nome` VARCHAR(45) NOT NULL,
  `data_nascimento_animal` DATE NOT NULL,
  `sexo` CHAR NOT NULL,
  `peso` FLOAT NOT NULL,
  `especie` VARCHAR(45) NOT NULL,
  `pessoa_cpf` VARCHAR(15) NOT NULL,
  INDEX `fk_animal_pessoa1_idx` (`pessoa_cpf` ASC) VISIBLE,
  PRIMARY KEY (`idanimal`),
  UNIQUE INDEX `idanimal_UNIQUE` (`idanimal` ASC) VISIBLE,
  CONSTRAINT `fk_animal_pessoa1`
    FOREIGN KEY (`pessoa_cpf`)
    REFERENCES `clinica`.`pessoa` (`cpf`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `clinica`.`vacina`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `clinica`.`vacina` ;

CREATE TABLE IF NOT EXISTS `clinica`.`vacina` (
  `id_vacina` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(45) NOT NULL,
  `fabricante` VARCHAR(45) NOT NULL,
  `validade_da_aplicacao` INT NOT NULL,
  `dosagem` FLOAT NOT NULL,
  PRIMARY KEY (`id_vacina`),
  UNIQUE INDEX `id_vacina_UNIQUE` (`id_vacina` ASC) VISIBLE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `clinica`.`lote`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `clinica`.`lote` ;

CREATE TABLE IF NOT EXISTS `clinica`.`lote` (
  `id_lote` VARCHAR(20) NOT NULL,
  `vacina_id_vacina` INT NOT NULL,
  `data_validade` DATE NOT NULL,
  PRIMARY KEY (`id_lote`),
  INDEX `fk_lote_vacina1_idx` (`vacina_id_vacina` ASC) VISIBLE,
  UNIQUE INDEX `id_lote_UNIQUE` (`id_lote` ASC) VISIBLE,
  CONSTRAINT `fk_lote_vacina1`
    FOREIGN KEY (`vacina_id_vacina`)
    REFERENCES `clinica`.`vacina` (`id_vacina`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `clinica`.`frasco`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `clinica`.`frasco` ;

CREATE TABLE IF NOT EXISTS `clinica`.`frasco` (
  `id_frasco` VARCHAR(20) NOT NULL,
  `lote_id_lote` VARCHAR(20) NOT NULL,
  `volume_frasco` FLOAT NOT NULL,
  PRIMARY KEY (`id_frasco`),
  INDEX `fk_frasco_lote1_idx` (`lote_id_lote` ASC) VISIBLE,
  CONSTRAINT `fk_frasco_lote1`
    FOREIGN KEY (`lote_id_lote`)
    REFERENCES `clinica`.`lote` (`id_lote`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `clinica`.`vacinacao`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `clinica`.`vacinacao` ;

CREATE TABLE IF NOT EXISTS `clinica`.`vacinacao` (
  `id_vacinacao` INT NOT NULL AUTO_INCREMENT,
  `dataAplicacao` DATE NOT NULL,
  `dataRetorno` DATE NULL,
  `veterinario_crmv` VARCHAR(15) NOT NULL,
  `dose_aplicada` FLOAT NOT NULL,
  `animal_idanimal` INT NOT NULL,
  `frasco_id_frasco` VARCHAR(20) NOT NULL,
  INDEX `fk_vacinacao_veterinario1_idx` (`veterinario_crmv` ASC) VISIBLE,
  INDEX `fk_vacinacao_frasco1_idx` (`frasco_id_frasco` ASC) VISIBLE,
  PRIMARY KEY (`id_vacinacao`),
  UNIQUE INDEX `id_vacinacao_UNIQUE` (`id_vacinacao` ASC) VISIBLE,
  CONSTRAINT `fk_vacinacao_veterinario1`
    FOREIGN KEY (`veterinario_crmv`)
    REFERENCES `clinica`.`veterinario` (`crmv`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_vacinacao_animal1`
    FOREIGN KEY (`animal_idanimal`)
    REFERENCES `clinica`.`animal` (`idanimal`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_vacinacao_frasco1`
    FOREIGN KEY (`frasco_id_frasco`)
    REFERENCES `clinica`.`frasco` (`id_frasco`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
