package br.com.Treinamento.Pessoa.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

@Configuration
public class SwaggerConfig {
	@Bean
    OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                .title("API de Pessoa")
                .version("1.0")
                .description("Documentação da API de Pessoa"));
    }
}
