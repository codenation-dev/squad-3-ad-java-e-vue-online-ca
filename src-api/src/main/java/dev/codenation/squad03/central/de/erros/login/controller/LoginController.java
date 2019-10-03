package dev.codenation.squad03.central.de.erros.login.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.codenation.squad03.central.de.erros.usuario.mapper.UsuarioMapper;
import dev.codenation.squad03.central.de.erros.usuario.model.Response;
import dev.codenation.squad03.central.de.erros.usuario.model.Usuario;
import dev.codenation.squad03.central.de.erros.usuario.model.UsuarioDTO;
import dev.codenation.squad03.central.de.erros.usuario.service.UsuarioService;

@RestController
@RequestMapping("/api/central-de-erros/v1/login")
public class LoginController {

	@Autowired
	private UsuarioService usuarioService;

	@Autowired
	private UsuarioMapper usuarioMapper;
	
	@PostMapping
	public ResponseEntity<Response<UsuarioDTO>> logar(@Valid @RequestBody UsuarioDTO usuarioDTO, BindingResult bindingResult) {
		Response<UsuarioDTO> response = new Response<UsuarioDTO>();
		if (bindingResult.hasErrors()) {
			bindingResult.getAllErrors().forEach(error -> {
				String fieldName = ((FieldError)error).getField();
				String errorMessage = error.getDefaultMessage();
				response.getErros().put(fieldName, errorMessage);
			});
			return ResponseEntity.badRequest().body(response);
		}
		Usuario usuario = this.usuarioService.logar(this.usuarioMapper.usuarioDTOtoUsuario(usuarioDTO));
		response.setData(this.usuarioMapper.usuarioToUsuarioDTO(usuario));
		return ResponseEntity.ok(response);
	}
}
