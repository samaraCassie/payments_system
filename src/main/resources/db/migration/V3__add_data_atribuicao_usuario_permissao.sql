ALTER TABLE usuario_permissao
ADD COLUMN data_atribuicao TIMESTAMP NOT NULL DEFAULT now();