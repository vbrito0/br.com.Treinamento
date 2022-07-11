package br.com.Treinamento.Pessoa.ControllerTest;


import static org.hamcrest.CoreMatchers.equalTo;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.openMocks;

import java.io.IOException;
import java.nio.file.Files;

import org.hamcrest.MatcherAssert;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.Treinamento.Pessoa.Controller.PessoaController;
import br.com.Treinamento.Pessoa.Model.Pessoa;
import br.com.Treinamento.Pessoa.Service.PessoaService;

@RunWith(SpringJUnit4ClassRunner.class)
@AutoConfigureMockMvc
@WebMvcTest(value = PessoaController.class)
public class PessoaControllerTest {
	
	private static final String URI_PESSOA_CONTROLLER = "/pessoa";
    private static final String URI_CRIAR_PESSOA_CONTROLLER = "/criar";
    
    @Value("classpath:json/POST_pessoa.json")
    private Resource payloadPutProcessamento;
    
    private static final String NOME_PARA_TEST_INSERT_CONSULTA = "Victor";
    
    @Autowired
    private MockMvc mockitoMvc;

    @MockBean
    private PessoaService pessoaService;

    @BeforeEach
    public void setUp() {
        openMocks(this);
    }
    
    //CRIAÇÃO DO TEST
    @Test
    public void criarPessoa() throws Exception{
    	Pessoa pessoa = Pessoa.builder().id(1L).nome(NOME_PARA_TEST_INSERT_CONSULTA).idade(19).sexo("Masculino").estatura(1.75).build();
    
    	when(pessoaService.criarPessoa(ArgumentMatchers.any(Pessoa.class))).thenReturn(pessoa);

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Accept-Charset", "UTF-8");
        httpHeaders.add("Content-Type", MediaType.APPLICATION_JSON_VALUE);

        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.post(URI_PESSOA_CONTROLLER.concat(URI_CRIAR_PESSOA_CONTROLLER)).content(readFiles(payloadPutProcessamento)).accept(MediaType.APPLICATION_JSON).headers(httpHeaders);
        MvcResult result = mockitoMvc.perform(request).andReturn();

        MockHttpServletResponse response = result.getResponse();
        ObjectMapper mapper = new ObjectMapper();
        Pessoa pessoaRetornado = mapper.readValue(response.getContentAsString(), Pessoa.class);

        MatcherAssert.assertThat(pessoaRetornado.getNome(), equalTo(NOME_PARA_TEST_INSERT_CONSULTA));
    }
    
    private String readFiles(final Resource resource) throws IOException {
        return new String(Files.readAllBytes(resource.getFile().toPath()));
    }
}
