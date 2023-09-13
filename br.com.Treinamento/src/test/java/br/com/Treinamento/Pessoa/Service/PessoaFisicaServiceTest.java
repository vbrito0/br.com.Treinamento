package br.com.Treinamento.Pessoa.Service;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.Objects;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import br.com.Treinamento.Pessoa.DTO.PessoaFisicaDTO;
import br.com.Treinamento.Pessoa.Fixture.PessoaFisicaDTOFixture;
import br.com.Treinamento.Pessoa.Fixture.PessoaFisicaFixture;
import br.com.Treinamento.Pessoa.Fixture.PessoaFixture;
import br.com.Treinamento.Pessoa.Model.Pessoa;
import br.com.Treinamento.Pessoa.Model.PessoaFisica;
import br.com.Treinamento.Pessoa.Repository.PessoaFisicaRepository;
import br.com.Treinamento.Pessoa.Repository.PessoaRepository;

public class PessoaFisicaServiceTest {

	@InjectMocks
	private PessoaService pessoaService;

	@Mock
	private PessoaRepository pessoaRepository;

	@Mock
	private PessoaFisicaRepository pessoaFisicaRepository;

	private TestInfo info;

	private List<PessoaFisica> pessoaFisicaParaRetornar;

	    @BeforeEach
	    public void setUp(TestInfo info) {
	    	this.info = info;
	        MockitoAnnotations.openMocks(this);
	    }

	    @Test
	    public void adicionarPessoaFisicaComSucesso() {
	    	Pessoa pessoa = PessoaFixture.criarPessoa(info).now();
	    	PessoaFisica pessoaFisica = PessoaFisicaFixture.criarPessoaFisica(info).now();
	    	PessoaFisicaDTO pessoaFisicaDTO = PessoaFisicaDTOFixture.criarPessoaFisicaDTO().now();
	    	when(pessoaRepository.save(Mockito.any(Pessoa.class))).thenReturn(pessoa);
	        when(pessoaFisicaRepository.save(Mockito.any(PessoaFisica.class))).thenReturn(pessoaFisica);
	        pessoaFisicaParaRetornar = pessoaService.adicionarPessoaFisica(pessoa.getIdPessoa(), pessoaFisicaDTO);
	        assertTrue(Objects.nonNull(pessoaFisicaParaRetornar));
	        assertTrue(true);
	    }
}
