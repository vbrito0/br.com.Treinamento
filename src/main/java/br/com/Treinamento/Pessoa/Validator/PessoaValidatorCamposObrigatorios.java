package br.com.Treinamento.Pessoa.Validator;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import jakarta.validation.ConstraintValidatorContext;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import br.com.Treinamento.Pessoa.DTO.PessoaDTO;

public class PessoaValidatorCamposObrigatorios extends PessoaValidatorBase {
	private static final Logger logger = LoggerFactory.getLogger(PessoaValidatorCamposObrigatorios.class);

	@Override
	public Map<String, String> validarPessoa(PessoaDTO pessoaDTO, ConstraintValidatorContext context) {
		Map<String, String> mensagens = new HashMap<>();
		logger.info("Começando a validação dos campos obrigatorios de pessoa");
		validarCamposObrigatorios(pessoaDTO, mensagens);
		logger.info("Campos obrigatorios de pessoa validado" + mensagens);

		return mensagens;
	}

	private void validarCamposObrigatorios(PessoaDTO pessoaDTO, Map<String, String> mensagens) {
		logger.info("Validação dos campos obrigatorios");
		validarNome(pessoaDTO, mensagens);
		validarNomeFantasia(pessoaDTO, mensagens);
		validarLogradouro(pessoaDTO, mensagens);
		validarBairro(pessoaDTO, mensagens);
		validarCidade(pessoaDTO, mensagens);
		validarCep(pessoaDTO, mensagens);
		validarUf(pessoaDTO, mensagens);
		validarNumero(pessoaDTO, mensagens);

	}
	private void validarNome(PessoaDTO pessoaDTO, Map<String, String> mensagens) {
		logger.info("Validando Nome da pessoa");
		if(StringUtils.isEmpty(pessoaDTO.getNome()) || StringUtils.isBlank(pessoaDTO.getNome())) {
			logger.info("O campo de nome não pode ser branco ou estar vazio");
			mensagens.put(MensagensPessoa.getMensagemCampoNome("Nome - "), "Nome - ");
		}
	}
	private void validarNomeFantasia(PessoaDTO pessoaDTO, Map<String, String> mensagens) {
		logger.info("Validando Nome Fantasia");
		if(StringUtils.isEmpty(pessoaDTO.getNomeFantasia()) || StringUtils.isBlank(pessoaDTO.getNomeFantasia())) {
			logger.info("O campo de nome fantasia não pode ser vazio ou branco");
			mensagens.put(MensagensPessoa.getMensagemCampoNomeFantasia("Nome Fantasia - "), "Nome Fantasia - ");
		}
	}
	private void validarLogradouro(PessoaDTO pessoaDTO, Map<String, String> mensagens) {
		logger.info("Validando o Logradouro");
		if(StringUtils.isEmpty(pessoaDTO.getLogradouro()) || StringUtils.isBlank(pessoaDTO.getLogradouro())) {
			logger.info("O campo do logradouro não pode ser vazio ou estar em branco");
			mensagens.put(MensagensPessoa.getMensagemCampoLogradouro("Logradouro - "), "logradouro - ");
		}
	}
	private void validarBairro(PessoaDTO pessoaDTO, Map<String, String> mensagens) {
		logger.info("Validando o Bairro");
		if(StringUtils.isEmpty(pessoaDTO.getBairro()) || StringUtils.isBlank(pessoaDTO.getBairro())) {
			logger.info("O campo do bairro não pode ser vazio ou estar em branco");
			mensagens.put(MensagensPessoa.getMensagemCampoBairro("Bairro - "), "Bairro - ");
		}
	}
	private void validarCidade(PessoaDTO pessoaDTO, Map<String, String> mensagens) {
		logger.info("Validando a Cidade");
		if(StringUtils.isEmpty(pessoaDTO.getCidade()) || StringUtils.isBlank(pessoaDTO.getCidade())) {
			logger.info("O campo da cidade não pode ser vazio ou estar em branco");
			mensagens.put(MensagensPessoa.getMensagemCampoCidade("Cidade - "), "Cidade - ");
		}
	}
	private void validarCep(PessoaDTO pessoaDTO, Map<String, String> mensagens) {
		logger.info("Validando o CEP");
		if(StringUtils.isEmpty(pessoaDTO.getCep()) || StringUtils.isBlank(pessoaDTO.getCep())) {
			logger.info("O campo do cep não pode ser vazio ou estar em branco");
			mensagens.put(MensagensPessoa.getMensagemCampoCep("CEP - "), "CEP - ");
		}
	}
	private void validarUf(PessoaDTO pessoaDTO, Map<String, String> mensagens) {
		logger.info("Validando a UF");
		if(StringUtils.isEmpty(pessoaDTO.getUf()) || StringUtils.isBlank(pessoaDTO.getUf())) {
			logger.info("O campo da uf não pode ser vazio ou estar em branco");
			mensagens.put(MensagensPessoa.getMensagemCampoUf("UF - "), "UF - ");
		}
	}
	private void validarNumero(PessoaDTO pessoaDTO, Map<String, String> mensagens) {
		logger.info("Validando o Numero");
		if(Objects.isNull(pessoaDTO.getNumero())) {
			logger.info("O campo do numero não pode ser nulo");
			mensagens.put(MensagensPessoa.getMensagemCampoNumero("Numero - "), "Numero - ");
		}
	}
}
