package payment_system.contas.application.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import payment_system.contas.application.usecase.ContasUseCase;
import payment_system.contas.domain.dto.ContaRequestDTO;
import payment_system.contas.domain.model.Categoria;
import payment_system.contas.domain.model.Contas;
import payment_system.usuarios.domain.model.Usuario;
import payment_system.contas.domain.model.ContasBuilder;
import payment_system.contas.domain.model.ServicoPagamento;
import payment_system.contas.domain.repository.CategoriaRepository;
import payment_system.contas.domain.repository.ContasRepository;
import payment_system.contas.domain.repository.ServicoPagamentoRepository;
import payment_system.usuarios.domain.repository.UsuarioRepository;
import payment_system.utils.MessageUtil;

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
}