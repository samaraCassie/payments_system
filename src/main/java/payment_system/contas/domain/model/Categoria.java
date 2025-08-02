package payment_system.contas.domain.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import jakarta.persistence.Column;
import org.hibernate.annotations.GenericGenerator;

import java.util.UUID;

@Getter
@Entity
@Table(name = "categoria")
public class Categoria {

    @Id
    @GeneratedValue(generator = "uuid4")
    @GenericGenerator(name = "uuid4", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(columnDefinition = "UUID")
    private UUID id;

    @Column(nullable = false, unique = true)
    private UUID categoriaId;

    @Column(nullable = false)
    private String nome;

    public Categoria() {}

    public Categoria(CategoriaBuilder builder) {
        this.id = builder.getId();
        this.categoriaId = builder.getCategoriaId();
        this.nome = builder.getNome();
    }
}