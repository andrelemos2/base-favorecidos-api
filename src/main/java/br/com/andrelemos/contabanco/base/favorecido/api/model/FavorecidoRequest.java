package br.com.andrelemos.contabanco.base.favorecido.api.model;

import lombok.Getter;
import lombok.Setter;

/**
 * Modelo que representa o pedido de requisicao de um favorecido
 *
 * @author Andre Lemos
 * @version 1.0.0
 * @since Release 1
 */
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
