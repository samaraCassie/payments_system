package payment_system.contas.domain.specification;

import jakarta.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;
import payment_system.contas.api.criteria.ServicoPagamentoCriteria;
import payment_system.contas.domain.model.ServicoPagamento;

import java.util.ArrayList;
import java.util.List;

public class ServicoPagamentoSpecification {

    public static Specification<ServicoPagamento> filtrar(ServicoPagamentoCriteria criteria) {
        return (root, query, cb) -> {
            List<Predicate> predicates = new ArrayList<>();

            if (criteria.getServicoPagamentoId() != null) {
                predicates.add(cb.equal(root.get("servicoPagamentoId"), criteria.getServicoPagamentoId()));
            }

            if (criteria.getNome() != null && !criteria.getNome().isBlank()) {
                predicates.add(cb.like(cb.lower(root.get("nome")), "%" + criteria.getNome().toLowerCase() + "%"));
            }

            if (criteria.getDescricao() != null && !criteria.getDescricao().isBlank()) {
                predicates.add(cb.like(cb.lower(root.get("descricao")), "%" + criteria.getDescricao().toLowerCase() + "%"));
            }

            return cb.and(predicates.toArray(new Predicate[0]));
        };
    }
}