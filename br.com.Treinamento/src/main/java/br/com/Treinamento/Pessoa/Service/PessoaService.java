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
		
		final Pessoa pessoaSaved = pessoaRepository.save(pessoa);
        return pessoaSaved;
	}
	
	public Pessoa alterar(final Pessoa pessoa) {
        return pessoaRepository.save(pessoa);
    }

    public Pessoa buscarPessoas(Long idPessoa) {
        return pessoaRepository.findById(idPessoa).get();
    }

    public Pessoa salvarPessoa(Pessoa pessoaSave) {
        return pessoaRepository.save(pessoaSave);
    }
}
