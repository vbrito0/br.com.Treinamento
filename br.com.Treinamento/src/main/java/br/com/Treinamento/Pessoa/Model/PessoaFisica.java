package br.com.Treinamento.Pessoa.Model;

import java.sql.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;


@Entity
@DiscriminatorValue(value = "PF")
@PrimaryKeyJoinColumn(name="idPessoa")
public class PessoaFisica extends Pessoa{
	
	private static final long serialVersionUID = 1L;
	
	private String cpf;
	private String rg;
	private String genero;
	private Date nasc;
	
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getRg() {
		return rg;
	}
	public void setRg(String rg) {
		this.rg = rg;
	}
	public String getGenero() {
		return genero;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}
	public Date getNasc() {
		return nasc;
	}
	public void setNasc(Date nasc) {
		this.nasc = nasc;
	}
	
}
