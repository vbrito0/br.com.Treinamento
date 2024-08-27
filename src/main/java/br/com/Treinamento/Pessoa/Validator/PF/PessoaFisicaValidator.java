package br.com.Treinamento.Pessoa.Validator.PF;

import java.util.Map;

import javax.validation.ConstraintValidatorContext;

import br.com.Treinamento.Pessoa.DTO.PessoaFisicaDTO;

public interface PessoaFisicaValidator {

	public Map<String, String> validarPessoaFisica(PessoaFisicaDTO pessoaFisicaDTO, ConstraintValidatorContext context);
}
