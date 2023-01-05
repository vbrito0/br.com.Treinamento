package br.com.Treinamento.Pessoa.Exception;

import java.util.Set;
import java.util.stream.Collectors;

public class BusinessException extends RuntimeException{
	
	private static final long serialVersionUID = 1L;

    public BusinessException(String mensagem) {
        super(mensagem);
    }

    public BusinessException(Set<String> mensagens) {
        super(mensagens.stream().collect(Collectors.joining("\n")));
    }
}
