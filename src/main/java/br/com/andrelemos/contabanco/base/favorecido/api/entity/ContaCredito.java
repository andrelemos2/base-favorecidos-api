package br.com.andrelemos.contabanco.base.favorecido.api.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode
@Entity
@Table(name = "conta_credito")
public class ContaCredito {

  @EmbeddedId private ContaCreditoPk codigo;

  @Column(name = "nome_favorecido")
  private String nomeFavorecido;

  @Column(name = "cd_tipo_pessoa")
  private Integer tipoPessoa;

  @NotNull
  @Column(name = "cd_tipo_conta_pagamento")
  private Integer tipoContaPagamento;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumns(
      foreignKey = @ForeignKey(name = "fk_conta_credito_conta_debito"),
      value = {
        @JoinColumn(
            name = "cd_banco_de",
            referencedColumnName = "cd_banco",
            insertable = false,
            updatable = false),
        @JoinColumn(
            name = "cd_agencia_de",
            referencedColumnName = "cd_agencia",
            insertable = false,
            updatable = false),
        @JoinColumn(
            name = "cd_conta_de",
            referencedColumnName = "cd_conta",
            insertable = false,
            updatable = false),
        @JoinColumn(
            name = "cd_digito_de",
            referencedColumnName = "cd_digito",
            insertable = false,
            updatable = false),
        @JoinColumn(
            name = "cd_tipo_conta_de",
            referencedColumnName = "cd_tipo_conta",
            insertable = false,
            updatable = false)
      })
  private ContaDebito contaDeDebito;

  @NotNull
  @Column(name = "data_carga_registro")
  private LocalDateTime dataInclusaoRegistro;

  @NotNull
  @Column(name = "data_alteracao_registro")
  private LocalDateTime dataAlteracaoRegistro;
}
