package br.com.Treinamento.Pessoa.Validator;

import java.util.Map;

import jakarta.validation.ConstraintValidatorContext;

import br.com.Treinamento.Pessoa.DTO.PessoaDTO;

public interface PessoaValidator {
	public Map<String, String> validarPessoa(PessoaDTO pessoaDTO, ConstraintValidatorContext context);
}
