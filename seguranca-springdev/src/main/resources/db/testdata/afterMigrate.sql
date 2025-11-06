-- ================================================
-- DESABILITAR CONSTRAINTS PARA LIMPEZA
-- ================================================
SET FOREIGN_KEY_CHECKS = 0;

TRUNCATE TABLE tbusuario;

SET FOREIGN_KEY_CHECKS = 1;


-- ================================================
-- POPULAÇÃO DE USUÁRIOS
-- ================================================
-- Insere os 10 usuários
INSERT INTO tbusuario (nome, email, senha) VALUES ('João Silva', 'joao.silva@email.com', 'senha123');

INSERT INTO tbusuario (nome, email, senha) VALUES ('Maria Santos', 'maria.santos@email.com', 'senha456');

INSERT INTO tbusuario (nome, email, senha) VALUES ('Pedro Oliveira', 'pedro.oliveira@email.com', 'senha789');

INSERT INTO tbusuario (nome, email, senha) VALUES ('Ana Costa', 'ana.costa@email.com', 'ana2024');

INSERT INTO tbusuario (nome, email, senha) VALUES ('Carlos Ferreira', 'carlos.ferreira@email.com', 'carlos123');

INSERT INTO tbusuario (nome, email, senha) VALUES ('Juliana Lima', 'juliana.lima@email.com', 'juliana456');

INSERT INTO tbusuario (nome, email, senha) VALUES ('Roberto Alves', 'roberto.alves@email.com', 'roberto789');

INSERT INTO tbusuario (nome, email, senha) VALUES ('Fernanda Souza', 'fernanda.souza@email.com', 'fernanda2024');

INSERT INTO tbusuario (nome, email, senha) VALUES ('Lucas Rodrigues', 'lucas.rodrigues@email.com', 'lucas123');

INSERT INTO tbusuario (nome, email, senha) VALUES ('Camila Martins', 'camila.martins@email.com', 'camila456');