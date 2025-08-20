package space.vendas.sistema.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import space.vendas.sistema.dto.user.UserPostDTO;

import java.util.List;

@RequestMapping("/api/v1/users")
@RestController
@RequiredArgsConstructor
public class UserController {

  private final UserService userService;

  @PostMapping
  public ResponseEntity<UserPostDTO> save(@ResponseBody UserPostDTO userPostDTO){
    return new ResponseEntity<>(userService.save(userPostDTO), HttpStatus.CREATED);
  }

  @GetMapping("/{id}")
  public ResponseEntity<UserPostDTO> findById(@PathVariable Long id){
    return ResponseEntity.ok(userService.findById(id));
  }

  @GetMapping
  public ResponseEntity<List<UserPostDTO>> findAll(){
    return ResponseEntity.ok(userService.findAll());
  }

  @PutMapping("/{id}")
  public ResponseEntity<UserPostDTO> replace(@PathVariable Long id, @RequestBody UserPostDTO userPostDTO){
    return ResponseEntity.ok(userService.replace(id, userPostDTO));
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> destroy(@PathVariable Long id){
    userService.destroy(id);
  }

}
