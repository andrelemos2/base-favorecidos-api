CREATE TABLE conta_debito (
	cd_banco BIGINT(4) NOT NULL,
	cd_agencia BIGINT(4) NOT NULL,
	cd_conta BIGINT(10) NOT NULL,
	cd_digito INT(1) NOT NULL,
	cd_tipo_conta BIGINT(4) NOT NULL,
	cd_cnpj_cpf BIGINT(14) NOT NULL,
	nome_cliente VARCHAR(120) NOT NULL,
	cd_tipo_pessoa INT(1) NOT NULL,
	data_carga_registro TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
	data_alteracao_registro TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
	CONSTRAINT `pk_conta_debito`
		PRIMARY KEY (`cd_banco`, `cd_agencia`, `cd_conta`, `cd_digito`, `cd_tipo_conta`),
	CONSTRAINT `fk_conta_debito_tipo_conta`
	  	FOREIGN KEY (`cd_tipo_conta`)
	  	REFERENCES `tipo_conta` (`cd_tipo_conta`)
	  	ON DELETE NO ACTION
	  	ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO conta_debito (cd_cnpj_cpf, cd_banco, cd_agencia, cd_conta, cd_digito, cd_tipo_conta, nome_cliente, cd_tipo_pessoa) VALUES (44918885071, 341, 3718, 2516, 8, 2, 'Andre Lemos', 2);
