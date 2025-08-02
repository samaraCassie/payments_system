package payment_system.contas.domain.model;

import lombok.Getter;
import lombok.Setter;
import payment_system.usuarios.domain.model.Usuario;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

@Getter
@Setter
public class ContasBuilder {
    private UUID id;
    private UUID contaId;
    private LocalDate dataVencimento;
    private LocalDate dataPagamento;
    private BigDecimal valor;
    private String descricao;
    private Integer status;
    private Categoria categoria;
    private ServicoPagamento servicoPagamento;
    private Usuario usuario;

    public ContasBuilder id(UUID id) {
        this.id = id;
        return this;
    }

    public ContasBuilder contaId(UUID contaId) {
        this.contaId = contaId;
        return this;
    }

    public ContasBuilder dataVencimento(LocalDate dataVencimento) {
        this.dataVencimento = dataVencimento;
        return this;
    }

    public ContasBuilder dataPagamento(LocalDate dataPagamento) {
        this.dataPagamento = dataPagamento;
        return this;
    }

    public ContasBuilder valor(BigDecimal valor) {
        this.valor = valor;
        return this;
    }

    public ContasBuilder descricao(String descricao) {
        this.descricao = descricao;
        return this;
    }

    public ContasBuilder status(Integer status) {
        this.status = status;
        return this;
    }

    public ContasBuilder categoria(Categoria categoria) {
        this.categoria = categoria;
        return this;
    }

    public ContasBuilder servicoPagamento(ServicoPagamento servicoPagamento) {
        this.servicoPagamento = servicoPagamento;
        return this;
    }

    public ContasBuilder usuario(Usuario usuario) {
        this.usuario = usuario;
        return this;
    }

    public Contas build() {
        return new Contas(this);
    }
}
