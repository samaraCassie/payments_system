package payment_system.contas.application.usecase;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.multipart.MultipartFile;

import payment_system.contas.api.criteria.ContasCriteria;
import payment_system.contas.domain.dto.ContaRequestDTO;
import payment_system.contas.domain.dto.ContaResponseDTO;

public interface ContasUseCase {
    void registrarContas(List<ContaRequestDTO> contas);
    void registrarContasViaCsv(MultipartFile file);
    Page<ContaResponseDTO> buscarContas(ContasCriteria filtro, Pageable pageable);

}