package payment_system.usuarios.api.controller;

import java.util.UUID;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import payment_system.usuarios.api.criteria.UsuarioCriteria;
import payment_system.usuarios.application.usecases.UsuarioUseCase;

import payment_system.usuarios.domain.model.Usuario;

@RestController
@RequestMapping("api/user")
@RequiredArgsConstructor
public class UsuarioController {

    private final UsuarioUseCase usuarioUseCase;

    @GetMapping("/{usuarioId}")
    public ResponseEntity<Usuario> buscarPorId(@PathVariable UUID usuarioId) {
        Usuario usuario = usuarioUseCase.buscarPorUsuarioId(usuarioId);
        return ResponseEntity.ok(usuario);
    }

    @GetMapping("/list")
    public Page<Usuario> listarUsuariosComFiltros(
            @ParameterObject @ModelAttribute UsuarioCriteria filtro,
            @ParameterObject Pageable pageable) {
        return usuarioUseCase.buscarUsuario(filtro, pageable);
    }
}