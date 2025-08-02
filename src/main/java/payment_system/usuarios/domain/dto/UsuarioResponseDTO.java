package payment_system.usuarios.domain.dto;

import lombok.Builder;
import lombok.Getter;
import payment_system.usuarios.domain.model.enums.StatusAtividade;

import java.util.Date;
import java.util.UUID;

@Getter
@Builder
public class UsuarioResponseDTO {
    private UUID usuarioId;
    private String nome;
    private String email;
    private StatusAtividade status;
    private Date dataCadastro;
}
