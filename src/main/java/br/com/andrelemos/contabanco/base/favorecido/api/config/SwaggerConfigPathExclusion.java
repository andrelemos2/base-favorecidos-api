package br.com.andrelemos.contabanco.base.favorecido.api.config;

import java.util.function.Predicate;

/**
 * Test para excluir endpoints
 * 
 * @author Andre Lemos
 * @version 1.0.0
 * @since Release 1
 *
 */
public class SwaggerConfigPathExclusion implements Predicate<String> {

  @Override
  public boolean test(String input) {
    return !input.contains("actuator") && !input.contains("error");
  }
}
