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
import br.com.Treinamento.Pessoa.Model.DomGenero;
import br.com.Treinamento.Pessoa.Model.Pessoa;
import br.com.Treinamento.Pessoa.Model.PessoaFisica;
import br.com.Treinamento.Pessoa.Validator.PF.PessoaFisicaGroup;
import br.com.Treinamento.Pessoa.Validator.PF.ValidaPessoaFisica;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ValidaPessoaFisica(groups = { PessoaFisicaGroup.class })
public class PessoaFisicaDTO extends PessoaDTO{
	
	private static Validator validator = Validation.buildDefaultValidatorFactory().getValidator();

    private String cpf;
    private String rg;
    private DomGenero genero;
    @JsonDeserialize(using = LocalDateDeserializer.class)
    @JsonSerialize(using = LocalDateSerializer.class)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate nasc;

    public PessoaFisicaDTO(PessoaFisica pessoaFisica) {
        this.cpf = pessoaFisica.getCpf();
        this.rg = pessoaFisica.getRg();
        this.genero = pessoaFisica.getGenero();
        this.nasc = pessoaFisica.getNasc();
    }
    
    public static void preenchimentoCamposPessoaFisica(PessoaDTO pessoaDTO, Pessoa pessoa) {
    	validarPessoaFisica(pessoaDTO);
    	((PessoaFisica) pessoa).setCpf(pessoaDTO.getPessoaFisicaDTO().getCpf());
        ((PessoaFisica) pessoa).setRg(pessoaDTO.getPessoaFisicaDTO().getRg());
        ((PessoaFisica) pessoa).setGenero(pessoaDTO.getPessoaFisicaDTO().getGenero());
        ((PessoaFisica) pessoa).setNasc(pessoaDTO.getPessoaFisicaDTO().getNasc());
	}
    
    private static void validarPessoaFisica(PessoaDTO pessoaDTO) {
		Set<ConstraintViolation<PessoaFisicaDTO>> violations = validator.validate(pessoaDTO.getPessoaFisicaDTO(), PessoaFisicaGroup.class);

		if (!violations.isEmpty()) {
			String erros = violations.stream().map(ConstraintViolation::getMessage).collect(Collectors.joining("\n"));
			throw new BusinessException(erros);
		}
	}
}
