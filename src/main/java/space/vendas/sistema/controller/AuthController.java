package space.vendas.sistema.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import space.vendas.sistema.config.JwtUtil;
import space.vendas.sistema.dto.auth.AuthDTO;
import space.vendas.sistema.service.UserService;

import java.util.Map;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/auth")
public class AuthController {

  private final UserService service;
  private final JwtUtil jwtUtil;

  @PostMapping("/login")
  public ResponseEntity<Map<String, String>> login(@RequestBody @Valid AuthDTO dto){
    if(service.autenticar(dto.getEmail(), dto.getSenha())){
      String token = jwtUtil.tokenGenerator(dto.getEmail());
      return ResponseEntity.ok(Map.of("token", token));
    }
    return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(Map.of("Error", "Credenciais invalidas"));
  }

}
