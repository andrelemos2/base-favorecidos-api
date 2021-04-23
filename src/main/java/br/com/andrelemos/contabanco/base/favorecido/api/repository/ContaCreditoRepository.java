package br.com.andrelemos.contabanco.base.favorecido.api.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import br.com.andrelemos.contabanco.base.favorecido.api.entity.ContaCredito;
import br.com.andrelemos.contabanco.base.favorecido.api.entity.ContaCreditoPk;
import br.com.andrelemos.contabanco.base.favorecido.api.model.Favorecido;

/**
 * Camada para realizar mapeamento ORM da Conta de Credito na base de favorecidos
 * 
 * @author Andre Lemos
 * @version 1.0.0
 * @since Release 1
 *
 */
public interface ContaCreditoRepository extends CrudRepository<ContaCredito, ContaCreditoPk> {

  @Query(
      value =
          "SELECT new br.com.andrelemos.contabanco.base.favorecido.api.model.Favorecido(c.codigo.cnpjCpf, c.nomeFavorecido, c.tipoPessoa, c.codigo.banco, c.codigo.agencia, c.codigo.conta, c.codigo.digito, c.tipoContaPagamento, c.codigo.tipoConta) FROM ContaCredito c WHERE c.contaDeDebito.codigo.banco = :banco AND c.contaDeDebito.codigo.agencia = :agencia AND c.contaDeDebito.codigo.conta = :conta AND c.contaDeDebito.codigo.digito = :digito ",
      countQuery =
          "SELECT count(*) FROM ContaCredito c WHERE c.contaDeDebito.codigo.banco = :banco AND c.contaDeDebito.codigo.agencia = :agencia AND c.contaDeDebito.codigo.conta = :conta AND c.contaDeDebito.codigo.digito = :digito ")
  Page<Favorecido> buscarTodos(
      @Param("banco") Long banco,
      @Param("agencia") Long agencia,
      @Param("conta") Long conta,
      @Param("digito") Integer digito,
      Pageable pageable);
}
