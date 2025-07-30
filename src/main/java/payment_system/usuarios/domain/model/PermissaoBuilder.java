package payment_system.usuarios.domain.model;

import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Getter
@Setter
public class PermissaoBuilder {

    private UUID id;
    private UUID permissaoId;
    private String nome;
    private Set<UsuarioPermissao> usuarioPermissoes = new HashSet<>();

    public PermissaoBuilder id(UUID id) {
        this.id = id;
        return this;
    }

    public PermissaoBuilder permissaoId(UUID permissaoId) {
        this.permissaoId = permissaoId;
        return this;
    }

    public PermissaoBuilder nome(String nome) {
        this.nome = nome;
        return this;
    }

    public PermissaoBuilder usuarioPermissoes(Set<UsuarioPermissao> usuarioPermissoes) {
        this.usuarioPermissoes = usuarioPermissoes;
        return this;
    }

    public Permissao build() {
        return new Permissao(this);
    }
}
