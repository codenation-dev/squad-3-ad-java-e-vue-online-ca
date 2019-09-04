package dev.codenation.squad03.central.de.erros.usuario.mapper;

import java.util.List;
import java.util.stream.Collectors;

import dev.codenation.squad03.central.de.erros.usuario.model.Usuario;
import dev.codenation.squad03.central.de.erros.usuario.model.UsuarioDTO;

/**
 * Classe responsável por realizar o mapeamento de usuário na API Central de
 * Erros.
 * 
 * @since 22.08.2019
 * @version 1.0
 */
public class UsuarioMapper {

	public static Usuario contractToImpl(UsuarioDTO usuarioDTO) {
		return Usuario
				.builder()
					.email(usuarioDTO.getEmail())
					.senha(usuarioDTO.getSenha())
				.build();
	}

	public static UsuarioDTO implToContract(Usuario usuario) {
		UsuarioDTO usuarioDTO = new UsuarioDTO();
		usuarioDTO.setId(usuario.getId());
		usuarioDTO.setEmail(usuario.getEmail());
		usuarioDTO.setSenha(usuario.getSenha());
		return usuarioDTO;
	}

	public static List<UsuarioDTO> implToContractList(List<Usuario> usuarios) {
		return usuarios
				.stream()
				.map(usuario -> implToContract(usuario))
				.collect(Collectors.toList());
	}
}
