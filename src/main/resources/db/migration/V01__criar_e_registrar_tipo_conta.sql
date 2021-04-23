CREATE TABLE tipo_conta (
	cd_tipo_conta BIGINT(4) PRIMARY KEY,
	descricao VARCHAR(20) NOT NULL,
	data_carga_registro TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
	data_alteracao_registro TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO tipo_conta (cd_tipo_conta, descricao) VALUES (1, 'POUPANCA');
INSERT INTO tipo_conta (cd_tipo_conta, descricao) VALUES (2, 'CORRENTE');
