package payment_system.contas.application.usecase;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.multipart.MultipartFile;

import payment_system.contas.api.criteria.CategoriaCriteria;
import payment_system.contas.domain.dto.CategoriaRequestDTO;
import payment_system.contas.domain.dto.CategoriaResponseDTO;

public interface CategoriaUseCase {

    void registrarCategorias(List<CategoriaRequestDTO> categorias);

    void registrarCategoriasViaCsv(MultipartFile file);

    Page<CategoriaResponseDTO> buscarCategorias(CategoriaCriteria filtro, Pageable pageable);
}