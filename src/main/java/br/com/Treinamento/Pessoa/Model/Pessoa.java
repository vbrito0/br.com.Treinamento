package br.com.Treinamento.Pessoa.Model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "TIPO_PESSOA")
@NoArgsConstructor
@EqualsAndHashCode(of = "idPessoa", callSuper = false)
@Builder
@AllArgsConstructor
@Table(name = "PESSOA")
public class Pessoa implements Serializable {

	 private static final long serialVersionUID = 1L;

	 	@Id
	    @SequenceGenerator(name = "PESSOA_SQ", sequenceName = "PESSOA_SQ", allocationSize = 1)
	    @GeneratedValue(generator = "PESSOA_SQ", strategy = GenerationType.SEQUENCE)
	    @Column(name = "ID_PESSOA", nullable = false)
	    private Long idPessoa;

	    @Column(name = "NOME", nullable = false)
	    private String nome;

	 	@Column(name = "NOME_FANTASIA", nullable = false)
	 	private String nomeFantasia;

	 	@Column(name = "LOGRADOURO", nullable = false)
		private String logradouro;

	 	@Column(name = "NUMERO", nullable = false)
		private Integer numero;

		@Column(name = "COMPLEMENTO")
		private String complemento;

		@Column(name = "BAIRRO", nullable = false)
		private String bairro;

		@Column(name = "CEP", nullable = false)
		private String cep;

		@Column(name = "CIDADE", nullable = false)
		private String cidade;

		@Column(name = "UF", nullable = false)
		private String uf;

		@OneToOne(mappedBy = "pessoa", cascade = CascadeType.ALL)
		private PessoaFisica pessoaFisica;

		@OneToOne(mappedBy = "pessoa", cascade = CascadeType.ALL)
		private PessoaJuridica pessoaJuridica;

		public PessoaFisica toPessoaFisica() {
		    if (this instanceof PessoaFisica) {
		        return (PessoaFisica) this;
		    }
		    throw new ClassCastException("A instância não é do tipo PessoaFisica");
		}

		public PessoaJuridica toPessoaJuridica() {
		    if (this instanceof PessoaJuridica) {
		        return (PessoaJuridica) this;
		    }
		    throw new ClassCastException("A instância não é do tipo PessoaJuridica");
		}

		public boolean isPessoaFisica() {
	        return this instanceof PessoaFisica;
	    }
		
	    public boolean isPessoaJuridica() {
	        return this instanceof PessoaJuridica;
	    }
	}