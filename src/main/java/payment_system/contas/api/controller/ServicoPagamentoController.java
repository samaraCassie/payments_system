package payment_system.contas.api.controller;
import java.util.List;
import java.util.Map;

import org.springdoc.core.annotations.ParameterObject;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import lombok.RequiredArgsConstructor;
import payment_system.contas.api.criteria.ServicoPagamentoCriteria;
import payment_system.contas.application.usecase.ServicosPagamentoUseCase;
import payment_system.contas.domain.dto.ServicoPagamentoRequestDTO;
import payment_system.contas.domain.dto.ServicoPagamentoResponseDTO;

@RestController
@RequestMapping("api/paymentservice")
@RequiredArgsConstructor
public class ServicoPagamentoController {

    private final ServicosPagamentoUseCase useCase;

    @PostMapping("/register")
    public ResponseEntity<Void> registrarServicos(@RequestBody List<ServicoPagamentoRequestDTO> servicos) {
        useCase.registrarServicos(servicos);
        return ResponseEntity.ok().build();
    }

    @PostMapping(value = "/register-csv", consumes = "multipart/form-data")
    public ResponseEntity<?> registrarServicosCsv(@RequestParam("file") MultipartFile file) {
        try {
            useCase.registrarServicosViaCsv(file);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(Map.of("message", e.getMessage()));
        }
    }

    @GetMapping("/list")
    public Page<ServicoPagamentoResponseDTO> listarServicos(
            @ParameterObject @ModelAttribute ServicoPagamentoCriteria filtro,
            @ParameterObject Pageable pageable) {
        return useCase.buscarServicos(filtro, pageable);
    }

}