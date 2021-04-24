package br.com.andrelemos.contabanco.base.favorecido.api.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import br.com.andrelemos.contabanco.base.favorecido.api.entity.ContaDebito;
import br.com.andrelemos.contabanco.base.favorecido.api.entity.ContaDebitoPk;
import br.com.andrelemos.contabanco.base.favorecido.api.model.Favorecido;
import br.com.andrelemos.contabanco.base.favorecido.api.model.FavorecidoRequest;
import br.com.andrelemos.contabanco.base.favorecido.api.model.InfoFavorecido;
import br.com.andrelemos.contabanco.base.favorecido.api.repository.ContaCreditoRepository;
import br.com.andrelemos.contabanco.base.favorecido.api.repository.ContaDebitoRepository;

@ExtendWith(MockitoExtension.class)
class BaseFavorecidoServiceImplTest {

  @InjectMocks private BaseFavorecidoServiceImpl baseFavorecidoService;

  @Mock private ContaDebitoRepository contaDebitoRepository;

  @Mock private ContaCreditoRepository contaCreditoRepository;

  @DisplayName("Realiza pesquisa na base de favorecidos")
  @Test
  void deveRealizarPesquisaNaBaseDeFavorecidos() {
    ContaDebitoPk pk = populaContaDebitoPkMock();

    Optional<ContaDebito> contaDebito = Optional.of(populaContaDebitoMock(pk));

    when(contaDebitoRepository.findById(Mockito.any(ContaDebitoPk.class))).thenReturn(contaDebito);

    when(contaCreditoRepository.buscarTodos(
            Mockito.anyLong(),
            Mockito.anyLong(),
            Mockito.anyLong(),
            Mockito.anyInt(),
            Mockito.any(Pageable.class)))
        .thenReturn(new PageImpl<Favorecido>(populaFavorecedos()));

    FavorecidoRequest request = populaRequestMock();

    Optional<InfoFavorecido> favoritos = baseFavorecidoService.obterListaFavorecido(request);

    assertThat(favoritos.get().getBanco()).isEqualTo(341L);
  }

  private FavorecidoRequest populaRequestMock() {
    FavorecidoRequest request = new FavorecidoRequest();
    request.setBanco(341L);
    request.setAgencia(2516L);
    request.setConta(5678L);
    request.setDigito(8);
    request.setTipoConta(2L);
    request.setPagina(0);
    request.setLimite(10);
    return request;
  }

  private List<Favorecido> populaFavorecedos() {
    Favorecido favorecido = new Favorecido();
    return Collections.singletonList(favorecido);
  }

  private ContaDebitoPk populaContaDebitoPkMock() {
    ContaDebitoPk pk = new ContaDebitoPk();
    pk.setBanco(341L);
    pk.setAgencia(2516L);
    pk.setConta(5678L);
    pk.setDigito(8);
    pk.setTipoConta(2L);
    return pk;
  }

  private ContaDebito populaContaDebitoMock(ContaDebitoPk pk) {
    ContaDebito contaDebito = new ContaDebito();
    contaDebito.setCodigo(pk);
    contaDebito.setCnpjCpf(12345678901L);
    contaDebito.setNomeCliente("Andre Teste");
    contaDebito.setTipoPessoa(2);
    return contaDebito;
  }
}
