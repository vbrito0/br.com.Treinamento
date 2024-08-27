package br.com.Treinamento.Pessoa.Controller;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public abstract class AbstractControllerIT {

	@Autowired
    private ModelMapper modelMapper;

	@Test
    public void contextLoads() {
    }

    protected <D, T> D convertToDTO(final T model, final Class<D> dtoClass) {
        return modelMapper.map(model, dtoClass);
    }

    protected <D, T> List<D> convertToDTO(final Iterable<T> models, final Class<D> dtoClass) {
        List<D> dtos = new ArrayList<>();
        for (T model : models) {
            dtos.add(modelMapper.map(model, dtoClass));
        }

        return dtos;
    }
}
