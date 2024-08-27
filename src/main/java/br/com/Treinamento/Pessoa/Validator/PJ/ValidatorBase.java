package br.com.Treinamento.Pessoa.Validator.PJ;

import java.util.Map;
import java.util.Objects;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import br.com.Treinamento.Pessoa.DTO.PessoaJuridicaDTO;

public class ValidatorBase {

	private static final Logger logger = LoggerFactory.getLogger(ValidatorBase.class);

	public void validaPessoaJuridica(PessoaJuridicaDTO dto, Map<String, String> mensagens) {
		if(Objects.isNull(dto)) {
			logger.info("ValidarBase::validaPessoaJuridica:: Pessoa Juridica em Branco");
			mensagens.put(MensagensPessoaJuridica.getMensagemCampoObrigatorio("Pessoa Juridica"), "Pessoa Juridica");
		} else {
			logger.info("ValidarBase::validaPessoaJuridica:: Pessoa Juridica Cadastrada");
		}
	}
}
