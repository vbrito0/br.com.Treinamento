package br.com.Treinamento.Pessoa.DTO;

import java.time.LocalDate;
import java.util.Set;
import java.util.stream.Collectors;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;

import br.com.Treinamento.Pessoa.Exception.BusinessException;
import br.com.Treinamento.Pessoa.Model.Pessoa;
import br.com.Treinamento.Pessoa.Model.PessoaJuridica;
import br.com.Treinamento.Pessoa.Validator.PF.PessoaFisicaGroup;
import br.com.Treinamento.Pessoa.Validator.PJ.PessoaJuridicaGroup;
import br.com.Treinamento.Pessoa.Validator.PJ.ValidaPessoaJuridica;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ValidaPessoaJuridica(groups = { PessoaJuridicaGroup.class })
public class PessoaJuridicaDTO extends PessoaDTO{
	
	private static Validator validator = Validation.buildDefaultValidatorFactory().getValidator();

	private String cnpj;
	private String inscricaoEstadual;
	@JsonDeserialize(using = LocalDateDeserializer.class)
    @JsonSerialize(using = LocalDateSerializer.class)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private LocalDate fundacao;

	public PessoaJuridicaDTO(PessoaJuridica pessoaJuridica) {
        super(pessoaJuridica);
        this.cnpj = pessoaJuridica.getCnpj();
        this.inscricaoEstadual = pessoaJuridica.getInscricaoEstadual();
        this.fundacao = pessoaJuridica.getFundacao();
    }
	
	public static void preenchimentoCamposPessoaJuridica(PessoaDTO pessoaDTO, Pessoa pessoa) {
    	validarPessoaJuridica(pessoaDTO);
    	((PessoaJuridica) pessoa).setCnpj(pessoaDTO.getPessoaJuridicaDTO().getCnpj());
        ((PessoaJuridica) pessoa).setInscricaoEstadual(pessoaDTO.getPessoaJuridicaDTO().getInscricaoEstadual());
        ((PessoaJuridica) pessoa).setFundacao(pessoaDTO.getPessoaJuridicaDTO().getFundacao());
	}
    
    private static void validarPessoaJuridica(PessoaDTO pessoaDTO) {
		Set<ConstraintViolation<PessoaJuridicaDTO>> violations = validator.validate(pessoaDTO.getPessoaJuridicaDTO(), PessoaFisicaGroup.class);

		if (!violations.isEmpty()) {
			String erros = violations.stream().map(ConstraintViolation::getMessage).collect(Collectors.joining("\n"));
			throw new BusinessException(erros);
		}
	}
}
