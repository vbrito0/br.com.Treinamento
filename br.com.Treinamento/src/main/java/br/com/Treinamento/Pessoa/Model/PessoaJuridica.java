package br.com.Treinamento.Pessoa.Model;

import java.sql.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
@DiscriminatorValue(value = "PJ")
@PrimaryKeyJoinColumn(name="idPessoa")
public class PessoaJuridica extends Pessoa{

	
	private static final long serialVersionUID = 1L;
	
	private String cnpj;
	private String inscricaoEstadual;
	private Date fundacao;
	
	public String getCnpj() {
		return cnpj;
	}
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	public String getInscricaoEstadual() {
		return inscricaoEstadual;
	}
	public void setInscricaoEstadual(String inscricaoEstadual) {
		this.inscricaoEstadual = inscricaoEstadual;
	}
	public Date getFundacao() {
		return fundacao;
	}
	public void setFundacao(Date fundacao) {
		this.fundacao = fundacao;
	}
	
	
}
