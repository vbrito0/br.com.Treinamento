package br.com.Treinamento.Pessoa.Service;

import static br.com.Treinamento.Pessoa.Message.Menssage.ID_NÃO_ENCONTRADO;
import static br.com.Treinamento.Pessoa.Message.Menssage.MSG_PESSOA_EXISTENTE;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.Treinamento.Pessoa.DTO.PessoaDTO;
import br.com.Treinamento.Pessoa.DTO.PessoaFisicaDTO;
import br.com.Treinamento.Pessoa.DTO.PessoaJuridicaDTO;
import br.com.Treinamento.Pessoa.Exception.BusinessException;
import br.com.Treinamento.Pessoa.Exception.NotFoundException;
import br.com.Treinamento.Pessoa.Model.Pessoa;
import br.com.Treinamento.Pessoa.Model.PessoaFisica;
import br.com.Treinamento.Pessoa.Model.PessoaJuridica;
import br.com.Treinamento.Pessoa.Repository.PessoaFisicaRepository;
import br.com.Treinamento.Pessoa.Repository.PessoaJuridicaRepository;
import br.com.Treinamento.Pessoa.Repository.PessoaRepository;
import br.com.Treinamento.Pessoa.Validator.PessoaGroup;

@Service
public class PessoaService {

	@Autowired
	private PessoaRepository pessoaRepository;

	@Autowired
	private PessoaFisicaRepository pessoaFisicaRepository;

	@Autowired
	private PessoaJuridicaRepository pessoaJuridicaRepository;

	private Validator validator = Validation.buildDefaultValidatorFactory().getValidator();

	public Pessoa cadastrar(PessoaDTO pessoaDTO) {
		validarSePessoaExiste(pessoaDTO);
		Pessoa pessoa = Pessoa.builder().nome(pessoaDTO.getNome()).nomeFantasia(pessoaDTO.getNomeFantasia())
				.bairro(pessoaDTO.getBairro()).cep(pessoaDTO.getCep()).cidade(pessoaDTO.getCidade())
				.complemento(pessoaDTO.getComplemento()).logradouro(pessoaDTO.getLogradouro())
				.numero(pessoaDTO.getNumero()).uf(pessoaDTO.getUf()).build();

		return pessoaRepository.save(pessoa);
	}

	private void validarSePessoaExiste(PessoaDTO pessoaDTO) {
		if (Objects.isNull(pessoaDTO)) {
			throw new BusinessException(MSG_PESSOA_EXISTENTE);
		}
	}

	public List<Pessoa> buscarPessoaList() {
		return pessoaRepository.findAll();
	}

	public PessoaDTO buscarPessoa(Long idPessoa) {
		Pessoa pessoa = pessoaRepository.findById(idPessoa).get();
		PessoaDTO dto = new PessoaDTO(pessoa);
		return dto;
	}

	public void alterar(PessoaDTO pessoaDTO, Long idPessoa) {
		validarPessoa(pessoaDTO);
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
		pessoaRepository.save(pessoa);
	}

	public List<PessoaFisica> adicionarPessoaFisica(Long idPessoa, PessoaFisicaDTO pessoaFisicaDTO) {

		List <Pessoa> pessoa = pessoaRepository.findByIdPessoa(idPessoa);
		if (Objects.isNull(pessoa)) {
			throw new NotFoundException(String.format(ID_NÃO_ENCONTRADO, idPessoa));
		}
		List<PessoaFisica> pessoaFisicaSaved = new LinkedList<>();
		pessoa.stream().forEach(pessoaLoop -> {
			pessoaFisicaSaved.add(pessoaLoop.getPessoaFisica());
		});

		List<PessoaFisica> pessoaFisicaList = new LinkedList<>();

		if (Objects.nonNull(pessoaFisicaDTO.getIdPessoa())) {
			pessoaFisicaList = pessoaFisicaSaved.stream().filter(
					pf -> Objects.nonNull(pf.getIdPessoa()) && pessoaFisicaDTO.getIdPessoa().equals(pf.getIdPessoa()))
					.collect(Collectors.toList());
		}

		for (PessoaFisica pessoaFisi : pessoaFisicaList) {
			pessoaFisi.setCpf(pessoaFisicaDTO.getCpf());
			pessoaFisi.setRg(pessoaFisicaDTO.getRg());
			pessoaFisi.setGenero(pessoaFisicaDTO.getGenero());
			pessoaFisi.setNasc(pessoaFisicaDTO.getNasc());
			pessoaFisicaRepository.save(pessoaFisi);
		}

		return pessoaFisicaList;
	}

	private void validarPessoa(PessoaDTO pessoaDTO) {
		Set<ConstraintViolation<PessoaDTO>> violations = validator.validate(pessoaDTO, PessoaGroup.class);

		if (!violations.isEmpty()) {
			String erros = violations.stream().map(ConstraintViolation::getMessage).collect(Collectors.joining("\n"));
			throw new BusinessException(erros);
		}
	}

	public List<PessoaJuridica> adicionarPessoaJuridica(Long idPessoa, PessoaJuridicaDTO pessoaJuridicaDTO) {

		List <Pessoa> pessoa = pessoaRepository.findByIdPessoa(idPessoa);
		if (Objects.isNull(pessoa)) {
			throw new NotFoundException(String.format(ID_NÃO_ENCONTRADO, idPessoa));
		}
		List<PessoaJuridica> pessoaJuridicaSaved = new LinkedList<>();
		pessoa.stream().forEach(pessoaLoop -> {
			pessoaJuridicaSaved.add(pessoaLoop.getPessoaJuridica());
		});

		List<PessoaJuridica> pessoaJuridicaList = new LinkedList<>();

		if (Objects.nonNull(pessoaJuridicaDTO)) {
			pessoaJuridicaList = pessoaJuridicaSaved.stream().filter(
					pj -> Objects.nonNull(pj.getIdPessoa()) && pessoaJuridicaDTO.getNome().equals(pj.getNome()))
					.collect(Collectors.toList());
		}

		for (PessoaJuridica pessoaJu : pessoaJuridicaList) {
			pessoaJu.setCnpj(pessoaJuridicaDTO.getCnpj());
			pessoaJu.setInscricaoEstadual(pessoaJuridicaDTO.getInscricaoEstadual());
			pessoaJu.setFundacao(pessoaJuridicaDTO.getFundacao());
			pessoaJuridicaRepository.save(pessoaJu);
		}
		return pessoaJuridicaList;
	}

}
