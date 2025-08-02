package payment_system.contas.application.service;

import lombok.RequiredArgsConstructor;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import payment_system.contas.api.criteria.ServicoPagamentoCriteria;
import payment_system.contas.application.usecase.ServicosPagamentoUseCase;
import payment_system.contas.domain.dto.ServicoPagamentoRequestDTO;
import payment_system.contas.domain.dto.ServicoPagamentoResponseDTO;
import payment_system.contas.domain.model.ServicoPagamento;
import payment_system.contas.domain.model.ServicoPagamentoBuilder;
import payment_system.contas.domain.repository.ServicoPagamentoRepository;
import payment_system.contas.domain.specification.ServicoPagamentoSpecification;
import payment_system.utils.CsvUtil;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ServicosPagamentoAppService implements ServicosPagamentoUseCase {

    private final ServicoPagamentoRepository repository;

    @Override
    public void registrarServicos(List<ServicoPagamentoRequestDTO> servicos) {
        List<ServicoPagamento> entidades = servicos.stream().map(dto ->
                new ServicoPagamentoBuilder()
                        .servicoPagamentoId(UUID.randomUUID())
                        .nome(dto.getNome())
                        .descricao(dto.getDescricao())
                        .build()
        ).toList();

        repository.saveAll(entidades);
    }

    @Override
    public void registrarServicosViaCsv(MultipartFile file) {
        List<String[]> linhas = CsvUtil.lerCsv(file);
        List<ServicoPagamento> entidades = linhas.stream()
                .skip(1)
                .map(coluna -> new ServicoPagamentoBuilder()
                        .servicoPagamentoId(UUID.randomUUID())
                        .nome(coluna[0].trim())
                        .descricao(coluna.length > 1 ? coluna[1].trim() : null)
                        .build())
                .toList();

        repository.saveAll(entidades);
    }

    @Override
    public Page<ServicoPagamentoResponseDTO> buscarServicos(ServicoPagamentoCriteria filtro, Pageable pageable) {
        Specification<ServicoPagamento> spec = ServicoPagamentoSpecification.filtrar(filtro);
        return repository.findAll(spec, pageable).map(servico ->
                ServicoPagamentoResponseDTO.builder()
                        .nome(servico.getNome())
                        .descricao(servico.getDescricao())
                        .build()
        );
    }
}