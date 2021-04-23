package br.com.andrelemos.contabanco.base.favorecido.api.utils;

import org.apache.commons.lang3.StringUtils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class BaseFavorecidoUtils {

  public static String objetoParaJson(Object object) {
    return escreveJsonComoString(object);
  }

  private static String escreveJsonComoString(Object object) {
    try {
      ObjectMapper mapper = new ObjectMapper();
      mapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
      return mapper.writeValueAsString(object);
    } catch (JsonProcessingException exc) {
      log.error("OCORREU UM ERRO AO CONVERTER O OBJETO PARA JSON", exc);
      return StringUtils.EMPTY;
    }
  }
}
