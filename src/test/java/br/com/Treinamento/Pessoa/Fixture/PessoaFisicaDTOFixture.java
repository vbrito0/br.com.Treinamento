package br.com.Treinamento.Pessoa.Fixture;

import java.time.LocalDate;

import br.com.Treinamento.Pessoa.DTO.PessoaFisicaDTO;
import br.com.Treinamento.Pessoa.Model.DomGenero;

public class PessoaFisicaDTOFixture {

	private static final DomGenero GENERO = DomGenero.MASCULINO;
	private static final LocalDate NASCIMENTO = LocalDate.of(2002, 9, 27);
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

	private static PessoaFisicaDTO pessoaFisicaDTO;

	public static PessoaFisicaDTOFixture criarPessoaFisicaDTO() {
		pessoaFisicaDTO = new PessoaFisicaDTO();
		pessoaFisicaDTO.setNome(NOME);
		pessoaFisicaDTO.setNomeFantasia(NOME_FANTASIA);
		pessoaFisicaDTO.setCidade(CIDADE);
		pessoaFisicaDTO.setBairro(BAIRRO);
		pessoaFisicaDTO.setCep(CEP);
		pessoaFisicaDTO.setComplemento(COMPLEMENTO);
		pessoaFisicaDTO.setLogradouro(LOGRADOURO);
		pessoaFisicaDTO.setNumero(NUMERO);
		pessoaFisicaDTO.setUf(UF);
		pessoaFisicaDTO.setCpf(CPF);
		pessoaFisicaDTO.setRg(RG);
		pessoaFisicaDTO.setGenero(GENERO);
		pessoaFisicaDTO.setNasc(NASCIMENTO);

		return new PessoaFisicaDTOFixture();
	}

	public PessoaFisicaDTOFixture comNome(String nome) {
		pessoaFisicaDTO.setNome(nome);
		return this;
	}

	public PessoaFisicaDTOFixture comNomeFantasia(String nomeFantasia) {
		pessoaFisicaDTO.setNomeFantasia(nomeFantasia);
		return this;
	}

	public PessoaFisicaDTOFixture comCidade(String cidade) {
		pessoaFisicaDTO.setCidade(cidade);
		return this;
	}

	public PessoaFisicaDTOFixture comBairro(String bairro) {
		pessoaFisicaDTO.setBairro(bairro);
		return this;
	}

	public PessoaFisicaDTOFixture comCep(String cep) {
		pessoaFisicaDTO.setCep(cep);
		return this;
	}

	public PessoaFisicaDTOFixture comComplemento(String complemento) {
		pessoaFisicaDTO.setComplemento(complemento);
		return this;
	}

	public PessoaFisicaDTOFixture comLogradouro(String logradouro) {
		pessoaFisicaDTO.setLogradouro(logradouro);
		return this;
	}

	public PessoaFisicaDTOFixture comNumero(Integer numero) {
		pessoaFisicaDTO.setNumero(numero);
		return this;
	}

	public PessoaFisicaDTOFixture comUf(String uf) {
		pessoaFisicaDTO.setUf(uf);
		return this;
	}

	public PessoaFisicaDTOFixture comCpf(String cpf) {
		pessoaFisicaDTO.setCpf(cpf);
		return this;
	}

	public PessoaFisicaDTOFixture comRg(String rg) {
		pessoaFisicaDTO.setRg(rg);
		return this;
	}

	public PessoaFisicaDTOFixture comGenero(DomGenero genero) {
		pessoaFisicaDTO.setGenero(genero);
		return this;
	}

	public PessoaFisicaDTOFixture comNascimento(LocalDate nasc) {
		pessoaFisicaDTO.setNasc(nasc);
		return this;
	}

	public PessoaFisicaDTO now() {
		return pessoaFisicaDTO;
	}
}
