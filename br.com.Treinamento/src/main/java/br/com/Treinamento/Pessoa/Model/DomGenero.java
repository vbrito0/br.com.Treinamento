package br.com.Treinamento.Pessoa.Model;

import java.util.Objects;
import java.util.stream.Stream;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum DomGenero {

	MASCULINO(1),
    FEMININO(2),
    OUTROS(9);

    private Integer idGenero;

    public static DomGenero valueOf(Integer idGenero) throws EnumConstantNotPresentException {
        if (Objects.isNull(idGenero)) {
            return null;
        }
        return Stream.of(values()).filter(domGenero -> domGenero.getIdGenero().equals(idGenero)).findFirst().orElseThrow(() -> new EnumConstantNotPresentException(DomGenero.class, "Value not present ".concat(String.valueOf(idGenero))));
    }
}
