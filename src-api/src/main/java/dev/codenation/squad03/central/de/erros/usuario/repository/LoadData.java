package dev.codenation.squad03.central.de.erros.usuario.repository;

import java.util.Date;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import dev.codenation.squad03.central.de.erros.usuario.model.Usuario;
import lombok.extern.slf4j.Slf4j;

/**
 * 
 * @since 24.09.2019
 * @version 1.0 
 * Classe responsável por inserir o usuário admin durante
 *          inicialização do servidor
 *
 */
@Configuration
@Slf4j
public class LoadData {

	@Bean
	public CommandLineRunner inserirAdministradorNoBancoDeDados(UsuarioRepository usuarioRepository) {
		return args -> {
			usuarioRepository
					.save(new Usuario(null, "administrador@centraldeerros.com.br", "12345678", null, new Date(), null));
			log.info("Administrador inserido com sucesso.");
		};
	}
}
