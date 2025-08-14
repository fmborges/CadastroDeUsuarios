-- V2: Migration para adicionar a coluna de Cambio na tabela de Carros

ALTER TABLE TB_CARROS
ADD COLUMN cambio VARCHAR(255);