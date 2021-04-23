CREATE TABLE conta_credito (
	cd_banco BIGINT(4) NOT NULL,
	cd_agencia BIGINT(4) NOT NULL,
	cd_conta BIGINT(10) NOT NULL,
	cd_digito INT(1) NOT NULL,
	cd_tipo_conta BIGINT(4) NOT NULL,
	cd_cnpj_cpf BIGINT(14),
	nome_favorecido VARCHAR(120),
	cd_tipo_pessoa INT(1),	
	cd_tipo_conta_pagamento INT(1) NOT NULL,
	cd_banco_de BIGINT(4) NOT NULL,
	cd_agencia_de BIGINT(4) NOT NULL,
	cd_conta_de BIGINT(10) NOT NULL,
	cd_digito_de INT(1) NOT NULL,
	cd_tipo_conta_de BIGINT(4) NOT NULL,
	data_carga_registro TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
	data_alteracao_registro TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
	CONSTRAINT `fk_conta_credito_conta_debito`
  	FOREIGN KEY (`cd_banco_de`, `cd_agencia_de`, `cd_conta_de`, `cd_digito_de`, `cd_tipo_conta_de`)
  	REFERENCES `basefavorecido`.`conta_debito` (`cd_banco`, `cd_agencia`, `cd_conta`, `cd_digito`, `cd_tipo_conta`)
  	ON DELETE NO ACTION
  	ON UPDATE NO ACTION,
	CONSTRAINT `fk_conta_credito_tipo_conta`
  	FOREIGN KEY (`cd_tipo_conta`)
  	REFERENCES `basefavorecido`.`tipo_conta` (`cd_tipo_conta`)
  	ON DELETE NO ACTION
  	ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


INSERT INTO `basefavorecido`.`conta_credito` (`cd_banco`, `cd_agencia`, `cd_conta`, `cd_digito`, `cd_tipo_conta`, `cd_cnpj_cpf`, `nome_favorecido`, `cd_tipo_pessoa`, `cd_tipo_conta_pagamento`, `cd_banco_de`, `cd_agencia_de`, `cd_conta_de`, `cd_digito_de`, `cd_tipo_conta_de`) VALUES (347, 2516, 5420, 8, 2, 22783088827, 'Andre Lemos', 2, 1, 341, 3718, 2516, 8, 2);
