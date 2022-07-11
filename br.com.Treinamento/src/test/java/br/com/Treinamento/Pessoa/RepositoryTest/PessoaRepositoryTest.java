package br.com.Treinamento.Pessoa.RepositoryTest;

import javax.transaction.Transactional;

import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import br.com.Treinamento.Pessoa.Model.Pessoa;
import br.com.Treinamento.Pessoa.Repository.PessoaRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
@EnableTransactionManagement
@Transactional
@Rollback(false)
@FixMethodOrder(MethodSorters.JVM)
public class PessoaRepositoryTest {
	
	private static final String NOME_PARA_TEST_INSERT_CONSULTA = "Victor";

    @Autowired
    private PessoaRepository pessoaRepository;

    private static Pessoa pessoa;

    @BeforeClass
    public static void init() {

        pessoa = pessoa.builder().id(null).idade(19).nome(NOME_PARA_TEST_INSERT_CONSULTA).build();

    }
    
    //CRIAÇÃO DO TESTE
    
}
