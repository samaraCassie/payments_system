package payment_system.contas.domain.model;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class ServicoPagamentoBuilder {

    private UUID id;
    private UUID servicoPagamentoId;
    private String nome;
    private String descricao;

    public ServicoPagamentoBuilder id(UUID id) {
        this.id = id;
        return this;
    }

    public ServicoPagamentoBuilder servicoPagamentoId(UUID servicoPagamentoId) {
        this.servicoPagamentoId = servicoPagamentoId;
        return this;
    }

    public ServicoPagamentoBuilder nome(String nome) {
        this.nome = nome;
        return this;
    }

    public ServicoPagamentoBuilder descricao(String descricao) {
        this.descricao = descricao;
        return this;
    }

    public ServicoPagamento build() {
        return new ServicoPagamento(this);
    }
}
