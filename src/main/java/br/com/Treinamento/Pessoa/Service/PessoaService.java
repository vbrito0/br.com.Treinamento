package br.com.Treinamento.Pessoa.Service;

import static br.com.Treinamento.Pessoa.Message.Menssage.CNPJ_INVALID;
import static br.com.Treinamento.Pessoa.Message.Menssage.CNPJ_NOT_FOUND;
import static br.com.Treinamento.Pessoa.Message.Menssage.CPF_NOT_FOUND;
import static br.com.Treinamento.Pessoa.Message.Menssage.ID_NOT_FOUND;
import static br.com.Treinamento.Pessoa.Message.Menssage.NOT_IS_PF;
import static br.com.Treinamento.Pessoa.Message.Menssage.NOT_IS_PJ;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.Treinamento.Pessoa.DTO.PessoaDTO;
import br.com.Treinamento.Pessoa.Exception.NotFoundException;
import br.com.Treinamento.Pessoa.Message.Menssage;
import br.com.Treinamento.Pessoa.Model.Pessoa;
import br.com.Treinamento.Pessoa.Model.PessoaFisica;
import br.com.Treinamento.Pessoa.Model.PessoaJuridica;
import br.com.Treinamento.Pessoa.Repository.PessoaFisicaRepository;
import br.com.Treinamento.Pessoa.Repository.PessoaJuridicaRepository;
import br.com.Treinamento.Pessoa.Repository.PessoaRepository;
import br.com.Treinamento.Pessoa.Utils.CnpjUtils;
import br.com.Treinamento.Pessoa.Utils.CpfUtils;

@Service
public class PessoaService {

	@Autowired
	private PessoaRepository pessoaRepository;
	@Autowired
	private PessoaFisicaRepository pessoaFisicaRepository;
	@Autowired
	private PessoaJuridicaRepository pessoaJuridicaRepository;

	public Pessoa cadastrar(PessoaDTO pessoaDTO) {
		Pessoa pessoa = PessoaDTO.fromPessoaDTO(pessoaDTO);
		return pessoaRepository.save(pessoa);
	}

	public List<Pessoa> buscarPessoaList() {
		return pessoaRepository.findAll();
	}

	public Pessoa getCpf(String cpf) {
		Pessoa pessoaFisica = buscarCpfBanco(cpf);
		return pessoaFisica;
	}

    public void alterarPessoaFisica(String cpf, PessoaDTO pessoaDTO) {
        Pessoa pessoaFisica =  buscarCpfBanco(cpf);
        isAlterarNome(pessoaDTO, pessoaFisica);
		isAlterarNomeFantasia(pessoaDTO, pessoaFisica);
		isAlterarLogradouro(pessoaDTO, pessoaFisica);
		isAlterarBairro(pessoaDTO, pessoaFisica);
		isAlterarCidade(pessoaDTO, pessoaFisica);
		isAlterarComplemento(pessoaDTO, pessoaFisica);
		isAlterarCep(pessoaDTO, pessoaFisica);
		isAlterarUf(pessoaDTO, pessoaFisica);
		isAlterarNumero(pessoaDTO, pessoaFisica);
		pessoaRepository.save(pessoaFisica);
    }
    
    public Pessoa getCnpj(String cnpj) {
		Pessoa pessoaJuridica = buscarCnpjBanco(cnpj);
		return pessoaJuridica;
	}
    
	public void alterarPessoaJuridica(String cnpj, PessoaDTO pessoaDTO) {
        Pessoa pessoaJuridica =  buscarCnpjBanco(cnpj);
        isAlterarNome(pessoaDTO, pessoaJuridica);
		isAlterarNomeFantasia(pessoaDTO, pessoaJuridica);
		isAlterarLogradouro(pessoaDTO, pessoaJuridica);
		isAlterarBairro(pessoaDTO, pessoaJuridica);
		isAlterarCidade(pessoaDTO, pessoaJuridica);
		isAlterarComplemento(pessoaDTO, pessoaJuridica);
		isAlterarCep(pessoaDTO, pessoaJuridica);
		isAlterarUf(pessoaDTO, pessoaJuridica);
		isAlterarNumero(pessoaDTO, pessoaJuridica);
		pessoaRepository.save(pessoaJuridica);
    }

