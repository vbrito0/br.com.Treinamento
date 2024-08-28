package br.com.Treinamento.Pessoa.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.Treinamento.Pessoa.Model.Pessoa;
import br.com.Treinamento.Pessoa.Model.PessoaJuridica;

@Repository
public interface PessoaJuridicaRepository extends JpaRepository<PessoaJuridica, Long>{

	Optional<Pessoa> findByCnpj(String cnpjFormatado);
}
