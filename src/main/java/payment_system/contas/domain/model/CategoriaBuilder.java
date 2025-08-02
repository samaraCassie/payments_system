package payment_system.contas.domain.model;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class CategoriaBuilder {

    private UUID id;
    private UUID categoriaId;
    private String nome;

    public CategoriaBuilder id(UUID id) {
        this.id = id;
        return this;
    }

    public CategoriaBuilder categoriaId(UUID categoriaId) {
        this.categoriaId = categoriaId;
        return this;
    }

    public CategoriaBuilder nome(String nome) {
        this.nome = nome;
        return this;
    }

    public Categoria build() {
        return new Categoria(this);
    }
}