package br.com.Treinamento.Pessoa.Validator.PF;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import jakarta.validation.ConstraintValidatorContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import br.com.Treinamento.Pessoa.DTO.PessoaFisicaDTO;

public class PessoaFisicaValidatorCamposObrigatorios extends PessoaFisicaValidatorBase {

	private static final Logger logger = LoggerFactory.getLogger(PessoaFisicaValidatorCamposObrigatorios.class);

	@Override
	public Map<String, String> validarPessoaFisica(PessoaFisicaDTO pessoaFisicaDTO, ConstraintValidatorContext context) {
		Map<String, String> mensagens = new HashMap<>();
		logger.info("Começando a validação dos campos obrigatorios de pessoa fisica");
		validarCamposObrigatorios(pessoaFisicaDTO, mensagens);
		logger.info("Campos obrigatorios de pessoa fisica validado" + mensagens);

		return mensagens;
	}

	private void validarCamposObrigatorios(PessoaFisicaDTO pessoaFisicaDTO, Map<String, String> mensagens) {
		logger.info("Validação dos campos obrigatorios");
		validarCpf(pessoaFisicaDTO, mensagens);
		validarRg(pessoaFisicaDTO, mensagens);
		validarNasc(pessoaFisicaDTO, mensagens);

	}

	private void validarNasc(PessoaFisicaDTO pessoaFisicaDTO, Map<String, String> mensagens) {
		logger.info("Validando Data de Nascimento");
		if(Objects.isNull(pessoaFisicaDTO.getNasc())) {
			logger.info("O campo de nascimento não pode ser nulo");
			mensagens.put(MensagensPessoaFisica.getMensagemNascimento("Nascimento - "), "Nascimento - ");
		}
	}

	private void validarRg(PessoaFisicaDTO pessoaFisicaDTO, Map<String, String> mensagens) {
		logger.info("Validando RG");
		if(Objects.isNull(pessoaFisicaDTO.getRg())) {
			logger.info("O RG é um campo obrigatorio e não pode ser nulo");
			mensagens.put(MensagensPessoaFisica.getMensagemRg("RG - "), "RG - ");
		}
	}

	private void validarCpf(PessoaFisicaDTO pessoaFisicaDTO, Map<String, String> mensagens) {
		logger.info("Validando CPF");
		if(Objects.isNull(pessoaFisicaDTO.getCpf())) {
			logger.info("O CPF é um campo obrigatorio e não pode ser nulo");
			mensagens.put(MensagensPessoaFisica.getMensagemCampoObrigatorio("CPF - "), "CPF - ");
		}
	}


}
