package space.vendas.sistema.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import space.vendas.sistema.domain.User;
import space.vendas.sistema.dto.user.UserDTO;
import space.vendas.sistema.enums.UserType;
import space.vendas.sistema.service.UserService;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/usuarios")
@RequiredArgsConstructor
public class UserController {

  private final UserService userService;

  @PostMapping
  public ResponseEntity<UserDTO> save(@RequestBody UserDTO userDTO){
    return new ResponseEntity<>(userService.save(userDTO), HttpStatus.CREATED);
  }

  @GetMapping("/{id}")
  public ResponseEntity<User> findById(@PathVariable Long id){
    return ResponseEntity.ok(userService.findById(id));
  }

  @GetMapping("/clientes")
  public ResponseEntity<List<UserDTO>> findClients(){
    return ResponseEntity.ok(userService.findUsersByType(UserType.NORMAL));
  }

  @GetMapping
  public ResponseEntity<List<User>> findAll(){
    return ResponseEntity.ok(userService.findAll());
  }

  @PutMapping("/{id}")
  public ResponseEntity<UserDTO> replace(@PathVariable Long id, @RequestBody UserDTO userDTO){
    return ResponseEntity.ok(userService.update(id, userDTO));
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<UserDTO> destroy(@PathVariable Long id){
    userService.destroy(id);
    return null;
  }

}
