package br.com.Treinamento.Pessoa.Model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name = "PESSOA", schema = "pessoa_estudo")
public class Pessoa implements Serializable{
	
	 private static final long serialVersionUID = 1L;
	 	
	 	//FAZENDO UMA SEQUENCE NO DB E DEPOIS MAPEAR O CAMPO QUE VAI SER GERADO
	 	@Id
	    @SequenceGenerator(name = "PESSOA_SQ", sequenceName = "PESSOA_SQ", allocationSize = 1, schema = "pessoa_estudo")
	    @GeneratedValue(generator = "PESSOA_SQ", strategy = GenerationType.SEQUENCE)
	    
	    //FAZENDO UM MAPEAMENTO DO CAMPO DA ENTIDADE COM A COLUNA DO DB
	    @Column(name = "ID", nullable = false)
	    private Long id;
	    
	 	@NotBlank
	    @Column(name = "NOME")
	    private String nome;
	 	
	 	@NotBlank
	    @Column(name = "IDADE")	
	    private Integer idade;
	    
	 	@NotBlank
	    @Column(name = "GENERO")
	    private String sexo;
	    
	 	@NotBlank
	    @Column(name = "ESTATURA")
	    private Double estatura;
	    
	    //@OneToMany(mappedBy = "pessoa", cascade = CascadeType.PERSIST)
	    //private List<Endereco> enderecoList;
	}