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

  @Override
  public List<Log> findByAmbiente(String ambiente) {
    return this.repository.findByAmbiente(ambiente);
  }

  @Override
  public List<Log> filterByLevel(String ambiente, String level) {
    return this.repository.filterByLevel(ambiente, level);
  }

  @Override
  public List<Log> filterByLog(String ambiente, String log) {
    return this.repository.filterByLog(ambiente, log);

  }
}
