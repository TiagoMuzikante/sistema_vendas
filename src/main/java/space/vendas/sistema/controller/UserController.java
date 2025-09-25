package space.vendas.sistema.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import space.vendas.sistema.domain.User;
import space.vendas.sistema.dto.user.UserDTO;
import space.vendas.sistema.service.UserService;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/usuarios")
@RequiredArgsConstructor
public class UserController {

  private final UserService userService;

  @PostMapping
  public ResponseEntity<User> save(@RequestBody UserDTO userPostDTO){
    return new ResponseEntity<>(userService.save(userPostDTO), HttpStatus.CREATED);
  }

  @GetMapping("/{id}")
  public ResponseEntity<User> findById(@PathVariable UUID id){
    return ResponseEntity.ok(userService.findById(id));
  }

  @GetMapping
  public ResponseEntity<List<User>> findAll(){
    return ResponseEntity.ok(userService.findAll());
  }

  @PutMapping("/{id}")
  public ResponseEntity<User> replace(@PathVariable UUID id, @RequestBody UserDTO userPostDTO){
    return ResponseEntity.ok(userService.update(id, userPostDTO));
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> destroy(@PathVariable UUID id){
    userService.destroy(id);
    return null;
  }

}
