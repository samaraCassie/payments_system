package payment_system.usuarios.application.usecases;

import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import payment_system.usuarios.api.criteria.UsuarioCriteria;
import payment_system.usuarios.domain.dto.UsuarioResponseDTO;;

public interface UsuarioUseCase {

    UsuarioResponseDTO buscarPorUsuarioId(UUID usuarioId);

    Page<UsuarioResponseDTO> buscarUsuario(UsuarioCriteria filtro, Pageable pageable);

}