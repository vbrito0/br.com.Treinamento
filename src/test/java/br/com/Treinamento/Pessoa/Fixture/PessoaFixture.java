package br.com.Treinamento.Pessoa.Fixture;

import org.junit.jupiter.api.TestInfo;

import br.com.Treinamento.Pessoa.Model.Pessoa;

public class PessoaFixture {
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

	 private static Pessoa pessoa;

		public static PessoaFixture criarPessoa(TestInfo info) {
			pessoa = Pessoa.builder().idPessoa(ID)
									 .nome(NOME)
									 .nomeFantasia(NOME_FANTASIA)
									 .bairro(BAIRRO)
									 .cep(CEP)
									 .cidade(CIDADE)
									 .complemento(COMPLEMENTO)
									 .logradouro(LOGRADOURO)
									 .numero(NUMERO)
									 .uf(UF)
									 .build();

			return new PessoaFixture();
		}

		public PessoaFixture comIdPessoa(Long idPessoa) {
			pessoa.setIdPessoa(idPessoa);
			return this;
		}

		public PessoaFixture comNome(String nome) {
			pessoa.setNome(nome);
			return this;
		}

		public PessoaFixture comNomeFantasia(String nomeFantasia) {
			pessoa.setNomeFantasia(nomeFantasia);
			return this;
		}

		public PessoaFixture comCidade(String cidade) {
			pessoa.setCidade(cidade);
			return this;
		}

		public PessoaFixture comBairro(String bairro) {
			pessoa.setBairro(bairro);
			return this;
		}

		public PessoaFixture comCep(String cep) {
			pessoa.setCep(cep);
			return this;
		}

		public PessoaFixture comComplemento(String complemento) {
			pessoa.setComplemento(complemento);
			return this;
		}

		public PessoaFixture comLogradouro(String logradouro) {
			pessoa.setLogradouro(logradouro);
			return this;
		}

		public PessoaFixture comNumero(Integer numero) {
			pessoa.setNumero(numero);
			return this;
		}

		public PessoaFixture comUf(String uf) {
			pessoa.setUf(uf);
			return this;
		}

		public Pessoa now() {
			return pessoa;
		}

}
