package br.com.andrelemos.contabanco.base.favorecido.api.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


/**
 * Modelo que representa um favorecido
 * 
 * @author Andre Lemos
 * @version 1.0.0
 * @since Release 1
 *
 */
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
public class Favorecido {

  private Long cnpjCpf;

  private String nomeFavorecido;

  private Integer tipoPessoa;

  private Long banco;

  private Long agencia;

  private Long conta;

  private Integer digito;

  private Integer tipoContaPagamento;

  private Long tipoConta;
}
