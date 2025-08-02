package payment_system.contas.api.controller;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import payment_system.contas.application.usecase.ContasUseCase;
import payment_system.contas.domain.dto.ContaRequestDTO;
import payment_system.contas.domain.model.Contas;

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
}