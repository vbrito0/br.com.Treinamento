package br.com.Treinamento.Pessoa;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.Treinamento.Pessoa.Model.Pessoa;

public class GerarPayload {
	
	 private static final String NOME = "Victor";
	 private static final String CIDADE = "São Paulo";
	 private static final String BAIRRO = "Cohabi II";
	 private static final String CEP = "08257100";
	 private static final String COMPLEMENTO = "";
	 private static final String LOGRADOURO = "Rua Luz do Sol";
	 private static final Integer NUMERO = 115;
	 private static final String UF = "SP";
	
	public static void main(final String[] args) throws JsonProcessingException {
        final ObjectMapper objectMapper = new ObjectMapper();
        Pessoa pessoa = new Pessoa();
        
        pessoa.setIdPessoa(1L);
        pessoa.setNome(NOME);
        pessoa.setCidade(CIDADE);
        pessoa.setBairro(BAIRRO);
        pessoa.setCep(CEP);
        pessoa.setComplemento(COMPLEMENTO);
        pessoa.setLogradouro(LOGRADOURO);
        pessoa.setNumero(NUMERO);
        pessoa.setUf(UF);

        System.out.println(objectMapper.writeValueAsString(pessoa));
    }
}
