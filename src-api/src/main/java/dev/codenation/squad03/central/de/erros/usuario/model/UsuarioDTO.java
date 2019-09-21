package dev.codenation.squad03.central.de.erros.usuario.model;

import java.util.Collection;

import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Classe responsável por representar o DTO(Data Transfer Object) de um usuário
 * na API Central de Erros.
 * 
 * @since 22.08.2019
 * @version 1.0
 */
@NoArgsConstructor
@Getter
@Setter
public class UsuarioDTO implements UserDetails {

	private static final long serialVersionUID = 8821614929654353714L;

	@ApiModelProperty(hidden = true)
	private Long id;

	@ApiModelProperty(example = "example@centraldeerros.com", name = "email", required = true)
	@NotEmpty(message = "Email é obrigatório.")
	private String email;

	@ApiModelProperty(example = "12345678", name = "senha", required = true)
	@Length(min = 8, max = 8, message = "Senha precisa ter exatamente 8 caracteres.")
	@NotEmpty(message = "Senha é obrigatório.")
	private String senha;
	
	@ApiModelProperty(hidden = true)
	private String token;

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return null;
	}

	@Override
	public String getPassword() {
		return this.senha;
	}

	@Override
	public String getUsername() {
		return this.email;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}
}
