package br.com.Treinamento.Pessoa.Model;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.Period;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.br.CPF;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@EqualsAndHashCode(of = "cpf", callSuper = false)
@Entity
@DiscriminatorValue(value = "PESSOA_FISICA")
public class PessoaFisica extends Pessoa implements Serializable{

	private static final long serialVersionUID = 1L;

	@CPF(message = "CPF inválido")
	@NotBlank(message = "CPF é obrigatório")
	private String cpf;

	@Column(name = "RG")
	@NotBlank(message = "RG é obrigatório")
	private String rg;

	@Column(name = "GENERO")
	@Enumerated(EnumType.STRING)
	@NotBlank(message = "Genero é obrigatório")
	private DomGenero genero;

	@JsonFormat(pattern = "dd/MM/yyyy")
    @JsonSerialize(using = LocalDateSerializer.class)
    @JsonDeserialize(using = LocalDateDeserializer.class)
    @Column(name = "DATA_NASCIMENTO")
    @NotNull(message = "Data de nascimento é obrigatória")
	private LocalDate nasc;

	@OneToOne
	@JoinColumn(name = "ID_PESSOA")
	private Pessoa pessoa;

	public String getCpfSemMascara() {
        return cpf != null ? this.cpf.replaceAll("\\D+", "") : cpf;
    }

    public int getIdade() {
        return Objects.nonNull(nasc) ? Period.between(this.nasc, LocalDate.now()).getYears() : 0;
    }

    static public int getIdade(LocalDate nasc) {
        Objects.requireNonNull(nasc, "Data de Nascimento obrigatório");
        return Period.between(nasc, LocalDate.now()).getYears();
    }

    static public boolean precisaEmancipacao(LocalDate nasc) {
        int idade = getIdade(nasc);
        return idade >= 16 && idade < 18;
    }

    public boolean precisaEmancipacao() {
        int idade = getIdade();
        return idade >= 16 && idade < 18;
    }

    public boolean isMaiorIdade() {
        int idade = getIdade();
        return idade >= 18;
    }

    public boolean isMenorIdade() {
        return !isMaiorIdade();
    }

    public boolean isMenor16Anos() {
        int idade = getIdade();
        return idade < 16;
    }
}
