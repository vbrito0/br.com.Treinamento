package br.com.Treinamento.Pessoa.Service;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

import java.util.Objects;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import br.com.Treinamento.Pessoa.DTO.PessoaDTO;
import br.com.Treinamento.Pessoa.Fixture.PessoaDTOFixture;
import br.com.Treinamento.Pessoa.Fixture.PessoaFisicaFixture;
import br.com.Treinamento.Pessoa.Fixture.PessoaFixture;
import br.com.Treinamento.Pessoa.Model.Pessoa;
import br.com.Treinamento.Pessoa.Model.PessoaFisica;
import br.com.Treinamento.Pessoa.Repository.PessoaFisicaRepository;
import br.com.Treinamento.Pessoa.Repository.PessoaRepository;

public class PessoaServiceTest {

	@InjectMocks
	private PessoaService pessoaService;

	@Mock
	private PessoaRepository pessoaRepository;
	@Mock
	private PessoaFisicaRepository pessoaFisicaRepository;

	private TestInfo info;

	    @BeforeEach
	    public void setUp(TestInfo info) {
	    	this.info = info;
	        MockitoAnnotations.openMocks(this);
	    }

	    @Test
	    public void criarPessoaComSucesso() {
	    	Pessoa pessoa = PessoaFixture.criarPessoa(info).now();
	    	PessoaDTO pessoaDTO = PessoaDTOFixture.criarPessoaDTO().now();
	        Mockito.when(pessoaRepository.save(ArgumentMatchers.any(Pessoa.class))).thenReturn(pessoa);
	        Pessoa pessoaParaRetornar = pessoaService.cadastrar(pessoaDTO);

	        assertTrue(Objects.nonNull(pessoaParaRetornar));
	        assertTrue(Objects.nonNull(pessoaParaRetornar.getIdPessoa()));
	        assertTrue(Objects.nonNull(pessoaParaRetornar.getNome()));
	        assertTrue(Objects.nonNull(pessoaParaRetornar.getNomeFantasia()));
	        assertTrue(Objects.nonNull(pessoaParaRetornar.getCidade()));
	        assertTrue(Objects.nonNull(pessoaParaRetornar.getBairro()));
	        assertTrue(Objects.nonNull(pessoaParaRetornar.getCep()));
	        assertTrue(Objects.nonNull(pessoaParaRetornar.getComplemento()));
	        assertTrue(Objects.nonNull(pessoaParaRetornar.getLogradouro()));
	        assertTrue(Objects.nonNull(pessoaParaRetornar.getNumero()));
	        assertTrue(Objects.nonNull(pessoaParaRetornar.getUf()));
	        assertThat(pessoaParaRetornar.getNome(), equalTo(pessoaDTO.getNome()));
	        assertThat(pessoaParaRetornar.getNomeFantasia(), equalTo(pessoaDTO.getNomeFantasia()));
	        assertThat(pessoaParaRetornar.getCidade(), equalTo(pessoaDTO.getCidade()));
	        assertThat(pessoaParaRetornar.getBairro(), equalTo(pessoaDTO.getBairro()));
	        assertThat(pessoaParaRetornar.getCep(), equalTo(pessoaDTO.getCep()));
	        assertThat(pessoaParaRetornar.getComplemento(), equalTo(pessoaDTO.getComplemento()));
	        assertThat(pessoaParaRetornar.getLogradouro(), equalTo(pessoaDTO.getLogradouro()));
	        assertThat(pessoaParaRetornar.getNumero(), equalTo(pessoaDTO.getNumero()));
	        assertThat(pessoaParaRetornar.getUf(), equalTo(pessoaDTO.getUf()));
	        assertTrue(true);
	    }


	    @Test
	    public void buscarPessoa() {
	    	PessoaFisica pessoaBuscar = PessoaFisicaFixture.criarPessoaFisica().now();
	        when(pessoaFisicaRepository.findByCpf(ArgumentMatchers.anyString())).thenReturn(Optional.of(pessoaBuscar));
	        
	        Pessoa resultado = pessoaService.getCpf(pessoaBuscar.getCpf());

	        assertNotNull(resultado);
	        assertThat(resultado.getIdPessoa(), equalTo(Long.valueOf(1)));
	    }
}
