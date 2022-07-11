package br.com.Treinamento.PessoaTest;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.Treinamento.Pessoa.Model.Pessoa;

public class GeradorDePayload {
	
	public static void main(String[] args) throws JsonProcessingException {
		final ObjectMapper objectMapper = new ObjectMapper();
		
		final Pessoa pessoa = new Pessoa();
		
		pessoa.setId(1L);
		pessoa.setNome("Victor ");
		pessoa.setIdade(19);
		pessoa.setSexo("Masculino");
		pessoa.setEstatura(1.75);
		
		System.out.println(objectMapper.writeValueAsString(pessoa));
	}

}
