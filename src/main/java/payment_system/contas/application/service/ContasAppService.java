package payment_system.contas.application.service;

import lombok.RequiredArgsConstructor;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import payment_system.contas.api.criteria.ContasCriteria;
import payment_system.contas.application.usecase.ContasUseCase;
import payment_system.contas.domain.dto.ContaRequestDTO;
import payment_system.contas.domain.dto.ContaResponseDTO;
import payment_system.contas.domain.model.Categoria;
import payment_system.contas.domain.model.Contas;
import payment_system.usuarios.domain.model.Usuario;
import payment_system.contas.domain.model.ContasBuilder;
import payment_system.contas.domain.model.ServicoPagamento;
import payment_system.contas.domain.repository.CategoriaRepository;
import payment_system.contas.domain.repository.ContasRepository;
import payment_system.contas.domain.repository.ServicoPagamentoRepository;
import payment_system.contas.domain.specification.ContaSpecification;
import payment_system.usuarios.domain.repository.UsuarioRepository;
import payment_system.utils.CsvUtil;
import payment_system.utils.MessageUtil;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ContasAppService implements ContasUseCase {

    private final ContasRepository repository;
    private final CategoriaRepository categoriaRepository;
    private final ServicoPagamentoRepository servicoPagamentoRepository;
    private final UsuarioRepository usuarioRepository;

    @Override
    public void registrarContas(List<ContaRequestDTO> contasDto) {
        List<Contas> contas = contasDto.stream().map(dto -> {
            Categoria categoria = categoriaRepository.findByNomeIgnoreCase(dto.getNomeCategoria())
                    .orElseThrow(() -> new RuntimeException(MessageUtil.erroCategoriaNaoEncontrada(dto.getNomeCategoria())));

            ServicoPagamento servico = servicoPagamentoRepository.findByNomeIgnoreCase(dto.getNomeServicoPagamento())
                    .orElseThrow(() -> new RuntimeException(MessageUtil.erroServicoNaoEncontrado(dto.getNomeServicoPagamento())));

            Usuario usuario = usuarioRepository.findByEmailIgnoreCase(dto.getEmailUsuario())
                    .orElseThrow(() -> new RuntimeException(MessageUtil.erroUsuarioNaoEncontrado(dto.getEmailUsuario())));

            return new ContasBuilder()
                    .contaId(UUID.randomUUID())
                    .dataVencimento(dto.getDataVencimento())
                    .dataPagamento(dto.getDataPagamento())
                    .valor(dto.getValor())
                    .descricao(dto.getDescricao())
                    .status(dto.getStatus())
                    .categoria(categoria)
                    .servicoPagamento(servico)
                    .usuario(usuario)
                    .build();
        }).toList();

        repository.saveAll(contas);
    }

    @Override
    public void registrarContasViaCsv(MultipartFile file) {
        List<String[]> linhas = CsvUtil.lerCsv(file);

        List<Contas> contas = linhas.stream()
                .skip(1)
                .map(colunas -> {
                    if (colunas.length < 7) {
                        throw new RuntimeException("Linha do CSV com número de colunas inválido. Esperado: 7. Recebido: " + colunas.length);
                    }

                    Categoria categoria = categoriaRepository.findByNomeIgnoreCase(colunas[5].trim())
                            .orElseThrow(() -> new RuntimeException(MessageUtil.erroCategoriaNaoEncontrada(colunas[5].trim())));

                    ServicoPagamento servico = servicoPagamentoRepository.findByNomeIgnoreCase(colunas[6].trim())
                            .orElseThrow(() -> new RuntimeException(MessageUtil.erroServicoNaoEncontrado(colunas[6].trim())));

                    Usuario usuario = usuarioRepository.findByEmailIgnoreCase(colunas[7].trim())
                            .orElseThrow(() -> new RuntimeException(MessageUtil.erroUsuarioNaoEncontrado(colunas[7].trim())));

                    return new ContasBuilder()
                            .contaId(UUID.randomUUID())
                            .dataVencimento(LocalDate.parse(colunas[0].trim()))
                            .dataPagamento(LocalDate.parse(colunas[1].trim()))
                            .valor(new BigDecimal(colunas[2].trim()))
                            .descricao(colunas[3].trim())
                            .status(Integer.parseInt(colunas[4].trim()))
                            .categoria(categoria)
                            .servicoPagamento(servico)
                            .usuario(usuario)
                            .build();
                }).toList();

        repository.saveAll(contas);
    }

    @Override
    public Page<ContaResponseDTO> buscarContas(ContasCriteria filtro, Pageable pageable) {
        Specification<Contas> spec = ContaSpecification.filtrar(filtro);
        return repository.findAll(spec, pageable).map(conta ->
                ContaResponseDTO.builder()
                        .contaId(conta.getContaId())
                        .dataVencimento(conta.getDataVencimento())
                        .dataPagamento(conta.getDataPagamento())
                        .valor(conta.getValor())
                        .descricao(conta.getDescricao())
                        .status(conta.getStatus())
                        .nomeCategoria(conta.getCategoria().getNome())
                        .nomeServicoPagamento(conta.getServicoPagamento().getNome())
                        .emailUsuario(conta.getUsuario().getEmail())
                        .build()
        );
    }

}