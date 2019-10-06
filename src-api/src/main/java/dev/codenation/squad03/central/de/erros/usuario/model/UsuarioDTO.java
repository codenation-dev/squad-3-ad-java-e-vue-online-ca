package dev.codenation.squad03.central.de.erros.usuario.model;

import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

/**
 * Classe responsável por representar o DTO(Data Transfer Object) de um usuário na API Central de
 * Erros.
 *
 * @version 1.0
 * @since 22.08.2019
 */
@NoArgsConstructor
@Getter
@Setter
public class UsuarioDTO {

  @ApiModelProperty(hidden = true)
  private Long id;

  @ApiModelProperty(example = "example@centraldeerros.com.br", name = "email", required = true)
  @NotEmpty(message = "Email é obrigatório.")
  private String email;

  @ApiModelProperty(example = "12345678", name = "senha", required = true)
  @Length(min = 8, max = 8, message = "Senha precisa ter exatamente 8 caracteres.")
  @NotEmpty(message = "Senha é obrigatório.")
  private String senha;

  @ApiModelProperty(hidden = true)
  private String token;
}
