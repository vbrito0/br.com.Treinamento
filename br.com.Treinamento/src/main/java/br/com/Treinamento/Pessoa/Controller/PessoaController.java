package br.com.Treinamento.Pessoa.Controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.Treinamento.Pessoa.DTO.PessoaDTO;
import br.com.Treinamento.Pessoa.DTO.PessoaFisicaDTO;
import br.com.Treinamento.Pessoa.DTO.PessoaJuridicaDTO;
import br.com.Treinamento.Pessoa.Model.Pessoa;
import br.com.Treinamento.Pessoa.Service.PessoaService;

@RestController
@RequestMapping("/pessoa")
public class PessoaController {

	@Autowired
	private PessoaService pessoaService;

	// O GETMAPPING RESPONDE A REQUISIÇÃO
	@PostMapping("/cadastrar")
	public ResponseEntity<Pessoa> cadastrarPessoa(@Valid @RequestBody PessoaDTO pessoaDTO) {
		Pessoa pessoaSaved = pessoaService.cadastrar(pessoaDTO);
		return ResponseEntity.status(HttpStatus.CREATED).body(pessoaSaved);
	}

	@GetMapping
    public ResponseEntity<List<Pessoa>> buscarListaPessoa() {
        return new ResponseEntity<>(pessoaService.buscarPessoaList(), HttpStatus.OK);
    }

	@GetMapping("/{idPessoa}")
	public ResponseEntity<PessoaDTO> buscarPessoas(@PathVariable Long idPessoa) {
		return new ResponseEntity<>(pessoaService.buscarPessoa(idPessoa), HttpStatus.OK);
	}

	@PutMapping("/alterar/{idPessoa}")
    public ResponseEntity<?> alterar(@RequestBody PessoaDTO pessoaDTO, @PathVariable Long idPessoa) {
		pessoaService.alterar(pessoaDTO, idPessoa);
		return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

	@PutMapping("/adicionar/pessoaFisica/{idPessoa}")
	public ResponseEntity<?> adicionarPF(@PathVariable Long idPessoa, @RequestBody PessoaFisicaDTO pessoaFisicaDTO){
		pessoaService.adicionarPessoaFisica(idPessoa, pessoaFisicaDTO);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}

	@PutMapping("/adicionar/pessoaJuridica/{idPessoa}")
	public ResponseEntity<?> adicionarPJ(@PathVariable Long idPessoa, @RequestBody PessoaJuridicaDTO pessoaJuridicaDTO){
		pessoaService.adicionarPessoaJuridica(idPessoa, pessoaJuridicaDTO);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
}
