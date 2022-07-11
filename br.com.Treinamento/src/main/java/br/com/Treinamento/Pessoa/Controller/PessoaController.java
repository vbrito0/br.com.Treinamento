package br.com.Treinamento.Pessoa.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.Treinamento.Pessoa.Model.Pessoa;
import br.com.Treinamento.Pessoa.Service.PessoaService;

@RestController
@RequestMapping("/pessoas")
public class PessoaController {
	
	@Autowired
	private PessoaService pessoaService;
	
	
	@GetMapping
	public ResponseEntity<List<Pessoa>>buscarPessoas(){
        return new ResponseEntity<List<Pessoa>>(pessoaService.buscarPessoas(), HttpStatus.OK);
	}
	
	
	//O GETMAPPING RESPONDE A REQUISIÇÃO
	@GetMapping("/{id}")
    public ResponseEntity<Pessoa> buscarPessoas(@PathVariable("id") Long id) {
        return new ResponseEntity<Pessoa>(pessoaService.buscarPessoas(id), HttpStatus.OK);
    }
	
	@GetMapping("/criar")
	public ResponseEntity<Pessoa> criarPessoa(@RequestBody final Pessoa pessoa) {

        Pessoa pessoaCriado = pessoaService.criarPessoa(pessoa);
        return new ResponseEntity<Pessoa>(pessoaCriado, HttpStatus.OK);
    }
	
	@PutMapping("/alterar/{idPessoa}")
    public ResponseEntity<Pessoa> alterarPessoa(@RequestBody final Pessoa pessoa, @PathVariable("idPessoa") Long idPessoa) {
        final Pessoa pessoaParaAlterar = Pessoa.builder().id(idPessoa).nome(pessoa.getNome()).idade(pessoa.getIdade()).sexo(pessoa.getSexo()).estatura(pessoa.getEstatura()).build();
        return new ResponseEntity<Pessoa>(pessoaService.alterar(pessoaParaAlterar), HttpStatus.OK);
    }
}
