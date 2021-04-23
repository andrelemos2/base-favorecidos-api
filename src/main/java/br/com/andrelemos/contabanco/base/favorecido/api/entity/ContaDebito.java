package br.com.andrelemos.contabanco.base.favorecido.api.entity;

import java.time.LocalDateTime;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

/**
 * Entidade que representa uma conta de debito (cliente) na base
 * 
 * @author Andre Lemos
 * @version 1.0.0
 * @since Release 1
 *
 */
@Getter
@Setter
@EqualsAndHashCode
@Entity
@Table(name = "conta_debito")
public class ContaDebito {

  @EmbeddedId private ContaDebitoPk codigo;

  @NotNull
  @Column(name = "cd_cnpj_cpf")
  private Long cnpjCpf;

  @NotNull
  @Column(name = "nome_cliente")
  private String nomeCliente;

  @NotNull
  @Column(name = "cd_tipo_pessoa")
  private Integer tipoPessoa;

  @OneToMany(mappedBy = "contaDeDebito", cascade = CascadeType.ALL, orphanRemoval = true)
  private Set<ContaCredito> contasDeCredito;

  @NotNull
  @Column(name = "data_carga_registro")
  private LocalDateTime dataInclusaoRegistro;

  @NotNull
  @Column(name = "data_alteracao_registro")
  private LocalDateTime dataAlteracaoRegistro;
}
