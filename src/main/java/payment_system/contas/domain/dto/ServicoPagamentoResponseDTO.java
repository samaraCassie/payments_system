package payment_system.contas.domain.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ServicoPagamentoResponseDTO {
    private String nome;
    private String descricao;
}