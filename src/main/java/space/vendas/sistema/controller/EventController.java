package space.vendas.sistema.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import space.vendas.sistema.dto.event.EventPostDTO;

import java.util.List;

@RestController
@RequestMapping("api/v1/eventos")
@RequiredArgsConstructor
public class EventController {

  private final EventService eventService;

  @PostMapping
  public ResponseEntity<EventPostDTO> save(@RequestBody EventPostDTO eventPostDTO){
    return new ResponseEntity<>(eventService.save(eventPostDTO), HttpStatus.CREATED);
  }

  @GetMapping("/{id}")
  public ResponseEntity<EventPostDTO> findById(@PathVariable Long id){
    return ResponseEntity.ok(eventService.findById(id));
  }

  @GetMapping
  public ResponseEntity<List<EventPostDTO>> findAll(){
    return ResponseEntity.ok(eventService.findAll());
  }

  @PutMapping("/{id}")
  public ResponseEntity<EventPostDTO> replace(@PathVariable Long id, @ResponseBody EventPostDTO eventPostDTO){
    return ResponseEntity.ok(eventService.replace(id,eventPostDTO));
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> destroy(@PathVariable Long id){
    eventService.destroy(id);
  }


}
