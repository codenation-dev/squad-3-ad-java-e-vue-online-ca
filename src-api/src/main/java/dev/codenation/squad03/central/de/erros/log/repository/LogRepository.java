package dev.codenation.squad03.central.de.erros.log.repository;

import dev.codenation.squad03.central.de.erros.log.model.Log;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
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

  List<Log> findByAmbiente(String ambiente);

  @Query("FROM Log l WHERE l.ambiente = :e AND l.level like %:q%")
  List<Log> filterByLevel(@Param("e") String ambiente, @Param("q") String search);

  @Query("FROM Log l WHERE l.ambiente = :e AND l.log like %:q%")
  List<Log> filterByLog(@Param("e") String ambiente, @Param("q") String search);

}