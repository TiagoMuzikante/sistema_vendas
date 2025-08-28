package space.vendas.sistema.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import space.vendas.sistema.domain.Inscription;
import space.vendas.sistema.dto.inscription.InscriptionPostDTO;
import space.vendas.sistema.dto.inscription.InscriptionSimple;
import space.vendas.sistema.service.InscriptionService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/inscricoes")
@RequiredArgsConstructor
public class InscriptionController {

  private final InscriptionService inscriptionService;

  @PostMapping
  public ResponseEntity<InscriptionSimple> save(@RequestBody InscriptionPostDTO inscriptionPostDTO){
    return new ResponseEntity<>(inscriptionService.save(inscriptionPostDTO), HttpStatus.CREATED);
  }

  @GetMapping("/{id}")
  public ResponseEntity<InscriptionSimple> findById(@PathVariable Long id){
    return ResponseEntity.ok(inscriptionService.findById(id));
  }

  @GetMapping
  public ResponseEntity<List<InscriptionSimple>> findAll(){
    return ResponseEntity.ok(inscriptionService.findAll());
  }

  @PutMapping("/{id}")
  public ResponseEntity<InscriptionSimple> replace(@PathVariable Long id, @RequestBody InscriptionPostDTO inscriptionPostDTO){
    return ResponseEntity.ok(inscriptionService.update(id, inscriptionPostDTO));
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> destroy(@PathVariable Long id){
    inscriptionService.destroy(id);
    return null;
  }

}
