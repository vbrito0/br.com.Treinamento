package br.com.Treinamento.Pessoa.Validator.PJ;

import java.util.Map;

import javax.validation.ConstraintValidatorContext;

import br.com.Treinamento.Pessoa.DTO.PessoaJuridicaDTO;

public interface PessoaJuridicaValidator {

	public Map<String, String> validarPessoaJuridica(PessoaJuridicaDTO pessoaJuridicaDTO, ConstraintValidatorContext context);
}
