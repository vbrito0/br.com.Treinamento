package br.com.Treinamento.Pessoa.ServiceTest;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.mockito.Mockito.when;

import org.hamcrest.MatcherAssert;
import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import br.com.Treinamento.Pessoa.Model.Pessoa;
import br.com.Treinamento.Pessoa.Repository.PessoaRepository;
import br.com.Treinamento.Pessoa.Service.PessoaService;

public class PessoaServiceTest {

	@InjectMocks
    private PessoaService pessoaService;

    @Mock
    private PessoaRepository pessoaRepository;

    private static final String NOME_PARA_TEST_INSERT_CONSULTA = "Victor";

    private Pessoa pessoaParaRetornar;

    private Pessoa pessoaParaSalvar;

    @Before
    public void setup() {
        MockitoAnnotations.openMocks(this);
        pessoaParaSalvar = Pessoa.builder().id(null).idade(19).nome(NOME_PARA_TEST_INSERT_CONSULTA).build();
        pessoaParaRetornar = Pessoa.builder().id(1L).idade(19).nome(NOME_PARA_TEST_INSERT_CONSULTA).build();
    }

    @Test
    public void salvarCliente() {
        when(pessoaRepository.save(pessoaParaSalvar)).thenReturn(pessoaParaRetornar);
        Pessoa pessoaRetornado = pessoaService.salvarPessoa(pessoaParaSalvar);

        Assert.assertNotNull(pessoaRetornado);
        MatcherAssert.assertThat(pessoaRetornado.getId(), equalTo(Long.valueOf(1)));
    }
}
