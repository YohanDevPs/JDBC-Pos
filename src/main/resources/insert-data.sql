INSERT INTO tuser (name, email, password) VALUES
('Usuário 1', 'usuario1@email.com', 'senha123'),
('Usuário 2', 'usuario2@email.com', 'senha456'),
-- ... (adicionar outros dados)

INSERT INTO tfarm (name, licence, register, idUser) VALUES
('Fazenda 1', TRUE, 'ABC123', 1),
('Fazenda 2', FALSE, 'XYZ789', 2),
-- ... (adicionar outros dados)

INSERT INTO tresource (nome, quantidade, idUser) VALUES
('Recurso 1', 10.5, 1),
('Recurso 2', 7.2, 2),
-- ... (adicionar outros dados)

INSERT INTO tacquisition (description, dateTime, idFarm, idUser) VALUES
('Aquisição 1', '2023-11-09 12:30:00', 1, 1),
('Aquisição 2', '2023-11-10 14:45:00', 2, 2),
-- ... (adicionar outros dados)

INSERT INTO tresource_tacquisition (resource_id, acquisition_id) VALUES
(1, 1),
(2, 2),
-- ... (adicionar outros dados)

INSERT INTO tseed (name, quantity, description, seed_type, amount) VALUES
('Seed1', 10.5, 'Description1', 'OLEAGINOUS', 25.0),
('Seed2', 15.0, 'Description2', 'ORTHODOX', 30.0),
-- ... (adicionar outros dados)

INSERT INTO tfertilizer (name, quantity, description, fertilizer_type, amount) VALUES
('Fertilizer 1', 1.56, 'Description1', 'MICRONUTRIENT', 65.0),
('Fertilizer 2', 1.0, 'Description2', 'ORGANIC', 19.0),
-- ... (adicionar outros dados)

INSERT INTO tpesticide (name, quantity, description, pesticide_type, amount) VALUES
('Pesticide 1', 1.5, 'Description1', 'DESFOLIANT', 25.0),
('Pesticide 2', 6.0, 'Description2', 'INSECTICIDE', 30.0),
-- ... (adicionar outros dados)
