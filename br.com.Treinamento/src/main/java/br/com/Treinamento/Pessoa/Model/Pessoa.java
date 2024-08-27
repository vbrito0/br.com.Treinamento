package br.com.Treinamento.Pessoa.Model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

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

	 	//FAZENDO UM MAPEAMENTO DO CAMPO DA ENTIDADE COM A COLUNA DO DB
	 	//FAZENDO UMA SEQUENCE NO DB E DEPOIS MAPEAR O CAMPO QUE VAI SER GERADO
	 	@Id
	    @SequenceGenerator(name = "PESSOA_SQ", sequenceName = "PESSOA_SQ", allocationSize = 1)
	    @GeneratedValue(generator = "PESSOA_SQ", strategy = GenerationType.SEQUENCE)
	    @Column(name = "ID", nullable = false)
	    private Long idPessoa;

	 	@NotBlank
	    @Column(name = "NOME", nullable = false)
	    private String nome;

	 	@NotBlank
	 	@Column(name = "NOME_FANTASIA", nullable = false)
	 	private String nomeFantasia;

	 	@NotBlank
	 	@Column(name = "LOGRADOURO", nullable = false)
		private String logradouro;

	 	@NotBlank
	 	@Column(name = "NUMERO", nullable = false)
		private Integer numero;

		@Column(name = "COMPLEMENTO")
		private String complemento;

		@NotBlank
		@Column(name = "BAIRRO", nullable = false)
		private String bairro;

		@NotBlank
		@Column(name = "CEP", nullable = false)
		private String cep;

		@NotBlank
		@Column(name = "CIDADE", nullable = false)
		private String cidade;

		@NotBlank
		@Column(name = "UF", nullable = false)
		private String uf;

		@OneToOne(mappedBy = "pessoa", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
		private PessoaFisica pessoaFisica;

		@OneToOne(mappedBy = "pessoa", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
		private PessoaJuridica pessoaJuridica;

		public PessoaFisica toPessoaFisica() {
	        return (PessoaFisica) this;
	    }

	    public PessoaJuridica toPessoaJuridica() {
	        return (PessoaJuridica) this;
	    }

	    public boolean isPessoaFisica() {
	        return this instanceof PessoaFisica;
	    }

	    public boolean isPessoaJuridica() {
	        return this instanceof PessoaJuridica;
	    }
	}