package payment_system.usuarios.domain.specification;

import jakarta.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;
import payment_system.usuarios.api.criteria.UsuarioCriteria;
import payment_system.usuarios.domain.model.Usuario;

import java.util.ArrayList;
import java.util.List;

public class UsuarioSpecification {

    public static Specification<Usuario> filtrar(UsuarioCriteria criteria) {
        return (root, query, cb) -> {
            List<Predicate> predicates = new ArrayList<>();

            if (criteria.getNome() != null && !criteria.getNome().isBlank()) {
                predicates.add(cb.like(cb.lower(root.get("nome")), "%" + criteria.getNome().toLowerCase() + "%"));
            }

            if (criteria.getEmail() != null && !criteria.getEmail().isBlank()) {
                predicates.add(cb.equal(cb.lower(root.get("email")), criteria.getEmail().toLowerCase()));
            }

            if (criteria.getStatus() != null) {
                predicates.add(cb.equal(root.get("statusAtividade"), criteria.getStatus()));
            }

            if (criteria.getDataCadastroInicial() != null) {
                predicates.add(cb.greaterThanOrEqualTo(root.get("dataCadastro"), criteria.getDataCadastroInicial()));
            }

            if (criteria.getDataCadastroFinal() != null) {
                predicates.add(cb.lessThanOrEqualTo(root.get("dataCadastro"), criteria.getDataCadastroFinal()));
            }

            return cb.and(predicates.toArray(new Predicate[0]));
        };
    }
}