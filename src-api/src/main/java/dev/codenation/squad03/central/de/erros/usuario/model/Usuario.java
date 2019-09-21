package dev.codenation.squad03.central.de.erros.usuario.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Classe que representa um usuário na API Central de Erros
 * 
 * @since 18.08.2019
 * @author willian
 * @version 1.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "usuario", uniqueConstraints = @UniqueConstraint(columnNames = { "email" }, name = "uk_email"))
public class Usuario implements Serializable {

	private static final long serialVersionUID = -80372305546386062L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(length = 255, nullable = false)
	private String email;

	@Column(length = 8, nullable = false)
	private String senha;
	
	@Column(length = 255, nullable = false)
	private String token;

	@Column(name = "data_criacao")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataCriacao;

	@Column(name = "data_atualizacao")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataAtualizacao;

	@PrePersist
	public void prePersiste() {
		this.dataCriacao = new Date();
	}

	@PreUpdate
	public void preUpdate() {
		this.dataAtualizacao = new Date();
	}
}
