package br.com.andrelemos.contabanco.base.favorecido.api.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode
@Embeddable
public class ContaDebitoPk implements Serializable {

  private static final long serialVersionUID = 2179763029221463510L;

  @NotNull
  @Column(name = "cd_banco")
  private Long banco;

  @NotNull
  @Column(name = "cd_agencia")
  private Long agencia;

  @NotNull
  @Column(name = "cd_conta")
  private Long conta;

  @NotNull
  @Column(name = "cd_digito")
  private Integer digito;

  @NotNull
  @Column(name = "cd_tipo_conta")
  private Long tipoConta;
}
