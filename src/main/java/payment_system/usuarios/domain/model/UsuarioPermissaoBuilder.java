package payment_system.usuarios.domain.model;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class UsuarioPermissaoBuilder {

    private Usuario usuario;
    private Permissao permissao;
    private Date dataAtribuicao = new Date();

    public UsuarioPermissaoBuilder usuario(Usuario usuario) {
        this.usuario = usuario;
        return this;
    }

    public UsuarioPermissaoBuilder permissao(Permissao permissao) {
        this.permissao = permissao;
        return this;
    }

    public UsuarioPermissaoBuilder dataAtribuicao(Date dataAtribuicao) {
        this.dataAtribuicao = dataAtribuicao;
        return this;
    }

    public UsuarioPermissao build() {
        return new UsuarioPermissao(this);
    }
}