package payment_system.usuarios.domain.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Column;
import lombok.Getter;
import org.hibernate.annotations.GenericGenerator;

import jakarta.persistence.CascadeType;
import jakarta.persistence.OneToMany;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Getter
@Entity
@Table(name = "permissao")
public class Permissao {

    @Id
    @GeneratedValue(generator = "uuid4")
    @GenericGenerator(name = "uuid4", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(columnDefinition = "UUID")
    private UUID id;

    @Column(name = "permissao_id", nullable = false, unique = true)
    private UUID permissaoId;

    @Column(nullable = false, length = 100)
    private String nome;

    @OneToMany(mappedBy = "permissao", cascade = CascadeType.ALL)
    private Set<UsuarioPermissao> usuarioPermissoes = new HashSet<>();

    public Permissao() {
    }

    public Permissao(PermissaoBuilder builder) {
        this.id = builder.getId();
        this.permissaoId = builder.getPermissaoId();
        this.nome = builder.getNome();
        this.usuarioPermissoes = builder.getUsuarioPermissoes();
    }
}
