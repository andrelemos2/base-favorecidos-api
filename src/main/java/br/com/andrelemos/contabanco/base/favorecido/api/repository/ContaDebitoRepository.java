package br.com.andrelemos.contabanco.base.favorecido.api.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.andrelemos.contabanco.base.favorecido.api.entity.ContaDebito;
import br.com.andrelemos.contabanco.base.favorecido.api.entity.ContaDebitoPk;

/**
 * Camada para realizar mapeamento ORM da Conta de Debito na base de favorecidos
 * 
 * @author Andre Lemos
 * @version 1.0.0
 * @since Release 1
 *
 */
@Repository
public interface ContaDebitoRepository extends CrudRepository<ContaDebito, ContaDebitoPk> {}
