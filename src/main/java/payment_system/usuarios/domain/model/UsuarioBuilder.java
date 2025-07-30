package payment_system.usuarios.domain.model;

import lombok.Getter;
import lombok.Setter;
import payment_system.usuarios.domain.model.enums.StatusAtividade;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Getter
@Setter
public class UsuarioBuilder {

    private UUID id;
    private UUID usuarioId;
    private String nome;
    private String email;
    private String senha;
    private Date dataCadastro = new Date();
    private StatusAtividade statusAtividade;
    private Set<UsuarioPermissao> usuarioPermissoes = new HashSet<>();

    public UsuarioBuilder id(UUID id) {
        this.id = id;
        return this;
    }

    public UsuarioBuilder usuarioId(UUID usuarioId) {
        this.usuarioId = usuarioId;
        return this;
    }

    public UsuarioBuilder nome(String nome) {
        this.nome = nome;
        return this;
    }

    public UsuarioBuilder email(String email) {
        this.email = email;
        return this;
    }

    public UsuarioBuilder senha(String senha) {
        this.senha = senha;
        return this;
    }

    public UsuarioBuilder dataCadastro(Date dataCadastro) {
        this.dataCadastro = dataCadastro;
        return this;
    }

    public UsuarioBuilder statusAtividade(StatusAtividade statusAtividade) {
        this.statusAtividade = statusAtividade;
        return this;
    }

    public UsuarioBuilder usuarioPermissoes(Set<UsuarioPermissao> usuarioPermissoes) {
        this.usuarioPermissoes = usuarioPermissoes;
        return this;
    }

    public Usuario build() {
        return new Usuario(this);
    }
}
