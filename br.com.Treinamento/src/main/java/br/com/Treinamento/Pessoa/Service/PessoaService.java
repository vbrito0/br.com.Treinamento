package br.com.Treinamento.Pessoa.Service;

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

	private static final String ID_NÃO_ENCONTRADO = "Id não encontrado";

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

		pessoa = salvarPessoa(pessoa);
		return pessoa;
	}

	private void validarSePessoaExiste(PessoaDTO pessoaDTO) {
		if (Objects.isNull(pessoaDTO.getIdPessoa())) {
			throw new BusinessException("Essa pessoa já está cadastrada na base!");
		}
	}

	public Pessoa salvarPessoa(Pessoa pessoaSaved) {
		return pessoaRepository.save(pessoaSaved);
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
		pessoa.setNome(pessoaDTO.getNome());
		pessoa.setNomeFantasia(pessoaDTO.getNomeFantasia());
		pessoa.setBairro(pessoaDTO.getBairro());
		pessoa.setCep(pessoaDTO.getCep());
		pessoa.setCidade(pessoaDTO.getCidade());
		pessoa.setComplemento(pessoaDTO.getComplemento());
		pessoa.setLogradouro(pessoaDTO.getLogradouro());
		pessoa.setNumero(pessoaDTO.getNumero());
		pessoa.setUf(pessoaDTO.getUf());
		pessoaRepository.save(pessoa);
	}

	public List<PessoaFisica> adicionarPessoaFisica(Long idPessoa, PessoaFisicaDTO pessoaFisicaDTO) {

		List <Pessoa> pessoa = pessoaRepository.findByIdPessoa(idPessoa);
		if (Objects.isNull(idPessoa)) {
			throw new NotFoundException(String.format(ID_NÃO_ENCONTRADO, idPessoa));
		}
		List<PessoaFisica> pessoaFisicaSaved = new LinkedList<PessoaFisica>();
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

		}

		return pessoaFisicaRepository.saveAll(pessoaFisicaList);
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
		if (Objects.isNull(idPessoa)) {
			throw new NotFoundException(String.format(ID_NÃO_ENCONTRADO, idPessoa));
		}
		List<PessoaJuridica> pessoaJuridicaSaved = new LinkedList<PessoaJuridica>();
		pessoa.stream().forEach(pessoaLoop -> {
			pessoaJuridicaSaved.add(pessoaLoop.getPessoaJuridica());
		});

		List<PessoaJuridica> pessoaJuridicaList = new LinkedList<>();

		if (Objects.nonNull(pessoaJuridicaDTO.getIdPessoa())) {
			pessoaJuridicaList = pessoaJuridicaSaved.stream().filter(
					pj -> Objects.nonNull(pj.getIdPessoa()) && pessoaJuridicaDTO.getIdPessoa().equals(pj.getIdPessoa()))
					.collect(Collectors.toList());
		}

		for (PessoaJuridica pessoaJu : pessoaJuridicaList) {
			pessoaJu.setCnpj(pessoaJuridicaDTO.getCnpj());
			pessoaJu.setInscricaoEstadual(pessoaJuridicaDTO.getInscricaoEstadual());
			pessoaJu.setFundacao(pessoaJuridicaDTO.getFundacao());
		}

		return pessoaJuridicaRepository.saveAll(pessoaJuridicaList);
	}

}
