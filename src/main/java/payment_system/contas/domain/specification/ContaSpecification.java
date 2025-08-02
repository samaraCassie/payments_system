package payment_system.contas.domain.specification;

import jakarta.persistence.criteria.Join;
import jakarta.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;
import payment_system.contas.api.criteria.ContasCriteria;
import payment_system.contas.domain.model.Categoria;
import payment_system.contas.domain.model.Contas;
import payment_system.contas.domain.model.ServicoPagamento;
import payment_system.usuarios.domain.model.Usuario;

import java.util.ArrayList;
import java.util.List;

public class ContaSpecification {

    public static Specification<Contas> filtrar(ContasCriteria criteria) {
        return (root, query, cb) -> {
            List<Predicate> predicates = new ArrayList<>();

            if (criteria.getNomeCategoria() != null) {
                Join<Contas, Categoria> categoriaJoin = root.join("categoria");
                predicates.add(cb.like(cb.lower(categoriaJoin.get("nome")), "%" + criteria.getNomeCategoria().toLowerCase() + "%"));
            }

            if (criteria.getNomeServicoPagamento() != null) {
                Join<Contas, ServicoPagamento> servicoJoin = root.join("servicoPagamento");
                predicates.add(cb.like(cb.lower(servicoJoin.get("nome")), "%" + criteria.getNomeServicoPagamento().toLowerCase() + "%"));
            }

            if (criteria.getEmailUsuario() != null) {
                Join<Contas, Usuario> usuarioJoin = root.join("usuario");
                predicates.add(cb.equal(cb.lower(usuarioJoin.get("email")), criteria.getEmailUsuario().toLowerCase()));
            }

            if (criteria.getStatus() != null) {
                predicates.add(cb.equal(root.get("status"), criteria.getStatus()));
            }

            if (criteria.getDataVencimentoInicial() != null) {
                predicates.add(cb.greaterThanOrEqualTo(root.get("dataVencimento"), criteria.getDataVencimentoInicial()));
            }

            if (criteria.getDataVencimentoFinal() != null) {
                predicates.add(cb.lessThanOrEqualTo(root.get("dataVencimento"), criteria.getDataVencimentoFinal()));
            }

            if (criteria.getDataPagamentoInicial() != null) {
                predicates.add(cb.greaterThanOrEqualTo(root.get("dataPagamento"), criteria.getDataPagamentoInicial()));
            }

            if (criteria.getDataPagamentoFinal() != null) {
                predicates.add(cb.lessThanOrEqualTo(root.get("dataPagamento"), criteria.getDataPagamentoFinal()));
            }

            if (criteria.getValorMinimo() != null) {
                predicates.add(cb.greaterThanOrEqualTo(root.get("valor"), criteria.getValorMinimo()));
            }

            if (criteria.getValorMaximo() != null) {
                predicates.add(cb.lessThanOrEqualTo(root.get("valor"), criteria.getValorMaximo()));
            }

            return cb.and(predicates.toArray(new Predicate[0]));
        };
    }
}