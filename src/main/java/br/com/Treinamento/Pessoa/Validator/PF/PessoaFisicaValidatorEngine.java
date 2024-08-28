package br.com.Treinamento.Pessoa.Validator.PF;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Configurable;

import br.com.Treinamento.Pessoa.DTO.PessoaFisicaDTO;
import br.com.Treinamento.Pessoa.Validator.ValidatorEngine;

@Configurable
public class PessoaFisicaValidatorEngine extends ValidatorEngine implements ConstraintValidator<ValidaPessoaFisica, PessoaFisicaDTO>{

	private List<PessoaFisicaValidator> validators = new ArrayList<>();

	@Override
    public void initialize(ValidaPessoaFisica annotation) {
        validators.add(new PessoaFisicaValidatorCamposObrigatorios());
    }

    @Override
    public boolean isValid(PessoaFisicaDTO pessoaFisicaDTO, ConstraintValidatorContext context) {
        Map<String, String> listaMensagens = new HashMap<>();

        for (PessoaFisicaValidator validator : this.validators) {
            listaMensagens.putAll(validator.validarPessoaFisica(pessoaFisicaDTO, context));
        }

        for (String key : listaMensagens.keySet()) {
            addNotification(context, key, listaMensagens.get(key));
        }

        return listaMensagens.isEmpty();
    }
}
