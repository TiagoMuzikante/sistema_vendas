package space.vendas.sistema.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import space.vendas.sistema.domain.Evento;
import space.vendas.sistema.dto.event.EventDTO;
import space.vendas.sistema.service.EventoService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/eventos")
@RequiredArgsConstructor
public class EventController {

  private final EventoService eventService;

  @PostMapping
  public ResponseEntity<Evento> save(@RequestBody EventDTO eventPostDTO){
    return new ResponseEntity<>(eventService.save(eventPostDTO), HttpStatus.CREATED);
  }

  @GetMapping("/{id}")
  public ResponseEntity<Evento> findById(@PathVariable Long id){
    return ResponseEntity.ok(eventService.findById(id));
  }

  @GetMapping
  public ResponseEntity<List<Evento>> findAll(){
    return ResponseEntity.ok(eventService.findAll());
  }

  @PutMapping("/{id}")
  public ResponseEntity<Evento> replace(@PathVariable Long id, @RequestBody EventDTO eventPostDTO){
    return ResponseEntity.ok(eventService.update(id,eventPostDTO));
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> destroy(@PathVariable Long id){
    eventService.destroy(id);
    return null;
  }


}
