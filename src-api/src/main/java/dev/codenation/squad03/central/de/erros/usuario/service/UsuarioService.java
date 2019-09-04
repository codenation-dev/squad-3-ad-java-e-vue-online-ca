package dev.codenation.squad03.central.de.erros.usuario.service;

import java.util.Optional;

import dev.codenation.squad03.central.de.erros.usuario.model.Usuario;

/**
 * Interface que contém as assinaturas dos serviços relacionados á usuário.
 * 
 * @since 31.08.2019
 * @version 1.0
 *
 */
public interface UsuarioService {

	public Usuario save(Usuario usuario);

	Optional<Usuario> findByEmail(String email);
}
