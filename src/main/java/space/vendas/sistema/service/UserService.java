package space.vendas.sistema.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import space.vendas.sistema.domain.Evento;
import space.vendas.sistema.domain.User;
import space.vendas.sistema.dto.event.EventDTO;
import space.vendas.sistema.dto.user.UserDTO;
import space.vendas.sistema.enums.UserType;
import space.vendas.sistema.repository.UserRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class UserService {

  private final UserRepository userRepository;

  public UserDTO save(UserDTO dto){
    return toDto(userRepository.save(toEntity(dto)));
  }

  public User findById(Long id){
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

  public List<UserDTO> findUsersByType(UserType type){
    return userRepository.findByType(type).stream().map(this::toDto).toList();
  }

  private User toEntity(UserDTO dto){
    User user = new User();
    BeanUtils.copyProperties(dto, user);
    return user;
  }

  private UserDTO toDto(User user){
    UserDTO dto = new UserDTO();
    BeanUtils.copyProperties(user, dto);
    return dto;
  }

  public UserDTO update(Long id, UserDTO dto){
    User user = toEntity(dto);
    user.setId(id);
    user.setPassword("");
    return toDto(userRepository.save(user));
  }

  public void destroy(Long id){
    userRepository.deleteById(id);
  }

}
