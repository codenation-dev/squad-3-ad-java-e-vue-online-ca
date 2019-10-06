package dev.codenation.squad03.central.de.erros.log.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

/**
 * Classe que representa um log na API Central de Erros
 *
 * @author Alfredo
 * @version 1.0
 * @since 01.10.2019
 */
@Entity
@Table(name = "log")
@NoArgsConstructor
@AllArgsConstructor
@Data
@EntityListeners(AuditingEntityListener.class)
public class Log implements Serializable {

  private static final long serialVersionUID = 117584739053367855L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column
  @NotNull
  @JsonFormat
  private String level;

  @Column
  @NotNull
  @JsonFormat
  private String log;

  @NotNull
  @JsonFormat
  private Long eventos;

  @Column
  @NotNull
  @JsonFormat
  private String titulo;

  @Column
  @NotNull
  @JsonFormat
  private String detalhes;

  @Column
  @NotNull
  @JsonFormat
  private String ambiente;

  @Column(name = "data_criacao")
  @CreatedDate
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
  private LocalDateTime dataCriacao;

  @Column
  @NotNull
  @JsonFormat
  private Boolean arquivar;

}