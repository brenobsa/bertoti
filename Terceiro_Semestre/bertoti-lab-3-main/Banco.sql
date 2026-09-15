-- 1. Criação e seleção do banco de dados
CREATE DATABASE IF NOT EXISTS `treino_db`
  DEFAULT CHARACTER SET utf8mb4 
  COLLATE utf8mb4_unicode_ci;

USE `treino_db`;

-- 2. Limpeza prévia (ordem inversa das dependências)
DROP TABLE IF EXISTS `exercicios`;
DROP TABLE IF EXISTS `treinos`;

-- 3. Criação da tabela de Treinos
CREATE TABLE `treinos` (
    `identificador` VARCHAR(5) NOT NULL,
    `grupo_muscular` VARCHAR(255) NULL,
    PRIMARY KEY (`identificador`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- 4. Criação da tabela de Exercícios
CREATE TABLE `exercicios` (
    `id` BIGINT NOT NULL AUTO_INCREMENT,
    `nome` VARCHAR(255) NOT NULL,
    `series` INT NOT NULL,
    `repeticoes` INT NOT NULL,
    `treino_id` VARCHAR(5) NOT NULL,
    PRIMARY KEY (`id`),
    CONSTRAINT `fk_exercicio_treino` 
        FOREIGN KEY (`treino_id`) 
        REFERENCES `treinos` (`identificador`) 
        ON DELETE CASCADE 
        ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- 5. Carga inicial dos Treinos A, B e C
INSERT INTO `treinos` (`identificador`, `grupo_muscular`) VALUES
('A', 'Peito e Tríceps'),
('B', 'Costas e Bíceps'),
('C', 'Pernas e Ombros');

-- 6. Carga inicial dos Exercícios
INSERT INTO `exercicios` (`nome`, `series`, `repeticoes`, `treino_id`) VALUES
('Supino Reto', 4, 12, 'A'),
('Remada Curvada', 4, 12, 'B'),
('Leg Press 45', 4, 12, 'C');