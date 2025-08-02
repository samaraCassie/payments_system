package payment_system.contas.domain.model;

import jakarta.persistence.*;
import lombok.Getter;
import payment_system.usuarios.domain.model.Usuario;

import org.hibernate.annotations.GenericGenerator;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

@Getter
@Entity
@Table(name = "conta")
public class Contas {

    @Id
    @GeneratedValue(generator = "uuid4")
    @GenericGenerator(name = "uuid4", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(columnDefinition = "UUID")
    private UUID id;

    @Column(name = "conta_id", nullable = false, unique = true)
    private UUID contaId;

    @Column(name = "data_vencimento", nullable = false)
    private LocalDate dataVencimento;

    @Column(name = "data_pagamento")
    private LocalDate dataPagamento;

    @Column(nullable = false, precision = 12, scale = 2)
    private BigDecimal valor;

    @Column(columnDefinition = "TEXT")
    private String descricao;

    @Column(nullable = false)
    private Integer status;

    @ManyToOne
    @JoinColumn(name = "categoria_id", referencedColumnName = "id")
    private Categoria categoria;

    @ManyToOne
    @JoinColumn(name = "servico_pagamento_id", referencedColumnName = "id")
    private ServicoPagamento servicoPagamento;

    @ManyToOne
    @JoinColumn(name = "usuario_id", referencedColumnName = "id")
    private Usuario usuario;

    public Contas() {}

    public Contas(ContasBuilder builder) {
        this.id = builder.getId();
        this.contaId = builder.getContaId();
        this.dataVencimento = builder.getDataVencimento();
        this.dataPagamento = builder.getDataPagamento();
        this.valor = builder.getValor();
        this.descricao = builder.getDescricao();
        this.status = builder.getStatus();
        this.categoria = builder.getCategoria();
        this.servicoPagamento = builder.getServicoPagamento();
        this.usuario = builder.getUsuario();
    }
}