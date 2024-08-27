package br.com.Treinamento.Pessoa.Validator.PF;

import java.util.Map;
import java.util.Objects;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import br.com.Treinamento.Pessoa.DTO.PessoaFisicaDTO;

public class ValidatorBase {

	private static final Logger logger = LoggerFactory.getLogger(ValidatorBase.class);

	public void validaPessoaFisica(PessoaFisicaDTO dto, Map<String, String> mensagens) {
		if(Objects.isNull(dto)) {
			logger.info("ValidarBase::validaPessoaFisica:: Pessoa Fisica em Branco");
			mensagens.put(MensagensPessoaFisica.getMensagemCampoObrigatorio("Pessoa Fisica"), "Pessoa Fisica");
		} else {
			logger.info("ValidarBase::validaPessoaFisica:: Pessoa Fisica Cadastrada");
		}
	}
}
