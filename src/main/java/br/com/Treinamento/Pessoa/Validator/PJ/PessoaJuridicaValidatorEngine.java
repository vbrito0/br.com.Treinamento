package br.com.Treinamento.Pessoa.Validator.PJ;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Configurable;

import br.com.Treinamento.Pessoa.DTO.PessoaJuridicaDTO;
import br.com.Treinamento.Pessoa.Validator.ValidatorEngine;

@Configurable
public class PessoaJuridicaValidatorEngine extends ValidatorEngine implements ConstraintValidator<ValidaPessoaJuridica, PessoaJuridicaDTO>{

	private List<PessoaJuridicaValidator> validators = new ArrayList<>();

	@Override
    public void initialize(ValidaPessoaJuridica annotation) {
        validators.add(new PessoaJuridicaValidatorCamposObrigatorios());
    }

    @Override
    public boolean isValid(PessoaJuridicaDTO pessoaJuridicaDTO, ConstraintValidatorContext context) {
        Map<String, String> listaMensagens = new HashMap<>();

        for (PessoaJuridicaValidator validator : this.validators) {
            listaMensagens.putAll(validator.validarPessoaJuridica(pessoaJuridicaDTO, context));
        }

        for (String key : listaMensagens.keySet()) {
            addNotification(context, key, listaMensagens.get(key));
        }

        return listaMensagens.isEmpty();
    }
}
