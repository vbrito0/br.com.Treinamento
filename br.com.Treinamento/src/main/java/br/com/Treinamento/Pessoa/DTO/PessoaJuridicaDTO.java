package br.com.Treinamento.Pessoa.DTO;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "cnpj", callSuper = false)
@Data
public class PessoaJuridicaDTO extends PessoaDTO{

	String cnpj;
	String inscricaoEstadual;
	LocalDate fundacao;

	public PessoaJuridicaDTO(Long idPessoa, String nome, String nomeFantasia, String logradouro, String bairro, String cidade,
			String complemento, String cep, String uf, Integer numero, String cnpj, String inscricaoEstadual, LocalDate fundacao) {

		super(idPessoa, nome, nomeFantasia, logradouro, bairro, cidade, complemento, cep, uf, numero);
		this.cnpj = cnpj;
		this.inscricaoEstadual = inscricaoEstadual;
		this.fundacao = fundacao;
	}
}
