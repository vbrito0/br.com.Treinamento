package br.com.Treinamento.Pessoa.Fixture;

import br.com.Treinamento.Pessoa.DTO.PessoaDTO;

public class PessoaDTOFixture {
	 private static final String NOME = "Victor";
	 private static final String NOME_FANTASIA = "Victor-LTDA";
	 private static final String CIDADE = "São Paulo";
	 private static final String BAIRRO = "Cohabi II";
	 private static final String CEP = "08257100";
	 private static final String COMPLEMENTO = "";
	 private static final String LOGRADOURO = "Rua Luz do Sol";
	 private static final Integer NUMERO = 115;
	 private static final String UF = "SP";

	private static PessoaDTO pessoaDTO;

	public static PessoaDTOFixture criarPessoaDTO() {
		pessoaDTO = PessoaDTO.builder().nome(NOME)
									   .nomeFantasia(NOME_FANTASIA)
									   .bairro(BAIRRO)
									   .cep(CEP)
									   .cidade(CIDADE)
									   .complemento(COMPLEMENTO)
									   .logradouro(LOGRADOURO)
									   .numero(NUMERO)
									   .uf(UF)
									   .build();
		return new PessoaDTOFixture();
	}

	public PessoaDTOFixture comNome(String nome) {
		pessoaDTO.setNome(nome);
		return this;
	}

	public PessoaDTOFixture comNomeFantasia(String nomeFantasia) {
		pessoaDTO.setNomeFantasia(nomeFantasia);
		return this;
	}

	public PessoaDTOFixture comCidade(String cidade) {
		pessoaDTO.setCidade(cidade);
		return this;
	}

	public PessoaDTOFixture comBairro(String bairro) {
		pessoaDTO.setBairro(bairro);
		return this;
	}

	public PessoaDTOFixture comCep(String cep) {
		pessoaDTO.setCep(cep);
		return this;
	}

	public PessoaDTOFixture comComplemento(String complemento) {
		pessoaDTO.setComplemento(complemento);
		return this;
	}

	public PessoaDTOFixture comLogradouro(String logradouro) {
		pessoaDTO.setLogradouro(logradouro);
		return this;
	}

	public PessoaDTOFixture comNumero(Integer numero) {
		pessoaDTO.setNumero(numero);
		return this;
	}

	public PessoaDTOFixture comUf(String uf) {
		pessoaDTO.setUf(uf);
		return this;
	}

	public PessoaDTO now() {
		return pessoaDTO;
	}
}
