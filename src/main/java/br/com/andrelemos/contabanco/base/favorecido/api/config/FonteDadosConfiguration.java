package br.com.andrelemos.contabanco.base.favorecido.api.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.zaxxer.hikari.HikariDataSource;

@Configuration
public class FonteDadosConfiguration {

  @Autowired private BaseFavorecidosApiProperties properties;

  @Bean(name = "dataSource", destroyMethod = "close")
  public DataSource dataSource() {
    HikariDataSource dataSource = new HikariDataSource();
    dataSource.setMaximumPoolSize(properties.getMaximumPoolSize());
    dataSource.setMinimumIdle(properties.getMinimumIddle());
    dataSource.setDriverClassName(properties.getDriverClass());
    dataSource.setJdbcUrl(properties.getUrl());
    dataSource.setUsername(properties.getUsername());
    dataSource.setPassword(properties.getPassword());
    dataSource.setRegisterMbeans(true);
    return dataSource;
  }
}
