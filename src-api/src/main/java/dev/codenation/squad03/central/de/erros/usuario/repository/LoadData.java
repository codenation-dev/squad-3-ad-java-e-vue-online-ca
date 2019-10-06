package dev.codenation.squad03.central.de.erros.usuario.repository;

import dev.codenation.squad03.central.de.erros.usuario.model.Usuario;
import java.util.Date;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @version 1.0 Classe responsável por inserir o usuário admin durante inicialização do servidor
 * @since 24.09.2019
 */
@Configuration
@Slf4j
public class LoadData {

  @Bean
  public CommandLineRunner inserirAdministradorNoBancoDeDados(UsuarioRepository usuarioRepository) {
    return args -> {
      usuarioRepository
          .save(new Usuario(null, "administrador@centraldeerros.com.br", "12345678", new Date(),
              null));
      log.info("Administrador inserido com sucesso.");
    };
  }
}
