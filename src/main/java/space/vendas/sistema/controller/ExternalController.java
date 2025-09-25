package space.vendas.sistema.controller;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class ExternalController {

  @GetMapping
  public ResponseEntity<List<Supplier>> findAll() {
    return ResponseEntity.ok(List.of(
        new Supplier(1,"CARREFOUR COMERCIO E INDUSTRIA LTDA", "45.543.915/0001-81"),
        new Supplier(2,"VAKINHA.COM INSTITUICAO DE PAGAMENTO LTDA", "22.831.673/0001-26"),
        new Supplier(3,"COMPRA SEGURA LTDA - ME", "46.908.518/0001-29")
    ));
  }

}

@Data
@AllArgsConstructor
class Supplier {
  private int id;
  private String name;
  private String cnpj;
}
