package payment_system.usuarios.domain.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import payment_system.usuarios.domain.model.Usuario;

import java.util.UUID;
public interface UsuarioRepository extends JpaRepository<Usuario, UUID>{
    Usuario findByEmail(String email);
}
