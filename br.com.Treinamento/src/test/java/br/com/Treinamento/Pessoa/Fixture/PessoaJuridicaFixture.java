package br.com.Treinamento.Pessoa.Fixture;

import java.time.LocalDate;

import org.junit.jupiter.api.TestInfo;

import br.com.Treinamento.Pessoa.Model.PessoaJuridica;

public class PessoaJuridicaFixture {
	
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
	
	private static final String CNPJ = "99.999.999/9999-99";
	private static final String INSCRICAO_ESTADUAL = "02.232.3355-6";
	private static final LocalDate FUNDACAO = LocalDate.of(2021, 01, 01);

	private static PessoaJuridica pessoaJuridica;

	public static PessoaJuridicaFixture criarPessoaJuridica(TestInfo info) {
		pessoaJuridica = new PessoaJuridica();
		pessoaJuridica.setIdPessoa(ID);
		pessoaJuridica.setNome(NOME);
		pessoaJuridica.setNomeFantasia(NOME_FANTASIA);
		pessoaJuridica.setCidade(CIDADE);
		pessoaJuridica.setBairro(BAIRRO);
		pessoaJuridica.setCep(CEP);
		pessoaJuridica.setComplemento(COMPLEMENTO);
		pessoaJuridica.setLogradouro(LOGRADOURO);
		pessoaJuridica.setNumero(NUMERO);
		pessoaJuridica.setUf(UF);
		pessoaJuridica.setCnpj(CNPJ);
		pessoaJuridica.setInscricaoEstadual(INSCRICAO_ESTADUAL);
		pessoaJuridica.setFundacao(FUNDACAO);
		
		return new PessoaJuridicaFixture();
	}

	public PessoaJuridicaFixture comIdPessoa(Long idPessoa) {
		pessoaJuridica.setIdPessoa(idPessoa);
		return this;
	}

	public PessoaJuridicaFixture comNome(String nome) {
		pessoaJuridica.setNome(nome);
		return this;
	}

	public PessoaJuridicaFixture comNomeFantasia(String nomeFantasia) {
		pessoaJuridica.setNomeFantasia(nomeFantasia);
		return this;
	}

	public PessoaJuridicaFixture comCidade(String cidade) {
		pessoaJuridica.setCidade(cidade);
		return this;
	}

	public PessoaJuridicaFixture comBairro(String bairro) {
		pessoaJuridica.setBairro(bairro);
		return this;
	}

	public PessoaJuridicaFixture comCep(String cep) {
		pessoaJuridica.setCep(cep);
		return this;
	}

	public PessoaJuridicaFixture comComplemento(String complemento) {
		pessoaJuridica.setComplemento(complemento);
		return this;
	}

	public PessoaJuridicaFixture comLogradouro(String logradouro) {
		pessoaJuridica.setLogradouro(logradouro);
		return this;
	}

	public PessoaJuridicaFixture comNumero(Integer numero) {
		pessoaJuridica.setNumero(numero);
		return this;
	}

	public PessoaJuridicaFixture comUf(String uf) {
		pessoaJuridica.setUf(uf);
		return this;
	}
	
	public PessoaJuridicaFixture comCnpj(String cnpj) {
		pessoaJuridica.setCnpj(cnpj);
		return this;
	}
	
	public PessoaJuridicaFixture comRg(String inscricaoEstadual) {
		pessoaJuridica.setInscricaoEstadual(inscricaoEstadual);
		return this;
	}
	
	public PessoaJuridicaFixture comFundacao(LocalDate fundacao) {
		pessoaJuridica.setFundacao(fundacao);
		return this;
	}

	public PessoaJuridica now() {
		return pessoaJuridica;
	}
}
