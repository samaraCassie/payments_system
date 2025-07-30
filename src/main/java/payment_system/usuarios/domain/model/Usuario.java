package payment_system.usuarios.domain.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Column;

import org.hibernate.annotations.GenericGenerator;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.OneToMany;
import jakarta.persistence.CascadeType;
import payment_system.usuarios.domain.model.enums.StatusAtividade;

@Entity
@Table(name = "usuario")
public class Usuario {

    @Id
    @GeneratedValue(generator = "uuid4")
    @GenericGenerator(name = "uuid4", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(columnDefinition = "UUID")
    private UUID id;

    @Column(name = "usuario_id", nullable = false, unique = true)
    private UUID usuarioId;

    @Column(nullable = false, length = 100)
    private String nome;

    private String email;

    private String senha;

    private Date dataCadastro = new Date();

    @Column(name = "status_atividade", nullable = false)
    private StatusAtividade statusAtividade;

    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<UsuarioPermissao> usuarioPermissoes = new HashSet<>();
}