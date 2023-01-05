package br.com.Treinamento.Pessoa.DTO;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;

import br.com.Treinamento.Pessoa.Model.DomGenero;
import br.com.Treinamento.Pessoa.Model.PessoaFisica;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "cpf", callSuper = false)
@Data
public class PessoaFisicaDTO extends PessoaDTO {

	Long idPessoa;
	
	String cpf;
	
	String rg;
	
	DomGenero genero;
	
	@JsonDeserialize(using = LocalDateDeserializer.class)
    @JsonSerialize(using = LocalDateSerializer.class)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	LocalDate nasc;

	
	@JsonIgnore
    private PessoaFisica pessoaFisicaOriginal;
	
	@JsonIgnore
    public String getCpfSemMascara() {
        return cpf != null ? this.cpf.replaceAll("\\D+", "") : cpf;
    }
}
