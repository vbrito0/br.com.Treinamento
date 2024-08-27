package br.com.Treinamento.Pessoa.Model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@DiscriminatorValue(value = "PESSOA_JURIDICA")
public class PessoaJuridica extends Pessoa{

	private static final long serialVersionUID = 1L;

	@Column(name = "CNPJ")
	private String cnpj;

	@Column(name = "INSCRICAO_ESTADUAL")
	private String inscricaoEstadual;

	@JsonFormat(pattern = "dd/MM/yyyy")
    @JsonSerialize(using = LocalDateSerializer.class)
    @JsonDeserialize(using = LocalDateDeserializer.class)
	@Column(name = "FUNDACAO")
	LocalDate fundacao;

	@OneToOne
	@JoinColumn(name = "ID_PESSOA")
	private Pessoa pessoa;

}
