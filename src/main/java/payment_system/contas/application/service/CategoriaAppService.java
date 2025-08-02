package payment_system.contas.application.service;

import lombok.RequiredArgsConstructor;
import payment_system.contas.application.usecase.CategoriaUseCase;
import payment_system.contas.domain.dto.CategoriaRequestDTO;
import payment_system.contas.domain.model.Categoria;
import payment_system.contas.domain.model.CategoriaBuilder;
import payment_system.contas.domain.repository.CategoriaRepository;
import payment_system.utils.CsvUtil;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
@RequiredArgsConstructor
public class CategoriaAppService implements CategoriaUseCase {

    private final CategoriaRepository categoriaRepository;

    @Override
    public void registrarCategorias(List<CategoriaRequestDTO> categorias) {
        List<Categoria> entidades = categorias.stream().map(dto -> new CategoriaBuilder()
                .categoriaId(UUID.randomUUID())
                .nome(dto.getNome())
                .build()).toList();

        categoriaRepository.saveAll(entidades);
    }

    @Override
    public void registrarCategoriasViaCsv(MultipartFile file) {
        List<String[]> linhas = CsvUtil.lerCsv(file);
        List<Categoria> categorias = linhas.stream()
                .skip(1)
                .map(colunas -> new CategoriaBuilder()
                        .categoriaId(UUID.randomUUID())
                        .nome(colunas[0].trim())
                        .build())
                .toList();

        categoriaRepository.saveAll(categorias);
    }
}