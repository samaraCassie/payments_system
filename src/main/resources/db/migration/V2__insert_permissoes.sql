INSERT INTO permissao (id, permissao_id, nome)
VALUES
    (uuid_generate_v4(), uuid_generate_v4(), 'ADMINISTRADOR'),
    (uuid_generate_v4(), uuid_generate_v4(), 'USUARIO'),
    (uuid_generate_v4(), uuid_generate_v4(), 'GERENCIAR_USUARIOS'),
    (uuid_generate_v4(), uuid_generate_v4(), 'GERENCIAR_PERMISSOES'),
    (uuid_generate_v4(), uuid_generate_v4(), 'GERENCIAR_CATEGORIAS'),
    (uuid_generate_v4(), uuid_generate_v4(), 'GERENCIAR_SERVICOS_PAGAMENTO'),
    (uuid_generate_v4(), uuid_generate_v4(), 'GERENCIAR_CONTAS'),
    (uuid_generate_v4(), uuid_generate_v4(), 'CONSULTAR_RELATORIOS');