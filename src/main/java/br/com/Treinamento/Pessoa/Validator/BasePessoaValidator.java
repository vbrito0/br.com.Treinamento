package br.com.Treinamento.Pessoa.Validator;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import jakarta.validation.ConstraintValidatorContext;

import com.google.common.base.Strings;

import br.com.Treinamento.Pessoa.DTO.PessoaDTO;

public class BasePessoaValidator extends PessoaValidatorBase{

	@Override
    public Map<String, String> validarPessoa(PessoaDTO pessoaDTO, ConstraintValidatorContext context) {
        Map<String, String> mensagens = new HashMap<>();
        validaDadosObrigatorios(pessoaDTO, mensagens);

        return mensagens;
    }

	private void validaDadosObrigatorios(PessoaDTO pessoaDTO, Map<String, String> mensagens) {
		if(Strings.isNullOrEmpty(pessoaDTO.getNome())) {
			mensagens.put(MensagensPessoa.getMensagemCampoNome("Nome"), "Pessoa");
		}
		if(Strings.isNullOrEmpty(pessoaDTO.getNomeFantasia())) {
			mensagens.put(MensagensPessoa.getMensagemCampoNomeFantasia("Nome Fantasia"), "Pessoa");
		}
		if(Strings.isNullOrEmpty(pessoaDTO.getLogradouro())) {
			mensagens.put(MensagensPessoa.getMensagemCampoLogradouro("Logradouro"), "Pessoa");
		}
		if(Strings.isNullOrEmpty(pessoaDTO.getBairro())) {
			mensagens.put(MensagensPessoa.getMensagemCampoBairro("Bairro"), "Pessoa");
		}
		if(Strings.isNullOrEmpty(pessoaDTO.getCidade())) {
			mensagens.put(MensagensPessoa.getMensagemCampoCidade("Cidade"), "Pessoa");
		}
		if(Strings.isNullOrEmpty(pessoaDTO.getCep())) {
			mensagens.put(MensagensPessoa.getMensagemCampoCep("Cep"), "Pessoa");
		}
		if(Strings.isNullOrEmpty(pessoaDTO.getUf())) {
			mensagens.put(MensagensPessoa.getMensagemCampoUf("Uf"), "Pessoa");
		}
		if(Objects.isNull(pessoaDTO.getNumero())) {
			mensagens.put(MensagensPessoa.getMensagemCampoNumero("Numero"), "Pessoa");
		}
	}
}