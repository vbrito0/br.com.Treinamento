package br.com.Treinamento.Pessoa.Validator.PJ;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import javax.validation.ConstraintValidatorContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import br.com.Treinamento.Pessoa.DTO.PessoaJuridicaDTO;

public class PessoaJuridicaValidatorCamposObrigatorios extends PessoaJuridicaValidatorBase {

	private static final Logger logger = LoggerFactory.getLogger(PessoaJuridicaValidatorCamposObrigatorios.class);

	@Override
	public Map<String, String> validarPessoaJuridica(PessoaJuridicaDTO pessoaJuridicaDTO, ConstraintValidatorContext context) {
		Map<String, String> mensagens = new HashMap<>();
		logger.info("Começando a validação dos campos obrigatorios de pessoa juridica");
		validarCamposObrigatorios(pessoaJuridicaDTO, mensagens);
		logger.info("Campos obrigatorios de pessoa juridica validado" + mensagens);

		return mensagens;
	}

	private void validarCamposObrigatorios(PessoaJuridicaDTO pessoaJuridicaDTO, Map<String, String> mensagens) {
		logger.info("Validação dos campos obrigatorios");
		validarCnpj(pessoaJuridicaDTO, mensagens);
	}

	private void validarCnpj(PessoaJuridicaDTO pessoaJuridicaDTO, Map<String, String> mensagens) {
		logger.info("Validando Cpnj");
		if(Objects.isNull(pessoaJuridicaDTO.getCnpj())) {
			logger.info("O campo de cnpj não pode ser nulo");
			mensagens.put(MensagensPessoaJuridica.getMensagemCnpj("Cnpj - "), "Cnpj - ");
		}
		
	}
}
