ALTER TABLE conta_credito ADD UNIQUE INDEX conta_credito_favorecido_unq_idx (cd_cnpj_cpf ASC, cd_tipo_pessoa ASC, cd_banco ASC, cd_agencia ASC, cd_conta ASC, cd_digito ASC);
