SET SQL_SAFE_UPDATES = 0;

CREATE DATABASE Bens;

USE Bens;

CREATE TABLE Funcionario (
    ID INT AUTO_INCREMENT PRIMARY KEY,
    Matricula INT UNIQUE NOT NULL,
    Nome VARCHAR(255) NOT NULL,
    Email VARCHAR(50) NOT NULL,
    Telefone VARCHAR(50) NOT NULL,
    SetorQuePertence INT 
);

CREATE TABLE Setor (
    ID INT AUTO_INCREMENT PRIMARY KEY,
    CodigoSetor INT UNIQUE NOT NULL,
    Nome VARCHAR(100) NOT NULL,
    Responsavel INT 
);

ALTER TABLE Funcionario
ADD CONSTRAINT FK_Funcionario_Setor
FOREIGN KEY (SetorQuePertence) REFERENCES Setor(CodigoSetor) ON DELETE CASCADE ON UPDATE CASCADE;

ALTER TABLE Setor
ADD CONSTRAINT FK_Setor_Responsavel
FOREIGN KEY (Responsavel) REFERENCES Funcionario(ID) ON DELETE CASCADE ON UPDATE CASCADE;

CREATE TABLE Tipo (
    ID INT AUTO_INCREMENT PRIMARY KEY,
    Nome VARCHAR(50) NOT NULL
);

