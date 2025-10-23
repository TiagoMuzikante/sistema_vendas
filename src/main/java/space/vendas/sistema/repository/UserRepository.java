package space.vendas.sistema.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import space.vendas.sistema.domain.User;
import space.vendas.sistema.enums.UserType;
import space.vendas.sistema.service.UserService;

import java.util.List;
import java.util.UUID;


public interface UserRepository extends JpaRepository<User, Long> {

  List<User> findByType(UserType type);

  User findUserByEmail(String email);
}
