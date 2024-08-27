package br.com.Treinamento.Pessoa.Service;

import static br.com.Treinamento.Pessoa.Message.Menssage.ID_NÃO_ENCONTRADO;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.Treinamento.Pessoa.DTO.PessoaDTO;
import br.com.Treinamento.Pessoa.Exception.NotFoundException;
import br.com.Treinamento.Pessoa.Model.Pessoa;
import br.com.Treinamento.Pessoa.Repository.PessoaRepository;

@Service
public class PessoaService {

	@Autowired
	private PessoaRepository pessoaRepository;

	public Pessoa cadastrar(PessoaDTO pessoaDTO) {
		Pessoa pessoa = PessoaDTO.fromPessoaDTO(pessoaDTO);
		return pessoaRepository.save(pessoa);
	}

	public List<Pessoa> buscarPessoaList() {
		return pessoaRepository.findAll();
	}

	public PessoaDTO buscarPessoa(Long idPessoa) {
		Pessoa pessoa = pessoaRepository.findById(idPessoa).get();
		PessoaDTO dto = new PessoaDTO(pessoa);
		return dto;
	}

	public Pessoa alterar(PessoaDTO pessoaDTO, Long idPessoa) {
		Pessoa pessoa = pessoaRepository.findById(idPessoa).orElseThrow(() -> new NotFoundException(ID_NÃO_ENCONTRADO));

		if(Objects.nonNull(pessoaDTO.getNome())) {
			pessoa.setNome(pessoaDTO.getNome());
		}
		else if(Objects.nonNull(pessoaDTO.getNomeFantasia())) {
			pessoa.setNomeFantasia(pessoaDTO.getNomeFantasia());
		}
		else if(Objects.nonNull(pessoaDTO.getBairro())) {
			pessoa.setBairro(pessoaDTO.getBairro());
		}
		else if(Objects.nonNull(pessoaDTO.getCep())) {
			pessoa.setCep(pessoaDTO.getCep());
		}
		else if(Objects.nonNull(pessoaDTO.getCidade())) {
			pessoa.setCidade(pessoaDTO.getCidade());
		}
		else if(Objects.nonNull(pessoaDTO.getComplemento())) {
			pessoa.setComplemento(pessoaDTO.getComplemento());
		}
		else if(Objects.nonNull(pessoaDTO.getLogradouro())) {
			pessoa.setLogradouro(pessoaDTO.getLogradouro());
		}
		else if(Objects.nonNull(pessoaDTO.getNumero())) {
			pessoa.setNumero(pessoaDTO.getNumero());
		}
		else if(Objects.nonNull(pessoaDTO.getUf())) {
			pessoa.setUf(pessoaDTO.getUf());
		}
		return pessoaRepository.save(pessoa);
	}
}