CREATE TABLE Movel (
    ID INT AUTO_INCREMENT PRIMARY KEY,
    CodigoPatrimonial INT UNIQUE NOT NULL,
    Descricao VARCHAR(255),
    IDTipo INT NOT NULL,
    DataAquisicao DATE NOT NULL,
    Valor DECIMAL(10, 2) NOT NULL,
    Estado ENUM('ATIVO', 'EM_MANUTENCAO', 'DANIFICADO', 'INATIVO', 'BAIXADO') NOT NULL,
    IDSetor INT,
    FOREIGN KEY (IDTipo) REFERENCES Tipo(ID),
    FOREIGN KEY (IDSetor) REFERENCES Setor(ID) ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE Movimentacao (
    ID INT AUTO_INCREMENT PRIMARY KEY,
    DataMovimentacao DATE NOT NULL,
    CodigoMovel INT,
    IDSetorOrigem INT,
    IDSetorDestino INT,
    IDResponsavel INT,
    FOREIGN KEY (CodigoMovel) REFERENCES Movel(CodigoPatrimonial) ON DELETE CASCADE ON UPDATE CASCADE,
    FOREIGN KEY (IDSetorOrigem) REFERENCES Setor(ID) ON DELETE CASCADE ON UPDATE CASCADE,
    FOREIGN KEY (IDSetorDestino) REFERENCES Setor(ID) ON DELETE CASCADE ON UPDATE CASCADE,
    FOREIGN KEY (IDResponsavel) REFERENCES Funcionario(ID) ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE Baixa (
    ID INT AUTO_INCREMENT PRIMARY KEY,
    CodigoMovel INT NOT NULL,
    Motivo VARCHAR(255) NOT NULL,
    DataBaixa DATE NOT NULL,
    FOREIGN KEY (CodigoMovel) REFERENCES Movel(CodigoPatrimonial) ON UPDATE CASCADE
);

DELIMITER //
CREATE TRIGGER before_delete_movel
BEFORE DELETE ON Movel
FOR EACH ROW
BEGIN
    DELETE FROM Baixa WHERE CodigoMovel = OLD.CodigoPatrimonial;
    DELETE FROM Movimentacao WHERE CodigoMovel = OLD.CodigoPatrimonial;
END;
//
DELIMITER ;

INSERT INTO Setor (CodigoSetor, Nome, Responsavel)
VALUES
(1, 'Administração', NULL),
(2, 'TI', NULL),
(3, 'RH', NULL),
(4, 'Financeiro', NULL),
(5, 'Marketing', NULL),
(6, 'Logística', NULL),
(7, 'Manutenção', NULL),
(8, 'Compras', NULL),
(9, 'Produção', NULL),
(10, 'Qualidade', NULL),
(11, 'Pesquisa', NULL),
(12, 'Vendas', NULL),
(13, 'Planejamento', NULL),
(14, 'Engenharia', NULL),
(15, 'Treinamento', NULL),
(16, 'Jurídico', NULL),
(17, 'Segurança', NULL),
(18, 'Auditoria', NULL),
(19, 'SAC', NULL),
(20, 'Diretoria', NULL);

INSERT INTO Funcionario (Matricula, Nome, Email, Telefone, SetorQuePertence)
VALUES
(1001, 'Alice Silva', 'alice@gmail.com', '1234-5678', 1),
(1002, 'Bruno Costa', 'bruno@gmail.com', '2345-6789', 1),
(1003, 'Carla Lima', 'carla@gmail.com', '3456-7890', 2),
(1004, 'Daniel Rocha', 'daniel@gmail.com', '4567-8901', 2),
(1005, 'Eduardo Nunes', 'eduardo@gmail.com', '5678-9012', 3),
(1006, 'Fernanda Souza', 'fernanda@gmail.com', '6789-0123', 3),
(1007, 'Gabriel Pinto', 'gabriel@gmail.com', '7890-1234', 4),
(1008, 'Helena Gomes', 'helena@gmail.com', '8901-2345', 4),
(1009, 'Igor Almeida', 'igor@gmail.com', '9012-3456', 5),
(1010, 'Julia Reis', 'julia@gmail.com', '0123-4567', 5),
(1011, 'Lucas Santos', 'lucas@gmail.com', '1234-5678', 1),
(1012, 'Mariana Oliveira', 'mariana@gmail.com', '2345-6789', 1),
(1013, 'Nicolas Barros', 'nicolas@gmail.com', '3456-7890', 2),
(1014, 'Olivia Ferreira', 'olivia@gmail.com', '4567-8901', 2),
(1015, 'Pedro Carvalho', 'pedro@gmail.com', '5678-9012', 3),
(1016, 'Quésia Ramos', 'quesia@gmail.com', '6789-0123', 3),
(1017, 'Rafael Dias', 'rafael@gmail.com', '7890-1234', 4),
(1018, 'Sofia Monteiro', 'sofia@gmail.com', '8901-2345', 4),
(1019, 'Thiago Mendes', 'thiago@gmail.com', '9012-3456', 5),
(1020, 'Vivian Cardoso', 'vivian@gmail.com', '0123-4567', 5);

UPDATE Setor
SET Responsavel = 5 WHERE ID = 1;
UPDATE Setor
SET Responsavel = 12 WHERE ID = 2;
UPDATE Setor
SET Responsavel = 8 WHERE ID = 3;
UPDATE Setor
SET Responsavel = 15 WHERE ID = 4;
UPDATE Setor
SET Responsavel = 2 WHERE ID = 5;
UPDATE Setor
SET Responsavel = 18 WHERE ID = 6;
UPDATE Setor
SET Responsavel = 4 WHERE ID = 7;
UPDATE Setor
SET Responsavel = 10 WHERE ID = 8;
UPDATE Setor
SET Responsavel = 1 WHERE ID = 9;
UPDATE Setor
SET Responsavel = 17 WHERE ID = 10;
UPDATE Setor
SET Responsavel = 20 WHERE ID = 11;
UPDATE Setor
SET Responsavel = 14 WHERE ID = 12;
UPDATE Setor
SET Responsavel = 19 WHERE ID = 13;
UPDATE Setor
SET Responsavel = 3 WHERE ID = 14;
UPDATE Setor
SET Responsavel = 7 WHERE ID = 15;
UPDATE Setor
SET Responsavel = 11 WHERE ID = 16;
UPDATE Setor
SET Responsavel = 16 WHERE ID = 17;
UPDATE Setor
SET Responsavel = 9 WHERE ID = 18;
UPDATE Setor
SET Responsavel = 13 WHERE ID = 19;
UPDATE Setor
SET Responsavel = 6 WHERE ID = 20;

INSERT INTO Tipo (Nome)
VALUES
('Cadeira'),
('Mesa'),
('Monitor'),
('Teclado'),
('Mouse'),
('Estante'),
('Arquivo'),
('Notebook'),
('Desktop'),
('Projetor'),
('Impressora'),
('Scanner'),
('Cofre'),
('Telefone'),
('Tablet'),
('Servidor'),
('Ar-condicionado'),
('Ventilador'),
('TV'),
('Outro');

INSERT INTO Movel (CodigoPatrimonial, Descricao, IDTipo, DataAquisicao, Valor, Estado, IDSetor)
VALUES
(1001, 'Cadeira de escritório', 1, '2023-01-01', 200.00, 'BAIXADO', 1),
(1002, 'Mesa de reunião', 2, '2023-01-15', 500.00, 'BAIXADO', 2),
(1003, 'Monitor 24"', 3, '2023-02-01', 300.00, 'BAIXADO', 3),
(1004, 'Teclado mecânico', 4, '2023-02-15', 100.00, 'ATIVO', 4),
(1005, 'Mouse sem fio', 5, '2023-03-01', 50.00, 'EM_MANUTENCAO', 5),
(1006, 'Estante de metal', 6, '2023-03-15', 400.00, 'ATIVO', 1),
(1007, 'Arquivo de aço', 7, '2023-04-01', 600.00, 'ATIVO', 2),
(1008, 'Notebook Dell', 8, '2023-04-15', 3000.00, 'ATIVO', 3),
(1009, 'Desktop HP', 9, '2023-05-01', 1500.00, 'INATIVO', 4),
(1010, 'Projetor Epson', 10, '2023-05-15', 2500.00, 'ATIVO', 5),
(1011, 'Impressora Laser', 11, '2023-06-01', 1200.00, 'EM_MANUTENCAO', 1),
(1012, 'Scanner HP', 12, '2023-06-15', 800.00, 'ATIVO', 2),
(1013, 'Cofre de segurança', 13, '2023-07-01', 1500.00, 'DANIFICADO', 3),
(1014, 'Telefone fixo', 14, '2023-07-15', 300.00, 'ATIVO', 4),
(1015, 'Tablet Samsung', 15, '2023-08-01', 2000.00, 'DANIFICADO', 5),
(1016, 'Servidor Dell', 16, '2023-08-15', 10000.00, 'ATIVO', 1),
(1017, 'Ar-condicionado portátil', 17, '2023-09-01', 1500.00, 'ATIVO', 2),
(1018, 'Ventilador de mesa', 18, '2023-09-15', 100.00, 'EM_MANUTENCAO', 3),
(1019, 'TV 50"', 19, '2023-10-01', 2500.00, 'ATIVO', 4),
(1020, 'Outro equipamento', 20, '2023-10-15', 150.00, 'INATIVO', 5);

INSERT INTO Movimentacao (DataMovimentacao, CodigoMovel, IDSetorOrigem, IDSetorDestino, IDResponsavel)
VALUES
('2023-01-01', 1001, 1, 2, 1),
('2023-01-15', 1002, 2, 3, 2),
('2023-02-01', 1003, 3, 4, 3),
('2023-02-15', 1004, 4, 5, 4),
('2023-03-01', 1005, 5, 1, 5),
('2023-03-15', 1006, 1, 2, 6),
('2023-04-01', 1007, 2, 3, 7),
('2023-04-15', 1008, 3, 4, 8),
('2023-05-01', 1009, 4, 5, 9),
('2023-05-15', 1010, 5, 1, 10),
('2023-06-01', 1011, 1, 2, 11),
('2023-06-15', 1012, 2, 3, 12),
('2023-07-01', 1013, 3, 4, 13),
('2023-07-15', 1014, 4, 5, 14),
('2023-08-01', 1015, 5, 1, 15),
('2023-08-15', 1016, 1, 2, 16),
('2023-09-01', 1017, 2, 3, 17),
('2023-09-15', 1018, 3, 4, 18),
('2023-10-01', 1019, 4, 5, 19),
('2023-10-15', 1020, 5, 1, 20);

INSERT INTO Baixa (CodigoMovel, Motivo, DataBaixa)
VALUES
(1001, 'Obsoleto', '2024-01-01'),
(1002, 'Excedente', '2024-01-15'),
(1003, 'Quebrado', '2024-02-01');

