package br.com.andrelemos.contabanco.base.favorecido.api.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Configuration
public class BaseFavorecidosApiProperties {

  @Value("${spring.datasource.hikari.minimum-idle}")
  private Integer minimumIddle;

  @Value("${spring.datasource.hikari.maximum-pool-size}")
  private Integer maximumPoolSize;

  @Value("${spring.datasource.url}")
  private String url;

  @Value("${spring.datasource.driver-class-name}")
  private String driverClass;

  @Value("${spring.datasource.username}")
  private String username;

  @Value("${spring.datasource.password}")
  private String password;
}
