package br.com.andrelemos.contabanco.base.favorecido.api.resource;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.andrelemos.contabanco.base.favorecido.api.model.FavorecidoRequest;
import br.com.andrelemos.contabanco.base.favorecido.api.model.InfoFavorecido;
import br.com.andrelemos.contabanco.base.favorecido.api.service.BaseFavorecidoService;
import br.com.andrelemos.contabanco.base.favorecido.api.utils.BaseFavorecidoUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.slf4j.Slf4j;

/**
 * Recurso disponivel para consumir/pesquisar a base de favorecidos
 * 
 * @author Andre Lemos
 * @version 1.0.0
 * @since Release 1
 *
 */
@Api(value = "/favorecidos", tags = "Favorecidos")
@Slf4j
@RestController
@RequestMapping("/api/v1/favorecidos")
public class FavorecidosResource {

  @Autowired private BaseFavorecidoService baseFavorecidoService;

  @ApiOperation(
      value = "Pesquisa de contatos favorecidos",
      notes = "Obtem a lista de contatos favorecidos cadastrados")
  @ApiResponses(
      value = {
        @ApiResponse(code = 200, message = "Successfully"),
        @ApiResponse(code = 404, message = "Data Not Found"),
        @ApiResponse(code = 500, message = "Internal Server Error")
      })
  @PostMapping(value = "/info")
  public ResponseEntity<?> info(@RequestBody FavorecidoRequest request) {

    log.debug(
        "PESQUISA LISTA DE FAVORECIDOS (IN) BANCO | AGENCIA | CONTA | DIGITO | PAGINA | LIMITE : {}",
        BaseFavorecidoUtils.objetoParaJson(request));
    try {

      Optional<InfoFavorecido> infoFavorecido = baseFavorecidoService.obterListaFavorecido(request);

      log.debug(
          "PESQUISA LISTA DE FAVORECIDOS (OUT) : {}",
          BaseFavorecidoUtils.objetoParaJson(infoFavorecido));

      if (!infoFavorecido.isPresent()) {
        log.debug("HTTP 422, NAO HA DADOS PARA BANCO | AGENCIA | CONTA | DIGITO INFORMADO");
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
            .body("NAO HA DADOS PARA BANCO | AGENCIA | CONTA | DIGITO INFORMADO");
      }

      log.debug("PESQUISA LISTA DE FAVORECIDOS : HTTP 200");
      return ResponseEntity.ok(infoFavorecido.get());
    } catch (Exception e) {
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }
  }
}
