package space.vendas.sistema.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import space.vendas.sistema.dto.auth.AuthDTO;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/auth")
public class AuthController {

  @PostMapping("/login")
  public void login(@RequestBody AuthDTO dto){

  }

}
