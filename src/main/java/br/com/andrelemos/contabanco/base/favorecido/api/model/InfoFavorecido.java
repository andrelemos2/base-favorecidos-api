package br.com.andrelemos.contabanco.base.favorecido.api.model;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Modelo que representa o cabecalho do favorecido
 * 
 * @author Andre Lemos
 * @version 1.0.0
 * @since Release 1
 *
 */
@ToString
@Getter
@Setter
public class InfoFavorecido {

  private Long banco;

  private Long agencia;

  private Long conta;

  private Integer digito;

  private List<Favorecido> favorecidos;

  public InfoFavorecido() {
    this.favorecidos = new ArrayList<>();
  }
}
