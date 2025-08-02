package payment_system.contas.api.controller;

import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import lombok.RequiredArgsConstructor;
import payment_system.contas.application.usecase.CategoriaUseCase;
import payment_system.contas.domain.dto.CategoriaRequestDTO;

@RestController
@RequestMapping("api/category")
@RequiredArgsConstructor
public class CategoriaController {
    private final CategoriaUseCase categoriaUseCase;

    @PostMapping("/register")
    public ResponseEntity<Void> registrarCategorias(@RequestBody List<CategoriaRequestDTO> categorias) {
        categoriaUseCase.registrarCategorias(categorias);
        return ResponseEntity.ok().build();
    }


    @PostMapping(value = "/register-csv", consumes = "multipart/form-data")
    public ResponseEntity<?> registrarCategoriasViaCsv(@RequestParam("file") MultipartFile file) {
        try {
            categoriaUseCase.registrarCategoriasViaCsv(file);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(Map.of("message", e.getMessage()));
        }
    }


}