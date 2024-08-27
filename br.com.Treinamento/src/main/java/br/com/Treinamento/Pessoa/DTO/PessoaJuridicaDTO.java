package br.com.Treinamento.Pessoa.DTO;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "cnpj", callSuper = false)
@Data
public class PessoaJuridicaDTO extends PessoaDTO{

	String cnpj;
	String inscricaoEstadual;
	LocalDate fundacao;

}
