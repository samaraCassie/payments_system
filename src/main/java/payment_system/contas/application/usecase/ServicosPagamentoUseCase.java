package payment_system.contas.application.usecase;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.multipart.MultipartFile;

import payment_system.contas.api.criteria.ServicoPagamentoCriteria;
import payment_system.contas.domain.dto.ServicoPagamentoRequestDTO;
import payment_system.contas.domain.dto.ServicoPagamentoResponseDTO;

public interface ServicosPagamentoUseCase {

    void registrarServicos(List<ServicoPagamentoRequestDTO> servicos);
    void registrarServicosViaCsv(MultipartFile file);
    Page<ServicoPagamentoResponseDTO> buscarServicos(ServicoPagamentoCriteria filtro, Pageable pageable);
}