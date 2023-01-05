package br.com.Treinamento.Pessoa.Controller;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertNotNull;
import static org.mockito.MockitoAnnotations.openMocks;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import br.com.Treinamento.Pessoa.DTO.PessoaDTO;
import br.com.Treinamento.Pessoa.Model.Pessoa;
import br.com.Treinamento.Pessoa.Service.PessoaService;

@WebMvcTest
public class PessoaControllerTest extends BaseControllerIT{

	private static final String URI_CRIAR_PESSOA_CONTROLLER = "/pessoa/criar";

	@Autowired
	PessoaController pessoaController;
	
	@Value("classpath:json/POST_pessoa.json")
	private Resource payloadPutProcessamento;

	@Mock
	private PessoaService pessoaService;

	@BeforeEach
	public void setUp() {
		openMocks(this);
	}

	@Nested
	class Sucess {

		@Test
		@DisplayName("Cadastro de pessoa")
		void criarPessoa() {
			PessoaDTO pessoaDTO = new PessoaDTO();
			Pessoa pessoaSaved = pessoaService.cadastrar(pessoaDTO);
			PessoaDTO pessoaReturn = PessoaDTO.fromPessoaDTO(pessoaSaved);
			StringBuilder url = new StringBuilder(URI_CRIAR_PESSOA_CONTROLLER);
			ResponseEntity<PessoaDTO> response = restTemplate.exchange(url.toString(), HttpMethod.POST,
					getRequestEntity(pessoaReturn), PessoaDTO.class);
			assertNotNull(response);
			assertThat(response.getStatusCode(), equalTo(HttpStatus.CREATED));

		}

	}

}
