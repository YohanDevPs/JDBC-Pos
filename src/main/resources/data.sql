SET FOREIGN_KEY_CHECKS = 0;
DROP TABLE IF EXISTS tuser;
DROP TABLE IF EXISTS tfarm;
DROP TABLE IF EXISTS tacquisition;
DROP TABLE IF EXISTS tresource;
DROP TABLE IF EXISTS tseed;
DROP TABLE IF EXISTS tresource_tacquisition;
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

CREATE TABLE tacquisition (
    id INT PRIMARY KEY AUTO_INCREMENT,
    description VARCHAR(255),
    date DATE,
    idFarm INT,
    idUser INT,
    FOREIGN KEY (idFarm) REFERENCES tfarm(id),
    FOREIGN KEY (idUser) REFERENCES tuser(id)
);

CREATE TABLE tseed (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(255) NOT NULL,
    quantity FLOAT NOT NULL,
    description VARCHAR(255) NOT NULL,
    seed_type VARCHAR(255) NOT NULL,
    amount FLOAT NOT NULL
);

-- Inserir dados na tabela tuser
INSERT INTO tuser (name, email, password)
VALUES ('Usuário 1', 'usuario1@email.com', 'senha123'),
('Usuário 2', 'usuario2@email.com', 'senha456'),
('Usuário 3', 'usuario3@email.com', 'senha789'),
('Usuário 4', 'usuario4@email.com', 'senhaabc'),
('Usuário 5', 'usuario5@email.com', 'senha123'),
('Usuário 6', 'usuario6@email.com', 'senha456'),
('Usuário 7', 'usuario7@email.com', 'senha789'),
('Usuário 8', 'usuario8@email.com', 'senhaabc'),
('Usuário 9', 'usuario9@email.com', 'senha123'),
('Usuário 10', 'usuario10@email.com', 'senha456');

-- Inserir dados na tabela tfarm
INSERT INTO tfarm (name, licence, register, idUser)
VALUES ('Fazenda 1', TRUE, 'ABC123', 1),
('Fazenda 2', FALSE, 'XYZ789', 2),
('Fazenda 3', TRUE, 'DEF456', 3),
('Fazenda 4', FALSE, 'GHI789', 4),
('Fazenda 5', TRUE, 'JKL012', 5),
('Fazenda 6', FALSE, 'MNO345', 6),
('Fazenda 7', TRUE, 'PQR678', 7),
('Fazenda 8', FALSE, 'STU901', 8),
('Fazenda 9', TRUE, 'VWX234', 9),
('Fazenda 10', FALSE, 'YZA567', 10);

INSERT INTO tacquisition (description, date, idFarm, idUser)
VALUES ('Aquisição 1', '2023-11-09', 1, 1),
('Aquisição 2', '2023-11-10', 2, 2),
('Aquisição 3', '2023-11-11', 3, 3),
('Aquisição 4', '2023-11-12', 4, 4),
('Aquisição 5', '2023-11-13', 5, 5),
('Aquisição 6', '2023-11-14', 6, 6),
('Aquisição 7', '2023-11-15', 7, 7),
('Aquisição 8', '2023-11-16', 8, 8),
('Aquisição 9', '2023-11-17', 9, 9),
('Aquisição 10', '2023-11-18', 10, 10);

INSERT INTO tseed (name, quantity, description, seed_type, amount)
VALUES ('Seed1', 10.5, 'Description1', 'OLEAGINOUS', 25.0),
('Seed2', 15.0, 'Description2', 'ORTHODOX', 30.0),
('Seed3', 8.75, 'Description3', 'PASTURE', 20.0);