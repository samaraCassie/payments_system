package payment_system.contas.domain.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ServicoPagamentoRequestDTO {
    private String nome;
    private String descricao;
}