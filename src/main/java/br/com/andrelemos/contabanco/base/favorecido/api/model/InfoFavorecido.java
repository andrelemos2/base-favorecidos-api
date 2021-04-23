package br.com.andrelemos.contabanco.base.favorecido.api.model;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

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
