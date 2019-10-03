package dev.codenation.squad03.central.de.erros.log.service;

/**
 * Classe que representa um log na API Central de Erros
 *
 * @author Alfredo
 * @version 1.0
 * @since 01.10.2019
 */

import dev.codenation.squad03.central.de.erros.log.model.Log;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public interface LogService {

  public List<Log> findAll();

  public Optional<Log> findById(Long id);

  public Log save(Log log);
}