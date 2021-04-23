package br.com.andrelemos.contabanco.base.favorecido.api.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import br.com.andrelemos.contabanco.base.favorecido.api.entity.ContaDebito;
import br.com.andrelemos.contabanco.base.favorecido.api.entity.ContaDebitoPk;
import br.com.andrelemos.contabanco.base.favorecido.api.model.Favorecido;
import br.com.andrelemos.contabanco.base.favorecido.api.model.FavorecidoRequest;
import br.com.andrelemos.contabanco.base.favorecido.api.model.InfoFavorecido;
import br.com.andrelemos.contabanco.base.favorecido.api.repository.ContaCreditoRepository;
import br.com.andrelemos.contabanco.base.favorecido.api.repository.ContaDebitoRepository;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class FavorecidoServiceImpl implements BaseFavorecidoService {

  @Autowired private ContaDebitoRepository contaDebitoRepository;

  @Autowired private ContaCreditoRepository contaCreditoRepository;

  @Override
  public Optional<InfoFavorecido> obterListaFavorecido(FavorecidoRequest request) {
    try {
      ContaDebitoPk contaDebitoPk = populaContaDebitoPk(request);
      Optional<ContaDebito> contaDebito = contaDebitoRepository.findById(contaDebitoPk);

      if (!contaDebito.isPresent()) {
        return Optional.empty();
      }

      return Optional.of(
          popularFavorecidos(contaDebito.get(), request.getPagina(), request.getLimite()));
    } catch (Exception exc) {
      log.error("OCORREU UM ERRO AO CONSULTAR A LISTA DE FAVORECIDOS", exc);
      throw new RuntimeException();
    }
  }

  private ContaDebitoPk populaContaDebitoPk(FavorecidoRequest request) {
    ContaDebitoPk pk = new ContaDebitoPk();
    pk.setBanco(request.getBanco());
    pk.setAgencia(request.getAgencia());
    pk.setConta(request.getConta());
    pk.setDigito(request.getDigito());
    pk.setTipoConta(request.getTipoConta());
    return pk;
  }

  private InfoFavorecido popularFavorecidos(
      ContaDebito contaDebito, Integer pagina, Integer tamanho) {
    InfoFavorecido infoContaDebito = new InfoFavorecido();
    infoContaDebito.setBanco(contaDebito.getCodigo().getBanco());
    infoContaDebito.setAgencia(contaDebito.getCodigo().getAgencia());
    infoContaDebito.setConta(contaDebito.getCodigo().getConta());
    infoContaDebito.setDigito(contaDebito.getCodigo().getDigito());

    List<Favorecido> favorecidos =
        contaCreditoRepository
            .buscarTodos(
                infoContaDebito.getBanco(),
                infoContaDebito.getAgencia(),
                infoContaDebito.getConta(),
                infoContaDebito.getDigito(),
                PageRequest.of(pagina, tamanho))
            .getContent();

    infoContaDebito.setFavorecidos(favorecidos);

    return infoContaDebito;
  }
}
