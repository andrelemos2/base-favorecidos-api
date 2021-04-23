package br.com.andrelemos.contabanco.base.favorecido.api.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.andrelemos.contabanco.base.favorecido.api.entity.ContaDebito;
import br.com.andrelemos.contabanco.base.favorecido.api.entity.ContaDebitoPk;

@Repository
public interface ContaDebitoRepository extends CrudRepository<ContaDebito, ContaDebitoPk> {}
