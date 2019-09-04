package dev.codenation.squad03.central.de.erros.usuario.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dev.codenation.squad03.central.de.erros.usuario.model.Usuario;
import dev.codenation.squad03.central.de.erros.usuario.repository.UsuarioRepository;

@Service
public class UsuarioServiceImpl implements UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;

	@Transactional
	@Override
	public Usuario save(Usuario usuario) {
		return this.usuarioRepository.save(usuario);
	}

	@Override
	public Optional<Usuario> findByEmail(String email) {
		return Optional.ofNullable(this.usuarioRepository.findByEmail(email));
	}

}
