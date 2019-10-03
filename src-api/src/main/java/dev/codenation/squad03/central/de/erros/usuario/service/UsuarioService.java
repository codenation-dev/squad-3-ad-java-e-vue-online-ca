package dev.codenation.squad03.central.de.erros.usuario.service;

import dev.codenation.squad03.central.de.erros.usuario.model.Usuario;

/**
 * Interface que contém as assinaturas dos serviços relacionados á usuário.
 * 
 * @since 22.09.2019
 * @version 3.0
 *
 */
public interface UsuarioService {

	Usuario save(Usuario usuario);

	Usuario findByEmail(String email);

	Usuario logar(Usuario usuario);
}
