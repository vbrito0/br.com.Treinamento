package br.com.Treinamento.Pessoa.Model;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.Period;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
@DiscriminatorValue(value = "PESSOA_FISICA")
public class PessoaFisica extends Pessoa implements Serializable {

    private static final long serialVersionUID = 1L;

    @Column(name = "CPF")
    private String cpf;

    @Column(name = "RG")
    private String rg;

    @Column(name = "GENERO")
    @Enumerated(EnumType.STRING)
    private DomGenero genero;

    @JsonFormat(pattern = "dd/MM/yyyy")
    @JsonSerialize(using = LocalDateSerializer.class)
    @JsonDeserialize(using = LocalDateDeserializer.class)
    @Column(name = "DATA_NASCIMENTO")
    private LocalDate nasc;

//    @JsonBackReference
//    @OneToOne
//    @JoinColumn(name = "ID_PESSOA")
//    private Pessoa pessoa;
    
    public String getCpfSemMascara() {
        return cpf != null ? this.cpf.replaceAll("\\D+", "") : cpf;
    }

    public int getIdade() {
        return Objects.nonNull(nasc) ? Period.between(this.nasc, LocalDate.now()).getYears() : 0;
    }

    public static int getIdade(LocalDate nasc) {
        Objects.requireNonNull(nasc, "Data de Nascimento obrigatória");
        return Period.between(nasc, LocalDate.now()).getYears();
    }

    public static boolean precisaEmancipacao(LocalDate nasc) {
        int idade = getIdade(nasc);
        return idade >= 16 && idade < 18;
    }

    public boolean precisaEmancipacao() {
        int idade = getIdade();
        return idade >= 16 && idade < 18;
    }

    public boolean isMaiorIdade() {
        int idade = getIdade();
        return idade >= 18;
    }

    public boolean isMenorIdade() {
        return !isMaiorIdade();
    }

    public boolean isMenor16Anos() {
        int idade = getIdade();
        return idade < 16;
    }
}
