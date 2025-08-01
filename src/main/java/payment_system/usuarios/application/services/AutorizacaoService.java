package payment_system.usuarios.application.services;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import payment_system.infra.security.TokenService;
import payment_system.usuarios.domain.dto.AutenticacaoDTO;
import payment_system.usuarios.domain.dto.LoginResponseDTO;
import payment_system.usuarios.domain.dto.RegisterDTO;
import payment_system.usuarios.domain.model.Usuario;
import payment_system.usuarios.domain.model.UsuarioBuilder;
import payment_system.usuarios.domain.model.UsuarioPermissao;
import payment_system.usuarios.domain.model.UsuarioPermissaoBuilder;
import payment_system.usuarios.domain.model.enums.StatusAtividade;
import payment_system.usuarios.domain.repository.PermissaoRepository;
import payment_system.usuarios.domain.repository.UsuarioPermissaoRepository;
import payment_system.usuarios.domain.repository.UsuarioRepository;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Service
public class AutorizacaoService {

    @Autowired private UsuarioRepository usuarioRepository;
    @Autowired private PermissaoRepository permissaoRepository;
    @Autowired private UsuarioPermissaoRepository usuarioPermissaoRepository;
    @Autowired private PasswordEncoder passwordEncoder;
    @Autowired private TokenService tokenService;

    public void registrarUsuario(RegisterDTO dto) {
        if (usuarioRepository.findByEmail(dto.email()) != null) {
            throw new IllegalArgumentException("E-mail já está em uso.");
        }

        Usuario usuario = new UsuarioBuilder()
                .usuarioId(UUID.randomUUID())
                .nome(dto.nome())
                .email(dto.email())
                .senha(passwordEncoder.encode(dto.senha()))
                .statusAtividade(StatusAtividade.ATIVO)
                .build();

        Set<UsuarioPermissao> permissoesDoUsuario = new HashSet<>();

        if (dto.permissoes() != null && !dto.permissoes().isEmpty()) {
            for (String nomePermissao : dto.permissoes()) {
                permissaoRepository.findByNome(nomePermissao).ifPresent(permissao -> {
                    UsuarioPermissao usuarioPermissao = new UsuarioPermissaoBuilder()
                            .usuario(usuario)
                            .permissao(permissao)
                            .build();
                    permissoesDoUsuario.add(usuarioPermissao);
                });
            }
        } else {
            permissaoRepository.findByNome("USUARIO").ifPresent(permissao -> {
                UsuarioPermissao usuarioPermissao = new UsuarioPermissaoBuilder()
                        .usuario(usuario)
                        .permissao(permissao)
                        .build();
                permissoesDoUsuario.add(usuarioPermissao);
            });
        }

        usuario.getUsuarioPermissoes().addAll(permissoesDoUsuario);

        usuarioRepository.save(usuario);
    }

    public LoginResponseDTO autenticar(AutenticacaoDTO dto) {
        Usuario usuario = usuarioRepository.findByEmail(dto.email());
        if (usuario == null || !passwordEncoder.matches(dto.senha(), usuario.getSenha())) {
            throw new IllegalArgumentException("Credenciais inválidas.");
        }

        String token = tokenService.generateToken(usuario);
        return new LoginResponseDTO(token);
    }
}