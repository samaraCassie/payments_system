package payment_system.usuarios.domain.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import payment_system.usuarios.domain.model.Permissao;

import java.util.UUID;

public interface PermissaoRepository extends JpaRepository<Permissao, UUID> {
    Optional<Permissao> findByNome(String nome);
}
