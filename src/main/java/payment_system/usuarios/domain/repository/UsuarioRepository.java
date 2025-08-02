package payment_system.usuarios.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import payment_system.usuarios.domain.model.Usuario;

import java.util.Optional;
import java.util.UUID;

public interface UsuarioRepository extends JpaRepository<Usuario, UUID>, JpaSpecificationExecutor<Usuario> {

    Usuario findByEmail(String email);

    Optional<Usuario> findByUsuarioId(UUID usuarioId);

    Optional<Usuario> findByEmailIgnoreCase(String email);
}