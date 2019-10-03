package dev.codenation.squad03.central.de.erros.usuario.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import dev.codenation.squad03.central.de.erros.log.model.Log;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * Classe que representa um usuário na API Central de Erros
 *
 * @author willian
 * @version 1.0
 * @since 18.08.2019
 */
@Data
@NoArgsConstructor
@Entity
@Table(name = "usuario", uniqueConstraints = @UniqueConstraint(columnNames = {
    "email"}, name = "uk_email"))
public class Usuario implements Serializable, UserDetails {

  private static final long serialVersionUID = -80372305546386062L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(length = 255, nullable = false)
  private String email;

  @Column(length = 255, nullable = false)
  private String senha;

  @Column(length = 255, nullable = true)
  private String token;

  @Column(name = "data_criacao")
  @Temporal(TemporalType.TIMESTAMP)
  private Date dataCriacao;

  @Column(name = "data_atualizacao")
  @Temporal(TemporalType.TIMESTAMP)
  private Date dataAtualizacao;

  @JsonIgnore
  @OneToMany(mappedBy = "usuario")
  private List<Log> logs;

  public Usuario(Long id, String email, String senha, String token, Date dataCriacao,
      Date dataAtualizacao) {
    this.id = id;
    this.email = email;
    this.senha = senha;
    this.token = token;
    this.dataCriacao = dataCriacao;
    this.dataAtualizacao = dataAtualizacao;
  }

  @ApiModelProperty(hidden = true)
  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    return null;
  }

  @ApiModelProperty(hidden = true)
  @Override
  public String getPassword() {
    return this.senha;
  }

  @ApiModelProperty(hidden = true)
  @Override
  public String getUsername() {
    return this.email;
  }

  @ApiModelProperty(hidden = true)
  @Override
  public boolean isAccountNonExpired() {
    return true;
  }

  @ApiModelProperty(hidden = true)
  @Override
  public boolean isAccountNonLocked() {
    return true;
  }

  @ApiModelProperty(hidden = true)
  @Override
  public boolean isCredentialsNonExpired() {
    return true;
  }

  @ApiModelProperty(hidden = true)
  @Override
  public boolean isEnabled() {
    return true;
  }

  @PrePersist
  public void prePersiste() {
    this.dataCriacao = new Date();
  }

  @PreUpdate
  public void preUpdate() {
    this.dataAtualizacao = new Date();
  }

}
