package dev.codenation.squad03.central.de.erros.usuario.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import dev.codenation.squad03.central.de.erros.usuario.model.Usuario;
import dev.codenation.squad03.central.de.erros.usuario.model.UsuarioDTO;

/**
 * Interface responsável por definir o mapeamento de {@link Usuario} para um
 * {@link UsuarioDTO} e vice-versa na API Central de Erros.
 * 
 * @since 21.09.2019
 * @version 2.0
 */
@Mapper(componentModel = "spring")
public interface UsuarioMapper {

	@Mappings({
		@Mapping(target = "id", source = "usuario.id"),
		@Mapping(target = "email", source = "usuario.email"),
		@Mapping(target = "senha", source = "usuario.senha"),
		@Mapping(target = "token", source = "usuario.token")
	})
	UsuarioDTO usuarioToUsuarioDTO(Usuario usuario);
	
	@Mappings({
		@Mapping(target = "id", source = "usuarioDTO.id"),
		@Mapping(target = "email", source = "usuarioDTO.email"),
		@Mapping(target = "senha", source = "usuarioDTO.senha"),
		@Mapping(target = "token", source = "usuarioDTO.token")
	})
	Usuario usuarioDTOtoUsuario(UsuarioDTO usuarioDTO);
}
