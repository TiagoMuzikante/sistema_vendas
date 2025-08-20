package space.vendas.sistema.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import space.vendas.sistema.dto.inscription.InscriptionPostDTO;

import java.util.List;

@RequestMapping("api/v1/Inscricoes")
@RestController
@RequiredArgsConstructor
public class InscriptionController {

  private final InscriptionService inscriptionService;

  @PostMapping
  public ResponseEntity<InscriptionPostDTO> save(@ResponseBody InscriptionPostDTO inscriptionPostDTO){
    return new ResponseEntity<>(inscriptionService.save(inscriptionPostDTO), HttpStatus.CREATED);
  }

  @GetMapping("/{id}")
  public ResponseEntity<InscriptionPostDTO> findById(@PathVariable Long id){
    return ResponseEntity.ok(inscriptionService.findById(id));
  }

  @GetMapping
  public ResponseEntity<List<InscriptionPostDTO>> findAll(){
    return ResponseEntity.ok(inscriptionService.findAll());
  }

  @PutMapping("/{id}")
  public ResponseEntity<InscriptionPostDTO> replace(@PathVariable Long id, @RequestBody InscriptionPostDTO inscriptionPostDTO){
    return ResponseEntity.ok(inscriptionService.replace(id, inscriptionPostDTO));
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> destroy(@PathVariable Long id){
    inscriptionService.destroy(id);
  }

}
