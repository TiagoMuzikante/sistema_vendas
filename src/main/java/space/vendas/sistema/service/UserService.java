package space.vendas.sistema.service;

import lombok.RequiredArgsConstructor;
import org.hibernate.sql.Update;
import org.springframework.stereotype.Service;
import space.vendas.sistema.domain.User;
import space.vendas.sistema.dto.user.UserPostDTO;
import space.vendas.sistema.repository.UserRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class UserService {

  private final UserRepository userRepository;

  public User save(UserPostDTO dto){
    User user = User.builder()
        .name(dto.getName())
        .email(dto.getEmail())
        .password(dto.getPassword())
        .phone_number(dto.getPhone_number())
        .document_cpf(dto.getDocument_cpf())
        .type(dto.getType())
        .birthday(dto.getBirthday())
        .build();
    return userRepository.save(user);
  }

  public User findById(UUID id){
    User user = userRepository.findById(id).orElseThrow(() -> new RuntimeException("Usuario não encontrado"));
    user.setPassword("");
    return user;
  }

  public List<User> findAll(){
    List<User> users = userRepository.findAll();
    users.stream()
        .peek(user -> user.setPassword(""))
        .peek(user -> user.setInscriptions(List.of()))
        .collect(Collectors.toList());
    return users;
  }

  public User update(UUID id, UserPostDTO dto){
    User user = User.builder()
        .id(id)
        .name(dto.getName())
        .email(dto.getEmail())
        .password(dto.getPassword())
        .phone_number(dto.getPhone_number())
        .document_cpf(dto.getDocument_cpf())
        .type(dto.getType())
        .birthday(dto.getBirthday())
        .updated_at(LocalDateTime.now())
        .build();
    User updated = userRepository.save(user);
    updated.setPassword("");
    return updated;
  }

  public void destroy(UUID id){
    userRepository.deleteById(id);
  }

}
