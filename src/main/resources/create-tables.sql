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
