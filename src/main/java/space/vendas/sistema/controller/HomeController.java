package space.vendas.sistema.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

  @GetMapping("/administrativo")
  public String Home(){
    return "administrativo/Home";
  }

  @GetMapping("/teste")
  public String teste(){
    return "teste";
  }
}
