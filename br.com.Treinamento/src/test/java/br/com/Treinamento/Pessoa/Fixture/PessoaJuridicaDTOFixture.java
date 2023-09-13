package br.com.Treinamento.Pessoa.Fixture;

import java.time.LocalDate;

import br.com.Treinamento.Pessoa.DTO.PessoaJuridicaDTO;

public class PessoaJuridicaDTOFixture {

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

	private static PessoaJuridicaDTO pessoaJuridicaDTO;

	public static PessoaJuridicaDTOFixture criarPessoaJuridicaDTO() {
		pessoaJuridicaDTO = new PessoaJuridicaDTO();
		pessoaJuridicaDTO.setIdPessoa(ID);
		pessoaJuridicaDTO.setNome(NOME);
		pessoaJuridicaDTO.setNomeFantasia(NOME_FANTASIA);
		pessoaJuridicaDTO.setCidade(CIDADE);
		pessoaJuridicaDTO.setBairro(BAIRRO);
		pessoaJuridicaDTO.setCep(CEP);
		pessoaJuridicaDTO.setComplemento(COMPLEMENTO);
		pessoaJuridicaDTO.setLogradouro(LOGRADOURO);
		pessoaJuridicaDTO.setNumero(NUMERO);
		pessoaJuridicaDTO.setUf(UF);
		pessoaJuridicaDTO.setCnpj(CNPJ);
		pessoaJuridicaDTO.setInscricaoEstadual(INSCRICAO_ESTADUAL);
		pessoaJuridicaDTO.setFundacao(FUNDACAO);

		return new PessoaJuridicaDTOFixture();
	}

	public PessoaJuridicaDTOFixture comIdPessoa(Long idPessoa) {
		pessoaJuridicaDTO.setIdPessoa(idPessoa);
		return this;
	}

	public PessoaJuridicaDTOFixture comNome(String nome) {
		pessoaJuridicaDTO.setNome(nome);
		return this;
	}

	public PessoaJuridicaDTOFixture comNomeFantasia(String nomeFantasia) {
		pessoaJuridicaDTO.setNomeFantasia(nomeFantasia);
		return this;
	}

	public PessoaJuridicaDTOFixture comCidade(String cidade) {
		pessoaJuridicaDTO.setCidade(cidade);
		return this;
	}

	public PessoaJuridicaDTOFixture comBairro(String bairro) {
		pessoaJuridicaDTO.setBairro(bairro);
		return this;
	}

	public PessoaJuridicaDTOFixture comCep(String cep) {
		pessoaJuridicaDTO.setCep(cep);
		return this;
	}

	public PessoaJuridicaDTOFixture comComplemento(String complemento) {
		pessoaJuridicaDTO.setComplemento(complemento);
		return this;
	}

	public PessoaJuridicaDTOFixture comLogradouro(String logradouro) {
		pessoaJuridicaDTO.setLogradouro(logradouro);
		return this;
	}

	public PessoaJuridicaDTOFixture comNumero(Integer numero) {
		pessoaJuridicaDTO.setNumero(numero);
		return this;
	}

	public PessoaJuridicaDTOFixture comUf(String uf) {
		pessoaJuridicaDTO.setUf(uf);
		return this;
	}

	public PessoaJuridicaDTOFixture comCnpj(String cnpj) {
		pessoaJuridicaDTO.setCnpj(cnpj);
		return this;
	}

	public PessoaJuridicaDTOFixture comRg(String inscricaoEstadual) {
		pessoaJuridicaDTO.setInscricaoEstadual(inscricaoEstadual);
		return this;
	}

	public PessoaJuridicaDTOFixture comFundacao(LocalDate fundacao) {
		pessoaJuridicaDTO.setFundacao(fundacao);
		return this;
	}

	public PessoaJuridicaDTO now() {
		return pessoaJuridicaDTO;
	}
}
