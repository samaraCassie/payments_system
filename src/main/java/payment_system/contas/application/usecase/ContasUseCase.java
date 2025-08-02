package payment_system.contas.application.usecase;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import payment_system.contas.domain.dto.ContaRequestDTO;

public interface ContasUseCase {
    void registrarContas(List<ContaRequestDTO> contas);
    void registrarContasViaCsv(MultipartFile file);
}