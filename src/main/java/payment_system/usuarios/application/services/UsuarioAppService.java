package payment_system.usuarios.application.services;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import payment_system.usuarios.api.criteria.UsuarioCriteria;
import payment_system.usuarios.application.usecases.UsuarioUseCase;
import payment_system.usuarios.domain.model.Usuario;
import payment_system.usuarios.domain.repository.UsuarioRepository;
import payment_system.usuarios.domain.specification.UsuarioSpecification;

@Service
@RequiredArgsConstructor
public class UsuarioAppService implements UsuarioUseCase {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public Page<Usuario> buscarUsuario(UsuarioCriteria filtro, Pageable pageable) {
        Specification<Usuario> spec = UsuarioSpecification.filtrar(filtro);
        return usuarioRepository.findAll(spec, pageable);
    }

    @Override
    public Usuario buscarPorUsuarioId(UUID usuarioId) {
        return usuarioRepository.findByUsuarioId(usuarioId)
                .orElseThrow(() -> new EntityNotFoundException("Usuário não encontrado com usuarioId: " + usuarioId));
    }
}