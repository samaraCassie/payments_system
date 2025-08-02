package payment_system.contas.api.criteria;

import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
public class ContasCriteria {

    private String nomeCategoria;
    private String nomeServicoPagamento;
    private String emailUsuario;
    private Integer status;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate dataVencimentoInicial;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate dataVencimentoFinal;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate dataPagamentoInicial;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate dataPagamentoFinal;

    private BigDecimal valorMinimo;
    private BigDecimal valorMaximo;
}