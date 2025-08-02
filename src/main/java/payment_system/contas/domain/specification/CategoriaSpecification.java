package payment_system.contas.domain.specification;

import jakarta.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;
import payment_system.contas.api.criteria.CategoriaCriteria;
import payment_system.contas.domain.model.Categoria;

import java.util.ArrayList;
import java.util.List;

public class CategoriaSpecification {

    public static Specification<Categoria> filtrar(CategoriaCriteria criteria) {
        return (root, query, cb) -> {
            List<Predicate> predicates = new ArrayList<>();

            if (criteria.getNome() != null && !criteria.getNome().isBlank()) {
                predicates.add(cb.like(cb.lower(root.get("nome")), "%" + criteria.getNome().toLowerCase() + "%"));
            }

            return cb.and(predicates.toArray(new Predicate[0]));
        };
    }
}