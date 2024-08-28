package br.com.Treinamento.Pessoa.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.Treinamento.Pessoa.DTO.PessoaDTO;
import br.com.Treinamento.Pessoa.Model.Pessoa;
import br.com.Treinamento.Pessoa.Service.PessoaService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/pessoa")
public class PessoaController {

	@Autowired
	private PessoaService pessoaService;

	@PostMapping("/cadastrar")
	public ResponseEntity<Pessoa> cadastrarPessoa(@Valid @RequestBody PessoaDTO pessoaDTO) {
		Pessoa pessoaSaved = pessoaService.cadastrar(pessoaDTO);
		return ResponseEntity.status(HttpStatus.CREATED).body(pessoaSaved);
	}

	@GetMapping
    public ResponseEntity<List<Pessoa>> buscarListaPessoa() {
        return new ResponseEntity<>(pessoaService.buscarPessoaList(), HttpStatus.OK);
    }

	@GetMapping("/buscar-cpf/{cpf}")
	public ResponseEntity<Pessoa> buscarPorCpf(@PathVariable String cpf){
		Pessoa pessoaFisica = pessoaService.getCpf(cpf);
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(pessoaFisica);
	}
	
	@PutMapping("/alterar-dados-pessoa/{cpf}")
	public ResponseEntity<Pessoa> alterarPessoaFisica(@PathVariable String cpf, @RequestBody PessoaDTO pessoaDTO) {
		pessoaService.alterarPessoaFisica(cpf, pessoaDTO);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
	@GetMapping("/buscar-cnpj/{cnpj}")
	public ResponseEntity<Pessoa> buscarPorCnpj(@PathVariable String cnpj){
		Pessoa pessoaJuridica = pessoaService.getCnpj(cnpj);
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(pessoaJuridica);
	}
	
	@PutMapping("/alterar-dados-pessoa-juridica/{cnpj}")
	public ResponseEntity<Pessoa> alterarPessoaJuridica(@PathVariable String cnpj, @RequestBody PessoaDTO pessoaDTO) {
		pessoaService.alterarPessoaJuridica(cnpj, pessoaDTO);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
	@DeleteMapping("/deletar/{idPessoa}")
	public ResponseEntity<Pessoa> deletarPessoa(@PathVariable Long idPessoa) {
		pessoaService.deletar(idPessoa);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
