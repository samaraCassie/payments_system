package payment_system.contas.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import payment_system.contas.domain.model.Categoria;

import java.util.Optional;
import java.util.UUID;

public interface CategoriaRepository extends JpaRepository<Categoria, UUID> {

    Optional<Categoria> findByNomeIgnoreCase(String nome);

}