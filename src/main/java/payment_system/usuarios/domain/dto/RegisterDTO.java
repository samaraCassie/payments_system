package payment_system.usuarios.domain.dto;

import java.util.List;

public record RegisterDTO(String nome, String email, String senha, List<String> permissoes) {
}
