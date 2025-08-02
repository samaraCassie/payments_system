package payment_system.contas.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import payment_system.contas.domain.model.Contas;

import java.util.UUID;

public interface ContasRepository extends JpaRepository<Contas, UUID> {
}