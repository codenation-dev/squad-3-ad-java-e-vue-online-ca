package dev.codenation.squad03.central.de.erros.usuario.repository;

import dev.codenation.squad03.central.de.erros.usuario.model.Usuario;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

  Usuario findByEmail(String email);

  Optional<Usuario> findById(Long id);
}
