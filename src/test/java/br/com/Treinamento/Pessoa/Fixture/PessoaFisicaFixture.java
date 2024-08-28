package br.com.Treinamento.Pessoa.Fixture;

import java.time.LocalDate;

import br.com.Treinamento.Pessoa.Model.DomGenero;
import br.com.Treinamento.Pessoa.Model.PessoaFisica;

public class PessoaFisicaFixture {

    private static final Long ID = 1L;
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

    private PessoaFisica pessoaFisica;

    public static PessoaFisicaFixture criarPessoaFisica() {
        PessoaFisicaFixture fixture = new PessoaFisicaFixture();
        fixture.pessoaFisica = new PessoaFisica();
        fixture.pessoaFisica.setIdPessoa(ID);
        fixture.pessoaFisica.setNome(NOME);
        fixture.pessoaFisica.setNomeFantasia(NOME_FANTASIA);
        fixture.pessoaFisica.setCidade(CIDADE);
        fixture.pessoaFisica.setBairro(BAIRRO);
        fixture.pessoaFisica.setCep(CEP);
        fixture.pessoaFisica.setComplemento(COMPLEMENTO);
        fixture.pessoaFisica.setLogradouro(LOGRADOURO);
        fixture.pessoaFisica.setNumero(NUMERO);
        fixture.pessoaFisica.setUf(UF);
        fixture.pessoaFisica.setCpf(CPF);
        fixture.pessoaFisica.setRg(RG);
        fixture.pessoaFisica.setGenero(GENERO);
        fixture.pessoaFisica.setNasc(NASCIMENTO);
        return fixture;
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