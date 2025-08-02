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
import payment_system.contas.application.usecase.ContasUseCase;
import payment_system.contas.domain.dto.ContaRequestDTO;

@RestController
@RequestMapping("api/paymentaccounts")
@RequiredArgsConstructor
public class ContasController {

    private final ContasUseCase useCase;

    @PostMapping("/register")
    public ResponseEntity<Void> registrarContas(@RequestBody List<ContaRequestDTO> contas) {
        useCase.registrarContas(contas);
        return ResponseEntity.ok().build();
    }

    @PostMapping(value = "/register-csv", consumes = "multipart/form-data")
    public ResponseEntity<?> registrarContasCsv(@RequestParam("file") MultipartFile file) {
        try {
            useCase.registrarContasViaCsv(file);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(Map.of("message", e.getMessage()));
        }
    }
}