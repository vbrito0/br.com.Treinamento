package br.com.Treinamento.Pessoa.DTO;

import br.com.Treinamento.Pessoa.Model.Pessoa;
import br.com.Treinamento.Pessoa.Model.PessoaFisica;
import br.com.Treinamento.Pessoa.Validator.PessoaGroup;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Data
@ValidaPessoa(groups = { PessoaGroup.class })
@Builder
public class PessoaDTO {
	
	Long idPessoa;
	String nome;
	String nomeFantasia;
	String logradouro;
	String bairro;
	String cidade;
	String complemento;
	String cep;
	String uf;
	Integer numero;
	
	public PessoaDTO(Pessoa pessoa) {
		super();
		idPessoa = pessoa.getIdPessoa();
		nome = pessoa.getNome();
		nomeFantasia = pessoa.getNomeFantasia();
		logradouro = pessoa.getLogradouro();
		bairro = pessoa.getBairro();
		cidade = pessoa.getCidade();
		complemento = pessoa.getComplemento();
		cep = pessoa.getCep();
		uf = pessoa.getUf();
		numero = pessoa.getNumero();
	}
	
	public static Pessoa fromPessoa(PessoaDTO pessoaDTO) {
		Pessoa pessoa = new Pessoa();
		pessoa.setNome(pessoaDTO.getNome());
		pessoa.setNomeFantasia(pessoaDTO.getNomeFantasia());
		pessoa.setBairro(pessoaDTO.getBairro());
		pessoa.setCep(pessoaDTO.getCep());
		pessoa.setCidade(pessoaDTO.getCidade());
		pessoa.setComplemento(pessoaDTO.getComplemento());
		pessoa.setLogradouro(pessoaDTO.getLogradouro());
		pessoa.setNumero(pessoaDTO.getNumero());
		pessoa.setUf(pessoaDTO.getUf());
		return pessoa;
	}
	
	public static PessoaDTO fromPessoaDTO(Pessoa pessoa) {
		PessoaDTO pessoaDTO = new PessoaDTO();
		pessoaDTO.setNome(pessoa.getNome());
		pessoaDTO.setNomeFantasia(pessoa.getNomeFantasia());
		pessoaDTO.setBairro(pessoa.getBairro());
		pessoaDTO.setCep(pessoa.getCep());
		pessoaDTO.setCidade(pessoa.getCidade());
		pessoaDTO.setComplemento(pessoa.getComplemento());
		pessoaDTO.setLogradouro(pessoa.getLogradouro());
		pessoaDTO.setNumero(pessoa.getNumero());
		pessoaDTO.setUf(pessoa.getUf());
		return pessoaDTO;
	}
	
	public static PessoaFisica fromPessoaFisica(PessoaFisicaDTO pessoaFisicaDTO) {
		PessoaFisica pessoaFisica = new PessoaFisica();
		pessoaFisica.setNome(pessoaFisicaDTO.getNome());
		pessoaFisica.setNomeFantasia(pessoaFisicaDTO.getNomeFantasia());
		pessoaFisica.setBairro(pessoaFisicaDTO.getBairro());
		pessoaFisica.setCep(pessoaFisicaDTO.getCep());
		pessoaFisica.setCidade(pessoaFisicaDTO.getCidade());
		pessoaFisica.setComplemento(pessoaFisicaDTO.getComplemento());
		pessoaFisica.setLogradouro(pessoaFisicaDTO.getLogradouro());
		pessoaFisica.setNumero(pessoaFisicaDTO.getNumero());
		pessoaFisica.setUf(pessoaFisicaDTO.getUf());
		
		pessoaFisica.setCpf(pessoaFisicaDTO.getCpf());
		pessoaFisica.setRg(pessoaFisicaDTO.getRg());
		pessoaFisica.setGenero(pessoaFisicaDTO.getGenero());
		pessoaFisica.setNasc(pessoaFisicaDTO.getNasc());
		return pessoaFisica;
	}
	
	public static PessoaFisicaDTO fromPessoaFisicaDTO(PessoaFisica pessoaFisica) {
		PessoaFisicaDTO pessoaFisicaDTO = new PessoaFisicaDTO();
		pessoaFisicaDTO.setNome(pessoaFisica.getNome());
		pessoaFisicaDTO.setNomeFantasia(pessoaFisica.getNomeFantasia());
		pessoaFisicaDTO.setBairro(pessoaFisica.getBairro());
		pessoaFisicaDTO.setCep(pessoaFisica.getCep());
		pessoaFisicaDTO.setCidade(pessoaFisica.getCidade());
		pessoaFisicaDTO.setComplemento(pessoaFisica.getComplemento());
		pessoaFisicaDTO.setLogradouro(pessoaFisica.getLogradouro());
		pessoaFisicaDTO.setNumero(pessoaFisica.getNumero());
		pessoaFisicaDTO.setUf(pessoaFisica.getUf());
		
		pessoaFisicaDTO.setCpf(pessoaFisica.getCpf());
		pessoaFisicaDTO.setRg(pessoaFisica.getRg());
		pessoaFisicaDTO.setGenero(pessoaFisica.getGenero());
		pessoaFisicaDTO.setNasc(pessoaFisica.getNasc());
		return pessoaFisicaDTO;
	}
}
