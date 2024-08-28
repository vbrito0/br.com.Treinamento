package br.com.Treinamento.Pessoa.Validator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import br.com.Treinamento.Pessoa.DTO.PessoaDTO;

public class PessoaValidatorEngine extends ValidatorEngine implements ConstraintValidator<ValidaPessoa, PessoaDTO> {
	private List<PessoaValidator> validators = new ArrayList<>();

	@Override
	public void initialize(ValidaPessoa annotation) {
		validators.add(new PessoaValidatorCamposObrigatorios());
	}

	@Override
	public boolean isValid(PessoaDTO pessoaDTO, ConstraintValidatorContext context) {
		Map<String, String> listaMensagens = new HashMap<>();

		for (PessoaValidator validator : this.validators) {
			listaMensagens.putAll(validator.validarPessoa(pessoaDTO, context));
		}

		for (String key : listaMensagens.keySet()) {
			addNotification(context, key, listaMensagens.get(key));
		}

		return listaMensagens.isEmpty();
	}
}
