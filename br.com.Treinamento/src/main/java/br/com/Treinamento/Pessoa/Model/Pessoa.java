package br.com.Treinamento.Pessoa.Model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Entity
@DiscriminatorColumn(name = "tipo", length = 1, discriminatorType = DiscriminatorType.STRING)
@DiscriminatorValue("P")
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "PESSOA", schema = "pessoa_estudo")
public class Pessoa implements Serializable{
	
	 private static final long serialVersionUID = 1L;
	 	
	 	
	    //FAZENDO UM MAPEAMENTO DO CAMPO DA ENTIDADE COM A COLUNA DO DB
	    @Id
	    //FAZENDO UMA SEQUENCE NO DB E DEPOIS MAPEAR O CAMPO QUE VAI SER GERADO
	    @SequenceGenerator(name = "PESSOA_SQ", sequenceName = "PESSOA_SQ", allocationSize = 1, schema = "pessoa_estudo")
	    @GeneratedValue(generator = "PESSOA_SQ", strategy = GenerationType.SEQUENCE)
	    @Column(name = "ID", nullable = false)
	    private Long idPessoa;
	    
	 	@NotBlank
	    @Column(name = "NOME")
	    private String nome;
	 	
	 	@NotBlank
	 	@Column(name = "NOME_FANTASIA")
	 	private String nomeFantasia;
	 	
	 	@NotBlank
	 	@Column(name = "LOGRADOURO", nullable = false)
		private String logradouro;
	 	
	 	@NotBlank
	 	@Column(name = "NUMERO", nullable = false)
		private Integer numero;
		
	 	@NotBlank
		@Column(name = "COMPLEMENTO", nullable = false)
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
	 	
	 	@NotBlank
	 	@Column(name = "TIPO")
	 	private String tipoPessoa;
	 	
	    
	}