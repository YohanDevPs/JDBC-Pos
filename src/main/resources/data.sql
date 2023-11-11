SET FOREIGN_KEY_CHECKS = 0;
DROP TABLE IF EXISTS tuser;
DROP TABLE IF EXISTS tfarm;
DROP TABLE IF EXISTS tacquisition;
DROP TABLE IF EXISTS tresource;
DROP TABLE IF EXISTS tresource_tacquisition;
DROP TABLE IF EXISTS tseed;
DROP TABLE IF EXISTS tfertilizer;
DROP TABLE IF EXISTS tpesticide;
SET FOREIGN_KEY_CHECKS = 1;

CREATE TABLE tuser (
	id INT AUTO_INCREMENT,
    name VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE tfarm (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(255) NOT NULL,
    licence BOOLEAN NOT NULL,
    register VARCHAR(255) NOT NULL,
    idUser INT,
    FOREIGN KEY (idUser) REFERENCES tuser(id)
);

CREATE TABLE tresource (
    id INT PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(255),
    quantidade FLOAT,
    idUser INT,
    FOREIGN KEY (idUser) REFERENCES tuser(id)
);

CREATE TABLE tacquisition (
    id INT PRIMARY KEY AUTO_INCREMENT,
    description VARCHAR(255),
    dateTime DATETIME,
    idFarm INT,
    idUser INT,
    FOREIGN KEY (idFarm) REFERENCES tfarm(id),
    FOREIGN KEY (idUser) REFERENCES tuser(id)
);

CREATE TABLE tresource_tacquisition (
    resource_id INT,
    acquisition_id INT,
    FOREIGN KEY (resource_id) REFERENCES tresource(id),
    FOREIGN KEY (acquisition_id) REFERENCES tacquisition(id)
);

CREATE TABLE tseed (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(255) NOT NULL,
    quantity FLOAT NOT NULL,
    description VARCHAR(255) NOT NULL,
    seed_type VARCHAR(255) NOT NULL,
    amount FLOAT NOT NULL
);

CREATE TABLE tfertilizer (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(255) NOT NULL,
    quantity FLOAT NOT NULL,
    description VARCHAR(255) NOT NULL,
    fertilizer_type VARCHAR(255) NOT NULL,
    amount FLOAT NOT NULL
);

CREATE TABLE tpesticide (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(255) NOT NULL,
    quantity FLOAT NOT NULL,
    description VARCHAR(255) NOT NULL,
    pesticide_type VARCHAR(255) NOT NULL,
    amount FLOAT NOT NULL
);

INSERT INTO tuser (name, email, password) VALUES
('Usuário 1', 'usuario1@email.com', 'senha123'),
('Usuário 2', 'usuario2@email.com', 'senha456'),
('Usuário 3', 'usuario3@email.com', 'senha789'),
('Usuário 4', 'usuario4@email.com', 'senhaabc'),
('Usuário 5', 'usuario5@email.com', 'senha123'),
('Usuário 6', 'usuario6@email.com', 'senha456'),
('Usuário 7', 'usuario7@email.com', 'senha789'),
('Usuário 8', 'usuario8@email.com', 'senhaabc'),
('Usuário 9', 'usuario9@email.com', 'senha123'),
('Usuário 10', 'usuario10@email.com', 'senha456');

INSERT INTO tfarm (name, licence, register, idUser) VALUES
('Fazenda 1', TRUE, 'ABC123', 1),
('Fazenda 2', FALSE, 'XYZ789', 2),
('Fazenda 3', TRUE, 'DEF456', 3),
('Fazenda 4', FALSE, 'GHI789', 4),
('Fazenda 5', TRUE, 'JKL012', 5),
('Fazenda 6', FALSE, 'MNO345', 6),
('Fazenda 7', TRUE, 'PQR678', 7),
('Fazenda 8', FALSE, 'STU901', 8),
('Fazenda 9', TRUE, 'VWX234', 9),
('Fazenda 10', FALSE, 'YZA567', 10);

INSERT INTO tresource (nome, quantidade, idUser) VALUES
('Recurso 1', 10.5, 1),
('Recurso 2', 7.2, 2),
('Recurso 3', 5.0, 3),
('Recurso 4', 8.8, 4),
('Recurso 5', 12.3, 5),
('Recurso 6', 6.7, 6),
('Recurso 7', 9.1, 7),
('Recurso 8', 4.4, 8),
('Recurso 9', 11.2, 9),
('Recurso 10', 3.3, 10);

INSERT INTO tacquisition (description, dateTime, idFarm, idUser) VALUES
('Aquisição 1', '2023-11-09 12:30:00', 1, 1),
('Aquisição 2', '2023-11-10 14:45:00', 2, 2),
('Aquisição 3', '2023-11-11 10:15:00', 3, 3),
('Aquisição 4', '2023-11-12 08:00:00', 4, 4),
('Aquisição 5', '2023-11-13 16:20:00', 5, 5),
('Aquisição 6', '2023-11-14 13:00:00', 6, 6),
('Aquisição 7', '2023-11-15 09:45:00', 7, 7),
('Aquisição 8', '2023-11-16 11:30:00', 8, 8),
('Aquisição 9', '2023-11-17 15:10:00', 9, 9),
('Aquisição 10', '2023-11-18 07:50:00', 10, 10);

INSERT INTO tresource_tacquisition (resource_id, acquisition_id) VALUES
(1, 1),
(2, 2),
(3, 3),
(4, 4),
(5, 5),
(6, 6),
(7, 7),
(8, 8),
(9, 9),
(10, 10);

INSERT INTO tseed (name, quantity, description, seed_type, amount)
VALUES ('Seed1', 10.5, 'Description1', 'OLEAGINOUS', 25.0),
('Seed2', 15.0, 'Description2', 'ORTHODOX', 30.0),
('Seed3', 8.75, 'Description3', 'PASTURE', 20.0);

INSERT INTO tfertilizer (name, quantity, description, fertilizer_type, amount)
VALUES ('Fertilizer 1', 1.56, 'Description1', 'MICRONUTRIENT', 65.0),
('Fertilizer 2', 1.0, 'Description2', 'ORGANIC', 19.0),
('Fertilizer 3', 2.75, 'Description3', 'MINERAL', 90.0);

INSERT INTO tpesticide (name, quantity, description, pesticide_type, amount)
VALUES ('Pesticide 1', 1.5, 'Description1', 'DESFOLIANT', 25.0),
('Pesticide 2', 6.0, 'Description2', 'INSECTICIDE', 30.0),
('Pesticide 3', 9.75, 'Description3', 'INSECTICIDE', 20.0);