package dev.codenation.squad03.central.de.erros.usuario.controller;

import java.net.URI;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import dev.codenation.squad03.central.de.erros.usuario.mapper.UsuarioMapper;
import dev.codenation.squad03.central.de.erros.usuario.model.Response;
import dev.codenation.squad03.central.de.erros.usuario.model.Usuario;
import dev.codenation.squad03.central.de.erros.usuario.model.UsuarioDTO;
import dev.codenation.squad03.central.de.erros.usuario.service.UsuarioService;

/**
 * Classe responsável por controllar(receber e enviar) requisições relacionadas a um usuário na API Central de Erros.
 * 
 * @since 22.08.2019
 * @version 1.0
 *
 */
@RestController
@RequestMapping("/api/central-de-erros/v1/usuario")
public class UsuarioController {

	@Autowired
	private UsuarioService usuarioService;

	@PostMapping
	public ResponseEntity<Response<UsuarioDTO>> salvar(@Valid @RequestBody UsuarioDTO usuarioDTO,
			BindingResult bindingResult) {
		Response<UsuarioDTO> response = new Response<UsuarioDTO>();
		if (bindingResult.hasErrors()) {
			bindingResult.getAllErrors().forEach(e -> response.getErros().add(e.getDefaultMessage()));
			return ResponseEntity.badRequest().body(response);
		} else {
			Usuario usuarioSaved = this.usuarioService.save(UsuarioMapper.contractToImpl(usuarioDTO));
			URI location = ServletUriComponentsBuilder
					.fromCurrentRequest()
					.path("/{id}")
					.buildAndExpand(usuarioSaved.getId())
					.toUri();
			return ResponseEntity.created(location).build();
		}
	}
}
