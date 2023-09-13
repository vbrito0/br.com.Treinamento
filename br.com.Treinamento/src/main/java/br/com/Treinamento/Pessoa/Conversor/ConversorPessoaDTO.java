package br.com.Treinamento.Pessoa.Conversor;

import java.util.Objects;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import br.com.Treinamento.Pessoa.DTO.PessoaDTO;
import br.com.Treinamento.Pessoa.DTO.PessoaFisicaDTO;
import br.com.Treinamento.Pessoa.Model.Pessoa;
import br.com.Treinamento.Pessoa.Model.PessoaFisica;

@Component
public class ConversorPessoaDTO {

	public void convertPessoaFisica(PessoaFisicaDTO dto, PessoaFisica pessoaFisica) {
		if(Objects.isNull(dto)) {
			return;
		}
		BeanUtils.copyProperties(dto, pessoaFisica);
		preenchePessoa(dto, pessoaFisica);
		pessoaFisica.setIdPessoa(dto.getIdPessoa());
		pessoaFisica.setNome(dto.getNome());
		pessoaFisica.setCpf(dto.getCpf());
		pessoaFisica.setRg(dto.getRg());
		pessoaFisica.setGenero(dto.getGenero());
		pessoaFisica.setNasc(dto.getNasc());
		pessoaFisica.setNomeFantasia(dto.getNomeFantasia());
		pessoaFisica.setCidade(dto.getCidade());
		pessoaFisica.setBairro(dto.getBairro());
		pessoaFisica.setCep(dto.getCep());
		pessoaFisica.setComplemento(dto.getComplemento());
		pessoaFisica.setLogradouro(dto.getLogradouro());
		pessoaFisica.setNumero(dto.getNumero());
		pessoaFisica.setUf(dto.getUf());
	}

	public PessoaFisicaDTO convertPessoaFisicaDTO (PessoaFisica pessoaFisica) {
		if (Objects.isNull(pessoaFisica)){
			return null;
		}
		PessoaFisicaDTO pessoaFisicaDTO = new PessoaFisicaDTO();
        BeanUtils.copyProperties(pessoaFisica, pessoaFisicaDTO);
        preenchePessoaDTO(pessoaFisica, pessoaFisicaDTO);
        pessoaFisicaDTO.setPessoaFisicaOriginal(pessoaFisica);
		return pessoaFisicaDTO;
	}

	private void preenchePessoaDTO(PessoaFisica pessoaFisica, PessoaFisicaDTO pessoaFisicaDTO) {
		pessoaFisicaDTO.setIdPessoa(pessoaFisica.getIdPessoa());
		pessoaFisicaDTO.setCpf(pessoaFisica.getCpf());
		pessoaFisicaDTO.setGenero(pessoaFisica.getGenero());
		pessoaFisicaDTO.setRg(pessoaFisica.getRg());
	}

	private void preenchePessoa(PessoaDTO pessoaDTO, Pessoa pessoa) {
		pessoa.setNome(pessoaDTO.getNome());
		pessoa.setNomeFantasia(pessoaDTO.getNomeFantasia());
		pessoa.setCidade(pessoaDTO.getCidade());
		pessoa.setBairro(pessoaDTO.getBairro());
		pessoa.setCep(pessoaDTO.getCep());
		pessoa.setComplemento(pessoaDTO.getComplemento());
		pessoa.setLogradouro(pessoaDTO.getLogradouro());
		pessoa.setNumero(pessoaDTO.getNumero());
		pessoa.setUf(pessoaDTO.getUf());
	}
}
