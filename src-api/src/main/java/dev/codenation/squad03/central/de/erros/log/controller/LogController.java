package dev.codenation.squad03.central.de.erros.log.controller;

import dev.codenation.squad03.central.de.erros.log.model.Log;
import dev.codenation.squad03.central.de.erros.log.service.LogService;
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

  @GetMapping
  @ResponseBody
  public ResponseEntity<?> findAll() {
    return new ResponseEntity<>(
        this.logService.findAll(),
        HttpStatus.OK);
  }

  @GetMapping(path = "/{id}")
  @ResponseBody
  public ResponseEntity<?> findById(@PathVariable Long id) {
    Optional<Log> optionalLog = this.logService.findById(id);
    return new ResponseEntity<>(optionalLog, HttpStatus.OK);
  }

  @PostMapping
  @ResponseBody
  public ResponseEntity<?> create(@RequestBody Log log) {
    return new ResponseEntity<>(this.logService.save(log), HttpStatus.ACCEPTED);
  }

}
