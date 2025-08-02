package payment_system.contas.api.criteria;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class ServicoPagamentoCriteria {
    private UUID servicoPagamentoId;
    private String nome;
    private String descricao;
}
