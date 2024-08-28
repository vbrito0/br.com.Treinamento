package br.com.Treinamento.Pessoa.Validator;

import jakarta.validation.ConstraintValidatorContext;

public class ValidatorEngine {

	protected void addNotification(ConstraintValidatorContext context, String mensagem, String propriedade) {
        context.buildConstraintViolationWithTemplate(mensagem).addPropertyNode(propriedade).addConstraintViolation();
    }
}
