package br.com.Treinamento.Pessoa.Model;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
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
		
//		@JsonManagedReference
//	    @OneToOne(mappedBy = "pessoa", cascade = CascadeType.ALL)
//	    private PessoaFisica pessoaFisica;
//
//	    @JsonManagedReference
//	    @OneToOne(mappedBy = "pessoa", cascade = CascadeType.ALL)
//	    private PessoaJuridica pessoaJuridica;

		public PessoaFisica toPessoaFisica() {
		    if (this instanceof PessoaFisica fisica) {
		        return fisica;
		    }
		    throw new ClassCastException("A instância não é do tipo PessoaFisica");
		}

		public PessoaJuridica toPessoaJuridica() {
		    if (this instanceof PessoaJuridica juridica) {
		        return juridica;
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