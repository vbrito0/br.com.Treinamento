package br.com.Treinamento.Pessoa.Model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.br.CNPJ;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = "cnpj", callSuper = false)
@Entity
@DiscriminatorValue(value = "PESSOA_JURIDICA")
public class PessoaJuridica extends Pessoa{
	
	private static final long serialVersionUID = 1L;

	@CNPJ(message = "CNPJ inválido")
	@NotBlank(message = "CNPJ é obrigatório")
	private String cnpj;
	
	@Column(name = "INSCRICAO_ESTADUAL")
	private String inscricaoEstadual;
	
	@Column(name = "FUNDACAO")
	LocalDate fundacao;
	
	@OneToOne
	@JoinColumn(name = "ID_PESSOA")
	private Pessoa pessoa;
	
}
