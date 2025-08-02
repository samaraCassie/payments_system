package payment_system.contas.domain.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import payment_system.contas.domain.model.ServicoPagamento;

import java.util.Optional;
import java.util.UUID;

public interface ServicoPagamentoRepository extends JpaRepository<ServicoPagamento, UUID>,JpaSpecificationExecutor<ServicoPagamento> {

    Optional<ServicoPagamento> findByNomeIgnoreCase(String nome);

}