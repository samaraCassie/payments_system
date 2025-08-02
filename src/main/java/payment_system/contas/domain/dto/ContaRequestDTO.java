package payment_system.contas.domain.dto;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
public class ContaRequestDTO {
    private LocalDate dataVencimento;
    private LocalDate dataPagamento;
    private BigDecimal valor;
    private String descricao;
    private Integer status;
    private String nomeCategoria;
    private String nomeServicoPagamento;
    private String emailUsuario;
}