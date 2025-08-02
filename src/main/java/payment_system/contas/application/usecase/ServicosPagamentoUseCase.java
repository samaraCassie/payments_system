package payment_system.contas.application.usecase;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import payment_system.contas.domain.dto.ServicoPagamentoRequestDTO;

public interface ServicosPagamentoUseCase {

    void registrarServicos(List<ServicoPagamentoRequestDTO> servicos);
    void registrarServicosViaCsv(MultipartFile file);
}