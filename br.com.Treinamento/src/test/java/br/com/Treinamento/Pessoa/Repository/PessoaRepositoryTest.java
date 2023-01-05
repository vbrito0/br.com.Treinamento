package br.com.Treinamento.Pessoa.Repository;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

import java.util.List;

import javax.transaction.Transactional;

import org.hamcrest.MatcherAssert;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import br.com.Treinamento.Pessoa.Model.Pessoa;

@RunWith(SpringRunner.class)
@SpringBootTest
@EnableTransactionManagement
@Transactional
@Rollback(false)
@FixMethodOrder(MethodSorters.JVM)
public class PessoaRepositoryTest {

	private static final String NOME = "Victor";
	 private static final String CIDADE = "São Paulo";
	 private static final String BAIRRO = "Cohabi II";
	 private static final String CEP = "08257100";
	 private static final String COMPLEMENTO = "";
	 private static final String LOGRADOURO = "Rua Luz do Sol";
	 private static final Integer NUMERO = 115;
	 private static final String UF = "SP";

    @Autowired
    private PessoaRepository pessoaRepository;

    private static Pessoa pessoa;

    @BeforeClass
    public static void init() {

        pessoa = Pessoa.builder().idPessoa(null)
									.nome(NOME)
									.cidade(CIDADE)
									.bairro(BAIRRO)
									.cep(CEP)
									.complemento(COMPLEMENTO)
									.logradouro(LOGRADOURO)
									.numero(NUMERO)
									.uf(UF)
									.build();

    }

    @Test
    public void insertPessoa() {
        Pessoa pessoaSaved = pessoaRepository.save(pessoa);
        MatcherAssert.assertThat(pessoaSaved.getNome(), equalTo(new String(NOME)));
    }

    @Test
    public void consultaPorNomeComSucesso() {

        List<Pessoa> pessoaList = pessoaRepository.findByNome(NOME);
        assertThat(pessoaList.size(), equalTo(Integer.valueOf(1)));
        assertThat(pessoaList.get(0).getNome(), equalTo(new String(NOME)));
    }

}
