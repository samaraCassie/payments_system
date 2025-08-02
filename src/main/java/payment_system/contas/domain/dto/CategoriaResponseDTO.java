package payment_system.contas.domain.dto;

import java.util.UUID;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class CategoriaResponseDTO {
    private UUID categoriaId;
    private String nome;
}