    private Pessoa buscarCpfBanco(String cpf) {
    	String cpfFormatado = CpfUtils.adicionarMascara(cpf);
		Pessoa pessoa = pessoaFisicaRepository.findByCpf(cpfFormatado).orElseThrow(() -> new NotFoundException(CPF_NOT_FOUND));
		
		if(pessoa instanceof PessoaFisica) {
			return (PessoaFisica) pessoa;
		} else {
	        throw new ClassCastException(NOT_IS_PF);
		}
	}
    
    private Pessoa buscarCnpjBanco(String cnpj) {
    	if(CnpjUtils.validarCnpj(cnpj)) {
    		String cnpjFormatado = CnpjUtils.formatarCnpj(cnpj);

    		Pessoa pessoa = pessoaJuridicaRepository.findByCnpj(cnpjFormatado).orElseThrow(() -> new NotFoundException(CNPJ_NOT_FOUND));
    		
    		if(pessoa instanceof PessoaJuridica) {
    			return (PessoaJuridica) pessoa;
    		} else {
    			throw new ClassCastException(NOT_IS_PJ);
    		}
    	} else {
    		throw new IllegalArgumentException(CNPJ_INVALID);
    	}
	}
    
	private void isAlterarNome(PessoaDTO pessoaDTO, Pessoa pessoa) {
		pessoa.setNome(Objects.nonNull(pessoaDTO.getNome()) ? pessoaDTO.getNome() : pessoa.getNome());
	}
	
	private void isAlterarNomeFantasia(PessoaDTO pessoaDTO, Pessoa pessoa) {
		pessoa.setNomeFantasia(Objects.nonNull(pessoaDTO.getNomeFantasia()) ? pessoaDTO.getNomeFantasia() : pessoa.getNomeFantasia());
	}
	
	private void isAlterarLogradouro(PessoaDTO pessoaDTO, Pessoa pessoa) {
		pessoa.setLogradouro(Objects.nonNull(pessoaDTO.getLogradouro()) ? pessoaDTO.getLogradouro() : pessoa.getLogradouro());
	}
	
	private void isAlterarBairro(PessoaDTO pessoaDTO, Pessoa pessoa) {
		pessoa.setBairro(Objects.nonNull(pessoaDTO.getBairro()) ? pessoaDTO.getBairro() : pessoa.getBairro());
	}
	
	private void isAlterarCidade(PessoaDTO pessoaDTO, Pessoa pessoa) {
		pessoa.setCidade(Objects.nonNull(pessoaDTO.getCidade()) ? pessoaDTO.getCidade() : pessoa.getCidade());
	}
	
	private void isAlterarComplemento(PessoaDTO pessoaDTO, Pessoa pessoa) {
		pessoa.setComplemento(Objects.nonNull(pessoaDTO.getComplemento()) ? pessoaDTO.getComplemento() : pessoa.getComplemento());
	}
	
	private void isAlterarCep(PessoaDTO pessoaDTO, Pessoa pessoa) {
		pessoa.setCep(Objects.nonNull(pessoaDTO.getCep()) ? pessoaDTO.getCep() : pessoa.getCep());
	}

	private void isAlterarUf(PessoaDTO pessoaDTO, Pessoa pessoa) {
		pessoa.setUf(Objects.nonNull(pessoaDTO.getUf()) ? pessoaDTO.getUf() : pessoa.getUf());
	}

	private void isAlterarNumero(PessoaDTO pessoaDTO, Pessoa pessoa) {
		pessoa.setNumero(Objects.nonNull(pessoaDTO.getNumero()) ? pessoaDTO.getNumero() : pessoa.getNumero());
	}

	public void deletar(Long idPessoa) {
		Pessoa pessoa = pessoaRepository.findById(idPessoa).orElseThrow(() -> new NotFoundException(ID_NOT_FOUND));
		pessoaRepository.delete(pessoa);
	}
}
