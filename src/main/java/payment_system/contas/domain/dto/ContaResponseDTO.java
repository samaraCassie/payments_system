package payment_system.contas.domain.dto;

import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

@Getter
@Builder
public class ContaResponseDTO {
    private UUID contaId;
    private LocalDate dataVencimento;
    private LocalDate dataPagamento;
    private BigDecimal valor;
    private String descricao;
    private Integer status;
    private String nomeCategoria;
    private String nomeServicoPagamento;
    private String emailUsuario;
}