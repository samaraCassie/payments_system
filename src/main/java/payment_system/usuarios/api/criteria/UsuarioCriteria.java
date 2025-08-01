package payment_system.usuarios.api.criteria;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;
import payment_system.usuarios.domain.model.enums.StatusAtividade;

@Getter
@Setter
public class UsuarioCriteria {
    private String nome;
    private String email;
    private StatusAtividade status;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private Date dataCadastroInicial;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private Date dataCadastroFinal;
}