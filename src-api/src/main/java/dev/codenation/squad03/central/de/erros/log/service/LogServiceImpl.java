package dev.codenation.squad03.central.de.erros.log.service;

import dev.codenation.squad03.central.de.erros.log.model.Log;
import dev.codenation.squad03.central.de.erros.log.repository.LogRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Classe que representa um log na API Central de Erros
 *
 * @author Alfredo
 * @version 1.0
 * @since 01.10.2019
 */
@Service
public class LogServiceImpl implements LogService {

  @Autowired
  private LogRepository repository;

  public List<Log> findAll() {
    return this.repository.findAll();
  }

  @Override
  public Optional<Log> findById(Long id) {
    return this.repository.findById(id);
  }

  @Override
  public Log save(Log log) {
    return this.repository.save(log);
  }
}
