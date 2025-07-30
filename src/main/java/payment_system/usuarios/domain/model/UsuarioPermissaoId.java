package payment_system.usuarios.domain.model;

import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.util.UUID;

@Embeddable
public class UsuarioPermissaoId implements Serializable {

    private UUID usuario;
    private UUID permissao;

    public UsuarioPermissaoId() {}

    public UsuarioPermissaoId(UUID usuario, UUID permissao) {
        this.usuario = usuario;
        this.permissao = permissao;
    }

    //TODO: Ajustar equals() e hashCode()
}