package br.com.Treinamento.Pessoa.Model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

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
@Table(name = "ENDERECO", schema = "pessoa_estudo")
public class Endereco implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
    @SequenceGenerator(name = "ENDERECO_SQ", sequenceName = "ENDERECO_SQ", allocationSize = 1, schema = "pessoa_estudo")
    @GeneratedValue(generator = "ENDERECO_SQ", strategy = GenerationType.SEQUENCE)
	@Column(name = "ID", nullable = false)
    private Long id;
	
	@Column(name = "LOGRADOURO", nullable = false)
	private String logradouro;
	
	@Column(name = "NUMERO", nullable = false)
	private Integer numero;
	
	@Column(name = "COMPLEMENTO", nullable = false)
	private String complemento;
	
	@Column(name = "BAIRRO", nullable = false)
	private String bairro;
	
	@Column(name = "CEP", nullable = false)
	private String cep;
	
	@Column(name = "CIDADE", nullable = false)
	private String cidade;
	
	@Column(name = "UF", nullable = false)
	private String uf;
}
