package payment_system.usuarios.domain.model;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Column;
import jakarta.persistence.IdClass;
import jakarta.persistence.FetchType;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;


@Getter
@Entity
@Table(name = "usuario_permissao")
@IdClass(UsuarioPermissaoId.class)
public class UsuarioPermissao {

    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "permissao_id")
    private Permissao permissao;

    @Column(name = "data_atribuicao", nullable = false, updatable = false)
    private Date dataAtribuicao = new Date();

    public UsuarioPermissao() {
    }

    public UsuarioPermissao(UsuarioPermissaoBuilder builder) {
        this.usuario = builder.getUsuario();
        this.permissao = builder.getPermissao();
        this.dataAtribuicao = builder.getDataAtribuicao();
    }
}