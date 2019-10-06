package dev.codenation.squad03.central.de.erros.usuario.service;

import dev.codenation.squad03.central.de.erros.usuario.model.Usuario;
import java.util.Optional;

/**
 * Interface que contém as assinaturas dos serviços relacionados á usuário.
 *
 * @version 3.0
 * @since 22.09.2019
 */
public interface UsuarioService {

  Usuario save(Usuario usuario);

  Usuario findByEmail(String email);

  Usuario logar(Usuario usuario);

  Optional<Usuario> findById(Long id);
}
