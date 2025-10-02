package space.vendas.sistema.controller;

import jakarta.validation.Valid;
import jakarta.websocket.server.PathParam;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import space.vendas.sistema.domain.Evento;
import space.vendas.sistema.dto.event.EventDTO;
import space.vendas.sistema.service.EventoService;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/v1/eventos")
@RequiredArgsConstructor
@Validated
@Log4j2
public class EventController {

  private final EventoService eventService;

  @PostMapping
  public ResponseEntity<Evento> save(@RequestBody @Valid EventDTO eventPostDTO){
    return new ResponseEntity<>(eventService.save(eventPostDTO), HttpStatus.CREATED);
  }

  @GetMapping("/{id}")
  public ResponseEntity<Evento> findById(@PathVariable Long id){
    return ResponseEntity.ok(eventService.findById(id));
  }

  @GetMapping("/por-datas")
  public ResponseEntity<List<EventDTO>> findAllBetweenDate(@RequestParam("start-date") LocalDate startDate, @RequestParam("end-date") LocalDate endDate){
    return ResponseEntity.ok(eventService.findAllBetweenDates(startDate, endDate));
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
