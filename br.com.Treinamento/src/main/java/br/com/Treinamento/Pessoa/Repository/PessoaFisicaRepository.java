package br.com.Treinamento.Pessoa.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.Treinamento.Pessoa.Model.PessoaFisica;

@Repository
public interface PessoaFisicaRepository extends JpaRepository<PessoaFisica, Long>{
	
	Optional<PessoaFisica> findByCpf(String cpf);
	
	@Query("SELECT pf FROM PessoaFisica pf where pf.cpf = :cpf") 
    List<PessoaFisica> findPessoaFisicaByCPF(String cpf);
}
