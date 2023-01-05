package br.com.Treinamento.Pessoa.Controller;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.Treinamento.Pessoa.PessoaApplication;
import br.com.Treinamento.Pessoa.Model.Pessoa;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = { PessoaApplication.class }, webEnvironment = WebEnvironment.RANDOM_PORT)
@ContextConfiguration
@ActiveProfiles("test")
public abstract class BaseControllerIT extends AbstractControllerIT{
	
	private static final String NOME = "Victor";
	private static final String NOME_FANTASIA = "Victor";
	private static final String CIDADE = "São Paulo";
	private static final String BAIRRO = "Cohabi II";
	private static final String CEP = "08257100";
	private static final String COMPLEMENTO = "";
	private static final String LOGRADOURO = "Rua Luz do Sol";
	private static final Integer NUMERO = 115;
	private static final String UF = "SP";
	
	@Autowired
    public TestRestTemplate restTemplate;
	
	 @Test
	    public void contextLoads() {
	    }

	    protected HttpEntity<?> getRequestEntity() {
	        return new HttpEntity<>(getHeaders());
	    }

	    protected <T> HttpEntity<?> getRequestEntity(T object) {
	        return new HttpEntity<>(object, getHeaders());
	    }

	    public HttpHeaders getHeaders() {
	        HttpHeaders headers = new HttpHeaders();
	        headers.set("X-COM-PERSIST", "true");
	        headers.setContentType(MediaType.APPLICATION_JSON);
	        return headers;
	    }
	    
	    protected Pessoa buildPessoa() {
			Pessoa pessoa = new Pessoa();
			pessoa = Pessoa.builder().idPessoa(1L).nome(NOME).nomeFantasia(NOME_FANTASIA).cidade(CIDADE).bairro(BAIRRO)
					.cep(CEP).complemento(COMPLEMENTO).logradouro(LOGRADOURO).numero(NUMERO).uf(UF).build();
			return pessoa;
		}
}
