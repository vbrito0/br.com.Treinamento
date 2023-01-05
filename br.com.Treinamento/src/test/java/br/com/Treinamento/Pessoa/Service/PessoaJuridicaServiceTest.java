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

import br.com.Treinamento.Pessoa.DTO.PessoaJuridicaDTO;
import br.com.Treinamento.Pessoa.Fixture.PessoaFixture;
import br.com.Treinamento.Pessoa.Fixture.PessoaJuridicaDTOFixture;
import br.com.Treinamento.Pessoa.Fixture.PessoaJuridicaFixture;
import br.com.Treinamento.Pessoa.Model.Pessoa;
import br.com.Treinamento.Pessoa.Model.PessoaJuridica;
import br.com.Treinamento.Pessoa.Repository.PessoaJuridicaRepository;
import br.com.Treinamento.Pessoa.Repository.PessoaRepository;

public class PessoaJuridicaServiceTest {
	
	@InjectMocks
	private PessoaService pessoaService;
	
	@Mock
	private PessoaRepository pessoaRepository;
	
	@Mock
	private PessoaJuridicaRepository pessoaJuridicaRepository;
	
	private TestInfo info;
	
	private List<PessoaJuridica> pessoaJuridicaParaRetornar;
	    
	    @BeforeEach
	    public void setUp(TestInfo info) {
	    	this.info = info;
	        MockitoAnnotations.openMocks(this);
	    }
	    
	    @Test
	    public void adicionarPessoaJuridicaComSucesso() {
	    	Pessoa pessoa = PessoaFixture.criarPessoa(info).now();
	    	PessoaJuridica pessoaJuridica = PessoaJuridicaFixture.criarPessoaJuridica(info).now();
	    	PessoaJuridicaDTO pessoaJuridicaDTO = PessoaJuridicaDTOFixture.criarPessoaJuridicaDTO().now();
	    	when(pessoaRepository.save(Mockito.any(Pessoa.class))).thenReturn(pessoa);
	        when(pessoaJuridicaRepository.save(Mockito.any(PessoaJuridica.class))).thenReturn(pessoaJuridica);
	        pessoaJuridicaParaRetornar = pessoaService.adicionarPessoaJuridica(pessoa.getIdPessoa(), pessoaJuridicaDTO);
	        assertTrue(Objects.nonNull(pessoaJuridicaParaRetornar));
	        assertTrue(true);
	    }
}
