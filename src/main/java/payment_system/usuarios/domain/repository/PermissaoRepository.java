package payment_system.usuarios.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import payment_system.usuarios.domain.model.Permissao;

import java.util.UUID;

public interface PermissaoRepository extends JpaRepository<Permissao, UUID> {
}
