package br.com.andrelemos.contabanco.base.favorecido.api.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FavorecidoRequest {

  private Long banco;

  private Long agencia;

  private Long conta;

  private Integer digito;

  private Long tipoConta;

  private Integer pagina;

  private Integer limite;
}
