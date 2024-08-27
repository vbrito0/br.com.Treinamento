package br.com.Treinamento.Pessoa.DTO;

import static br.com.Treinamento.Pessoa.DTO.PessoaFisicaDTO.preenchimentoCamposPessoaFisica;
import static br.com.Treinamento.Pessoa.DTO.PessoaJuridicaDTO.preenchimentoCamposPessoaJuridica;

import br.com.Treinamento.Pessoa.Model.Pessoa;
import br.com.Treinamento.Pessoa.Model.PessoaFisica;
import br.com.Treinamento.Pessoa.Model.PessoaJuridica;
import br.com.Treinamento.Pessoa.Validator.PessoaGroup;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Data
@ValidaPessoa(groups = { PessoaGroup.class })
@Builder
public class PessoaDTO {

    private Long idPessoa;
    private String nome;
    private String nomeFantasia;
    private String logradouro;
    private String bairro;
    private String cidade;
    private String complemento;
    private String cep;
    private String uf;
    private Integer numero;
    private PessoaFisicaDTO pessoaFisicaDTO;
    private PessoaJuridicaDTO pessoaJuridicaDTO;

    public PessoaDTO(Pessoa pessoa) {
        this.idPessoa = pessoa.getIdPessoa();
        this.nome = pessoa.getNome();
        this.nomeFantasia = pessoa.getNomeFantasia();
        this.logradouro = pessoa.getLogradouro();
        this.bairro = pessoa.getBairro();
        this.cidade = pessoa.getCidade();
        this.complemento = pessoa.getComplemento();
        this.cep = pessoa.getCep();
        this.uf = pessoa.getUf();
        this.numero = pessoa.getNumero();
        
        if (pessoa instanceof PessoaFisica) {
            this.pessoaFisicaDTO = new PessoaFisicaDTO((PessoaFisica) pessoa);
        } else if (pessoa instanceof PessoaJuridica) {
            this.pessoaJuridicaDTO = new PessoaJuridicaDTO((PessoaJuridica) pessoa);
        }
    }

    public static Pessoa fromPessoaDTO(PessoaDTO pessoaDTO) {
        Pessoa pessoa = new Pessoa();
        if (pessoaDTO.getPessoaFisicaDTO() != null) {
            pessoa = new PessoaFisica();
            preenchimentoCamposPessoa(pessoaDTO, pessoa);
            preenchimentoCamposPessoaFisica(pessoaDTO, pessoa);
        } else if (pessoaDTO.getPessoaJuridicaDTO() != null) {
            pessoa = new PessoaJuridica();
            preenchimentoCamposPessoa(pessoaDTO, pessoa);
            preenchimentoCamposPessoaJuridica(pessoaDTO, pessoa);
        } 
        return pessoa;
    }

	private static void preenchimentoCamposPessoa(PessoaDTO pessoaDTO, Pessoa pessoa) {
		pessoa.setNome(pessoaDTO.getNome());
		pessoa.setNomeFantasia(pessoaDTO.getNomeFantasia());
		pessoa.setBairro(pessoaDTO.getBairro());
		pessoa.setCep(pessoaDTO.getCep());
		pessoa.setCidade(pessoaDTO.getCidade());
		pessoa.setComplemento(pessoaDTO.getComplemento());
		pessoa.setLogradouro(pessoaDTO.getLogradouro());
		pessoa.setNumero(pessoaDTO.getNumero());
		pessoa.setUf(pessoaDTO.getUf());
	}

    public static PessoaDTO fromPessoa(Pessoa pessoa) {
        PessoaDTO pessoaDTO = new PessoaDTO(pessoa);
        if (pessoa instanceof PessoaFisica) {
            pessoaDTO.setPessoaFisicaDTO(new PessoaFisicaDTO((PessoaFisica) pessoa));
        } else if (pessoa instanceof PessoaJuridica) {
            pessoaDTO.setPessoaJuridicaDTO(new PessoaJuridicaDTO((PessoaJuridica) pessoa));
        }
        return pessoaDTO;
    }
}
