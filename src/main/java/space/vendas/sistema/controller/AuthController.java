package space.vendas.sistema.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/auth")
public class AuthController {

  @GetMapping("/login")
  public ResponseEntity<Void> login(){
    return ResponseEntity.noContent().build();
  }

  @GetMapping("/ping")
  public ResponseEntity<String> ping(){
    return ResponseEntity.ok("pong");
  }

  @PostMapping("/nome")
  public ResponseEntity<String> nome(){
    return ResponseEntity.ok("nome");
  }

}
