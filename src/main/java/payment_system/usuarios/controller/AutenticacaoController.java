package payment_system.usuarios.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import payment_system.usuarios.domain.dto.LoginResponseDTO;
import payment_system.usuarios.domain.dto.RegisterDTO;
import payment_system.usuarios.services.AutorizacaoService;

@RestController
@RequestMapping("/auth")
public class AutenticacaoController {

    @Autowired private AutorizacaoService autorizacaoService;

    @PostMapping("/register")
    public ResponseEntity<?> registrar(@RequestBody RegisterDTO dto) {
        autenticacaoService.registrarUsuario(dto);
        return ResponseEntity.ok("Usuário registrado com sucesso.");
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponseDTO> login(@RequestBody AutorizacaoService dto) {
        return ResponseEntity.ok(autenticacaoService.autenticar(dto));
    }
}