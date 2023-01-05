package br.com.Treinamento.Pessoa.Validator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import br.com.Treinamento.Pessoa.DTO.PessoaDTO;
import br.com.Treinamento.Pessoa.DTO.PessoaFisicaDTO;
import br.com.Treinamento.Pessoa.DTO.ValidaPessoa;

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
