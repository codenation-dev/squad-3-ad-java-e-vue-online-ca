package dev.codenation.squad03.central.de.erros.usuario.service;

import dev.codenation.squad03.central.de.erros.usuario.model.Usuario;

/**
 * Interface que contém as assinaturas dos serviços relacionados á usuário.
 * 
 * @since 21.09.2019
 * @version 2.0
 *
 */
public interface UsuarioService {

	public Usuario save(Usuario usuario);

	Usuario findByEmail(String email);
}
