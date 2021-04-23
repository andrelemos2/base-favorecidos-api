package br.com.andrelemos.contabanco.base.favorecido.api.service;

import java.util.Optional;

import br.com.andrelemos.contabanco.base.favorecido.api.model.FavorecidoRequest;
import br.com.andrelemos.contabanco.base.favorecido.api.model.InfoFavorecido;

public interface BaseFavorecidoService {
  Optional<InfoFavorecido> obterListaFavorecido(FavorecidoRequest request);
}
