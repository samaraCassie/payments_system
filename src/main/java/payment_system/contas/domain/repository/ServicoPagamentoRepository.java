package payment_system.contas.domain.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import payment_system.contas.domain.model.ServicoPagamento;

import java.util.Optional;
import java.util.UUID;

public interface ServicoPagamentoRepository extends JpaRepository<ServicoPagamento, UUID> {

    Optional<ServicoPagamento> findByNomeIgnoreCase(String nome);

}