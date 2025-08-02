package payment_system.contas.domain.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import jakarta.persistence.Column;
import org.hibernate.annotations.GenericGenerator;

import java.util.UUID;

@Getter
@Entity
@Table(name = "servico_pagamento")
public class ServicoPagamento {

    @Id
    @GeneratedValue(generator = "uuid4")
    @GenericGenerator(name = "uuid4", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(columnDefinition = "UUID")
    private UUID id;

    @Column(name = "servico_pagamento_id", nullable = false, unique = true)
    private UUID servicoPagamentoId;

    @Column(nullable = false)
    private String nome;

    @Column(columnDefinition = "TEXT")
    private String descricao;

    public ServicoPagamento() {}

    public ServicoPagamento(ServicoPagamentoBuilder builder) {
        this.id = builder.getId();
        this.servicoPagamentoId = builder.getServicoPagamentoId();
        this.nome = builder.getNome();
        this.descricao = builder.getDescricao();
    }
}
