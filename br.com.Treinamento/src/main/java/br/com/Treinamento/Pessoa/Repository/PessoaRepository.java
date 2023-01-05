package br.com.Treinamento.Pessoa.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.Treinamento.Pessoa.Model.Pessoa;

@Repository
//IMPORTANDO O JPA E O MODELO PESSOA -- RESPONSAVEL POR INTERAGIR COM O DB
public interface PessoaRepository extends JpaRepository<Pessoa, Long>{
	
	List<Pessoa> findByNome(String nome);
	
	List<Pessoa> findByIdPessoa(Long idPessoa);
}
