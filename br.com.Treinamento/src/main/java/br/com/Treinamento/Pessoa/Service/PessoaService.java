package br.com.Treinamento.Pessoa.Service;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.Treinamento.Pessoa.Model.Pessoa;
import br.com.Treinamento.Pessoa.Repository.PessoaRepository;

@Service
public class PessoaService {
	
	//EXPORTANDO E INSTANCIANDO UMA CLASSE DO REPOSITORY 
	@Autowired
	private PessoaRepository pessoaRepository;
	
	public List<Pessoa> buscarPessoas(){
		return pessoaRepository.findAll();
	}
	
	//CRIAÇÃO PESSOAS E SUAS VALIDAÇÕES
	
	public Pessoa criarPessoa(final Pessoa pessoa) {
		
		validarSeMaiorIdade(pessoa);
		validarSeMenorIdade(pessoa);
		
		final Pessoa pessoaSaved = pessoaRepository.save(pessoa);
        return pessoaSaved;
	}
	
	private void validarSeMaiorIdade(final Pessoa pessoa) {
        if (Objects.nonNull(pessoa) && pessoa.getIdade() >= 18) {
            throw new IllegalArgumentException("Você é maior de idade");
        }
    }
	
	private void validarSeMenorIdade(final Pessoa pessoa) {
        if (Objects.nonNull(pessoa) && pessoa.getIdade() < 18) {
            throw new IllegalArgumentException("Você não é maior de idade ainda");
        }
    }
	
	public Pessoa alterar(final Pessoa pessoa) {
        return pessoaRepository.save(pessoa);
    }

    public Pessoa buscarPessoas(Long id) {
        return pessoaRepository.findById(id).get();
    }

    public Pessoa salvarPessoa(Pessoa pessoaSave) {
        return pessoaRepository.save(pessoaSave);
    }
}
