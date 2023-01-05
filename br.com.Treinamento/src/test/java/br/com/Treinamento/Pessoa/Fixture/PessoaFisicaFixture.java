package br.com.Treinamento.Pessoa.Fixture;

import java.time.LocalDate;

import org.junit.jupiter.api.TestInfo;

import br.com.Treinamento.Pessoa.DTO.PessoaDTO;
import br.com.Treinamento.Pessoa.DTO.PessoaFisicaDTO;
import br.com.Treinamento.Pessoa.Model.DomGenero;
import br.com.Treinamento.Pessoa.Model.Pessoa;
import br.com.Treinamento.Pessoa.Model.PessoaFisica;

public class PessoaFisicaFixture {

	private static final long ID = 1L;
	private static final String NOME = "Victor";
	private static final String NOME_FANTASIA = "Victor-LTDA";
	private static final String CIDADE = "São Paulo";
	private static final String BAIRRO = "Cohabi II";
	private static final String CEP = "08257100";
	private static final String COMPLEMENTO = "";
	private static final String LOGRADOURO = "Rua Luz do Sol";
	private static final Integer NUMERO = 115;
	private static final String UF = "SP";
	
	private static final String CPF = "259.274.115-14";
	private static final String RG = "39.755.111/8";
	private static final DomGenero GENERO = DomGenero.MASCULINO;
	private static final LocalDate NASCIMENTO = LocalDate.of(2002, 9, 27);

	private static PessoaFisica pessoaFisica;

	public static PessoaFisicaFixture criarPessoaFisica(TestInfo info) {
		pessoaFisica = new PessoaFisica();
		pessoaFisica.setIdPessoa(ID);
		pessoaFisica.setNome(NOME);
		pessoaFisica.setNomeFantasia(NOME_FANTASIA);
		pessoaFisica.setCidade(CIDADE);
		pessoaFisica.setBairro(BAIRRO);
		pessoaFisica.setCep(CEP);
		pessoaFisica.setComplemento(COMPLEMENTO);
		pessoaFisica.setLogradouro(LOGRADOURO);
		pessoaFisica.setNumero(NUMERO);
		pessoaFisica.setUf(UF);
		pessoaFisica.setCpf(CPF);
		pessoaFisica.setRg(RG);
		pessoaFisica.setGenero(GENERO);
		pessoaFisica.setNasc(NASCIMENTO);		
		
		return new PessoaFisicaFixture();
	}

	public PessoaFisicaFixture comIdPessoa(Long idPessoa) {
		pessoaFisica.setIdPessoa(idPessoa);
		return this;
	}

	public PessoaFisicaFixture comNome(String nome) {
		pessoaFisica.setNome(nome);
		return this;
	}

	public PessoaFisicaFixture comNomeFantasia(String nomeFantasia) {
		pessoaFisica.setNomeFantasia(nomeFantasia);
		return this;
	}

	public PessoaFisicaFixture comCidade(String cidade) {
		pessoaFisica.setCidade(cidade);
		return this;
	}

	public PessoaFisicaFixture comBairro(String bairro) {
		pessoaFisica.setBairro(bairro);
		return this;
	}

	public PessoaFisicaFixture comCep(String cep) {
		pessoaFisica.setCep(cep);
		return this;
	}

	public PessoaFisicaFixture comComplemento(String complemento) {
		pessoaFisica.setComplemento(complemento);
		return this;
	}

	public PessoaFisicaFixture comLogradouro(String logradouro) {
		pessoaFisica.setLogradouro(logradouro);
		return this;
	}

	public PessoaFisicaFixture comNumero(Integer numero) {
		pessoaFisica.setNumero(numero);
		return this;
	}

	public PessoaFisicaFixture comUf(String uf) {
		pessoaFisica.setUf(uf);
		return this;
	}
	
	public PessoaFisicaFixture comCpf(String cpf) {
		pessoaFisica.setCpf(cpf);
		return this;
	}
	
	public PessoaFisicaFixture comRg(String rg) {
		pessoaFisica.setRg(rg);
		return this;
	}
	
	public PessoaFisicaFixture comGenero(DomGenero genero) {
		pessoaFisica.setGenero(genero);
		return this;
	}
	
	public PessoaFisicaFixture comNascimento(LocalDate nasc) {
		pessoaFisica.setNasc(nasc);
		return this;
	}

	public PessoaFisica now() {
		return pessoaFisica;
	}
}
