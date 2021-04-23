package br.com.andrelemos.contabanco.base.favorecido.api.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

/**
 * Configuracao do Swagger para documentar a API
 * 
 * @author Andre Lemos
 * @version 1.0.0
 * @since Release 1
 *
 */
@Configuration
public class SwaggerConfiguration {

  @Bean
  public Docket api() {
    return new Docket(DocumentationType.SWAGGER_2)
        .apiInfo(new ApiInfoBuilder().title("Base Favorecidos - API").build())
        .select()
        .apis(RequestHandlerSelectors.any())
        .paths(new SwaggerConfigPathExclusion())
        .build();
  }
}
