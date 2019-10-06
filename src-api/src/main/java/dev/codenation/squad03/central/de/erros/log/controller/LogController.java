package dev.codenation.squad03.central.de.erros.log.controller;

import dev.codenation.squad03.central.de.erros.config.Message;
import dev.codenation.squad03.central.de.erros.exception.ResourceNotFoundException;
import dev.codenation.squad03.central.de.erros.log.model.Log;
import dev.codenation.squad03.central.de.erros.log.service.LogService;
import java.util.Arrays;
import java.util.Optional;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Classe que representa um log na API Central de Erros
 *
 * @author Alfredo
 * @version 1.0
 * @since 01.10.2019
 */
@RestController
@AllArgsConstructor
@RequestMapping("/logs")
public class LogController {

  @Autowired
  private LogService logService;

  @Autowired
  private Message message;

  @GetMapping(path = "/{id}")
  @ResponseBody
  public ResponseEntity<?> findById(@PathVariable Long id) {
    Optional<Log> optionalLog = this.logService.findById(id);
    Log log = optionalLog.orElseThrow(() -> new ResourceNotFoundException(
        message.build("resource.not.found.for.identifier", Arrays.asList(id))));
    return new ResponseEntity<>(log, HttpStatus.OK);
  }

  @PostMapping
  @ResponseBody
  public ResponseEntity<?> create(@RequestBody Log log) {
    return new ResponseEntity<>(this.logService.save(log), HttpStatus.ACCEPTED);
  }

  @GetMapping
  @ResponseBody
  public ResponseEntity<?> findAll() {
    return new ResponseEntity<>(
        this.logService.findAll(),
        HttpStatus.OK);
  }

  @GetMapping(path = "busca-por-ambiente/{ambiente}")
  @ResponseBody
  public ResponseEntity<?> findByAmbiente(@PathVariable String ambiente) {
    return new ResponseEntity<>(
        this.logService.findByAmbiente(ambiente),
        HttpStatus.OK);
  }

  @GetMapping(path = "busca-por-ambiente-e-level/{ambiente}/{level}")
  @ResponseBody
  public ResponseEntity<?> filterByLevel(@PathVariable String ambiente,
      @PathVariable String level) {
    return new ResponseEntity<>(
        this.logService.filterByLevel(ambiente, level),
        HttpStatus.OK);
  }

  @GetMapping(path = "busca-por-ambiente-e-log/{ambiente}/{log}")
  @ResponseBody
  public ResponseEntity<?> filterByLog(@PathVariable String ambiente,
      @PathVariable String log) {
    return new ResponseEntity<>(
        this.logService.filterByLog(ambiente, log),
        HttpStatus.OK);
  }

  @PostMapping(path = "/arquivar/{id}")
  @ResponseBody
  public boolean arquivar(@PathVariable Long id) {
    Log log = logService.findById(id).get();

    if (log != null) {
      log.setArquivar(true);
      logService.save(log);
      return true;
    }
    return false;
  }
}
