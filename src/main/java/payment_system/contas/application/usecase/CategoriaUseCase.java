package payment_system.contas.application.usecase;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import payment_system.contas.domain.dto.CategoriaRequestDTO;

public interface CategoriaUseCase {

    void registrarCategorias(List<CategoriaRequestDTO> categorias);

    void registrarCategoriasViaCsv(MultipartFile file);
}