package payment_system.contas.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import payment_system.usuarios.domain.model.UsuarioPermissao;

import java.util.UUID;

public interface UsuarioPermissaoRepository extends JpaRepository<UsuarioPermissao, UUID> {
}
