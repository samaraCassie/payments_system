CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

CREATE TABLE categoria (
    id                                UUID                                   PRIMARY KEY DEFAULT uuid_generate_v4(),
    categoria_id                      UUID                                   NOT NULL UNIQUE,
    nome                              VARCHAR(100)                           NOT NULL
);

CREATE TABLE servico_pagamento (
    id                                UUID                                   PRIMARY KEY DEFAULT uuid_generate_v4(),
    servico_pagamento_id              UUID                                   NOT NULL UNIQUE,
    nome                              VARCHAR(100)                           NOT NULL,
    descricao                         TEXT
);

CREATE TABLE usuario (
     id                               UUID                                   PRIMARY KEY DEFAULT uuid_generate_v4(),
     usuario_id                       UUID                                   NOT NULL UNIQUE,
     nome                             VARCHAR(100)                           NOT NULL,
     email                            VARCHAR(255)                           NOT NULL UNIQUE,
     senha                            VARCHAR(255)                           NOT NULL,
     data_cadastro                    TIMESTAMP WITHOUT TIME ZONE            NOT NULL DEFAULT now(),
     status_atividade                 SMALLINT                               NOT NULL
);

CREATE TABLE permissao (
    id                                UUID                                   PRIMARY KEY DEFAULT uuid_generate_v4(),
    permissao_id                      UUID                                   NOT NULL UNIQUE,
    nome                              VARCHAR(100)                           NOT NULL
);

CREATE TABLE usuario_permissao (
    usuario_id                        UUID                                   NOT NULL,
    permissao_id                      UUID                                   NOT NULL,
    PRIMARY KEY (usuario_id, permissao_id),
    CONSTRAINT fk_usuario             FOREIGN KEY (usuario_id)               REFERENCES usuario(id) ON DELETE CASCADE,
    CONSTRAINT fk_permissao           FOREIGN KEY (permissao_id)             REFERENCES permissao(id) ON DELETE CASCADE
);

CREATE TABLE conta (
    id                                UUID                                   PRIMARY KEY DEFAULT uuid_generate_v4(),
    conta_id                          UUID                                   NOT NULL UNIQUE,
    data_vencimento                   DATE                                   NOT NULL,
    data_pagamento                    DATE,
    valor                             NUMERIC(12,2)                          NOT NULL,
    descricao                         TEXT,
    status                            SMALLINT                               NOT NULL,

    categoria_id                      UUID,
    servico_pagamento_id              UUID,
    usuario_id                        UUID,

    CONSTRAINT fk_categoria           FOREIGN KEY (categoria_id)             REFERENCES categoria(id),
    CONSTRAINT fk_servico_pagamento   FOREIGN KEY (servico_pagamento_id)     REFERENCES servico_pagamento(id),
    CONSTRAINT fk_usuario_conta       FOREIGN KEY (usuario_id)               REFERENCES usuario(id)
);
