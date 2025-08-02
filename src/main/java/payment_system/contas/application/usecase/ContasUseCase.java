package payment_system.contas.application.usecase;

import java.util.List;

import payment_system.contas.domain.dto.ContaRequestDTO;

public interface ContasUseCase {
    void registrarContas(List<ContaRequestDTO> contas);
}