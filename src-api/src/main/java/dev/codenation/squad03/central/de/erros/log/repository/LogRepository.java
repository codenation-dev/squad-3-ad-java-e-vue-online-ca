package dev.codenation.squad03.central.de.erros.log.repository;

import dev.codenation.squad03.central.de.erros.log.model.Log;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Classe que representa um log na API Central de Erros
 *
 * @author Alfredo
 * @version 1.0
 * @since 01.10.2019
 */
@Repository
public interface LogRepository extends JpaRepository<Log, Long> {

}
